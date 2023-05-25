import React, { useEffect, useState } from "react";
import "../style.css";
import { AppBar, Toolbar, IconButton, Typography } from "@mui/material";
import WeatherService from "../service/WeatherService";
import DeleteIcon from "@mui/icons-material/Delete";
import { Box, Card, CardContent, CardActions } from "@mui/material";


function Favorite() {

  const [place, setPlace] = useState([]);

  useEffect(()=> {
    WeatherService.getAllPlace().then((response) => {
      setPlace(response.data)
      console.log(response.data)
    }).catch(error => {
      console.log(error);
    });
  },[])
  return (
    <>
      <AppBar position="static">
        <Toolbar variant="dense">
          <Typography variant="h6" color="inherit" component="div">
            My Favorites
          </Typography>
        </Toolbar>
      </AppBar>
      <div className="favorite_container">
        {place.map((place) => (
          <Box key={place.id} width="250px" >
            <Card className="box">
              <CardContent>
                <Typography gutterBottom variant="h5" component="div">
                  {place.name}
                </Typography>
                <Typography variant="body" color="text.secondary">
                  {place.temp}°C
                </Typography>
              </CardContent>
              <CardActions>
                <IconButton>
                  <DeleteIcon />
                </IconButton>
              </CardActions>
            </Card>
          </Box>
        ))}
      </div>
    </>
  );
}

export default Favorite;
