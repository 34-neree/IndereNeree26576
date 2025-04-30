package AdvancedInternshipManagementSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ULKInternship extends Internship {

    public ULKInternship(String internshipId, Student student, Company company, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        super(internshipId, student, company, supervisor, startDate, endDate);
    }

    @Override
    public void assignSupervisor() {
        if (!supervisor.getQualification().equalsIgnoreCase("Masters") && !supervisor.getQualification().equalsIgnoreCase("PhD")) {
            throw new IllegalArgumentException("Supervisor must have a Master's degree or higher.");
        }
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking ULK Internship Progress...");
    }

    @Override
    public void generateReport() {
        System.out.println("ULK Internship Report for " + student.getFullName());
    }

    @Override
    public void validateInternship() {
        if (!student.getUniversity().equalsIgnoreCase("ULK")) {
            throw new IllegalArgumentException("Student must be from ULK.");
        }
        if (ChronoUnit.WEEKS.between(startDate, endDate) < 6) {
            throw new IllegalArgumentException("Internship must last at least 6 weeks.");
        }
    }
}

