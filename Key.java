package PocketComposer;

/** The keys in a piano, ordered from lowest note to highest.
 *  @author Annie Tsai
 */
enum Key {

    /** The piano keys. Names start with one or two characters (depending on
     *  whether the note is a white or black key) for the note name, followed by
     *  the rank (starting with 1 from left to right on a full piano). */
    A1, Bb1, B1, C1, Db1, D1, Eb1, E1, F1, Gb1, G1, Ab1,
    A2, Bb2, B2, C2, Db2, D2, Eb2, E2, F2, Gb2, G2, Ab2,
    A3, Bb3, B3, C3, Db3, D3, Eb3, E3, F3, Gb3, G3, Ab3,
    A4, Bb4, B4, C4, Db4, D4, Eb4, E4, F4, Gb4, G4, Ab4,
    A5, Bb5, B5, C5, Db5, D5, Eb5, E5, F5, Gb5, G5, Ab5,
    A6, Bb6, B6, C6, Db6, D6, Eb6, E6, F6, Gb6, G6, Ab6,
    A7, Bb7, B7, C7, Db7, D7, Eb7, E7, F7, Gb7, G7, Ab7,
    A8, Bb8, B8, C8;

    /** Number of octaves for A through C. */
    static final int NUM_OCTAVES_A_THROUGH_C = 8;
    /** Number of octaves for Db through Ab. */
    static final int NUM_OCTAVES_ABOVE_C = 7;
    /** Number of notes in a scale. */
    static final int NUM_SCALE_NOTES = 12;

    /** Middle C. */
    static final Key MIDDLE_C = C4;

    /** Return my note as a single- or double-character abbreviation, depending
     *  on the note. */
    String note() {
        String name = name();
        return name.substring(0, name.length() - 1);
    }

    /** Return my octave as an integer from 1 (lowest) to 8 (highest). */
    String octave() {
        String name = name();
        return name.substring(name.length() - 1);
    }

    /** Return one octave down from my octave as an integer. If there is no valid
     *  octave, return null. */
    String octaveDown() {
        int currOctave = Integer.parseInt(octave());
        if (currOctave == 1) {
            return null;
        } else {
            return Integer.toString(currOctave - 1);
        }
    }

    /** Return one octave up from my octave as an integer. If there is no valid
     *  octave, return null. */
    String octaveUp() {
        String note = note();
        int currOctave = Integer.parseInt(octave());
        if (currOctave == NUM_OCTAVES_A_THROUGH_C) {
            return null;
        } else if (!(note.equals("A") || note.equals("Bb") || note.equals("B")
                   || note.equals("C")) && currOctave == NUM_OCTAVES_ABOVE_C) {
            return null;
        } else {
            return Integer.toString(currOctave + 1);
        }
    }
}
