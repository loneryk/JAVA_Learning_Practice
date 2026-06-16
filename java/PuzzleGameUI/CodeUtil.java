package PuzzleGameUI;

import java.util.Random;

public class CodeUtil {
    // 定义验证码可能的字符集
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 4; // 验证码长度

    /**
     * 生成随机验证码
     * @return 随机生成的验证码字符串
     */
    public static String getCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            code.append(CHARACTERS.charAt(index));
        }

        return code.toString();
    }
}
