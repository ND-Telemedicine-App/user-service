package com.team4.user_service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceApplicationTests {
    @Autowired
    private UserService userService;

    @Autowired
    private BusyTimeService busyTimeService;

    /**
     * Test create function
     * Description:
     * Using UserService to create a new user object, check if it is in the database or not
     */
    @Test
    @Order(1)
    void createUser1() {
        userService.saveUser(new User(1L, "DOCTOR", "doctor123@gmail.com", "123123123", "John Dang", "assets/images/doctor_ava_1.jpeg", "111 Bourke Street", "0422030020", "Male", new Date(76, 12, 21), "", "", "",
                "Dr John has over 14 years’ experience as a GP.", "Surgery", "No status"));
        assertNotNull(userService.findById(1L));
    }

    @Test
    @Order(2)
    void createUser2() {
        userService.saveUser(new User(2L, "DOCTOR", "doctor456@gmail.com", "password", "Alicia Nguyen", "assets/images/doctor_ava_2.jpeg", "123 Abc Street", "0123456789", "Female", new Date(76, 12, 21), "", "", "",
                "Dr Alicia has over 14 years’ experience as a Ophthalmologists.", "Ophthalmologists", "No status"));
        assertNotNull(userService.findById(2L));
    }

    @Test
    @Order(3)
    void createUser3() {
        userService.saveUser(new User(3L, "PATIENT", "patient789@gmail.com", "p88888888", "Ben Tran", "assets/images/kieran.jpg", "123 Abc Street", "0123456789", "Male", new Date(76, 12, 21), "Nuts", "Migraine", "Aspirin",
                "", "", "Feeling sick"));
        assertNotNull(userService.findById(3L));
    }

    @Test
    @Order(4)
    void createUser4() {
        userService.saveUser(new User(4L, "PATIENT", "junho@gmail.com", "password", "Go Junho", "assets/images/Junho.png", "224 Elizabeth Street", "0123456789", "Male", new Date(99, 12, 30), "Peanut", "Heart disease, diabetes level 2", "Insulin, Paracetamol",
                "", "", "Frequent headaches"));
        assertNotNull(userService.findById(4L));
    }

    @Test
    @Order(5)
    void createUser5() {
        userService.saveUser(new User( 5L, "PATIENT", "luke@gmail.com", "password", "Van Helsing", "assets/images/patient.jpeg", "422 Swanston Street", "0123456789", "Male", new Date(99, 12,30), "Peanut","Heart disease, diabetes level 2","Insulin, Paracetamol",
                "", "", "Frequent headaches"));
        assertNotNull(userService.findById(5L));
    }


    /**
     * Test find by id function
     * Desceiption:
     * Using UserService to find a person, all variables in that user object should equal to the expected value
     */
    @Test
    @Order(6)
    void viewUserById1() {
        User expectedUser = userService.findById(1L);
        assertEquals(1L, expectedUser.getId());
        assertEquals("DOCTOR", expectedUser.getRole());
        assertEquals("doctor123@gmail.com", expectedUser.getEmail());
        assertEquals("123123123", expectedUser.getPassword());
        assertEquals("John Dang", expectedUser.getFullName());
        assertEquals("assets/images/doctor_ava_1.jpeg", expectedUser.getAvatar());
        assertEquals("111 Bourke Street", expectedUser.getAddress());
        assertEquals("0422030020", expectedUser.getPhoneNumber());
        assertEquals("Male", expectedUser.getGender());
        assertEquals(new Date(76,12,21), expectedUser.getDateOfBirth());
        assertEquals("", expectedUser.getAllergies());
        assertEquals("", expectedUser.getDiseases());
        assertEquals("", expectedUser.getMedication());
        assertEquals("Dr John has over 14 years’ experience as a GP.", expectedUser.getBio());
        assertEquals("Surgery", expectedUser.getSpeciality());
        assertEquals("No status", expectedUser.getUserStatus());
    }

    @Test
    @Order(7)
    void viewUserById2() {
        User expectedUser = userService.findById(3L);
        assertEquals(3L, expectedUser.getId());
        assertEquals("PATIENT", expectedUser.getRole());
        assertEquals("patient789@gmail.com", expectedUser.getEmail());
        assertEquals("p88888888", expectedUser.getPassword());
        assertEquals("Ben Tran", expectedUser.getFullName());
        assertEquals("assets/images/kieran.jpg", expectedUser.getAvatar());
        assertEquals("123 Abc Street", expectedUser.getAddress());
        assertEquals("0123456789", expectedUser.getPhoneNumber());
        assertEquals("Male", expectedUser.getGender());
        assertEquals(new Date(76,12,21), expectedUser.getDateOfBirth());
        assertEquals("Nuts", expectedUser.getAllergies());
        assertEquals("Migraine", expectedUser.getDiseases());
        assertEquals("Aspirin", expectedUser.getMedication());
        assertEquals("", expectedUser.getBio());
        assertEquals("", expectedUser.getSpeciality());
        assertEquals("Feeling sick", expectedUser.getUserStatus());
    }

    @Test
    @Order(8)
    void viewUserById3() {
        User expectedUser = userService.findById(4L);
        assertEquals(4L, expectedUser.getId());
        assertEquals("PATIENT", expectedUser.getRole());
        assertEquals("junho@gmail.com", expectedUser.getEmail());
        assertEquals("password", expectedUser.getPassword());
        assertEquals("Go Junho", expectedUser.getFullName());
        assertEquals("assets/images/Junho.png", expectedUser.getAvatar());
        assertEquals("224 Elizabeth Street", expectedUser.getAddress());
        assertEquals("0123456789", expectedUser.getPhoneNumber());
        assertEquals("Male", expectedUser.getGender());
        assertEquals(new Date(99,12,30), expectedUser.getDateOfBirth());
        assertEquals("Peanut", expectedUser.getAllergies());
        assertEquals("Heart disease, diabetes level 2", expectedUser.getDiseases());
        assertEquals("Insulin, Paracetamol", expectedUser.getMedication());
        assertEquals("", expectedUser.getBio());
        assertEquals("", expectedUser.getSpeciality());
        assertEquals("Frequent headaches", expectedUser.getUserStatus());
    }

    /**
     * Test view all doctors function
     * Desceiption:
     * Using UserService to fetch all doctors, the size of person list should be equal to the expected value
     */
    @Test
    @Order(9)
    void viewAllDoctors() {
//        userService.saveUser(new User(5L, "DOCTOR", "doctor123@gmail.com", "3563563563", "Jason Smith", "assets/images/doctor_ava_1.jpeg", "111 Bourke Street", "0422030020", "Male", new Date(76, 12, 21), "", "", "",
//                "Dr Jason has over 14 years’ experience as a GP.", "Surgery", "No status"));
        assertEquals(2, (userService.findAllDoctors()).size());
    }

    /**
     * Test view all doctors function
     * Desceiption:
     * Using UserService to fetch all doctors, the size of doctor list should be equal to the expected value
     */
    @Test
    @Order(10)
    void viewAllPatients() {
//        userService.saveUser(new User(6L , "PATIENT", "luke@gmail.com", "password", "Luke Nguyen", "assets/images/patient.jpeg", "500 Elizabeth Street", "0123456789", "Male", new Date(99, 12,30), "Peanut","Heart disease, diabetes level 2","Insulin, Paracetamol",
//                "", "", "Frequent headaches"));
        assertEquals(3, (userService.findAllPatients()).size());
    }

    /**
     * Test view all users function
     * Desceiption:
     * Using UserService to fetch all users, the size of patient list should be equal to the expected value
     */
    @Test
    @Order(11)
    void viewAllUsers() {
//        userService.saveUser(new User(7L , "PATIENT", "luke@gmail.com", "password", "Van Helsing", "assets/images/patient.jpeg", "422 Swanston Street", "0123456789", "Male", new Date(99, 12,30), "Peanut","Heart disease, diabetes level 2","Insulin, Paracetamol",
//                "", "", "Frequent headaches"));
        assertEquals(5, (userService.findAll()).size());
    }

    /**
     * Test update user status function
     * Desceiption:
     *      Using UserService to update a user status, the attribute status of that user should equal to expected value
     */
    @Test
    @Order(12)
    void updateUser1() {
        User user1 = userService.findById(1L);
        userService.updateUserStatus(1L, "Online 1");
        User person1AfterModify = userService.findById(1L);
        assertEquals("Online 1", person1AfterModify.getUserStatus());
    }

    @Test
    @Order(13)
    void updateUser2() {
        User user2 = userService.findById(3L);
        userService.updateUserStatus(3L, "No status");
        User person1AfterModify = userService.findById(3L);
        assertEquals("No status", person1AfterModify.getUserStatus());
    }

    /**
     * Test create busyTime function
     * Description:
     * Using BusyTimeService to create a new busyTime object, check if it is in the database or not
     */
    @Test
    @Order(14)
    void createBusyTime1() {
        busyTimeService.saveBusyTime(new BusyTime(1L, 1L, "11-10-2022 10:30", 2));
        assertNotNull(userService.findById(1L));
    }

    @Test
    @Order(15)
    void createBusyTime2() {
        busyTimeService.saveBusyTime(new BusyTime(2L, 1L, "15-10-2022 11:00", 2));
        assertNotNull(userService.findById(2L));
    }

    @Test
    @Order(16)
    void createBusyTime3() {
        busyTimeService.saveBusyTime(new BusyTime(3L, 12L, "21-10-2022 10:30", 4));
        assertNotNull(userService.findById(3L));
    }

    @Test
    @Order(17)
    void createBusyTime4() {
        busyTimeService.saveBusyTime(new BusyTime(4L, 12L, "13-10-2022 15:30", 1));
        assertNotNull(userService.findById(4L));
    }

    @Test
    @Order(18)
    void createBusyTime5() {
        busyTimeService.saveBusyTime(new BusyTime(5L, 12L, "31-10-2022 16:30", 2));
        assertNotNull(userService.findById(5L));
    }

    /**
     * Test find busytime by id function
     * Desceiption:
     *      Using BusyTimeService to find a doctor's busy time, the size of list should equal to expected value
     */
    @Test
    @Order(19)
    void viewBusyTimeByDoctorId1() {
        List<BusyTime> actualBusyTime = busyTimeService.findBusyTimesByDoctorId(1L);
        assertEquals(2, actualBusyTime.size());
    }

    @Test
    @Order(20)
    void viewBusyTimeByDoctorId2() {
        List<BusyTime> actualBusyTime = busyTimeService.findBusyTimesByDoctorId(12L);
        assertEquals(3, actualBusyTime.size());
    }

}
