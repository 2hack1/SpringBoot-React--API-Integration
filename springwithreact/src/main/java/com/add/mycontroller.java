package com.add;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class mycontroller {

	@Autowired
	private UserRepo userRepo;

	@PostMapping("/user")
	public UserService insert(@RequestBody UserService user) {
		System.out.println("kapil");
		if (user.equals(null)) {
			System.out.println("not store");

		} else {
			return userRepo.save(user);
		}
		return userRepo.save(user);
	}

	@GetMapping("/users")
	public List<UserService> select() {
		return (List<UserService>) userRepo.findAll();
	}

//	@GetMapping("/user/{id}")
//	public UserService getUsersServiceById(@PathVariable int id) {
//		return userRepo.findById(id)
//				.orElseThrow(()-> new UserNotFoundException(id));
//	}

	@GetMapping("/user/{id}")

	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {

		Optional<UserService> user = userRepo.findById(id);

		if (user.isPresent()) {

			return ResponseEntity.ok(user.get());
		} else {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found With ID  :" + id);
		}

	}
	
	
	
	 // Delete user by ID
    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return ResponseEntity.ok("User deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }

    // Update user by ID
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable Integer id, @RequestBody UserService userDetails) {
        Optional<UserService> existingUser = userRepo.findById(id);

        if (existingUser.isPresent()) {
            UserService user = existingUser.get();
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setUsername(userDetails.getUsername());
            userRepo.save(user);  // Save the updated user
            return ResponseEntity.ok("User updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found with ID: " + id);
        }
    }
}
	

