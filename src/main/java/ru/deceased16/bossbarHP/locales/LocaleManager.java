package ru.deceased16.bossbarHP.locales;

public class LocaleManager {
    private static MobLocale mobLocale = new EnglishLocale();
    private static MessageLocale messageLocale = new EnglishMessages();


    public static void setLocale(MobLocale mobLoc, MessageLocale msgLoc) {
        mobLocale = mobLoc;
        messageLocale = msgLoc;
    }

    public static void setRussian() {
        mobLocale = new RussianLocale();
        messageLocale = new RussianMessages();
    }

    public static void setEnglish() {
        mobLocale = new EnglishLocale();
        messageLocale = new EnglishMessages();
    }

    public static MobLocale getMobLocale() {
        return mobLocale;
    }

    public static MessageLocale getMessageLocale() {
        return messageLocale;
    }
}
