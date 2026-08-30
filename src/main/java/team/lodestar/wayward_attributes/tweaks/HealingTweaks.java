package team.lodestar.wayward_attributes.tweaks;

import net.minecraft.world.entity.LivingEntity;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import team.lodestar.wayward_attributes.core.registry.WaywardAttributeTypes;

public class HealingTweaks {

    public static void heal(LivingHealEvent event) {
        if (event.getAmount() <= 0) {
            return;
        }
        final LivingEntity entity = event.getEntity();
        if (!entity.getAttributes().hasAttribute(WaywardAttributeTypes.HEALING_MULTIPLIER)) {
            return;
        }
        float multiplier = (float) entity.getAttributeValue(WaywardAttributeTypes.HEALING_MULTIPLIER);
        event.setAmount(event.getAmount() * multiplier);
    }
}
