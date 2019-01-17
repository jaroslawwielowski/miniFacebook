package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;
import pl.coderslab.finalproject.entity.Post;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.enums.UserPrivileges;
import pl.coderslab.finalproject.repository.PostRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(name = "/posts")
class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @GetMapping(value = "/all")
    public String allFriendPost(Model model, HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                if (user.getAdministrativeRights().equals(UserPrivileges.Administrator.toString()) || user.getAdministrativeRights().equals(UserPrivileges.HyperAdministrator.toString())) {
                    List<Post> postFriendsList = postRepository.;
                    model.addAttribute("users", users);
                    return "fragments/allUsers ";
                }
            }
        }
        String message = "nie posiadasz uprawnień, Twoje uprawnienia to : " + user.getAdministrativeRights();
        model.addAttribute("message", message);
        return "fragments/message";
    }
}
