package br.com.fiap.CheckpointUmBD.dao;

import br.com.fiap.CheckpointUmBD.entity.Vistoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VistoriaDao {

    private Connection conexao;

    public void inserir(Vistoria vistoria) throws SQLException {
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "insert into vistoria (status, id, data)" +
                "values(?,?,?)";

        comandoSql = conexao.prepareStatement(sql);
        comandoSql.setString(1, vistoria.getStatus());
        comandoSql.setInt(2, vistoria.getId());
        comandoSql.setString(3, vistoria.getData());
        comandoSql.executeUpdate();
        conexao.close();
        comandoSql.close();
    }

    public void alterar(Vistoria vistoria){
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "update vistoria set status = ?, set data = ? where id = ?";

        try{
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, vistoria.getStatus());
            comandoSql.setString(2, vistoria.getData());
            comandoSql.setInt(3, vistoria.getId());
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();

        }catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void excluir(int id){
        conexao = GerenciadorBD.obterConexao();
        PreparedStatement comandoSql = null;
        String sql = "delete from vistoria where id = ?";

        try{
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1,id);
            comandoSql.executeUpdate();
            conexao.close();
            comandoSql.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Vistoria buscarPorId(int id) throws SQLException{
        Vistoria vistoria = new Vistoria();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBD.obterConexao();

        try{
            String sql = "Select * from vistoria where id = ?";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setInt(1, id);
            ResultSet rs = comandoSql.executeQuery();

            if(rs.next()){
                vistoria.setId(rs.getInt(1));
                vistoria.setStatus((rs.getString(2)));
                vistoria.setData((rs.getString(3)));
            }
            comandoSql.close();
            conexao.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vistoria;
    }


    public List<Vistoria> buscarVistoria(){
        List<Vistoria> vistorias = new ArrayList<>();
        PreparedStatement comandoSql = null;
        conexao = GerenciadorBD.obterConexao();

        try{
            String sql = "select * from vistoria order by id";
            comandoSql = conexao.prepareStatement(sql);
            ResultSet rs = comandoSql.executeQuery();

            while(rs.next()){
                Vistoria vistoria = new Vistoria();

                vistoria.setId(rs.getInt(1));
                vistoria.setStatus(rs.getString(2));
                vistoria.setData(rs.getString(3));


                vistorias.add(vistoria);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vistorias;
    }


}
