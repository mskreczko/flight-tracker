export const fetchFlights = async () => {
    return await fetch('http://localhost:8080/api/v1/flights');
}

export const fetchFlightDetails = (icao) => {
    return fetch('http://localhost:8080/api/v1/flights?icao=' + icao);
}