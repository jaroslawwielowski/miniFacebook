package pl.coderslab.finalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;
import pl.coderslab.finalproject.dto.PostDto;
import pl.coderslab.finalproject.dto.UserGroupDto;
import pl.coderslab.finalproject.entity.Post;
import pl.coderslab.finalproject.entity.User;
import pl.coderslab.finalproject.entity.UserGroup;
import pl.coderslab.finalproject.repository.PostRepository;
import pl.coderslab.finalproject.repository.UserGroupRepository;
import pl.coderslab.finalproject.repository.UserRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/group")
class UserGroupController {

    private final UserGroupRepository userGroupRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    UserGroupController(UserGroupRepository userGroupRepository, UserRepository userRepository, PostRepository postRepository) {
        this.userGroupRepository = userGroupRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
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

    @GetMapping(value = "/allMy")
    public String allMyGroup(Model model, HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                List<UserGroup> allGroupList = userGroupRepository.getUserGroupsByUserList(user);
                Collections.reverse(allGroupList);
                model.addAttribute("groups", allGroupList);
                return "fragments/allGroup";
            }
        }
        String message = "coś poszło nie tak :( " ;
        model.addAttribute("message", message);
        return "fragments/message";
    }


    @GetMapping("/{id}")
    public String logOutUser(@PathVariable Long id, Model model, HttpServletRequest request){
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {

                UserGroup userGroup = new UserGroup();
                userGroup = userGroupRepository.getOne(id);
                List<Post> allpostList = postRepository.getPostsByUserGroup(userGroup);
                Collections.reverse(allpostList);
                model.addAttribute("userGroup", userGroup);
                model.addAttribute("posts", allpostList);
                model.addAttribute("user", user);
                return "User/GroupPage";
            }
        }
        String message = "coś poszło nie tak :( " ;
        model.addAttribute("message", message);
        return "fragments/message";

    }

    @PostMapping(value = "posts/add")
    public String red(Model model, @ModelAttribute Post post){
        model.addAttribute(post);
        return "redirect:/posts/add";
    }
//    @PostMapping(value = "{id}")
//    public String addPost2(@ModelAttribute PostDto postDto,
//                           Model model,
//                           @PathVariable Long id,
//                           @ModelAttribute Long userGroup,
//                           HttpServletRequest request) {
//        Cookie c = WebUtils.getCookie(request, "cookieUser");
//        User user = new User();
//        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
//        if (user!=null) {
//            if (user.isOnline()) {
//                Post post = postDto.toDto();
//                post.setUser(user);
//                if (userGroup!=null){
//                    post.setUserGroup(userGroupRepository.getOne(userGroup));
//                }
//                model.addAttribute("newpost", new Post());
//                try {
//                    postRepository.save(post);
//                }catch (Exception e){
//
//                }
//
//                if (!userGroup.equals(null)){
//                    return "redirect:/group/" + userGroup;
//                }
//                return "redirect:/";//"fragments/addPost";
//            }
//        }
//        return "index";
//    }


//
}
