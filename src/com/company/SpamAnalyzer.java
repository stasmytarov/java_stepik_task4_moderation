package com.company;

class SpamAnalyzer extends KeywordAnalyzer {
    private String [] keywords;

    SpamAnalyzer(String [] keywords) {
        this.keywords = keywords;
    }

    protected String [] getKeywords() {
        return keywords;
    }

    protected Label getLabel() {
        return Label.OK;
    }

    public Label processText(String text) {
        String[] strArray1 = text.split(" ");
        Label resultspam = Label.SPAM;
        for (int str1 = 0; str1 < strArray1.length; str1++) {
            for (int y = 0; y < keywords.length; y++) {
                if (keywords[y].equals(strArray1[str1])) {
                    return resultspam;
                }
            }
        }
        return Label.OK;
    }
}
