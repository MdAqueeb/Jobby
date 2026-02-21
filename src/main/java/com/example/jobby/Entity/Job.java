
package com.example.jobby.Entity;

import jakarta.persistence.Entity;

@Entity
public class Job {
    private Long job_id;

    private String employment_type;
    private String job_description;
    private String location;
    private Integer package_per_annum;
    private Integer rating;
    private String job_title;
    // skills relation
    // life_at_company 

}



// {
//   "job_details": {
//     "skills": [
//       {
//         "image_url": "https://assets.ccbp.in/frontend/react-js/jobby-app/docker-img.png",
//         "name": "Docker"
//       },
//       ...
//     ],
//     "life_at_company": {
//       "description": "Our core philosophy is people over process. Our culture has been instrumental to our success. It has helped us attract and retain stunning colleagues, making work here more satisfying. Entertainment, like friendship, is a fundamental human need, and it changes how we feel and gives us common ground. We want to entertain the world.",
//       "image_url": "https://assets.ccbp.in/frontend/react-js/jobby-app/life-netflix-img.png"
//     },
//     
//   },
//   "similar_jobs": [
//     {
//     },
//     ...
//   ]
// }

// {
//   "jobs": [
//     {
//       
//     }
//     ...
//   ],
//   "total":25,
// }