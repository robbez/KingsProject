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

    public Violation(ViolationType type, String description, Date vDate, 
    		String location) {
        violationType = type;
        violationDescription = description;
        violationDate = vDate;
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

}
