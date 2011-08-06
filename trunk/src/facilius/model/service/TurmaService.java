package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.TurmaDAO;
import facilius.model.pojo.Turma;

public class TurmaService implements BaseService<Turma> {

	@Override
	public void create(Turma e) throws Exception {
		TurmaDAO dao = new TurmaDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		TurmaDAO dao = new TurmaDAO();
		dao.delete(id);
	}

	@Override
	public List<Turma> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		TurmaDAO dao = new TurmaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Turma readById(Long id) throws Exception {
		TurmaDAO dao = new TurmaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Turma e) throws Exception {
		TurmaDAO dao = new TurmaDAO();
		dao.update(e);

	}

}