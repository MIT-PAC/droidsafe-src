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
 * Conditions Of Use
 *
 * This software was developed by employees of the National Institute of
 * Standards and Technology (NIST), an agency of the Federal Government.
 * Pursuant to title 15 Untied States Code Section 105, works of NIST
 * employees are not subject to copyright protection in the United States
 * and are considered to be in the public domain.  As a result, a formal
 * license is not needed to use the software.
 *
 * This software is provided by NIST as a service and is expressly
 * provided "AS IS."  NIST MAKES NO WARRANTY OF ANY KIND, EXPRESS, IMPLIED
 * OR STATUTORY, INCLUDING, WITHOUT LIMITATION, THE IMPLIED WARRANTY OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, NON-INFRINGEMENT
 * AND DATA ACCURACY.  NIST does not warrant or make any representations
 * regarding the use of the software or the results thereof, including but
 * not limited to the correctness, accuracy, reliability or usefulness of
 * the software.
 *
 * Permission to use this software is contingent upon your acceptance
 * of the terms of this agreement
 *
 * .
 *
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.InternalErrorHandler;
import gov.nist.javax.sip.stack.SIPStackTimerTask;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;

public class Pipeline extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.731 -0500", hash_original_field = "86DA92917EB7762FF502F88DA803E684", hash_generated_field = "B4DAA050AED16D506138B23A2C545CFC")

    private LinkedList buffList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.733 -0500", hash_original_field = "0A73FD9A1AA89E3BF0779051055F85DB", hash_generated_field = "18A2B612A1CF4422210AEC79BF708D17")

    private Buffer currentBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.736 -0500", hash_original_field = "FF1318BD7B381B7887A6EEC627EFEF6C", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.738 -0500", hash_original_field = "738C3D18449F14F8BF2AE2302B0A1011", hash_generated_field = "02D2240A23798B540E9F3183DC11EA33")

    private Timer timer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.741 -0500", hash_original_field = "A22F4158EEDE6585ECB16C67C9DD6488", hash_generated_field = "74EA00CD9256C545C6A23A280DF2583C")

    private InputStream pipe;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.743 -0500", hash_original_field = "665A6CAA499F4AF9E1413810B84B3FBE", hash_generated_field = "6532B828611581315664CF6DAFB483BF")

    private int readTimeout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.746 -0500", hash_original_field = "387ABD8C123EDD8BA64EC399E2255BE3", hash_generated_field = "861338A3A376656ED2C9B97C2EA0F97E")

    private TimerTask myTimerTask;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.787 -0500", hash_original_method = "F09CF9CB05C3E89BEBCB566F6112879F", hash_generated_method = "B29D509ACBCBA79BB8525CD553413EF8")
    
