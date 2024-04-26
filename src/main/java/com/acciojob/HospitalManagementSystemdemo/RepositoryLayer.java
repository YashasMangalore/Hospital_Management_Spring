package com.acciojob.HospitalManagementSystemdemo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RepositoryLayer
{
    Map<Integer,Patient> patientDb=new HashMap<>();
    //This is the database layer

    public String addPatient(Patient patient)
    {
        int key=patient.getPatientID();
        //Add this to patientDB
        patientDb.put(key,patient);
        return "The patient with patientID as "+key+" has been added";
    }

    public List<Patient> getAllPatients()
    {
        List<Patient> patients=new ArrayList<>();
        for(Patient patient:patientDb.values())
        {
            patients.add(patient);
        }
        return patients;
    }
}
