package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.DisciplinaDAO;
import facilius.model.pojo.Disciplina;
import java.util.TreeMap;

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

    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        Map<String, String> options = new TreeMap<String, String>();
        List<Disciplina> disciplinas = this.readByCriteria(criteria);
        for (int i = 0; i < disciplinas.size(); i++) {
            Disciplina aux = disciplinas.get(i);
            options.put(aux.getId().toString(), aux.getNome());
        }
        return options;
    }
}
