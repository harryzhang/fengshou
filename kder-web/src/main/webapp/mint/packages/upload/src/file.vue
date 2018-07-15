<template>
  <div class="cube-upload-file" @click="clickHandler">
    <slot>
      <div class="cube-upload-file-def" :style="fileStyle">
        <i class="cubeic-wrong" @click.stop="removeFile"></i>
        <div class="cube-upload-file-state" :class="fileStatusCls">
          <i class="cube-upload-file-status" :class="statusCls"></i>
          <span class="cube-upload-file-progress">{{fileProgress}}</span>
        </div>
      </div>
    </slot>
  </div>
</template>
<script>
  import { STATUS_SUCCESS, STATUS_ERROR } from './util'

  const COMPONENT_NAME = 'cube-upload-file'
  const STATUS_CLASS_MAP = {
    success: 'cubeic-right',
    error: 'cubeic-warn'
  }
  const EVENT_CLICK = 'click'

  export default {
    name: COMPONENT_NAME,
    props: {
      file: {
        type: Object,
        required: true
      }
    },
    computed: {
      fileStatusCls() {
        const file = this.file
        const status = file.status
        if (file.progress >= 0.01 || status === STATUS_SUCCESS || status === STATUS_ERROR) {
          return 'cube-upload-file_stat'
        }
      },
      fileStyle() {
        const url = this.file.url || this.file.base64
        if (!url) {
          return
        }
        return {
          'background-image': `url("${url}")`
        }
      },
      statusCls() {
        const status = this.file.status
        return STATUS_CLASS_MAP[status]
      },
      fileProgress() {
        if (this.statusCls) {
          return '100%'
        }
        const p = Math.min(Math.floor(this.file.progress * 100), 99)
        return `${p}%`
      }
    },
    methods: {
      clickHandler() {
        this.$emit(EVENT_CLICK, this.file)
      },
      removeFile() {
        this.$parent.removeFile(this.file)
      }
    }
  }
</script>
<style>
.cube-upload-file { position: relative }
.cube-upload-file-def { position: relative; width: 80px; height: 80px; -webkit-box-sizing: border-box; box-sizing: border-box; background: #fff no-repeat 50%; background-size: cover; border-radius: 2px }
.cube-upload-file-def>.cubeic-wrong { position: absolute; z-index: 2; top: -2px; right: -2px; color: rgba(0, 0, 0, .8); font-size: 16px; background-color: #fff; border-radius: 50% }
.cube-upload-file-def>.cubeic-wrong:before { display: inline-block; -webkit-transform: scale(1.625); transform: scale(1.625); -webkit-transform-origin: center; transform-origin: center }
.cube-upload-file-state { position: relative; width: 100%; height: 100%; display: -webkit-box; display: flex; -webkit-box-align: center; align-items: center; -webkit-box-pack: center; justify-content: center; overflow: hidden; opacity: 0; background-color: rgba(37, 38, 45, .4); border-radius: 2px; -webkit-transition: opacity .1s; transition: opacity .1s }

.cube-upload-file_stat { opacity: 1 }
.cube-upload-file-status { position: relative; z-index: 1; font-size: 30px; display: none }
.cube-upload-file-status.cubeic-right { display: block; color: #fc9153 }
.cube-upload-file-status.cubeic-warn { display: block; color: #f43530 }
.cube-upload-file-status.cubeic-right+.cube-upload-file-progress,
.cube-upload-file-status.cubeic-warn+.cube-upload-file-progress { display: none }
.cube-upload-file-progress { color: #fff; font-size: 20px }  
</style>
