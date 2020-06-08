package com.example.model;

import java.util.List;

public class EmployeeResponse {

    private String status;
    private List<EmployeeInfo> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EmployeeInfo> getData() {
        return data;
    }

    public void setData(List<EmployeeInfo> data) {
        this.data = data;
    }
}
