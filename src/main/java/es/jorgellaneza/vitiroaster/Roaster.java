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
            "Viti tiene el código muy acoplado y las clases muy poco cohesivas",
            "Viti no sabe salir de vim",
            "Viti cree que no es un bug, que es una feature",
            "Viti es vibecoder",
            "EL lenguaje de programación favorito de Viti es html",
            "Viti es desarrollador frontend",
            "El sueño de Viti es poder correr javascript en cualquier sitio",
            "Si Victor callara la boca el mundo sería mejor",
            "Viti cree que una funcion y un metodo es lo mismo",
            "Viti no recuerda la ultima vez que escribio documéntación",
            "Los automatas de Viti son infinitos y no determinísticos"
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
