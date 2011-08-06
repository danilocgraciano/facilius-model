package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.DisciplinaDAO;
import facilius.model.pojo.Disciplina;

public class DisciplinaService implements BaseService<Disciplina> {

	@Override
	public void create(Disciplina e) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.delete(id);
	}

	@Override
	public List<Disciplina> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Disciplina readById(Long id) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Disciplina e) throws Exception {
		DisciplinaDAO dao = new DisciplinaDAO();
		dao.update(e);
	}

}