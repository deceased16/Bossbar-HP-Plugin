/*
 How to add a new language:
 1. Create a new MobLocale class, e.g. SpanishLocale.
 2. Create a new MessageLocale class, e.g. SpanishMessages.
 3. Add constants here:
      private static final MobLocale SPANISH_LOC = new SpanishLocale();
      private static final MessageLocale SPANISH_MSG_LOC = new SpanishMessages();
 4. Add a method to switch:
      public static void setSpanish() {
          mobLocale = SPANISH_LOC;
          messageLocale = SPANISH_MSG_LOC;
      }
 5. Add a case in the switch inside the HPCommand class
*/

package ru.deceased16.bossbarHP.locales;

public class LocaleManager {
    private static MobLocale mobLocale = new EnglishLocale();
    private static MessageLocale messageLocale = new EnglishMessages();

    // ru localization
    private static final MobLocale RUSSIAN_LOC = new RussianLocale();
    private static final MessageLocale RUSSIAN_MSG_LOC = new RussianMessages();

    // en localization
    private static final MobLocale ENGLISH_LOC = new EnglishLocale();
    private static final MessageLocale ENGLISH_MSG_LOC = new EnglishMessages();


    public static void setRussian() {
        mobLocale = RUSSIAN_LOC;
        messageLocale = RUSSIAN_MSG_LOC;
    }

    public static void setEnglish() {
        mobLocale = ENGLISH_LOC;
        messageLocale = ENGLISH_MSG_LOC;
    }

    public static MobLocale getMobLocale() {
        return mobLocale;
    }

    public static MessageLocale getMessageLocale() {
        return messageLocale;
    }
}

