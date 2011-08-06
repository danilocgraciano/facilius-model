package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Disciplina;

public class DisciplinaDAO implements BaseDAO<Disciplina> {

	private String path = "C:\\Disciplina.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Disciplina>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Disciplina> data) throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}
	
	@Override
	public void create(Disciplina e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Disciplina> data = (List<Disciplina>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Disciplina> data = (List<Disciplina>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Disciplina Disciplina = data.get(i);
			if (Disciplina != null) {
				if (Disciplina.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Disciplina> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Disciplina> resultados = new ArrayList<Disciplina>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Disciplina> data = (List<Disciplina>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Disciplina aux = data.get(i);
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
	public Disciplina readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Disciplina> data = (List<Disciplina>) conteudo.get("data");

		Disciplina DisciplinaAux = null;

		for (int i = 0; i < data.size(); i++) {
			Disciplina Disciplina = data.get(i);
			if (Disciplina != null) {
				if (Disciplina.getId().equals(id)) {
					DisciplinaAux = data.get(i);
					break;
				}
			}
		}
		return DisciplinaAux;
	}

	@Override
	public void update(Disciplina e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Disciplina> data = (List<Disciplina>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Disciplina Disciplina = data.get(i);
			if (Disciplina != null) {
				if (Disciplina.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}