public Pipeline(InputStream pipe, int readTimeout, Timer timer) {
        // pipe is the Socket stream
        // this is recorded here to implement a timeout.
        this.timer = timer;
        this.pipe = pipe;
        buffList = new LinkedList();
        this.readTimeout = readTimeout;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.781 -0500", hash_original_method = "2B544F7E796D3D68CE94D6BF6C677E04", hash_generated_method = "FA572370F8DB2267FB11A76FCA320674")
    
public void startTimer() {
        if (this.readTimeout == -1)
            return;
        // TODO make this a tunable number. For now 4 seconds
        // between reads seems reasonable upper limit.
        this.myTimerTask = new MyTimer(this);
        this.timer.schedule(this.myTimerTask, this.readTimeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.784 -0500", hash_original_method = "37F409FD7F01F3081F8A12D9761B8422", hash_generated_method = "DC245243DDA6A9993493CA8F415CAF9D")
    
public void stopTimer() {
        if (this.readTimeout == -1)
            return;
        if (this.myTimerTask != null)
            this.myTimerTask.cancel();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.789 -0500", hash_original_method = "B005CBAD4698DC28B9A1B35993572349", hash_generated_method = "3A70F720B8609BBBFA750B22D93CF16B")
    
public void write(byte[] bytes, int start, int length) throws IOException {
        if (this.isClosed)
            throw new IOException("Closed!!");
        Buffer buff = new Buffer(bytes, length);
        buff.ptr = start;
        synchronized (this.buffList) {
            buffList.add(buff);
            buffList.notifyAll();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.792 -0500", hash_original_method = "C06546AC352C387D8ACC673056FAD350", hash_generated_method = "E40187C6BA0AD944E39AD78BA9B2DB1F")
    
public void write(byte[] bytes) throws IOException {
        if (this.isClosed)
            throw new IOException("Closed!!");
        Buffer buff = new Buffer(bytes, bytes.length);
        synchronized (this.buffList) {
            buffList.add(buff);
            buffList.notifyAll();
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.794 -0500", hash_original_method = "9D61CBBC55A04932A86EE90F3831850B", hash_generated_method = "CDDE287FF99A539B653DF429E5750A4C")
    
public void close() throws IOException {
        this.isClosed = true;
        synchronized (this.buffList) {
            this.buffList.notifyAll();
        }

        // JvB: added
        this.pipe.close();
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.797 -0500", hash_original_method = "F2F79F1D43766E909F353C0CFC9043D6", hash_generated_method = "4E747B06890E58DC4665FE9F81AEC4E1")
    
public int read() throws IOException {
        // if (this.isClosed) return -1;
        synchronized (this.buffList) {
            if (currentBuffer != null
                    && currentBuffer.ptr < currentBuffer.length) {
                int retval = currentBuffer.getNextByte();
                if (currentBuffer.ptr == currentBuffer.length)
                    this.currentBuffer = null;
                return retval;
            }
            // Bug fix contributed by Rob Daugherty.
            if (this.isClosed && this.buffList.isEmpty())
                return -1;
            try {
                // wait till something is posted.
                while (this.buffList.isEmpty()) {
                    this.buffList.wait();
                    if (this.isClosed)
                        return -1;
                }
                currentBuffer = (Buffer) this.buffList.removeFirst();
                int retval = currentBuffer.getNextByte();
                if (currentBuffer.ptr == currentBuffer.length)
                    this.currentBuffer = null;
                return retval;
            } catch (InterruptedException ex) {
                throw new IOException(ex.getMessage());
            } catch (NoSuchElementException ex) {
                ex.printStackTrace();
                throw new IOException(ex.getMessage());
            }
        }
    }
    
    class MyTimer extends SIPStackTimerTask {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.748 -0500", hash_original_field = "7840915867A0DD99EC64B89800E1CB6D", hash_generated_field = "7840915867A0DD99EC64B89800E1CB6D")

        Pipeline pipeline;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.752 -0500", hash_original_field = "BB99F9FD9B80227D96B49A85B4B95D46", hash_generated_field = "59DB49985984D67A006441E7DEFF885A")

        private boolean isCancelled;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.755 -0500", hash_original_method = "469A54409CE651B527E545FCC2B571E7", hash_generated_method = "DB0F1C8CBBB97AC894ACF040EC7BD514")
        
protected MyTimer(Pipeline pipeline) {
            this.pipeline = pipeline;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.758 -0500", hash_original_method = "6E25F52123B3B61D6A13AFDDD464AC50", hash_generated_method = "6B6DD5A211E3E5FE3B49313E2C7105EE")
        
protected void runTask() {
            if (this.isCancelled)
                return;

            try {
                pipeline.close();
            } catch (IOException ex) {
                InternalErrorHandler.handleException(ex);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.761 -0500", hash_original_method = "866118B2542F2688ED0E9C68986718EB", hash_generated_method = "D283DF1122A44FE0C2A1B9F13F61C0AB")
        
public boolean cancel() {
            boolean retval = super.cancel();
            this.isCancelled = true;
            return retval;
        }
        
    }
    
    class Buffer {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.765 -0500", hash_original_field = "AB97A4156FC1CC1DAF26375194010FF1", hash_generated_field = "AB97A4156FC1CC1DAF26375194010FF1")

        byte[] bytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.768 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

        int length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.770 -0500", hash_original_field = "407F33A4FEC278EC364347D42DC7DA18", hash_generated_field = "407F33A4FEC278EC364347D42DC7DA18")

        int ptr;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.773 -0500", hash_original_method = "093A036FC0CE68502CB27911CE2FE87A", hash_generated_method = "F1771AF9AAE805CACB2317846F533F87")
        
public Buffer(byte[] bytes, int length) {
            ptr = 0;
            this.length = length;
            this.bytes = bytes;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:42.776 -0500", hash_original_method = "C5E9FA9D1099E171DFD942E3B525903F", hash_generated_method = "087EB1F45898EAF0175AF01D67DE848C")
        
public int getNextByte() {
            int retval = bytes[ptr++] & 0xFF;
            return retval;
        }
        
    }
    
}

