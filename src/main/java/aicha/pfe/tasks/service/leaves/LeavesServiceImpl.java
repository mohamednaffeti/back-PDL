package aicha.pfe.tasks.service.leaves;

import aicha.pfe.tasks.entity.Leaves;
import aicha.pfe.tasks.repository.LeavesRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LeavesServiceImpl implements ILeavesService {

    private final LeavesRepository leavesRepository;

    @Autowired
    public LeavesServiceImpl(LeavesRepository leavesRepository) {
        this.leavesRepository = leavesRepository;
    }

    @Override
    public List<Leaves> retrieve() {
        return (List<Leaves>) leavesRepository.findAll();
    }

    @Override
    public Leaves add(Leaves leaves) {
        leavesRepository.save(leaves);
        return leaves;
    }

    @Override
    public void delete(Long id) {
        leavesRepository.deleteById(id);
    }

    @Override
    public Leaves update(Leaves leaves) {
        leavesRepository.save(leaves);
        return leaves;
    }

}
