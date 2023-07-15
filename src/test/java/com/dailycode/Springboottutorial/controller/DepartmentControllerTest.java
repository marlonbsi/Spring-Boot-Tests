package com.dailycode.Springboottutorial.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dailycode.Springboottutorial.entity.Department;
import com.dailycode.Springboottutorial.error.DepartmentNotFoundException;
import com.dailycode.Springboottutorial.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	
	private Department department;
	
	@BeforeEach
	void setUp() {
		department = Department.builder()
				.departmentName("it")
				.departmentAddress("Birkirkara, Malta")
				.departmentCode("IT09")
				.departmentId(1L)
				.build();
	}

	@Test
	void testSaveDepartment() throws Exception {
		Department inputDepartment = Department.builder()
				.departmentName("it")
				.departmentAddress("Birkirkara, Malta")
				.departmentCode("IT09")
				.build();
		Mockito.when(departmentService.saveDepartment(inputDepartment))
			.thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n"
						+ "    \"departmentName\":\"it\",\n"
						+ "    \"departmentAddress\":\"Birkirkara, Malta\",\n"
						+ "    \"departmentCode\":\"IT09\"\n"
						+ "}"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testDeleteDepartmentById() throws Exception {
		Mockito.when(departmentService.fetchDepartmentById(1L))
			.thenReturn(department);
		mockMvc.perform(get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.departmentName")
						.value(department.getDepartmentName()));
	}

}
