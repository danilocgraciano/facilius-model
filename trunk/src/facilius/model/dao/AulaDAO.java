package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Aula;

public class AulaDAO implements BaseDAO<Aula> {

	private String path = "C:\\Aula.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Aula>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Aula> data) throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	@Override
	public void create(Aula e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Aula> data = (List<Aula>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Aula> data = (List<Aula>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Aula Aula = data.get(i);
			if (Aula != null) {
				if (Aula.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Aula> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Aula> resultados = new ArrayList<Aula>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Aula> data = (List<Aula>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Aula aux = data.get(i);
			boolean ok = true;
			// Aplicar critérios...
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

	@Override
	public Aula readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Aula> data = (List<Aula>) conteudo.get("data");

		Aula AulaAux = null;

		for (int i = 0; i < data.size(); i++) {
			Aula Aula = data.get(i);
			if (Aula != null) {
				if (Aula.getId().equals(id)) {
					AulaAux = data.get(i);
					break;
				}
			}
		}
		return AulaAux;
	}

	@Override
	public void update(Aula e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Aula> data = (List<Aula>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Aula Aula = data.get(i);
			if (Aula != null) {
				if (Aula.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}