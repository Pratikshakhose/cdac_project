package com.iacsd.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iacsd.daos.DepartmentDao;
import com.iacsd.entities.Department;


@Transactional
@Service
public class DepartmentServiceImpl {

	@Autowired
	private DepartmentDao deptDao;

	public Department getDepartment(int deptId) {
		Department dept = deptDao.findByDeptId(deptId);
		return dept;
	}
}
