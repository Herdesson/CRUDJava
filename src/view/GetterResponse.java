/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author FLAVIO
 */
public class GetterResponse {
    
    public static String getNomeCad(){
        return Cadastro.getNome;
    }
    public static String getSenhaCad(){
        return Cadastro.getSenha;
    }
    public static int getIdadeCad(){
        return Cadastro.getIdade;
    }
    public static String getNomeLog(){
        return Login.nome;
    }
    public static String getSenhaLog(){
        return Login.senha;
    }
    public static String getNomeMenu(){
        return Menu.nome;
    }
    public static String getSenhaMenu(){
        return Menu.senha;
    }
    public static int getIdadeMenu(){
        return Menu.idade;
    }
}
