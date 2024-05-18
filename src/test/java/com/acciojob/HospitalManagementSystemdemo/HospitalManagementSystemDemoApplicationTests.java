package com.acciojob.HospitalManagementSystemdemo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HospitalManagementSystemDemoApplicationTests
{
//	@Test
//	void contextLoads() {
//	}

	@Mock
	public RepositoryLayer repositoryLayerObj;
	@InjectMocks
	public ServiceLayer serviceLayer=new ServiceLayer();// test won't allow Autowired

	@Test
	public void testGetOldestPatient()
	{
		//expected output:p3
		String expectedOutput="p3";
		//create a dummy data
		String actualOutput=serviceLayer.getOldestPatientName(generateDummyData());

		assert(actualOutput.equals(expectedOutput));
	}

	@Test
	public void testGetOldestPatientWithNoInput()
	{
		List<Patient> dummyData=generateDummyData();
		//mock external data
		Mockito.when(repositoryLayerObj.getAllPatients()).thenReturn(dummyData);
		//expected output:p3
		String expectedOutput="p3";
		String actualOutput=serviceLayer.getOldestPatientName();
		assert(expectedOutput.equals(actualOutput));
	}

	private List<Patient> generateDummyData()
	{
		Patient p1=new Patient(1,"p1",24,"Fever","1234");
		Patient p2=new Patient(2,"p2",12,"Cold","1234");
		Patient p3=new Patient(3,"p3",88,"Cancer","12334");
		Patient p4=new Patient(4,"p4",54,"Flu","124534");
		List<Patient> patientList=new ArrayList<>();
		patientList.add(p1);
		patientList.add(p2);
		patientList.add(p3);
		patientList.add(p4);
		return patientList;
	}
}
