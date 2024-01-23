package Biblioteca.Dao;

import Biblioteca.Factory.ConnectionFactory;
import Biblioteca.User.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void salvarUser(Usuario usuario) {
        String sql = "insert into usuarios(usuario_nome, usuario_telefone, usuario_email, usuario_datanascimento) values (?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            // cria uma conexao com o banco de dados
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getTelefone());
            pstm.setString(3, usuario.getEmail());
            pstm.setString(4, usuario.getDataNascimento());
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null){
                    conn.close();
                }
                if (pstm != null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }

    public List <Usuario> listarUsuarios(){
        String sql ="select * from usuarios";
        List<Usuario> usuarios = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        //recupera os dados do banco
        ResultSet rst = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rst = pstm.executeQuery();
            // percorrer o resultSet pq ele vai ter muitos dados
            while (rst.next()){
                 Usuario usuario = new Usuario();
                 // recuperar o id
                usuario.setId(rst.getInt("id"));
                usuario.setNome(rst.getString("usuario_nome"));
                usuario.setTelefone(rst.getString("usuario_telefone"));
                usuario.setEmail(rst.getString("usuario_email"));
                usuario.setDataNascimento(rst.getString("usuario_datanascimento"));
                usuarios.add(usuario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (conn != null){
                    conn.close();
                }
                if (pstm!= null){
                    pstm.close();
                }
                if (rst!= null){
                    rst.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }


        return usuarios;
    }

    public void atualizarUser(Usuario usuario){
        String sql = "update usuarios set usuario_nome = ?, usuario_telefone= ?, usuario_email =?, usuario_datanascimento =? "+
                "where id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2,usuario.getTelefone());
            pstm.setString(3,usuario.getEmail());
            pstm.setString(4,usuario.getDataNascimento());
            pstm.setInt(5,usuario.getId());

            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (conn!= null){
                    conn.close();
                }
                if (pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public  void remover(int id){
        String sql = "Delete from usuarios where id =?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (conn != null){
                    conn.close();
                }
                if(pstm!= null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
