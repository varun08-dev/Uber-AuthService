package org.varun.uberauthservice.Dtos;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerSignUpRequestDto {

    private String name;

    private  String email;

    private String phoneNumber;

    private String password;
}
