package com.example.myfirstcrudapp.service;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.example.myfirstcrudapp.model.UserEntity;
import com.example.myfirstcrudapp.model.dto.CreateUserRequest;
import com.example.myfirstcrudapp.model.dto.UpdateUserRequest;
import com.example.myfirstcrudapp.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepo userRepo;

	public List<UserEntity> getAll() {
		return userRepo.findAll();
	}

	public UserEntity getByUserById(Long id) {
		return userRepo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
	}

	@Transactional
	public UserEntity create(CreateUserRequest request) {
		UserEntity user = new UserEntity();
		user.setName(request.getName());
		return userRepo.save(user);
	}

	@Transactional
	public UserEntity update(Long id, UpdateUserRequest updateUserRequest) {
		UserEntity user = userRepo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(NOT_FOUND));
		user.setName(updateUserRequest.getName());
		return userRepo.save(user);
	}

	public void deleteById(Long id) {
		userRepo.deleteById(id);
	}
}
