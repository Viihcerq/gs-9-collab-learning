package com.github.viihcerq.gs_9_collab_learning.controller;

import com.github.viihcerq.gs_9_collab_learning.model.dto.UserResponse;
import com.github.viihcerq.gs_9_collab_learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/info")
    public ResponseEntity<List<UserResponse>> findAll(){
        List<UserResponse> response =
                service.getAll().stream()
                        .map(p -> new UserResponse().toDto(p))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }


}
