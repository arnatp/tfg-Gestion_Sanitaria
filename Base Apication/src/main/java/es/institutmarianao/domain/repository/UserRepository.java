package es.institutmarianao.domain.repository;

import es.institutmarianao.domain.User;

public interface UserRepository {
    User getUserByUsername(String username);
    void addUser(User user);
    public void updateUser(User user);
}
