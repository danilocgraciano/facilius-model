package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.ValorNotaDAO;
import facilius.model.pojo.ValorNota;

public class ValorNotaService implements BaseService<ValorNota> {

	@Override
	public void create(ValorNota e) throws Exception {
		ValorNotaDAO dao = new ValorNotaDAO();
		dao.create(e);

	}

	@Override
	public void delete(Long id) throws Exception {
		ValorNotaDAO dao = new ValorNotaDAO();
		dao.delete(id);

	}

	@Override
	public List<ValorNota> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		ValorNotaDAO dao = new ValorNotaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public ValorNota readById(Long id) throws Exception {
		ValorNotaDAO dao = new ValorNotaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(ValorNota e) throws Exception {
		ValorNotaDAO dao = new ValorNotaDAO();
		dao.update(e);
	}

}