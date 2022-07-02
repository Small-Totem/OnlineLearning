<template>
    <div class="MainPage">
        <v-header/>
        <router-view v-slot="{ Component }">
            <transition name="move" mode="out-in">
                <keep-alive>
                    <component :is="Component" />
                </keep-alive>
            </transition>
        </router-view>
    </div>
</template>

<script>
    import { computed } from "vue";
    import { useStore } from "vuex";
    import { useRoute } from "vue-router";
    import vHeader from "../components/MainHeader.vue";

    export default {
        name: "MainPage.vue",
        components: {
            vHeader
        },

        setup() {
            const store = useStore();
            const collapse = computed(() => store.state.collapse);

            return {
                collapse,
            };
        },

    }
</script>
