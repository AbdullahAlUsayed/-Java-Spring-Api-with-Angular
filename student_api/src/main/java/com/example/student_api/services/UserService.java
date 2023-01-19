package com.example.student_api.services;

import com.example.student_api.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService {
    UserEntity Post(UserEntity params);

    List<UserEntity> Get();

    UserEntity Get(int id);

    UserEntity Update(UserEntity params);

    String Delete(int id);
}
