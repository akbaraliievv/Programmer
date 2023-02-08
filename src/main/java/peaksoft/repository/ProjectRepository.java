package peaksoft.repository;

import peaksoft.entity.Project;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface ProjectRepository {
    void saveProject(Project project);
    List<Project>saveAll(List<Project> project);
    List<Project>findAll();
    Project findById(Long projectId);
    Project deletedById(Long projectId);
    List<Project>deletedAll();
    String updated(Project project,Long projectId);
    Project addProgrammerToProject(Project project, Long ProgrammerId);
    Project expensiveProject(BigDecimal price);
    void shortTimeProject();
}
