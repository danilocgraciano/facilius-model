package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.InstituicaoDAO;
import facilius.model.pojo.Instituicao;

public class InstituicaoService implements BaseService<Instituicao> {

	@Override
	public void create(Instituicao e) throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		dao.delete(id);
	}

	@Override
	public List<Instituicao> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Instituicao readById(Long id) throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Instituicao e) throws Exception {
		InstituicaoDAO dao = new InstituicaoDAO();
		dao.update(e);
	}

}