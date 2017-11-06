package za.co.reverside.takealot_replica.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateEmailController {

    private String updateEmailPage = "template/update-email";

    @RequestMapping(value = "/updateEmail", method = RequestMethod.GET)
    public String getUpdateEmailPage(Model model) {
        model.addAttribute("page", updateEmailPage);
        return "account";
    }
}