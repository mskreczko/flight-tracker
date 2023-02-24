import React from 'react';
import { Outlet } from 'react-router-dom';
import './MainView.css';

export default function MainView() {
    return (
        <div className='container'>
            <header>
                <h1>Flights Tracker</h1>
            </header>
            <Outlet/>
            <footer>
                <span>Michał Skreczko &copy; 2023</span>
            </footer>
        </div>
    )
}