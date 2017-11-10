package za.co.reverside.takealot_replica.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateEmailController {

    private String updateEmailPage = "template/update-email";

    @GetMapping("/updateEmail")
    public String getUpdateEmailPage(Model model) {
        model.addAttribute("page", updateEmailPage);
        return "account";
    }
}