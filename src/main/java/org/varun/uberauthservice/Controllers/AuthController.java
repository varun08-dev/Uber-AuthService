package org.varun.uberauthservice.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.varun.uberauthservice.Dtos.PassengerDto;
import org.varun.uberauthservice.Dtos.PassengerSignUpRequestDto;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @PostMapping("/signup/passenger")
    public ResponseEntity<?> signUp(@RequestBody PassengerSignUpRequestDto passengerSignUpRequestDto){
        return  null;
    }
}
