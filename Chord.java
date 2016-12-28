package PocketComposer;

import java.util.ArrayList;
import java.util.Arrays;

/** Represents a collection of keys.
 *  @author Annie Tsai
 */
class Chord {

    /** A new Chord that initially contains KEYS. */
    Chord(Key... keys) {
        _keys = new ArrayList<>(Arrays.asList(keys));
    }

    /** A new, empty Chord. */
    Chord() {
        _keys = new ArrayList<>();
    }

    /** Add KEY to the top of me. */
    void addToTop(Key key) {
        if (key != null) {
            _keys.add(key);
        }
    }

    /** Add KEY to the bottom of me. */
    void addToBottom(Key key) {
        if (key != null) {
            _keys.add(0, key);
        }
    }

    /** Remove the key at the top of me. */
    void removeTop() {
        if (!isEmpty()) {
            _keys.remove(size() - 1);
        }
    }

    /** Remove the key at the bottom of me. */
    void removeBottom() {
        if (!isEmpty()) {
            _keys.remove(0);
        }
    }

    /** Return my top key, or null if I am empty. */
    Key top() {
        if (isEmpty()) {
            return null;
        } else {
            return get(0);
        }
    }

    /** Return my bottom key, or null if I am empty. */
    Key bottom() {
        if (isEmpty()) {
            return null;
        } else {
            return get(size() - 1);
        }
    }

    /** Return my Kth from top key (0 <= K < size()). Causes
     *  IllegalArgumentException if K is out of range. */
    Key get(int k) {
        try {
            return _keys.get(size() - 1 - k);
        } catch (IndexOutOfBoundsException excp) {
            return null;
        }
    }

    /** Returns my current number of keys. */
    int size() {
        return _keys.size();
    }

    /** Return true iff I am empty. */
    boolean isEmpty() {
        return _keys.isEmpty();
    }

    /** Takes the top key of this chord and inverts it an octave downwards. If
     *  the top key cannot be inverted downwards, prints an error message and
     *  leaves the chord as is. */
    void invertDown() {
        Key top = top();
        String octaveDown = top.octaveDown();
        if (top == null || octaveDown == null) {
            System.out.println("Invalid inversion.");
        } else {
            String newNote = top.note() + octaveDown;
            Key newKey = Key.valueOf(newNote);
            removeTop();
            addToBottom(newKey);
        }
    }

    /** Takes the bottom key of this chord and inverts it an octave upwards. If
     *  the bottom key cannot be inverted upwards, prints an error message and
     *  leaves the chord as is. */
    void invertUp() {
        Key bottom = bottom();
        String octaveUp = bottom.octaveUp();
        if (bottom == null || octaveUp == null) {
            System.out.println("Invalid inversion.");
        } else {
            String newNote = bottom.note() + octaveUp;
            Key newKey = Key.valueOf(newNote);
            removeBottom();
            addToTop(newKey);
        }
    }

    /** The keys in this chord. The top key is last. */
    private final ArrayList<Key> _keys;
}