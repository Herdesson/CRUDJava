/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author FLAVIO
 */
public class Client {
    private String nome;
    private String senha;
    private int idade;
    private int id;
    
    public Client(String nome, String senha, int idade, int id){
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.id = id;
    }
    public Client(String nome, String senha, int idade){
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
    }
    private Client(){
    }

    
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getNome(){
        return nome;
    }
    public int getId(){
        return id;
    }
    public String getSenha(){
        return senha;
    }
    public int getIdade(){
        return idade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.senha);
        hash = 67 * hash + this.idade;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.senha, other.senha);
    }
    public static final class ClientBuilder {
        private String nome;
        private String senha;
        private int idade;
        private int id;

        public ClientBuilder() {
        }

        public static ClientBuilder builder() {
            return new ClientBuilder();
        }

        public ClientBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public ClientBuilder senha(String senha) {
            this.senha= senha;
            return this;
        }

        public ClientBuilder idade(int idade) {
            this.idade = idade;
            return this;
        }

        public ClientBuilder id(int id) {
            this.id = id;
            return this;
        }

        public Client build() {
            return new Client(nome, senha, idade, id);
        }
    }
}
