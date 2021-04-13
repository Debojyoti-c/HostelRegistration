import static org.junit.Assert.*;

import controllers.RegistrationController;
import datastore.DataStore;
import dtos.RegistrationDTO;
import org.junit.Before;
import org.junit.Test;

public class TestHostelRegistration {

    DataStore dataStore;
    RegistrationController registrationController;

    @Before
    public void setUp() throws Exception {
        dataStore = DataStore.getInstance();
        registrationController = new RegistrationController();
    }

    @Test
    public void testStudentSuccessfulRegistration(){
        dataStore.flush();
        RegistrationDTO registrationDTO1 = new RegistrationDTO("1", "A", "V");
        RegistrationDTO registrationDTO2 = new RegistrationDTO("2", "B", "V");
        RegistrationDTO registrationDTO3 = new RegistrationDTO("3", "B", "V");
        registrationController.addHostels(8);
        registrationController.registerStudent(registrationDTO1);
        registrationController.registerStudent(registrationDTO2);
        registrationController.registerStudent(registrationDTO3);
        assertEquals(2, dataStore.getHostelMap().get("BV").getStudentList().size());
        assertEquals(1, dataStore.getHostelMap().get("AV").getStudentList().size());
    }

    @Test
    public void testStudentDuplicateRegistration() {
        dataStore.flush();
        RegistrationDTO registrationDTO1 = new RegistrationDTO("1", "A", "V");
        RegistrationDTO registrationDTO2 = new RegistrationDTO("1", "B", "V");
        registrationController.addHostels(4);
        registrationController.registerStudent(registrationDTO1);
        registrationController.registerStudent(registrationDTO2);
        assertEquals(1, dataStore.getHostelMap().get("AV").getStudentList().size());
        assertEquals(0, dataStore.getHostelMap().get("BV").getStudentList().size());
    }

    @Test
    public void testStudentRegistrationWithExtraStudent() {
        dataStore.flush();
        RegistrationDTO registrationDTO1 = new RegistrationDTO("1", "A", "V");
        RegistrationDTO registrationDTO2 = new RegistrationDTO("2", "B", "V");
        RegistrationDTO registrationDTO3 = new RegistrationDTO("3", "A", "NV");
        RegistrationDTO registrationDTO4 = new RegistrationDTO("4", "B", "NV");
        RegistrationDTO registrationDTO5 = new RegistrationDTO("5", "B", "NV");
        registrationController.addHostels(4);
        registrationController.registerStudent(registrationDTO1);
        registrationController.registerStudent(registrationDTO2);
        registrationController.registerStudent(registrationDTO3);
        registrationController.registerStudent(registrationDTO4);
        registrationController.registerStudent(registrationDTO5);
        assertEquals(1, dataStore.getHostelMap().get("AV").getStudentList().size());
        assertEquals(1, dataStore.getHostelMap().get("BV").getStudentList().size());
        assertEquals(1, dataStore.getHostelMap().get("ANV").getStudentList().size());
        assertEquals(1, dataStore.getHostelMap().get("BNV").getStudentList().size());
        assertEquals(1, dataStore.getUnregisteredStudents().size());
    }
}