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
import java.util.Enumeration;
import org.apache.commons.net.util.ListenerList;

/**
 * The CopyStreamAdapter will relay CopyStreamEvents to a list of listeners
 * when either of its bytesTransferred() methods are called.  Its purpose
 * is to facilitate the notification of the progress of a copy operation
 * performed by one of the static copyStream() methods in
 * org.apache.commons.io.Util to multiple listeners.  The static
 * copyStream() methods invoke the
 * bytesTransfered(long, int) of a CopyStreamListener for performance
 * reasons and also because multiple listeners cannot be registered given
 * that the methods are static.
 * <p>
 * <p>
 * @see CopyStreamEvent
 * @see CopyStreamListener
 * @see Util
 * @author <a href="mailto:savarese@apache.org">Daniel F. Savarese</a>
 * @version $Id: CopyStreamAdapter.java 165675 2005-05-02 20:09:55Z rwinston $
 */
public class CopyStreamAdapter implements CopyStreamListener
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.211 -0500", hash_original_field = "0969B112C8F7B08C25CE76D9315C065E", hash_generated_field = "7D389C7B484155C80B7972C8841D3EA5")

    private ListenerList internalListeners;

    /**
     * Creates a new copyStreamAdapter.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.216 -0500", hash_original_method = "2CBB805BB0A161F5128CD7B1280D9949", hash_generated_method = "27092FC110AA8FE32A5A4C706D52F461")
    
public CopyStreamAdapter()
    {
        internalListeners = new ListenerList();
    }

    /**
     * This method is invoked by a CopyStreamEvent source after copying
     * a block of bytes from a stream.  The CopyStreamEvent will contain
     * the total number of bytes transferred so far and the number of bytes
     * transferred in the last write.  The CopyStreamAdapater will relay
     * the event to all of its registered listeners, listing itself as the
     * source of the event.
     * @param event The CopyStreamEvent fired by the copying of a block of
     *              bytes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.219 -0500", hash_original_method = "F49A1215DBCAFF371E059D4C820BFFAD", hash_generated_method = "D0C5A42D8CF59B609D724814F892DAB7")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void bytesTransferred(CopyStreamEvent event)
    {
        bytesTransferred(event.getTotalBytesTransferred(),
                         event.getBytesTransferred(),
                         event.getStreamSize());
    }

    /**
     * This method is not part of the JavaBeans model and is used by the
     * static methods in the org.apache.commons.io.Util class for efficiency.
     * It is invoked after a block of bytes to inform the listener of the
     * transfer.  The CopyStreamAdapater will create a CopyStreamEvent
     * from the arguments and relay the event to all of its registered
     * listeners, listing itself as the source of the event.
     * @param totalBytesTransferred  The total number of bytes transferred
     *         so far by the copy operation.
     * @param bytesTransferred  The number of bytes copied by the most recent
     *          write.
     * @param streamSize The number of bytes in the stream being copied.
     *        This may be equal to CopyStreamEvent.UNKNOWN_STREAM_SIZE if
     *        the size is unknown.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.223 -0500", hash_original_method = "162C0509301F2C51523E8B25D0579049", hash_generated_method = "FCF69916F262C42E9B6A1EB9B1E1D628")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void bytesTransferred(long totalBytesTransferred,
                                 int bytesTransferred, long streamSize)
    {
        Enumeration listeners;
        CopyStreamEvent event;

        listeners = internalListeners.getListeners();

        event = new CopyStreamEvent(this,
                                    totalBytesTransferred,
                                    bytesTransferred,
                                    streamSize);

        while (listeners.hasMoreElements())
        {
            ((CopyStreamListener) (listeners.nextElement())).
                bytesTransferred(event);
        }
    }

    /**
     * Registers a CopyStreamListener to receive CopyStreamEvents.
     * Although this method is not declared to be synchronized, it is
     * implemented in a thread safe manner.
     * @param listener  The CopyStreamlistener to register.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.226 -0500", hash_original_method = "804DBCB0CD99C171EB9C2BE85EFE707F", hash_generated_method = "F945DE3E757AC7DD3DC8584B1CB11B30")
    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void addCopyStreamListener(CopyStreamListener listener)
    {
        internalListeners.addListener(listener);
        if (listener != null) {
            bytesTransferred(DSUtils.FAKE_INT, DSUtils.FAKE_INT, DSUtils.FAKE_INT);
            
            CopyStreamEvent event = new CopyStreamEvent(this,
                                    DSUtils.FAKE_INT,
                                    DSUtils.FAKE_INT,
                                    DSUtils.FAKE_INT);

            bytesTransferred(event);
        }
    }

    /**
     * Unregisters a CopyStreamListener.  Although this method is not
     * synchronized, it is implemented in a thread safe manner.
     * @param listener  The CopyStreamlistener to unregister.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.229 -0500", hash_original_method = "2D7E47036B50BB575C62CBE22B38A3ED", hash_generated_method = "13D305BFC1071355C8CD298FADE3E731")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void removeCopyStreamListener(CopyStreamListener listener)
    {
        internalListeners.removeListener(listener);
    }
}
