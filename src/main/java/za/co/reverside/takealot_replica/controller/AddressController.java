package za.co.reverside.takealot_replica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddressController {

    private static String changeAddressPage = "template/changeAddress";

    @RequestMapping(value = "/addressDetails", method = RequestMethod.GET)
    public String getAddressDetailsPage(HttpServletRequest request, Model model) {
        model.addAttribute("page", changeAddressPage);
        return "account";

    }
}