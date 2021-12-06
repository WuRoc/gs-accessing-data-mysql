package com.example.accessingdatamysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dell
 */
@SpringBootApplication
public class AccessingDataMysqlApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataMysqlApplication.class, args);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {

        User user = new User("wuhepeng", "wu13213786609@outloook.com");

        Comment comment1 = new Comment("Very beautiful");
        Comment comment2 = new Comment("information");
        Comment comment3 = new Comment("Great post");

        user.getComments().add(comment1);
        user.getComments().add(comment2);
        user.getComments().add(comment3);

        this.userRepository.save(user);
    }
}
