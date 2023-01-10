package com.example.myfirstcrudapp.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.myfirstcrudapp.model.UserEntity;
import com.example.myfirstcrudapp.model.dto.CreateUserRequest;
import com.example.myfirstcrudapp.model.dto.UpdateUserRequest;
import com.example.myfirstcrudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@GetMapping
	public List<UserEntity> getAll() {
		return userService.getAll();
	}

	@GetMapping("/{id}")
	public UserEntity getByUserById(@PathVariable("id") Long id) {
		return userService.getByUserById(id);
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public UserEntity create(@RequestBody CreateUserRequest request) {
		return userService.create(request);
	}

	@PutMapping("/{id}")
	public UserEntity update(@PathVariable("id") Long id, @RequestBody UpdateUserRequest updateUserRequest) {
		return userService.update(id, updateUserRequest);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") Long id) {
		userService.deleteById(id);
	}
}
