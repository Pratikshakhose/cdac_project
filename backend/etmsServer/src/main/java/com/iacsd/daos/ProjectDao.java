package com.iacsd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iacsd.entities.Project;
import com.iacsd.entities.Task;

public interface ProjectDao extends JpaRepository<Project, Integer>{
	
	Project findByProjectId(int projectId);
	List<Project> findAll();
	
	@Query("from Project p where p.department.deptId = :deptId ORDER BY p.status DESC")
	List<Project> sortedProjects(@Param("deptId") int deptId);
}
