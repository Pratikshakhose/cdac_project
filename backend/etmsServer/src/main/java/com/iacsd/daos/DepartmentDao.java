package com.iacsd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iacsd.entities.Department;

public interface DepartmentDao extends JpaRepository<Department	, Integer>{
	
	Department findByDeptId(int deptId);
}
