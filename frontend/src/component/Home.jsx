import React from "react";
import "../style.css";

export default function Home() {
  return (
    <div className="home">
      <div className="left-container">
        <img src="images/reporter-icon.png" alt="" />
      </div>

      <div className="right-container">
        <div>
          <button className="weather-btn">Weather</button>
          <button className="favorite-btn">Favorite</button>
        </div>
      </div>
    </div>
  );
}
