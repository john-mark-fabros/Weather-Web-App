import "./App.css";
import Home from "./component/Home";
import { Route, Routes } from "react-router-dom";
import Weather from "./component/Weather";
import Favorite from "./component/Favorite";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/weather" element={<Weather />} />
        <Route path="/favorite" element={<Favorite />} />
      </Routes>
    </>
  );
}

export default App;
