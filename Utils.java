package PocketComposer;

/** Various static utility functions.
 *  @author Annie Tsai
 */
public class Utils {

    /** Returns an IllegalArgumentException with specified message.  Arguments
     *  MSG and ARGS are as for String.format. */
    static IllegalArgumentException err(String msg, Object... args) {
        return new IllegalArgumentException(String.format(msg, args));
    }

}
