package aicha.pfe.tasks.service.education;

import aicha.pfe.tasks.repository.EducationRepository;
import aicha.pfe.tasks.entity.Education;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EducationServiceImpl implements IEducationService {

    private final EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public List<Education> retrieve() {
        return (List<Education>) educationRepository.findAll();
    }

    @Override
    public Education add(Education education) {
        educationRepository.save(education);
        return education;
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }

    @Override
    public Education update(Education education) {
        educationRepository.save(education);
        return education;
    }

}
