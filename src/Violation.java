
public class Violation {

    private ViolationType violationType;
    private String violationDescription;
    private Date violationDate;

    public Violation() {
        violationType = ViolationType.MinorViolation;
        violationDescription = "";
        violationDate = new Date();
    }

    public Violation(ViolationType vt, String vd, Date vDate) {
        violationType = vt;
        violationDescription = vd;
        violationDate = vDate;
    }

    public ViolationType getViolationType() {
        return violationType;
    }

    public String getViolationDescription() {
        return violationDescription;
    }

    public Date getViolationDate() {
        return violationDate;
    }

    public String toString() {
        ViolationType licStr = violationType;
        String namStr = violationDescription;
        Date strStr = violationDate;

        String allStr = "Violation Type: " + licStr.toString()
                + " \nViolation Description: " + namStr
                + " \n Violation Date: " + strStr;
        return allStr;
    }

//    public static void main( String[] args )
//    {
//        Violation driver;
//         
//        System.out.println( "This is the main method" );
//        for(int i = 0; i < 10; i++) {
//        	try{
//        		if (MajorViolation)
//        	}
//        		
//       
//        	
//        }
//         
//        String lE = (JOptionPane.showInputDialog( "License number:" ));
//        String nE = (JOptionPane.showInputDialog( "Name:" ));
//        String sT = (JOptionPane.showInputDialog( "Street:" ));
//         
//        driver = new Violation( lE, nE, sT);
//         
//        System.out.println( driver.toString());
//    }
}
