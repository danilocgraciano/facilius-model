package facilius.model.dao;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.TipoNota;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ldsutils.XMLPersist;

public class TipoNotaDAO implements BaseDAO<TipoNota> {

    private String path = "C:\\TipoNota.xml";

    public Map<String, Object> loadFromFile(String path) {
        Map<String, Object> conteudo = null;
        try {
            conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
        } catch (Exception e1) {
            conteudo = new HashMap<String, Object>();
            conteudo.put("sequence", new Long(0));
            conteudo.put("data", new ArrayList<TipoNota>());
        }
        return conteudo;
    }

    private void saveToFile(Long sequence, List<TipoNota> data) throws Exception {

        Map<String, Object> conteudo = new HashMap<String, Object>();
        conteudo.put("sequence", sequence);
        conteudo.put("data", data);

        XMLPersist.saveToFile(conteudo, path);

    }

    public void create(TipoNota e) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<TipoNota> data = (List<TipoNota>) conteudo.get("data");

        e.setId(++sequence);
        data.add(e);

        saveToFile(sequence, data);
    }

    public List<TipoNota> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<TipoNota> resultados = new ArrayList<TipoNota>();
        Map<String, Object> conteudo = loadFromFile(path);
        List<TipoNota> data = (List<TipoNota>) conteudo.get("data");
        for (int i = 0; i < data.size(); i++) {

            TipoNota aux = data.get(i);
            boolean ok = true;
            //Aplicar critérios...
            if (criteria != null) {
                String nome = (String) criteria.get("nome");
                if (nome != null && !aux.getDescricao().startsWith(nome)) {
                    ok = false;
                }
            }
            if (ok) {
                resultados.add(aux);
            }
        }
        return resultados;
    }

    public TipoNota readById(Long id) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        List<TipoNota> data = (List<TipoNota>) conteudo.get("data");

        TipoNota tipoNotaAux = null;

        for (int i = 0; i < data.size(); i++) {
            TipoNota tipoNota = data.get(i);
            if (tipoNota != null) {
                if (tipoNota.getId().equals(id)) {
                    tipoNotaAux = data.get(i);
                    break;
                }
            }
        }
        return tipoNotaAux;
    }

    public void update(TipoNota e) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<TipoNota> data = (List<TipoNota>) conteudo.get("data");

        for (int i = 0; i < data.size(); i++) {
            TipoNota tipoNota = data.get(i);
            if (tipoNota != null) {
                if (tipoNota.getId().equals(e.getId())) {
                    data.remove(i);
                    data.add(e);
                    break;
                }
            }
        }

        saveToFile(sequence, data);
    }

    public void delete(Long id) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<TipoNota> data = (List<TipoNota>) conteudo.get("data");

        for (int i = 0; i < data.size(); i++) {
            TipoNota tipoNota = data.get(i);
            if (tipoNota != null) {
                if (tipoNota.getId().equals(id)) {
                    data.remove(i);
                    break;
                }
            }
        }

        saveToFile(sequence, data);
    }
}
