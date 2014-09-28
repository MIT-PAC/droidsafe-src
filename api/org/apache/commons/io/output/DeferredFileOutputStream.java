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
package org.apache.commons.io.output;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

/**
 * An output stream which will retain data in memory until a specified
 * threshold is reached, and only then commit it to disk. If the stream is
 * closed before the threshold is reached, the data will not be written to
 * disk at all.
 * <p>
 * This class originated in FileUpload processing. In this use case, you do
 * not know in advance the size of the file being uploaded. If the file is small
 * you want to store it in memory (for speed), but if the file is large you want
 * to store it to file (to avoid memory issues).
 *
 * @version $Id: DeferredFileOutputStream.java 1307462 2012-03-30 15:13:11Z ggregory $
 */
public class DeferredFileOutputStream
    extends ThresholdingOutputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.093 -0400", hash_original_field = "EA0D38896AA5736EE728D81536C1574B", hash_generated_field = "B6D69B2A8FDF5F6E6AA5F5500BE8FBBD")

    /**
     * The output stream to which data will be written prior to the theshold
     * being reached.
     */
    private ByteArrayOutputStream memoryOutputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.093 -0400", hash_original_field = "83619CF75734A822121A135F620BEBD2", hash_generated_field = "95C2638CFCA277D66AF64A0C84E5EFAA")

    private OutputStream currentOutputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.094 -0400", hash_original_field = "8D4CC0E7BA99A8832275E070A961265D", hash_generated_field = "13DF2A79D46A052511C9FF993E8FED07")

    private File outputFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.095 -0400", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "F717D382565968ED95842821FAEC62F9")

    private  String prefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.095 -0400", hash_original_field = "352ABBD93A6DB7B3DEC72F9E1AF43FA3", hash_generated_field = "4D4C553D5B0C0462F41497F0C740F576")

    private  String suffix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.096 -0400", hash_original_field = "FAF68CC60E35257A66D284E0CBAD8965", hash_generated_field = "8B0860249151DE823C54467CC9BADB3F")

    private  File directory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.096 -0400", hash_original_field = "3AA5C7F0C9D40E3C1B48B8404423A098", hash_generated_field = "AA98B16E301073717D23E903C6D6286D")

    private boolean closed = false;

    // ----------------------------------------------------------- Constructors

    /**
     * Constructs an instance of this class which will trigger an event at the
     * specified threshold, and save data to a file beyond that point.
     *
     * @param threshold  The number of bytes at which to trigger an event.
     * @param outputFile The file to which data is saved beyond the threshold.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.097 -0400", hash_original_method = "12A02A287ADE8B8C967BB9DD34A9FF2E", hash_generated_method = "C71A0F98834D59EAB17314599B7E441B")
    
public DeferredFileOutputStream(int threshold, File outputFile)
    {
        this(threshold,  outputFile, null, null, null);
    }

    /**
     * Constructs an instance of this class which will trigger an event at the
     * specified threshold, and save data to a temporary file beyond that point.
     *
     * @param threshold  The number of bytes at which to trigger an event.
     * @param prefix Prefix to use for the temporary file.
     * @param suffix Suffix to use for the temporary file.
     * @param directory Temporary file directory.
     *
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.097 -0400", hash_original_method = "7C105C969E0E98618A848E2BA2427DC3", hash_generated_method = "21CF5C571DC55CCD93ED40ADA6FCCAD5")
    
public DeferredFileOutputStream(int threshold, String prefix, String suffix, File directory)
    {
        this(threshold, null, prefix, suffix, directory);
        if (prefix == null) {
            throw new IllegalArgumentException("Temporary file prefix is missing");
        }
    }

    /**
     * Constructs an instance of this class which will trigger an event at the
     * specified threshold, and save data either to a file beyond that point.
     * 
     * @param threshold  The number of bytes at which to trigger an event.
     * @param outputFile The file to which data is saved beyond the threshold.
     * @param prefix Prefix to use for the temporary file.
     * @param suffix Suffix to use for the temporary file.
     * @param directory Temporary file directory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.098 -0400", hash_original_method = "48C97AA3045E7A9B2226A2F0245D0AFE", hash_generated_method = "3B6F987AE93FE3888F8771127EE2B773")
    
private DeferredFileOutputStream(int threshold, File outputFile, String prefix, String suffix, File directory) {
        super(threshold);
        this.outputFile = outputFile;

        memoryOutputStream = new ByteArrayOutputStream();
        currentOutputStream = memoryOutputStream;
        this.prefix = prefix;
        this.suffix = suffix;
        this.directory = directory;
    }

    // --------------------------------------- ThresholdingOutputStream methods

    /**
     * Returns the current output stream. This may be memory based or disk
     * based, depending on the current state with respect to the threshold.
     *
     * @return The underlying output stream.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.098 -0400", hash_original_method = "F995E868509776850AFF6498E755EFC4", hash_generated_method = "D4CA15ED89B95EC7FC8D484D064F3925")
    
@Override
    protected OutputStream getStream() throws IOException
    {
        return currentOutputStream;
    }

    /**
     * Switches the underlying output stream from a memory based stream to one
     * that is backed by disk. This is the point at which we realise that too
     * much data is being written to keep in memory, so we elect to switch to
     * disk-based storage.
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.099 -0400", hash_original_method = "90F9D8BE12A4409DA41E0CA93662D129", hash_generated_method = "4E7ABC686CA9C6B8AC9AD36A794F05FD")
    
@Override
    protected void thresholdReached() throws IOException
    {
        if (prefix != null) {
            outputFile = File.createTempFile(prefix, suffix, directory);
        }
        FileOutputStream fos = new FileOutputStream(outputFile);
        memoryOutputStream.writeTo(fos);
        currentOutputStream = fos;
        memoryOutputStream = null;
    }

    // --------------------------------------------------------- Public methods

    /**
     * Determines whether or not the data for this output stream has been
     * retained in memory.
     *
     * @return {@code true} if the data is available in memory;
     *         {@code false} otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.100 -0400", hash_original_method = "02F113772DEC1618BE4A7F2BC7B846DE", hash_generated_method = "5B772556B53A8F8B9942E093E8A9593E")
    
public boolean isInMemory()
    {
        return !isThresholdExceeded();
    }

    /**
     * Returns the data for this output stream as an array of bytes, assuming
     * that the data has been retained in memory. If the data was written to
     * disk, this method returns {@code null}.
     *
     * @return The data for this output stream, or {@code null} if no such
     *         data is available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.100 -0400", hash_original_method = "CEBBD6265454356FCC4FE657D9359767", hash_generated_method = "69618D494BC4F8C6943FE1E87349F378")
    
public byte[] getData()
    {
        if (memoryOutputStream != null)
        {
            return memoryOutputStream.toByteArray();
        }
        return null;
    }

    /**
     * Returns either the output file specified in the constructor or
     * the temporary file created or null.
     * <p>
     * If the constructor specifying the file is used then it returns that
     * same output file, even when threshold has not been reached.
     * <p>
     * If constructor specifying a temporary file prefix/suffix is used
     * then the temporary file created once the threshold is reached is returned
     * If the threshold was not reached then {@code null} is returned.
     *
     * @return The file for this output stream, or {@code null} if no such
     *         file exists.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.100 -0400", hash_original_method = "2FAEE05DD81B3DF9BBBB7355A430983C", hash_generated_method = "378C316E260238E1BC0C6921CA732FF6")
    
public File getFile()
    {
        return outputFile;
    }
        
    /**
     * Closes underlying output stream, and mark this as closed
     *
     * @exception IOException if an error occurs.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.101 -0400", hash_original_method = "C7FCBD344022D72FF18766A4DFEA8EE1", hash_generated_method = "7035C7CC0EC06D72F1A3D6EF6B3FE4EA")
    
@Override
    public void close() throws IOException
    {
        super.close();
        closed = true;
    }
    
    /**
     * Writes the data from this output stream to the specified output stream,
     * after it has been closed.
     *
     * @param out output stream to write to.
     * @exception IOException if this stream is not yet closed or an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.102 -0400", hash_original_method = "EDA7487DCECD411B0E9FBCE942C20A22", hash_generated_method = "9F1E443C899E55485C185E755AF35886")
    
public void writeTo(OutputStream out) throws IOException 
    {
        // we may only need to check if this is closed if we are working with a file
        // but we should force the habit of closing wether we are working with
        // a file or memory.
        if (!closed)
        {
            throw new IOException("Stream not closed");
        }
        
        if(isInMemory())
        {
            memoryOutputStream.writeTo(out);
        }
        else
        {
            FileInputStream fis = new FileInputStream(outputFile);
            try {
                IOUtils.copy(fis, out);
            } finally {
                IOUtils.closeQuietly(fis);
            }
        }
    }
}
