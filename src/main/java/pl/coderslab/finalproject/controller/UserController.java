package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import pl.coderslab.finalproject.dto.UserDto;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.enums.Sex;
import pl.coderslab.finalproject.enums.UserPrivileges;
import pl.coderslab.finalproject.repository.UserRepository;
import pl.coderslab.finalproject.service.EmailService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "User")
class UserController {

    private final UserRepository userRepository;
    private final EmailService emailService;


    public UserController(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }


    private String createConfirmationID() {
        return java.util.UUID.randomUUID().toString();
    }

}
