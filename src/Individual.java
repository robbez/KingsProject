/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael Githinji
 */
// licenseNo DATE OF  DB     EX     SSN        NAMES FLM
// 00918825   7   7 1944    2015  98-86-81684 James  Ayla M
public class Individual implements Comparable<Individual> {

    private final String Name;
    private final Date DateOfBirth;
    private final String SocialSecurityNumber;
    private final int LicenseNumber;

    public Individual(int licenseNum)
    {
    	this.LicenseNumber = licenseNum;
    	this.Name = "N/A";
    	this.SocialSecurityNumber = "N/A";
    	this.DateOfBirth = new Date();
    }
    
    public Individual(String fullName, Date dateOfBirth, int licenseNum, String ssn) {
        this.Name = fullName;
        this.DateOfBirth = dateOfBirth;
        this.LicenseNumber = licenseNum;
        this.SocialSecurityNumber = ssn;
    }

    public String getName() {
        return Name;
    }

    public Date getDateOfBirth() {
        return new Date();
    }

    public int getLicenseNumber() {
        return LicenseNumber;
    }

    public String getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public String toString() {
        String result;
        result = "Name: " + Name + "birthdate " + DateOfBirth + " License: " + LicenseNumber;
        return result;
    }

	@Override
	public int compareTo(Individual other) {
		if(this.LicenseNumber < other.LicenseNumber) return -1;
		if(this.LicenseNumber > other.LicenseNumber) return 1;
		return 0;
	}
}
