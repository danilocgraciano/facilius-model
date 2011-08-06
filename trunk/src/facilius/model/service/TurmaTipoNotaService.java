package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.TurmaTipoNotaDAO;
import facilius.model.pojo.TurmaTipoNota;

public class TurmaTipoNotaService implements BaseService<TurmaTipoNota> {

	@Override
	public void create(TurmaTipoNota e) throws Exception {
		TurmaTipoNotaDAO dao = new TurmaTipoNotaDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		TurmaTipoNotaDAO dao = new TurmaTipoNotaDAO();
		dao.delete(id);
	}

	@Override
	public List<TurmaTipoNota> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		TurmaTipoNotaDAO dao = new TurmaTipoNotaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public TurmaTipoNota readById(Long id) throws Exception {
		TurmaTipoNotaDAO dao = new TurmaTipoNotaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(TurmaTipoNota e) throws Exception {
		TurmaTipoNotaDAO dao = new TurmaTipoNotaDAO();
		dao.update(e);
	}

}