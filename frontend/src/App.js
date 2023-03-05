import logo from './logo.svg';
import Map from './components/Map/Map';
import MainView from './components/MainView/MainView';
import About from './components/MainView/About';
import { Route, Routes } from 'react-router-dom';
import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<MainView/>}>
          <Route index element={<Map/>}/>
          <Route path='about' element={<About/>}/>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
