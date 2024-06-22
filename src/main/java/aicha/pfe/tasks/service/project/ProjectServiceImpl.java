package aicha.pfe.tasks.service.project;

import aicha.pfe.tasks.entity.Project;
import aicha.pfe.tasks.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectServiceImpl implements IProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> retrieve() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project add(Project p) {
        projectRepository.save(p);
        return p;
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project update(Project p) {
        projectRepository.save(p);
        return p;
    }

    @Override
    public Project findProjectByName(String name) {
        return projectRepository.findProjectByName(name);
    }



}
