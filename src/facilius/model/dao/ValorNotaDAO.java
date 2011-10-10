package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.TipoNota;
import facilius.model.pojo.UsuarioCursoTurma;
import facilius.model.pojo.ValorNota;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValorNotaDAO implements BaseDAO<ValorNota> {

    @Override
    public void create(ValorNota e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into valor_nota(valor,tipo_notaid,usuario_curso_turmaid) values(?,?,?)");
        ps.setFloat(1, e.getValor());
        ps.setLong(2, e.getTipoNota().getId());
        ps.setLong(3, e.getUsuarioCursoTurma().getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from valor_nota where id = ?");
        ps.setFloat(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<ValorNota> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<ValorNota> resultados = new ArrayList<ValorNota>();
        String sentence = "select * from valor_nota where true";
        if (criteria != null) {

            TipoNota tipoNota = (TipoNota) criteria.get("tipoNota");
            if (tipoNota != null) {
                sentence += " and tipo_notaid = \'" + tipoNota.getId() + "\'";
            }

            UsuarioCursoTurma usuario = (UsuarioCursoTurma) criteria.get("usuarioCursoTurma");

            if (usuario != null) {
                sentence += " and usuario_curso_turmaid = \'" + usuario.getId() + "\'";
            }

            Long matricula = (Long) criteria.get("matricula");
            if (matricula != null) {
                sentence += " and usuario_curso_turmaid in (select id from usuario_curso_turma where usuario_cursomatricula = '" + matricula + "')";
            }

            Integer ano = (Integer) criteria.get("ano");
            if(ano != null && ano > 0){
                sentence += " and usuario_curso_turmaid in (select id from usuario_curso_turma where turmaid in (select id from turma where ano = '"+ano+"'))";
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
    public ValorNota readById(Long id) throws Exception {
        ValorNota vNota = null;
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("select * from valor_nota where id = ?");
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                vNota = this.extract(resultSet);
            }
        }

        return vNota;
    }

    @Override
    public void update(ValorNota e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update valor_nota set valor = ?, set tipo_notaid = ?, set usuario_curso_turmaid = ? where id = ?");
        ps.setFloat(1, e.getValor());
        ps.setLong(2, e.getTipoNota().getId());
        ps.setLong(3, e.getUsuarioCursoTurma().getId());
        ps.setLong(4, e.getId());
        ps.execute();
        ps.close();
    }

    public ValorNota extract(ResultSet resultSet) throws Exception {
        ValorNota vNota = new ValorNota();
        vNota.setId(resultSet.getLong("id"));
        vNota.setValor(resultSet.getFloat("valor"));
        vNota.setTipoNota(ServiceLocator.getTipoNotaService().readById(resultSet.getLong("tipo_notaid")));
        vNota.setUsuarioCursoTurma(ServiceLocator.getUsuarioCursoTurmaService().readById(resultSet.getLong("usuario_curso_turmaid")));
        return vNota;
    }
}
