package com.github.viihcerq.gs_9_collab_learning.service;

import com.github.viihcerq.gs_9_collab_learning.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public List<User> getAll() {
        return users;
    }
}
