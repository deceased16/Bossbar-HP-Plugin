package ru.deceased16.bossbarHP;

import org.bukkit.Bukkit;
import org.bukkit.boss.*;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.deceased16.bossbarHP.locales.LocaleManager;
import ru.deceased16.bossbarHP.locales.MobLocale;

import java.util.*;

public final class BossbarHP extends JavaPlugin implements Listener {

    private final Map<UUID, BossBar> activeBars = new HashMap<>();
    private final Map<UUID, Long> barKeepUntil = new HashMap<>();
    private final Map<UUID, UUID> lastTargets = new HashMap<>();
    private final Set<UUID> disabledPlayers = new HashSet<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadDisabledPlayers();

        getServer().getPluginManager().registerEvents(this, this);

        PluginCommand cmd = getCommand("bossbarhp");
        if (cmd != null) cmd.setExecutor(new HPCommand(this));

        new BukkitRunnable() {
            @Override
            public void run() {
                long now = System.currentTimeMillis();

                for (Player player : Bukkit.getOnlinePlayers()) {
                    UUID uuid = player.getUniqueId();

                    if (disabledPlayers.contains(uuid)) {
                        removeBar(uuid);
                        continue;
                    }

                    Entity target = getTargetEntity(player, 10);
                    boolean keep = barKeepUntil.getOrDefault(uuid, 0L) > now;

                    if (target instanceof LivingEntity mob && !(mob instanceof ArmorStand) && !isBoss(mob)) {
                        showBar(player, mob);
                    } else if (!keep) {
                        removeBar(uuid);
                    }
                }
            }
        }.runTaskTimer(this, 0L, 2L);
    }

    private void showBar(Player player, LivingEntity mob) {
        UUID uuid = player.getUniqueId();
        double health = Math.max(0.0, mob.getHealth());
        double maxHealth = mob.getMaxHealth();

        String name = getLocalizedName(mob);

        double hpPercent = health / maxHealth;
        BarColor color = hpPercent < 0.3 ? BarColor.RED : (hpPercent < 0.6 ? BarColor.YELLOW : BarColor.GREEN);
        String healthColor = hpPercent < 0.3 ? "§c" : (hpPercent < 0.6 ? "§e" : "§a");

        String barTitle = String.format("§f%s §7(%s%.1f§7/§a%.1f§7)", name, healthColor, health, maxHealth);

        BossBar bar = activeBars.computeIfAbsent(uuid, id -> {
            BossBar b = Bukkit.createBossBar(barTitle, color, BarStyle.SEGMENTED_10);
            b.addPlayer(player);
            return b;
        });

        bar.setTitle(barTitle);
        bar.setProgress(Math.max(0.0, Math.min(1.0, hpPercent)));

        if (bar.getColor() != color) {
            bar.setColor(color);
        }

        bar.setVisible(true);
        lastTargets.put(uuid, mob.getUniqueId());
    }

    private void removeBar(UUID uuid) {
        BossBar bar = activeBars.remove(uuid);
        if (bar != null) bar.removeAll();
        barKeepUntil.remove(uuid);
        lastTargets.remove(uuid);
    }

    private Entity getTargetEntity(Player player, double range) {
        return player.getTargetEntity((int) range);
    }

    private boolean isBoss(LivingEntity entity) {
        return entity.getType() == EntityType.ENDER_DRAGON || entity.getType() == EntityType.WITHER;
    }

    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player player)) return;
        if (!(event.getEntity() instanceof LivingEntity mob)) return;
        if (mob instanceof ArmorStand || isBoss(mob)) return;
        if (disabledPlayers.contains(player.getUniqueId())) return;

        UUID uuid = player.getUniqueId();
        showBar(player, mob);
        barKeepUntil.put(uuid, System.currentTimeMillis() + 5000);
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        UUID dead = event.getEntity().getUniqueId();
        for (Map.Entry<UUID, UUID> entry : lastTargets.entrySet()) {
            if (entry.getValue().equals(dead)) {
                removeBar(entry.getKey());
            }
        }
    }

    private void loadDisabledPlayers() {
        List<String> list = getConfig().getStringList("disabledPlayers");
        for (String id : list) {
            try {
                disabledPlayers.add(UUID.fromString(id));
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    public Set<UUID> getDisabledPlayers() {
        return disabledPlayers;
    }

    private String getLocalizedName(Entity entity) {
        if (entity.getCustomName() != null) return entity.getCustomName();
        if (entity instanceof Player) return ((Player) entity).getName();

        MobLocale locale = LocaleManager.getMobLocale();
        return locale.getName(entity.getType());
    }

    @Override
    public void onDisable() {
        activeBars.values().forEach(BossBar::removeAll);
        activeBars.clear();
        barKeepUntil.clear();
        lastTargets.clear();

        getConfig().set("disabledPlayers", disabledPlayers.stream().map(UUID::toString).toList());
        saveConfig();
    }
}