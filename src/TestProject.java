
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a filename ");
        String filename = in.nextLine();
        System.out.println("Opening " + filename);

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + filename + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"+ filename + "'");
        }
    }

}
