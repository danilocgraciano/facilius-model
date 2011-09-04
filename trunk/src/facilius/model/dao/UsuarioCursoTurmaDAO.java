package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Turma;
import facilius.model.pojo.UsuarioCurso;
import facilius.model.pojo.UsuarioCursoTurma;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UsuarioCursoTurmaDAO implements BaseDAO<UsuarioCursoTurma> {

    public void create(UsuarioCursoTurma e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into usuario_curso_turma(usuario_cursomatricula,turmaid) values (?,?)");
        ps.setLong(1, e.getUsuarioCurso().getMatricula());
        ps.setLong(2, e.getTurma().getId());
        ps.execute();
        ps.close();
    }

    public List<UsuarioCursoTurma> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<UsuarioCursoTurma> resultados = new ArrayList<UsuarioCursoTurma>();
        String sentence = "select * from usuario_curso_turma where true";
        if (criteria != null) {
            Object obj = criteria.get("turma");
            Turma turma = null;
            if (obj != null) {
                turma = (Turma) obj;
            }

            if (turma != null) {
                sentence += " and turmaid = '" + turma.getId() + "'";
            }

            UsuarioCurso usuarioCurso = (UsuarioCurso) criteria.get("usuarioCurso");
            if (usuarioCurso != null) {
                sentence += " and usuario_cursomatricula = '" + usuarioCurso.getMatricula() + "'";
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

    public UsuarioCursoTurma readById(Long id) throws Exception {
        UsuarioCursoTurma usuarioCursoTurma = null;
        String sentence = "select * from usuario_curso_turma where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                usuarioCursoTurma = this.extract(resultSet);
            }

        }

        return usuarioCursoTurma;
    }

    public void update(UsuarioCursoTurma e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update usuario_curso_turma set usuario_cursomatricula = ?, set turmaid = ? where id = ?");
        ps.setLong(1, e.getUsuarioCurso().getMatricula());
        ps.setLong(2, e.getTurma().getId());
        ps.setLong(3, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from usuario_curso_turma where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();

    }

    public UsuarioCursoTurma extract(ResultSet resultSet) throws Exception {
        UsuarioCursoTurma usuarioCursoTurma = new UsuarioCursoTurma();

        usuarioCursoTurma.setId(resultSet.getLong("id"));

        usuarioCursoTurma.setTurma(ServiceLocator.getTurmaService().readById(resultSet.getLong("turmaid")));

        usuarioCursoTurma.setUsuarioCurso(ServiceLocator.getUsuarioCursoService().readById(resultSet.getLong("usuario_cursomatricula")));
        return usuarioCursoTurma;
    }
}
