import React from "react";
import "../style.css";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <div className="home">
      <div className="left-container">
        <img src="images/reporter-icon.png" alt="" />
      </div>

      <div className="right-container">
        <div>
          <Link to="/weather">
            <button className="weather-btn">Weather</button>
          </Link>
          <Link to="/favorite">
            <button className="favorite-btn">Favorite</button>
          </Link>
        </div>
      </div>
    </div>
  );
}
