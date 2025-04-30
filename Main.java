package AdvancedInternshipManagementSystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    private static final List<Student> students = new ArrayList<>();
    private static final List<Supervisor> supervisors = new ArrayList<>();
    private static final List<Company> companies = new ArrayList<>();
    private static final List<Internship> internships = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Internship Management System =====");
            System.out.println("1. Register Student");
            System.out.println("2. Register Supervisor");
            System.out.println("3. Register Company");
            System.out.println("4. Assign Internship");
            System.out.println("5. View Internships");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerStudent();
                    break;
                case "2":
                    registerSupervisor();
                    break;
                case "3":
                    registerCompany();
                    break;
                case "4":
                    assignInternship();
                    break;
                case "5":
                    viewInternships();
                    break;
                case "6":
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void registerStudent() {
        System.out.println("\n--- Register Student ---");
        String studentId = inputString("Enter Student ID: ");
        String fullName = inputString("Enter Full Name: ");
        String university = inputUniversity();
        String email = inputEmail();

        Student student = new Student(studentId, fullName, university, email);
        students.add(student);
        System.out.println("Student registered successfully!");
    }

    private static void registerSupervisor() {
        System.out.println("\n--- Register Supervisor ---");
        String supervisorId = inputString("Enter Supervisor ID: ");
        String fullName = inputString("Enter Full Name: ");
        String qualification = inputQualification();
        String email = inputEmail();

        Supervisor supervisor = new Supervisor(supervisorId, fullName, qualification, email);
        supervisors.add(supervisor);
        System.out.println("Supervisor registered successfully!");
    }

    private static void registerCompany() {
        System.out.println("\n--- Register Company ---");
        String companyId = inputString("Enter Company ID: ");
        String name = inputString("Enter Company Name: ");
        String industryType = inputIndustryType();
        String location = inputString("Enter Location: ");

        Company company = new Company(companyId, name, industryType, location);
        companies.add(company);
        System.out.println("Company registered successfully!");
    }

    private static void assignInternship() {
        System.out.println("\n--- Assign Internship ---");

        if (students.isEmpty() || supervisors.isEmpty() || companies.isEmpty()) {
            System.out.println("Please register at least one student, supervisor, and company first.");
            return;
        }

        String internshipId = inputString("Enter Internship ID: ");
        Student student = chooseStudent();
        Company company = chooseCompany();
        Supervisor supervisor = chooseSupervisor();
        LocalDate startDate = inputDate("Enter Start Date (YYYY-MM-DD): ");
        LocalDate endDate = inputDate("Enter End Date (YYYY-MM-DD): ");

        System.out.println("Choose Internship Type:");
        System.out.println("1. ULK Internship");
        System.out.println("2. UR Internship");
        System.out.println("3. AUCA Internship");
        System.out.println("4. UK Internship");
        System.out.println("5. Remote Internship");

        String type = scanner.nextLine();

        Internship internship = null;

        try {
            switch (type) {
                case "1":
                    internship = new ULKInternship(internshipId, student, company, supervisor, startDate, endDate);
                    break;
                case "2":
                    internship = new URInternship(internshipId, student, company, supervisor, startDate, endDate);
                    break;
                case "3":
                    internship = new AUCAInternship(internshipId, student, company, supervisor, startDate, endDate);
                    break;
                case "4":
                    internship = new UKInternship(internshipId, student, company, supervisor, startDate, endDate);
                    break;
                case "5":
                    internship = new RemoteInternship(internshipId, student, company, supervisor, startDate, endDate);
                    break;
                default:
                    System.out.println("Invalid internship type selected.");
                    return;
            }
            internship.validateInternship();
            internships.add(internship);
            System.out.println("Internship assigned successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error assigning internship: " + e.getMessage());
        }
    }

    private static void viewInternships() {
        if (internships.isEmpty()) {
            System.out.println("No internships found.");
        } else {
            System.out.println("\n--- List of Internships ---");
            for (Internship internship : internships) {
                System.out.println(internship);
                System.out.println("------------------------");
            }
        }
    }

    // ---------- Helper Methods ----------

    private static String inputString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                return input.trim();
            }
            System.out.println("Input cannot be empty. Try again.");
        }
    }

    private static String inputEmail() {
        while (true) {
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            if (email.contains("@")) {
                return email.trim();
            }
            System.out.println("Invalid email format. Must contain '@'. Try again.");
        }
    }

    private static String inputUniversity() {
        while (true) {
            System.out.print("Enter University (ULK, UR, AUCA, UK): ");
            String university = scanner.nextLine().toUpperCase();
            if (university.equals("ULK") || university.equals("UR") || university.equals("AUCA") || university.equals("UK")) {
                return university;
            }
            System.out.println("Invalid university. Try again.");
        }
    }

    private static String inputQualification() {
        while (true) {
            System.out.print("Enter Qualification (Bachelors, Masters, PhD): ");
            String qualification = scanner.nextLine();
            if (qualification.equalsIgnoreCase("Bachelors") || qualification.equalsIgnoreCase("Masters") || qualification.equalsIgnoreCase("PhD")) {
                return qualification;
            }
            System.out.println("Invalid qualification. Try again.");
        }
    }

    private static String inputIndustryType() {
        while (true) {
            System.out.print("Enter Industry Type (IT, Finance, Health, Education): ");
            String industry = scanner.nextLine();
            if (industry.equalsIgnoreCase("IT") || industry.equalsIgnoreCase("Finance") || industry.equalsIgnoreCase("Health") || industry.equalsIgnoreCase("Education")) {
                return industry;
            }
            System.out.println("Invalid industry type. Try again.");
        }
    }

    private static LocalDate inputDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scanner.nextLine();
                return LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid date format. Try again (YYYY-MM-DD).");
            }
        }
    }

    private static Student chooseStudent() {
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getFullName() + " (" + students.get(i).getUniversity() + ")");
        }
        int index = inputChoice(1, students.size());
        return students.get(index - 1);
    }

    private static Supervisor chooseSupervisor() {
        System.out.println("Available Supervisors:");
        for (int i = 0; i < supervisors.size(); i++) {
            System.out.println((i + 1) + ". " + supervisors.get(i).getFullName() + " (" + supervisors.get(i).getQualification() + ")");
        }
        int index = inputChoice(1, supervisors.size());
        return supervisors.get(index - 1);
    }

    private static Company chooseCompany() {
        System.out.println("Available Companies:");
        for (int i = 0; i < companies.size(); i++) {
            System.out.println((i + 1) + ". " + companies.get(i).getName() + " (" + companies.get(i).getIndustryType() + ")");
        }
        int index = inputChoice(1, companies.size());
        return companies.get(index - 1);
    }

    private static int inputChoice(int min, int max) {
        while (true) {
            try {
                System.out.print("Enter choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } catch (Exception e) {
                // Fallthrough to print error
            }
            System.out.println("Invalid choice. Try again.");
        }
    }
}

