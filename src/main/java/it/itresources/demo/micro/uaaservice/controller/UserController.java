package it.itresources.demo.micro.uaaservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.itresources.demo.micro.uaaservice.controller.model.UserDto;
import it.itresources.demo.micro.uaaservice.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public String info() {
        return "Users Controller";
    }

    @PostMapping("")
    public ResponseEntity<UserDto> creteUser(@RequestBody() @Valid UserDto userDto) {
        logger.info("REST request to create user: " + userDto);

        // call service
        UserDto newUser = userService.create(userDto);

        // return
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getAll() {
        logger.info("REST request to get all users");
        List<UserDto> users = userService.getAll();

        return ResponseEntity.ok(users);
    }
    
}