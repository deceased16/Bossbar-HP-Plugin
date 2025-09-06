package ru.deceased16.bossbarHP.locales;

public interface MessageLocale {
    String getHpEnabled();
    String getHpDisabled();
    String getLanguageSet(String lang); // "Язык сменен на Русский!" & "Language set to English!"
    String getPlayerOnly();
    String getUnknownLanguage();
    String getUsage(String label);
}
