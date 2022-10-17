package com.team4.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BusyTimeRepository busyTimeRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		User doctor1 = new User(1L , "DOCTOR", "doctor123@gmail.com", "password", "John Dang", "assets/images/doctor_ava_1.jpeg", "123 Abc Street", "0123456789", "Male", new Date(76, Calendar.DECEMBER,20), "","","",
				"Dr John is an expert in GP, with passion and extensive knowledge in his field.", "Surgery", "No status");
		User doctor2 = new User(2L , "DOCTOR", "doctor456@gmail.com", "password", "Alicia Nguyen", "assets/images/doctor_ava_2.jpeg", "123 Abc Street", "0123456789", "Female", new Date(82, Calendar.MARCH,13), "","","",
				"Dr Alicia has over 14 years of experience as a Ophthalmologists.", "Ophthalmologists", "No status" );
		User patient1 = new User(3L , "PATIENT", "ben@gmail.com", "password", "Ben Tran", "assets/images/kieran.jpg", "123 Abc Street", "0123456789", "Male", new Date(76, Calendar.FEBRUARY,14), "Nuts","Migraine","Aspirin",
				"", "", "Feeling sick");
		User patient2 = new User(4L , "PATIENT", "junho@gmail.com", "password", "Go Junho", "assets/images/Junho.png", "224 Elizabeth Street", "0123456789", "Male",new Date(99, Calendar.DECEMBER,30), "Peanut","Heart disease, diabetes level 2","Insulin, Paracetamol",
				"", "", "Frequent headaches");
		User admin = new User(5L , "ADMIN", "hsy@yahoo.com", "hsy1234", "Han Sooyoung", "assets/images/hansooyoung.jpg", "15 Collin St, Melbourne VIC 3000", "0412556668", "Female", new Date(96, Calendar.APRIL, 02), "","","",
				"", "", "");

		BusyTime busyTime1 = new BusyTime(1L, 1L, "11-10-2022 10:30", 2);
		BusyTime busyTime2 = new BusyTime(2L, 1L, "12-10-2022 12:11", 1);
		BusyTime busyTime3 = new BusyTime(3L, 1L, "13-10-2022 14:02", 1);
		BusyTime busyTime4 = new BusyTime(4L, 1L, "14-10-2022 13:25", 2);

		userRepository.save(doctor1);
		userRepository.save(doctor2);
		userRepository.save(patient1);
		userRepository.save(patient2);
		userRepository.save(admin);

		busyTimeRepository.save(busyTime1);
		busyTimeRepository.save(busyTime2);
		busyTimeRepository.save(busyTime3);
		busyTimeRepository.save(busyTime4);
	}

}
