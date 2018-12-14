package com.ads2018II.banking.domain.repository.users;

import java.util.List;

import com.ads2018II.banking.domain.entity.users.User;

public interface UserRepository {
		public User save(User user);
		public User getById(long userId);
		public User getByName(String name);
		public List<User> getPaginated (int page, int pageSize);
}
