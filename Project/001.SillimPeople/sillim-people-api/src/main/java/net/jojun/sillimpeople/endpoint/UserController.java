package net.jojun.sillimpeople.endpoint;

import net.jojun.sillimpeople.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JOJUN.
 * Date: 2020-07-07
 */
@RestController
public class UserController {

    @Autowired
    UserService UserService;

    @GetMapping
    public String helloWorld(){
        return "HelloWorld";
    }


    @GetMapping("/printUser")
    public String printUser(){


        return "called";
    }


}
