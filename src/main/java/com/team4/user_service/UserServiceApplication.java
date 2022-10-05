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
		User newUser = new User(1L , 0L, 1L,"DOCTOR", "doctor123@gmail.com", "password", "John Dang", "assets/images/doctor_ava_1.jpeg", "123 Abc Street", "0123456789", "Male", new Date(76, 12,21), "","","",
		"Dr John has over 14 years experience as a GP.", "Surgery");
		User newUser1 = new User(2L , 0L, 2L,"DOCTOR", "doctor456@gmail.com", "password", "Alicia Nguyen", "assets/images/doctor_ava_2.jpeg", "123 Abc Street", "0123456789", "Female", new Date(76, 12,21), "","","",
				"Dr Alicia has over 14 years experience as a Ophthalmologists.", "Ophthalmologists" );
		User newUser2 = new User(3L , 0L, 3L, "DOCTOR", "doctor789@gmail.com", "password", "Ben Tran", "assets/images/doctor_ava_3.jpeg", "123 Abc Street", "0123456789", "Male", new Date(76, 12,21), "","","",
				"Dr John has over 14 years experience as a Radiologists", "Radiologists");
		User newUser3 = new User(4L , 1L, 0L, "PATIENT", "luke@gmail.com", "password", "Luke Nguyen", "assets/images/patient.jpeg", "123 Elizabeth St, Melbourne, VIC 3000", "0413939449", "Male", new Date(76, 12,21), "Peanut Butter, Aspirin, Dairy, Penicillin, Tree nuts","Major depression, Diabetes type 2","Citalopram, Insulin",
				"", "");

		BusyTime busyTime1 = new BusyTime(1L, 1L, "26-09-2022 10:30", 2);
		BusyTime busyTime2 = new BusyTime(2L, 1L, "01-10-2022 12:11", 3);
		BusyTime busyTime3 = new BusyTime(3L, 1L, "29-09-2022 14:02", 4);
		BusyTime busyTime4 = new BusyTime(4L, 1L, "28-09-2022 9:25", 5);



		userRepository.save(newUser);
		userRepository.save(newUser1);
		userRepository.save(newUser2);
		userRepository.save(newUser3);

		busyTimeRepository.save(busyTime1);
		busyTimeRepository.save(busyTime2);
		busyTimeRepository.save(busyTime3);
		busyTimeRepository.save(busyTime4);
	}

}
