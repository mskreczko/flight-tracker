package pl.mskreczko.trackingapi.flights.dto;

public record FlightDetailsDto(String icao, String callsign, String originCountry, Double longitude, Double latitude,
                               Double velocity, String squawk, Integer category) {
}
