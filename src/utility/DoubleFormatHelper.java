package utility;

import java.text.DecimalFormat;

public class DoubleFormatHelper {
    public static String formatDouble(Double value) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value);
    }
}
