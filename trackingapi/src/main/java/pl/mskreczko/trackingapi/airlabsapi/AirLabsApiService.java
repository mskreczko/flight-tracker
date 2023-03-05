package pl.mskreczko.trackingapi.airlabsapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class AirLabsApiService {

    @Value("${api.key}")
    private String API_KEY ;
    private final static String API_ROOT_URL = "https://airlabs.co/api/v9/flights?_fields=hex,dir&api_key=";

    private Map<String, Integer> mapResponse(String response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = objectMapper.readValue(response, ObjectNode.class);

        Map<String, Integer> directions = new HashMap<>();
        for (JsonNode n : node.get("response")) {
            if (n.get("hex") == null) {
                continue;
            }
            directions.put(n.get("hex").asText(), n.get("dir").asInt());
        }

        return directions;
    }

    public Map<String, Integer> getFlightsDirection() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        return mapResponse(restTemplate.getForObject(API_ROOT_URL + API_KEY, String.class));
    }
}
