package ru.deceased16.bossbarHP;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.deceased16.bossbarHP.locales.*;

import java.util.Set;
import java.util.UUID;

public class HPCommand implements CommandExecutor {

    private final BossbarHP plugin;

    public HPCommand(BossbarHP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(LocaleManager.getMessageLocale().getPlayerOnly());
            return true;
        }

        UUID uuid = player.getUniqueId();
        Set<UUID> disabledPlayers = plugin.getDisabledPlayers();
        FileConfiguration config = plugin.getConfig();


        if (args.length == 1 && args[0].equalsIgnoreCase("toggle")) {
            boolean isDisabled = disabledPlayers.contains(uuid);

            if (isDisabled) {
                disabledPlayers.remove(uuid);
            } else {
                disabledPlayers.add(uuid);
            }

            player.sendMessage(isDisabled
                    ? LocaleManager.getMessageLocale().getHpEnabled()
                    : LocaleManager.getMessageLocale().getHpDisabled());

            config.set("disabledPlayers", disabledPlayers.stream().map(UUID::toString).toList());
            plugin.saveConfig();
            return true;
        }


        if (args.length == 2 && args[0].equalsIgnoreCase("language")) {
            String lang = args[1].toLowerCase();

            switch (lang) {
                case "ru" -> {
                    LocaleManager.setRussian();
                    player.sendMessage(LocaleManager.getMessageLocale().getLanguageSet("Русский"));
                }
                case "en" -> {
                    LocaleManager.setEnglish();
                    player.sendMessage(LocaleManager.getMessageLocale().getLanguageSet("English"));
                }
                default -> player.sendMessage(LocaleManager.getMessageLocale().getUnknownLanguage());
            }
            return true;
        }

        player.sendMessage(LocaleManager.getMessageLocale().getUsage(label));
        return true;
    }
}