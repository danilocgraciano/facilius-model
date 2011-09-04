package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Disciplina;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DisciplinaDAO implements BaseDAO<Disciplina> {

    @Override
    public void create(Disciplina e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into disciplina(nome,descricao,cursoid) values(?,?,?)");
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
        ps.setLong(3, e.getCurso().getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from disciplina where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Disciplina> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        String sentence = "select * from disciplina where true";
        List<Disciplina> resultados = new ArrayList<Disciplina>();
        if (criteria != null) {
            String nome = (String) criteria.get("nome");
            if (nome != null && !nome.trim().isEmpty()) {
                sentence += " and nome ilike \'%" + nome + "%\'";
            }
            nome = (String) criteria.get("descricao");
            if (nome != null && !nome.trim().isEmpty()) {
                sentence += " and descricao ilike \'%" + nome + "%\'";
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
    public Disciplina readById(Long id) throws Exception {
        Disciplina disciplina = null;
        String sentence = "select * from disciplina where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                disciplina = this.extract(resultSet);
            }
        }
        return disciplina;
    }

    @Override
    public void update(Disciplina e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update disciplina set nome = ?, descricao = ?, cursoid = ? where id = ?");
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
        ps.setLong(3, e.getCurso().getId());
        ps.setLong(4, e.getId());
        ps.execute();
        ps.close();
    }

    public Disciplina extract(ResultSet resultSet) throws Exception {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(resultSet.getLong("id"));
        disciplina.setCurso(ServiceLocator.getCursoService().readById(resultSet.getLong("cursoid")));
        disciplina.setDescricao(resultSet.getString("descricao"));
        disciplina.setNome(resultSet.getString("nome"));
        return disciplina;
    }
}
