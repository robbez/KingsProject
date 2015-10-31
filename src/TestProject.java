import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.generic.NEW;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kings90
 */
public class TestProject {

	private static String line;

	public static void main(String[] arg) throws IOException {

		BinarySearchTree<DriverLic> driverLicenseTree = new BinarySearchTree<DriverLic>();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter individuals filename ");
		String individualsFilename = in.nextLine();
		System.out.println("Opening " + individualsFilename);

		try {
			FileReader fileReader = new FileReader(individualsFilename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// licenseNo DATE OF DB EX SSN NAMES FLM
			// 00918825 7 7 1944 2015 98-86-81684 James Ayla M
			while ((line = bufferedReader.readLine()) != null) {
				loadDriverLicesnse(line, driverLicenseTree);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + individualsFilename
					+ "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + individualsFilename
					+ "'");
		}

		System.out.print("Enter individuals filename ");
		String violationsFilename = in.nextLine();
		System.out.println("Opening " + violationsFilename);

		try {
			FileReader fileReader = new FileReader(violationsFilename);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// licenseNo DATE OF DB EX SSN NAMES FLM
			// 00918825 7 7 1944 2015 98-86-81684 James Ayla M
			while ((line = bufferedReader.readLine()) != null) {
				loadViolation(line, bufferedReader, driverLicenseTree);
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + violationsFilename
					+ "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + violationsFilename
					+ "'");
		}
		
		System.out.println(driverLicenseTree.toString());
	}

	private static void loadDriverLicesnse(String driverLicText,
			BinarySearchTree<DriverLic> driverLicenseTree) {
		StringTokenizer st = new StringTokenizer(line, " ");
		int licenseNum = Integer.parseInt(st.nextToken());
		int dbMonth = Integer.parseInt(st.nextToken());
		int dbDay = Integer.parseInt(st.nextToken());
		int dbYear = Integer.parseInt(st.nextToken());
		int expYear = Integer.parseInt(st.nextToken());
		String ssn = st.nextToken();
		String lastName = st.nextToken();
		String firstName = st.nextToken();
		String middleInitial = st.nextToken();

		String fullName = String.format("%s %s %s.", firstName, lastName,
				middleInitial);
		String dobString = String.format("%s/%s/%s", dbMonth, dbDay, dbYear);
		String expString = String.format("%s/%s/%s", dbMonth, dbDay, expYear);

		Date dob = new Date(dobString);
		Date expirationDate = new Date(expString);

		if (dob.isValidDate() && expirationDate.isValidDate()) {
			DriverLic drvLic = new DriverLic(fullName, dob, licenseNum, ssn,
					expirationDate);
			driverLicenseTree.add(drvLic);
		}
	}

	private static void loadViolation(String violationText,
			BufferedReader bufferedReader,
			BinarySearchTree<DriverLic> driverLicenseTree) {
		StringTokenizer st = new StringTokenizer(line, " ");
		ViolationType type = ViolationType.values()[Integer.parseInt(st
				.nextToken())];
		int licenseNum = Integer.parseInt(st.nextToken());
		String location = "";
		String description = "";

		try {
			for (int i = 0; i < 3 && (line = bufferedReader.readLine()) != null; i++) {
				if (i == 0) {
					location = line.trim();
				}

				else if (i == 1) {
					description = line.trim();
				}

				else {
					st = new StringTokenizer(line, " ");
					int dbMonth = Integer.parseInt(st.nextToken());
					int dbDay = Integer.parseInt(st.nextToken());
					int dbYear = Integer.parseInt(st.nextToken());
					
					String dobString = String.format("%s/%s/%s.", dbMonth, dbDay, dbYear);
					Date violationDate = new Date(dobString);
					
					if(violationDate.isValidDate())
					{
						Violation violation = new Violation(type, description, violationDate, location);
						DriverLic dummy = new DriverLic(licenseNum);
						
						if(!driverLicenseTree.getEntry(dummy).element.addViolation(violation))
						{
							driverLicenseTree.remove(dummy);
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
