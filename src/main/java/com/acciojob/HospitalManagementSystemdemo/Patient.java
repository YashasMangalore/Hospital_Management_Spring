package com.acciojob.HospitalManagementSystemdemo;

public class Patient
{
    private int patientID;
    private String PatientName;
    private int patientAge;
    private String PatientDisease;
    private String mobNo;

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        PatientName = patientName;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientDisease() {
        return PatientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        PatientDisease = patientDisease;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
