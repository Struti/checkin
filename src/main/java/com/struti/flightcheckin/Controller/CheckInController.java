package com.struti.flightcheckin.Controller;

import com.struti.flightcheckin.DTO.Reservation;
import com.struti.flightcheckin.DTO.ReservationUpdateRequest;
import com.struti.flightcheckin.Integration.IReservationRestClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckInController {

    private IReservationRestClient reservationRestClient;

    public CheckInController(IReservationRestClient reservationRestClient){
        this.reservationRestClient=reservationRestClient;
    }

    @RequestMapping("/showStartCheckIn")
    public String showStartCheckIn(){

        return "startCheckIn";
    }

    @RequestMapping("/startCheckIn")
    public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap){

        Reservation reservation = reservationRestClient.findReservation(reservationId);
        modelMap.addAttribute("reservation", reservation);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
                                  @RequestParam("numberOfBags") int numberOfBags){

        ReservationUpdateRequest request = new ReservationUpdateRequest();

        request.setId(reservationId);
        request.setNumberOfBags(numberOfBags);
        request.setCheckedIn(true);
        reservationRestClient.updateReservation(request);

        return "checkInConformation";
    }
}
