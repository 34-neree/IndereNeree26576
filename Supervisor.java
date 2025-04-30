package AdvancedInternshipManagementSystem;

public class Supervisor {
    private String supervisorId;
    private String fullName;
    private String qualification;
    private String email;

    public Supervisor(String supervisorId, String fullName, String qualification, String email) {
        setSupervisorId(supervisorId);
        setFullName(fullName);
        setQualification(qualification);
        setEmail(email);
    }

    public String getSupervisorId() { return supervisorId; }

    public void setSupervisorId(String supervisorId) {
        if (supervisorId == null || supervisorId.isEmpty())
            throw new IllegalArgumentException("Supervisor ID cannot be empty.");
        this.supervisorId = supervisorId;
    }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.fullName = fullName;
    }

    public String getQualification() { return qualification; }

    public void setQualification(String qualification) {
        if (!qualification.equalsIgnoreCase("Bachelors") &&
                !qualification.equalsIgnoreCase("Masters") &&
                !qualification.equalsIgnoreCase("PhD"))
            throw new IllegalArgumentException("Invalid qualification.");
        this.qualification = qualification;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (!email.contains("@"))
            throw new IllegalArgumentException("Invalid email format.");
        this.email = email;
    }
}

