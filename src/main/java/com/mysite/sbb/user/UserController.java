package com.mysite.sbb.user;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String signup(@ModelAttribute("siteUserForm") SiteUserForm siteUserForm) {

        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid SiteUserForm siteUserForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!siteUserForm.getPassword1().equals(siteUserForm.getPassword2())) {
            bindingResult.rejectValue("password2","passwordInCorrect","비밀번호가 일치하지 않습니다");
            return "signup_form";
        }
        userService.create(siteUserForm.getUsername(), siteUserForm.getEmail(), siteUserForm.getPassword1());
        return "redirect:/";
    }
}
