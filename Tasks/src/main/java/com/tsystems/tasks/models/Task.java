/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tsystems.tasks.models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author aalonsoa
 */
public class Task implements Serializable {
    int id;
    String name;
    TaskState tState;

    public Task(int id, String name, TaskState tState) {
        this.id = id;
        this.name = name;
        this.tState = tState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskState getState() {
        return tState;
    }

    public void setState(TaskState tState) {
        this.tState = tState;
    }

    @Override
    public int hashCode() {
        String hashTest = String.valueOf(this.id) + "/" + String.valueOf(this.name);      
        return hashTest.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Task other = (Task) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return this.tState == other.tState;
    }
    
    
    
    
}
