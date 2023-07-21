package knubot;

public class Application {

	public static void main(String[] args) {
		Knubot bot = new Knubot(System.getenv("BOT_TOKEN"));
		bot.execute();
	}

}
