package facilius.model.service;

import facilius.model.ServiceLocator;
import facilius.model.base.AbstractBaseService;
import facilius.model.dao.CursoDAO;

import facilius.model.pojo.Curso;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CursoService extends AbstractBaseService<Curso> {

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

    @Override
    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        Map<String, String> options = new TreeMap<String, String>();
        List<Curso> cursos = this.readByCriteria(criteria);
        for (int i = 0; i < cursos.size(); i++) {
            Curso aux = cursos.get(i);
            options.put(aux.getId().toString(), aux.getDescricao());
        }
        return options;
    }

    @Override
    public Map<String, String> validateForCreate(Curso curso) throws Exception {

        Map<String, String> errors = new HashMap<String, String>();
        errors.put("valido", "n");

        String descricao = (String) curso.getDescricao();
        if (descricao == null || descricao.trim().isEmpty()) {
            errors.put("errorDescricao", "Descrição Inválida!");
        }
        if (errors.keySet().size() == 1 ) {
            errors.put("valido", "s");
            errors.put("msg", "Operação realizada com sucesso!");
        }
        return errors;
    }

    @Override
    public Map<String, String> validateForDelete(Long id) throws Exception {

        Map<String, String> errors = new HashMap<String, String>();
        errors.put("valido", "n");
        try {
            delete(id);
        } catch (Exception e) {
            errors.put("msg", "Operação não permitida!");
        }
        if (errors.keySet().size() == 1 ) {
            errors.put("valido", "s");
            errors.put("msg", "Operação realizada com sucesso!");
        }
        return errors;

    }


}
