import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/Home_View.vue'
import {useAuth} from "../stores/auth.js";

const routes = [
    {
        path: '/',
        name: 'home',
        component: HomeView
    },
    {
        path: '/login',
        name: 'login',
        component: () => import('../views/Login_View.vue')
    },   {
        path: '/dashboard',
        name: 'dashboard',
        component: () => import('../views/Dashboard_View.vue')
    },  {
        path: '/dashboard/admin/user-overview',
        name: 'admin-user-overview',
        component: () => import('../views/User_Overview_Admin_view.vue')
    },   {
        path: '/incidents',
        name: 'incident-list',
        component: () => import('../views/Incident_Overview_View.vue')
    },   {
        path: '/incidents/details/:id',
        name: 'incident-details',
        component: () => import('../views/Incident_Detail_View.vue'),
        props: true
    },   {
        path: '/incidents/create',
        name: 'create-incident',
        component: () => import('../views/Incident_Report_View.vue')
    }, {
        path: '/incidents/notifications',
        name: 'incidents-notifications',
        component: () => import('../views/Incident_Report_Notification_View.vue')
    },   {
        path: '/user',
        name: 'user',
        component: () => import('../views/User_Details_View.vue')
    },   {
        path: '/user/create',
        name: 'create-user',
        component: () => import('../views/User_NewUser_View.vue')
    },   {
        path: '/test',
        name: 'test',
        component: () => import('../views/TestView.vue')
    },   {
        path: '/test/:id',
        name: 'test-comp',
        component: () => import('../views/TestComponentView.vue')
    }
]

const router = createRouter({
    history: createWebHistory(import.meta.env.VITE_BASE_URL),
    routes
});

router.beforeEach(async (to) => {
    const publicPages = ['/login', '/']
    const authRequired = !publicPages.includes(to.path);
    const auth = useAuth();



    if (authRequired && auth.user == '') {
        return 'login';
    }
})

export default router
