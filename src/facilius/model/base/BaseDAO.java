package facilius.model.base;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface BaseDAO<E> {

    public void create(E e) throws Exception;

    public List<E> readByCriteria(Map<String, Object> criteria) throws Exception;

    public E readById(Long id) throws Exception;

    public void update(E e) throws Exception;

    public void delete(Long id) throws Exception;

    public E extract(ResultSet resultSet) throws Exception;
}
