package com.team4.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		User newUser = new User(1L , "DOCTOR", "doctor123@gmail.com", "password", "John Dang", "assets/images/doctor_ava_1.jpeg", "123 Abc Street", "0123456789", "Male", new Date(76, 12,21), "","","",
				"Dr John has over 14 years’ experience as a GP.", "Surgery", "No status");
		User newUser1 = new User(2L , "DOCTOR", "doctor456@gmail.com", "password", "Alicia Nguyen", "assets/images/doctor_ava_2.jpeg", "123 Abc Street", "0123456789", "Female", new Date(76, 12,21), "","","",
				"Dr Alicia has over 14 years’ experience as a Ophthalmologists.", "Ophthalmologists", "No status" );
		User newUser2 = new User(3L , "PATIENT", "doctor789@gmail.com", "password", "Ben Tran", "assets/images/kieran.jpg", "123 Abc Street", "0123456789", "Male", new Date(76, 12,21), "Nuts","Migraine","Aspirin",
				"", "", "Feeling sick");
		User newUser3 = new User(4L , "PATIENT", "junho@gmail.com", "password", "Go Junho", "assets/images/Junho.png", "224 Elizabeth Street", "0123456789", "Male", new Date(99, 12,30), "Peanut","Heart disease, diabetes level 2","Insulin, Paracetamol",
				"", "", "Frequent headaches");
		User newUser4 = new User(5L , "PATIENT", "luke@gmail.com", "password", "Luke Nguyen", "assets/images/patient.jpeg", "500 Elizabeth Street", "0123456789", "Male", new Date(99, 12,30), "Peanut","Heart disease, diabetes level 2","Insulin, Paracetamol",
				"", "", "Frequent headaches");

		BusyTime busyTime1 = new BusyTime(1L, 1L, "11-10-2022 10:30", 2);
		BusyTime busyTime2 = new BusyTime(2L, 1L, "12-10-2022 12:11", 1);
		BusyTime busyTime3 = new BusyTime(3L, 1L, "13-10-2022 14:02", 1);
		BusyTime busyTime4 = new BusyTime(4L, 1L, "14-10-2022 13:25", 2);



		userRepository.save(newUser);
		userRepository.save(newUser1);
		userRepository.save(newUser2);
		userRepository.save(newUser3);
		newUser1.setUserStatus("Online 2");
		userRepository.save(newUser1);
		userRepository.save(newUser4);


		busyTimeRepository.save(busyTime1);
		busyTimeRepository.save(busyTime2);
		busyTimeRepository.save(busyTime3);
		busyTimeRepository.save(busyTime4);
	}

}
