package com.dailycode.Springboottutorial.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dailycode.Springboottutorial.entity.Department;
import com.dailycode.Springboottutorial.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.departmentName("it")
				.departmentAddress("Berlin, Germany")
				.departmentCode("AB-18")
				.departmentId(1L)
				.build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("it"))
			.thenReturn(department);
	}
	
	@Test
	@DisplayName("Get data based on department name")
	public void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "it";
		Department found = departmentService.fetchDepartmentByName(departmentName);
		assertThat(hasItem(found.getDepartmentName()));
	}

}
