package facilius.model.base;

import java.util.Map;

/**
 *
 * @author Graciano
 */
public abstract class AbstractBaseService<E> implements BaseService<E> {

    public Map<String, String> validateForCreate(E e) throws Exception {
        return null;
    }

    public Map<String, String> validateForUpdate(E e) throws Exception {
        return null;
    }

    public Map<String, String> validateForDelete(Long id) throws Exception {
        return null;
    }

    public Map<String, String> getOptions(Map<String, Object> criteria) throws Exception {
        return null;
    }
}
