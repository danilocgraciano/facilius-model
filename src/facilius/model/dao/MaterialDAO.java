package facilius.model.dao;

import facilius.model.ConnectionManager;
import facilius.model.ServiceLocator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.Material;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MaterialDAO implements BaseDAO<Material> {

    @Override
    public void create(Material e) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("insert into material(nome,descricao,aulaid) values(?,?,?)");
        ps.setString(1, e.getNome());
        ps.setString(2, e.getDescricao());
//        ps.setByte(3, nu);
        ps.setLong(3, e.getAula().getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id) throws Exception {
        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("delete from material where id = ?");
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    @Override
    public List<Material> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        List<Material> resultados = new ArrayList<Material>();
        String sentence = "select * from material where true";
        if (criteria != null){
            Long aulaId = (Long) criteria.get("aulaId");
            if (aulaId != null && aulaId > 0){
                sentence += " and aulaid = '"+aulaId+"'";
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
    public Material readById(Long id) throws Exception {
        Material material = null;

        String sentence = "select * from material where id = ?";
        PreparedStatement stmt = ConnectionManager.getInstance().getConnection().prepareStatement(sentence);
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();
        if (resultSet != null) {
            while (resultSet.next()) {
                material = this.extract(resultSet);
            }
        }
        return material;
    }

    @Override
    public void update(Material e) throws Exception {
//        PreparedStatement ps = ConnectionManager.getInstance().getConnection().prepareStatement("update material set nome = ?, set aulaid = ? where id = ?");
//        ps.setString(1, e.getNome());
//        ps.setString(2, e.getDescricao());
////        ps.setByte(3, e.getArquivo());
//        ps.setLong(2, e.getAula().getId());
//        ps.execute();
//        ps.close();
    }

    public Material extract(ResultSet resultSet) throws Exception {
        Material material = new Material();
//        material.setArquivo(resultSet.getByte("arquivo"));
        material.setAula(ServiceLocator.getAulaService().readById(resultSet.getLong("aulaid")));
        material.setDescricao(resultSet.getString("descricao"));
        material.setId(resultSet.getLong("id"));
        material.setNome(resultSet.getString("nome"));
        return material;
    }
}
