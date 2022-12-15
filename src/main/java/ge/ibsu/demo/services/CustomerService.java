package ge.ibsu.demo.services;

import ge.ibsu.demo.DTO.AddCustomerDTO;
import ge.ibsu.demo.entities.Address;
import ge.ibsu.demo.entities.Customer;
import ge.ibsu.demo.repositories.AddressRepository;
import ge.ibsu.demo.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;
    public List<Customer> retrieveAllCustomer(){
        return customerRepository.findAll();
    }

    public Customer getOne(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    @Transactional
    public Customer addCustomer(AddCustomerDTO addCustomerDTO){
        Customer customer = new Customer();
        customer.setFirstName(addCustomerDTO.getFirstName());
        customer.setLastName(addCustomerDTO.getLastName());
        customer.setEmail(addCustomerDTO.getEmail());
        customer.setCreateDate(new Date());
        customer.setActive(1);

        Address address = new Address();
        address.setAddress(addCustomerDTO.getAddress());

        address = addressRepository.save(address);
        customer.setAddress(address);

        return customerRepository.save(customer);
    }
    @Transactional
    public Customer editCustomer(Long id, AddCustomerDTO addCustomerDTO) throws Exception {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new Exception("customer_not_found"));
        customer.setFirstName(addCustomerDTO.getFirstName());
        customer.setLastName(addCustomerDTO.getLastName());
        customer.setEmail(addCustomerDTO.getEmail());
        customer.getAddress().setAddress(addCustomerDTO.getAddress());
        return customerRepository.save(customer);
    }
}
