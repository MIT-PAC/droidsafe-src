package org.apache.commons.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineIterator implements Iterator<String> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.433 -0400", hash_original_field = "11148760BA02713964D5A15D6F5171FA", hash_generated_field = "E9FC4259DF64673646A1E5B909E48FC5")

    private BufferedReader bufferedReader;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.433 -0400", hash_original_field = "667BF3695F65E08AAEF8B2FFD1D2B74B", hash_generated_field = "74623D5E484C005F39CC5D482DEF445A")

    private String cachedLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.433 -0400", hash_original_field = "3027219904C350AD9F97C8EB57D62D3C", hash_generated_field = "4D53CDA6E6E10E780105913A3C199117")

    private boolean finished = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.434 -0400", hash_original_method = "2ECB3DE44318CC6265E9907690BC7DD5", hash_generated_method = "88FACDA0BC9CA391180AA506EDB2514C")
    public  LineIterator(final Reader reader) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Reader must not be null");
        } //End block
        {
            bufferedReader = (BufferedReader) reader;
        } //End block
        {
            bufferedReader = new BufferedReader(reader);
        } //End block
        // ---------- Original Method ----------
        //if (reader == null) {
            //throw new IllegalArgumentException("Reader must not be null");
        //}
        //if (reader instanceof BufferedReader) {
            //bufferedReader = (BufferedReader) reader;
        //} else {
            //bufferedReader = new BufferedReader(reader);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.434 -0400", hash_original_method = "67C6321C4A560250E895F968089F5E07", hash_generated_method = "B9501D2CAA2EE41807C8DEA568DB6611")
    public boolean hasNext() {
        {
            try 
            {
                {
                    String line = bufferedReader.readLine();
                    {
                        finished = true;
                    } //End block
                    {
                        boolean varC992E840C9325E3D06A977EA0B1F4CE5_1429551536 = (isValidLine(line));
                        {
                            cachedLine = line;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            catch (IOException ioe)
            {
                close();
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(ioe);
            } //End block
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_798388599 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_798388599;
        // ---------- Original Method ----------
        //if (cachedLine != null) {
            //return true;
        //} else if (finished) {
            //return false;
        //} else {
            //try {
                //while (true) {
                    //String line = bufferedReader.readLine();
                    //if (line == null) {
                        //finished = true;
                        //return false;
                    //} else if (isValidLine(line)) {
                        //cachedLine = line;
                        //return true;
                    //}
                //}
            //} catch(IOException ioe) {
                //close();
                //throw new IllegalStateException(ioe);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.435 -0400", hash_original_method = "D521A7CE64679A779C6680051467F6C8", hash_generated_method = "62D5E2223EAD2CE88D1D8E3CD8EE0798")
    protected boolean isValidLine(String line) {
        addTaint(line.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_516442249 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_516442249;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.435 -0400", hash_original_method = "5E316A44D1D2B85B5A94898151BCE074", hash_generated_method = "13801A031B407512D845A9F181833E78")
    public String next() {
        String varB4EAC82CA7396A68D541C85D26508E83_871566426 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_871566426 = nextLine();
        varB4EAC82CA7396A68D541C85D26508E83_871566426.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_871566426;
        // ---------- Original Method ----------
        //return nextLine();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.436 -0400", hash_original_method = "34C5F6253FCD1E23723623334462E67F", hash_generated_method = "089F54B43D1EA2D056AFA05D6EE93060")
    public String nextLine() {
        String varB4EAC82CA7396A68D541C85D26508E83_1061571111 = null; //Variable for return #1
        {
            boolean var2CC10AB3C52DD03176ADB3A939341751_1094743259 = (!hasNext());
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException("No more lines");
            } //End block
        } //End collapsed parenthetic
        String currentLine = cachedLine;
        cachedLine = null;
        varB4EAC82CA7396A68D541C85D26508E83_1061571111 = currentLine;
        varB4EAC82CA7396A68D541C85D26508E83_1061571111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1061571111;
        // ---------- Original Method ----------
        //if (!hasNext()) {
            //throw new NoSuchElementException("No more lines");
        //}
        //String currentLine = cachedLine;
        //cachedLine = null;
        //return currentLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.436 -0400", hash_original_method = "D603D6A8B937767723C974F30C64091E", hash_generated_method = "7E68A5F34F4B01DBAF690434ACC86387")
    public void close() {
        finished = true;
        IOUtils.closeQuietly(bufferedReader);
        cachedLine = null;
        // ---------- Original Method ----------
        //finished = true;
        //IOUtils.closeQuietly(bufferedReader);
        //cachedLine = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:31.437 -0400", hash_original_method = "AC01E9FFBEF40935A0A093C32EF1F4B2", hash_generated_method = "793F400B9FA36D4F5795E6A6031659CF")
    public void remove() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Remove unsupported on LineIterator");
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Remove unsupported on LineIterator");
    }

    
    public static void closeQuietly(LineIterator iterator) {
        if (iterator != null) {
            iterator.close();
        }
    }

    
}

