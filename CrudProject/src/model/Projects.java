/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Control.Conn;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dsm-2
 */
public class Projects {
    
    private int cod;
    private String nome;
    private String descricao;
    private String responsavel;
    
    Conn con = new Conn();
    
    public Projects(){
        this(0,"","","");
    }

    public Projects(int cod, String nome, String descricao, String responsavel) {
        this.cod = cod;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    public void Cadastrar(){
        
        String sql;
        sql = "Insert into projetos(nome,descricao,responsavel)values"+"('"+ getNome() +"' ,'"+ getDescricao()+"' , '" + getResponsavel() +"')";
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registro salvo com sucesso!!");
    }
    
    public void excluir(){
        String sql;
        sql = "Delete from projetos where cod=" + getCod();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registro excluído com sucesso!!");
    }
    
    public void alterar(){
        String sql;
        sql = "Update projetos set nome='"+ getNome() +"', descricao='"+ getDescricao() +"',responsavel='" + getResponsavel() + "' where cod=" + getCod();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null,"Registro alterado com sucesso!!");
    }
    public ResultSet Consultar(){
        ResultSet tabela;
        tabela = null;
        String sql = "Select * from projetos";
        tabela = con.RetornarResultset(sql);
        return tabela;
    }
    public ResultSet consultarCompoExpecifico(){
        ResultSet tabela;
        tabela = null;
        
        try{
             String sql = "Select * from projetos where nome like '" + getNome() +"%'";
             tabela = con.RetornarResultset(sql);
        }
        catch(Exception sqle){
            JOptionPane.showMessageDialog(null,"Atenção!!!" + sqle.getMessage());
        }
        return tabela;
  
    }

    public void consultaCampoEspecifico() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
