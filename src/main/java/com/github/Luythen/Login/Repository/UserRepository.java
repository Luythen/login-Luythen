package com.github.Luythen.Login.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.github.Luythen.Login.Model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, UUID> {
    Optional<UserModel> findByEmail(String email);
}
