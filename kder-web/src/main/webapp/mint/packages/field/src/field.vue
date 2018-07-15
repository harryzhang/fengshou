<template>
  <x-cell
    class="mint-field"
    :title="label"
    v-clickoutside="doCloseActive"
    :class="[{
      'is-textarea': type === 'textarea',
      'is-nolabel': !label
    }]">
    <slot name="icon"></slot>
    <textarea
      @change="$emit('change', currentValue)"
      ref="textarea"
      class="mint-field-core"
      :placeholder="placeholder"
      v-if="type === 'textarea'"
      :rows="rows"
      :disabled="disabled"
      :readonly="readonly"
      @focus="focusTarget='textarea'"
      @blur="focusTarget=null"
      v-model="currentValue">
    </textarea>
    <input
      @change="$emit('change', currentValue)"
      ref="input"
      class="mint-field-core"
      :placeholder="placeholder"
      :number="type === 'number'"
      v-else
      :type="type"
      @focus="active = true,focusTarget='input'"
      :disabled="disabled"
      :readonly="readonly"
      :value="currentValue"
      @blur="focusTarget=null"
      @input="handleInput">
    <div
      @click="handleClear"
      class="mint-field-clear"
      v-if="!disableClear"
      v-show="currentValue && type !== 'textarea' && active">
      <i class="mintui mintui-field-error"></i>
    </div>
    <span class="mint-field-state" v-if="state" :class="['is-' + state]">
      <i class="mintui" :class="['mintui-field-' + state]"></i>
    </span>
    <div v-if="eyeIcon==true" class="mint-eye" :class="{'mint-eye-open':!eyeOff}" @click="toggleEye"></div>
    <div class="mint-field-other">
      <slot></slot>
    </div>
  </x-cell>
</template>

<script>
import XCell from 'mint-ui/packages/cell/index.js';
import Clickoutside from 'mint-ui/src/utils/clickoutside';
if (process.env.NODE_ENV === 'component') {
  require('mint-ui/packages/cell/style.css');
}

/**
 * mt-field
 * @desc 编辑器，依赖 cell
 * @module components/field
 *
 * @param {string} [type=text] - field 类型，接受 text, textarea 等
 * @param {string} [label] - 标签
 * @param {string} [rows] - textarea 的 rows
 * @param {string} [placeholder] - placeholder
 * @param {string} [disabled] - disabled
 * @param {string} [readonly] - readonly
 * @param {string} [state] - 表单校验状态样式，接受 error, warning, success
 *
 * @example
 * <mt-field v-model="value" label="用户名"></mt-field>
 * <mt-field v-model="value" label="密码" placeholder="请输入密码"></mt-field>
 * <mt-field v-model="value" label="自我介绍" placeholder="自我介绍" type="textarea" rows="4"></mt-field>
 * <mt-field v-model="value" label="邮箱" placeholder="成功状态" state="success"></mt-field>
 */
export default {
  name: 'mt-field',

  data() {
    return {
      winHeight: window.innerHeight,
      active: false,
      focusTarget:null,
      currentValue: this.value,
      eyeOff: true,
      eyeIcon: false
    };
  },

  directives: {
    Clickoutside
  },

  props: {
    type: {
      type: String,
      default: 'text'
    },
    rows: String,
    label: String,
    placeholder: String,
    readonly: Boolean,
    disabled: Boolean,
    disableClear: Boolean,
    state: {
      type: String,
      default: 'default'
    },
    value: {},
    attr: Object
  },

  components: { XCell },

  methods: {
    doCloseActive() {
      this.active = false;
    },

    handleInput(evt) {
      this.currentValue = evt.target.value;
    },

    handleClear() {
      if (this.disabled || this.readonly) return;
      this.currentValue = '';
    },

    toggleEye(){
      this.eyeOff = !this.eyeOff;
      this.$refs['input'].setAttribute('type', this.eyeOff ? 'password' : 'text');
    },

    getElemViewPosition (elem) {
        if (document.documentElement.getBoundingClientRect) {
            var elemBCR = elem.getBoundingClientRect();
            return {
                top: elemBCR.top,
                right: elemBCR.right,
                bottom: elemBCR.bottom,
                left: elemBCR.left
            };
        }
    },

    resize(){
      try {
        var focusTarget = this.$refs[this.focusTarget],
        iWrapper = document.querySelectorAll('.i-wrapper')[0],
        sPos;
        if(focusTarget&&focusTarget.scrollIntoViewIfNeeded&&window.innerHeight<this.winHeight){
          iWrapper.scrollTop = this.getElemViewPosition(focusTarget).top+iWrapper.scrollTop-window.innerHeight/2;
        }
      } catch (error) {
      }
    }
  },

  watch: {
    value(val) {
      this.currentValue = val;
    },

    currentValue(val) {
      this.$emit('input', val);
    },

    attr: {
      immediate: true,
      handler(attrs) {
        this.$nextTick(() => {
          const target = [this.$refs.input, this.$refs.textarea];
          target.forEach(el => {
            if (!el || !attrs) return;
            Object.keys(attrs).map(name => el.setAttribute(name, attrs[name]));
          });
        });
      }
    }
  },
  beforeUpdate(){
    if(this.type=='password') this.eyeIcon=true;
  },
  mounted(){
    if(this.type=='password') this.eyeIcon=true;
    window.addEventListener('resize', this.resize)
  },
  beforeDestroy(){
    window.removeEventListener('resize', this.resize)
  }
};
</script>

<style lang="css">
  @import "../../../src/style/var.css";

  @component-namespace mint {
    @component field {
      display: flex;

      .mint-eye{
        width: 20px;
        height: 20px;
        background-size: 20px auto;
        background-image: url('../../../src/assets/eye.png');
        background-repeat: no-repeat;
        margin-left:20px;
      }
      .mint-eye-open{
        background-position: 0 -20px;
      }

      @when textarea {
        align-items: inherit;

        .mint-cell-title {
          padding: 10px 0;
        }

        .mint-cell-value {
          padding: 5px 0;
        }
      }

      .mint-cell-title {
        width: 105px;
        flex: none;
      }

      .mint-cell-value {
        flex: 1;
        color: inherit;
        display: flex;
      }

      @descendent core {
        appearance: none;
        border-radius: 0;
        border: 0;
        flex: 1;
        outline: 0;
        line-height: 1.6;
        font-size: inherit;
        width: 100%;
      }

      @descendent clear {
        opacity: .2;
      }

      @descendent state {
        color: inherit;
        margin-left: 20px;

        .mintui {
          font-size: 20px;
        }

        @when error {
          color: $error-color;
        }

        @when warning {
          color: $warning-color;
        }

        @when success {
          color: $success-color;
        }

        @when default {
          margin-left: 0;
        }
      }

      @descendent other {
        position: relative 0 0 * *;
      }

      @when nolabel {
        .mint-cell-title {
          display: none;
        }
      }
    }
  }
</style>
