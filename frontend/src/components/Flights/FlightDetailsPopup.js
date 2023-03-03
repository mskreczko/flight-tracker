import { Popup } from "react-leaflet";
import { useState, useEffect } from 'react';

export default function FlightDetailsPopup(props) {
    const [flightState, setFlightState] = useState([]);

    useEffect(() => {
        setFlightState(props.state);
    }, []);

    return (
        <Popup>
            <p>ICAO: {flightState[0]}</p>
            <p>Callsign: {flightState[1] ? flightState[1] : 'N/A'}</p>
            <p>Country of origin: {flightState[2]}</p>
            <p>Velocity: {flightState[9] ? flightState[9] + ' m/s': 'N/A'}</p>
            <p>Altitude: {flightState[13] ? flightState[13] + ' m' : 'N/A'}</p>
        </Popup>
    )
}