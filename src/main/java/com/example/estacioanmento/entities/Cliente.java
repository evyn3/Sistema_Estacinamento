package com.example.estacioanmento.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String cnh;
    private double credito;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String email, String telefone, String senha, String cnh, double credito) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.cnh = cnh;
        this.credito = credito;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Double.compare(credito, cliente.credito) == 0 && Objects.equals(cpf, cliente.cpf) && Objects.equals(nome, cliente.nome) && Objects.equals(email, cliente.email) && Objects.equals(telefone, cliente.telefone) && Objects.equals(senha, cliente.senha) && Objects.equals(cnh, cliente.cnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, email, telefone, senha, cnh, credito);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", senha='" + senha + '\'' +
                ", cnh='" + cnh + '\'' +
                ", credito=" + credito +
                '}';
    }
}
