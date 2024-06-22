package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.LeaveType;
import aicha.pfe.tasks.entity.Leaves;
import aicha.pfe.tasks.repository.UserRepository;
import aicha.pfe.tasks.service.leaves.ILeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/leave")
public class LeaveRestController {

    private final ILeavesService leavesService;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    public LeaveRestController(ILeavesService leavesService) {
        this.leavesService = leavesService;
    }

    @GetMapping("/retrieve-all-leavesType")
    @ResponseBody
    public LeaveType[] getDesignations() {
        return LeaveType.values();
    }
    @GetMapping("/retrieve-all-leaves")
    @ResponseBody
    public List<Leaves> getLeaves() {
        return leavesService.retrieve();
    }

    @PostMapping("/add-leave")
    @ResponseBody
    public Leaves addLeave(@RequestBody Leaves leave) {

        return leavesService.add(leave);
    }

    @DeleteMapping("/remove-leave/{leave-id}")
    @ResponseBody
    public void removeLeave(@PathVariable("leave-id") Long leaveId) {
        leavesService.delete(leaveId);
    }

    @PutMapping("/modify-leave")
    @ResponseBody
    public Leaves modifyLeave(@RequestBody Leaves leave) {

        return leavesService.add(leave);
    }
}


