// store.js
import { reactive } from 'vue'

export const store = reactive({
    updates: ["1"],
    add() {
        this.updates.push("2");
    }
})