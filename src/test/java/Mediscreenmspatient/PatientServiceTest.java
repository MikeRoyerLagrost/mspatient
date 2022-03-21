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
    private final Patient patient = new Patient(null, "Mike", "ROYER", localDate, "Enorme", "12 bd de l improvisation", "11284212");

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
    




}