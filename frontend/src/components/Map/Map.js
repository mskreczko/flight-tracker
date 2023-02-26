import { React, useEffect, useState } from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import { icon } from './Icon';
import { fetchFlightDetails, fetchFlights } from '../Flights/Flights';
import 'leaflet/dist/leaflet.css';

export default function Map() {
    const [flights, setFlights] = useState([]);

    useEffect(() => {
        const interval = setInterval(() => {
            fetchFlights().then((resp) => resp.json()).then((body) => {
                let arr = [];
                for (let i = 0; i < 300; i++) {
                    if (body.states[i][3] != null && body.states[i][4] != null) {
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
                </Marker>
            )) : null }
        </MapContainer>
    )
}