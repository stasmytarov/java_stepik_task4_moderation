package com.company;

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    public Label processText(String text) {
        Label resultlong = Label.TOO_LONG;
        String[] strArray3 = text.split(" ");
        for (int str3 = 0; str3 < strArray3.length; str3++) {
            if (maxLength < strArray3[str3].length()) {
                return resultlong;
            }
        }
        return Label.OK;
    }
}
