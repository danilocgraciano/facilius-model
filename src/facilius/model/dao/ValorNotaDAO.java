package facilius.model.dao;

import facilius.model.base.BaseDAO;
import facilius.model.pojo.ValorNota;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;

public class ValorNotaDAO implements BaseDAO<ValorNota> {
	
	private String path = "C:\\ValorNota.xml";

    public Map<String, Object> loadFromFile(String path) {
        Map<String, Object> conteudo = null;
        try {
            conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
        } catch (Exception e1) {
            conteudo = new HashMap<String, Object>();
            conteudo.put("sequence", new Long(0));
            conteudo.put("data", new ArrayList<ValorNota>());
        }
        return conteudo;
    }

    private void saveToFile(Long sequence, List<ValorNota> data) throws Exception {

        Map<String, Object> conteudo = new HashMap<String, Object>();
        conteudo.put("sequence", sequence);
        conteudo.put("data", data);

        XMLPersist.saveToFile(conteudo, path);

    }

	@Override
	public void create(ValorNota e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<ValorNota> data = (List<ValorNota>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	@Override
	public void delete(Long id) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<ValorNota> data = (List<ValorNota>) conteudo.get("data");

        for (int i = 0; i < data.size(); i++) {
            ValorNota ValorNota = data.get(i);
            if (ValorNota != null) {
                if (ValorNota.getId().equals(id)) {
                    data.remove(i);
                    break;
                }
            }
        }

        saveToFile(sequence, data);
    }

	@Override
	public List<ValorNota> readByCriteria(Map<String, Object> criteria)throws Exception {
        List<ValorNota> resultados = new ArrayList<ValorNota>();
        Map<String, Object> conteudo = loadFromFile(path);
        List<ValorNota> data = (List<ValorNota>) conteudo.get("data");
        for (int i = 0; i < data.size(); i++) {

            ValorNota aux = data.get(i);
            boolean ok = true;
            //Aplicar critérios...
            if (criteria != null) {
                String nome = (String) criteria.get("tipoNota");
                if (nome != null && !aux.getTipoNota().getDescricao().startsWith(nome)) {
                    ok = false;
                }
            }
            if (ok) {
                resultados.add(aux);
            }
        }
        return resultados;
    
	}

	@Override
	public ValorNota readById(Long id) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        List<ValorNota> data = (List<ValorNota>) conteudo.get("data");

        ValorNota ValorNotaAux = null;

        for (int i = 0; i < data.size(); i++) {
            ValorNota ValorNota = data.get(i);
            if (ValorNota != null) {
                if (ValorNota.getId().equals(id)) {
                    ValorNotaAux = data.get(i);
                    break;
                }
            }
        }
        return ValorNotaAux;
    }

	@Override
	public void update(ValorNota e) throws Exception {
        Map<String, Object> conteudo = loadFromFile(path);
        Long sequence = (Long) conteudo.get("sequence");
        List<ValorNota> data = (List<ValorNota>) conteudo.get("data");

        for (int i = 0; i < data.size(); i++) {
            ValorNota ValorNota = data.get(i);
            if (ValorNota != null) {
                if (ValorNota.getId().equals(e.getId())) {
                    data.remove(i);
                    data.add(e);
                    break;
                }
            }
        }

        saveToFile(sequence, data);
    }

}