package ru.deceased16.bossbarHP.locales;

public class LocaleManager {
    private static MobLocale mobLocale = new EnglishLocale();
    private static MessageLocale messageLocale = new EnglishMessages();

    // ru localization
    private static final RUSSIAN_LOC = new RussianLocale();
    private static final RUSSIAN_MSG_LOC = new RussianMessages();

    // en localization
    private static final ENGLISH_LOC = new EnglishLocale();
    private static final ENGLISH_MSG_LOC = new EnglishMessages();

    @SuppressWarnings("unused")
    public static void setLocale(MobLocale mobLoc, MessageLocale msgLoc) {
        mobLocale = mobLoc;
        messageLocale = msgLoc;
    } // Not used yet - may be used in future updates or removed

    public static void setRussian() {
        mobLocale = RUSSIAN_LOC;
        messageLocale = RUSSIAN_MSG_LOC;
    }

    public static void setEnglish() {
        mobLocale = ENGLISH_LOC;
        messageLocale = ENGLISH_MSG_LOC;
    }

    // To add a new language, create classes for both mob and message locales,
    // then add a new static method here similar to the examples above.
    // Example for Spanish:
    // public static void setSpanish() {
    //     mobLocale = new SpanishLocale();
    //     messageLocale = new SpanishMessages();
    // }

    public static MobLocale getMobLocale() {
        return mobLocale;
    }

    public static MessageLocale getMessageLocale() {
        return messageLocale;
    }
}

