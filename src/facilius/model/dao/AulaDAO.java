package facilius.model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import facilius.model.pojo.Aula;
import facilius.util.TrataData;
import java.sql.PreparedStatement;
import java.util.Date;

public class AulaDAO implements BaseDAO<Aula> {

    @Override
    public void create(Aula e) throws Exception {

        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into aula(titulo,descricao,data,turmaid) values(?,?,?,?)");
        ps.setString(1, e.getTitulo());
        ps.setString(2, e.getDescricao());
        ps.setDate(3, new java.sql.Date(e.getData().getTime()));
        ps.setLong(4, e.getTurma().getId());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from aula where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Aula> readByCriteria(Map<String, Object> criteria)
            throws Exception {

        List<Aula> resultados = new ArrayList<Aula>();
        String sentence = "select * from aula where true ";

        if (criteria != null) {
            String nome = (String) criteria.get("nome");
            if (nome != null && !nome.trim().isEmpty()) {
                sentence += " and titulo ilike '%" + nome + "%'";
            }
            Long turma = (Long)criteria.get("turma");
            if (turma != null){
                sentence += " and turmaid = '" + turma + "'";
            }
            Long professor = (Long)criteria.get("professorid");
            if (professor != null){
                sentence += " and turmaid in (select id from turma where professorid = " + professor + ")";
            }

            String semFrequencia = (String) criteria.get("sem");
            if (semFrequencia != null && !semFrequencia.trim().isEmpty()){
                sentence += " and id not in (select aulaid from frequencia)";
            }

            Integer ano = (Integer) criteria.get("ano");
            if (ano != null && ano > 0){
                sentence += " and extract(year from data) = '"+ano+"'";
            }

            Date dataInicio = (Date) criteria.get("dataInicial");
            if (dataInicio != null){
                sentence += " and data >= '" + TrataData.dateToStringDB(dataInicio)+"'";
            }

            Date dataFim = (Date) criteria.get("dataFinal");
            if (dataFim != null){
                sentence += " and data <= '" + TrataData.dateToStringDB(dataFim)+"'";
            }

            //tem que ser a ultima opcao, por causa do order by
            Long matricula = (Long) criteria.get("matricula");
            if (matricula != null){
                sentence += " and turmaid in (select turmaid from usuario_curso_turma where true and usuario_cursomatricula = "+matricula+") order by data desc";
            }


            
        }


        java.sql.Statement stmt = ConnectionManager.getInstance().getConnection().createStatement();
        ResultSet resultSet = stmt.executeQuery(sentence);
        if (resultSet != null) {
            while (resultSet.next()) {
                Aula aula = this.extract(resultSet);
                resultados.add(aula);
            }
        }
        return resultados;
    }

    @Override
    public Aula readById(Long id) throws Exception {
        Aula aulaAux = null;

        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("select * from aula where id = ?");
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                aulaAux = this.extract(resultSet);
            }
        }
        return aulaAux;
    }

    @Override
    public void update(Aula e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update aula set titulo = ?, descricao = ?, data = ?,turmaid = ? where id = ? ");
        ps.setString(1, e.getTitulo());
        ps.setString(2, e.getDescricao());
        ps.setDate(3, new java.sql.Date(e.getData().getTime()));
        ps.setLong(4, e.getTurma().getId());
        ps.setLong(5, e.getId());
        ps.execute();
        ps.close();

    }
    
    @Override
    public Aula extract(ResultSet resultSet) throws Exception {
        Aula aula = new Aula();
        aula.setId(resultSet.getLong("id"));
        aula.setData(new java.util.Date(resultSet.getTimestamp("data").getTime()));
        aula.setDescricao(resultSet.getString("descricao"));
        aula.setTitulo(resultSet.getString("titulo"));
        aula.setTurma(ServiceLocator.getTurmaService().readById(resultSet.getLong("turmaid")));
        return aula;
    }
}
