package com.techelevator;

public class Department {
    private int departmentsId;
    private String name;

    public Department(int departmentsId, String name) {
        this.departmentsId = departmentsId;
        this.name = name;
    }

    public int getDepartmentsId() {
        return departmentsId;
    }

    public void setDepartmentsId(int departmentsId) {
        this.departmentsId = departmentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
