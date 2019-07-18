package com.struti.flightcheckin.Integration;


import com.struti.flightcheckin.DTO.Reservation;
import com.struti.flightcheckin.DTO.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ReservationRestClientImpl implements IReservationRestClient {

    private static final String RESERVATION_URL = "http://localhost:8080/flightreservation/reservations/" ;

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject( RESERVATION_URL+id, Reservation.class);
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(RESERVATION_URL,request,Reservation.class);
    }
}
