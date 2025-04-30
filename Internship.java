package AdvancedInternshipManagementSystem;

import java.time.LocalDate;

public abstract class Internship {
    protected String internshipId;
    protected Student student;
    protected Company company;
    protected Supervisor supervisor;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected String status; // PENDING, ONGOING, COMPLETED

    public Internship(String internshipId, Student student, Company company, Supervisor supervisor, LocalDate startDate, LocalDate endDate) {
        this.internshipId = internshipId;
        this.student = student;
        this.company = company;
        this.supervisor = supervisor;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "PENDING";
    }

    public abstract void assignSupervisor();

    public abstract void trackProgress();

    public abstract void generateReport();

    public abstract void validateInternship();
}
