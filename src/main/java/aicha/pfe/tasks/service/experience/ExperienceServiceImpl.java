package aicha.pfe.tasks.service.experience;

import aicha.pfe.tasks.repository.ExperienceRepository;
import aicha.pfe.tasks.entity.Experience;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExperienceServiceImpl implements IExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> retrieve() {
        return (List<Experience>) experienceRepository.findAll();
    }

    @Override
    public Experience add(Experience experience) {
        experienceRepository.save(experience);
        return experience;
    }

    @Override
    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }

    @Override
    public Experience update(Experience experience) {
        experienceRepository.save(experience);
        return experience;
    }

}
