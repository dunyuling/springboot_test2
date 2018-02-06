package com.imooc.springboot_test2.controller;

import com.imooc.springboot_test2.domain.User;
import com.imooc.springboot_test2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liux on 18-2-5.
 */
@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);

        if (userRepository.save(user)) {
            System.out.printf("用户对象:%s 保存成功!\n", user);
        }
        return user;
    }

}
