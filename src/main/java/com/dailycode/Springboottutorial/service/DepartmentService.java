package com.dailycode.Springboottutorial.service;

import java.util.List;

import com.dailycode.Springboottutorial.entity.Department;
import com.dailycode.Springboottutorial.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);
	public List<Department> fetchDepartmentList();
	public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;
	public void deleteDepartmentById(Long departmentId);
	public Department updateDepartment(Long departmentId, Department department);
	public Department fetchDepartmentByName(String departmentName);

}
