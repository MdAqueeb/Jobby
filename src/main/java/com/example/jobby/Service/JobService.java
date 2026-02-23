package com.example.jobby.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobby.DTO.JobFilter;
import com.example.jobby.Entity.Job;
import com.example.jobby.Exceptions.NotFoundException;
import com.example.jobby.Repository.JobRepo;
import com.example.jobby.Specifications.JobSpecification;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<Job> findAllJobs(JobFilter filter) {
        return jobRepo.findAll(JobSpecification.filterJobs(filter));
    }

    public Job getJobDetails(Long jobId) {
        Optional<Job> job = jobRepo.findById(jobId);
        if(!job.isPresent()){
            throw new NotFoundException("Job Not Found");
        }
        return job.get();
    }   

    public List<Job> getSimilarJobs(Long jobId) {
        return jobRepo.findSimilarJobs(jobId);
    }

    
}
