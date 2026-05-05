package org.varun.uberauthservice.Dtos;

import lombok.*;
import org.varun.uberauthservice.Models.Passenger;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    private Long id;

    private String name;

    private  String email;

    private String phoneNumber;

    private String password;

    private Date createdAt;

    public  PassengerDto from(Passenger passenger){

        PassengerDto passengerDto = PassengerDto.builder()
                .id(passenger.getId())
                .name(passenger.getName())
                .email(passenger.getEmail())
                .phoneNumber(passenger.getPhoneNumber())
                .password(passenger.getPassword())
                .createdAt(passenger.getCreatedAt())
                .build();

        return  passengerDto;
    }
}
