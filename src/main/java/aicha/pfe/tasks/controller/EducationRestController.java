package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Education;
import aicha.pfe.tasks.service.education.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
@CrossOrigin(origins = "*")
public class EducationRestController {

    private final IEducationService educationService;

    @Autowired
    public EducationRestController(IEducationService educationService) {
        this.educationService = educationService;
    }


    @GetMapping("/retrieve-all-educations")
    @ResponseBody
    public List<Education> getEducations() {
        return educationService.retrieve();
    }

    @PostMapping("/add-education")
    @ResponseBody
    public Education addEducation(@RequestBody Education education) {
        return educationService.add(education);
    }

    @DeleteMapping("/remove-education/{education-id}")
    @ResponseBody
    public void removeEducation(@PathVariable("education-id") Long educationId) {
        educationService.delete(educationId);
    }

    @PutMapping("/modify-education")
    @ResponseBody
    public Education modifyEducation(@RequestBody Education education) {
        return educationService.update(education);
    }
}


