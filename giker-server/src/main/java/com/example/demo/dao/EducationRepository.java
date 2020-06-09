package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Education;

public interface EducationRepository  extends JpaRepository<Education, String>{

}
