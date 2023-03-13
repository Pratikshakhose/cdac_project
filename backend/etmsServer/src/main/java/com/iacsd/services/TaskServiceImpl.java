package com.iacsd.services;

import java.util.Collections;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iacsd.daos.TaskDao;
import com.iacsd.dtos.DtoEntityConverter;
import com.iacsd.dtos.TaskDTO;
import com.iacsd.entities.Task;

@Transactional
@Service
public class TaskServiceImpl {

	@Autowired
	private TaskDao taskDao;

	@Autowired
	private DtoEntityConverter converter;

	public Map<String, Object> addTask(Task task, TaskDTO taskDto) {
		task = converter.toTaskEntity(task, taskDto);
		System.out.println(task);
		task = taskDao.save(task);
		return Collections.singletonMap("insertedId", task.gettaskId());
	}
}
