package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.UsuarioCursoTurma;

public class UsuarioCursoTurmaDAO implements BaseDAO<UsuarioCursoTurma> {

	private String path = "C:\\UsuarioCursoTurma.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<UsuarioCursoTurma>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<UsuarioCursoTurma> data)
			throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	public void create(UsuarioCursoTurma e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<UsuarioCursoTurma> data = (List<UsuarioCursoTurma>) conteudo
				.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	public List<UsuarioCursoTurma> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<UsuarioCursoTurma> resultados = new ArrayList<UsuarioCursoTurma>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<UsuarioCursoTurma> data = (List<UsuarioCursoTurma>) conteudo
				.get("data");
		for (int i = 0; i < data.size(); i++) {

			UsuarioCursoTurma aux = data.get(i);
			boolean ok = true;
			// Aplicar critérios...
			if (ok) {
				resultados.add(aux);
			}
		}
		return resultados;
	}

	public UsuarioCursoTurma readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<UsuarioCursoTurma> data = (List<UsuarioCursoTurma>) conteudo
				.get("data");

		UsuarioCursoTurma UsuarioCursoTurmaAux = null;

		for (int i = 0; i < data.size(); i++) {
			UsuarioCursoTurma UsuarioCursoTurma = data.get(i);
			if (UsuarioCursoTurma != null) {
				if (UsuarioCursoTurma.getId().equals(id)) {
					UsuarioCursoTurmaAux = data.get(i);
					break;
				}
			}
		}
		return UsuarioCursoTurmaAux;
	}

	public void update(UsuarioCursoTurma e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<UsuarioCursoTurma> data = (List<UsuarioCursoTurma>) conteudo
				.get("data");

		for (int i = 0; i < data.size(); i++) {
			UsuarioCursoTurma UsuarioCursoTurma = data.get(i);
			if (UsuarioCursoTurma != null) {
				if (UsuarioCursoTurma.getId().equals(e.getId())) {
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
		List<UsuarioCursoTurma> data = (List<UsuarioCursoTurma>) conteudo
				.get("data");

		for (int i = 0; i < data.size(); i++) {
			UsuarioCursoTurma UsuarioCursoTurma = data.get(i);
			if (UsuarioCursoTurma != null) {
				if (UsuarioCursoTurma.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}
}