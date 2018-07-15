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
/******/ 	return __webpack_require__(__webpack_require__.s = 274);
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

/***/ 10:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "c", function() { return URL; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "d", function() { return STATUS_READY; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "g", function() { return STATUS_UPLOADING; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "e", function() { return STATUS_ERROR; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "f", function() { return STATUS_SUCCESS; });
/* harmony export (immutable) */ __webpack_exports__["b"] = processFiles;
/* unused harmony export processFile */
/* harmony export (immutable) */ __webpack_exports__["a"] = newFile;
var URL = window.URL || window.webkitURL || window.mozURL

var STATUS_READY = 'ready'
var STATUS_UPLOADING = 'uploading'
var STATUS_ERROR = 'error'
var STATUS_SUCCESS = 'success'

function processFiles(files, eachProcessFile, eachCb, cb) {
  var fileItems = []
  var len = files.length
  var processedLen = 0
  for (var i = 0; i < len; i++) {
    processFile(files[i], i, eachProcessFile, function (item, index) {
      processedLen++
      fileItems[index] = item
      eachCb(item, index)
      if (processedLen === len) {
        return cb(fileItems)
      }
    })
  }
}

function processFile(file, i, eachProcessFile, cb) {
  eachProcessFile(file, function (file) {
    var item = newFile(file.name, file.size, STATUS_READY, 0, file)
    cb(item, i)
  })
}

function newFile(name, size, status, progress, file) {
  if ( name === void 0 ) name = '';
  if ( size === void 0 ) size = 0;
  if ( status === void 0 ) status = '';
  if ( progress === void 0 ) progress = 0;
  if ( file === void 0 ) file = null;

  var base64 = file && file.base64 || ''
  var url = base64 ? '' : createURL(file)

  return {
    name: name,
    size: size,
    url: url,
    base64: base64,
    status: status,
    progress: progress,
    file: file
  }
}

function createURL(file) {
  if (file && URL) {
    return URL.createObjectURL(file)
  }
  return ''
}


/***/ }),

/***/ 107:
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

var COMPONENT_NAME = 'cube-upload-btn'

/* harmony default export */ __webpack_exports__["default"] = ({
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
    changeHandler: function changeHandler(e) {
      var fileEle = e.currentTarget
      var files = fileEle.files
      if (files) {
        this.$parent.addFiles(files)
        fileEle.value = null
      }
    }
  }
});


/***/ }),

/***/ 108:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__util__ = __webpack_require__(10);
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



var COMPONENT_NAME = 'cube-upload-file'
var STATUS_CLASS_MAP = {
  success: 'cubeic-right',
  error: 'cubeic-warn'
}
var EVENT_CLICK = 'click'

/* harmony default export */ __webpack_exports__["default"] = ({
  name: COMPONENT_NAME,
  props: {
    file: {
      type: Object,
      required: true
    }
  },
  computed: {
    fileStatusCls: function fileStatusCls() {
      var file = this.file
      var status = file.status
      if (file.progress >= 0.01 || status === __WEBPACK_IMPORTED_MODULE_0__util__["f" /* STATUS_SUCCESS */] || status === __WEBPACK_IMPORTED_MODULE_0__util__["e" /* STATUS_ERROR */]) {
        return 'cube-upload-file_stat'
      }
    },
    fileStyle: function fileStyle() {
      var url = this.file.url || this.file.base64
      if (!url) {
        return
      }
      return {
        'background-image': ("url(\"" + url + "\")")
      }
    },
    statusCls: function statusCls() {
      var status = this.file.status
      return STATUS_CLASS_MAP[status]
    },
    fileProgress: function fileProgress() {
      if (this.statusCls) {
        return '100%'
      }
      var p = Math.min(Math.floor(this.file.progress * 100), 99)
      return (p + "%")
    }
  },
  methods: {
    clickHandler: function clickHandler() {
      this.$emit(EVENT_CLICK, this.file)
    },
    removeFile: function removeFile() {
      this.$parent.removeFile(this.file)
    }
  }
});


