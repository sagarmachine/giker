package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, String> {

}
