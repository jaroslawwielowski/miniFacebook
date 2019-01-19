package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.enums.UserPrivileges;
import pl.coderslab.finalproject.repository.UserRepository;

@Controller
public class StarterCreateFirstUser {

    private final UserRepository userRepository;

    public StarterCreateFirstUser( UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/first")
    public String firstUser(Model model){
        User user = new User();
        String message = null;
       user.setFirstName("Jarosław");
       user.setLastName("Wielowski");
       user.setAdministrativeRights(UserPrivileges.Administrator.toString());
       user.setPassword("1q2w");
       user.setEmail("jaroslawwielowski@gmail.com");
       user.setConfirmationStatus(true);
       message = "jesteś pierwszy Administratorze!! i drugi użytkownik";
       userRepository.save(user);

//       User user1 = new User();
//        user1.setFirstName("jarek");
//        user1.setLastName("wiel");
//        user1.setAdministrativeRights(UserPrivileges.NormalUser.toString());
//        user1.setPassword("1q2w");
//        user1.setEmail("constream@gmail.com");
//        user1.setConfirmationStatus(true);
//
//        userRepository.save(user1);
       model.addAttribute("message", message);
        return "index";
    }

//
//    @PostMapping("/first")
//    public String firstUser1(Model model){
//        User user = new User();
//        String message = null;
//        user.setLogin("jarekwie");
//        user.setAdministrativeRights(UserPrivileges.HyperAdministrator.toString());
//        user.setPassword("1q2w");
//        user.setEmail("jaroslawwielowski@gmail.com");
//        user.setConfirmationStatus(true);
//        message = "jesteś pierwszy Administratorze!";
//        model.addAttribute("message", message);
//        return "index";
//    }

}
