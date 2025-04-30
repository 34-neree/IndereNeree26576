package AdvancedInternshipManagementSystem;



public class Company {
    private String companyId;
    private String name;
    private String industryType;
    private String location;

    public Company(String companyId, String name, String industryType, String location) {
        setCompanyId(companyId);
        setName(name);
        setIndustryType(industryType);
        setLocation(location);
    }

    public String getCompanyId() { return companyId; }

    public void setCompanyId(String companyId) {
        if (companyId == null || companyId.isEmpty())
            throw new IllegalArgumentException("Company ID cannot be empty.");
        this.companyId = companyId;
    }

    public String getName() { return name; }

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Company name cannot be empty.");
        this.name = name;
    }

    public String getIndustryType() { return industryType; }

    public void setIndustryType(String industryType) {
        if (!industryType.equalsIgnoreCase("IT") && !industryType.equalsIgnoreCase("Finance") &&
                !industryType.equalsIgnoreCase("Health") && !industryType.equalsIgnoreCase("Education"))
            throw new IllegalArgumentException("Invalid industry type.");
        this.industryType = industryType;
    }

    public String getLocation() { return location; }

    public void setLocation(String location) {
        if (location == null || location.isEmpty())
            throw new IllegalArgumentException("Location cannot be empty.");
        this.location = location;
    }
}

