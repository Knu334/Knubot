package knubot.db.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class KnubotHistory {
	public static final String COLUMN_NAME_USERID = "userid";
	public static final String COLUMN_NAME_TWEET = "tweet";
	public static final String COLUMN_NAME_EXEC_DATE = "exec_date";

	private String userid;
	private String tweet;
	private LocalDate execDate;

}
