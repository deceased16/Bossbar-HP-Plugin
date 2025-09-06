package ru.deceased16.bossbarHP.locales;

import org.bukkit.entity.EntityType;
import java.util.HashMap;
import java.util.Map;

public class RussianLocale implements MobLocale {

    private final Map<EntityType, String> names = new HashMap<>();

    public RussianLocale() {
        names.put(EntityType.ALLAY, "Тихоня");
        names.put(EntityType.AXOLOTL, "Аксолотль");
        names.put(EntityType.ARMADILLO,"Броненосец");
        names.put(EntityType.BAT, "Летучая мышь");
        names.put(EntityType.BEE, "Пчела");
        names.put(EntityType.BLAZE, "Всполох");
        names.put(EntityType.BREEZE, "Вихрь");
        names.put(EntityType.BOGGED, "Болотник");
        names.put(EntityType.CAMEL, "Верблюд");
        names.put(EntityType.CAT, "Кот");
        names.put(EntityType.CAVE_SPIDER, "Пещерный паук");
        names.put(EntityType.CHICKEN, "Курица");
        names.put(EntityType.COD, "Треска");
        names.put(EntityType.COW, "Корова");
        names.put(EntityType.CREEPER, "Крипер");
        names.put(EntityType.CREAKING, "Скрипун");
        names.put(EntityType.DOLPHIN, "Дельфин");
        names.put(EntityType.DONKEY, "Осёл");
        names.put(EntityType.DROWNED, "Утопленник");
        names.put(EntityType.ELDER_GUARDIAN, "Древний страж");
        names.put(EntityType.ENDERMAN, "Эндермен");
        names.put(EntityType.ENDERMITE, "Эндермит");
        names.put(EntityType.EVOKER, "Заклинатель");
        names.put(EntityType.FOX, "Лиса");
        names.put(EntityType.FROG, "Лягушка");
        names.put(EntityType.GHAST, "Гаст");
        names.put(EntityType.GIANT, "Гигант");
        names.put(EntityType.GLOW_SQUID, "Светящийся спрут");
        names.put(EntityType.GOAT, "Коза");
        names.put(EntityType.GUARDIAN, "Страж");
        names.put(EntityType.HOGLIN, "Хоглин");
        names.put(EntityType.HORSE, "Лошадь");
        names.put(EntityType.HUSK, "Кадавр");
        names.put(EntityType.ILLUSIONER, "Иллюзор");
        names.put(EntityType.IRON_GOLEM, "Железный голем");
        names.put(EntityType.LLAMA, "Лама");
        names.put(EntityType.MAGMA_CUBE, "Магмовый куб");
        names.put(EntityType.MOOSHROOM, "Грибная корова");
        names.put(EntityType.MULE, "Мул");
        names.put(EntityType.OCELOT, "Оцелот");
        names.put(EntityType.PANDA, "Панда");
        names.put(EntityType.PARROT, "Попугай");
        names.put(EntityType.PHANTOM, "Фантом");
        names.put(EntityType.PIG, "Свинья");
        names.put(EntityType.PIGLIN, "Пиглин");
        names.put(EntityType.PIGLIN_BRUTE, "Брутальный пиглин");
        names.put(EntityType.PILLAGER, "Разбойник");
        names.put(EntityType.POLAR_BEAR, "Белый медведь");
        names.put(EntityType.PUFFERFISH, "Иглобрюх");
        names.put(EntityType.RABBIT, "Кролик");
        names.put(EntityType.RAVAGER, "Разоритель");
        names.put(EntityType.SALMON, "Лосось");
        names.put(EntityType.SHEEP, "Овца");
        names.put(EntityType.SHULKER, "Шалкер");
        names.put(EntityType.SILVERFISH, "Чешуйница");
        names.put(EntityType.SKELETON, "Скелет");
        names.put(EntityType.SNIFFER, "Нюхач");
        names.put(EntityType.SKELETON_HORSE, "Лошадь-скелет");
        names.put(EntityType.SLIME, "Слизень");
        names.put(EntityType.SNOW_GOLEM, "Снежный голем");
        names.put(EntityType.SPIDER, "Паук");
        names.put(EntityType.SQUID, "Спрут");
        names.put(EntityType.STRAY, "Зимогор");
        names.put(EntityType.STRIDER, "Лавомерка");
        names.put(EntityType.TADPOLE, "Головастик");
        names.put(EntityType.TRADER_LLAMA, "Лама-торговец");
        names.put(EntityType.TROPICAL_FISH, "Тропическая рыба");
        names.put(EntityType.TURTLE, "Черепаха");
        names.put(EntityType.VEX, "Вредина");
        names.put(EntityType.VILLAGER, "Крестьянин");
        names.put(EntityType.VINDICATOR, "Поборник");
        names.put(EntityType.WANDERING_TRADER, "Странствующий торговец");
        names.put(EntityType.WARDEN, "Хранитель");
        names.put(EntityType.WITCH, "Ведьма");
        names.put(EntityType.WITHER_SKELETON, "Визер-скелет");
        names.put(EntityType.WOLF, "Волк");
        names.put(EntityType.ZOGLIN, "Зоглин");
        names.put(EntityType.ZOMBIE, "Зомби");
        names.put(EntityType.ZOMBIE_HORSE, "Лошадь-зомби");
        names.put(EntityType.ZOMBIE_VILLAGER, "Зомби-крестьянин");
        names.put(EntityType.ZOMBIFIED_PIGLIN, "Зомбифицированный пиглин");
    }

    @Override
    public String getName(EntityType type) {
        return names.getOrDefault(type, type.name());
    }
}
