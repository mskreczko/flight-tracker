package pl.mskreczko.trackingapi.flights.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

@Getter
@Setter
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightStateDto {

    private String icao;

    private String callsign;

    private String originCountry;

    private Integer timePosition;

    private Integer lastContact;

    private Double longitude;

    private Double latitude;

    private Double baroAltitude;

    private Boolean onGround;

    private Double velocity;

    private Double trueTrack;

    private Double verticalRate;

    private Integer[] sensors;

    private Double geoAltitude;

    private String squawk;

    private Boolean spi;

    private Integer positionSource;

    private Integer category;
}
