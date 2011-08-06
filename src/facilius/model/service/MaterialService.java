package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.MaterialDAO;
import facilius.model.pojo.Material;

public class MaterialService implements BaseService<Material> {

	@Override
	public void create(Material e) throws Exception {
		MaterialDAO dao = new MaterialDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		MaterialDAO dao = new MaterialDAO();
		dao.delete(id);
	}

	@Override
	public List<Material> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		MaterialDAO dao = new MaterialDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Material readById(Long id) throws Exception {
		MaterialDAO dao = new MaterialDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Material e) throws Exception {
		MaterialDAO dao = new MaterialDAO();
		dao.update(e);
	}

}