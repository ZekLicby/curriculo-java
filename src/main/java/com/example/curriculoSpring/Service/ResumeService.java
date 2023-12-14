package com.example.curriculoSpring.Service;

import com.example.curriculoSpring.Model.Resume;
import com.example.curriculoSpring.Repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Autowired
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public Optional<Resume> getResumeById(Long id) {
        return resumeRepository.findById(id);
    }

    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

    public Optional<Resume> updateResume(Long id, Resume updatedResume) {
        Optional<Resume> existingResume = resumeRepository.findById(id);

        if (existingResume.isPresent()) {
            updatedResume.setId(id);
            return Optional.of(resumeRepository.save(updatedResume));
        } else {
            return Optional.empty();
        }
    }

    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }
}
