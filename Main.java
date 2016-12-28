package PocketComposer;

/** The main class for Pocket Composer.
 *  @author Annie Tsai
 */
public class Main {

    /** The main program. */
    public static void main(String... args) {
        
    }

    /** Set up and run Pocket Composer. */
    void run() {
        Game game = new Game();
        Player player;

        player = null;
        if (_options.contains("--text")) {
            player = new TextPlayer(game);
        } else {
            player = new GUIPlayer(game);
        }

        player.play();
    }

}
