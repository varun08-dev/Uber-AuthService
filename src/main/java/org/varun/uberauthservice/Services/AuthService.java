package org.varun.uberauthservice.Services;

import org.springframework.stereotype.Service;
import org.varun.uberauthservice.Dtos.PassengerDto;
import org.varun.uberauthservice.Dtos.PassengerSignUpRequestDto;
import org.varun.uberauthservice.Models.Passenger;
import org.varun.uberauthservice.Repositories.PassengerRepository;

@Service
public class AuthService {

    private  final PassengerRepository passengerRepository;

    public AuthService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public PassengerDto passengerSignUp(PassengerSignUpRequestDto passengerSignUpRequestDto) {

        Passenger passenger = Passenger.builder()
                .name(passengerSignUpRequestDto.getName())
                .email(passengerSignUpRequestDto.getEmail())
                .phoneNumber(passengerSignUpRequestDto.getPhoneNumber())
                .password(passengerSignUpRequestDto.getPassword())    //todo:have to hash password
                .build();

        passengerRepository.save(passenger);

        return new PassengerDto().from(passenger);


    }

}
