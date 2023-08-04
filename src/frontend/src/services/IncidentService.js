import axios from 'axios';

const INCIDENTS_API_BASE_URL = 'http://localhost:8080/incidents';

class IncidentService{

    async getIncidents(){
        return await axios.get(INCIDENTS_API_BASE_URL);
    }
}

export default new IncidentService();