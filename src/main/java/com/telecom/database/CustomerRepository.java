package com.telecom.database;

import com.telecom.models.Customer;
import com.telecom.models.PhoneNumber;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Stefan on 9/27/2018.
 */
public class CustomerRepository {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<PhoneNumber> numbers) {
        this.numbers = numbers;
    }

    private List<PhoneNumber> numbers = new ArrayList<>();

    public void generateCustomers() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(new PhoneNumber(random.nextInt()));
        }
        byte[] firstNames;
        byte[] lastNames;
        for (int i = 0; i < 10; i++) {
            firstNames = new byte[7];
            lastNames = new byte[7];
            random.nextBytes(firstNames);
            random.nextBytes(lastNames);
            customers.add(new Customer(i, new String(firstNames, Charset.defaultCharset()), new String(lastNames, Charset.defaultCharset()), Arrays.asList(numbers.get(i))));
        }


    }
}
