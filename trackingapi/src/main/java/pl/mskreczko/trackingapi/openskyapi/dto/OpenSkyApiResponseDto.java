package pl.mskreczko.trackingapi.openskyapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mskreczko.trackingapi.flights.dto.FlightStateDto;

import java.util.List;

@Getter
@AllArgsConstructor
public class OpenSkyApiResponseDto {

    @JsonProperty("time")
    private Integer time;

    @JsonProperty("states")
    private List<FlightStateDto> states;
}
