<template>
  <div >
    <div class="MainPage">
        <v-header/>
      <div class="MainContent">
        <router-view v-slot="{ Component }">
            <transition name="move" mode="out-in">
                <keep-alive>
                    <component :is="Component" />
                </keep-alive>
            </transition>
        </router-view>
      </div>
      <v-footer/>
    </div>
  </div>
</template>

<script>
    import { computed } from "vue";
    import { useStore } from "vuex";
    import vHeader from "../components/MainHeader.vue";
    import vFooter from "../components/footer.vue";
    export default {
        name: "MainPage.vue",
        components: {
          vHeader,
          vFooter
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

<style>

.MainPage{
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.MainContent {

  /* main 高度填充flex剩余高 */
  flex: 1;
}
</style>
<style scoped>

</style>
