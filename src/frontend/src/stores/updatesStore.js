// store.js
import { reactive } from 'vue'
import axios from "axios";
import {useAuth} from "./auth.js";

const userData = useAuth();
const token = userData.token;

const id = 2
export const fetchUpdates = reactive({
    updates: [],

    async fetch(incidentId) {
        const config = {
            headers: {
                Authorization:`Bearer ${token}`
            },
        };
        try {
            const response = await axios.get(`/api/updates/${incidentId}`, config);
            if (response.status === 200) {
                this.updates = response.data;
                console.log(response.data);
            }
        }catch (e) {
            console.log("Error fetching Updates: ", e);
        }
    }
})