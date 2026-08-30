package team.lodestar.wayward_attributes.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import team.lodestar.wayward_attributes.tweaks.InteractionTweaks;

@Mixin(Minecraft.class)
public class MinecraftMixin {

    @ModifyConstant(
            method = "startUseItem",
            constant = @Constant(intValue = 4)
    )
    private int modifyRightClickDelay(int original) {
        Player player = Minecraft.getInstance().player;
        if (player != null) {
            return Math.round(InteractionTweaks.modifyInteractionRate(Minecraft.getInstance().player, original));
        }
        return  original;
    }
}
