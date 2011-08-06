package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.UsuarioDAO;
import facilius.model.pojo.Usuario;

public class UsuarioService implements BaseService<Usuario> {

	@Override
	public void create(Usuario e) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		dao.create(e);
	}

	@Override
	public void delete(Long id) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		dao.delete(id);
	}

	@Override
	public List<Usuario> readByCriteria(Map<String, Object> criteria)
			throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.readByCriteria(criteria);
	}

	@Override
	public Usuario readById(Long id) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		return dao.readById(id);
	}

	@Override
	public void update(Usuario e) throws Exception {
		UsuarioDAO dao = new UsuarioDAO();
		dao.update(e);
	}

}