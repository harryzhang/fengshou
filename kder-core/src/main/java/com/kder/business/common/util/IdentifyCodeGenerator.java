package com.kder.business.common.util;

import java.util.Random;

public class IdentifyCodeGenerator {

    private static String codeRangeAsscii = "abcdefghijklmnopqrstuvwxyz0123456789";

    private static String codeRangeNumber = "0123456789";

    // 生成字符串从此序列中取
    private static Random random = new Random();

    private IdentifyCodeGenerator() {
    }

    /**
     * 生成登录验证码
     * 
     * @param checkCodeLength 验证码的位数
     * @return
     */
    public static String generateLoginIdentifyCode(int identifyCodeLength) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < identifyCodeLength; i++) {
            int number = random.nextInt(codeRangeAsscii.length());
            sb.append(codeRangeAsscii.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 生成手机验证码
     * 
     * @param checkCodeLength 验证码的位数
     * @return
     */
    public static String generateIdentifyCode(int identifyCodeLength) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < identifyCodeLength; i++) {
            int number = random.nextInt(codeRangeNumber.length());
            sb.append(codeRangeNumber.charAt(number));
        }
        return sb.toString();
    }
}
