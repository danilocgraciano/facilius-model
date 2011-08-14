package facilius.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldsutils.XMLPersist;
import facilius.model.base.BaseDAO;
import facilius.model.pojo.Usuario;
import facilius.model.pojo.UsuarioCurso;

public class UsuarioCursoDAO implements BaseDAO<UsuarioCurso> {

	private String path = "C:\\UsuarioCurso.xml";

	public Map<String, Object> loadFromFile(String path) {
		Map<String, Object> conteudo = null;
		try {
			conteudo = (Map<String, Object>) XMLPersist.readFromFile(path);
		} catch (Exception e1) {
			conteudo = new HashMap<String, Object>();
			conteudo.put("sequence", new Long(0));
			conteudo.put("data", new ArrayList<UsuarioCurso>());
		}
		return conteudo;
	}

	private void saveToFile(Long sequence, List<UsuarioCurso> data)
			throws Exception {

		Map<String, Object> conteudo = new HashMap<String, Object>();
		conteudo.put("sequence", sequence);
		conteudo.put("data", data);

		XMLPersist.saveToFile(conteudo, path);

	}

	public void create(UsuarioCurso e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<UsuarioCurso> data = (List<UsuarioCurso>) conteudo.get("data");

		e.setId(++sequence);
		data.add(e);

		saveToFile(sequence, data);
	}

	public List<UsuarioCurso> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		List<UsuarioCurso> resultados = new ArrayList<UsuarioCurso>();
		Map<String, Object> conteudo = loadFromFile(path);
		List<UsuarioCurso> data = (List<UsuarioCurso>) conteudo.get("data");
		for (int i = 0; i < data.size(); i++) {

			UsuarioCurso aux = data.get(i);
			boolean ok = true;
			// Aplicar critérios...

                        Usuario usuario = (Usuario) criteria.get("usuario");
                        
                        if (usuario != null && !aux.getUsuario().getId().equals(usuario.getId())){
                            ok = false;
                        }
			if (ok) {
				resultados.add(aux);
			}
		}
		return resultados;
	}

	public UsuarioCurso readById(Long id) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		List<UsuarioCurso> data = (List<UsuarioCurso>) conteudo.get("data");

		UsuarioCurso UsuarioCursoAux = null;

		for (int i = 0; i < data.size(); i++) {
			UsuarioCurso UsuarioCurso = data.get(i);
			if (UsuarioCurso != null) {
				if (UsuarioCurso.getId().equals(id)) {
					UsuarioCursoAux = data.get(i);
					break;
				}
			}
		}
		return UsuarioCursoAux;
	}

	public void update(UsuarioCurso e) throws Exception {
		Map<String, Object> conteudo = loadFromFile(path);
		Long sequence = (Long) conteudo.get("sequence");
		List<UsuarioCurso> data = (List<UsuarioCurso>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			UsuarioCurso UsuarioCurso = data.get(i);
			if (UsuarioCurso != null) {
				if (UsuarioCurso.getId().equals(e.getId())) {
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
		List<UsuarioCurso> data = (List<UsuarioCurso>) conteudo.get("data");

		for (int i = 0; i < data.size(); i++) {
			UsuarioCurso UsuarioCurso = data.get(i);
			if (UsuarioCurso != null) {
				if (UsuarioCurso.getId().equals(id)) {
					data.remove(i);
					break;
				}
			}
		}

		saveToFile(sequence, data);
	}
}