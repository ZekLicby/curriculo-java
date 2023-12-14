package com.example.curriculoSpring.Repository;

import com.example.curriculoSpring.Model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ResumeRepository extends JpaRepository<Resume, Long> {

}
