module.exports =
/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// identity function for calling harmony imports with the correct context
/******/ 	__webpack_require__.i = function(value) { return value; };
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 271);
/******/ })
/************************************************************************/
/******/ ({

/***/ 0:
/***/ (function(module, exports) {

/* globals __VUE_SSR_CONTEXT__ */

// this module is a runtime utility for cleaner component module output and will
// be included in the final webpack user bundle

module.exports = function normalizeComponent (
  rawScriptExports,
  compiledTemplate,
  injectStyles,
  scopeId,
  moduleIdentifier /* server only */
) {
  var esModule
  var scriptExports = rawScriptExports = rawScriptExports || {}

  // ES6 modules interop
  var type = typeof rawScriptExports.default
  if (type === 'object' || type === 'function') {
    esModule = rawScriptExports
    scriptExports = rawScriptExports.default
  }

  // Vue.extend constructor export interop
  var options = typeof scriptExports === 'function'
    ? scriptExports.options
    : scriptExports

  // render functions
  if (compiledTemplate) {
    options.render = compiledTemplate.render
    options.staticRenderFns = compiledTemplate.staticRenderFns
  }

  // scopedId
  if (scopeId) {
    options._scopeId = scopeId
  }

  var hook
  if (moduleIdentifier) { // server build
    hook = function (context) {
      // 2.3 injection
      context =
        context || // cached call
        (this.$vnode && this.$vnode.ssrContext) || // stateful
        (this.parent && this.parent.$vnode && this.parent.$vnode.ssrContext) // functional
      // 2.2 with runInNewContext: true
      if (!context && typeof __VUE_SSR_CONTEXT__ !== 'undefined') {
        context = __VUE_SSR_CONTEXT__
      }
      // inject component styles
      if (injectStyles) {
        injectStyles.call(this, context)
      }
      // register component module identifier for async chunk inferrence
      if (context && context._registeredComponents) {
        context._registeredComponents.add(moduleIdentifier)
      }
    }
    // used by ssr in case component is cached and beforeCreate
    // never gets called
    options._ssrRegister = hook
  } else if (injectStyles) {
    hook = injectStyles
  }

  if (hook) {
    var functional = options.functional
    var existing = functional
      ? options.render
      : options.beforeCreate
    if (!functional) {
      // inject component registration as beforeCreate hook
      options.beforeCreate = existing
        ? [].concat(existing, hook)
        : [hook]
    } else {
      // register for functioal component in vue file
      options.render = function renderWithStyleInjection (h, context) {
        hook.call(context)
        return existing(h, context)
      }
    }
  }

  return {
    esModule: esModule,
    exports: scriptExports,
    options: options
  }
}


/***/ }),

/***/ 104:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__utils_requestAnimationFrame__ = __webpack_require__(65);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__utils_requestAnimationFrame___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__utils_requestAnimationFrame__);
//
//
//
//
//
//
//
//
//
//

/**
 * mt-tab
 * @desc 依赖 tab-item
 * @param {Boolean} fixBottom - 固定底部
 * @param {*} value - 返回 item component 传入的 id
 *
 * @example
 * <mt-tab v-model="selected"> // v-model只是一个双向绑定的语法糖
      <mt-tab-item v-for="(item, index) in tabList" :key="index">
        {{item.itemName}}
      </mt-tab-item>
    </mt-tab>
 */


/* harmony default export */ __webpack_exports__["default"] = ({
  name: 'mt-tab',
  props: {
    lineWidth: {
      type: Number,
      default: 1
    },
    activeColor: {
      type: String,
      default: '#A17E41'
    },
    fixBottom: {
      type: Boolean,
      default: false
    },
    value: {},

    // 近似等于超出边界时最大可拖动距离(px);
    additionalX: {
      type: Number,
      default: 50
    },
    // 惯性回弹指数(值越大，幅度越大，惯性回弹距离越长);
    reBoundExponent: {
      type: Number,
      default: 10
    },
    // 灵敏度(惯性滑动时的灵敏度,值越小，阻力越大),可近似认为速度减为零所需的时间(ms);
    sensitivity: {
      type: Number,
      default: 1000
    },
    // 回弹过程duration;
    reBoundingDuration: {
      type: Number,
      default: 360
    }
  },
  computed: {
    style: function style () {
      return {
        transitionTimingFunction: this.transitionTimingFunction,
        transitionDuration: ((this.transitionDuration) + "ms"),
        transform: ("translate3d(" + (this.translateX) + "px, 0px, 0px)")
      }
    },
    transitionDuration: function transitionDuration () {
      if (this.touching || (!this.reBounding && !this.touching)) {
        return '0'
      }
      if (this.reBounding && !this.touching) {
        return this.reBoundingDuration
      }
    },
    transitionTimingFunction: function transitionTimingFunction () {
      return this.reBounding ? 'cubic-bezier(0.25, 0.46, 0.45, 0.94)' : 'cubic-bezier(0.1, 0.57, 0.1, 1)'
    },
    // 可视区宽度;
    viewAreaWidth: function viewAreaWidth () {
      return this.$refs.viewArea.offsetWidth
    },
    // 可视区与可滑动元素宽度差值;
    listWidth: function listWidth () {
      return this.$refs.list.offsetWidth - this.viewAreaWidth
    },
    // 是否向左惯性滚动;
    isMoveLeft: function isMoveLeft () {
      return this.currentX <= this.startX
    },
    isMoveRight: function isMoveRight () {
      return this.currentX >= this.startX
    }
  },
  data: function data () {
    return {
      speed: 0, // 滑动速度(正常滑动时一般不会超过10);
      touching: false, // 是否处于touch状态;
      reBounding: false, // 是否处于回弹过程;
      translateX: 0,
      startX: 0,
      lastX: 0,
      currentX: 0,
      frameTime: 16.7, // 每个动画帧的ms数
      frameStartTime: 0,
      frameEndTime: 0,
      inertiaFrame: 0,
      zeroSpeed: 0.001, // 当speed绝对值小于该值时认为速度为0 (可用于控制惯性滚动结束期的顺滑度)
      acceleration: 0, // 惯性滑动加速度;
    }
  },
  mounted: function mounted () {
    this.bindEvent()
  },
  methods: {
    // start
    handleTouchStart: function handleTouchStart (event) {
      cancelAnimationFrame(this.inertiaFrame)
      this.lastX = event.touches[0].clientX
    },
    // move
    handleTouchMove: function handleTouchMove (event) {
      if (this.listWidth <= 0) { return }
      event.preventDefault()
      event.stopPropagation()
      this.touching = true
      this.startMoveTime = this.endMoveTime
      this.startX = this.lastX
      this.currentX = event.touches[0].clientX
      this.moveFellowTouch()
      this.endMoveTime = event.timeStamp // 每次触发touchmove事件的时间戳;
    },
    // end
    handleTouchEnd: function handleTouchEnd (event) {
      this.touching = false
      if (this.checkReboundX()) {
        cancelAnimationFrame(this.inertiaFrame)
      } else {
        var silenceTime = event.timeStamp - this.endMoveTime
        var timeStamp = this.endMoveTime - this.startMoveTime
        if (silenceTime > 100) { return }  // 停顿时间超过100ms不产生惯性滑动;
        this.speed = (this.lastX - this.startX) / (timeStamp)
        this.acceleration = this.speed / this.sensitivity
        this.frameStartTime = new Date().getTime()
        this.inertiaFrame = requestAnimationFrame(this.moveByInertia)
      }
    },
    // 如果需要回弹则进行回弹操作并返回true;
    checkReboundX: function checkReboundX () {
      this.reBounding = false
      if (this.translateX > 0) {
        this.reBounding = true
        this.translateX = 0
      } else if (this.translateX < -this.listWidth) {
        this.reBounding = true
        this.translateX = -this.listWidth
      }
      return this.translateX === 0 || this.translateX === -this.listWidth
    },
    bindEvent: function bindEvent () {
      this.$el.addEventListener('touchstart', this.handleTouchStart, false)
      this.$el.addEventListener('touchmove', this.handleTouchMove, false)
      this.$el.addEventListener('touchend', this.handleTouchEnd, false)
    },
    // touch拖动
    moveFellowTouch: function moveFellowTouch () {
      if (this.isMoveLeft) { // 向左拖动
        if (this.translateX <= 0 && this.translateX + this.listWidth > 0 || this.translateX > 0) {
          this.translateX += this.currentX - this.lastX
        } else if (this.translateX + this.listWidth <= 0) {
          this.translateX += this.additionalX * (this.currentX - this.lastX) / (this.viewAreaWidth + Math.abs(this.translateX + this.listWidth))
        }
      } else { // 向右拖动
        if (this.translateX >= 0) {
          this.translateX += this.additionalX * (this.currentX - this.lastX) / (this.viewAreaWidth + this.translateX)
        } else if (this.translateX <= 0 && this.translateX + this.listWidth >= 0 || this.translateX + this.listWidth <= 0) {
          this.translateX += this.currentX - this.lastX
        }
      }
      this.lastX = this.currentX
    },
    // 惯性滑动
    moveByInertia: function moveByInertia () {
      this.frameEndTime = new Date().getTime()
      this.frameTime = this.frameEndTime - this.frameStartTime
      if (this.isMoveLeft) { // 向左惯性滑动;
        if (this.translateX <= -this.listWidth) { // 超出边界的过程;
          // 加速度指数变化;
          this.acceleration *= (this.reBoundExponent +
                               Math.abs(this.translateX + this.listWidth)) /
                               this.reBoundExponent
          this.speed = Math.min(this.speed - this.acceleration, 0) // 为避免减速过程过短，此处加速度没有乘上frameTime;
        } else {
          this.speed = Math.min(this.speed - this.acceleration * this.frameTime, 0)
        }
      } else if (this.isMoveRight) { // 向右惯性滑动;
        if (this.translateX >= 0) {
          this.acceleration *= (this.reBoundExponent + this.translateX) / this.reBoundExponent
          this.speed = Math.max(this.speed - this.acceleration, 0)
        } else {
          this.speed = Math.max(this.speed - this.acceleration * this.frameTime, 0)
        }
      }
      this.translateX += this.speed * this.frameTime / 2
      if (Math.abs(this.speed) <= this.zeroSpeed) {
        this.checkReboundX()
        return
      }
      this.frameStartTime = this.frameEndTime
      this.inertiaFrame = requestAnimationFrame(this.moveByInertia)
    }
  }
});


/***/ }),

