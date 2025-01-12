package com.example.intern2.service;

import com.example.intern2.entity.User;

public interface IUserService extends IService<User>{
    public User getUserById(int id);

    public default void deleteUser(int id){}

    public default void updateUser(int id){}

    public String findByUsername(String username);
    public String findByPassword(String username);

}
