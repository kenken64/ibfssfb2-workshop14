package sg.edu.nus.iss.app.workshop14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import sg.edu.nus.iss.app.workshop14.model.Contact;
import sg.edu.nus.iss.app.workshop14.services.AddressbookService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddressbookController {
    @Autowired
    private AddressbookService addrbkSvc;

    @GetMapping(value="/")
    public String showContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }
    
      
}
