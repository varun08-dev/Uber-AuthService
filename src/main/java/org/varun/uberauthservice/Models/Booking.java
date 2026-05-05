package org.varun.uberauthservice.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseModel {




    @Enumerated(value= EnumType.STRING)
    private  BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startedAt;

    @Temporal(value =TemporalType.TIMESTAMP)
    private  Date endAt;

    private Double totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Passenger passenger;
}
