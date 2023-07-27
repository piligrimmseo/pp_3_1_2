package com.example.pre_project.service;

import com.example.pre_project.model.User;
import com.example.pre_project.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> index() {
        return userRepository.findAll();
    }

    @Override
    public User show(int id) {
        Optional<User> userById = userRepository.findById(id);
        return userById.orElse(null);
    }

    @Override
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void update(int id, User updateUser) {
        updateUser.setId(id);
        userRepository.save(updateUser);
    }

    @Override
    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
