package team.lodestar.wayward_attributes.tweaks;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import team.lodestar.wayward_attributes.core.registry.WaywardAttributeTypes;

public class InteractionTweaks {

    public static float modifyInteractionRate(LivingEntity entity, float original) {
        double interactionRate = entity.getAttributeValue(WaywardAttributeTypes.INTERACTION_RATE);
        return (float)(original / interactionRate);
    }

    public static AABB modifyCollectionRadius(Player player, AABB original) {
        double radius = player.getAttributeValue(WaywardAttributeTypes.COLLECTION_RADIUS);
        if (radius == 1) {
            return original;
        }
        double xSize = original.getXsize() * radius;
        double ySize = original.getYsize() * radius;
        double zSize = original.getZsize() * radius;
        return AABB.ofSize(original.getCenter(), xSize, ySize, zSize);
    }
}