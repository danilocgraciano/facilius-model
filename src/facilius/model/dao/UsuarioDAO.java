package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Usuario;

public class UsuarioDAO implements BaseDAO<Usuario> {

	private String path = "C:\\Usuario.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<Usuario>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<Usuario> data) throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	@Override
	public void create(Usuario e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Usuario> data = (List<Usuario>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Usuario> data = (List<Usuario>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Usuario Usuario = data.get(i);
			if (Usuario != null) {
				if (Usuario.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

	@Override
	public List<Usuario> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<Usuario> resultados = new ArrayList<Usuario>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<Usuario> data = (List<Usuario>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			Usuario aux = data.get(i);
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
	public Usuario readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<Usuario> data = (List<Usuario>) conteudo.get("data");

		Usuario UsuarioAux = null;

		for (int i = 0; i < data.size(); i++) {
			Usuario Usuario = data.get(i);
			if (Usuario != null) {
				if (Usuario.getId().equals(id)) {
					UsuarioAux = data.get(i);
					break;
				}
			}
		}
		return UsuarioAux;
	}

	@Override
	public void update(Usuario e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<Usuario> data = (List<Usuario>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			Usuario Usuario = data.get(i);
			if (Usuario != null) {
				if (Usuario.getId().equals(e.getId())) {
					data.remove(i);
					data.add(e);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}

}