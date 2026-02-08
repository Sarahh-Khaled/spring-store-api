package com.codewithmosh.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }
}
////
//package com.codewithmosh.store;
//
//import com.codewithmosh.store.entities.User;
//import com.codewithmosh.store.repositories.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//@SpringBootApplication
//public class StoreApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(StoreApplication.class, args);
//    }
//
//    @Bean
//    CommandLineRunner runner(UserRepository userRepository) {
//        return args -> {
//            // بنكريت مستخدم جديد للتجربة
//            User user = User.builder()
//                    .name("Sara Khaled")
//                    .email("sara@example.com")
//                    .password("password123")
//                    .build();
//
//            // بنحفظه في قاعدة البيانات
//            userRepository.save(user);
//            System.out.println("User 'Sara' has been saved to MySQL!");
//        };
//    }
//}