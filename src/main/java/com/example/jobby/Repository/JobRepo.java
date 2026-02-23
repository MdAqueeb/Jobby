package com.example.jobby.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.jobby.Entity.Job;

public interface JobRepo extends JpaRepository<Job, Long>, JpaSpecificationExecutor<Job> {
    
    @Query(value = """
        SELECT DISTINCT j.* 
        FROM job j
        JOIN skills s ON j.job_id = s.job_id
        WHERE s.name IN (
            SELECT s2.name 
            FROM skills s2 
            WHERE s2.job_id = :jobId
        )
        AND j.job_id != :jobId
        LIMIT 5
        """, nativeQuery = true)
    List<Job> findSimilarJobs(@Param("jobId") Long jobId);

}
