package java.nio.channels.spi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.channels.SelectionKey;






public abstract class AbstractSelectionKey extends SelectionKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.225 -0500", hash_original_field = "FFFCC50D3A278EF95DEB022E99DE2B21", hash_generated_field = "FFFCC50D3A278EF95DEB022E99DE2B21")

    boolean isValid = true;

    /**
     * Constructs a new {@code AbstractSelectionKey}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.228 -0500", hash_original_method = "A659BC27757815EB634E5D963F0A56EB", hash_generated_method = "9B4E27A7807670D7CB0964E7593083F7")
    
protected AbstractSelectionKey() {
    }

    /**
     * Indicates whether this key is valid. A key is valid as long as it has not
     * been canceled.
     *
     * @return {@code true} if this key has not been canceled, {@code false}
     *         otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.232 -0500", hash_original_method = "1D07A2DB88FBC8505561F98CE95D4D40", hash_generated_method = "5CAB1804A992395EE26A5B382908E240")
    
@Override
    public final boolean isValid() {
        return isValid;
    }

    /**
     * Cancels this key.
     * <p>
     * A key that has been canceled is no longer valid. Calling this method on
     * an already canceled key does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:58.234 -0500", hash_original_method = "A279029257087CE11FC7A37CBDFB5215", hash_generated_method = "BBF29FCAD5F9A043B65C4DCCD2050B9A")
    
@Override
    public final void cancel() {
        if (isValid) {
            isValid = false;
            ((AbstractSelector) selector()).cancel(this);
        }
    }

    
}

