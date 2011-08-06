package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Cidade;

public class CidadeDAO implements BaseDAO<Cidade> {

	private String path = "C:\\Cidade.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Cidade>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Cidade> data) throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	@Override
	public void create(Cidade e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Cidade> data = (List<Cidade>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Cidade> data = (List<Cidade>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Cidade Cidade = data.get(i);
			if (Cidade != null) {
				if (Cidade.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Cidade> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Cidade> resultados = new ArrayList<Cidade>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Cidade> data = (List<Cidade>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Cidade aux = data.get(i);
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
	public Cidade readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Cidade> data = (List<Cidade>) conteudo.get("data");

		Cidade CidadeAux = null;

		for (int i = 0; i < data.size(); i++) {
			Cidade Cidade = data.get(i);
			if (Cidade != null) {
				if (Cidade.getId().equals(id)) {
					CidadeAux = data.get(i);
					break;
				}
			}
		}
		return CidadeAux;
	}

	@Override
	public void update(Cidade e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Cidade> data = (List<Cidade>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Cidade Cidade = data.get(i);
			if (Cidade != null) {
				if (Cidade.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}