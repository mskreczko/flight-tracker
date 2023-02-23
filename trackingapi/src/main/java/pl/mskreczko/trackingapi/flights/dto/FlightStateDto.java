package pl.mskreczko.trackingapi.flights.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightStateDto {

    @JsonProperty(index = 0)
    private String icao;

    @JsonProperty(index = 1)
    private String callsign;

    @JsonProperty(index = 2)
    private String originCountry;

    @JsonProperty(index = 5)
    private Double longitude;

    @JsonProperty(index = 6)
    private Double latitude;

    @JsonProperty(index = 7)
    private Double baroAltitude;

    @JsonProperty(index = 9)
    private Double velocity;

    @JsonProperty(index = 13)
    private Double geoAltitude;

    @JsonProperty(index = 14)
    private String squawk;

    @JsonProperty(index = 17)
    private Integer category;
}
