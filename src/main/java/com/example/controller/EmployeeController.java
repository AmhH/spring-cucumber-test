package com.example.controller;

import com.example.model.EmployeeResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

public class EmployeeController {

    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass().getName());
    private final RestTemplate restTemplate = new RestTemplate();



    @RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
    public EmployeeResponse allEmployeesMethod() {
        LOGGER.info("Enter into the Controller");
        EmployeeResponse employeeResponse = new EmployeeResponse();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = null;
        String response = null;

        try {
            LOGGER.info("Enter into try");
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            response = responseEntity.getBody();
            ObjectMapper mapper = new ObjectMapper();
            employeeResponse = mapper.readValue(response, EmployeeResponse.class);
            LOGGER.info("Get the response {}", employeeResponse);
        } catch (Exception e) {
            System.out.println("#######" + e.getMessage());
        }

        return employeeResponse;
    }
}
