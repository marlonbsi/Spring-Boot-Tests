package com.dailycode.Springboottutorial.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.dailycode.Springboottutorial.entity.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;

	@BeforeEach
	void setUp() {
		Department department = Department.builder()
				.departmentName("Mechanical")
				.departmentCode("MEC-10")
				.departmentAddress("San Gwann, Malta")
				.build();
		entityManager.persist(department);
	}
	
	@Test
	public void whenFindById_thenReturnDepartment() {
		Department department = departmentRepository.findById(1L).get();
		assertEquals(department.getDepartmentName(), "Mechanical");
	}

}
