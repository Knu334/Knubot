package knubot;

import java.time.LocalDate;

import knubot.common.KnubotConstants;
import knubot.db.KnubotRepository;
import knubot.db.dto.KnubotHistory;
import knubot.db.dto.KnubotTweet;
import lombok.extern.log4j.Log4j2;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

@Log4j2
public class KnubotListener extends ListenerAdapter {

	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
		switch (event.getName()) {
		case "knubot":
			String userid = event.getMember().getId();

			if (!LocalDate.now().equals(KnubotConstants.TARGET_DATE)) {
				event.reply(KnubotConstants.ERROR_MSG_DATE_NOT_MATCH).queue();
				log.info(KnubotConstants.LOG_FORMAT, new Object[] { userid, KnubotConstants.ERROR_MSG_DATE_NOT_MATCH });
				break;
			}

			KnubotRepository repository = new KnubotRepository();
			KnubotHistory history = repository.selectHistory(userid);

			if (history != null) {
				event.reply(history.getTweet()).queue();
				log.info(KnubotConstants.LOG_FORMAT, new Object[] { userid, history.getTweet() });
				break;
			}

			KnubotTweet tweet = repository.selectRandom();
			event.reply(tweet.getTweet()).queue();
			log.info(KnubotConstants.LOG_FORMAT, new Object[] { userid, tweet.getTweet() });

			repository.updateHistory(userid, tweet.getTweet());

			break;
		}
	}

}
