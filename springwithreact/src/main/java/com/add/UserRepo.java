package com.add;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserService, Integer> {

}
