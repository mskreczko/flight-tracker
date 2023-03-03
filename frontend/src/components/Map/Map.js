import { React, useEffect, useState } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import { icon } from './Icon';
import { fetchFlights } from '../Flights/Flights';
import 'leaflet/dist/leaflet.css';
import FlightDetailsPopup from '../Flights/FlightDetailsPopup';

const WGS84ToOSM = (lat, lon) => {

    const RAD2DEG = 180 / Math.PI;
    const PI_4 = Math.PI / 4;

    let x = lon;
    let y = Math.log(Math.tan((lat / 90 + 1) * PI_4)) * RAD2DEG;

    if (isNaN(x) || isNaN(y)) {
        return [-1, -1];
    }

    return [x, y];
}

export default function Map() {
    const [flights, setFlights] = useState([]);

    useEffect(() => {
        const interval = setInterval(() => {
            fetchFlights().then((resp) => resp.json()).then((body) => {
                let arr = [];
                for (let i = 0; i < body.states.length; i++) {
                    if (body.states[i][3] != null && body.states[i][4] != null) {
                        let [newLon, newLot] = WGS84ToOSM(body.states[i][5], body.states[i][6]);
                        body.states[i][5] = newLon;
                        body.states[i][6] = newLot;
                        arr.push(body.states[i]);
                    }
                }
                setFlights(arr);
            })
    }, 10000);
    return () => clearInterval(interval);
    }, []);

    return (
        <MapContainer center={[40.505, -100.09]} zoom={5} style={{minHeight: '100vh', width: '100%'}}>
            <TileLayer attribution='&copy; <a href="https://osm.org/copyright">OpenStreetMap</a> contributors' url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>

            { flights.length > 0 ? flights.map((state) => (
                <Marker key={state[0]} position={[state[5], state[6]]} icon={icon}>
                    <FlightDetailsPopup state={state}/>
                </Marker>
            )) : null }
        </MapContainer>
    )
}