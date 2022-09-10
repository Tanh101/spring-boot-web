package com.javaweb.myCodeJava;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
   @Autowired
   private UserRepository repo;

   @Autowired
    private TestEntityManager entityManager;

   @Test
    public void testCreateUser(){
       User user = new User();
       user.setEmail("lyvantanh101@gmail.com");
       user.setPassword("lyvantanh2002");
       user.setFirstName("Tanh");
       user.setLastName("Ly Van");
       User saveUSer = repo.save(user);

       User exitUSer = entityManager.find(User.class, saveUSer.getId());

       assertThat(exitUSer.getEmail()).isEqualTo(user.getEmail());
   }
}