/***/ }),

/***/ 109:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__btn_vue__ = __webpack_require__(184);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__btn_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__btn_vue__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__file_vue__ = __webpack_require__(185);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__file_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_1__file_vue__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__ajax__ = __webpack_require__(67);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__util__ = __webpack_require__(10);
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






var COMPONENT_NAME = 'mt-upload'
var EVENT_ADDED = 'files-added'
var EVENT_SUBMITTED = 'file-submitted'
var EVENT_REMOVED = 'file-removed'
var EVENT_SUCCESS = 'file-success'
var EVENT_ERROR = 'file-error'
var EVENT_CLICK = 'file-click'

/* harmony default export */ __webpack_exports__["default"] = ({
  name: COMPONENT_NAME,
  props: {
    action: {
      type: [String, Object],
      default: ''
    },
    max: {
      type: Number,
      default: 10
    },
    auto: {
      type: Boolean,
      default: true
    },
    simultaneousUploads: {
      type: Number,
      default: 1
    },
    processFile: {
      type: Function,
      default: function (file, cb) {
        cb(file)
      }
    },
    multiple:{
      type: Boolean,
      default: false
    }
  },
  data: function data() {
    return {
      files: [],
      paused: !this.auto
    }
  },
  computed: {
    actionOptions: function actionOptions() {
      var action = this.action
      if (typeof action === 'string') {
        return action ? {
          target: action
        } : null
      } else {
        return action
      }
    },
    isShowBtn: function isShowBtn() {
      return this.files.length < this.max
    }
  },
  methods: {
    addFiles: function addFiles(files) {
      var this$1 = this;

      this.$emit(EVENT_ADDED, files)
      var filesLen = this.files.length
      var newFiles = []
      var maxLen = this.max - filesLen
      var i = 0
      var file = files[i]
      while (newFiles.length < maxLen && file) {
        if (!file.ignore) {
          newFiles.push(file)
          this$1.files.push(__webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__util__["a" /* newFile */])())
        }
        file = files[++i]
      }
      __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_3__util__["b" /* processFiles */])(newFiles, this.processFile, function (file, index) {
        this$1.$set(this$1.files, filesLen + index, file)
        this$1.$emit(EVENT_SUBMITTED, file)
      }, function () {
        // waiting ui
        this$1.$nextTick(function () {
          this$1.upload()
        })
      })
    },
    removeFile: function removeFile(file) {
      this.$emit(EVENT_REMOVED, file)
      file._xhr && file._xhr.abort()
      if (file.url) {
        __WEBPACK_IMPORTED_MODULE_3__util__["c" /* URL */].revokeObjectURL(file.url)
      }
      var index = this.files.indexOf(file)
      this.files.splice(index, 1)
      this.upload()
    },
    fileClick: function fileClick(file) {
      this.$emit(EVENT_CLICK, file)
    },
    upload: function upload(retry) {
      var this$1 = this;

      var options = this.actionOptions
      if (this.paused || !options) {
        return
      }
      var len = this.files.length
      var uploadingCount = 0
      var i = 0
      var loop = function () {
        var file = this$1.files[i]
        var status = file.status
        if (status === __WEBPACK_IMPORTED_MODULE_3__util__["d" /* STATUS_READY */] || (retry && status === __WEBPACK_IMPORTED_MODULE_3__util__["e" /* STATUS_ERROR */] && file._retryId !== this$1.retryId)) {
          __webpack_require__.i(__WEBPACK_IMPORTED_MODULE_2__ajax__["a" /* default */])(file, options, function (file) {
            if (status === __WEBPACK_IMPORTED_MODULE_3__util__["e" /* STATUS_ERROR */]) {
              file._retryId = this$1.retryId
            }
            this$1.$emit(file.status === __WEBPACK_IMPORTED_MODULE_3__util__["f" /* STATUS_SUCCESS */] ? EVENT_SUCCESS : EVENT_ERROR, file)
            this$1.upload(retry)
          })
          uploadingCount++
        } else if (status === __WEBPACK_IMPORTED_MODULE_3__util__["g" /* STATUS_UPLOADING */]) {
          uploadingCount++
        }
        i++
      };

      while (i < len && uploadingCount < this.simultaneousUploads) loop();
    },
    start: function start() {
      this.paused = false
      this.upload()
    },
    pause: function pause() {
      this.paused = true
      this.files.forEach(function (file) {
        if (file.status === __WEBPACK_IMPORTED_MODULE_3__util__["g" /* STATUS_UPLOADING */]) {
          file._xhr.abort()
          file.status = __WEBPACK_IMPORTED_MODULE_3__util__["d" /* STATUS_READY */]
        }
      })
    },
    retry: function retry() {
      this.retryId = Date.now()
      this.paused = false
      this.upload(true)
    }
  },
  components: {
    UploadBtn: __WEBPACK_IMPORTED_MODULE_0__btn_vue___default.a,
    UploadFile: __WEBPACK_IMPORTED_MODULE_1__file_vue___default.a
  }
});


