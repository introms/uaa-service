package it.itresources.demo.micro.uaaservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import it.itresources.demo.micro.uaaservice.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {}























/*
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import it.itresources.demo.micro.uaaservice.domain.User;

// @Repository
@Component
public class UserRepository {

    private static long idx = 0;
    private HashMap<Long, User> db = new HashMap<>();

    public User save(User user) {
        user.setId(++idx);
        db.put(idx, user);
        return user;
    }

    public List<User> selectAll() {
        return new ArrayList<>(db.values());
    }
    
}

*/