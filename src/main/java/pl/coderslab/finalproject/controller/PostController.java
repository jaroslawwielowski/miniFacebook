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
import java.util.*;

@Controller
@RequestMapping(value = "posts")
class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    @GetMapping(value = "/all")
    public String allPost(Model model, HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                    List<Post> allPostList = postRepository.findAll();

                Collections.reverse(allPostList);

                    model.addAttribute("posts", allPostList);

                    return "fragments/allPost";
            }
        }
        String message = "coś poszło nie tak :( " ;
        model.addAttribute("message", message);
        return "fragments/message";
    }


    @GetMapping(value = "/allMy")
    public String allFriendPost(Model model, HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {

                List<User> friendList = new ArrayList<>();
                friendList.add(user);
                List<Post> postFriendsAndMyList =  postRepository.getPostsByUser(friendList);


                model.addAttribute("posts", postFriendsAndMyList);
                return "fragments/allPost";
            }
        }
        String message = "coś poszło nie tak :( " ;
        model.addAttribute("message", message);
        return "fragments/message";
    }


    @GetMapping(value = "/add")
    public String addPost1(Model model,HttpServletRequest request) {

        model.addAttribute("newpost" , new Post());
        return "fragments/addPost";
    }

    @PostMapping(value = "/add")
    public String addPost2(@ModelAttribute PostDto postDto,
                           Model model,
                           HttpServletRequest request) {
        Cookie c = WebUtils.getCookie(request, "cookieUser");
        User user = new User();
        user= userRepository.getUserByConfirmationOnlineId(c.getValue());
        if (user!=null) {
            if (user.isOnline()) {
                    Post post = postDto.toDto();
                    post.setUser(user);
                    model.addAttribute("newpost", new Post());
                    postRepository.save(post);
                    return "redirect:/";//"fragments/addPost";
            }
        }
        return "index";
    }

//    @GetMapping(value = "/onlyPage")
//    public String a(Model model,HttpServletRequest request) {
//
//        return "User/OnlyPage";
//    }
}
