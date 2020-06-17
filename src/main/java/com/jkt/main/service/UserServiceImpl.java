package com.jkt.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jkt.main.dao.UserRepository;
import com.jkt.main.model.LoginDto;
import com.jkt.main.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @Autowired
	private UserRepository userRepository;

	@Override
	public ResponseEntity<String> login(LoginDto loginDto) {
		
		User user = userRepository.findByEmail(loginDto.getEmail());
        if(user == null) {
        	
        	return new ResponseEntity<>(
        	          "User does not exist.", 
        	          HttpStatus.BAD_REQUEST);  
        }
        
        if(!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())){
            
        	return new ResponseEntity<>(
      	          "Password mismatch.", 
      	          HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(
        		"Login success", 
        	      HttpStatus.OK);
   
	}
	
	


}
