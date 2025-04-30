package AdvancedInternshipManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class URInternship extends Internship {

    public URInternship(String internshipId, Student student, Company company, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        super(internshipId, student, company, supervisor, startDate, endDate);
    }

    @Override
    public void assignSupervisor() {
        System.out.println("Assigning supervisor for UR Internship...");
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking UR Internship Progress...");
    }

    @Override
    public void generateReport() {
        System.out.println("UR Internship Report for " + student.getFullName());
    }

    @Override
    public void validateInternship() {
        if (!student.getUniversity().equalsIgnoreCase("UR")) {
            throw new IllegalArgumentException("Student must be from UR.");
        }
        long months = ChronoUnit.MONTHS.between(startDate, endDate);
        if (months < 2 || months > 6) {
            throw new IllegalArgumentException("Internship duration must be between 2 and 6 months.");
        }
    }
}