/***/ }),

/***/ 116:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 117:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 124:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 184:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(124)
}
var Component = __webpack_require__(0)(
  /* script */
  __webpack_require__(107),
  /* template */
  __webpack_require__(204),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 185:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(117)
}
var Component = __webpack_require__(0)(
  /* script */
  __webpack_require__(108),
  /* template */
  __webpack_require__(195),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 186:
/***/ (function(module, exports, __webpack_require__) {

function injectStyle (ssrContext) {
  __webpack_require__(116)
}
var Component = __webpack_require__(0)(
  /* script */
  __webpack_require__(109),
  /* template */
  __webpack_require__(193),
  /* styles */
  injectStyle,
  /* scopeId */
  null,
  /* moduleIdentifier (server only) */
  null
)

module.exports = Component.exports


/***/ }),

/***/ 193:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "cube-upload",
    class: {
      'cube-upload-single': !_vm.multiple, 'cube-upload-success': _vm.files.length
    }
  }, [_vm._t("default", [_c('div', {
    staticClass: "cube-upload-def clear-fix"
  }, [_vm._l((_vm.files), function(file, i) {
    return _c('upload-file', {
      key: i,
      attrs: {
        "file": file
      },
      on: {
        "click": _vm.fileClick
      }
    })
  }), _vm._v(" "), _c('div', {
    staticClass: "reupload-tip"
  }, [_vm._v("点击重新上传")]), _vm._v(" "), _c('upload-btn', {
    attrs: {
      "multiple": _vm.multiple
    }
  })], 2)])], 2)
},staticRenderFns: []}

/***/ }),

/***/ 195:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "cube-upload-file",
    on: {
      "click": _vm.clickHandler
    }
  }, [_vm._t("default", [_c('div', {
    staticClass: "cube-upload-file-def",
    style: (_vm.fileStyle)
  }, [_c('i', {
    staticClass: "cubeic-wrong",
    on: {
      "click": function($event) {
        $event.stopPropagation();
        return _vm.removeFile($event)
      }
    }
  }), _vm._v(" "), _c('div', {
    staticClass: "cube-upload-file-state",
    class: _vm.fileStatusCls
  }, [_c('i', {
    staticClass: "cube-upload-file-status",
    class: _vm.statusCls
  }), _vm._v(" "), _c('span', {
    staticClass: "cube-upload-file-progress"
  }, [_vm._v(_vm._s(_vm.fileProgress))])])])])], 2)
},staticRenderFns: []}

/***/ }),

