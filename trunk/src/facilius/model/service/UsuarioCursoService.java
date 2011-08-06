package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.UsuarioCursoDAO;
import facilius.model.pojo.UsuarioCurso;

public class UsuarioCursoService implements BaseService<UsuarioCurso> {

	@Override
	public void create(UsuarioCurso e) throws Exception {
		UsuarioCursoDAO dao = new UsuarioCursoDAO();
		dao.create(e);

	}

	@Override
	public void delete(Long id) throws Exception {
		UsuarioCursoDAO dao = new UsuarioCursoDAO();
		dao.delete(id);
	}

	@Override
	public List<UsuarioCurso> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		UsuarioCursoDAO dao = new UsuarioCursoDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public UsuarioCurso readById(Long id) throws Exception {
		UsuarioCursoDAO dao = new UsuarioCursoDAO();
		return dao.readById(id);
	}

	@Override
	public void update(UsuarioCurso e) throws Exception {
		UsuarioCursoDAO dao = new UsuarioCursoDAO();
		dao.update(e);
	}

}