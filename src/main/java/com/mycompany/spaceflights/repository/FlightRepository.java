package com.mycompany.spaceflights.repository;

import com.mycompany.spaceflights.domain.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {


}
