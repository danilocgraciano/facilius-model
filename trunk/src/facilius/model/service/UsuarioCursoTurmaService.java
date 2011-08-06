package facilius.model.service;

import facilius.model.base.BaseService;
import facilius.model.dao.UsuarioCursoTurmaDAO;
import facilius.model.pojo.UsuarioCursoTurma;

import java.util.List;
import java.util.Map;

public class UsuarioCursoTurmaService implements BaseService<UsuarioCursoTurma> {

	@Override
	public void create(UsuarioCursoTurma e) throws Exception {
		UsuarioCursoTurmaDAO dao = new UsuarioCursoTurmaDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		UsuarioCursoTurmaDAO dao = new UsuarioCursoTurmaDAO();
		dao.delete(id);
	}

	@Override
	public List<UsuarioCursoTurma> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		UsuarioCursoTurmaDAO dao = new UsuarioCursoTurmaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public UsuarioCursoTurma readById(Long id) throws Exception {
		UsuarioCursoTurmaDAO dao = new UsuarioCursoTurmaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(UsuarioCursoTurma e) throws Exception {
		UsuarioCursoTurmaDAO dao = new UsuarioCursoTurmaDAO();
		dao.update(e);
	}

}