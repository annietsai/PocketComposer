package PocketComposer;

import java.util.ArrayList;

/** Represents the state of a progression of chords.
 *  @author Annie Tsai
 */
class Progression {

    /** Initial ArrayList to hold memory states of the progression. */
    private ArrayList<Progression> memory = new ArrayList<Progression>();

    /** A new, empty Progression. */
    Progression() {
        _chords = new ArrayList<>();
    }

    /** The sequence of chords in this progression. */
    private final ArrayList<Chord> _chords;
}