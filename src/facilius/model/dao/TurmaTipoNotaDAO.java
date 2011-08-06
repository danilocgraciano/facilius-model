package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.TurmaTipoNota;

public class TurmaTipoNotaDAO implements BaseDAO<TurmaTipoNota> {


    private String path = "C:\\TurmaTipoNota.xml";

    public Map<String, Object> loadFromFile(String path) {
        Map<String, Object> conteudo = null;
        try {
            conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
        } catch (Exception e1) {
            conteudo = new HashMap<String, Object>();
            conteudo.put("sequence", new Long(0));
            conteudo.put("data", new ArrayList<TurmaTipoNota>());
        }
        return conteudo;
    }

    private void saveToFile(Long sequence, List<TurmaTipoNota> data) throws Exception {

        Map<String, Object> conteudo = new HashMap<String, Object>();
        conteudo.put("sequence", sequence);
        conteudo.put("data", data);

        XMLPersist.saveToFile(conteudo, path);

    }

    public void create(TurmaTipoNota e) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<TurmaTipoNota> data = (List<TurmaTipoNota>) conteudo.get("data");

        e.setId(++sequence);
        data.add(e);

        saveToFile(sequence, data);
    }

    public List<TurmaTipoNota> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<TurmaTipoNota> resultados = new ArrayList<TurmaTipoNota>();
        Map<String, Object> conteudo = loadFromFile(path);
        List<TurmaTipoNota> data = (List<TurmaTipoNota>) conteudo.get("data");
        for (int i = 0; i < data.size(); i++) {

            TurmaTipoNota aux = data.get(i);
            boolean ok = true;
            //Aplicar critérios...
            if (ok) {
                resultados.add(aux);
            }
        }
        return resultados;
    }

    public TurmaTipoNota readById(Long id) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        List<TurmaTipoNota> data = (List<TurmaTipoNota>) conteudo.get("data");

        TurmaTipoNota TurmaTipoNotaAux = null;

        for (int i = 0; i < data.size(); i++) {
            TurmaTipoNota TurmaTipoNota = data.get(i);
            if (TurmaTipoNota != null) {
                if (TurmaTipoNota.getId().equals(id)) {
                    TurmaTipoNotaAux = data.get(i);
                    break;
                }
            }
        }
        return TurmaTipoNotaAux;
    }

    public void update(TurmaTipoNota e) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<TurmaTipoNota> data = (List<TurmaTipoNota>) conteudo.get("data");

        for (int i = 0; i < data.size(); i++) {
            TurmaTipoNota TurmaTipoNota = data.get(i);
            if (TurmaTipoNota != null) {
                if (TurmaTipoNota.getId().equals(e.getId())) {
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
        List<TurmaTipoNota> data = (List<TurmaTipoNota>) conteudo.get("data");

        for (int i = 0; i < data.size(); i++) {
            TurmaTipoNota TurmaTipoNota = data.get(i);
            if (TurmaTipoNota != null) {
                if (TurmaTipoNota.getId().equals(id)) {
                    data.remove(i);
                    break;
                }
            }
        }

        saveToFile(sequence, data);
    }

}