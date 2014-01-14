package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import libcore.util.EmptyArray;

public class Throwable implements java.io.Serializable {

    /**
     * Counts the number of duplicate stack frames, starting from the
     * end of the stack.
     *
     * @param currentStack a stack to compare
     * @param parentStack a stack to compare
     *
     * @return the number of duplicate stack frames.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.610 -0500", hash_original_method = "694D318D728E7460C6E6317B80FB1826", hash_generated_method = "89B3661221734219BB93880F76201C32")
    
private static int countDuplicates(StackTraceElement[] currentStack,
            StackTraceElement[] parentStack) {
        int duplicates = 0;
        int parentIndex = parentStack.length;
        for (int i = currentStack.length; --i >= 0 && --parentIndex >= 0;) {
            StackTraceElement parentFrame = parentStack[parentIndex];
            if (parentFrame.equals(currentStack[i])) {
                duplicates++;
            } else {
                break;
            }
        }
        return duplicates;
    }
    
    private static Object nativeFillInStackTrace() {
    	return new Object();
    }
    
    private static StackTraceElement[] nativeGetStackTrace(Object stackState) {
    	StackTraceElement[] ret = new StackTraceElement[0];
    	ret[0].addTaint(stackState.taint);
    	return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.567 -0500", hash_original_field = "03831E44B4BAB79115DDC1B6FBA097B6", hash_generated_field = "02CA67A79E3766B4E9DFDCEAEB0383C0")

    private static final long serialVersionUID = -3042686055658047285L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.569 -0500", hash_original_field = "637820AD7E88318FF7A86CC153394477", hash_generated_field = "5F933F283197F636E634092890034B15")

    private String detailMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.572 -0500", hash_original_field = "B4A04BF7E0D26A48EF6F6C0414C3F6FE", hash_generated_field = "6C1FA207B061A6741951FC650E75192F")

    private Throwable cause = this;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.574 -0500", hash_original_field = "12111AFEC1C12C586D2414996DDDCB07", hash_generated_field = "DE9A96CD1773A127DE8B75F7745CAF86")

    private List<Throwable> suppressedExceptions = new ArrayList<Throwable>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.576 -0500", hash_original_field = "29D6C384A26BFC93BEB43799CE532E88", hash_generated_field = "5F29D314996BC5D7FD0952BE7C7301C2")

    private volatile Object stackState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.578 -0500", hash_original_field = "838375D63C180940C2E3D85652A5D29D", hash_generated_field = "3998EFB68B1CCA38FEA7032A25D26EC5")

    private StackTraceElement[] stackTrace;

    /**
     * Constructs a new {@code Throwable} that includes the current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.581 -0500", hash_original_method = "8CAF8D74185B0F181EC07276079C4966", hash_generated_method = "3D2DB5F2D6311AEE1851EB3EE05A646E")
    
public Throwable() {
        fillInStackTrace();
    }

    /**
     * Constructs a new {@code Throwable} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage
     *            the detail message for this {@code Throwable}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.584 -0500", hash_original_method = "22D8176BCA749706DC2B313EF94A4BA5", hash_generated_method = "A682FF75B4A5FFA56A655C57B3F2F888")
    
public Throwable(String detailMessage) {
        this();
        this.detailMessage = detailMessage;
    }

    /**
     * Constructs a new {@code Throwable} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param detailMessage
     *            the detail message for this {@code Throwable}.
     * @param throwable
     *            the cause of this {@code Throwable}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.587 -0500", hash_original_method = "60881CAC7A5ED0481A49F5467094E82C", hash_generated_method = "924BC4E6059AF449701AC9CD7A5E3D6B")
    
public Throwable(String detailMessage, Throwable throwable) {
        this();
        this.detailMessage = detailMessage;
        cause = throwable;
    }

    /**
     * Constructs a new {@code Throwable} with the current stack trace and the
     * specified cause.
     *
     * @param throwable
     *            the cause of this {@code Throwable}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.590 -0500", hash_original_method = "1CFFD54DEC9660238586E7A30681A82F", hash_generated_method = "36DAF41407B4862DBCBB00D51B01FFF4")
    
public Throwable(Throwable throwable) {
        this();
        this.detailMessage = throwable == null ? null : throwable.toString();
        cause = throwable;
    }

    /**
     * Constructs a new {@code Throwable} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param enableSuppression if false, throwables passed to {@link
     *     #addSuppressed(Throwable)} will be silently discarded.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.593 -0500", hash_original_method = "E90AFC6F1FC322D1AB2CAA72835C3192", hash_generated_method = "0A9493132C6DF2DA1E6BF37222232B14")
    
protected Throwable(String detailMessage, Throwable throwable, boolean enableSuppression) {
        this(detailMessage, throwable);
        if (!enableSuppression) {
            this.suppressedExceptions = null;
        }
    }

    /**
     * Records the stack trace from the point where this method has been called
     * to this {@code Throwable}. This method is invoked by the {@code Throwable} constructors.
     *
     * <p>This method is public so that code (such as an RPC system) which catches
     * a {@code Throwable} and then re-throws it can replace the construction-time stack trace
     * with a stack trace from the location where the exception was re-thrown, by <i>calling</i>
     * {@code fillInStackTrace}.
     *
     * <p>This method is non-final so that non-Java language implementations can disable VM stack
     * traces for their language. Filling in the stack trace is relatively expensive.
     * <i>Overriding</i> this method in the root of a language's exception hierarchy allows the
     * language to avoid paying for something it doesn't need.
     *
     * @return this {@code Throwable} instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.595 -0500", hash_original_method = "1BF0D9E451222474F2DDB047C74BA127", hash_generated_method = "74F05E3F25AB2BF87F24FDC716350999")
    
public Throwable fillInStackTrace() {
        // Fill in the intermediate representation
        stackState = nativeFillInStackTrace();
        // Mark the full representation as empty
        stackTrace = null;
        return this;
    }

    /**
     * Returns the extra information message which was provided when this
     * {@code Throwable} was created. Returns {@code null} if no message was
     * provided at creation time.
     *
     * @return this {@code Throwable}'s detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.597 -0500", hash_original_method = "DB11282615D634E343F956A1D91DEDE9", hash_generated_method = "DFAFD5BFED23A5DC115EDF0B4FB19888")
    
public String getMessage() {
        return detailMessage;
    }

    /**
     * Returns the extra information message which was provided when this
     * {@code Throwable} was created. Returns {@code null} if no message was
     * provided at creation time. Subclasses may override this method to return
     * localized text for the message. Android returns the regular detail message.
     *
     * @return this {@code Throwable}'s localized detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.600 -0500", hash_original_method = "A2EE7B7852887DFBE3A27B61B4F72974", hash_generated_method = "9A2C4BFFE86AF7C1B43429C9DF39A332")
    
public String getLocalizedMessage() {
        return getMessage();
    }

    /**
     * Returns the array of stack trace elements of this {@code Throwable}. Each
     * {@code StackTraceElement} represents an entry in the call stack. The
     * element at position 0 is the top of the stack, that is, the stack frame
     * where this {@code Throwable} is thrown.
     *
     * @return a copy of the array of {@code StackTraceElement}s representing
     *         the call stack. Changes in the array obtained from this call will
     *         not change the call stack stored in this {@code Throwable}.
     * @see #printStackTrace()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.602 -0500", hash_original_method = "45FE0FF583AFF2392C672B8C003FC38F", hash_generated_method = "335BD883E150835B2792DDB4AA7898D9")
    
public StackTraceElement[] getStackTrace() {
        return getInternalStackTrace().clone();
    }

    /**
     * Sets the array of stack trace elements. Each {@code StackTraceElement}
     * represents an entry in the call stack. A copy of the specified array is
     * stored in this {@code Throwable}. will be returned by {@code
     * getStackTrace()} and printed by {@code printStackTrace()}.
     *
     * @param trace
     *            the new array of {@code StackTraceElement}s. A copy of the
     *            array is stored in this {@code Throwable}, so subsequent
     *            changes to {@code trace} will not change the call stack stored
     *            in this {@code Throwable}.
     * @throws NullPointerException
     *             if any element in {@code trace} is {@code null}.
     * @see #printStackTrace()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.604 -0500", hash_original_method = "5E6079B0EA3605E8298E1D15C30F6678", hash_generated_method = "4D79DCEB4761ABFCF09895C59AE81452")
    
public void setStackTrace(StackTraceElement[] trace) {
        StackTraceElement[] newTrace = trace.clone();
        for (StackTraceElement element : newTrace) {
            if (element == null) {
                throw new NullPointerException();
            }
        }
        stackTrace = newTrace;
    }

    /**
     * Writes a printable representation of this {@code Throwable}'s stack trace
     * to the {@code System.err} stream.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.607 -0500", hash_original_method = "325BA3C27FA0D6128256227B9178A07C", hash_generated_method = "1B603FFF15E34450E605F88022FEF2C8")
    
public void printStackTrace() {
        printStackTrace(System.err);
    }

    /**
     * Returns an array of StackTraceElement. Each StackTraceElement
     * represents a entry on the stack.
     *
     * @return an array of StackTraceElement representing the stack
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.612 -0500", hash_original_method = "5A8373E0D01D66F3E38F3485979BD426", hash_generated_method = "96B325E55D8EF6BA5DCC20AB99474C09")
    
private StackTraceElement[] getInternalStackTrace() {
        if (stackTrace == null) {
            stackTrace = nativeGetStackTrace(stackState);
            stackState = null; // Clean up intermediate representation
        }
        return stackTrace;
    }

    /**
     * Writes a printable representation of this {@code Throwable}'s stack trace
     * to the specified print stream. If the {@code Throwable} contains a
     * {@link #getCause() cause}, the method will be invoked recursively for
     * the nested {@code Throwable}.
     *
     * @param err
     *            the stream to write the stack trace on.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.615 -0500", hash_original_method = "721611E9E00924F0C591FE9FD87A98DF", hash_generated_method = "E081C99283B0C7FAF2830771267339F1")
    
public void printStackTrace(PrintStream err) {
        try {
            printStackTrace(err, "", null);
        } catch (IOException e) {
            // Appendable.append throws IOException but PrintStream.append doesn't.
            throw new AssertionError();
        }
    }

    /**
     * Writes a printable representation of this {@code Throwable}'s stack trace
     * to the specified print writer. If the {@code Throwable} contains a
     * {@link #getCause() cause}, the method will be invoked recursively for the
     * nested {@code Throwable}.
     *
     * @param err
     *            the writer to write the stack trace on.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.617 -0500", hash_original_method = "83BBC2719839E738869257F8A62E26AC", hash_generated_method = "A0F9157CE536E06503E642974016B844")
    
public void printStackTrace(PrintWriter err) {
        try {
            printStackTrace(err, "", null);
        } catch (IOException e) {
            // Appendable.append throws IOException, but PrintWriter.append doesn't.
            throw new AssertionError();
        }
    }

    /**
     * @param indent additional indentation on each line of the stack trace.
     *     This is the empty string for all but suppressed throwables.
     * @param parentStack the parent stack trace to suppress duplicates from, or
     *     null if this stack trace has no parent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.620 -0500", hash_original_method = "9161BE82060982591CF587E371FF5EC1", hash_generated_method = "E41462E11C26A6D1B3DA6F23FE79D53C")
    
private void printStackTrace(Appendable err, String indent, StackTraceElement[] parentStack)
            throws IOException {
        err.append(toString());
        err.append("\n");

        StackTraceElement[] stack = getInternalStackTrace();
        if (stack != null) {
            int duplicates = parentStack != null ? countDuplicates(stack, parentStack) : 0;
            for (int i = 0; i < stack.length - duplicates; i++) {
                err.append(indent);
                err.append("\tat ");
                err.append(stack[i].toString());
                err.append("\n");
            }

            if (duplicates > 0) {
                err.append(indent);
                err.append("\t... ");
                err.append(Integer.toString(duplicates));
                err.append(" more\n");
            }
        }

        // Print suppressed exceptions indented one level deeper.
        if (suppressedExceptions != null) {
            for (Throwable throwable : suppressedExceptions) {
                err.append(indent);
                err.append("\tSuppressed: ");
                throwable.printStackTrace(err, indent + "\t", stack);
            }
        }

        Throwable cause = getCause();
        if (cause != null) {
            err.append(indent);
            err.append("Caused by: ");
            cause.printStackTrace(err, indent, stack);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.623 -0500", hash_original_method = "D135C496474AE8F48C2BC1E13C422ADC", hash_generated_method = "21B9D9DBDDED3326A1D02C25EC759AFC")
    
@Override
    public String toString() {
        String msg = getLocalizedMessage();
        String name = getClass().getName();
        if (msg == null) {
            return name;
        }
        return name + ": " + msg;
    }

    /**
     * Initializes the cause of this {@code Throwable}. The cause can only be
     * initialized once.
     *
     * @param throwable
     *            the cause of this {@code Throwable}.
     * @return this {@code Throwable} instance.
     * @throws IllegalArgumentException
     *             if {@code Throwable} is this object.
     * @throws IllegalStateException
     *             if the cause has already been initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.625 -0500", hash_original_method = "C6146D344F8C29A6B259252212744901", hash_generated_method = "3E4C8DD68A3FC459DD8B2D55802FE9C2")
    
public Throwable initCause(Throwable throwable) {
        if (cause != this) {
            throw new IllegalStateException("Cause already initialized");
        }
        if (throwable == this) {
            throw new IllegalArgumentException("throwable == this");
        }
        cause = throwable;
        return this;
    }

    /**
     * Returns the cause of this {@code Throwable}, or {@code null} if there is
     * no cause.
     *
     * @return Throwable this {@code Throwable}'s cause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.628 -0500", hash_original_method = "22464C579A8BDBBA630699F5CFE21CE6", hash_generated_method = "EC6E1F32E2206A3C3ED13D06EC6500B3")
    
public Throwable getCause() {
        if (cause == this) {
            return null;
        }
        return cause;
    }

    /**
     * Adds {@code throwable} to the list of throwables suppressed by this. The
     * throwable will included when this exception's stack trace is printed.
     *
     * @throws IllegalArgumentException if {@code throwable == this}.
     * @throws NullPointerException if {@code throwable == null}.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.635 -0500", hash_original_method = "FE7E0A038916A44CD2EDEB98621E4496", hash_generated_method = "3F953B6DCC5D014D9BBB93AAF01028E7")
    
public final void addSuppressed(Throwable throwable) {
        if (throwable == this) {
            throw new IllegalArgumentException("suppressed == this");
        }
        if (throwable == null) {
            throw new NullPointerException("suppressed == null");
        }
        if (suppressedExceptions != null) {
            suppressedExceptions.add(throwable);
        }
    }

    /**
     * Returns the throwables suppressed by this.
     *
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.637 -0500", hash_original_method = "8B184B5B883F2271AE4A6DCD97FDDD74", hash_generated_method = "3FEE70597C3C89C502CEED679EDD4D15")
    
public final Throwable[] getSuppressed() {
        return (suppressedExceptions != null)
                ? suppressedExceptions.toArray(new Throwable[suppressedExceptions.size()])
                : EmptyArray.THROWABLE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.640 -0500", hash_original_method = "9B67B0A60488A3B6BF6B1F8E333B2B37", hash_generated_method = "EF567936BD808503CF3D5DFEB1398DFA")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        // ensure the stackTrace field is initialized
        getInternalStackTrace();
        out.defaultWriteObject();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.642 -0500", hash_original_method = "D9E2A8DEA9D5CE3A923EF2188BD1E0E9", hash_generated_method = "21D81ED8A3D00D34802B128905499369")
    
private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        if (suppressedExceptions != null) {
            // the deserialized list may be unmodifiable, so just create a mutable copy
            suppressedExceptions = new ArrayList<Throwable>(suppressedExceptions);
        }
    }
}

