package facilius.model.service;

import facilius.model.base.BaseService;
import facilius.model.dao.TipoNotaDAO;
import facilius.model.pojo.TipoNota;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TipoNotaService implements BaseService<TipoNota> {

    public void create(TipoNota e) throws Exception {
        TipoNotaDAO tipoNotaDAO = new TipoNotaDAO();
        tipoNotaDAO.create(e);
    }

    public List<TipoNota> readByCriteria(Map<String, Object> criteria) throws Exception {
        TipoNotaDAO tipoNotaDAO = new TipoNotaDAO();
        return tipoNotaDAO.readByCriteria(criteria);
    }

    public TipoNota readById(Long id) throws Exception {
        TipoNotaDAO tipoNotaDAO = new TipoNotaDAO();
        return tipoNotaDAO.readById(id);
    }

    public void update(TipoNota e) throws Exception {
        TipoNotaDAO tipoNotaDAO = new TipoNotaDAO();
        tipoNotaDAO.update(e);
    }

    public void delete(Long id) throws Exception {
        TipoNotaDAO tipoNotaDAO = new TipoNotaDAO();
        tipoNotaDAO.delete(id);
    }
    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        Map<String, String> options = new TreeMap<String, String>();
        List<TipoNota> tipoNota = this.readByCriteria(criteria);
        for (int i = 0; i < tipoNota.size(); i++) {
            TipoNota aux = tipoNota.get(i);
            options.put(aux.getId().toString(), aux.getDescricao());
        }
        return options;
    }
}