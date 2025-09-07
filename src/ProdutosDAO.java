/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
      try{
          conn = new conectaDAO().connectDB();
          String sql = "INSEERT INTO produtos (nome, valor , status) VALUES(?,?,?)";
          prep = conn.prepareStatement(sql);
          prep.setString(1,produto.getNome());
          prep.setInt(2,produto.getValor());
          prep.setString(3,produto.getStatus());
          prep.executeUpdate();
          JOptionPane.showMessageDialog(null,"Produto cadastro com sucesso!");
          
      }  catch(Exception e){
          JOptionPane.showMessageDialog(null,"Erro ao cadastrar o produto:" + e.getMessage());
      }
        
       }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        ArrayList<ProdutosDTO> lista= new ArrayList<>();
        try{
            conn= new conectaDAO().connectDB();
            String sql= "SELECT * FROM produtos";
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            while(resultset.next()){
                ProdutosDTO p = new ProdutosDTO();
                p.setId(resultset.getInt("id"));
                p.setNome(resultset.getString("nome"));
                p.setValor(resultset.getInt("valor"));
                p.setStatus(resultset.getString("status"));
                lista.add(p);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos:" + e.getMessage());
        }
        return lista;
    }
    
    
    
        
}

