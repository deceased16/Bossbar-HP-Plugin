package ru.deceased16.bossbarHP.locales;

import org.bukkit.ChatColor;

public class RussianMessages implements MessageLocale {

    @Override
    public String getHpEnabled() {
        return ChatColor.GREEN + "Показ боссбара с ХП включён.";
    }

    @Override
    public String getHpDisabled() {
        return ChatColor.RED + "Показ боссбара с ХП отключён.";
    }

    @Override
    public String getLanguageSet(String lang) {
        return ChatColor.GREEN + "Язык сменен на " + lang + "!";
    }

    @Override
    public String getPlayerOnly() {
        return ChatColor.RED + "Только игрок может использовать эту команду.";
    }

    @Override
    public String getUnknownLanguage() {
        return ChatColor.RED + "Неизвестный язык!";
    }

    @Override
    public String getUsage(String label) {
        return ChatColor.YELLOW + "Использование команды:\n" +
                ChatColor.YELLOW + "/" + label + " toggle - включить/выключить HP\n" +
                ChatColor.YELLOW + "/" + label + " language <ru | en> - сменить язык";
    }
}
