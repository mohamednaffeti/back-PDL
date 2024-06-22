package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Department;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "*")
public class DepartmentRestController {


    @GetMapping("/retrieve-all-departments")
    @ResponseBody
    public Department[] getDepartments() {
        return Department.values();
    }
}




