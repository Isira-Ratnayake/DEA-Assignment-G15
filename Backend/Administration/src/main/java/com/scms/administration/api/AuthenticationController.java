package com.scms.administration.api;

import com.scms.administration.dto.LoginResponse;
import com.scms.administration.dto.RequireAuthResponse;
import com.scms.administration.security.EntryUserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @GetMapping("requireauth")
    public ResponseEntity<RequireAuthResponse> requireAuthHandler() {
        return new ResponseEntity<>(new RequireAuthResponse(true), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> loginHandler() {
        EntryUserDetails entryUserDetails = (EntryUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LoginResponse loginResponse = new LoginResponse(
                entryUserDetails.getUser().getUsername(),
                entryUserDetails.getUser().getRole().getRoleDescription(),
                entryUserDetails.getToken()
        );
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}

