<template>
    <label class="mt-radio">
        <input :name="$parent.name" type="radio" @change="changeHandler" :disabled="disabled" :checked="checked"/>
        <span class="mt-radio-icon" :style="[{color: $parent.color}, styles(1)]"><i :style="styles(2)"></i></span>
        <span class="mt-radio-text" v-if="!$slots.default">{{val}}</span>
        <span class="mt-radio-text" v-else><slot></slot></span>
    </label>
</template>

<script>
    export default {
        name: 'mt-radio',
        data() {
            return {
                checked: false
            }
        },
        props: {
            val: [String, Number],
            disabled: {
                type: Boolean,
                default: false
            }
        },
        methods: {
            changeHandler (event) {
                if (this.disabled) return;
                this.checked = event.target.checked;
                this.$parent.change(this.val);
            },
            styles(size) {
                return {
                    width: this.$parent.size / size + 'px',
                    height: this.$parent.size / size + 'px'
                };
            }
        }
    }
</script>
<style>
.mt-radio {
    display: inline-block;
    padding-right: 10px
}

.mt-radio-icon {
    border: 1px solid #ccc;
    border-radius: 50%;
    display: inline-block;
    position: relative;
    z-index: 10;
    vertical-align: -3.3px;
    pointer-events: none
}

.mt-radio-icon>i {
    content: "";
    position: absolute;
    left: 50%;
    top: 50%;
    border-radius: 50%;
    background-color: currentColor;
    opacity: 0;
    -webkit-transform: translate(-50%, -50%) scale(.1);
    transform: translate(-50%, -50%) scale(.1)
}

.mt-radio-text {
    margin-left: 1px;
    font-size: 15px;
    color: #666;
    pointer-events: none
}

.mt-radio>input[type=radio] {
    position: absolute;
    left: -9999em
}

.mt-radio>input[type=radio]:checked+.mt-radio-icon {
    border-color: currentColor
}

.mt-radio>input[type=radio]:checked+.mt-radio-icon>i {
    opacity: 1;
    -webkit-transform: translate(-50%, -50%) scale(1);
    transform: translate(-50%, -50%) scale(1);
    -webkit-transition: all .2s ease-in-out;
    transition: all .2s ease-in-out
}

.mt-radio>input[type=radio]:disabled~.mt-radio-text {
    color: #ccc
}

.mt-radio>input[type=radio]:disabled+.mt-radio-icon {
    border-color: #ccc;
    background-color: #f3f3f3
}

.mt-radio>input[type=radio]:disabled+.mt-radio-icon>i {
    background-color: #ccc
}
</style>
