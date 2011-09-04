package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Instituicao;
import java.sql.PreparedStatement;

public class InstituicaoDAO implements BaseDAO<Instituicao> {

    @Override
    public void create(Instituicao e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into instituicao(nome,endereco,bairro,numero,telefone1,telefone2,cidadeid) values(?,?,?,?,?,?,?)");
        ps.setString(1, e.getNome());
        ps.setString(2, e.getEndereco());
        ps.setString(3, e.getBairro());
        ps.setString(4, e.getNumero());
        ps.setString(5, e.getTelefone1());
        ps.setString(6, e.getTelefone2());
        ps.setLong(7, e.getCidade().getId());
//        ps.setByte(8, e.getLogo());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from instituicao where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Instituicao> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<Instituicao> resultados = new ArrayList<Instituicao>();
        String sentence = "select * from instituicao where true";
        if (criteria != null){
            String nome = (String)criteria.get("nome");
            if (nome != null && !nome.trim().isEmpty())
                sentence += " and nome ilike '%"+nome+"%'";
        }
        java.sql.Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                resultados.add(this.extract(resultSet));
            }
        }
        return resultados;
    }

    @Override
    public Instituicao readById(Long id) throws Exception {
        Instituicao instituicao = null;
        String sentence = "select * from instituicao where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                instituicao = this.extract(resultSet);
            }
        }
        return instituicao;
    }

    @Override
    public void update(Instituicao e) throws Exception {
        String sentence = "update instituicao set nome = ?, endereco = ?,bairro = ?,numero = ?,telefone1 = ?,telefone2 = ?,cidadeid = ?,email = ? where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setString(1, e.getNome());
        ps.setString(2, e.getEndereco());
        ps.setString(3, e.getBairro());
        ps.setString(4, e.getNumero());
        ps.setString(5, e.getTelefone1());
        ps.setString(6, e.getTelefone2());
        ps.setLong(7, e.getCidade().getId());
//        ps.setByte(8, e.getLogo());
        ps.setString(8, e.getEmail());
        ps.setLong(9, e.getId());
        ps.execute();
        ps.close();
    }

    public Instituicao extract(ResultSet resultSet) throws Exception {
        Instituicao instituicao = new Instituicao();
        instituicao.setBairro(resultSet.getString("bairro"));
        instituicao.setCidade(ServiceLocator.getCidadeService().readById(resultSet.getLong("cidadeid")));
        instituicao.setEmail(resultSet.getString("email"));
        instituicao.setEndereco(resultSet.getString("endereco"));
        instituicao.setId(resultSet.getLong("id"));
        instituicao.setLogo(resultSet.getByte("logo"));
        instituicao.setNome(resultSet.getString("nome"));
        instituicao.setNumero(resultSet.getString("numero"));
        instituicao.setTelefone1(resultSet.getString("telefone1"));
        instituicao.setTelefone2(resultSet.getString("telefone2"));
        return instituicao;
    }
}
