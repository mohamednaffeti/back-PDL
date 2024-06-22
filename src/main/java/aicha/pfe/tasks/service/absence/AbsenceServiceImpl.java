package aicha.pfe.tasks.service.absence;


import aicha.pfe.tasks.entity.Absence;
import aicha.pfe.tasks.repository.AbsenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class AbsenceServiceImpl implements IAbsenceService {

    private final AbsenceRepository absenceRepository;



    @Autowired
    public AbsenceServiceImpl(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

   @Override
    public List<Absence> retrieve() {
        return (List<Absence>) absenceRepository.findAll();
    }

    @Override
    public Absence add(Absence absence) {
        absenceRepository.save(absence);
        return absence;
    }

    @Override
    public void delete(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public Absence update(Absence absence) {
        absenceRepository.save(absence);
        return absence;
    }



}
