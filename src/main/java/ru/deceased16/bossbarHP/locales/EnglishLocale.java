package ru.deceased16.bossbarHP.locales;
import org.bukkit.entity.EntityType;

public class EnglishLocale implements MobLocale {
    public String getName(EntityType type) {
        return type.name();
    }
}