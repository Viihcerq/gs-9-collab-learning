package com.github.viihcerq.gs_9_collab_learning.controller;

import com.github.viihcerq.gs_9_collab_learning.model.dto.TemaResponse;
import com.github.viihcerq.gs_9_collab_learning.service.TemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TemaController {

    @Autowired
    private TemaService service;

    @GetMapping("/info")
    public ResponseEntity<List<TemaResponse>> findAll(){
        List<TemaResponse> response =
                service.getAll().stream()
                        .map(p -> new TemaResponse().toDto(p))
                        .collect(Collectors.toList());

        return ResponseEntity.ok(response);
    }


}
