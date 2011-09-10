package facilius.model.dao;

import facilius.model.ConnectionManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Curso;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CursoDAO implements BaseDAO<Curso> {

    @Override
    public void create(Curso e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into curso(nome) values(?)");
        ps.setString(1, e.getDescricao());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from curso where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Curso> readByCriteria(Map<String, Object> criteria)
            throws Exception {

        List<Curso> resultados = new ArrayList<Curso>();
        String sentence = "select * from curso where true";
        Boolean options = (Boolean)criteria.get("options");
        Long usuarioId = (Long) criteria.get("usuarioId");
        if ((options != null && options) && usuarioId != null){
            sentence += " and curso.id not in(select usuario_curso.cursoid from usuario_curso left join curso on cursoid = curso.id where usuarioid = "+usuarioId+")";
        }else{
            if (criteria != null) {
                String nome = (String) criteria.get("nome");
                if (nome != null && !nome.trim().isEmpty()) {
                    sentence += " and nome ilike \'%" + nome + "%\'";
                }
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
    public Curso readById(Long id) throws Exception {
        Curso curso = null;
        String sentence = "select * from curso where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                curso = this.extract(resultSet);
            }
        }
        return curso;
    }

    @Override
    public void update(Curso e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update curso set nome = ? where id = ?");
        ps.setString(1, e.getDescricao());
        ps.setLong(2, e.getId());
        ps.execute();
        ps.close();
    }

    public Curso extract(ResultSet resultSet) throws Exception {
        Curso curso = new Curso();
        curso.setId(resultSet.getLong("id"));
        curso.setDescricao(resultSet.getString("nome"));
        return curso;
    }
}
