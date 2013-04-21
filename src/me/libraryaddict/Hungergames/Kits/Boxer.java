package me.libraryaddict.Hungergames.Kits;

import me.libraryaddict.Hungergames.Managers.KitManager;
import me.libraryaddict.Hungergames.Types.HungergamesApi;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Boxer implements Listener {

    private KitManager kits = HungergamesApi.getKitManager();

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && kits.hasAbility((Player) event.getDamager(), "Boxer")
                && event.getDamage() == 1)
            event.setDamage(4);
        if (event.getEntity() instanceof Player && kits.hasAbility((Player) event.getEntity(), "Boxer"))
            if (event.getDamage() > 0)
                event.setDamage(event.getDamage() - 1);
    }
}
