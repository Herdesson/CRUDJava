/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Client;
import java.util.List;
import repository.Repository;

/**
 *
 * @author FLAVIO
 */
public class Controller {
    
    public static void save(String nome, String senha, int idade){
        Repository.save(new Client(nome, senha, idade));
    }
    public static Client findById(int id){
        return Repository.findById(id);
    }
    public static void delete(int id){
        Repository.delete(id);
    }
    public static List<Client> findByAll(){
         return Repository.findByAll();
    }
    public static void update(String nome, String senha, int idade, int id){
        Repository.update(new Client(nome, senha, idade, id));
    }        
}
