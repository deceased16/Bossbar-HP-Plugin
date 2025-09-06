package ru.deceased16.bossbarHP.locales;

import org.bukkit.ChatColor;

public class EnglishMessages implements MessageLocale {

    @Override
    public String getHpEnabled() {
            return ChatColor.GREEN + "Bossbar HP display enabled.";
    }

    @Override
    public String getHpDisabled() {
        return ChatColor.RED + "Bossbar HP display disabled.";
    }

    @Override
    public String getLanguageSet(String lang) {
        return ChatColor.GREEN + "Language set to " + lang + "!";
    }

    @Override
    public String getPlayerOnly() {
        return ChatColor.RED + "Only a player can use this command.";
    }

    @Override
    public String getUnknownLanguage() {
        return ChatColor.RED + "Unknown language!";
    }

    @Override
    public String getUsage(String label) {
        return ChatColor.YELLOW + "Command usage:\n" +
                ChatColor.YELLOW + "/" + label + " toggle - enable/disable HP\n" +
                ChatColor.YELLOW + "/" + label + " language <ru | en> - change language";
    }
}
