package wow.discord;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import wow.net.util.Logger;

public class WoWDiscord
{
	public static void start()
	{
		Runtime.getRuntime().addShutdownHook(new Thread(() ->
		{
			Logger.write("Shutting down DiscordHook");
			DiscordRPC.discordShutdown();
		}));
		
		initDiscord();
		while(true)
		{
			DiscordRPC.discordRunCallbacks();
		}
	}
	
	public static void initDiscord()
	{
		try
		{
			DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler((user) ->
			{
				Logger.write("Welcome " + user.username + "#" + user.discriminator + ".");
				DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder("").setDetails("Logging In...").setBigImage("big_logo", "Placeholder").build());
			}).build();
			DiscordRPC.discordInitialize("508296178648088596", handlers, true);
		}
		catch(Exception ex)
		{
			Logger.write(ex.getMessage());
		}
	}
}
