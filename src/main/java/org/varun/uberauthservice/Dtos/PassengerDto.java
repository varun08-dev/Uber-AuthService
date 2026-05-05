package org.varun.uberauthservice.Dtos;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {

    private String id;

    private String name;

    private  String email;

    private String phoneNumber;

    private String password;

    private Date createdAt;
}
