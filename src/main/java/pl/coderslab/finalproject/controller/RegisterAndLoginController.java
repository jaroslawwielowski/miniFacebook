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
class RegisterAndLoginController {

    private final UserRepository userRepository;
    private final EmailService emailService;


    public RegisterAndLoginController(UserRepository userRepository, EmailService emailService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
    }

    @GetMapping(value = "/register")
    public String showRegistrationForm(HttpServletRequest request, Model model) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        String message = null;
        try {
            user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        }catch (Exception e){
            message = "ups coś poszło nie tak" + e;
        }
        if (user!=null) {
            if (user.isOnline()) {
                message = " jests już zalogowany " + user.getFirstName() + " " + user.getLastName();
                model.addAttribute( "message" , message);
                model.addAttribute("user", user);
                return "redirect:/";
            }
        }
        model.addAttribute("user", new User());
        model.addAttribute("sex", Sex.values());
        model.addAttribute("dayOfBirth", dayOfBirth());
        model.addAttribute("monthOfBirth", monthOfBirth());
        model.addAttribute("yearOfBirth", yearsOfBirth());
        return "fragments/registerForm";
    }


    @PostMapping(value = "/register")
    public String checkPersonInfo(@Valid User user, Model model) {
        user.setConfirmationId(createConfirmationID());
        String message = "ups, coś poszło nie tak.";
        userRepository.save(user);
        emailService.send(user.getEmail(), "To jest link aktywacyjny do mojej strony",
                "to jest link aktywacyjny \n" +
                        "http://localhost:8080/confirm?id=" + user.getConfirmationId() +
                        " \n Dziękujemy za rejestracje :)");
        message = "na twoje konto został wysłany link aktywacyjny";
        model.addAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping("/confirm")
    public String greeting(@RequestParam(value="id", required=true) String confirmationId, Model model) {
        User user = userRepository.getUserByConfirmationId(confirmationId);
        String message = "ups, coś poszło nie tak.";
        if(user!=null){
            if(!user.isConfirmationStatus()){
                user.setConfirmationStatus(true);
                user.setConfirmationId(null);
                user.setAdministrativeRights(UserPrivileges.NormalUser.toString());
                userRepository.save(user);
            }
            message = user.getFirstName()+ " " + user.getLastName() + ", Twoje konto zostało aktywowane :) <br> możesz się teraz zalogować! ";
        }
        model.addAttribute("message", message);
        return "index";
    }



    @GetMapping(value = "/login")
    public String showLogInForm(Model model,HttpServletRequest request) {
        User user = new User();
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        String message = null;
        try {
            user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        }catch (Exception e){
            message = "ups,coś poszło nie tak" + e;
        }
        if (user!=null) {
            if (user.isOnline()) {
                message = " jests już zalogowany "+ user.getFirstName() + " " + user.getLastName();
                model.addAttribute( "message" , message);
                model.addAttribute("user", user);
                return "redirect:/";
            }
        }
        model.addAttribute("user", new User());
        return "fragments/loginForm";
    }


    @PostMapping(value = "/login")
    public String loginFormGetUser(@ModelAttribute UserDto userDto,
                                   Model model,
                                   HttpServletResponse response,
                                   HttpServletRequest request) {
        User user = userRepository.getUserByEmail(userDto.getEmail());
        String message = "nieprawidłowy login lub hasło";

        if(user!=null){
            if (user.isConfirmationStatus()) {
                if (user.passwordMatches(userDto.getPassword())){
                    message = "Witaj " + user.getFirstName() + " " + user.isOnline();
                    user.setOnline(true);
                    String onlineId = createConfirmationID();
                    user.setConfirmationOnlineId(onlineId);
                    Cookie cookieUser = new Cookie("cookieUser", onlineId);
                    cookieUser.setPath("/");
                    response.addCookie(cookieUser);
                    userRepository.save(user);
                    message = "usało się :)";
                    model.addAttribute("message", message);
                    model.addAttribute("user", user);
                    return "redirect:/";
                }
            }
        }

        model.addAttribute("user", new User());
        model.addAttribute("message", message);
        return "redirect:/";
    }

    @GetMapping("/logout/{id}")
    public String logOutUser(@PathVariable Long id, @ModelAttribute UserDto userDto, Model model){
        User user = new User();
        user = userRepository.getUserById(id);
        user.setConfirmationOnlineId(null);
        user.setOnline(false);
        userRepository.save(user);
        model.addAttribute("message", "zostałeś wylogowany");
        return "redirect:/";

    }

    @GetMapping(value = "/all")
    public String allUsers(Model model, HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                if (user.getAdministrativeRights().equals(UserPrivileges.Administrator.toString()) || user.getAdministrativeRights().equals(UserPrivileges.HyperAdministrator.toString())) {
                    List<User> users = userRepository.findAll();
                    model.addAttribute("users", users);
                    return "fragments/allUsers";
                }
            }
        }
        if (user!=null) {
            if (user.isOnline()) {
                    List<User> users = userRepository.findAll();
                    model.addAttribute("users", users);
                    return "fragments/allUsersForUsers";
            }
        }
        String message = "nie posiadasz uprawnień, Twoje uprawnienia to : " + user.getAdministrativeRights();
        model.addAttribute("message", message);
        return "fragments/message";
    }


    public List dayOfBirth() {
        List<Integer> listDay = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            listDay.add(i+1);
        }
        return listDay;
    }
    public List monthOfBirth(){
        List<String> listMonth = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            listMonth.add(Month.of(i+1).getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("pl-PL")));
        }
        return listMonth;
    }

    public List yearsOfBirth(){
        List<Integer> listYears = new ArrayList<>();
        for (int i = LocalDateTime.now().getYear(); i > 1940; i--) {
            listYears.add(i);
        }
        return listYears;
    }



    private String createConfirmationID() {
        return java.util.UUID.randomUUID().toString();
    }

}
