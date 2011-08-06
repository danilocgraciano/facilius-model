package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.FrequenciaDAO;
import facilius.model.pojo.Frequencia;

public class FrequenciaService implements BaseService<Frequencia> {

	@Override
	public void create(Frequencia e) throws Exception {
		FrequenciaDAO dao = new FrequenciaDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		FrequenciaDAO dao = new FrequenciaDAO();
		dao.delete(id);
	}

	@Override
	public List<Frequencia> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		FrequenciaDAO dao = new FrequenciaDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Frequencia readById(Long id) throws Exception {
		FrequenciaDAO dao = new FrequenciaDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Frequencia e) throws Exception {
		FrequenciaDAO dao = new FrequenciaDAO();
		dao.update(e);
	}

}