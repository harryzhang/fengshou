<template>
    <mt-button 
    @click.native="submit" 
    type="primary" 
    :disabled="disabled" 
    plain>
        {{change}}
    </mt-button>   
</template>
<script>
import MtButton from "mint-ui/packages/button/index.js";
if (process.env.NODE_ENV === "component") {
  require("mint-ui/packages/button/style.css");
}
export default {
  name: "mt-countdown",

  props: {
    send: {
      type: Function,
      default: () => {}
    }
  },

  components: { "mt-button": MtButton },

  data() {
    return {
      interval: null,
      disabled: false,
      time: "免费获取"
    };
  },

  computed: {
    change() {
      let value = this.time;
      if (!isNaN(value)) {
        if (this.flag == true) {
          return `重新发送${value}S`;
        }
        return value + "s";
      } else {
        return value;
      }
    }
  },

  methods: {
    submit() {
      this.disabled = true;
      this.send(
        _ => {
          this.timedown();
        },
        _ => {
          this.disabled = false;
        }
      );
    },

    timedown() {
      this.time = 60;
      this.interval = setInterval(() => {
        this.time--;
        if (this.time <= 0) {
          this.time = "获取验证码";
          this.disabled = false;
          clearInterval(this.interval);
        }
      }, 1000);
    }
  }
};
</script>
