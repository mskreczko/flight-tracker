package pl.mskreczko.trackingapi.flights;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mskreczko.trackingapi.openskyapi.OpenSkyApiService;

import java.io.IOException;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/flights")
public class FlightsController {

    private final OpenSkyApiService openSkyApiService;


    @GetMapping
    public ResponseEntity<?> getAllFlights() {
        try {
            return ResponseEntity.ok(openSkyApiService.getFlights());
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
