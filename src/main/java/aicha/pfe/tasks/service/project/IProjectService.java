package aicha.pfe.tasks.service.project;

import aicha.pfe.tasks.entity.Project;
import aicha.pfe.tasks.service.IService;

public interface IProjectService extends IService<Project> {
    Project findProjectByName(String name);
}
