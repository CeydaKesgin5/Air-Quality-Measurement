package com.example.intern2.service.impl;


import com.example.intern2.common.GeneralException;
import com.example.intern2.entity.User;
import com.example.intern2.repository.IUserRepository;
import com.example.intern2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;





    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {//kayıt

        return userRepository.save(user);

    }




    @Override
    public User getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
            throw new GeneralException("Invalid not found!");
        }
        return user.get();
    }

    @Override
    public List<User> getAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new GeneralException("Invalid not found!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public User update(Integer id, User updatedUser) {
        User existingUser=userRepository.findById(id).orElseThrow(()
                -> new GeneralException("Invalid not found!"));

        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }
    @Override
    public void add() {
        userRepository.save(new User());
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(int id) {
        IUserService.super.deleteUser(id);
    }

    @Override
    public void updateUser(int id) {
        IUserService.super.updateUser(id);
    }

    @Override
    public String findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public String findByPassword(String username) {
        return userRepository.findByPassword(username);
    }


}
