import DeleteIcon from "@mui/icons-material/Delete";
import {
  Box,
  IconButton,
  Card,
  CardContent,
  Typography,
  CardActions,
} from "@mui/material";

export const CardComponent = (props) => {
  return (
    <Box width="250px" margin="10px" justifyContent="space-evenly">
      <Card key={props.id}>
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            {props.place}
          </Typography>
          <Typography variant="body" color="text.secondary">
            {props.temp}°C
          </Typography>
        </CardContent>
        <CardActions>
          <IconButton>
            <DeleteIcon/>
          </IconButton>
        </CardActions>
      </Card>
    </Box>
  );
};
