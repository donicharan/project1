package com.project1.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project1.demo.entities.Project;
import com.project1.demo.services.ProjectService;

@RestController
public class ControllerP {
	
	
	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping("/projects")
	public List<Project>  getprojects()
	{
		return this.projectService.getprojects();
	}
	@GetMapping("/projects/{projectproject_id}")
	public Optional<Project> getProject(@PathVariable String projectproject_id) {
	    return projectService.getProject(projectproject_id);
	}
	
	
	@PostMapping("/projects")
	public Project addProject(@RequestBody Project project) 
	{
		return this.projectService.addProject(project);
	}
	 
	@PutMapping("/projects")
	public Project updateProject(@RequestBody Project project)
	{
		return this.projectService.updateProject(project);
	}
	@DeleteMapping("/projects/{projectproject_id}")
	public ResponseEntity<HttpStatus> deleteProject(@PathVariable String projectproject_id){
		try {
			this.projectService.deleteProject(String.valueOf(projectproject_id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			 
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	}
