package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.TurmaTipoNota;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TurmaTipoNotaDAO implements BaseDAO<TurmaTipoNota> {

    public void create(TurmaTipoNota e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into turma_tipo_nota values (?,?)");
        ps.setLong(1, e.getId());
        ps.setLong(2, e.getTipoNota().getId());
        ps.execute();
        ps.close();
    }

    public List<TurmaTipoNota> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<TurmaTipoNota> resultados = new ArrayList<TurmaTipoNota>();
        String sentence = "select * from turma_tipo_nota where true";
        Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                resultados.add(this.extract(resultSet));
            }
        }
        return resultados;
    }

    public TurmaTipoNota readById(Long id) throws Exception {

        TurmaTipoNota turmaTipoNota = null;
        String sentence = "select * from turma_tipo_nota where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                turmaTipoNota = this.extract(resultSet);
            }
        }
        return turmaTipoNota;
    }

    public void update(TurmaTipoNota e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update turma_tipo_nota set turmaid = ?, set tipo_notaid = ? where turmaid = ?");
        ps.setLong(1, e.getId());
        ps.setLong(2, e.getTipoNota().getId());
        ps.setLong(3, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from turma_tipo_nota where turmaid = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();

    }

    public TurmaTipoNota extract(ResultSet resultSet) throws Exception {
        TurmaTipoNota turmaTipoNota = new TurmaTipoNota();
        turmaTipoNota.setId(resultSet.getLong("turmaid"));
        turmaTipoNota.setTipoNota(ServiceLocator.getTipoNotaService().readById(resultSet.getLong("tipo_notaid")));
        turmaTipoNota.setTurma(ServiceLocator.getTurmaService().readById(resultSet.getLong("turmaid")));
        return turmaTipoNota;
    }
}
