package com.company.controller;


import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {


    private final UserServiceInter userService;

    public UserController(UserServiceInter userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              @RequestParam(value = "nationality", required = false) Integer nationality) {

        System.out.println("SIIGN-------------saccsdcdc--s-dc 1");
        List<User> list = userService.getAll(name, surname, nationality);

        ModelAndView mv = new ModelAndView("users");
        mv.addObject("usersList", list);


        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView index(@Valid @ModelAttribute("user") UserForm u, BindingResult bindingResult) {

        System.out.println("SIIGN-------------saccsdcdc--s-dc 1");

        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            return mv;
        }

        List<User> list = userService.getAll(u.getName(), u.getSurname(), u.getNationality());
        mv.addObject("usersList", list);

        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        System.out.println("Login");
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout() {
        System.out.println("Logout");
        return "logout";
    }


//
//    @RequestMapping(method = RequestMethod.GET, value = "/foo")
//    public String foo(){
//        System.out.println("foo in ;controller");
//        dummyService.foo();
//        return "users";
//    }


    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm(null, null, null);
    }

}
