package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Role;
import aicha.pfe.tasks.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "*")
public class RoleRestController {

    private final IRoleService roleService;

    @Autowired
    public RoleRestController(IRoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/retrieve-all-roles")
    @ResponseBody
    public List<Role> getRoles() {
        return roleService.retrieve();
    }

    @PostMapping("/add-role")
    @ResponseBody
    public Role addRole(@RequestBody Role role) {
        return roleService.add(role);
    }

    @DeleteMapping("/remove-role/{role-id}")
    @ResponseBody
    public void removeRole(@PathVariable("role-id") Long roleId) {
        roleService.delete(roleId);
    }

    @PutMapping("/modify-role")
    @ResponseBody
    public Role modifyRole(@RequestBody Role role) {
        return roleService.update(role);
    }
}


