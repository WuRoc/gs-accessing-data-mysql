package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
			   // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@PostMapping(path="/update") // Map ONLY POST Requests
	public @ResponseBody String addNewUser (@RequestParam Integer id, @RequestParam String name
			, @RequestParam String email) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setId(id);
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}

	@PostMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@PostMapping(path="/condition")
	public @ResponseBody
	List<User> getUsers(@RequestParam String param) {
		// This returns a JSON or XML with the users
		List<User> list = new ArrayList<>();
		 for (User user : userRepository.findAll()){
		 	if(user.getEmail().toLowerCase().contains(param)){
		 		list.add(user);
			}
		 }
		 return list;
	}

	@GetMapping(path = "id")
	public @ResponseBody
	Optional<User> getUserById(@RequestParam Integer id){
		return userRepository.findById(id);
	}


}
