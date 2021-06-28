/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.sql.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author s.lucas
 */
public class AgendaDao 
{
    Connection con;
    
    public AgendaDao() throws SQLException
    {
        con = ConnFac.getConnection();
    }
    
    public boolean checkLogin(String Email, String Senha) 
    {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try
        {
            stmt = con.prepareStatement("SELECT * FROM tbagenda WHERE Email = ? AND Senha = ?");
            stmt.setString(1, Email);
            stmt.setString(2, Senha);
            
            rs = stmt.executeQuery();
            
            if(rs.next())
            {
                check = true;
            }
        }
        catch (SQLException e)
        {
             JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());       
        }
        
        return check;
    }
    
    public void create(Agenda a)
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = con.prepareStatement("INSERT INTO tbagenda (Nome, Email, Senha, Telefone, Recado) VALUE (?,?,?,?,?)");
            
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getSenha());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getRecado());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pessoa " + a.getNome() + " de ID " + a.getId() + " salva com sucesso");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }
        finally
        {
            ConnFac.closeConnection(con, stmt);
        }
    }
    
    
    public void update(Agenda a)
    {
       PreparedStatement stmt = null;
        try
        {
            stmt = con.prepareStatement("UPDATE tbagenda SET Nome = ?, Email = ?, Senha = ?, Telefone = ?, Recado = ? WHERE Id = ?");
            
            stmt.setString(1, a.getNome());
            stmt.setString(2, a.getEmail());
            stmt.setString(3, a.getSenha());
            stmt.setString(4, a.getTelefone());
            stmt.setString(5, a.getRecado());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pessoa " + a.getNome() + " de ID " + a.getId() + " modificada com sucesso");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }
        finally
        {
            ConnFac.closeConnection(con, stmt);
        } 
    }
   
    
    public void delete(Agenda a)
    {
        PreparedStatement stmt = null;
        try
        {
            stmt = con.prepareStatement("DELETE FROM tbagenda WHERE id = ?");
            
            stmt.setInt(1, a.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pessoa " + a.getNome() + " de ID " + a.getId() + " excluida com sucesso");
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }
        finally
        {
            ConnFac.closeConnection(con, stmt);
        }
    }
    
    
    public ArrayList<Agenda> read()
    {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Agenda> agen = new ArrayList<>();
        try
        {
            stmt = con.prepareStatement("SELECT * FROM tbagenda ORDER BY id ASC");
            rs = stmt.executeQuery();
            while(rs.next())
            {
                Agenda agendas = new Agenda();
                
                agendas.setId(rs.getInt("Id"));
                agendas.setNome(rs.getString("Nome"));
                agendas.setEmail(rs.getString("Email"));
                agendas.setSenha(rs.getString("Senha"));
                agendas.setTelefone(rs.getString("Telefone"));
                agendas.setRecado(rs.getString("Recado"));
                
                agen.add(agendas);
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        finally
        {
            ConnFac.closeConnection(con, stmt, rs);
        }
        return (ArrayList<Agenda>) agen;
    
    }
    
    
    public ArrayList<Agenda> readPesq(String nome)
    {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Agenda> agen = new ArrayList<>();
        try
        {
            stmt = con.prepareStatement("SELECT * FROM tbagenda WHERE nome LIKE ?");
            
            stmt.setString(1, "%" + nome + "%");
            
            rs = stmt.executeQuery();
            
            while(rs.next())
            {
                Agenda agendas = new Agenda();
                
                agendas.setId(rs.getInt("Id"));
                agendas.setNome(rs.getString("Nome"));
                agendas.setEmail(rs.getString("Email"));
                agendas.setSenha(rs.getString("Senha"));
                agendas.setTelefone(rs.getString("Telefone"));
                agendas.setRecado(rs.getString("Recado"));
                
                agen.add(agendas);
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
        finally
        {
            ConnFac.closeConnection(con, stmt, rs);
        }
        
        return (ArrayList<Agenda>) agen;
    
    }
}
