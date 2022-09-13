package com;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class AssignmentApplication {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AssignmentApplication.class, args);
        ClassPathResource serviceAccount = new ClassPathResource("clothesshop-1e4f2-firebase-adminsdk-go941-099ddf72d7.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
                .setStorageBucket("clothesshop-1e4f2.appspot.com")
                .build();

        FirebaseApp.initializeApp(options);
    }


}
