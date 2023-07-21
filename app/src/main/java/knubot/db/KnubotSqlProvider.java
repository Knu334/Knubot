package knubot.db;

import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

import knubot.common.KnubotConstants;
import knubot.db.dto.KnubotHistory;

public class KnubotSqlProvider implements ProviderMethodResolver {

	public String selectRandom() {
		return new SQL() {
			{
				SELECT("*");
				FROM(KnubotConstants.TABLE_NAME_TWEET);
				ORDER_BY("random()");
				LIMIT(1);
			}
		}.toString();
	}

	public String selectHistory(String userid) {
		return new SQL() {
			{
				SELECT("*");
				FROM(KnubotConstants.TABLE_NAME_HISTORY);
				WHERE(createWhereString(KnubotHistory.COLUMN_NAME_USERID, userid));
				WHERE(createWhereString(KnubotHistory.COLUMN_NAME_EXEC_DATE,
						KnubotConstants.TARGET_DATE.toString()));
			}
		}.toString();
	}

	public String updateHistory(String userid, String tweet) {
		return new SQL() {
			{
				INSERT_INTO(KnubotConstants.TABLE_NAME_HISTORY);
				VALUES(KnubotHistory.COLUMN_NAME_USERID, convertSqlString(userid));
				VALUES(KnubotHistory.COLUMN_NAME_TWEET, convertSqlString(tweet));
				VALUES(KnubotHistory.COLUMN_NAME_EXEC_DATE, convertSqlString(KnubotConstants.TARGET_DATE.toString()));
			}
		}.toString();
	}

	private String createWhereString(String column, String value) {
		StringBuilder builder = new StringBuilder();
		builder.append(column);
		builder.append("=");
		builder.append(this.convertSqlString(value));
		return builder.toString();
	}

	private String convertSqlString(String s) {
		return "'" + s + "'";
	}

}
