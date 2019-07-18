package com.struti.flightcheckin.Integration;

import com.struti.flightcheckin.DTO.Reservation;
import com.struti.flightcheckin.DTO.ReservationUpdateRequest;

public interface IReservationRestClient {

    Reservation findReservation(Long id);

    Reservation updateReservation(ReservationUpdateRequest request);
}
