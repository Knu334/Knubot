package knubot.db;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import knubot.common.KnubotConstants;
import knubot.db.dto.KnubotHistory;
import knubot.db.dto.KnubotTweet;

public class KnubotRepository {

	public KnubotTweet selectRandom() {
		KnubotTweet tweet = null;
		SqlSession session = null;
		try (InputStream inputStream = Resources.getResourceAsStream(KnubotConstants.MYBATIS_CONFIG_PATH)) {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
			tweet = session.getMapper(KnubotMapper.class).selectRandom();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return tweet;
	}

	public KnubotHistory selectHistory(String userid) {
		KnubotHistory history = null;
		SqlSession session = null;
		try (InputStream inputStream = Resources.getResourceAsStream(KnubotConstants.MYBATIS_CONFIG_PATH)) {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
			history = session.getMapper(KnubotMapper.class).selectHistory(userid);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return history;
	}

	public void updateHistory(String userid, String tweet) {
		SqlSession session = null;
		try (InputStream inputStream = Resources.getResourceAsStream(KnubotConstants.MYBATIS_CONFIG_PATH)) {
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
			session.getMapper(KnubotMapper.class).updateHistory(userid, tweet);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.commit();
				session.close();
			}
		}
	}

}
