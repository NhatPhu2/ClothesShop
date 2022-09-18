//package com.controller;
//
//
//import com.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//public class TestLogin {
//
//
//
//    @PostMapping("login")
//    public boolean login(@RequestBody LoginReq) {
//        System.out.println(userDetails.getPassword().);
//        return user.getUsername().equals(UserDetails) && user.getPassword().equals(userDetails.getPassword());
//    }
//
//    public static class User{
//        String username;
//        String password;
//
//        public User() {
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//    }
//}
