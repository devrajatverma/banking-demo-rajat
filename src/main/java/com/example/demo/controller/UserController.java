package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		if (user == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			try {
				userService.save(user);
				return new ResponseEntity<String>("User Added", HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@CrossOrigin
	@GetMapping("")
	public ResponseEntity<?> allUsers() {
		try {
			return new ResponseEntity<List<Map<String, Object>>>(userService.getAllUsers(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Integer id) {
		if (id == null || id == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			try {

				return new ResponseEntity<Map<String, Object>>(userService.getByKey(id), HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@CrossOrigin
	@PutMapping("")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		if (user == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			try {
				userService.saveOrUpdate(user);
				return new ResponseEntity<String>("User Added", HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

	@CrossOrigin
	@DeleteMapping("")
	public ResponseEntity<?> deleteUser(@RequestParam(value = "id", required = true) Long id) {
		if (id == null || id == 0)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else {
			try {
				userService.removeById(id);
				return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e);
				return new ResponseEntity<String>(e.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

	}

}
