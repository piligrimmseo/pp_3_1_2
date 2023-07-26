package com.example.pre_project.service;



import com.example.pre_project.Model.User;

import java.util.List;

public interface UserService {
    public List<User> index();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updateUser);

    public void delete(int id);
}
