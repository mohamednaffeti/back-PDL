package aicha.pfe.tasks.controller;

import aicha.pfe.tasks.entity.Project;
import aicha.pfe.tasks.repository.ProjectRepository;
import aicha.pfe.tasks.service.project.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProjectRestController {
    private final IProjectService projectService;
    private final ProjectRepository repoProject;

    @Autowired
    public ProjectRestController(IProjectService projectService, ProjectRepository repoProject) {
        this.projectService = projectService;
        this.repoProject = repoProject;
    }

    @GetMapping("/retrieve-all-projects")
    @ResponseBody
    public List<Project> getProjects() {
        return projectService.retrieve();
    }

    @GetMapping("/retrieve-project/{project-name}")
    @ResponseBody
    public Project findProjectByName(@PathVariable("project-name") String projectName) {
        return projectService.findProjectByName(projectName);
    }

    @GetMapping("/get-project-by-team/{team-id}")
    @ResponseBody
    public Project getProjetByTeam(@PathVariable("team-id") Long id) {
        return repoProject.getProjectByTeam(id);
    }

    @PostMapping("/add-project")
    @ResponseBody
    public Project addProject(@RequestBody Project p) {

        return projectService.add(p);
    }

    @DeleteMapping("/remove-project/{project-id}")
    @ResponseBody
    public void removeProject(@PathVariable("project-id") Long projectId) {
        projectService.delete(projectId);
    }

    @PutMapping("/modify-project")
    @ResponseBody
    public Project modifyProject(@RequestBody Project project) {
        return projectService.update(project);
    }
}
