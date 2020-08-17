package com.czxy.order.service;

import com.czxy.order.domain.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<User> login(User user);
}
