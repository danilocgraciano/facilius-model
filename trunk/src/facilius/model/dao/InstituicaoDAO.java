package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Instituicao;

public class InstituicaoDAO implements BaseDAO<Instituicao> {

	private String path = "C:\\Instituicao.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Instituicao>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Instituicao> data)
			throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	@Override
	public void create(Instituicao e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Instituicao> data = (List<Instituicao>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Instituicao> data = (List<Instituicao>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Instituicao Instituicao = data.get(i);
			if (Instituicao != null) {
				if (Instituicao.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Instituicao> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Instituicao> resultados = new ArrayList<Instituicao>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Instituicao> data = (List<Instituicao>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Instituicao aux = data.get(i);
			boolean ok = true;
			// Aplicar critérios...
			if (criteria != null) {
				String nome = (String) criteria.get("nome");
				if (nome != null && !aux.getNome().startsWith(nome)) {
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
	public Instituicao readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Instituicao> data = (List<Instituicao>) conteudo.get("data");

		Instituicao InstituicaoAux = null;

		for (int i = 0; i < data.size(); i++) {
			Instituicao Instituicao = data.get(i);
			if (Instituicao != null) {
				if (Instituicao.getId().equals(id)) {
					InstituicaoAux = data.get(i);
					break;
				}
			}
		}
		return InstituicaoAux;
	}

	@Override
	public void update(Instituicao e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Instituicao> data = (List<Instituicao>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Instituicao Instituicao = data.get(i);
			if (Instituicao != null) {
				if (Instituicao.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}