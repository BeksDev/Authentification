package combekaapprest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import combekaapprest.Models.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
