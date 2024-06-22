package aicha.pfe.tasks.controller;


import aicha.pfe.tasks.entity.Absence;
import aicha.pfe.tasks.repository.AbsenceRepository;
import aicha.pfe.tasks.entity.Cause;
import aicha.pfe.tasks.service.absence.IAbsenceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absence")
@CrossOrigin(origins = "*")
public class AbsenceRestController {

    private final IAbsenceService absenceService;


    public AbsenceRestController(IAbsenceService absenceService, AbsenceRepository absenceRepository) {
        this.absenceService = absenceService;
    }





    @GetMapping("/retrieve-all-absence")
    @ResponseBody
    public List<Absence> getClients() {
        return absenceService.retrieve();
    }


    @PostMapping("/add-absence")
    @ResponseBody
    public Absence addClient(@RequestBody Absence a) {
        return absenceService.add(a);
    }




    @DeleteMapping("/remove-absence/{absence-id}")
    @ResponseBody
    public void removeAbsence(@PathVariable("absence-id") Long clientId) {
        absenceService.delete(clientId);
    }

    @PutMapping("/modify-absence")
    @ResponseBody
    public Absence modifyClient(@RequestBody Absence absence) {
        return absenceService.update(absence);
    }


    @GetMapping("/retrieve-all-enumabssence")
    @ResponseBody
    public Cause[] getAbsence() {
        return Cause.values();
    }
}
