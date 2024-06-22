package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Designation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/designation")
@CrossOrigin(origins = "*")
public class DesignationRestController {


    @GetMapping("/retrieve-all-designations")
    @ResponseBody
    public Designation[] getDesignations() {
        return Designation.values();
    }
}




