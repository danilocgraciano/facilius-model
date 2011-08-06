package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Curso;

public class CursoDAO implements BaseDAO<Curso> {

	private String path = "C:\\Curso.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Curso>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Curso> data)
			throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	@Override
	public void create(Curso e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Curso> data = (List<Curso>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Curso> data = (List<Curso>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Curso curso = data.get(i);
			if (curso != null) {
				if (curso.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Curso> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Curso> resultados = new ArrayList<Curso>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Curso> data = (List<Curso>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Curso aux = data.get(i);
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
	public Curso readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Curso> data = (List<Curso>) conteudo.get("data");

		Curso CursoAux = null;

		for (int i = 0; i < data.size(); i++) {
			Curso Curso = data.get(i);
			if (Curso != null) {
				if (Curso.getId().equals(id)) {
					CursoAux = data.get(i);
					break;
				}
			}
		}
		return CursoAux;
	}

	@Override
	public void update(Curso e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Curso> data = (List<Curso>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Curso Curso = data.get(i);
			if (Curso != null) {
				if (Curso.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}