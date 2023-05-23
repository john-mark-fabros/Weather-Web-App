import React, { useEffect } from 'react'
import '../style.css'
import { useState } from 'react';

function Weather() {

    const api = {
        key: "to be added",
        base_url: "to be added"
    }
    const [data, setData] = useState({
        name: '',
        celcius:  0
    })

    useEffect(() => {

    }, []);

  return (
    <div className='container'>
        <div className='weather'>
            <div className='search'>
                <input type='text' placeholder='Enter place'/>
                <button><img src='images/search-icon-smaller.png'/></button>
            </div>
            <div className="weatherinfo">
            <img src='images/cloudy.png'/>
            <h1>TBA-°C</h1>
            <h2>TBA-place</h2> 
            </div>
        </div>
    </div>
  )
}

export default Weather;