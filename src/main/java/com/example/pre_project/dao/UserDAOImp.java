package com.example.pre_project.dao;

import com.example.pre_project.Model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImp implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    List<User> users = new ArrayList<>();


    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(int id, User updateUser) {

        User user = entityManager.find(User.class, id); // по id определили, какой именно юзер был изменен и передан в аргумент
        user.setName(updateUser.getName()); //этому найденному юзеру устанавливаем значения того юзера, который пришел из формы
        user.setSurname(updateUser.getSurname());
        user.setAge(updateUser.getAge());
        entityManager.persist(user);
    }

    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

}
