import logo from './logo.svg';
import Map from './components/Map/Map';
import MainView from './components/MainView/MainView';
import { Route, Routes } from 'react-router-dom';
import './App.css';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<MainView/>}>
          <Route index element={<Map/>}/>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