/***/ 111:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 181:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(111)
}
var Component = __webpack_require__(0)(
  /* script */
  __webpack_require__(104),
  /* template */
  __webpack_require__(188),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 188:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    ref: "viewArea",
    staticClass: "mt-tab",
    class: {
      'mt-tab-fix-bottom': _vm.fixBottom
    }
  }, [_c('div', {
    ref: "list",
    staticClass: "mt-tab-list",
    style: (_vm.style)
  }, [_vm._t("default")], 2)])
},staticRenderFns: []}

/***/ }),

/***/ 271:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(52);


/***/ }),

/***/ 52:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__src_tab_vue__ = __webpack_require__(181);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__src_tab_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__src_tab_vue__);
/* harmony reexport (default from non-hamory) */ __webpack_require__.d(__webpack_exports__, "default", function() { return __WEBPACK_IMPORTED_MODULE_0__src_tab_vue___default.a; });





/***/ }),

/***/ 65:
/***/ (function(module, exports) {

;(function () {
  var lastTime = 0
  var vendors = ['webkit', 'moz']
  for (var x = 0; x < vendors.length && !window.requestAnimationFrame; ++x) {
    window.requestAnimationFrame = window[vendors[x] + 'RequestAnimationFrame']
    window.cancelAnimationFrame = window[vendors[x] + 'CancelAnimationFrame'] || // name has changed in Webkit
                                  window[vendors[x] + 'CancelRequestAnimationFrame']
  }

  if (!window.requestAnimationFrame) {
    window.requestAnimationFrame = function (callback, element) {
      var currTime = new Date().getTime()
      console.log(currTime, lastTime)
      var timeToCall = Math.max(0, 16.7 - (currTime - lastTime))
      var interval = currTime - lastTime
      var id = window.setTimeout(function () {
        callback(interval)
      }, timeToCall)
      lastTime = currTime + timeToCall
      return id
    }
  }
  if (!window.cancelAnimationFrame) {
    window.cancelAnimationFrame = function (id) {
      clearTimeout(id)
    }
  }
})()


/***/ })

/******/ });