package ru.deceased16.bossbarHP.locales;

public class LocaleManager {
    private static MobLocale mobLocale = new EnglishLocale();
    private static MessageLocale messageLocale = new EnglishMessages();

    @SuppressWarnings("unused")
    public static void setLocale(MobLocale mobLoc, MessageLocale msgLoc) {
        mobLocale = mobLoc;
        messageLocale = msgLoc;
    } // Not used yet - may be used in future updates or removed

    public static void setRussian() {
        mobLocale = new RussianLocale();
        messageLocale = new RussianMessages();
    }

    public static void setEnglish() {
        mobLocale = new EnglishLocale();
        messageLocale = new EnglishMessages();
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
