package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.WebUtils;
import pl.coderslab.finalproject.entity.Friend;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.repository.FriendRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
class FriendController {
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;

    FriendController(UserRepository userRepository, FriendRepository friendRepository) {
        this.userRepository = userRepository;
        this.friendRepository = friendRepository;
    }

    @GetMapping(value = "addToFriend/{id}")
    public String addToFriend(HttpServletRequest request,
                              HttpServletResponse response,
                              Model model,
                              @PathVariable Long id){
        User user = new User();
        String message = null;
        try {
            Cookie c = WebUtils.getCookie(request, "cookieUser");
            if (c.isHttpOnly()) {
                c  =  new  Cookie("cookieUser",  null);
                c.setPath("/" );
                response.addCookie(c);
            }
            user = userRepository.getUserByConfirmationOnlineId(c.getValue());
        }catch (Exception e){
            message = "ups, coś poszło nie tak" + e;
        }

        if (user!=null) {
            if (user.isOnline()) {
                message = "dodałeś do przyjaciół";
                User userFriend = userRepository.getUserById(id);
                Friend friend = new Friend();
                friend.setUser1(user);
                friend.setUser2(userFriend);
                friendRepository.save(friend);
                model.addAttribute( "message" , message);
                model.addAttribute("user", user);
                return "User/OnlyPage";
            }
        }
        return "index";
    }
}
