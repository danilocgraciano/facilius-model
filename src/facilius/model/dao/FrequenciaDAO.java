package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Frequencia;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class FrequenciaDAO implements BaseDAO<Frequencia> {

    public void create(Frequencia e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into frequencia(usuario_curso_turmaid,aulaid,status) values (?,?,?)");
        ps.setLong(1, e.getUsuarioCurso().getMatricula());
        ps.setLong(2, e.getAula().getId());
        ps.setBoolean(3, e.isStatus());
        ps.execute();
        ps.close();
    }

    public List<Frequencia> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<Frequencia> resultados = new ArrayList<Frequencia>();
        String sentence = "select * from frequencia where true";
        Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                resultados.add(this.extract(resultSet));
            }
        }
        return resultados;
    }

    public Frequencia readById(Long id) throws Exception {

        Frequencia frequencia = null;
        String sentence = "select * from frequencia where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                frequencia = this.extract(resultSet);
            }
        }
        return frequencia;
    }

    public void update(Frequencia e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update frequencia set usuario_curso_turmaid = ?, set aulaid = ?, set status = ? where id = ?");
        ps.setLong(1, e.getUsuarioCurso().getMatricula());
        ps.setLong(2, e.getAula().getId());
        ps.setBoolean(3, e.isStatus());
        ps.setLong(4, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from frequencia where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    public Frequencia extract(ResultSet resultSet) throws Exception {
        Frequencia freq = new Frequencia();
        freq.setAula(ServiceLocator.getAulaService().readById(resultSet.getLong("usuario_curso_turmaid")));
        freq.setId(resultSet.getLong("id"));
        freq.setStatus(resultSet.getBoolean("status"));
        return freq;
    }
}
