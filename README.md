# Patient Management API Documentation

## Introduction

This API offers a set of endpoints for managing patient data, including adding, retrieving, and deleting records. It also supports additional operations like performing calculations on patient lists. The controller layer maps these requests to their respective services, ensuring smooth API interactions.

## API Endpoints

### Add Patient
**POST** `/patient/addPatient`

- **Description**: Adds a new patient to the database.
- **Request Body**: 
  - `patientID` (String)
  - `patientAge` (Integer)
  - `mobNo` (String)
  - `patientName` (String)
  - `patientDisease` (String)
- **Response**: Success or failure message.

### Sum of Patients
**GET** `/patient/sum`

- **Description**: Returns the sum of all patients (could be the total count or a specific aggregated value related to patients).
- **Response**: Sum of patients.

### Get Patient Info
**GET** `/patient/getPatientInfo`

- **Description**: Retrieves the information of all patients.
- **Response**: List of patient details.

### Get Patient by Name and Mobile
**GET** `/patient/getPatientByNameAndMobile`

- **Description**: Retrieves patient information based on the provided name and mobile number.
- **Response**: Patient details matching the criteria.

### Find Oldest Patient Name
**GET** `/patient/findOldestPatientName`

- **Description**: Finds and returns the name of the oldest patient.
- **Response**: Name of the oldest patient.

### Delete Patient Record
**DELETE** `/patient/deletePatientRecord`

- **Description**: Deletes a patient record from the database.
- **Request Parameters**: 
  - `patientID` (String)
- **Response**: Success or failure message.

## Controller Layer

### Add Patient
**POST** `/addPatient`

- **Description**: Controller method to handle the addition of a new patient.
- **Maps to**: `/patient/addPatient`

### Get Patient by Name and Mobile
**GET** `/getPatientByNameAndMobile`

- **Description**: Controller method to retrieve patient information by name and mobile number.
- **Maps to**: `/patient/getPatientByNameAndMobile`

### Get Patient by Name and Mobile (with path variables)
**GET** `/getPatient/{name}/{mobNo}`

- **Description**: Controller method to retrieve patient information using path variables for name and mobile number.
- **Maps to**: `/patient/getPatientByNameAndMobile`

### Find Oldest Patient Name
**GET** `/findOldestPatientName`

- **Description**: Controller method to find the name of the oldest patient.
- **Maps to**: `/patient/findOldestPatientName`

## Schemas

### Patient
- **patientID** (String): Unique identifier for the patient.
- **patientAge** (Integer): Age of the patient.
- **mobNo** (String): Mobile number of the patient.
- **patientName** (String): Name of the patient.
- **patientDisease** (String): Disease the patient is suffering from.
