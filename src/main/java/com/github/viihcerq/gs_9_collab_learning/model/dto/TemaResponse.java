package com.github.viihcerq.gs_9_collab_learning.model.dto;

import com.github.viihcerq.gs_9_collab_learning.model.Tema;

public class TemaResponse {
    private String tema;
    private String membro1;
    private String membro2;
    private String descricao;

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getMembro1() {
        return membro1;
    }

    public void setMembro1(String membro1) {
        this.membro1 = membro1;
    }

    public String getMembro2() {
        return membro2;
    }

    public void setMembro2(String membro2) {
        this.membro2 = membro2;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TemaResponse toDto(Tema Tema) {
        this.setTema(Tema.getTema());
        this.setMembro1(Tema.getMembro1());
        this.setMembro2(Tema.getMembro2());
        this.setDescricao(Tema.getDescricao());
        return this;
    }
}
