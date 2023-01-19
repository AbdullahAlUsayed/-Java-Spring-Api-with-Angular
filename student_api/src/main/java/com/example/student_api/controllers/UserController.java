package com.example.student_api.controllers;

import com.example.student_api.entities.UserEntity;
import com.example.student_api.repositories.UserRepository;
import com.example.student_api.response.ResponseHandler;
import com.example.student_api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
    }

    // Add
    @PostMapping(value = "/api/student")
    public ResponseEntity<Object> Post(@RequestBody UserEntity params) {
        try {
            UserEntity result = userService.Post(params);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

    // Get
    @GetMapping(value = "/api/student")
    public ResponseEntity<Object> Get() {
        try {
            List<UserEntity> result = userService.Get();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Get By ID
    @GetMapping(value = "/api/student/{id}")
    public ResponseEntity<Object> Get(@PathVariable int id) {
        try {
            UserEntity result = userService.Get(id);
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Update
    @PutMapping(value = "/api/student/")
    public ResponseEntity<Object> Update(@RequestBody UserEntity params) {
        try {
            UserEntity result = userService.Update(params);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

    // Delete
    @DeleteMapping(value = "/api/student/{id}")
    public ResponseEntity<Object> Delete(@PathVariable int id) {
        try {
            String result = userService.Delete(id);
            return ResponseHandler.generateResponse("Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
