package com.azecoders.community.controller;

import com.azecoders.community.model.request.create.CreateCompleteProfileRequest;
import com.azecoders.community.service.concrete.UserServiceHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceHandler serviceHandler;


    @PostMapping("/complete")
    @ResponseStatus(HttpStatus.OK)
    public void completeProfile(@RequestBody CreateCompleteProfileRequest profileRequest,
                                @AuthenticationPrincipal UserDetails userDetails) {
        serviceHandler.completeProfile(profileRequest, userDetails.getUsername());
    }
}
