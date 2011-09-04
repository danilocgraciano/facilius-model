package facilius.model.dao;

import facilius.model.ConnectionManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Cidade;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CidadeDAO implements BaseDAO<Cidade> {

    @Override
    public void create(Cidade e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into cidade values(?,?)");
        ps.setString(1, e.getDescricao());
        ps.setString(2, e.getUf());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from cidade where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Cidade> readByCriteria(Map<String, Object> criteria)
            throws Exception {

        List<Cidade> resultados = new ArrayList<Cidade>();

        String sentence = "select * from cidade where true";
        if (criteria != null) {
            String nome = (String) criteria.get("nome");
            if (nome != null && !nome.trim().isEmpty()) {
                sentence += " and descricao ilike \'%" + nome + "%\'";
            }
        }

        Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                Cidade cidade = this.extract(resultSet);
                resultados.add(cidade);
            }
        }

        return resultados;
    }

    @Override
    public Cidade readById(Long id) throws Exception {
        Cidade cidade = null;
        String sentence = "select * from cidade where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                cidade = this.extract(resultSet);
            }
        }
        return cidade;
    }

    @Override
    public void update(Cidade e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update cidade set descricao = ?, set uf = ? where id = ?");
        ps.setString(1, e.getDescricao());
        ps.setString(2, e.getUf());
        ps.setLong(3, e.getId());
        ps.execute();
        ps.close();
    }

    public Cidade extract(ResultSet resultSet) throws Exception {
        Cidade cidade = new Cidade();
        cidade.setId(resultSet.getLong("id"));
        cidade.setDescricao(resultSet.getString("descricao"));
        cidade.setUf(resultSet.getString("uf"));
        return cidade;
    }
}
