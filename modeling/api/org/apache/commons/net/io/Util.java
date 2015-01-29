/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/***
 * The Util class cannot be instantiated and stores short static convenience
 * methods that are often quite useful.
 * <p>
 * <p>
 * @see CopyStreamException
 * @see CopyStreamListener
 * @see CopyStreamAdapter
 * @author Daniel F. Savarese
 ***/

public final class Util
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.811 -0500", hash_original_field = "EBFBB0CAD382EF05A4B21077872ECDF9", hash_generated_field = "7DF01242C67E4B5BBB6B01009C93226E")

    public static final int DEFAULT_COPY_BUFFER_SIZE = 1024;

    /***
     * Copies the contents of an InputStream to an OutputStream using a
     * copy buffer of a given size and notifies the provided
     * CopyStreamListener of the progress of the copy operation by calling
     * its bytesTransferred(long, int) method after each write to the
     * destination.  If you wish to notify more than one listener you should
     * use a CopyStreamAdapter as the listener and register the additional
     * listeners with the CopyStreamAdapter.
     * <p>
     * The contents of the InputStream are
     * read until the end of the stream is reached, but neither the
     * source nor the destination are closed.  You must do this yourself
     * outside of the method call.  The number of bytes read/written is
     * returned.
     * <p>
     * @param source  The source InputStream.
     * @param dest    The destination OutputStream.
     * @param bufferSize  The number of bytes to buffer during the copy.
     * @param streamSize  The number of bytes in the stream being copied.
     *          Should be set to CopyStreamEvent.UNKNOWN_STREAM_SIZE if unknown.
     * @param listener  The CopyStreamListener to notify of progress.  If
     *      this parameter is null, notification is not attempted.
     * @param flush Whether to flush the output stream after every
     *        write.  This is necessary for interactive sessions that rely on
     *        buffered streams.  If you don't flush, the data will stay in
     *        the stream buffer.
     * @exception CopyStreamException  If an error occurs while reading from the
     *            source or writing to the destination.  The CopyStreamException
     *            will contain the number of bytes confirmed to have been
     *            transferred before an
     *            IOException occurred, and it will also contain the IOException
     *            that caused the error.  These values can be retrieved with
     *            the CopyStreamException getTotalBytesTransferred() and
     *            getIOException() methods.
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.818 -0500", hash_original_method = "988C8C1A9C87B41B84F5CBCE16DA1DA1", hash_generated_method = "B0ACB468F4096B1507B0A8AC1B39636A")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static final long copyStream(InputStream source, OutputStream dest,
                                        int bufferSize, long streamSize,
                                        CopyStreamListener listener,
                                        boolean flush)
    throws CopyStreamException
    {
        int bytes;
        long total;
        byte[] buffer;

        buffer = new byte[bufferSize];
        total = 0;

        try
        {
            while ((bytes = source.read(buffer)) != -1)
            {
                // Technically, some read(byte[]) methods may return 0 and we cannot
                // accept that as an indication of EOF.

                if (bytes == 0)
                {
                    bytes = source.read();
                    if (bytes < 0)
                        break;
                    dest.write(bytes);
                    if(flush)
                      dest.flush();
                    ++total;
                    if (listener != null)
                        listener.bytesTransferred(total, 1, streamSize);
                    continue;
                }

                dest.write(buffer, 0, bytes);
                if(flush)
                  dest.flush();
                total += bytes;
                if (listener != null)
                    listener.bytesTransferred(total, bytes, streamSize);
            }
        }
        catch (IOException e)
        {
            throw new CopyStreamException("IOException caught while copying.",
                                          total, e);
        }

        return total;
    }

    /***
     * Copies the contents of an InputStream to an OutputStream using a
     * copy buffer of a given size and notifies the provided
     * CopyStreamListener of the progress of the copy operation by calling
     * its bytesTransferred(long, int) method after each write to the
     * destination.  If you wish to notify more than one listener you should
     * use a CopyStreamAdapter as the listener and register the additional
     * listeners with the CopyStreamAdapter.
     * <p>
     * The contents of the InputStream are
     * read until the end of the stream is reached, but neither the
     * source nor the destination are closed.  You must do this yourself
     * outside of the method call.  The number of bytes read/written is
     * returned.
     * <p>
     * @param source  The source InputStream.
     * @param dest    The destination OutputStream.
     * @param bufferSize  The number of bytes to buffer during the copy.
     * @param streamSize  The number of bytes in the stream being copied.
     *          Should be set to CopyStreamEvent.UNKNOWN_STREAM_SIZE if unknown.
     * @param listener  The CopyStreamListener to notify of progress.  If
     *      this parameter is null, notification is not attempted.
     * @exception CopyStreamException  If an error occurs while reading from the
     *            source or writing to the destination.  The CopyStreamException
     *            will contain the number of bytes confirmed to have been
     *            transferred before an
     *            IOException occurred, and it will also contain the IOException
     *            that caused the error.  These values can be retrieved with
     *            the CopyStreamException getTotalBytesTransferred() and
     *            getIOException() methods.
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.822 -0500", hash_original_method = "59F041575984EC96DFD0048B067EB3F8", hash_generated_method = "67DB68E6109BDF76F718C4F5354A00B6")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static final long copyStream(InputStream source, OutputStream dest,
                                        int bufferSize, long streamSize,
                                        CopyStreamListener listener)
    throws CopyStreamException
    {
      return copyStream(source, dest, bufferSize, streamSize, listener,
                        true);
    }

    /***
     * Copies the contents of an InputStream to an OutputStream using a
     * copy buffer of a given size.  The contents of the InputStream are
     * read until the end of the stream is reached, but neither the
     * source nor the destination are closed.  You must do this yourself
     * outside of the method call.  The number of bytes read/written is
     * returned.
     * <p>
     * @param source  The source InputStream.
     * @param dest    The destination OutputStream.
     * @return  The number of bytes read/written in the copy operation.
     * @exception CopyStreamException  If an error occurs while reading from the
     *            source or writing to the destination.  The CopyStreamException
     *            will contain the number of bytes confirmed to have been
     *            transferred before an
     *            IOException occurred, and it will also contain the IOException
     *            that caused the error.  These values can be retrieved with
     *            the CopyStreamException getTotalBytesTransferred() and
     *            getIOException() methods.
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.827 -0500", hash_original_method = "805E3D268EC2C624B76D676FF5B77E40", hash_generated_method = "E26FE89963A7CF23AB90370ADC8186C5")
    @DSVerified
    @DSSpec(DSCat.IO)
public static final long copyStream(InputStream source, OutputStream dest,
                                        int bufferSize)
    throws CopyStreamException
    {
        return copyStream(source, dest, bufferSize,
                          CopyStreamEvent.UNKNOWN_STREAM_SIZE, null);
    }

    /***
     * Same as <code> copyStream(source, dest, DEFAULT_COPY_BUFFER_SIZE); </code>
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.831 -0500", hash_original_method = "C323B602CD06AD973DC5FDF71A366294", hash_generated_method = "79746B066B86222CEF2617E74A625A3E")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static final long copyStream(InputStream source, OutputStream dest)
    throws CopyStreamException
    {
        return copyStream(source, dest, DEFAULT_COPY_BUFFER_SIZE);
    }

    /***
     * Copies the contents of a Reader to a Writer using a
     * copy buffer of a given size and notifies the provided
     * CopyStreamListener of the progress of the copy operation by calling
     * its bytesTransferred(long, int) method after each write to the
     * destination.  If you wish to notify more than one listener you should
     * use a CopyStreamAdapter as the listener and register the additional
     * listeners with the CopyStreamAdapter.
     * <p>
     * The contents of the Reader are
     * read until its end is reached, but neither the source nor the
     * destination are closed.  You must do this yourself outside of the
     * method call.  The number of characters read/written is returned.
     * <p>
     * @param source  The source Reader.
     * @param dest    The destination writer.
     * @param bufferSize  The number of characters to buffer during the copy.
     * @param streamSize  The number of characters in the stream being copied.
     *          Should be set to CopyStreamEvent.UNKNOWN_STREAM_SIZE if unknown.
     * @param listener  The CopyStreamListener to notify of progress.  If
     *      this parameter is null, notification is not attempted.
     * @return  The number of characters read/written in the copy operation.
     * @exception CopyStreamException  If an error occurs while reading from the
     *            source or writing to the destination.  The CopyStreamException
     *            will contain the number of bytes confirmed to have been
     *            transferred before an
     *            IOException occurred, and it will also contain the IOException
     *            that caused the error.  These values can be retrieved with
     *            the CopyStreamException getTotalBytesTransferred() and
     *            getIOException() methods.
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.835 -0500", hash_original_method = "E7B7C9450E823273368CE03BFFFC56F4", hash_generated_method = "7C00E07CBAAEA290928D5CD0E564AA90")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static final long copyReader(Reader source, Writer dest,
                                        int bufferSize, long streamSize,
                                        CopyStreamListener listener)
    throws CopyStreamException
    {
        int chars;
        long total;
        char[] buffer;

        buffer = new char[bufferSize];
        total = 0;

        try
        {
            while ((chars = source.read(buffer)) != -1)
            {
                // Technically, some read(char[]) methods may return 0 and we cannot
                // accept that as an indication of EOF.
                if (chars == 0)
                {
                    chars = source.read();
                    if (chars < 0)
                        break;
                    dest.write(chars);
                    dest.flush();
                    ++total;
                    if (listener != null)
                        listener.bytesTransferred(total, chars, streamSize);
                    continue;
                }

                dest.write(buffer, 0, chars);
                dest.flush();
                total += chars;
                if (listener != null)
                    listener.bytesTransferred(total, chars, streamSize);
            }
        }
        catch (IOException e)
        {
            throw new CopyStreamException("IOException caught while copying.",
                                          total, e);
        }

        return total;
    }

    /***
     * Copies the contents of a Reader to a Writer using a
     * copy buffer of a given size.  The contents of the Reader are
     * read until its end is reached, but neither the source nor the
     * destination are closed.  You must do this yourself outside of the
     * method call.  The number of characters read/written is returned.
     * <p>
     * @param source  The source Reader.
     * @param dest    The destination writer.
     * @param bufferSize  The number of characters to buffer during the copy.
     * @return  The number of characters read/written in the copy operation.
     * @exception CopyStreamException  If an error occurs while reading from the
     *            source or writing to the destination.  The CopyStreamException
     *            will contain the number of bytes confirmed to have been
     *            transferred before an
     *            IOException occurred, and it will also contain the IOException
     *            that caused the error.  These values can be retrieved with
     *            the CopyStreamException getTotalBytesTransferred() and
     *            getIOException() methods.
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.838 -0500", hash_original_method = "37E6395A53D2856A75AD4C3F97C011E2", hash_generated_method = "B3C18AA82E084366BF075DFC9488C49D")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static final long copyReader(Reader source, Writer dest,
                                        int bufferSize)
    throws CopyStreamException
    {
        return copyReader(source, dest, bufferSize,
                          CopyStreamEvent.UNKNOWN_STREAM_SIZE, null);
    }

    /***
     * Same as <code> copyReader(source, dest, DEFAULT_COPY_BUFFER_SIZE); </code>
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.842 -0500", hash_original_method = "9E0049FC39F955363C8AC470546DF985", hash_generated_method = "5E48864011F01A2EFAAC41F42D632A46")
    @DSVerified
    @DSSpec(DSCat.IO)
    
public static final long copyReader(Reader source, Writer dest)
    throws CopyStreamException
    {
        return copyReader(source, dest, DEFAULT_COPY_BUFFER_SIZE);
    }

    // Cannot be instantiated
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.814 -0500", hash_original_method = "3D931E11640E8C52E9034B5681D86ADB", hash_generated_method = "CB4C43C81CA4705B619CC3DA2D5FFAD7")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
    
private Util()
    { }

}
