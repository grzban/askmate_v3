package pl.gb.askmate.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gb.askmate.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
