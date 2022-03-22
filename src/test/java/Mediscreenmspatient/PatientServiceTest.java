package Mediscreenmspatient;

import Mediscreenmspatient.model.Patient;
import Mediscreenmspatient.service.PatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class PatientServiceTest {

    @Autowired
    PatientService patientService;
    LocalDate localDate = LocalDate.of(1983, 05, 17);
    private final Patient patient = new Patient(null, "Mike", "ROYER", localDate, "Enorme", "12 bd de l'improvisation", "11284212");

    @Test
    void contextLoads() {
    }

    @Test
    public void createPatientTest() {
        Patient patientCreated = patientService.createPatient(patient);

        Assertions.assertEquals("11284212", patientService.findPatientById(patientCreated.getId()).getPhone());
        patientService.deletePatient(patientCreated.getId());
    }

    @Test
    public void findPatientByIdTest() {
        Patient patientCreated = patientService.createPatient(patient);
        Patient patientSearched = patientService.findPatientById(patientCreated.getId());
        Assertions.assertEquals("11284212", patientSearched.getPhone());
        patientService.deletePatient(patientCreated.getId());
    }

    @Test
    public void updatePatientTest() {
        Patient patientCreated = patientService.createPatient(patient);
        patientCreated.setPhone("12294313");
        Patient patientUpdated = patientService.updatePatient(patientCreated, patientCreated.getId());
        Assertions.assertEquals(patientUpdated.getPhone(), "12294313");
        patientService.deletePatient(patientCreated.getId());
    }

    @Test
    void deletePatientTest() {


        Patient patientCreated = patientService.createPatient(patient);

        patientService.deletePatient(patientCreated.getId());

        Assertions.assertThrows(IllegalArgumentException.class, () -> patientService.findPatientById(patientCreated.getId()));
    }

}