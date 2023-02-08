package peaksoft.service;

import peaksoft.entity.Project;
import peaksoft.repository.ProjectRepository;
import peaksoft.repository.ProjectRepositoryImpl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    ProjectRepository repository = new ProjectRepositoryImpl();
    @Override
    public void saveProject(Project project) {
        repository.saveProject(project);
    }

    @Override
    public List<Project> saveAll(List<Project> project) {
        return repository.saveAll(project);
    }

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project findById(Long projectId) {
        return repository.findById(projectId);
    }

    @Override
    public Project deletedById(Long projectId) {
        return repository.deletedById(projectId);
    }

    @Override
    public List<Project> deletedAll() {
        return repository.deletedAll();
    }

    @Override
    public String updated(Project project, Long projectId) {
        return repository.updated(project,projectId);
    }

    @Override
    public Project addProgrammerToProject(Project project, Long ProgrammerId) {
        return null;
    }

    @Override
    public Project expensiveProject(BigDecimal price) {
        return null;
    }

    @Override
    public Project shortTimeProject(Date dateOfFinish) {
        return null;
    }
}
