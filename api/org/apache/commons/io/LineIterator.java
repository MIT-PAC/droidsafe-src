/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An Iterator over the lines in a <code>Reader</code>.
 * <p>
 * <code>LineIterator</code> holds a reference to an open <code>Reader</code>.
 * When you have finished with the iterator you should close the reader
 * to free internal resources. This can be done by closing the reader directly,
 * or by calling the {@link #close()} or {@link #closeQuietly(LineIterator)}
 * method on the iterator.
 * <p>
 * The recommended usage pattern is:
 * <pre>
 * LineIterator it = FileUtils.lineIterator(file, "UTF-8");
 * try {
 *   while (it.hasNext()) {
 *     String line = it.nextLine();
 *     // do something with line
 *   }
 * } finally {
 *   it.close();
 * }
 * </pre>
 *
 * @version $Id: LineIterator.java 1307461 2012-03-30 15:12:29Z ggregory $
 * @since 1.2
 */
public class LineIterator implements Iterator<String> {

    //-----------------------------------------------------------------------
    /**
     * Closes the iterator, handling null and ignoring exceptions.
     *
     * @param iterator  the iterator to close
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.474 -0400", hash_original_method = "3830DED98B2371780319D090EC33ABF7", hash_generated_method = "A5592C17224B2A723B157A5517F8473C")
    
public static void closeQuietly(LineIterator iterator) {
        if (iterator != null) {
            iterator.close();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.469 -0400", hash_original_field = "1569BA07ED3ADCB5C5B305753BE84005", hash_generated_field = "FD4BBFE83DB910675F421AFA4B796587")

    
    /** The reader that is being read. */
    private  BufferedReader bufferedReader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.470 -0400", hash_original_field = "876D86AF2632CD3A0B5613CC695C321A", hash_generated_field = "74623D5E484C005F39CC5D482DEF445A")

    private String cachedLine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.470 -0400", hash_original_field = "DD0C9E190E08FB73AB2E62C3F0D39A52", hash_generated_field = "4D53CDA6E6E10E780105913A3C199117")

    private boolean finished = false;

    /**
     * Constructs an iterator of the lines for a <code>Reader</code>.
     *
     * @param reader the <code>Reader</code> to read from, not null
     * @throws IllegalArgumentException if the reader is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.471 -0400", hash_original_method = "2ECB3DE44318CC6265E9907690BC7DD5", hash_generated_method = "D675EC37FA9255991C252D8C324462E8")
    
public LineIterator(final Reader reader) throws IllegalArgumentException {
        if (reader == null) {
            throw new IllegalArgumentException("Reader must not be null");
        }
        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Indicates whether the <code>Reader</code> has more lines.
     * If there is an <code>IOException</code> then {@link #close()} will
     * be called on this instance.
     *
     * @return {@code true} if the Reader has more lines
     * @throws IllegalStateException if an IO exception occurs
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.471 -0400", hash_original_method = "67C6321C4A560250E895F968089F5E07", hash_generated_method = "E8F71E97A7E43855D813D390E6EEDA2B")
    
public boolean hasNext() {
        if (cachedLine != null) {
            return true;
        } else if (finished) {
            return false;
        } else {
            try {
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        finished = true;
                        return false;
                    } else if (isValidLine(line)) {
                        cachedLine = line;
                        return true;
                    }
                }
            } catch(IOException ioe) {
                close();
                throw new IllegalStateException(ioe);
            }
        }
    }

    /**
     * Overridable method to validate each line that is returned.
     * This implementation always returns true.
     * @param line  the line that is to be validated
     * @return true if valid, false to remove from the iterator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.472 -0400", hash_original_method = "D521A7CE64679A779C6680051467F6C8", hash_generated_method = "50F30F812F18CCF52365DD659E124B74")
    
protected boolean isValidLine(String line) {
        return true;
    }

    /**
     * Returns the next line in the wrapped <code>Reader</code>.
     *
     * @return the next line from the input
     * @throws NoSuchElementException if there is no line to return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.472 -0400", hash_original_method = "5E316A44D1D2B85B5A94898151BCE074", hash_generated_method = "D7EA21AECB525C7025CA280400CBE298")
    
public String next() {
        return nextLine();
    }

    /**
     * Returns the next line in the wrapped <code>Reader</code>.
     *
     * @return the next line from the input
     * @throws NoSuchElementException if there is no line to return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.473 -0400", hash_original_method = "34C5F6253FCD1E23723623334462E67F", hash_generated_method = "0BEA4FA5CF6B6D343C3C9851467F6E9B")
    
public String nextLine() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more lines");
        }
        String currentLine = cachedLine;
        cachedLine = null;
        return currentLine;        
    }

    /**
     * Closes the underlying <code>Reader</code> quietly.
     * This method is useful if you only want to process the first few
     * lines of a larger file. If you do not close the iterator
     * then the <code>Reader</code> remains open.
     * This method can safely be called multiple times.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.473 -0400", hash_original_method = "D603D6A8B937767723C974F30C64091E", hash_generated_method = "6748068435EBC03C7FF026C219C94338")
    
public void close() {
        finished = true;
        IOUtils.closeQuietly(bufferedReader);
        cachedLine = null;
    }

    /**
     * Unsupported.
     *
     * @throws UnsupportedOperationException always
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.474 -0400", hash_original_method = "AC01E9FFBEF40935A0A093C32EF1F4B2", hash_generated_method = "780CB83F9E67492FDA3EE32565AD09C5")
    
public void remove() {
        throw new UnsupportedOperationException("Remove unsupported on LineIterator");
    }

}
