package javax.xml.transform;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TransformerException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.391 -0500", hash_original_field = "5558AD85FB938A7671619C5EC4E7AF73", hash_generated_field = "FAB3AA9E21148B68815314C0C638BF27")

    private static final long serialVersionUID = 975798773772956428L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.393 -0500", hash_original_field = "242C14456A521485BE94EFFE33D8EF15", hash_generated_field = "242C14456A521485BE94EFFE33D8EF15")

    SourceLocator locator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.399 -0500", hash_original_field = "FB75E61C44B34E5DCDC79855DF4646BE", hash_generated_field = "FB75E61C44B34E5DCDC79855DF4646BE")

    Throwable containedException;

    /**
     * Create a new TransformerException.
     *
     * @param message The error or warning message.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.409 -0500", hash_original_method = "ABE089B555C0BBE77A7ADBD2839474AC", hash_generated_method = "000E1DE47EA28A846705866007F87BFF")
    
public TransformerException(String message) {

        super(message);

        this.containedException = null;
        this.locator            = null;
    }

    /**
     * Create a new TransformerException wrapping an existing exception.
     *
     * @param e The exception to be wrapped.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.411 -0500", hash_original_method = "BCE7B8322CC2320F24F40E1C57B1D6A6", hash_generated_method = "25936BC200236774CFBBA514A187D197")
    
public TransformerException(Throwable e) {

        super(e.toString());

        this.containedException = e;
        this.locator            = null;
    }

    /**
     * Wrap an existing exception in a TransformerException.
     *
     * <p>This is used for throwing processor exceptions before
     * the processing has started.</p>
     *
     * @param message The error or warning message, or null to
     *                use the message from the embedded exception.
     * @param e Any exception
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.414 -0500", hash_original_method = "D45FC511BA6A923B19FFB66FC049AAEB", hash_generated_method = "7756E00B3977CA5B64F45C943CD8A29B")
    
public TransformerException(String message, Throwable e) {

        super(((message == null) || (message.length() == 0))
              ? e.toString()
              : message);

        this.containedException = e;
        this.locator            = null;
    }

    /**
     * Create a new TransformerException from a message and a Locator.
     *
     * <p>This constructor is especially useful when an application is
     * creating its own exception from within a DocumentHandler
     * callback.</p>
     *
     * @param message The error or warning message.
     * @param locator The locator object for the error or warning.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.417 -0500", hash_original_method = "DD07B7FCC3EF7EDD2CCAD748CE266263", hash_generated_method = "D3FF44579D24C5873923A5AFF708148B")
    
public TransformerException(String message, SourceLocator locator) {

        super(message);

        this.containedException = null;
        this.locator            = locator;
    }

    /**
     * Wrap an existing exception in a TransformerException.
     *
     * @param message The error or warning message, or null to
     *                use the message from the embedded exception.
     * @param locator The locator object for the error or warning.
     * @param e Any exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.419 -0500", hash_original_method = "48CCF75E307E890A227C0CAEA85C6D48", hash_generated_method = "5F88073B7E65B6DD93BD31CCC3EEEE18")
    
public TransformerException(String message, SourceLocator locator,
                                Throwable e) {

        super(message);

        this.containedException = e;
        this.locator            = locator;
    }

    /**
     * Method getLocator retrieves an instance of a SourceLocator
     * object that specifies where an error occurred.
     *
     * @return A SourceLocator object, or null if none was specified.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.395 -0500", hash_original_method = "78CCEDF93B9D36FA2F4D6EE8483F521D", hash_generated_method = "78AB11BCEBBBC2FCF89A2993A49EDCA3")
    
public SourceLocator getLocator() {
        return locator;
    }

    /**
     * Method setLocator sets an instance of a SourceLocator
     * object that specifies where an error occurred.
     *
     * @param location A SourceLocator object, or null to clear the location.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.397 -0500", hash_original_method = "2730D26302DDFE02DFC9B94C57BA2229", hash_generated_method = "6AA84A78185C81C08D20A0C4FF7901E2")
    
public void setLocator(SourceLocator location) {
        locator = location;
    }

    /**
     * This method retrieves an exception that this exception wraps.
     *
     * @return An Throwable object, or null.
     * @see #getCause
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.401 -0500", hash_original_method = "4E3501B9804FC98D0826FF297E292112", hash_generated_method = "3623FABB5AADCB689C45E34A1151713A")
    
public Throwable getException() {
        return containedException;
    }

    /**
     * Returns the cause of this throwable or <code>null</code> if the
     * cause is nonexistent or unknown.  (The cause is the throwable that
     * caused this throwable to get thrown.)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.403 -0500", hash_original_method = "CFB99AF15EF81FE883309E381BCDFD32", hash_generated_method = "4B82F41B424CEBFFB7BCA3B411E82EA0")
    
public Throwable getCause() {

        return ((containedException == this)
                ? null
                : containedException);
    }

    /**
     * Initializes the <i>cause</i> of this throwable to the specified value.
     * (The cause is the throwable that caused this throwable to get thrown.)
     *
     * <p>This method can be called at most once.  It is generally called from
     * within the constructor, or immediately after creating the
     * throwable.  If this throwable was created
     * with {@link #TransformerException(Throwable)} or
     * {@link #TransformerException(String,Throwable)}, this method cannot be called
     * even once.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A <tt>null</tt> value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @return  a reference to this <code>Throwable</code> instance.
     * @throws IllegalArgumentException if <code>cause</code> is this
     *         throwable.  (A throwable cannot
     *         be its own cause.)
     * @throws IllegalStateException if this throwable was
     *         created with {@link #TransformerException(Throwable)} or
     *         {@link #TransformerException(String,Throwable)}, or this method has already
     *         been called on this throwable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.406 -0500", hash_original_method = "480EED18E1765067FE991AF0B4A8D2D9", hash_generated_method = "D92B47C8AABBD243B75CE59F6692A560")
    
public synchronized Throwable initCause(Throwable cause) {

        if (this.containedException != null) {
            throw new IllegalStateException("Can't overwrite cause");
        }

        if (cause == this) {
            throw new IllegalArgumentException(
                "Self-causation not permitted");
        }

        this.containedException = cause;

        return this;
    }

    /**
     * Get the error message with location information
     * appended.
     *
     * @return A <code>String</code> representing the error message with
     *         location information appended.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.422 -0500", hash_original_method = "5F0314D1FF4AABD6580ED0D63B1DE248", hash_generated_method = "B996CB1C53E16086C6E44E2C23AAE1CD")
    
public String getMessageAndLocation() {

        StringBuilder sbuffer = new StringBuilder();
        String       message = super.getMessage();

        if (null != message) {
            sbuffer.append(message);
        }

        if (null != locator) {
            String systemID = locator.getSystemId();
            int    line     = locator.getLineNumber();
            int    column   = locator.getColumnNumber();

            if (null != systemID) {
                sbuffer.append("; SystemID: ");
                sbuffer.append(systemID);
            }

            if (0 != line) {
                sbuffer.append("; Line#: ");
                sbuffer.append(line);
            }

            if (0 != column) {
                sbuffer.append("; Column#: ");
                sbuffer.append(column);
            }
        }

        return sbuffer.toString();
    }

    /**
     * Get the location information as a string.
     *
     * @return A string with location info, or null
     * if there is no location information.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.425 -0500", hash_original_method = "066E0A6F600039820661DC1AB443CC5D", hash_generated_method = "12C86AC3248C5D9F8218B885189BD02B")
    
public String getLocationAsString() {

        if (null != locator) {
            StringBuilder sbuffer  = new StringBuilder();
            String       systemID = locator.getSystemId();
            int          line     = locator.getLineNumber();
            int          column   = locator.getColumnNumber();

            if (null != systemID) {
                sbuffer.append("; SystemID: ");
                sbuffer.append(systemID);
            }

            if (0 != line) {
                sbuffer.append("; Line#: ");
                sbuffer.append(line);
            }

            if (0 != column) {
                sbuffer.append("; Column#: ");
                sbuffer.append(column);
            }

            return sbuffer.toString();
        } else {
            return null;
        }
    }

    /**
     * Print the the trace of methods from where the error
     * originated.  This will trace all nested exception
     * objects, as well as this object.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.427 -0500", hash_original_method = "BFEE5D773C8C1A637BA8549A5548CE5E", hash_generated_method = "E341FECD54C25953BA09A90E6F690069")
    
public void printStackTrace() {
        printStackTrace(new java.io.PrintWriter(System.err, true));
    }

    /**
     * Print the the trace of methods from where the error
     * originated.  This will trace all nested exception
     * objects, as well as this object.
     * @param s The stream where the dump will be sent to.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.429 -0500", hash_original_method = "396FE4FDBD72A1A44CDA1D64A960A2B6", hash_generated_method = "E7D49A0DBE7DE3D1C84124DB37885C80")
    
public void printStackTrace(java.io.PrintStream s) {
        printStackTrace(new java.io.PrintWriter(s));
    }

    /**
     * Print the the trace of methods from where the error
     * originated.  This will trace all nested exception
     * objects, as well as this object.
     * @param s The writer where the dump will be sent to.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:59.432 -0500", hash_original_method = "A67ED2D6F45381C31C2891A6F92AFBC4", hash_generated_method = "F57BCB0D6CB5F326A2C8616C413C919C")
    
public void printStackTrace(java.io.PrintWriter s) {

        if (s == null) {
            s = new java.io.PrintWriter(System.err, true);
        }

        try {
            String locInfo = getLocationAsString();

            if (null != locInfo) {
                s.println(locInfo);
            }

            super.printStackTrace(s);
        } catch (Throwable e) {}
    }
}

