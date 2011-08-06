package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Frequencia;

public class FrequenciaDAO implements BaseDAO<Frequencia> {

	private String path = "C:\\Frequencia.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Frequencia>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Frequencia> data)
			throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	public void create(Frequencia e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Frequencia> data = (List<Frequencia>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	public List<Frequencia> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Frequencia> resultados = new ArrayList<Frequencia>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Frequencia> data = (List<Frequencia>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Frequencia aux = data.get(i);
			boolean ok = true;
			// Aplicar critérios...
			if (ok) {
				resultados.add(aux);
			}
		}
		return resultados;
	}

	public Frequencia readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Frequencia> data = (List<Frequencia>) conteudo.get("data");

		Frequencia FrequenciaAux = null;

		for (int i = 0; i < data.size(); i++) {
			Frequencia Frequencia = data.get(i);
			if (Frequencia != null) {
				if (Frequencia.getId().equals(id)) {
					FrequenciaAux = data.get(i);
					break;
				}
			}
		}
		return FrequenciaAux;
	}

	public void update(Frequencia e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Frequencia> data = (List<Frequencia>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Frequencia Frequencia = data.get(i);
			if (Frequencia != null) {
				if (Frequencia.getId().equals(e.getId())) {
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
		List<Frequencia> data = (List<Frequencia>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Frequencia Frequencia = data.get(i);
			if (Frequencia != null) {
				if (Frequencia.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}
}