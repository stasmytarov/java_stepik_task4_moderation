package com.company;

abstract class KeywordAnalyzer implements TextAnalyzer  {
    protected abstract String [] getKeywords();
    protected abstract Label getLabel();
    public Label processText(String text) {
        return Label.OK;
    }
}
