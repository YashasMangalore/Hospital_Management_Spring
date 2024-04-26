package com.acciojob.HospitalManagementSystemdemo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class ServiceLayer {

    RepositoryLayer repositoryLayer=new RepositoryLayer();
    public String addPatient(Patient patient)
    {
        String response= repositoryLayer.addPatient(patient);
        return response;
    }

    public Patient getPatient(String name, String mobNo)
    {
        List<Patient> patientList=repositoryLayer.getAllPatients();
        for(Patient patient:patientList)
        {
            if(patient.getPatientName().equals(name) && patient.getMobNo().equals(mobNo))
            {
                return patient;
            }
        }
        return null;
    }

    public String getOldestPatientName()
    {
        List<Patient> patientList=repositoryLayer.getAllPatients();
        int maxAge=0;
        String name="";
        for(Patient patient:patientList)
        {
            if(patient.getPatientAge()>maxAge)
            {
                maxAge= patient.getPatientAge();
                name=patient.getPatientName();
            }
        }
        return name;
    }
}
