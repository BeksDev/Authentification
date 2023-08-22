package combekaapprest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import combekaapprest.utils.PasswordValidator;
import combekaapprest.Models.User;
import combekaapprest.Repo.UserRepo;
import combekaapprest.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiControllers {
   
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;
    

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> getUserById(@PathVariable long id) {
        return userRepo.findById(id);
    }
    
  
    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        try {
            PasswordValidator.validatePassword(user.getPassword());
            
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepo.save(user);
            
            return "Save ...";
        } catch (IllegalArgumentException e) {
            // Handle the error here, e.getMessage() will contain the error code and message
            return "Error: " + e.getMessage();
        }
    }

    @PutMapping(value = "/user/{id}")
    public String updaterUser (@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setPassword(passwordEncoder.encode(user.getPassword()));
        updatedUser.setEmail(user.getEmail());
        userRepo.save(updatedUser);
        return "updated";
    }
    @DeleteMapping(value = "/user/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted";
    }


    @GetMapping("/{username}/age")
    public Integer getUserAge(@PathVariable String username) {
        return userService.getAgeByUsername(username);
    }
    @GetMapping("/{username}/email")
    public String getUserEmail(@PathVariable String username){
        return userService.getUserEmail(username);
    }

    @RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
    
}
