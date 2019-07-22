package com.donghn.portfolio.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donghn.portfolio.exception.ResourceNotFoundException;
import com.donghn.portfolio.model.Project;
import com.donghn.portfolio.repository.ProjectRepository;
@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") Long projectId)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
        return ResponseEntity.ok().body(project);
    }

    @PostMapping("/projects")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long projectId,
                                                   @Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        project.setTitle(projectDetails.getTitle());
        project.setCover(projectDetails.getCover());
        project.setIntro(projectDetails.getIntro());
        final Project updatedProject = projectRepository.save(project);
        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/projects/{id}")
    public Map<String, Boolean> deleteProject(@PathVariable(value = "id") Long projectId)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        projectRepository.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
