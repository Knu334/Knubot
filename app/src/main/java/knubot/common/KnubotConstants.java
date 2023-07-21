package knubot.common;

import java.time.LocalDate;

public class KnubotConstants {

	private KnubotConstants() {
	}

	public static final LocalDate TARGET_DATE = LocalDate.of(LocalDate.now().getYear(), 7, 22);

	public static final String MYBATIS_CONFIG_PATH = "mybatis-config.xml";

	public static final String TABLE_NAME_TWEET = "knubot.tweets";

	public static final String TABLE_NAME_HISTORY = "knubot.exec_history";

	public static final String ERROR_MSG_DATE_NOT_MATCH = "審判の日ではありません。";

	public static final String LOG_FORMAT = "userid: {}\tmessage: {}";

}
