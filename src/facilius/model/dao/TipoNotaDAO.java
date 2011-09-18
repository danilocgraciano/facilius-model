package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.TipoNota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TipoNotaDAO implements BaseDAO<TipoNota> {

    public void create(TipoNota e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into tipo_nota(oficial,descricao) values (?,?)");
        ps.setBoolean(1, e.isOficial());
        ps.setString(2, e.getDescricao());
        ps.execute();
        ps.close();
    }

    public List<TipoNota> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<TipoNota> resultados = new ArrayList<TipoNota>();
        String sentence = "select * from tipo_nota where true";
        if (criteria != null) {
            String nome = (String) criteria.get("nome");
            if (nome != null && !nome.trim().isEmpty()) {
                sentence += " and descricao ilike \'%" + nome + "%\'";
            }

            Long usuarioId = (Long) criteria.get("usuarioId");
            if (usuarioId != null){
                sentence += " and id not in (select tipo_notaid from valor_nota where usuario_curso_turmaid = "+usuarioId+")";
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

    public TipoNota readById(Long id) throws Exception {
        TipoNota tipoNota = null;

        String sentence = "select * from tipo_nota where id = ?";
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        ps.setLong(1, id);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                tipoNota = this.extract(resultSet);
            }
        }
        ps.close();
        return tipoNota;
    }

    public void update(TipoNota e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update tipo_nota set oficial = ?, descricao = ? where id = ?");
        ps.setBoolean(1, e.isOficial());
        ps.setString(2, e.getDescricao());
        ps.setLong(3, e.getId());
        ps.execute();
        ps.close();
    }

    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from tipo_nota where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    public TipoNota extract(ResultSet resultSet) throws Exception {
        TipoNota tiponota = new TipoNota();
        tiponota.setDescricao(resultSet.getString("descricao"));
        tiponota.setId(resultSet.getLong("id"));
        tiponota.setOficial(resultSet.getBoolean("oficial"));
        return tiponota;
    }
}
