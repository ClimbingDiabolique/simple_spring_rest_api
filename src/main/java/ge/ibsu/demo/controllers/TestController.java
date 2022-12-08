package ge.ibsu.demo.controllers;

import ge.ibsu.demo.DTO.Test;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/test")
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/about", method = RequestMethod.GET, produces = {"application/json"})
    public String test(){
        return "hello";
    }
    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = {"application/json"})
    public String testPost(@RequestBody Test rd){

        return "hello, mr. " + rd.getFirstName() + " <3";
    }
}
