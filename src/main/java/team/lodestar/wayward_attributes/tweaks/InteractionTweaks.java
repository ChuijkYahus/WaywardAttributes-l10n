package team.lodestar.wayward_attributes.tweaks;

import net.minecraft.world.entity.LivingEntity;
import team.lodestar.wayward_attributes.core.registry.WaywardAttributeTypes;

public class InteractionTweaks {

    public static float modifyInteractionRate(float original, LivingEntity entity) {
        double interactionRate = Math.max(entity.getAttributeValue(WaywardAttributeTypes.INTERACTION_RATE), 0.1f);
        return (float)(original / interactionRate);
    }
}