package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Turma;

public class TurmaDAO implements BaseDAO<Turma> {

	private String path = "C:\\Turma.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Turma>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Turma> data) throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	public void create(Turma e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Turma> data = (List<Turma>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	public List<Turma> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Turma> resultados = new ArrayList<Turma>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Turma> data = (List<Turma>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Turma aux = data.get(i);
			boolean ok = true;

                        String descricao = (String) criteria.get("nome");
                        if (descricao != null && !aux.getDescricao().startsWith(descricao)){
                            ok = false;
                        }
			// Aplicar critérios...
			if (ok) {
				resultados.add(aux);
			}
		}
		return resultados;
	}

	public Turma readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Turma> data = (List<Turma>) conteudo.get("data");

		Turma TurmaAux = null;

		for (int i = 0; i < data.size(); i++) {
			Turma Turma = data.get(i);
			if (Turma != null) {
				if (Turma.getId().equals(id)) {
					TurmaAux = data.get(i);
					break;
				}
			}
		}
		return TurmaAux;
	}

	public void update(Turma e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Turma> data = (List<Turma>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Turma Turma = data.get(i);
			if (Turma != null) {
				if (Turma.getId().equals(e.getId())) {
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
		List<Turma> data = (List<Turma>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Turma Turma = data.get(i);
			if (Turma != null) {
				if (Turma.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}