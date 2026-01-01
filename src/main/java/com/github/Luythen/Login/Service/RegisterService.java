package com.github.Luythen.Login.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.Luythen.Login.Model.RegisterDto;
import com.github.Luythen.Login.Model.UserModel;
import com.github.Luythen.Login.Repository.UserRepository;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerNewUserAccount (RegisterDto user) throws Exception {
        if (!userRepository.findByEmail(user.getEmail()).isEmpty()) {
            throw new Exception("Account already exits");
        }

        UserModel newUser = new UserModel();
        newUser.setEmail(user.getEmail());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole("Customer");
        userRepository.save(newUser);
    }

}
