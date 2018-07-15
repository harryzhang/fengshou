<template>
    <li class="mt-step-item" :class="currentClass">
        <template v-if="theme == 1">
            <em :class="stepNumber < current ? 'mt-step-checkmark' : ''"><i>{{stepNumber >= current ? stepNumber : ''}}</i></em>
        </template>
        <template v-else>
            <em></em>
        </template>
        <div class="mt-step-item-top">
            <div class="mt-step-item-top-text"><span><slot name="top"></slot></span></div>
        </div>
        <div class="mt-step-item-bottom">
            <slot name="bottom"></slot>
        </div>
    </li>
</template>

<script>
    export default {
        name: 'mt-step-item',
        data() {
            return {
                stepNumber: '',
                current: '',
                theme: '',
                currentClass: ''
            }
        },
        methods: {
            setCurrentClass() {
                if (this.theme == 2) {
                    this.currentClass = this.stepNumber == this.current ? 'mt-step-item-current' : '';
                    return;
                }
                this.currentClass = this.stepNumber <= this.current ? 'mt-step-item-current' : '';
            }
        },
        mounted() {
            this.$nextTick(this.$parent.updateChildStatus);
        }
    }
</script>
