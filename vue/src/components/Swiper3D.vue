<template>
  <div class="banner-box" ref="root">
    <!-- <div>{{source}}</div> -->
    <div class="wrapper">
      <div
        style="cursor:pointer"
        v-for="(item, index) in data.source"
        :key="item.id"
        :class="item.className"
        :style="item.sty"
        @click="slideClick(index)">
        <img :src="item.pic" alt=""/>
        <div class="mark"></div>
        <p class="detail">
          <span>{{ item.description }}</span>
        </p>
      </div>
    </div>
    <a href="javascript:;" class="left" @click="changeSlide('left')"></a>
    <a href="javascript:;" class="right" @click="changeSlide('right')"></a>
  </div>
</template>

<script>
import { reactive, ref, toRefs } from "@vue/reactivity";
import { watch } from "vue";
import { onMounted } from "@vue/runtime-core";
import debounce from "../utils/debounce.js"
import { useRouter } from "vue-router";

export default {
  name: "Swiper3D",
  props: {
    source: {
      type: Array,
      required: true,
      default() {
        return [];
      },
    },
    initial: {
      type: Number,
      default: 0,
    },
    /*
    interval: {
      type: Number,
      default: 2000,
    },*/
  },
  setup(props) {
    // 获取父组件的数据
    const router = useRouter();
    let source = props.source;
    // 数据不足5个 补足5个
    let diff = 5 - source.length;
    if (diff > 0 && diff !== 4) {
      for (let i = 0; i < diff; i++) {
        source.push({
          ...source[i],
          id: parseInt(source[source.length - 1].id + 1),
        });
      }
    }

    // 处理每一项的样式
    const computed = (initial, source) => {
      // console.log('处理样式')
      if (initial < 0) initial = 0;
      let len = source.length,
        temp1 = initial - 2 < 0 ? initial - 2 + len : initial - 2,
        temp2 = initial - 1 < 0 ? initial - 1 + len : initial - 1,
        temp3 = initial,
        temp4 = initial + 1 >= len ? initial + 1 - len : initial + 1,
        temp5 = initial + 2 >= len ? initial + 2 - len : initial + 2;
      return source.map((item, index) => {
        let transform = `translate(-50%, -50%) scale(0.7)`,
          zIndex = 0,
          className = "slide";
        switch (index) {
          case temp3:
            transform = `translate(-50%, -50%) scale(1)`;
            className = ["slide", "activate"];
            zIndex = 3;
            break;
          case temp1:
            transform = `translate(-200%, -50%) scale(0.7)`;
            zIndex = 1;
            break;
          case temp5:
            transform = `translate(100%, -50%) scale(0.7)`;
            zIndex = 1;
            break;
          case temp2:
            transform = `translate(-130%, -50%) scale(0.85)`;
            zIndex = 2;
            break;
          case temp4:
            transform = `translate(30%, -50%) scale(0.85)`;
            zIndex = 2;
            break;
        }
        item.sty = {
          transform,
          zIndex,
        };
        item.className = className;
        return item;
      });
    };
    source = computed(props.initial, source);
    let data = reactive({
      initial: props.initial,
      source,
    });
    // 监听data.initial变化，每次变化 重新渲染样式
    watch(
      () => data.initial,
      (newV, oldV) => {
        // console.log(newV);
        data.source = computed(newV, data.source);
        // console.log(data.source)
      }
    );
    // 处理自动轮播
    let timer = null;
    const autoPlay = () => {
      timer = setInterval(() => {
        // console.log(data.initial);
        data.initial++;
        // console.log(data.source.length)
        if (data.initial >= data.source.length) {
          data.initial = 0;
        }
      }, 3000);
    };
    // 鼠标移入移除效果
    let root = ref(null);
    onMounted(() => {
      clearInterval(timer);
      autoPlay();
      const box = root.value;
      box.onmouseenter = () => clearInterval(timer);
      box.onmouseleave = () => autoPlay();
    });
    // 点击哪张图片 哪张图片就到第一个
    function slideClick(index) {
      if(index===data.initial){
        //console.log("center_on_click")
        router.push(data.source[index].link)
      }
      data.initial = index
    }

    // 点击左右按钮切换图片
    function h(dir) {
      if (dir === "left") {
        clearInterval(timer)
        data.initial++;
        data.initial >= data.source.length ? (data.initial = 0) : false;
        return;
      }
      data.initial--;
      data.initial < 0 ? (data.initial = data.source.length-1) : false;
    }
    // 左右切换图片设置防抖效果
    function changeSlide(dir){
      debounce(h,200,dir)
    }
    return {
      data,
      root,
      slideClick,
      changeSlide,
    };
  },
};
</script>

<style scoped>
.banner-box {
  width: 100%;
  height: 240px;
  position: relative;
  left: 50%;
  top: 120px; /*height的一半*/
  transform: translate(-50%, -50%);
  background-color: rgba(0, 0, 0, 0.5);
}
.wrapper {
  width: 100%;
  height: 100%;
  position: relative;
  /* transition: 0.5s; */
}
.slide {
  width: 25%;
  height: 100%;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  transition: 0.5s;
  box-shadow: 0 0 4px black;
  border-radius: 20px;
  /* background-color: azure; */
}
img {
  height: 100%;
  width: 100%;
  vertical-align: bottom;
  border-radius: 20px;
}
.mark {
  position: absolute;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  border-radius: 20px;
}
.mark:hover {
  background-color: rgba(0, 0, 0, 0);
}

.activate .mark {
  background-color: rgba(0, 0, 0, 0);
}
.detail {
  display: flex;
  flex-direction: column;
  /* padding: 10px 0px; */
  position: absolute;
  bottom: 0;
  color: #fff;
  background-color: rgba(0, 0, 0, 0.5);
  max-height: 0px;
  overflow: hidden;
  transition: 0.2s;
  font-size: 14px;
  width: 100%;
  border-bottom-left-radius: 20px;
  border-bottom-right-radius: 20px;
}
.detail span {
  margin: 2px 10px;
}
.slide:hover .detail {
  max-height: 100%;
  padding: 5px 0px;
}
a.left {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  left: 0px;
  z-index: 9;
  /* background-color: black; */
  width: 50px;
  height: 50px;
  background-image: url(../assets/img/left.png);
  background-size: contain;
}
a.right {
  position: absolute;
  top: 50%;
  right: 0px;
  transform: translateY(-50%);
  z-index: 9;
  width: 50px;
  height: 50px;
  background-image: url(../assets/img/right.png);
  background-size: contain;
}
</style>
