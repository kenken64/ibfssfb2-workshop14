package sg.edu.nus.iss.app.workshop14.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.app.workshop14.model.Contact;
import sg.edu.nus.iss.app.workshop14.repositories.AddressbookRepository;

@Service
public class AddressbookService {
    @Autowired
    private AddressbookRepository addrbookRepo;

    public void saveContact(final Contact ctc){
        addrbookRepo.save(ctc);
    }

    public Contact findContactById(String contactId){
        return addrbookRepo.findById(contactId);
    }

    public List<Contact> getAllContact(int startIndex){
        return addrbookRepo.findAll(startIndex);
    }
}
