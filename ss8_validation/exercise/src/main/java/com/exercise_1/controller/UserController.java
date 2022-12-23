package com.exercise_1.controller;

import com.exercise_1.dto.UserDTO;
import com.exercise_1.model.User;
import com.exercise_1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("list", userService.findAll());
        return "user/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "user/create";
    }

    @PostMapping("/create")
    public String createUser(@Validated @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new UserDTO().validate(userDTO,bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.save(user);
        redirectAttributes.addFlashAttribute("mess","Thêm mới thành công");
        return "redirect:/user/";
    }
}
