package org.varun.uberauthservice.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.varun.uberauthservice.Dtos.PassengerDto;
import org.varun.uberauthservice.Dtos.PassengerSignUpRequestDto;
import org.varun.uberauthservice.Models.Passenger;
import org.varun.uberauthservice.Repositories.PassengerRepository;

@Service
public class AuthService {

    private  final PassengerRepository passengerRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthService(PassengerRepository passengerRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.passengerRepository = passengerRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public PassengerDto passengerSignUp(PassengerSignUpRequestDto passengerSignUpRequestDto) {

        Passenger passenger = Passenger.builder()
                .name(passengerSignUpRequestDto.getName())
                .email(passengerSignUpRequestDto.getEmail())
                .phoneNumber(passengerSignUpRequestDto.getPhoneNumber())
                .password(bCryptPasswordEncoder.encode(passengerSignUpRequestDto.getPassword())) //todo:have to hash password
                .build();

        passengerRepository.save(passenger);

        return new PassengerDto().from(passenger);


    }

}
