import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kings90
 */
public class DriverLic  extends Individual {
// methods must be added to this based on the line above

		private Date yearOfExpiration;
		private final int[] MAX_ALLOWED_VIOLATIONS_PER_TYPE = {1, 3, Integer.MAX_VALUE};
		private int[] violationCounter;
		ArrayList<Violation> driverOffenses;
		

		public DriverLic(int licenseNum)
		{
			super(licenseNum);
			this.yearOfExpiration = new Date();
			this.violationCounter = null;
			this.driverOffenses = null;
		}
		
        public DriverLic(String fullName, Date dateOfBirth, int licenseNum, String ssn, Date expirationDate) {
            super(fullName, dateOfBirth, licenseNum, ssn);
            this.yearOfExpiration = expirationDate;
            this.driverOffenses = new ArrayList<Violation>();
            this.violationCounter = new int[]{0, 0, 0};
        }

        public String toString() {

            String retVal = super.toString() + "\nDate Of Expiration: " + yearOfExpiration.toString() + "\n";
            StringBuilder buffer = new StringBuilder();
            for (Violation i : driverOffenses) {
				buffer.append(i.toString());
			}
            return retVal + "Violations: " + buffer.toString();
        }
        
        public boolean addViolation(Violation violation) {
        	driverOffenses.add(violation);
        	violationCounter[violation.getViolationType().ordinal()]++;
        	
        	return canKeepLicense();
        }
        
        private boolean canKeepLicense() {
        	for(int i = 0; i < violationCounter.length; i++)
        	{
        		if(violationCounter[i] > MAX_ALLOWED_VIOLATIONS_PER_TYPE[i])
        		{
        			return false;
        		}
        	}
        	
        	return true;
        }

    }