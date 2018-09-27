package com.telecom.controllers;

import com.telecom.database.CustomerRepository;
import com.telecom.models.Customer;
import com.telecom.models.PhoneNumber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Stefan on 9/27/2018.
 */
@RestController
public class HomeController {

    private CustomerRepository repo = new CustomerRepository();

    //Retrieve a list of all phone numbers existend
    //endpoint : localhost:8080/getAllPhoneNumbers
    @RequestMapping(value = "/getAllPhoneNumbers")
    public List<PhoneNumber> getAllPhoneNumbers() {

        return repo.getNumbers();
    }

    @RequestMapping(value = "/init")
    public void init() {
        repo.generateCustomers();
    }

    //Retrieve a list of all phone numbers of a certain custoemr
    //endpoint : localhost:8080/getPhoneNumbersForCustomer
    @RequestMapping(value = "/getPhoneNumbersForCustomer")
    public List<PhoneNumber> getPhoneNumbersForCustomer(int customerId) {
        List<Customer> customers = repo.getCustomers();
        Customer customer = customers.stream().filter(cust -> cust.getId() == customerId).findFirst().get();
        return customer.getPhoneNumbers();
    }

    //activate a given phone number
    //endpoint : localhost:8080/activatePhoneNumber
    @RequestMapping(value = "/activatePhoneNumber")
    public String activatePhoneNumber(int phoneNumber) {
        List<Customer> customers = repo.getCustomers();
        PhoneNumber phone = null;
        for (Customer customer : customers) {
            if (customer.getPhoneNumbers().stream().anyMatch(number -> number.getNumber() == phoneNumber)) {
                phone = customer.getPhoneNumbers().stream().filter(number -> number.getNumber() == phoneNumber).findFirst().get();
            }
        }
        if (phone != null) {
            phone.setActivated(true);
            return phoneNumber + "-> is Activated!(" + phone.isActivated() + ")";
        }
        return "The phone number could not be found!";
    }


}
