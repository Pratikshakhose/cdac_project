package com.iacsd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.dtos.ProjectDTO;
import com.iacsd.dtos.Response;
import com.iacsd.dtos.TaskDTO;
import com.iacsd.entities.Project;
import com.iacsd.entities.Task;
import com.iacsd.services.ProjectServiceImpl;
import com.iacsd.services.TaskServiceImpl;

@CrossOrigin
@RestController
public class TaskController {

	@Autowired
	private ProjectServiceImpl projectService;

	@Autowired
	private TaskServiceImpl taskService;

	@PostMapping("/manager/addTask")
	public ResponseEntity<?> addTask(@RequestBody TaskDTO taskDTO) {
		//System.out.println("Creating: " + taskDTO);
		//System.out.println("Desc : " + taskDTO.getDescription());
		Task task = new Task();
		
		Project project = projectService.getProject(taskDTO.getProjectId());
		task.setProject(project);
		System.out.println(project);
		System.out.println(task);
		taskService.addTask(task, taskDTO);
		return Response.success(task);
	}
}
