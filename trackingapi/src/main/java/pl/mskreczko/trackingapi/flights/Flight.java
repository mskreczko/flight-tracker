package pl.mskreczko.trackingapi.flights;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.mskreczko.trackingapi.flights.dto.FlightStateDto;

@NoArgsConstructor
@Getter
@Setter
public class Flight {

    private String icao;

    private String callsign;

    private String originCountry;

    private Double longitude;

    private Double latitude;

    private Double baroAltitude;

    private Double velocity;

    private Double geoAltitude;

    private String squawk;

    private Integer category;

    public Flight(FlightStateDto flightState) {
        this.icao = flightState.getIcao();
        this.callsign = flightState.getCallsign();
        this.originCountry = flightState.getOriginCountry();
        this.longitude = flightState.getLongitude();
        this.latitude = flightState.getLatitude();
        this.baroAltitude = flightState.getBaroAltitude();
        this.velocity = flightState.getVelocity();
        this.geoAltitude = flightState.getGeoAltitude();
        this.squawk = flightState.getSquawk();
        this.category = flightState.getCategory();
    }
}