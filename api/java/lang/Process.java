package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Process {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:47.423 -0400", hash_original_method = "F1A8A517686D0631650544C6E6120854", hash_generated_method = "F1A8A517686D0631650544C6E6120854")
    public Process ()
    {
        //Synthesized constructor
    }

    /**
     * Terminates this process and closes any associated streams.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.950 -0500", hash_original_method = "73111F72F4AB0474EB2CFBD7E4AF4E1A", hash_generated_method = "FF0E335625027EFCFF9FC16BC675F34B")
    
public abstract void destroy();

    /**
     * Returns the exit value of the native process represented by this object.
     * It is available only when the native process has terminated.
     *
     * @return the exit value of this process.
     * @throws IllegalThreadStateException
     *             if this process has not terminated.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.953 -0500", hash_original_method = "1EAA7B24F2B50944782A0CE60B3B8E75", hash_generated_method = "647CE9E2E70D98F5A5572B4451C53331")
    
public abstract int exitValue();

    /**
     * Returns an input stream that is connected to the error stream
     * <em>(stderr)</em> of the native process represented by this object.
     *
     * @return the input stream to read from the error stream associated with
     *         the native process.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.955 -0500", hash_original_method = "FB318E2B3F5B4555B4080C28AE106FDF", hash_generated_method = "DFAA796C158DC4EA4430C868D9AB59F0")
    
public abstract InputStream getErrorStream();

    /**
     * Returns an input stream that is connected to the standard output stream
     * <em>(stdout)</em> of the native process represented by this object.
     *
     * @return the input stream to read from the output stream associated with
     *         the native process.
     */
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.958 -0500", hash_original_method = "422D86606304C3F8D9976A0E2284F13F", hash_generated_method = "556020BF6265A6C5614B1CFEE9E2FBA9")
    
public abstract InputStream getInputStream();

    /**
     * Returns an output stream that is connected to the standard input stream
     * <em>(stdin)</em> of the native process represented by this object.
     *
     * @return the output stream to write to the input stream associated with
     *         the native process.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.960 -0500", hash_original_method = "4331060E74BEB71DFC1779059CAED65C", hash_generated_method = "EB193755F22F39A086883299C85DF0E2")
    
public abstract OutputStream getOutputStream();

    /**
     * Causes the calling thread to wait for the native process associated with
     * this object to finish executing.
     *
     * @return the exit value of the native process being waited on.
     * @throws InterruptedException
     *             if the calling thread is interrupted.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:14.962 -0500", hash_original_method = "1FBBA10249C9A6533D34170DE8056745", hash_generated_method = "691F1C6425EB7CF64F1CD4B894D399D7")
    
public abstract int waitFor() throws InterruptedException;
    
}

