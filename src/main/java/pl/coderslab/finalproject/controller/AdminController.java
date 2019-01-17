package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import pl.coderslab.finalproject.repository.UserRepository;

@Controller
class AdminController {

    private final UserRepository userRepository;

    AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
