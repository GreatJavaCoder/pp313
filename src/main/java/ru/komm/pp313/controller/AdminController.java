package ru.komm.pp313.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.komm.pp313.model.User;
import ru.komm.pp313.service.RoleService;
import ru.komm.pp313.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String showAdminPage() {
        return "adminpage";
    }

    @GetMapping("/create")
    public String showCreatePage(Model model) {
        model.addAttribute("user", new User());
        return "usr/newuser";
    }

    @GetMapping("/newuser")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "usr/newuser";
    }

    @PostMapping("/addnewuser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/admin/read";
    }

    @GetMapping("/personalpage")
    public String showPersonalPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", userService.getUser(id));
        return "usr/personalpage";
    }

    @GetMapping("/edituser")
    public String showEditUserForm(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "usr/edituser";
    }

    @PatchMapping("/personaleditpage")
    public String saveEditedUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.editUser(id, user);
        return "redirect:/admin/read";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/admin/read";
    }

    @GetMapping("/read")
    public String showReadPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usr/readpage";
    }

    @GetMapping("/update")
    public String showUpdatePage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usr/updatepage";
    }

    @GetMapping("/personaleditpage")
    public String showPersonalEditPage(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", userService.getUser(id));
        return "usr/personaleditpage";
    }

    @GetMapping("/delete")
    public String showDeletePage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "usr/deletepage";
    }

    @GetMapping("/personaldeletepage")
    public String showPersonalDeletePage(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", userService.getUser(id));
        return "usr/personaldeletepage";
    }
}
