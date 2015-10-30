import com.sun.javafx.scene.control.skin.FXVK.Type;


public class Violation {

    private ViolationType violationType;
    private String violationDescription;
    private Date violationDate;
    private String violationLocation;

    public Violation() {
        violationType = ViolationType.MinorViolation;
        violationDescription = "";
        violationLocation = "";
        violationDate = new Date();
    }

    public Violation(String type, String description, String vDate, 
    		String location) {
        violationType = type;
        violationDescription = description;
        violationDate = new Date(vDate);
        violationLocation = location;
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
    
    public String getViolationLocation() {
    	return violationLocation;
    }

    public String toString() {
        return "Violation Type: " + violationType.toString()
                + "\nViolation Description: " + violationDescription
                + "\nViolation Date: " + violationDate.toString()
                + "\nViolation Location" + violationLocation;
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
