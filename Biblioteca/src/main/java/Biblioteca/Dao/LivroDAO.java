package Biblioteca.Dao;

import Biblioteca.Books.Livros;
import Biblioteca.Factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    public void salvarLivro(Livros livros) {
        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "Insert into livros  (livro_titulo ,livro_autor ,livro_editora ,livro_numeroCaps " +
                ",livro_numeroPgns, livro_exemplares ) values(?,?,?,?,?,?)";
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livros.getTitulo());
            pstm.setString(2, livros.getAutor());
            pstm.setString(3, livros.getEditora());
            pstm.setInt(4, livros.getNumeroCaps());
            pstm.setInt(5, livros.getNumeroPaginas());
            pstm.setInt(6, livros.getExemplares());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public List<Livros> listarLivros(){
        String sql = "select * from livros";
        List<Livros> livros = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
         try {
             conn = ConnectionFactory.createConnectionToMySQL();
             pstm = conn.prepareStatement(sql);
             rset = pstm.executeQuery();
             while (rset.next()){
                 Livros livro = new Livros();

                livro.setId(rset.getInt("livro_id"));
                livro.setTitulo(rset.getString("livro_titulo"));
                livro.setAutor(rset.getString("livro_autor"));
                livro.setEditora(rset.getString("livro_editora"));
                livro.setNumeroCaps(rset.getInt("livro_numeroCaps"));
                livro.setNumeroPaginas(rset.getInt("livro_numeroPgns"));
                livro.setExemplares(rset.getInt("livro_exemplares"));
                livros.add(livro);

             }
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             try {
                 if (rset != null) {
                     rset.close();
                 }
                 if (pstm !=  null){
                     pstm.close();
                 }
                 if (conn != null) {
                     conn.close();
                 }
             }catch (Exception e){
                 e.printStackTrace();
             }
         }
         return livros;

    }

    public  void atualizarLivro(Livros livros){
        String sql = "update livros set livro_titulo = ?,livro_autor = ?,livro_editora = ?,livro_numeroCaps = ?" +
                ",livro_numeroPgns = ?,livro_exemplares = ? " +
                "where livro_id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, livros.getTitulo());
            pstm.setString(2, livros.getAutor());
            pstm.setString(3, livros.getEditora());
            pstm.setInt(4, livros.getNumeroCaps());
            pstm.setInt(5, livros.getNumeroPaginas());
            pstm.setInt(6, livros.getExemplares());
            pstm.setInt(7, livros.getId());
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
    public  void removerLivro(int id){
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "delete from livros where livro_id = ?";

        try {
            conn  = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(pstm != null){
                    pstm.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}
