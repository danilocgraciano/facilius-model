package facilius.model.dao;

import facilius.model.ConnectionManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Usuario;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UsuarioDAO implements BaseDAO<Usuario> {

    @Override
    public void create(Usuario e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into usuario(login,nome,senha,email,tipo) values(?,?,?,?,?)");
        ps.setString(1, e.getLogin());
        ps.setString(2, e.getNome());
//        ps.setByte(3, e.getFoto());
        ps.setString(3, e.getSenha());
        ps.setString(4, e.getEmail());
        ps.setInt(5, e.getTipo());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from usuario where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Usuario> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<Usuario> resultados = new ArrayList<Usuario>();
        String sentence = "select * from usuario where true";
        if (criteria != null) {
            String nome = (String) criteria.get("nome");
            if (nome != null && !nome.trim().isEmpty()) {
                sentence += " and nome ilike '%" + nome + "%'";
            }
            Integer tipo = (Integer) criteria.get("tipo");
            if (tipo != null) {
                sentence += " and tipo = " + tipo + "";

            }
        }
        Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                resultados.add(this.extract(resultSet));
            }
        }
        return resultados;
    }

    @Override
    public Usuario readById(Long id) throws Exception {
        Usuario user = null;
        String sentence = "select * from usuario where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                user = this.extract(resultSet);
            }
        }
        return user;
    }

    @Override
    public void update(Usuario e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update usuario set login = ?, nome = ?, senha = ?, email = ?, tipo = ? where id = ?");
        ps.setString(1, e.getLogin());
        ps.setString(2, e.getNome());
//        ps.setByte(3, e.getFoto());
        ps.setString(3, e.getSenha());
        ps.setString(4, e.getEmail());
        ps.setInt(5, e.getTipo());
        ps.setLong(6, e.getId());
        ps.execute();
        ps.close();
    }

    public Usuario extract(ResultSet resultSet) throws Exception {
        Usuario user = new Usuario();
        user.setEmail(resultSet.getString("email"));
        user.setFoto(resultSet.getByte("foto"));
        user.setId(resultSet.getLong("id"));
        user.setLogin(resultSet.getString("login"));
        user.setNome(resultSet.getString("nome"));
        user.setSenha(resultSet.getString("senha"));
        user.setTipo(resultSet.getInt("tipo"));
        return user;
    }
}
