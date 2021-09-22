package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;
    static {
        users.add(new User(1,"changeun",new Date(),"pass1","701010-1111111"));
        users.add(new User(2,"hihi",new Date(),"pass2","801010-1122221"));
        users.add(new User(3,"alice",new Date(),"pass3","901010-1111111"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User deleteById(int id) {
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            User user = iter.next();

            if (user.getId() == id) {
                iter.remove();
                return user;
            }

        }
        return null;
    }

    public User update(int id, User user) {
        User foundUser = findOne(id);

        if (foundUser != null) {
            foundUser.setJoinDate(user.getJoinDate());
            foundUser.setName(user.getName());
        }

        return foundUser;
    }
}
