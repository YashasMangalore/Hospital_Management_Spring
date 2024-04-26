package com.acciojob.HospitalManagementSystemdemo;

import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerLayer {

    ServiceLayer serviceLayer=new ServiceLayer();

    @PostMapping("addPatient")
    public String addPatient(@RequestBody Patient patient)
    {
        //this layer will take care of endpoint
        String response= serviceLayer.addPatient(patient);
        return response;
    }

    @GetMapping("getPatient/{name}/{mobNo}")
    public Patient getPatient(@PathVariable("name")String name,
                              @PathVariable("mobNo")String mobNo)
    {
        Patient patient= serviceLayer.getPatient(name, mobNo);
        return patient;
    }

    @GetMapping("getPatientByNameAndMobile")//controller layer both
    public Patient getPatientByNameAndMobile(@RequestParam("name")String name, @RequestParam("mobNo")String mobNo)
    {
        Patient patient= serviceLayer.getPatient(name,mobNo);//service layer both
        return patient;
    }

    @GetMapping("findOldestPatientName")
    public String findOldestPatientName()
    {
        String patientName= serviceLayer.getOldestPatientName();
        return patientName;
    }
}
