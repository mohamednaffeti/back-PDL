package aicha.pfe.tasks.service.team;

import aicha.pfe.tasks.entity.Team;
import aicha.pfe.tasks.repository.TeamRepository;
import aicha.pfe.tasks.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TeamServiceImpl implements ITeamService {
    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, UserRepository userRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> retrieve() {
        return (List<Team>) teamRepository.findAll();
    }




    @Override
    public Team add(Team team) {
        teamRepository.save(team);
        return team;
    }

    @Override
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    @Override
    public Team update(Team team) {
        teamRepository.save(team);
        return team;
    }

}
