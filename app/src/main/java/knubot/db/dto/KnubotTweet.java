package knubot.db.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class KnubotTweet {
	public static final String COLUMN_NAME_ID = "id";
	public static final String COLUMN_NAME_TWEET = "tweet";
	public static final String COLUMN_NAME_TIMESTAMP = "timestamp";

	private String id;
	private String tweet;
	private Timestamp timestamp;

}
