package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Team;
import aicha.pfe.tasks.entity.User;
import aicha.pfe.tasks.repository.UserRepository;

import aicha.pfe.tasks.service.team.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/team")
public class TeamRestController {

    private final ITeamService teamService;
    private final UserRepository userRepository;



    @Autowired
    public TeamRestController(ITeamService teamService, UserRepository userRepository) {
        this.teamService = teamService;
        this.userRepository = userRepository;
    }


    @GetMapping("/retrieve-all-teams")
    @ResponseBody
    public List<Team> getTeams() {
        return teamService.retrieve();
    }



    @PostMapping("/add-team")
    @ResponseBody
    public Team addTeam(@RequestBody Team team) {
        System.out.println(team.getUsers());
        Set<User> users = new HashSet<>();
        for (User u : team.getUsers()) {
            User user = userRepository.findById(u.getId()).orElseThrow(() -> new EntityNotFoundException("user does not exist"));
            user.setTeam(team);
            users.add(user);
        }
        System.out.println(users);
        team.getUsers().clear();
        team.getUsers().addAll(users);
        return teamService.add(team);

    }

    @DeleteMapping("/remove-team/{team-id}")
    @ResponseBody
    public void removeTeam(@PathVariable("team-id") Long teamId) {
        teamService.delete(teamId);
    }

    @PutMapping("/modify-team")
    @ResponseBody
    public Team modifyTeam(@RequestBody Team team) {
        return teamService.update(team);
    }


}


