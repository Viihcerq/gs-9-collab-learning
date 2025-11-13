package com.github.viihcerq.gs_9_collab_learning.service;

import com.github.viihcerq.gs_9_collab_learning.model.Tema;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemaService {

    private List<Tema> Temas = new ArrayList<>();

    public List<Tema> getAll() {
        return Temas;
    }
}
