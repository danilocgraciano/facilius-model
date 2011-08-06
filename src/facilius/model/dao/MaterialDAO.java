package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Material;

public class MaterialDAO implements BaseDAO<Material> {

	private String path = "C:\\Material.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Material>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Material> data)
			throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	@Override
	public void create(Material e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Material> data = (List<Material>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Material> data = (List<Material>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Material Material = data.get(i);
			if (Material != null) {
				if (Material.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Material> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Material> resultados = new ArrayList<Material>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Material> data = (List<Material>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Material aux = data.get(i);
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
	public Material readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Material> data = (List<Material>) conteudo.get("data");

		Material MaterialAux = null;

		for (int i = 0; i < data.size(); i++) {
			Material Material = data.get(i);
			if (Material != null) {
				if (Material.getId().equals(id)) {
					MaterialAux = data.get(i);
					break;
				}
			}
		}
		return MaterialAux;
	}

	@Override
	public void update(Material e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Material> data = (List<Material>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Material Material = data.get(i);
			if (Material != null) {
				if (Material.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}