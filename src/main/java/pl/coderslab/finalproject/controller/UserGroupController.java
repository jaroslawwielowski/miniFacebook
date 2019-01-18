package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;
import pl.coderslab.finalproject.dto.PostDto;
import pl.coderslab.finalproject.dto.UserGroupDto;
import pl.coderslab.finalproject.entity.Post;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.entity.UserGroup;
import pl.coderslab.finalproject.repository.UserGroupRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/group")
class UserGroupController {

    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;

    UserGroupController(UserGroupRepository userGroupRepository, UserRepository userRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/add")
    public String addGroup1(Model model, HttpServletRequest request) {

        model.addAttribute("newGroup" , new UserGroup());
        return "fragments/AddGroup";
    }

    @PostMapping(value = "/add")
    public String addGroup2(@ModelAttribute UserGroupDto userGroupDto,
                           Model model,
                           HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                UserGroup userGroup = userGroupDto.toDto();
                List<User> userList = new ArrayList<>();
                userList.add(user);
                userGroup.setAdminGroup(user.getId());
                userGroup.setUserList(userList);
                model.addAttribute("newGroup", new UserGroup());
                userGroupRepository.save(userGroup);
                return "redirect:/";  //   "fragme  nts/  addPos  t";
            }
        }
        return "index";
    }

    @GetMapping(value = "/all")
    public String allGroup(Model model, HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                List<UserGroup> allGroupList = userGroupRepository.findAll();
                Collections.reverse(allGroupList);
                model.addAttribute("groups", allGroupList);
                return "fragments/allGroup";
            }
        }
        String message = "coś poszło nie tak :( " ;
        model.addAttribute("message", message);
        return "fragments/message";
    }

//    @GetMapping(value = "/allMy")
//    public String allFriendPost(Model model, HttpServletRequest request) {
//        Cookie c = WebUtils.getCookie(request, "cookieUser");
//        User user = new User();
//        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
//        if (user!=null) {
//            if (user.isOnline()) {
//
//                List<User> friendList = new ArrayList<>();
//                friendList.add(user);
//                List<Post> postFriendsAndMyList =  postRepository.getPostsByUser(friendList);
//
//
//                model.addAttribute("posts", postFriendsAndMyList);
//                return "fragments/allPost";
//            }
//        }
//        String message = "coś poszło nie tak :( " ;
//        model.addAttribute("message", message);
//        return "fragments/message";
//    }
}
