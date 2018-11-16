/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class DAL {

    private String driver = "org.gjt.mm.mysql.Driver";
    private String url = "jdbc:mysql://localhost/TrabalhoDePoo2";
    private String usuario = "root";
    private String senha = "";
    private Connection conexao;

    //construtor privado impede a instnaciação fora desta classe
    private DAL() throws ClassNotFoundException, SQLException {
        Class.forName(driver);//carregar o driver para o java

        conexao = DriverManager.getConnection(url, usuario, senha);//abrir a conexão                
    }

    //Padrao de projeto 'Singleton'
    private static DAL dal = null;

    public static DAL getInstancia() throws ClassNotFoundException, SQLException {
        if (dal == null)//se ainda não foi instanciada, então cria
        {
            dal = new DAL();//somente aqui posso criar nova instancia
        }
        //caso contrário retorna o mesmo objeto que já criado anteriomente
        return dal;
    }

    public int insereCaixa(String descricao, int id_editar, int tamanho) throws SQLException {
        if (id_editar == tamanho + 1) {
            String sql = "INSERT INTO Caixa(descricao) VALUE(?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, descricao);
            int ret = st.executeUpdate();
            return ret;
        } else {
            String sql = "update Caixa set descricao = (?) where id = (?)";
            PreparedStatement st = conexao.prepareStatement(sql);
            st.setString(1, descricao);
            st.setInt(2, id_editar);
            int ret = st.executeUpdate();
            return ret;
        }

    }

    public int pesquisaCaixa() {
        return 0;
    }

    public ArrayList<CaixaClasse> retornaCaixa() throws SQLException {
        ArrayList<CaixaClasse> ret = new ArrayList();
        String sql = "SELECT * FROM Caixa";
        Statement st = conexao.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            ret.add(new CaixaClasse(rs.getInt("id"), rs.getString("descricao")));
        }
        return ret;
    }
}
