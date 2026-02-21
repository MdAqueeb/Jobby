package com.example.jobby.Entity;

import jakarta.persistence.Entity;

@Entity
public class Company {
    private Long company_id;
    private String company_logo_url;
    private String company_website_url;
}
// "life_at_company": {
//       "description": "Our core philosophy is people over process. Our culture has been instrumental to our success. It has helped us attract and retain stunning colleagues, making work here more satisfying. Entertainment, like friendship, is a fundamental human need, and it changes how we feel and gives us common ground. We want to entertain the world.",
//       "image_url": "https://assets.ccbp.in/frontend/react-js/jobby-app/life-netflix-img.png"
//     },