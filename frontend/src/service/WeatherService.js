import axios from 'axios'

// this will be use for the favorite section in saving user favorite
const BASE_URL = "http://localhost:8080/api/v1/weather";
class WeatherService {

    // get all place in the database
    getAllPlace() {
        return axios.get(BASE_URL);
    }
}

export default new WeatherService();
