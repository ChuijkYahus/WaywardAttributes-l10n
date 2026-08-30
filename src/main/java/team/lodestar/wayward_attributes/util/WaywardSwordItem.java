package team.lodestar.wayward_attributes.util;

import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import team.lodestar.lodestone.modules.toolkit.item.*;
import team.lodestar.lodestone.modules.toolkit.item.tools.*;
import team.lodestar.wayward_attributes.core.registry.*;

import static team.lodestar.wayward_attributes.tweaks.SweepAttackTweaks.*;

public class WaywardSwordItem extends LodestoneSwordItem {

    public WaywardSwordItem(Tier tier, float attackDamage, float attackSpeed, float sweepDamage, float sweepRadius, LodestoneItemProperties properties) {
        super(tier, attackDamage, attackSpeed, addSweepingProperties(properties, sweepDamage, sweepRadius));
    }

    public static LodestoneItemProperties addSweepingProperties(LodestoneItemProperties properties, float sweepDamage, float sweepRadius) {
        return properties.mergeAttributes(ItemAttributeModifiers.builder()
                .add(Attributes.SWEEPING_DAMAGE_RATIO, new AttributeModifier(BASE_SWEEP_DAMAGE, sweepDamage, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(WaywardAttributeTypes.SWEEPING_DAMAGE_RADIUS, new AttributeModifier(BASE_SWEEP_RADIUS, sweepRadius, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build());
    }
}
