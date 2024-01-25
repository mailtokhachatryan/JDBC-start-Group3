package repository.user;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoData extends JpaRepository<User, Integer> {

    User findByEmail(String email);

}
