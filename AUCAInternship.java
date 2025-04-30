package AdvancedInternshipManagementSystem;


import java.time.LocalDate;

public class AUCAInternship extends Internship {

    public AUCAInternship(String internshipId, Student student, Company company, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        super(internshipId, student, company, supervisor, startDate, endDate);
    }

    @Override
    public void assignSupervisor() {
        System.out.println("Assigning supervisor for AUCA Internship...");
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking weekly reports for AUCA Internship...");
    }

    @Override
    public void generateReport() {
        System.out.println("AUCA Internship Report for " + student.getFullName());
    }

    @Override
    public void validateInternship() {
        if (!student.getUniversity().equalsIgnoreCase("AUCA")) {
            throw new IllegalArgumentException("Student must be from AUCA.");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date.");
        }
    }
}
