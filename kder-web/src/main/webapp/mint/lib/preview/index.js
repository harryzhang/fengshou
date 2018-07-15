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
/******/ 	return __webpack_require__(__webpack_require__.s = 258);
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

/***/ 114:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 165:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(114)
}
var Component = __webpack_require__(0)(
  /* script */
  __webpack_require__(88),
  /* template */
  __webpack_require__(191),
  /* styles */
  injectStyle,
  /* scopeId */
  "data-v-0e088923",
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 191:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('transition', {
    attrs: {
      "name": "fade"
    }
  }, [_c('div', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (_vm.preview.show),
      expression: "preview.show"
    }],
    staticClass: "lg-preview-wrapper",
    on: {
      "click": _vm.leave,
      "touchmove": function($event) {
        $event.preventDefault();
      }
    }
  }, [_c('div', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (_vm.preview.loading),
      expression: "preview.loading"
    }],
    staticClass: "lg-preview-loading"
  }, [_c('div')]), _vm._v(" "), (_vm.preview.current.src) ? _c('img', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (!_vm.preview.loading),
      expression: "!preview.loading"
    }],
    staticClass: "lg-preview-img",
    attrs: {
      "src": _vm.preview.current.src,
      "alt": _vm.preview.current.title
    }
  }) : _vm._e(), _vm._v(" "), (_vm.preview.isTitleEnable && _vm.preview.current.title) ? _c('div', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (!_vm.preview.loading),
      expression: "!preview.loading"
    }],
    staticClass: "lg-preview-title"
  }, [_vm._v("\n            " + _vm._s(_vm.preview.current.title) + "\n        ")]) : _vm._e(), _vm._v(" "), (_vm.preview.isHorizontalNavEnable) ? _c('div', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (!_vm.preview.loading),
      expression: "!preview.loading"
    }],
    staticClass: "lg-preview-nav-left"
  }, [_c('span', {
    staticClass: "lg-preview-nav-arrow",
    on: {
      "click": _vm.preAction
    }
  })]) : _vm._e(), _vm._v(" "), (_vm.preview.isHorizontalNavEnable) ? _c('div', {
    directives: [{
      name: "show",
      rawName: "v-show",
      value: (!_vm.preview.loading),
      expression: "!preview.loading"
    }],
    staticClass: "lg-preview-nav-right"
  }, [_c('span', {
    staticClass: "lg-preview-nav-arrow",
    on: {
      "click": _vm.nextAction
    }
  })]) : _vm._e()])])
},staticRenderFns: []}

/***/ }),

/***/ 258:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(39);


/***/ }),

/***/ 39:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__src_index_js__ = __webpack_require__(63);
/* harmony reexport (binding) */ __webpack_require__.d(__webpack_exports__, "default", function() { return __WEBPACK_IMPORTED_MODULE_0__src_index_js__["a"]; });


/***/ }),

/***/ 63:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__preview_vue__ = __webpack_require__(165);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__preview_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__preview_vue__);


// export default {
    var install = function (Vue, options) {
        // 添加的内容写在这个函数里面
        var LOGIC_EVENT_BUS = new Vue({
            data: function data() {
                return {
                    LOGIC_PREVIEW: {
                        isTitleEnable: true,
                        isHorizontalNavEnable: true,
                        show: false,
                        loading: true,
                        current: {
                            title: '',
                            src: ''
                        },
                        list: []
                    }
                }
            }
        })

        window.LOGIC_EVENT_BUS = LOGIC_EVENT_BUS

        Vue.component('mt-preview', __WEBPACK_IMPORTED_MODULE_0__preview_vue___default.a)

        var updateIndex = function (list) {
            list.forEach(function (item, index) {
                item.index = index + 1
            })
        }

        function getImage(src, previewItem) {
            return new Promise(function (resolve, reject) {
                var img = new window.Image()
                img.src = src
                img.onload = function () {
                    previewItem['naturalHeight'] = img.naturalHeight
                    previewItem['naturalWidth'] = img.naturalWidth
                    setTimeout(function () {
                        LOGIC_EVENT_BUS.LOGIC_PREVIEW.loading = false
                    }, 500)
                    resolve(img)
                }
                img.error = function (e) {
                    reject(e)
                }
            })
        }

        Vue.directive('preview', {
            bind: function (el) {
                var previewItem = {
                    title: el.alt,
                    el: el,
                    index: 0,
                    src: ''
                }
                LOGIC_EVENT_BUS.LOGIC_PREVIEW.list.push(previewItem)
                updateIndex(LOGIC_EVENT_BUS.LOGIC_PREVIEW.list)
                el.addEventListener('click', function (e) {
                    e.stopPropagation()
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.isTitleEnable = el.getAttribute('preview-title-enable') == "false" ? false : true;
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.isHorizontalNavEnable = el.getAttribute('preview-nav-enable') == "false" ? false : true;
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.show = true
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.loading = true
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.current = previewItem
                    getImage(previewItem.src, previewItem)
                })
            },
            update: function (el, oldValue) {
                var previewItem = LOGIC_EVENT_BUS.LOGIC_PREVIEW.list.find(function (item) {
                    return item.el === el
                })
                if (!previewItem) { return }
                previewItem.src = oldValue.value
                previewItem.title = el.alt
            },
            unbind: function (el) {
                if (el) {
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.list.forEach(function (item, index) {
                        if (el === item.el) {
                            LOGIC_EVENT_BUS.LOGIC_PREVIEW.list.splice(index, 1)
                        }
                    })
                }
                updateIndex(LOGIC_EVENT_BUS.LOGIC_PREVIEW.list)
            }
        });

        

    }

    if (!Vue.prototype.$isServer && window.Vue) {
        Vue.use(install); // eslint-disable-line
    }

    /* harmony default export */ __webpack_exports__["a"] = ({});
// };

/***/ }),

/***/ 88:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
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
//
//
//
//

/* harmony default export */ __webpack_exports__["default"] = ({
    name: 'mt-preview',
    computed: {
        preview: function preview () {
            return window.LOGIC_EVENT_BUS.LOGIC_PREVIEW
        }
    },
    methods: {
        leave: function leave (e) {
            if ((this.preview.show)&&(e.target.className.indexOf('lg-preview-nav-arrow') != 0)){
               this.close()
            }
        },
        close: function close () {
            this.preview.show = false
        },
        preAction: function preAction () {
            this.preview.loading = true
            var index = this.preview.list.indexOf(this.preview.current)
            if (index === 0) {
                this.preview.loading = false
                return
            }
            index--
            this.preview.current = this.preview.list[index]
            var img = new window.Image()
            img.src = this.preview.current.src
            img.onload = function () {
                setTimeout(function () {
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.loading = false
                },500)
            }
        },
        nextAction: function nextAction () {
            this.preview.loading = true
            var index = this.preview.list.indexOf(this.preview.current)
            if (index === this.preview.list.length - 1) {
                this.preview.loading = false
                return
            }
            index++
            this.preview.current = this.preview.list[index]
            var img = new window.Image()
            img.src = this.preview.current.src
            img.onload = function () {
                setTimeout(function () {
                    LOGIC_EVENT_BUS.LOGIC_PREVIEW.loading = false
                },500)
            }
        },
    }
});


/***/ })

/******/ });