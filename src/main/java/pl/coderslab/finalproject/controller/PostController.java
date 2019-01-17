package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;
import pl.coderslab.finalproject.dto.PostDto;
import pl.coderslab.finalproject.dto.UserDto;
import pl.coderslab.finalproject.entity.Post;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.enums.UserPrivileges;
import pl.coderslab.finalproject.repository.PostRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


//    @GetMapping(value = "/all")
//    public String allFriendPost(Model model, HttpServletRequest request) {
//        Cookie c = WebUtils.getCookie(request, "cookieUser");
//        User user = new User();
//        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
//        if (user!=null) {
//            if (user.isOnline()) {
//                    List<Post> postFriendsList = postRepository.findAll();
//                    model.addAttribute("posts", postFriendsList);
//                    return "fragments/Post ";
//            }
//        }
//        String message = "nie posiadasz uprawnień, Twoje uprawnienia to : " + user.getAdministrativeRights();
//        model.addAttribute("message", message);
//        return "fragments/message";
//    }


    @GetMapping(value = "/add")
    public String addPost1(Model model,HttpServletRequest request) {
//        User user = new User();
//        Cookie c = WebUtils.getCookie(request, "cookieUser");
//        String message = null;
//        try {
//            user= userRepository.getUserByConfirmationOnlineId(c.getValue());
//        }catch (Exception e){
//            message = "ups,coś poszło nie tak" + e;
//        }
//        if (user!=null) {
//            if (user.isOnline()) {
//                message = " jests już zalogowany "+ user.getFirstName() + " " + user.getLastName();
//                model.addAttribute( "message" , message);
//                model.addAttribute("user", user);
//                return "piece/FirstUserPlace";
//            }
//        }
//        model.addAttribute("user", new User());
        Post post = new Post();
        model.addAttribute("post" , post);
        return "fragments/addPost";
    }


//    @PostMapping(value = "/add")
//    public String addPost2(@ModelAttribute PostDto postDto,
//                           Model model,
//                           HttpServletResponse response,
//                           HttpServletRequest request) {
//        User user = userRepository.getUserByEmail(userDto.getEmail());
//        String message = "nieprawidłowy login lub hasło";
//
//        if(user!=null){
//            if (user.isConfirmationStatus()) {
//                if (user.passwordMatches(userDto.getPassword())){
//                    message = "Witaj " + user.getFirstName() + " " + user.isOnline();
//                    user.setOnline(true);
//                    String onlineId = createConfirmationID();
//                    user.setConfirmationOnlineId(onlineId);
//                    Cookie cookieUser = new Cookie("cookieUser", onlineId);
//                    cookieUser.setPath("/");
//                    response.addCookie(cookieUser);
//                    userRepository.save(user);
//                    message = "usało się :)";
//                    model.addAttribute("message", message);
//                    model.addAttribute("user", user);
//                    return "index";
//                }
//            }
//        }
//
//        model.addAttribute("user", new User());
//        model.addAttribute("message", message);
////        return "redirect:/";
//        Post post =
//    }
}
