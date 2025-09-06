package jdbc.dao;

import domin.Cliente;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao implements IClienteDao {
    @Override
    public Integer cadastrar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlInsert();
            stm = connection.prepareStatement(sql);
            adcionarParametrosInsert(stm,cliente);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }


    }


    @Override
    public Integer atualizar(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlUpdate();
            stm = connection.prepareStatement(sql);
            adcionarParametrosUpdate(stm,cliente);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }
    }



    @Override
    public Cliente buscar(String codigo) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Cliente cliente =null;
        try{
            connection= ConnectionFactory.getConnection();

            String sql = getSqlSelect();
            stm = connection.prepareStatement(sql);
            adcionarParametrosSelect(stm,codigo);
            rs = stm.executeQuery();
            if (rs.next()){
                cliente = new Cliente();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String cd = rs.getString("CODIGO");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(codigo);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            closeConnection(connection,stm,rs);
        }
        return cliente;
    }


    @Override
    public List<Cliente> buscarTodos() throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Cliente> list = new ArrayList<>();
        Cliente cliente =null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlSelectAll();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()){
                cliente = new Cliente();
                Long id = rs.getLong("ID");
                String nome = rs.getString("NOME");
                String cd = rs.getString("CODIGO");
                cliente.setId(id);
                cliente.setNome(nome);
                cliente.setCodigo(cd);
                list.add(cliente);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            closeConnection(connection,stm,rs);
        }
        return list;
    }


    @Override
    public Integer excluir(Cliente cliente) throws Exception {
        Connection connection = null;
        PreparedStatement stm = null;
        try{
            connection= ConnectionFactory.getConnection();
            String sql = getSqlDelete();
            stm = connection.prepareStatement(sql);
            adcionarParametrosDelete(stm,cliente);
            return stm.executeUpdate();
        }catch (Exception e){
            throw e;
        }finally {
            closeConnection(connection,stm,null);
        }
    }

    //inserir
    private String getSqlInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO TB_CLIENTE(ID,CODIGO,NOME)");
        sb.append("VALUES(NEXTVAL('SQ_CLIENTE'),?,?)");
        return sb.toString();
    }

    private void adcionarParametrosInsert(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1,cliente.getCodigo());
        stm.setString(2,cliente.getNome());
    }
    //att
    private String getSqlUpdate() {
        StringBuilder sb = new StringBuilder();
        sb.append("Update TB_CLIENTE ");
        sb.append("SET NOME = ?, CODIGO = ? ");
        sb.append("WHERE ID = ?");
        return sb.toString();

    }
    private void adcionarParametrosUpdate(PreparedStatement stm, Cliente cliente) throws SQLException {
        stm.setString(1,cliente.getNome());
        stm.setString(2,cliente.getCodigo());
        stm.setLong(3,cliente.getId());
    }
    //buscar
    private String getSqlSelect() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_CLIENTE ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    private void adcionarParametrosSelect(PreparedStatement stm, String codigo) throws SQLException {
        stm.setString(1,codigo);
    }
    //todos
    private String getSqlSelectAll() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM TB_CLIENTE");
        return sb.toString();
    }
    //excluir
    private String getSqlDelete() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM TB_CLIENTE ");
        sb.append("WHERE CODIGO = ?");
        return sb.toString();
    }

    private void adcionarParametrosDelete(PreparedStatement stm, Cliente cliente)  throws SQLException{
        stm.setString(1,cliente.getCodigo());
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
