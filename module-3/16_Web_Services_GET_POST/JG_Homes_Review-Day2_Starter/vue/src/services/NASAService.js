import axios from 'axios';
const apiKey = 'DEMO_KEY'
export default {
    retrieveNASAData() {
        return axios.get('https://api.nasa.gov/planetary/apod?api_key=' + apiKey)
    }

}