package pl.mskreczko.trackingapi.aggregation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mskreczko.trackingapi.aggregation.dto.ApiResponseDto;
import pl.mskreczko.trackingapi.airlabsapi.AirLabsApiService;
import pl.mskreczko.trackingapi.flights.dto.FlightStateDto;
import pl.mskreczko.trackingapi.openskyapi.OpenSkyApiService;
import pl.mskreczko.trackingapi.openskyapi.dto.OpenSkyApiResponseDto;

import java.io.IOException;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class Aggregator {

    private final OpenSkyApiService openSkyApiService;
    private final AirLabsApiService airLabsApiService;

    public ApiResponseDto aggregateData() throws IOException  {
        OpenSkyApiResponseDto responseDto = openSkyApiService.getFlights();
        Map<String, Integer> directions = airLabsApiService.getFlightsDirection();
        for (FlightStateDto state : responseDto.getStates()) {
            if (directions.containsKey(state.getIcao())) {
                state.setDirection(directions.get(state.getIcao()));
            }
        }
        return new ApiResponseDto(responseDto.getStates());
    }
}
