/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.Controller;
import domain.Client;
import javax.swing.JOptionPane;
import repository.Repository;
import view.GetterResponse;

/**
 *
 * @author FLAVIO
 */
public class Rule {
    private static int idClientAt;
    public static boolean save(){
        String nome = GetterResponse.getNomeCad();
        String senha = GetterResponse.getSenhaCad();
        int idade = GetterResponse.getIdadeCad();
        if(nome.isEmpty() || senha.isEmpty() || idade < 1){
            JOptionPane.showMessageDialog(null,"Erro ao se cadastrar!");
            return false;
        }else{
            Controller.save(nome, senha, idade);
            return true;
        }
    }
    public static Client findById(int id){
        return Controller.findById(id);
    }
    public static void delete(){
        Integer id = idClientAt;
        if(id == 0 || id.equals(null)){
            JOptionPane.showMessageDialog(null,"Erro ao deletar!");
        }else{
            Repository.delete(id);
        }
    }
    public static void update(){
        String nome = GetterResponse.getNomeMenu();
        String senha = GetterResponse.getSenhaMenu();        
        int id = idClientAt;
        int idade = GetterResponse.getIdadeMenu();
        if(nome.isEmpty() || senha.isEmpty() || idade < 1){
            JOptionPane.showMessageDialog(null,"Erro ao editar!");
        }else{
            Controller.update(nome, senha, idade, id);
        }
    }
    public static boolean verification(){
        String nome = GetterResponse.getNomeLog();
        String senha = GetterResponse.getSenhaLog();
        if(nome.isEmpty() || senha.isEmpty()){
            JOptionPane.showMessageDialog(null,"Campos Invalidos!");
            return false;
        }else{
            for(int i = 0; i < Controller.findByAll().size(); i++){
                Client client = new Client.ClientBuilder()
                        .id(Controller.findByAll().get(i).getId())
                        .nome(Controller.findByAll().get(i).getNome())
                        .senha(Controller.findByAll().get(i).getSenha())
                        .build();
                idClientAt = client.getId();
                System.out.println(idClientAt);
                System.out.println(client.getSenha());
                if(nome.equals(client.getNome()) && senha.equals(client.getSenha())){
                    return true;
                }
            }
        }
        return false;
    }
}
