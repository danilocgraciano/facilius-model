package facilius.model.service;

import java.util.List;
import java.util.Map;

import facilius.model.base.BaseService;
import facilius.model.dao.TurmaDAO;
import facilius.model.pojo.Turma;
import java.util.TreeMap;

public class TurmaService implements BaseService<Turma> {

    @Override
    public void create(Turma e) throws Exception {
        TurmaDAO dao = new TurmaDAO();
        dao.create(e);
    }

    @Override
    public void delete(Long id) throws Exception {
        TurmaDAO dao = new TurmaDAO();
        dao.delete(id);
    }

    @Override
    public List<Turma> readByCriteria(Map<String, Object> criteria)
            throws Exception {
        TurmaDAO dao = new TurmaDAO();
        return dao.readByCriteria(criteria);
    }

    @Override
    public Turma readById(Long id) throws Exception {
        TurmaDAO dao = new TurmaDAO();
        return dao.readById(id);
    }

    @Override
    public void update(Turma e) throws Exception {
        TurmaDAO dao = new TurmaDAO();
        dao.update(e);

    }

    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        Map<String, String> options = new TreeMap<String, String>();
        List<Turma> turmas = this.readByCriteria(criteria);
        for (int i = 0; i < turmas.size(); i++) {
            Turma aux = turmas.get(i);
            options.put(aux.getId().toString(), aux.getDescricao());
        }
        return options;
    }
}
