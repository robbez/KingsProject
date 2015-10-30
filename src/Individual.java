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
public class Individual {

    private final String Name;
    private final Date DateOfBirth;
    private final int SocialSecurityNumber;
    private final int LicenseNumber;

    public Individual(String fullName, String dateOfBirth, int licenseNum, int ssn) {
        this.Name = fullName;
        this.DateOfBirth = new Date(dateOfBirth);
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

    public int getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public String toString() {
        String result;
        result = "Name: " + Name + "birthdate " + DateOfBirth + " License: " + LicenseNumber;
        return result;
    }
}
