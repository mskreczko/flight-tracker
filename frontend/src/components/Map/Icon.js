import L from 'leaflet';

const icon = new L.icon({
    iconUrl: 'airplane.svg',
    iconRetinaUrl: 'airplane.svg',
    iconAnchor: null,
    popupAnchor: new L.point(0, 0),
    shadowUrl: null,
    shadowSize: null,
    shadowAnchor: null,
    iconSize: new L.Point(20, 20)
});

export { icon }