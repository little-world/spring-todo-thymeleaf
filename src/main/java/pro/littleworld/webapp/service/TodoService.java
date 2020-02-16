
package pro.littleworld.webapp.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.littleworld.webapp.model.Todo;


@Repository
public interface TodoService extends CrudRepository<Todo, Integer> {

}