/***/ 204:
/***/ (function(module, exports) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "cube-upload-btn"
  }, [_vm._t("default", [_vm._m(0)]), _vm._v(" "), _c('input', {
    staticClass: "cube-upload-input",
    attrs: {
      "type": "file",
      "multiple": _vm.multiple,
      "accept": _vm.accept
    },
    on: {
      "change": _vm.changeHandler
    }
  })], 2)
},staticRenderFns: [function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "cube-upload-btn-def"
  }, [_c('i')])
}]}

/***/ }),

/***/ 274:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(55);


/***/ }),

/***/ 55:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__src_index_vue__ = __webpack_require__(186);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__src_index_vue___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_0__src_index_vue__);
/* harmony reexport (default from non-hamory) */ __webpack_require__.d(__webpack_exports__, "default", function() { return __WEBPACK_IMPORTED_MODULE_0__src_index_vue___default.a; });


/***/ }),

/***/ 67:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (immutable) */ __webpack_exports__["a"] = ajaxUpload;
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__util__ = __webpack_require__(10);


function ajaxUpload(file, options, changeHandler) {
  var target = options.target;
  var headers = options.headers; if ( headers === void 0 ) headers = {};
  var data = options.data; if ( data === void 0 ) data = {};
  var fileName = options.fileName; if ( fileName === void 0 ) fileName = 'file';
  var withCredentials = options.withCredentials;
  var timeout = options.timeout;
  var prop = options.prop; if ( prop === void 0 ) prop = 'file';
  var progressInterval = options.progressInterval; if ( progressInterval === void 0 ) progressInterval = 100;

  file.progress = 0
  file.status = __WEBPACK_IMPORTED_MODULE_0__util__["g" /* STATUS_UPLOADING */]

  var xhr = new window.XMLHttpRequest()
  file._xhr = xhr
  var progressTid = 0
  if (xhr.upload) {
    var lastProgressTime = Date.now()
    xhr.upload.onprogress = function (e) {
      if (e.total > 0) {
        if (progressTid) {
          clearTimeout(progressTid)
          var now = Date.now()
          var diff = now - lastProgressTime
          if (diff >= progressInterval) {
            computed()
          } else {
            progressTid = setTimeout(computed, diff)
          }
        } else {
          // first time
          computed()
          progressTid = 1
        }
      }
      function computed() {
        file.progress = e.loaded / e.total
        lastProgressTime = Date.now()
      }
    }
  }

  var formData = new window.FormData()
  Object.keys(data).forEach(function (key) {
    formData.append(key, data[key])
  })
  formData.append(fileName, file[prop])

  xhr.onload = function () {
    if (xhr.status < 200 || xhr.status >= 300) {
      setStatus(__WEBPACK_IMPORTED_MODULE_0__util__["e" /* STATUS_ERROR */])
      return
    }
    var response = xhr.responseText || xhr.response
    try {
      response = JSON.parse(response)
    } catch (e) {}
    file.response = response
    file.responseHeaders = xhr.getAllResponseHeaders()
    setStatus(__WEBPACK_IMPORTED_MODULE_0__util__["f" /* STATUS_SUCCESS */])
  }
  xhr.onerror = function () {
    setStatus(__WEBPACK_IMPORTED_MODULE_0__util__["e" /* STATUS_ERROR */])
  }
  xhr.ontimeout = function () {
    setStatus(__WEBPACK_IMPORTED_MODULE_0__util__["e" /* STATUS_ERROR */])
  }

  xhr.open('POST', target, true)
  if (withCredentials) {
    xhr.withCredentials = true
  }
  Object.keys(headers).forEach(function (key) {
    xhr.setRequestHeader(key, headers[key])
  })
  if (timeout > 0) {
    xhr.timeout = timeout
  }

  xhr.send(formData)
  function setStatus(status) {
    clearTimeout(progressTid)
    progressTid = 0
    file.progress = 1
    file.status = status
    changeHandler && changeHandler(file, options.data)
  }
}


/***/ })

/******/ });