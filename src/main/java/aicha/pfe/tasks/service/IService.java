package aicha.pfe.tasks.service;

import java.util.List;

public interface IService<T> {

    List<T> retrieve();

    T add(T t);

    void delete(Long id);

    T update(T t);

}
