package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Usuario;
import facilius.model.pojo.UsuarioCurso;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UsuarioCursoDAO implements BaseDAO<UsuarioCurso> {

    public void create(UsuarioCurso e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into usuario_curso(matricula,cursoid,usuarioid) values(?,?,?)");
        ps.setLong(1, e.getMatricula());
        ps.setLong(2, e.getCurso().getId());
        ps.setLong(3, e.getUsuario().getId());
        ps.execute();
        ps.close();
    }

    public List<UsuarioCurso> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<UsuarioCurso> resultados = new ArrayList<UsuarioCurso>();
        String sentence = "select * from usuario_curso where true";
        if (criteria != null) {
            Usuario usuario = (Usuario) criteria.get("usuario");
            if (usuario != null) {
                sentence += " and usuarioid = '" + usuario.getId() + "'";
            }
            String matricula = (String)criteria.get("matricula");
            if (matricula != null && !matricula.trim().isEmpty()){
                sentence += " and matricula = '" + matricula + "'";
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

    public UsuarioCurso readById(Long id) throws Exception {
        UsuarioCurso usuarioCurso = null;
        String sentence = "select * from usuario_curso where matricula = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                usuarioCurso = this.extract(resultSet);
            }
        }
        return usuarioCurso;
    }

    public void update(UsuarioCurso e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update usuario_curso set cursoid = ?, set usuarioid = ? where matricula = ?");
        ps.setLong(1, e.getCurso().getId());
        ps.setLong(2, e.getUsuario().getId());
        ps.setLong(3, e.getMatricula());
        ps.execute();
        ps.close();
    }

    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from usuario_curso where matricula = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    public UsuarioCurso extract(ResultSet resultSet) throws Exception {
        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setCurso(ServiceLocator.getCursoService().readById(resultSet.getLong("cursoid")));
        usuarioCurso.setMatricula(resultSet.getLong("matricula"));
        usuarioCurso.setUsuario(ServiceLocator.getUsuarioService().readById(resultSet.getLong("usuarioid")));
        return usuarioCurso;
    }
}
