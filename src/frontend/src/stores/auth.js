import {defineStore} from 'pinia'
import axios from "axios";
import router from "../router/routes.js";

export const useAuth = defineStore({
    id: 'auth,',
    state: () => {
        return {
            //localStorage only in Dev mode!! In production i will use HTTP-Only Cookies to store jwt to prevent from CSRF and XSS
            user: localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')) : null,
            token: localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')) : null,
            userId: localStorage.getItem('userId') ? JSON.parse(localStorage.getItem('userId')) : null,

            returnUrl: '/dashboard'
        }
    },
    actions: {
        async login(username, password) {
            const response = await axios.post('/auth/login',{username, password});

            if(response.status === 200) {
                const data = await response.data;
                localStorage.setItem('token', JSON.stringify(data.jwt));
                localStorage.setItem('user', JSON.stringify(data.user.username));
                localStorage.setItem('userId', JSON.stringify(data.user.userId));


                this.user = data.user.username;
                this.token = data.jwt;
                this.userId = data.user.userId;

                router.push(this.returnUrl || "/");
            }
            else {
                throw new Error("Invalid Username or Password");
            }

        },
        logout() {
            this.user = '';
            this.token = '';
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            router.push('/login');
        }
    }
})