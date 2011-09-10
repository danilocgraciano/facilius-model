package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Turma;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TurmaDAO implements BaseDAO<Turma> {

    public void create(Turma e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into turma(descricao,ano,disciplinaid,professorid) values (?,?,?,?)");
        ps.setString(1, e.getDescricao());
        ps.setInt(2, e.getAno());
        ps.setLong(3, e.getDisciplina().getId());
        ps.setLong(4, e.getProfessor().getId());
        ps.execute();
        ps.close();
    }

    public List<Turma> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<Turma> resultados = new ArrayList<Turma>();
        String sentence = "select * from turma";

        Boolean options = (Boolean) criteria.get("options");
        Long matricula = (Long) criteria.get("matricula");
        if ((options != null && options) && matricula != null) {
            sentence += " left join disciplina on disciplinaid=disciplina.id left join usuario_curso on usuario_curso.matricula =" + matricula;
            sentence += " where true and turma.id not in(select turmaid from usuario_curso_turma where true and usuario_cursomatricula = " + matricula + ")";
            sentence += " and usuario_curso.cursoid = disciplina.cursoid";
        } else {
            sentence += " where true";
            String descricao = (String) criteria.get("nome");
            if (descricao != null && !descricao.trim().isEmpty()) {
                sentence += " and descricao ilike '%" + descricao + "%'";
            }
            Long curso = (Long) criteria.get("curso");
            if (curso != null) {
                sentence += " and disciplinaid in (select id from disciplina where cursoid = " + curso + ")";
            }
            Long professorId = (Long) criteria.get("professor");
            if (professorId != null) {
                sentence += " and professorid = '" + professorId + "'";
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

    public Turma readById(Long id) throws Exception {

        Turma turma = null;
        String sentence = "select * from turma where id = ?";

        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                turma = this.extract(resultSet);
            }
        }
        return turma;
    }

    public void update(Turma e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update turma set descricao = ?,ano = ? ,disciplinaid = ?, professorid = ? where id = ?");
        ps.setString(1, e.getDescricao());
        ps.setInt(2, e.getAno());
        ps.setLong(3, e.getDisciplina().getId());
        ps.setLong(4, e.getProfessor().getId());
        ps.setLong(5, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from turma where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    public Turma extract(ResultSet resultSet) throws Exception {
        Turma turma = new Turma();
        turma.setAno(resultSet.getInt("ano"));
        turma.setDescricao(resultSet.getString("descricao"));
        turma.setDisciplina(ServiceLocator.getDisciplinaService().readById(resultSet.getLong("disciplinaid")));
        turma.setId(resultSet.getLong("id"));
        turma.setProfessor(ServiceLocator.getUsuarioService().readById(resultSet.getLong("professorid")));
        return turma;
    }
}
