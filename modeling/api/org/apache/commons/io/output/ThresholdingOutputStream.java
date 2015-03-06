/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * An output stream which triggers an event when a specified number of bytes of
 * data have been written to it. The event can be used, for example, to throw
 * an exception if a maximum has been reached, or to switch the underlying
 * stream type when the threshold is exceeded.
 * <p>
 * This class overrides all <code>OutputStream</code> methods. However, these
 * overrides ultimately call the corresponding methods in the underlying output
 * stream implementation.
 * <p>
 * NOTE: This implementation may trigger the event <em>before</em> the threshold
 * is actually reached, since it triggers when a pending write operation would
 * cause the threshold to be exceeded.
 *
 * @version $Id: ThresholdingOutputStream.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public abstract class ThresholdingOutputStream
    extends OutputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.804 -0400", hash_original_field = "B212DD967AF5750AEF1DDA2E6D14352F", hash_generated_field = "AA1C7D5F19989762847FF2B738612846")

    /**
     * The threshold at which the event will be triggered.
     */
    private  int threshold;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.804 -0400", hash_original_field = "8CB991C2D0A240C72F4A6CE2B1757B15", hash_generated_field = "C6743BCE3F1A0F9070591F7112B3B8ED")

    private long written;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.805 -0400", hash_original_field = "B20AF65B557B90C865AF74CBD0E4A409", hash_generated_field = "5E8665C6D9CAC8C9DDEA8BC1F29622E7")

    private boolean thresholdExceeded;

    // ----------------------------------------------------------- Constructors

    /**
     * Constructs an instance of this class which will trigger an event at the
     * specified threshold.
     *
     * @param threshold The number of bytes at which to trigger an event.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.806 -0400", hash_original_method = "77C2ECB5C285EF71184BF3F2AC3FDA1E", hash_generated_method = "65C3CED8DA391C5DF9403CB1D69EC7E2")
    
public ThresholdingOutputStream(int threshold)
    {
        this.threshold = threshold;
    }

    // --------------------------------------------------- OutputStream methods

    /**
     * Writes the specified byte to this output stream.
     *
     * @param b The byte to be written.
     *
     * @exception IOException if an error occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.806 -0400", hash_original_method = "A749941175ED4946E5E13C756C47A3BF", hash_generated_method = "1EAB21479D2DC67F93E2DB6C81109C12")
    
@Override
    public void write(int b) throws IOException
    {
        checkThreshold(1);
        getStream().write(b);
        written++;
    }

    /**
     * Writes <code>b.length</code> bytes from the specified byte array to this
     * output stream.
     *
     * @param b The array of bytes to be written.
     *
     * @exception IOException if an error occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.807 -0400", hash_original_method = "BDE8F5646F213B56F0E18C72C563121D", hash_generated_method = "F7D978458863BCF0A330E62C2E1F0BED")
    
@Override
    public void write(byte b[]) throws IOException
    {
        checkThreshold(b.length);
        getStream().write(b);
        written += b.length;
    }

    /**
     * Writes <code>len</code> bytes from the specified byte array starting at
     * offset <code>off</code> to this output stream.
     *
     * @param b   The byte array from which the data will be written.
     * @param off The start offset in the byte array.
     * @param len The number of bytes to write.
     *
     * @exception IOException if an error occurs.
     */
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.807 -0400", hash_original_method = "63B0905E0F7F5A890F09CED6998445D1", hash_generated_method = "F7476009FB88CC0D3EB7BCEF3585DC37")
    
@Override
    public void write(byte b[], int off, int len) throws IOException
    {
        checkThreshold(len);
        getStream().write(b, off, len);
        written += len;
    }

    /**
     * Flushes this output stream and forces any buffered output bytes to be
     * written out.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.808 -0400", hash_original_method = "7DA4C958A096834DFED555D27E028982", hash_generated_method = "FA6941C953BD1823B8C61ADAEEEA050E")
    
@Override
    public void flush() throws IOException
    {
        getStream().flush();
    }

    /**
     * Closes this output stream and releases any system resources associated
     * with this stream.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.808 -0400", hash_original_method = "D4B771243EF7B4BDA5F26E7A828E3C67", hash_generated_method = "370A89EED5A64731546DEF8BD1097C47")
    
@Override
    public void close() throws IOException
    {
        try
        {
            flush();
        }
        catch (IOException ignored)
        {
            // ignore
        }
        getStream().close();
    }

    // --------------------------------------------------------- Public methods

    /**
     * Returns the threshold, in bytes, at which an event will be triggered.
     *
     * @return The threshold point, in bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.809 -0400", hash_original_method = "D74160AE6FC7C2C8DE051989EE60B0B3", hash_generated_method = "01E48B87667CE843FABE386D9E7A07D3")
    
public int getThreshold()
    {
        return threshold;
    }

    /**
     * Returns the number of bytes that have been written to this output stream.
     *
     * @return The number of bytes written.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.810 -0400", hash_original_method = "406CBD57F94439414A20EAD4F95AFAE5", hash_generated_method = "B2F6021AB0147ADC9ADAC32297B4F264")
    
public long getByteCount()
    {
        return written;
    }

    /**
     * Determines whether or not the configured threshold has been exceeded for
     * this output stream.
     *
     * @return {@code true} if the threshold has been reached;
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.810 -0400", hash_original_method = "1EA9299850929B3D5FCE42AA4C38FE08", hash_generated_method = "7BACF9D7DB8D3EE4AC91EAC842CF0FA8")
    
public boolean isThresholdExceeded()
    {
        return written > threshold;
    }

    // ------------------------------------------------------ Protected methods

    /**
     * Checks to see if writing the specified number of bytes would cause the
     * configured threshold to be exceeded. If so, triggers an event to allow
     * a concrete implementation to take action on this.
     *
     * @param count The number of bytes about to be written to the underlying
     *              output stream.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.811 -0400", hash_original_method = "16D96BE3274D83A99EFD52BEDEDB0485", hash_generated_method = "CD90E839FCB0BADE3ED09030DB5ED8BB")
    
protected void checkThreshold(int count) throws IOException
    {
        if (!thresholdExceeded && written + count > threshold)
        {
            thresholdExceeded = true;
            thresholdReached();
        }
    }

    /**
     * Resets the byteCount to zero.  You can call this from 
     * {@link #thresholdReached()} if you want the event to be triggered again. 
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.811 -0400", hash_original_method = "30120E8670CD410900DBC3B4D1B240BE", hash_generated_method = "192B869C929210B0CABDD5B135221BF3")
    
protected void resetByteCount() 
    {
        this.thresholdExceeded = false;
        this.written = 0;
    }

    // ------------------------------------------------------- Abstract methods

    /**
     * Returns the underlying output stream, to which the corresponding
     * <code>OutputStream</code> methods in this class will ultimately delegate.
     *
     * @return The underlying output stream.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.812 -0400", hash_original_method = "1258B7401FFA9985EC84EF3503294AC3", hash_generated_method = "D0E9A4B6C860A23274BE26AC4DFCD022")
    
protected abstract OutputStream getStream() throws IOException;

    /**
     * Indicates that the configured threshold has been reached, and that a
     * subclass should take whatever action necessary on this event. This may
     * include changing the underlying output stream.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.812 -0400", hash_original_method = "B6A927CF971A77DB4F648C6E61D31E35", hash_generated_method = "541193D2150FC932731022C0C19BE96B")
    
protected abstract void thresholdReached() throws IOException;
}
