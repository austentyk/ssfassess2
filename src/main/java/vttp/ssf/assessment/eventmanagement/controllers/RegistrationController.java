package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.User;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping("/event")
public class RegistrationController {
    

    @Autowired
    public DatabaseService databaseService;

    @GetMapping("/register/{id}")
    public String register() {
        return "eventregister";
    }

    @PostMapping("/register/complete")
    public String processRegister(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if ((user.getPhoneNo().toString().startsWith("8")) || (user.getPhoneNo().toString().startsWith("8")))
        {
        
        if (bindingResult.hasErrors()) {
            return "eventregister";
        }
        String dateCheck = user.getDOB().toString().substring(0,4);

        int checking = Integer.parseInt(dateCheck);
        
        boolean firstCheck = ((2023 - checking) >= 21);

        boolean secondCheck = false;

        //secondcheck for participants.

        if ((firstCheck != false) && (secondCheck == false)) { 
        return "success"; } else {
            return "error";
        }
        }
        else {
            bindingResult.addError(new FieldError("event", "phoneNo", "Phone number must start with 8 or 9"));
            return "eventregister";
        
    }
}

}
