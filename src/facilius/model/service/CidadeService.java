package facilius.model.service;

import facilius.model.base.BaseService;
import facilius.model.dao.CidadeDAO;
import facilius.model.pojo.Cidade;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CidadeService implements BaseService<Cidade> {

    @Override
    public void create(Cidade e) throws Exception {
        CidadeDAO dao = new CidadeDAO();
        dao.create(e);
    }

    @Override
    public void delete(Long id) throws Exception {
        CidadeDAO dao = new CidadeDAO();
        dao.delete(id);
    }

    @Override
    public List<Cidade> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        CidadeDAO dao = new CidadeDAO();
        return dao.readByCriteria(criteria);
    }

    @Override
    public Cidade readById(Long id) throws Exception {
        CidadeDAO dao = new CidadeDAO();
        return dao.readById(id);
    }

    @Override
    public void update(Cidade e) throws Exception {
        CidadeDAO dao = new CidadeDAO();
        dao.update(e);
    }

    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        Map<String, String> options = new TreeMap<String, String>();
        List<Cidade> cidades = this.readByCriteria(criteria);
        for (int i = 0; i < cidades.size(); i++) {
            Cidade aux = cidades.get(i);
            options.put(aux.getId().toString(), aux.getDescricao());
        }
        return options;
    }
}
