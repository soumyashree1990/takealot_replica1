package za.co.reverside.takealot_replica.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddressController {

    private static String changeAddressPage = "template/changeAddress";

    @RequestMapping(value = "/addressDetails", method = RequestMethod.GET)
    public String getAddressDetailsPage(HttpServletRequest request, Model model) {
        model.addAttribute("page", changeAddressPage);
        return "account";

    }
}