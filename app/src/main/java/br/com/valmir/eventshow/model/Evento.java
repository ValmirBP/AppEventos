package br.com.valmir.eventshow.model;

import java.io.Serializable;

//Inicio da classe
// classe que controi o padrão para o JSON

public class Evento implements Serializable {

    String codigo;
    String boleto;
    String data;
    String endereco;
    String nome;
    String sobre;

    public Evento() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getBoleto() {
        return boleto;
    }

    public void setBoleto(String boleto) {
        this.boleto = boleto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobre() {
        return sobre;
    }

    public void setSobre(String sobre) {
        this.sobre = sobre;
    }
}
