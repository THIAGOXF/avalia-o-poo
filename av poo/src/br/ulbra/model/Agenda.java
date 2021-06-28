/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

/**
 *
 * @author s.lucas
 */
public class Agenda 
{
    private int Id;
    private String Nome;
    private String Email;
    private String Senha;
    private String Telefone;
    private String Recado;
    
    public Agenda()
    {
        
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = Email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        this.Senha = Senha;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = Telefone;
    }

    public String getRecado() {
        return Recado;
    }

    public void setRecado(String Recado) {
        this.Recado = Recado;
    }

    @Override
    public String toString() {
        return "Agenda{" + "Id=" + Id + ", Nome=" + Nome + ", Email=" + Email + ", Senha=" + Senha + ", Telefone=" + Telefone + ", Recado=" + Recado + '}';
    }
    
    
}
