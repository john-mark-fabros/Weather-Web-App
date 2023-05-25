import React, { useEffect } from 'react'
import '../style.css'
import { useState } from 'react';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import { Button, IconButton } from '@mui/material';
import axios from 'axios';

function Weather() {

    const api = {
        key: "to be added",
        base_url: "to be added"
    }

    const [data, setData] = useState({
        name: '',
        celcius:  0,
        img: ''
    });

    const [name, setName] = useState('');

    // useEffect(() => {
    //     axios.get(api.base_url)
    //     .then(res => {
    //         setData(...data, data.name = res.data.name, data.celcius = res.data.temp)
    //     }).catch(err => console.log(err));
    // }, []);

    const searchPlace = () => {
        if(name !== "") {
            axios.get(api.base_url)
            .then(res => {
                let imgPath = "";
                if(res.data.Weathe.main[0] === "Clear") {
                    imgPath = "images/sunny.png";
                } else if(res.data.Weathe.main[0] === "Clouds") {
                    imgPath = "images/cloudy.png";
                } else if(res.data.Weathe.main[0] === "Rain") {
                    imgPath = "images/cloudy.png";
                } else if(res.data.Weathe.main[0] === "Drizzle") {
                    imgPath = "images/windy.png";
                } else {
                    imgPath = "images/stormy.png";
                }
                setData(...data, data.name = res.data.name, data.celcius = res.data.temp, data.img = imgPath)
            }).catch(err => console.log(err));
        }
    }

  return (
    <div className='container'>
        <div className='weather'>
            <div className='search'>
                <input type='text' placeholder='Enter place' onChange={e => setName(e.target.value)}/>
                <button><img src='images/search-icon-smaller.png' onClick={searchPlace}/></button>
            </div>
            <div className="weatherinfo">
            <img src={data.img}/>
            <h1>{data.celcius}°C</h1>
            <h2>{data.name}</h2> 
            <IconButton>
                <FavoriteBorderIcon/>
            </IconButton>
            </div>
        </div>
    </div>
  )
}

export default Weather;