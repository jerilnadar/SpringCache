package com.example.springcache.service;

import java.util.Date;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.springcache.domain.Student;

@Service
public class StudentService {
	@Cacheable("student")
	public Student getStudentByID(String id) {
		try {
			Thread.sleep(1000 * 5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Returning now :: " + new Date());
		return new Student(id, "Jeril", "ComputerScience");

	}

	@CacheEvict(value = "student", allEntries = true)
	@Scheduled(fixedRate = 36000, initialDelay = 36000)
	public void cacheEvict() {
		System.out.println("Clearing now :: "+new Date());
	}
}
