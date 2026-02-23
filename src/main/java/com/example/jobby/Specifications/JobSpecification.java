package com.example.jobby.Specifications;


import org.springframework.data.jpa.domain.Specification;

import com.example.jobby.DTO.JobFilter;
import com.example.jobby.Entity.Job;

import jakarta.persistence.criteria.*;
import java.util.*;
public class JobSpecification {

    public static Specification<Job> filterJobs(JobFilter filter) {
        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if (filter.getEmployeType() != null && !filter.getEmployeType().isEmpty()) {
                CriteriaBuilder.In<Object> inClause = cb.in(root.get("employment_type"));
                for (String type : filter.getEmployeType()) {
                    inClause.value(Job.Employment_Type.valueOf(type));
                }
                predicates.add(inClause);
            }

            if (filter.getSearch() != null && !filter.getSearch().trim().isEmpty()) {
                String pattern = "%" + filter.getSearch().toLowerCase() + "%";
                predicates.add(
                    cb.like(cb.lower(root.get("job_title")), pattern)
                );
            }

            if (filter.getMin_salary() != null && filter.getMin_salary() > 0) {
                predicates.add(
                    cb.greaterThanOrEqualTo(root.get("package_per_annum"), filter.getMin_salary())
                );
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}