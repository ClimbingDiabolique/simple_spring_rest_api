package ge.ibsu.demo.controllers;

import ge.ibsu.demo.DTO.AddCustomerDTO;
import ge.ibsu.demo.services.CustomerService;
import ge.ibsu.demo.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @ResponseBody
    @RequestMapping(value = "/all", method = RequestMethod.GET,produces  = {"application/json"})
    public List<Customer> getAll(){
        return customerService.retrieveAllCustomer();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = {"application/json"})
    public Customer getOne(@PathVariable Long id){
        return customerService.getOne(id);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST,produces = {"application/json"})
    public Customer addCustomer(@RequestBody AddCustomerDTO rd){
        return customerService.addCustomer(rd);
    }
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT,produces = {"application/json"})
    public Customer addCustomer(@PathVariable Long id, @RequestBody AddCustomerDTO addCustomerDTO) throws Exception {
        return customerService.editCustomer(id, addCustomerDTO);
    }

}
