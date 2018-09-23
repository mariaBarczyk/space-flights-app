package com.mycompany.spaceflights.bootstrap;

import com.mycompany.spaceflights.domain.Flight;
import com.mycompany.spaceflights.domain.Gender;
import com.mycompany.spaceflights.domain.Tourist;
import com.mycompany.spaceflights.repository.FlightRepository;
import com.mycompany.spaceflights.repository.TouristRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Component
public class Bootstrap implements CommandLineRunner {

    private FlightRepository flightRepository;
    private TouristRepository touristRepository;

    public Bootstrap(FlightRepository flightRepository, TouristRepository touristRepository) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Tourist tourist1 = new Tourist();
        tourist1.setFirstName("Anna");
        tourist1.setLastName("Bullock");
        tourist1.setCountry("France");
        tourist1.setGender(Gender.FEMALE);
        tourist1.setDateOfBirth(LocalDate.of(1990, 10, 12));

        Tourist tourist2 = new Tourist();
        tourist2.setFirstName("Ronie");
        tourist2.setLastName("Adro");
        tourist2.setCountry("Italy");
        tourist2.setGender(Gender.FEMALE);
        tourist2.setDateOfBirth(LocalDate.of(1991, 1, 30));

        Tourist tourist3 = new Tourist();
        tourist3.setFirstName("Simon");
        tourist3.setLastName("Crowd");
        tourist3.setCountry("USA");
        tourist3.setGender(Gender.MALE);
        tourist3.setDateOfBirth(LocalDate.of(1985, 3, 3));

        Set<Tourist> tourists = new HashSet<>();
        tourists.add(tourist1);
        tourists.add(tourist2);
        tourists.add(tourist3);

        touristRepository.save(tourist1);
        touristRepository.save(tourist2);
        touristRepository.save(tourist3);

        Flight flight1 = new Flight();
        flight1.setArrival(LocalDateTime.of(2018, 12, 15, 14, 30, 0));
        flight1.setDeparture(LocalDateTime.of(2018, 12, 15, 18, 50, 0));
        flight1.setNumberOfSeats(300);
        flight1.setTicketPrice(1000);

        flight1.setTourists(tourists);

        Flight flight2 = new Flight();
        flight2.setArrival(LocalDateTime.of(2018, 11, 15, 8, 40, 0));
        flight2.setDeparture(LocalDateTime.of(2018, 11, 15, 12, 00, 0));
        flight2.setNumberOfSeats(200);
        flight2.setTicketPrice(1500);

        flightRepository.save(flight1);
        flightRepository.save(flight2);
    }
}
