
<!-- 
<mt-radio-group v-model="radio5" size="30" color="#F00">
        <mt-radio val="1"><span style="font-size: 24px;">男</span></mt-radio>
        <mt-radio val="2"><span style="font-size: 24px;">女</span></mt-radio>
        <mt-radio val="3"><span style="font-size: 24px;">未知</span></mt-radio>
</mt-radio-group>
-->
<template>
    <div>
        <slot></slot>
    </div>
</template>

<script>
    const isColor = function(value) {
        const colorReg = /^#([a-fA-F0-9]){3}(([a-fA-F0-9]){3})?$/;
        const rgbaReg = /^[rR][gG][bB][aA]\(\s*((25[0-5]|2[0-4]\d|1?\d{1,2})\s*,\s*){3}\s*(\.|\d+\.)?\d+\s*\)$/;
        const rgbReg = /^[rR][gG][bB]\(\s*((25[0-5]|2[0-4]\d|1?\d{1,2})\s*,\s*){2}(25[0-5]|2[0-4]\d|1?\d{1,2})\s*\)$/;
        return colorReg.test(value) || rgbaReg.test(value) || rgbReg.test(value);
    };
  export default {
        name: 'mt-radio-group',
        data () {
            return {
                currentValue: this.value
            }
        },
        props: {
            value: {
                type: [String, Number],
                default: ''
            },
            color: {
                validator(value) {
                    if (!value) return true;
                    return isColor(value);
                },
                default: '#4CD864'
            },
            size: {
                validator(val) {
                    return /^([1-9]\d*)$/.test(val);
                },
                default: 20
            }
        },
        methods: {
            updateValue() {
                const value = this.value;
                this.childrens = this.$children.filter(item => item.$options.name === 'mt-radio');
                if (this.childrens) {
                    this.childrens.forEach(child => {
                        child.checked = value == child.val;
                    });
                }
            },
            change(val) {
                this.currentValue = val;
                this.updateValue();
                this.$emit('input', val);
            }
        },
        watch: {
            value() {
                this.updateValue();
            }
        },
        mounted() {
            this.$nextTick(this.updateValue);
        }
    }
</script>

