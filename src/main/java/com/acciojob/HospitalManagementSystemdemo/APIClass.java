package com.acciojob.HospitalManagementSystemdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("patient")//prefixes added
public class APIClass
{
    @GetMapping("getWeatherStatus")//dummy api to test
    public String getWeatherStatus()
    {
        return "The temperature is 32 degree Celsius, mostly sunny and humidity 70% with wind 18km/hr";
    }

    @GetMapping("sum")
    public String sum(@RequestParam("no1")Integer no1,
                         @RequestParam("no2")Integer no2)
    {
        int sum = no1 + no2;
        return "The sum of the numbers is: "+sum;
    }

    @GetMapping("calculator")
    public String calculator(@RequestParam("num1")Integer num1, @RequestParam("num2")Integer num2,
                             @RequestParam("op")Character op)
    {
        double o = 0;
        switch (op)
        {
            // case to add two numbers
            case '+':
                o = num1 + num2;
                break;

            // case to subtract two numbers
            case '-':
                o = num1 - num2;
                break;

            // case to multiply two numbers
            case '*':
                o = num1 * num2;
                break;

            // case to divide two numbers
            case '/':
                o = (double) num1 / num2;
                break;

            default:
                return "You have entered wrong input";
        }
        return "The final result:"+num1 + " " + op + " " + num2 + " = " + o;
    }

    Map<Integer,Patient> patientDb=new HashMap<>();
    @PostMapping("addPatient")
    public ResponseEntity addPatient(@RequestBody Patient patient)
    {
        int key=patient.getPatientID();
        //Add this to patientDB
        patientDb.put(key,patient);
        String result= "The patient with patientID as "+key+" has been added";
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("getPatientInfo")
    public ResponseEntity getPatientInfo(@RequestParam("patientIDEnterInfo")Integer patientID)
    {
        //patientId acts as key
//        return patientDb.get(patientID);
        Patient patient=patientDb.get(patientID);
        return new ResponseEntity(patient,HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("getPatientByNameAndMobile")
    public Patient getPatientByNameAndMobile(@RequestParam("name")String name, @RequestParam("mobNo")String mobNo)
    {
        for(Patient patient:patientDb.values())
        {
            if(patient.getPatientName().equals(name)&&patient.getMobNo().equals(mobNo))
            {
                return patient;
            }
        }
        return null;
    }
    @GetMapping("findOldestPatientName")
    public String findOldestPatientName()
    {
        int maxAge=0;
        String name="";
        for(Patient patient:patientDb.values())
        {
            if(patient.getPatientAge()>maxAge)
            {
                maxAge= patient.getPatientAge();
                name=patient.getPatientName();
            }
        }
        return name;
    }

    @DeleteMapping("deletePatientRecord")
    public String deletePatientRecord(@RequestParam("patientID")Integer patientID)
    {
        patientDb.remove(patientID);
        return "The patient has been removed";
    }

}
