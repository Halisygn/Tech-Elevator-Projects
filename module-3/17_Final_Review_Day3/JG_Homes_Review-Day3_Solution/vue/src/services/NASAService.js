import axios from 'axios';

const apiKey = 'Gt53JZCtJPHVfecMOgQg4n0fRAW64TBPBrydnl4W';

export default {

  retrieveNASAData() {
      return axios.get('https://api.nasa.gov/planetary/apod?api_key=' + apiKey);
  }

}
