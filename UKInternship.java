package AdvancedInternshipManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UKInternship extends Internship {

    public UKInternship(String internshipId, Student student, Company company, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        super(internshipId, student, company, supervisor, startDate, endDate);
    }

    @Override
    public void assignSupervisor() {
        System.out.println("Assigning two supervisors (Company and University) for UK Internship...");
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking UK Internship progress...");
    }

    @Override
    public void generateReport() {
        System.out.println("UK Internship Report for " + student.getFullName());
    }

    @Override
    public void validateInternship() {
        if (!student.getUniversity().equalsIgnoreCase("UK")) {
            throw new IllegalArgumentException("Student must be from UK.");
        }
        if (ChronoUnit.WEEKS.between(startDate, endDate) < 6) {
            throw new IllegalArgumentException("Internship must be at least 6 weeks.");
        }
    }
}

