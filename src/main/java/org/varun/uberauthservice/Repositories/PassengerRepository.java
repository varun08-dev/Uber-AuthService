package org.varun.uberauthservice.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.varun.uberauthservice.Models.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
