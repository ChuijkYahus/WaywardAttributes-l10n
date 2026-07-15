package team.lodestar.wayward_attributes.tweaks;

import net.minecraft.world.entity.LivingEntity;
import team.lodestar.wayward_attributes.core.registry.WaywardAttributeTypes;

public class BlockInteractionTweaks {

    public static float modifyBlockPlaceDelay(float original, LivingEntity entity) {
        double blockPlaceDelay = Math.max(entity.getAttributeValue(WaywardAttributeTypes.BLOCK_PLACE_DELAY), 0.1f);
        return (float)(blockPlaceDelay * original / 4f);
    }
}