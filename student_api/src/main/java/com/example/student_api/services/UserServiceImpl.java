package com.example.student_api.services;

import com.example.student_api.entities.UserEntity;
import com.example.student_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity Post(UserEntity params) {
        userRepository.save(params);
        return params;
    }

    @Override
    public List<UserEntity> Get() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity Get(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public UserEntity Update(UserEntity params) {

        Integer id= params.getId();
        UserEntity user = userRepository.findById(id).get();
        user.setName(params.getName());
        user.setAge(params.getAge());
        user.setGender(params.getGender());
        user.setMobile(params.getMobile());

        return userRepository.save(user);

    }

    @Override
    public String Delete(int id) {
        userRepository.deleteById(id);
        return "User(" + id + ")" + " has been deleted!";
    }
}
