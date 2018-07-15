<template>
  <a class="mt-tab-item"
       :style="$parent.value === id ? activeStyle : {}"
       @click="onItemClicked">
    <div class="mt-tab-item-icon"><slot name="icon"></slot></div>
    <div class="mt-tab-item-label"><slot></slot></div>
  </a>
</template>

<script>
/**
 * mt-tab-item
 * @desc 搭配 tab 使用
 * @param {Number} id - 选中的item的索引值
 * @param {slot} [icon] - icon 图标
 * @param {slot} - 文字
 *
 * @example
 * <mt-tab-item>
 *   <img slot="icon" src="http://placehold.it/100x100">
 *   前端
 * </mt-tab-item>
 */
export default {
  name: 'mt-tab-item',
  props:{
    id:[String,Number]
  },
  computed: {
    activeStyle () {
      return {
        color: this.$parent.activeColor,
        borderColor: this.$parent.activeColor,
        borderWidth: this.$parent.lineWidth+'px',
        borderBottomStyle: 'solid'
      }
    }
  },
  // data () {
  //   return {
  //     id: (this.$parent.$children.length || 1) - 1
  //   }
  // },
  methods: {
    onItemClicked () {
      this.$parent.$emit('input', this.id);
      this.$parent.$emit('click', this.id);
    }
  }
}
</script>

