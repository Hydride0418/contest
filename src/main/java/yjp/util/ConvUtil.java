package yjp.util;

public class ConvUtil {
    public static Integer ConvStrToInt(String str) {
        if (str == null) {
            return 0;
        }
        return Integer.parseInt(str);
    }
}
