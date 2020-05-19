package es.institutmarianao.domain.repository.impl;

import es.institutmarianao.domain.Role;
import es.institutmarianao.domain.User;
import es.institutmarianao.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private static final List<User> listOfUsers = new ArrayList<User>();

    public User getUserByUsername(String username) {
        for (User user : listOfUsers) {
            if (user != null && user.getUsername() != null
                    && user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    private List<Role> getDefaultUserRoles() {
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        return roles;
    }

    public void addUser(User user) {
        user.setAuthorities(getDefaultUserRoles());
        listOfUsers.add(user);
    }

    public void updateUser(User user) {
        if (listOfUsers.contains(user)) {
            listOfUsers.remove(user);
        }
        listOfUsers.add(user);
    }
}
