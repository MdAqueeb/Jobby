package com.example.jobby.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jobby.DTO.ApiResponse;
import com.example.jobby.DTO.JobFilter;
import com.example.jobby.Entity.Job;
import com.example.jobby.Service.JobService;

@RestController
public class JobController {
    
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<ApiResponse<List<Job>>> getAllJobs(
        @RequestParam(required = false) List<String> employeType,
        @RequestParam(required = false, defaultValue = "") String search,
        @RequestParam(required = false, defaultValue = "0") Integer min_salary){

        JobFilter filter = new JobFilter();
        filter.setEmployeType(employeType);
        filter.setMin_salary(min_salary);
        filter.setSearch(search);
        List<Job> jobs = jobService.findAllJobs(filter);
        ApiResponse<List<Job>> response = new ApiResponse<>();
        response.setData(jobs);
        response.setMessage("Jobs Fetch Successfully");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/job/{jobId}")
    public ResponseEntity<ApiResponse<Job>> getJob(@PathVariable Long jobId){
        Job job = jobService.getJobDetails(jobId);
        ApiResponse<Job> response = new ApiResponse<>();
        response.setData(job);
        response.setMessage("Job Fetch successfull");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/jobs/{jobId}/similar")
    public ResponseEntity<ApiResponse<List<Job>>> getSimilarJobs(@PathVariable Long jobId) {
        List<Job> similarJobs = jobService.getSimilarJobs(jobId);
        ApiResponse<List<Job>> response = new ApiResponse<>();
        response.setData(similarJobs);
        response.setMessage("Similar Jobs fetch successfull");
        response.setSuccess(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
