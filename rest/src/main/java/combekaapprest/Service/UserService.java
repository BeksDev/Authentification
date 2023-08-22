package combekaapprest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private combekaapprest.Repo.UserRepo userRepo;

    public Integer getAgeByUsername(String username) {
        combekaapprest.Models.User user = userRepo.findByUsername(username);
        if (user != null) {
            return user.getAge();
        }
        return null; // Return null or handle accordingly if user not found
    }

    public String getUserEmail(String username) {
        combekaapprest.Models.User user = userRepo.findByUsername(username);
        if (user != null) {
            return user.getEmail();
        }
        return null;
    }
}

