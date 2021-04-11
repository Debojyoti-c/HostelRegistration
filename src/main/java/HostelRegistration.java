import controllers.RegistrationController;
import dtos.RegistrationDTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HostelRegistration {

    public static void main(String args[]) throws FileNotFoundException {

        RegistrationController registrationController = new RegistrationController();

        String fileName = "input.txt";
        ClassLoader classLoader = HostelRegistration.class.getClassLoader();

        File file = new File(classLoader.getResource(fileName).getFile());
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.equals("fin")) {
                registrationController.print();
                return;
            }
            String temp[] = s.split(" ");
            if (temp[0].equals("init")) {
                int totalCapacity = Integer.parseInt(temp[1]);
                registrationController.addHostels(totalCapacity);
            }
            else {
                RegistrationDTO registrationDTO = new RegistrationDTO(temp[1], temp[2], temp[3]);
                registrationController.registerStudent(registrationDTO);
            }
        }
        scanner.close();
    }
}
