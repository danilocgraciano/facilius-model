package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.CursoDAO;
import facilius.model.pojo.Curso;
import java.util.TreeMap;

public class CursoService implements BaseService<Curso> {

    @Override
    public void create(Curso e) throws Exception {
        CursoDAO dao = new CursoDAO();
        dao.create(e);
    }

    @Override
    public void delete(Long id) throws Exception {
        CursoDAO dao = new CursoDAO();
        dao.delete(id);
    }

    @Override
    public List<Curso> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        CursoDAO dao = new CursoDAO();
        return dao.readByCriteria(criteria);
    }

    @Override
    public Curso readById(Long id) throws Exception {
        CursoDAO dao = new CursoDAO();
        return dao.readById(id);
    }

    @Override
    public void update(Curso e) throws Exception {
        CursoDAO dao = new CursoDAO();
        dao.update(e);
    }

    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        Map<String, String> options = new TreeMap<String, String>();
        List<Curso> cursos = this.readByCriteria(criteria);
        for (int i = 0; i < cursos.size(); i++) {
            Curso aux = cursos.get(i);
            options.put(aux.getId().toString(), aux.getDescricao());
        }
        return options;
    }
}
