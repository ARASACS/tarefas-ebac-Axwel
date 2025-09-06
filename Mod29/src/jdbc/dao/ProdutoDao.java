package jdbc.dao;

import domin.Produto;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements IProdutoDao{
    @Override
    public Integer cadastrar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adcionarParametrosInsert(stm,produto);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }
    }


    @Override
    public Integer atualizar(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adcionarParametrosUpdate(stm,produto);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }
    }

    @Override
    public Produto buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Produto produto =null;
        try{
            connection= ConnectionFactory.getConnection();

            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adcionarParametrosSelect(stm,codigo);
            rs = stm.executeQuery();
            if (rs.next()){
                produto = new Produto();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                Long preco = rs.getLong("PRECO");
                String cd= rs.getString("CODIGO");

                produto.setId(id);
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setCodigo(cd);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            closeConnection(connection,stm,rs);
        }
        return produto;
    }



    @Override
    public List<Produto> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Produto> list = new ArrayList<>();
        Produto produto =null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                produto = new Produto();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                Long preco = rs.getLong("PRECO");
                String cd = rs.getString("CODIGO");
                produto.setId(id);
                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setCodigo(cd);
                list.add(produto);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            closeConnection(connection,stm,rs);
        }
        return list;
    }


    @Override
    public Integer excluir(Produto produto) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adcionarParametrosDelete(stm,produto);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }
    }


    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_PRODUTO(ID,CODIGO,PRECO,NOME)");
        sb.append("VALUES(NEXTVAL('SQ_PRODUTO'),?,?,?)");
        return sb.toString();
    }


    private void adcionarParametrosInsert(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1,produto.getCodigo());
        stm.setLong(2,produto.getPreco());
        stm.setString(3,produto.getNome());
    }

    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("Update TB_PRODUTO ");
        sb.append("SET NOME = ?, CODIGO = ?, PRECO = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();

    }
    private void adcionarParametrosUpdate(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1,produto.getNome());
        stm.setString(2,produto.getCodigo());
        stm.setLong(3,produto.getPreco());
        stm.setLong(4,produto.getId());
    }

    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTO ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }
    private void adcionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1,codigo);
    }

    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_PRODUTO");
        return sb.toString();
    }


    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_PRODUTO ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    private void adcionarParametrosDelete(PreparedStatement stm, Produto produto) throws SQLException {
        stm.setString(1,produto.getCodigo());

    }

    private void closeConnection(Connection connection, PreparedStatement stm, ResultSet rs) {
        try {
            if(rs!=null && !rs.isClosed()){
                rs.close();
            }
            if(stm!=null && !stm.isClosed()){
                stm.close();
            }
            if(connection!=null && !connection.isClosed()){
                connection.close();
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }
    }
}
