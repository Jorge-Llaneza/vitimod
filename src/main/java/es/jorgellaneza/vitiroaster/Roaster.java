package es.jorgellaneza.vitiroaster;


import net.minecraft.network.chat.Component;


import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Vitiroaster.MODID)
public class Roaster {

    private static final String VITI_NAME = "Llanepasto13";
    private static final Random rand = new Random();
    private static final List<String> roasts = List.of(
            "Viti codigo acoplado1",
            "Viti codigo acoplado2",
            "Viti codigo acoplado3",
            "Viti codigo acoplado4",
            "Viti codigo acoplado5",
            "Viti codigo acoplado6"
    );

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void roastViti(@NotNull ServerChatEvent event) {
        var player = event.getPlayer();
        var name = player.getName().getString();
        var server = player.getServer();

        if (name.equals(VITI_NAME) && server != null) {
            var originalMessage = event.getMessage();
            event.setCanceled(true);

            server.getPlayerList().broadcastSystemMessage(originalMessage, false);

            server.getPlayerList().broadcastSystemMessage(
                    Component.literal("§c" + roasts.get(rand.nextInt(roasts.size()))),
                    false
            );
        }
    }
}
