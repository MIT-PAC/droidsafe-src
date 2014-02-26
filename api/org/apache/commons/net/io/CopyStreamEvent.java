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
import java.util.EventObject;

/**
 * A CopyStreamEvent is triggered after every write performed by a
 * stream copying operation.  The event stores the number of bytes
 * transferred by the write triggering the event as well as the total
 * number of bytes transferred so far by the copy operation.
 * <p>
 * <p>
 * @see CopyStreamListener
 * @see CopyStreamAdapter
 * @see Util
 * @author <a href="mailto:savarese@apache.org">Daniel F. Savarese</a>
 * @version $Id: CopyStreamEvent.java 165675 2005-05-02 20:09:55Z rwinston $
 */
public class CopyStreamEvent extends EventObject
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.497 -0500", hash_original_field = "CD086838D51760ADB903B751241F9C1C", hash_generated_field = "878F50673BBBF3DEC3AD26329BFEC5E1")

    public static final long UNKNOWN_STREAM_SIZE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.501 -0500", hash_original_field = "BD85AB55237C037827FEDC1A9DD400CE", hash_generated_field = "6FC6472E5EFEBF4CC213117E3903FBF2")


    private int bytesTransferred;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.504 -0500", hash_original_field = "588067F15A284DFD9EE3EB09D591673F", hash_generated_field = "837439953D51ECB492B4F24E0B76C052")

    private long totalBytesTransferred;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.507 -0500", hash_original_field = "0A3CB120BAFF8192A08A4FBD609D1683", hash_generated_field = "AA20AF1DA7E7F88DCD38311F573CAD66")

    private long streamSize;

    /**
     * Creates a new CopyStreamEvent instance.
     * @param source  The source of the event.
     * @param totalBytesTransferred The total number of bytes transferred so
     *   far during a copy operation.
     * @param bytesTransferred  The number of bytes transferred during the
     *        write that triggered the CopyStreamEvent.
     * @param streamSize  The number of bytes in the stream being copied.
     *          This may be set to <code>UNKNOWN_STREAM_SIZE</code> if the
     *          size is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.510 -0500", hash_original_method = "BA8DA0A39FE3A34BE845FD360AA83761", hash_generated_method = "69ED514E7589238E52E387503E561C4E")
    @DSSafe(DSCat.SAFE_OTHERS)
public CopyStreamEvent(Object source, long totalBytesTransferred,
                           int bytesTransferred, long streamSize)
    {
        super(source);
        this.bytesTransferred = bytesTransferred;
        this.totalBytesTransferred = totalBytesTransferred;
        this.streamSize = streamSize;
    }

    /**
     * Returns the number of bytes transferred by the write that triggered
     * the event.
     * @return The number of bytes transferred by the write that triggered
     * the vent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.514 -0500", hash_original_method = "A41DCDCF02D5E7DE0F70EA42230590E8", hash_generated_method = "1C275BAD42DAFAE806A28930DC4CFDFE")
    @DSSafe(DSCat.SAFE_OTHERS)
public int getBytesTransferred()
    {
        return bytesTransferred;
    }

    /**
     * Returns the total number of bytes transferred so far by the copy
     * operation.
     * @return The total number of bytes transferred so far by the copy
     * operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.517 -0500", hash_original_method = "C28B76EE4358A62CAE2EB5BA12A6EFD5", hash_generated_method = "CA66174706A724EDF639914843DF4E73")
    @DSSafe(DSCat.SAFE_OTHERS)
public long getTotalBytesTransferred()
    {
        return totalBytesTransferred;
    }

    /**
     * Returns the size of the stream being copied.
     * This may be set to <code>UNKNOWN_STREAM_SIZE</code> if the
     * size is unknown.
     * @return The size of the stream being copied.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.520 -0500", hash_original_method = "59ECAC7CB091DC5DF7BEC5C502422BD9", hash_generated_method = "E3F57A8B46C91F94897BD3FC30C4B2BA")
    @DSSafe(DSCat.SAFE_OTHERS)
public long getStreamSize()
    {
        return streamSize;
    }
}
