package knubot.db;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import knubot.db.dto.KnubotHistory;
import knubot.db.dto.KnubotTweet;


@Mapper
public interface KnubotMapper {

	@SelectProvider(KnubotSqlProvider.class)
	KnubotTweet selectRandom();

	@SelectProvider(KnubotSqlProvider.class)
	KnubotHistory selectHistory(String userid);

	@InsertProvider(KnubotSqlProvider.class)
	void updateHistory(String userid, String tweet);

}
