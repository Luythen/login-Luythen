package com.github.Luythen.Login.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.github.Luythen.Login.Model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, String> {
    Optional<UserModel> findByEmail(String email);
}
