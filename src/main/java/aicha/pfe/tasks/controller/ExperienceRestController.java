package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Experience;
import aicha.pfe.tasks.service.experience.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "*")
public class ExperienceRestController {

    private final IExperienceService experienceService;

    @Autowired
    public ExperienceRestController(IExperienceService experienceService) {
        this.experienceService = experienceService;
    }


    @GetMapping("/retrieve-all-experiences")
    @ResponseBody
    public List<Experience> getExperiences() {
        return experienceService.retrieve();
    }

    @PostMapping("/add-experience")
    @ResponseBody
    public Experience addExperience(@RequestBody Experience experience) {
        return experienceService.add(experience);
    }

    @DeleteMapping("/remove-experience/{experience-id}")
    @ResponseBody
    public void removeExperience(@PathVariable("experience-id") Long experienceId) {
        experienceService.delete(experienceId);
    }

    @PutMapping("/modify-experience")
    @ResponseBody
    public Experience modifyExperience(@RequestBody Experience experience) {
        return experienceService.update(experience);
    }
}


