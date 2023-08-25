import {defineStore} from 'pinia'
import axios from "axios";

export const useAuth = defineStore({
    id: 'auth,',
    state: () => {
        return {
            user: null,
            token: null,
            returnUrl: '/'
        }
    },
    actions: {
        async login(username, password) {
            const response = await axios.post('/login',{username, password});

            console.log(response.status);
            console.log(response.data);
        }
    }
})