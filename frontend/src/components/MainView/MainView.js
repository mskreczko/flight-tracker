import React from 'react';
import { Outlet } from 'react-router-dom';
import './MainView.css';

export default function MainView() {
    return (
        <div className='container'>
            <header>
                <ul>
                    <li><a href='/'><h1>Flight Tracker</h1></a></li>
                    <nav>
                        <li><a href='/about'>ABOUT</a></li>
                    </nav>
                </ul>
            </header>
            <Outlet/>
            <footer>
                <span>Michał Skreczko &copy; 2023</span>
            </footer>
        </div>
    )
}