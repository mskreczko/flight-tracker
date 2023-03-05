package pl.mskreczko.trackingapi.aggregation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import pl.mskreczko.trackingapi.flights.dto.FlightStateDto;

import java.util.List;

@Getter
@AllArgsConstructor
public class ApiResponseDto {

    @JsonProperty("states")
    List<FlightStateDto> states;
}
