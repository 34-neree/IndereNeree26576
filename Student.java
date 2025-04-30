package AdvancedInternshipManagementSystem;

public class Student {
    private String studentId;
    private String fullName;
    private String university;
    private String email;

    public Student(String studentId, String fullName, String university, String email) {
        setStudentId(studentId);
        setFullName(fullName);
        setUniversity(university);
        setEmail(email);
    }

    // Getters and Setters with Validation
    public String getStudentId() { return studentId; }

    public void setStudentId(String studentId) {
        if (studentId == null || studentId.isEmpty())
            throw new IllegalArgumentException("Student ID cannot be empty.");
        this.studentId = studentId;
    }

    public String getFullName() { return fullName; }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty.");
        this.fullName = fullName;
    }

    public String getUniversity() { return university; }

    public void setUniversity(String university) {
        if (!university.equalsIgnoreCase("ULK") && !university.equalsIgnoreCase("UR") &&
                !university.equalsIgnoreCase("AUCA") && !university.equalsIgnoreCase("UK"))
            throw new IllegalArgumentException("Invalid university.");
        this.university = university.toUpperCase();
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (!email.contains("@"))
            throw new IllegalArgumentException("Invalid email format.");
        this.email = email;
    }
}
