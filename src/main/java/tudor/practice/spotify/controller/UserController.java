package tudor.practice.spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;

import tudor.practice.spotify.service.UserService;


public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // public List<UserModel> getAllUsers()
    // {

    // }


}
