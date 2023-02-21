package com.sky.controller;

import com.sky.model.Request;
import com.sky.model.Response;
import com.sky.service.UserInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/sky")
public class UserInformationController {

    @Autowired
    private UserInformationService userInformationService;

    @PostMapping("/middleware/user")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Response> getUser(@RequestBody(required = false) Request request) {
        return userInformationService.consult(request);
    }

}
