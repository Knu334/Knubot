package knubot;

import java.util.Collections;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Knubot {
	private String botToken = null;

	public Knubot(String botToken) {
		this.botToken = botToken;
	}

	public void execute() {
		JDA jda = JDABuilder.createDefault(botToken, Collections.emptyList())
				.addEventListeners(new KnubotListener())
				.build();

		jda.updateCommands().addCommands(
				Commands.slash("knubot", "けぬさんから今年の格言を授かります。")
						.setGuildOnly(true))
				.queue();
	}
}
