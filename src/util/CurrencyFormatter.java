package util;

import java.text.DecimalFormat;

import common.AppConstant;

public final class CurrencyFormatter {
    public static final DecimalFormat formatter = new DecimalFormat(AppConstant.CURRENCY_FORMAT);

    public static String formatVND(double value) {
        return new StringBuilder()
            .append(formatter.format(value))
            .append("đ") 
            .toString();
    }
}
