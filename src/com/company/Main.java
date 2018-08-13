package com.company;


public class Main {
    public static void main(String[] args) {
        String words [] = {"отстой", "круто", "класс"};

        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(words);
        NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
        TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(10);
        InputHelper helper = new InputHelper();
        TextAnalyzer[] analyzers = {spamAnalyzer, negativeTextAnalyzer, tooLongTextAnalyzer};

        String userinput = helper.getUserInput("Введите комментарий:");
        checkLabels(analyzers, userinput);


        if (checkLabels(analyzers, userinput) == Label.OK) {
            System.out.println("Комментарий прошёл модерацию");
        }
        if (checkLabels(analyzers, userinput) == Label.SPAM) {
            System.out.println("Комментарий не прошёл модерацию. Это спам. ");
        }
        if (checkLabels(analyzers, userinput) == Label.NEGATIVE_TEXT) {
            System.out.println("Комментарий не прошёл модерацию. Это текст негативного содержания.");
        }
        if (checkLabels(analyzers, userinput) == Label.TOO_LONG) {
            System.out.println("Комментарий не прошёл модерацию. Текст содержит слишком длинное слово.");
        }
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        Label result = null;
        for ( TextAnalyzer textAnalyzer : analyzers ) {
            result = textAnalyzer.processText(text);
            if (!Label.OK.equals(result)) {
                return result;
            }
        }
        return result;
    }
}
