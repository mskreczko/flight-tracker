package pl.mskreczko.trackingapi.openskyapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mskreczko.trackingapi.flights.dto.FlightStateDto;
import pl.mskreczko.trackingapi.openskyapi.dto.OpenSkyApiResponseDto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OpenSkyApiService {
    private final static String API_ROOT_URL = "https://opensky-network.org/api";

    private OpenSkyApiResponseDto mapResponse(String response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.readValue(response, ObjectNode.class);

        Integer time = node.get("time").asInt();
        List<FlightStateDto> states = new ArrayList<>();
        for (JsonNode n : node.get("states")) {
            states.add(objectMapper.convertValue(n, FlightStateDto.class));
        }
        return new OpenSkyApiResponseDto(time, states);
    }

    public OpenSkyApiResponseDto getFlights() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        return mapResponse(restTemplate.getForObject(API_ROOT_URL + "/states/all", String.class));
    }
}
