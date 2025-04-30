package AdvancedInternshipManagementSystem;
import java.time.LocalDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class RemoteInternship extends Internship {

    public RemoteInternship(String internshipId, Student student, Company company, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        super(internshipId, student, company, supervisor, startDate, endDate);
    }

    @Override
    public void assignSupervisor() {
        System.out.println("Assigning supervisor for Remote Internship...");
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking remote access and progress logs...");
    }

    @Override
    public void generateReport() {
        System.out.println("Remote Internship Report for " + student.getFullName());
    }

    @Override
    public void validateInternship() {
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
        if (ChronoUnit.WEEKS.between(startDate, endDate) < 6) {
            throw new IllegalArgumentException("Internship must last at least 6 weeks.");
        }
    }
}

