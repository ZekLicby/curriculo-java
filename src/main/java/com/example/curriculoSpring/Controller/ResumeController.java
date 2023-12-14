package com.example.curriculoSpring.Controller;

import com.example.curriculoSpring.Model.Resume;
import com.example.curriculoSpring.Service.ResumeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/resume")
@Validated
public class ResumeController {

    private final ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        return resumeService.getResumeById(id)
                .map(resume -> new ResponseEntity<>(resume, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Resume> createResume(@Valid @RequestBody Resume resume) {
        Resume createdResume = resumeService.createResume(resume);
        return new ResponseEntity<>(createdResume, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @Valid @RequestBody Resume updatedResume) {
        return resumeService.updateResume(id, updatedResume)
                .map(updated -> new ResponseEntity<>(updated, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
