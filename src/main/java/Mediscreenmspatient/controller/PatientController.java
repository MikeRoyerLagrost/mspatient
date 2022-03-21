package Mediscreenmspatient.controller;

import Mediscreenmspatient.model.Patient;
import Mediscreenmspatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    PatientService patientService;


    @PostMapping("/add")
    public Patient addPatient(@RequestBody @Valid Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping
    public void updatePatient(@RequestParam(name = "id") Integer id, @RequestBody Patient patient) {
        patientService.updatePatient(patient, id);
    }

    @GetMapping
    public Patient getPatientById(@RequestParam(name = "id") int id) {
        return this.patientService.findPatientById(id);
    }

    @DeleteMapping
    public void deletePatient(@RequestParam(name = "id") Integer id) {
        patientService.deletePatient(id);
    }

    @GetMapping("/getAll")
    public List<Patient> patientsgetAllPatients() {
        return patientService.findAllPatients();

    }

}
