package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserDaoImpl;
import com.example.demo.model.User;

@Service
@Transactional
public class UserService {

	@Autowired
	UserDaoImpl userDaoImpl;

	public void save(User user) {
		userDaoImpl.save(user);
	}

	public void saveOrUpdate(User user) {
		userDaoImpl.saveOrUpdate(user);
	}

	public Map<String, Object> getByKey(long id) {
		return userDaoImpl.getByKey(id);
	}

	public List<Map<String, Object>> getAllUsers() {
		return userDaoImpl.getAllUsers();
	}

	public void removeById(Long id) {
		userDaoImpl.removeById(id);
	}

	public void removeByUsername(String username) {
		userDaoImpl.removeByUsername(username);
	}
}
