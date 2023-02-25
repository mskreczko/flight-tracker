import React from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import { icon } from './Icon';
import 'leaflet/dist/leaflet.css';

export default function Map() {

    return (
        <MapContainer center={[40.505, -100.09]} zoom={5} style={{minHeight: '100vh', width: '100%'}}>
            <TileLayer attribution='&copy; <a href="https://osm.org/copyright">OpenStreetMap</a> contributors' url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>

            <Marker position={[40.505, -100.09]} icon={icon}>
                <Popup>
                    <h1>popup</h1>
                </Popup>
            </Marker>
        </MapContainer>
    )
}