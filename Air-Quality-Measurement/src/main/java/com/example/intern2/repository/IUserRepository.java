package com.example.intern2.repository;


import com.example.intern2.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository<User,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.id = :id")
    void DeleteUserById(@Param("id") int id);

    @Query("SELECT u FROM User u WHERE u.id = :id")
    User findUserById(@Param("id") int id);

    @Query("SELECT u.username FROM User u WHERE u.username = :username")
    String findByUsername(@Param("username") String username);

    @Query("SELECT u.password FROM User u WHERE u.username = :username")
    String findByPassword(@Param("username") String username);

    @Modifying
    @Query(value ="INSERT User(id,name,surname,email) VALUES (:id,:name,:surname,:email)", nativeQuery=true)
    void CreateUser(@Param("id") int id, @Param("name") String name, @Param("surname") String surname, @Param("email") String email);


}
