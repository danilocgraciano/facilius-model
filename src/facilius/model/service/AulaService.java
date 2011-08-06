package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.AulaDAO;
import facilius.model.pojo.Aula;

public class AulaService implements BaseService<Aula> {

	@Override
	public void create(Aula e) throws Exception {
		AulaDAO dao = new AulaDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		AulaDAO dao = new AulaDAO();
		dao.delete(id);
	}

	@Override
	public List<Aula> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		AulaDAO dao = new AulaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Aula readById(Long id) throws Exception {
		AulaDAO dao = new AulaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Aula e) throws Exception {
		AulaDAO dao = new AulaDAO();
		dao.update(e);
	}

}