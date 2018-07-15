<template>
  <div class="cube-upload-btn">
    <slot>
      <div class="cube-upload-btn-def"><i></i></div>
    </slot>
    <input class="cube-upload-input" type="file" @change="changeHandler" :multiple="multiple" :accept="accept">
  </div>
</template>
<script>
  const COMPONENT_NAME = 'cube-upload-btn'

  export default {
    name: COMPONENT_NAME,
    props: {
      multiple: {
        type: Boolean,
        default: true
      },
      accept: {
        type: String,
        default: 'image/*'
      }
    },
    methods: {
      changeHandler(e) {
        const fileEle = e.currentTarget
        const files = fileEle.files
        if (files) {
          this.$parent.addFiles(files)
          fileEle.value = null
        }
      }
    }
  }
</script>
<style>
.cube-upload-btn { position: relative; overflow: hidden }
.cube-upload-btn:active .cube-upload-btn-def { background-color: rgba(0, 0, 0, .04) }
.cube-upload-input { position: absolute; top: 0; left: 0; right: 0; bottom: 0; width: 100%; font-size: 0; opacity: 0 }
.cube-upload-btn-def { width: 80px; height: 80px; background-color: #fff; -webkit-box-shadow: 0 0 6px 2px rgba(0, 0, 0, .08); box-shadow: 0 0 6px 2px rgba(0, 0, 0, .08); border-radius: 2px; position: relative }
.cube-upload-btn-def,
.cube-upload-btn-def:after { -webkit-box-sizing: border-box; box-sizing: border-box }
.cube-upload-btn-def:after { content: ""; pointer-events: none; display: block; position: absolute; left: 0; top: 0; -webkit-transform-origin: 0 0; transform-origin: 0 0; border: 2px dashed #ddd; border-radius: 2px; width: 100%; height: 100% }
@media (-webkit-min-device-pixel-ratio:2), (min-resolution:2dppx) {
  .cube-upload-btn-def:after { width: 200%; height: 200%; border-radius: 4px; -webkit-transform: scale(.5) translateZ(0); transform: scale(.5) translateZ(0) }
}
@media (-webkit-min-device-pixel-ratio:3), (min-resolution:3dppx) {
  .cube-upload-btn-def:after { width: 300%; height: 300%; border-radius: 6px; -webkit-transform: scale(.333) translateZ(0); transform: scale(.333) translateZ(0) }
}
.cube-upload-btn-def>i:after,
.cube-upload-btn-def>i:before { content: ""; position: absolute; top: 50%; left: 50%; width: 20px; height: 2px; -webkit-transform: translate(-50%, -50%); transform: translate(-50%, -50%); background-color: #666 }
.cube-upload-btn-def>i:after { -webkit-transform: translate(-50%, -50%) rotate(90deg); transform: translate(-50%, -50%) rotate(90deg) }  
</style>