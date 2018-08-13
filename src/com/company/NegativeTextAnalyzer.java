package com.company;

class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    String [] negativewords = {":(","=(",":|"};

    protected String [] getKeywords() {
        return negativewords;
    }

    protected Label getLabel() {
        return Label.OK;
    }

    public Label processText(String text) {
        String[] strArray2 = text.split(" ");
        Label resultneg = Label.NEGATIVE_TEXT;
        for (int str2 = 0; str2 < strArray2.length; str2++) {
            for (int z = 0; z < negativewords.length; z++) {
                if (negativewords[z].equals(strArray2[str2])) {
                    return resultneg;
                }
            }
        }
        return Label.OK;
    }
}

