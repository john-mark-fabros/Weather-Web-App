import "./App.css";
import Home from "./component/Home";
import { Route, Routes } from "react-router-dom";
import Weather from "./component/Weather";

function App() {
  return (
    <>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/weather" element={<Weather />} />
      </Routes>
    </>
  );
}

export default App;
