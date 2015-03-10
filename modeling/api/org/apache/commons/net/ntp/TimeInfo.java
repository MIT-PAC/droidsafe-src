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
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.ntp;
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Wrapper class to network time packet messages (NTP, etc) that computes
 * related timing info and stats.
 *
 * @author Jason Mathews, MITRE Corp
 *
 * @version $Revision: 165675 $ $Date: 2005-05-02 15:09:55 -0500 (Mon, 02 May 2005) $
 */
public class TimeInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.277 -0500", hash_original_field = "8234D45122D9182FC85365E556E193B2", hash_generated_field = "BAA859FF447539D5BC0A0C680554377E")


    private NtpV3Packet _message;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.283 -0500", hash_original_field = "830E1463291D7534C477F725FC0BDA70", hash_generated_field = "2D660EA27EDCA342500ECD6E8C0AFD3B")

    private List _comments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.290 -0500", hash_original_field = "21F5C4C59B48D8235B5B3A0AFAE55B4B", hash_generated_field = "B4E2C96247763267C958D755316F21F1")

    private Long _delay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.296 -0500", hash_original_field = "3667F36CF7AEDAA9CC1BF65EA9776088", hash_generated_field = "70884A69F1C791016FC9EDEA5F8469A0")

    private Long _offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.302 -0500", hash_original_field = "2CB4FDF1E4C2D4513BC350A1EB7E4609", hash_generated_field = "8C6BCE104CEC7A7D8BD2AAC81EF6FC48")

    private long _returnTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.308 -0500", hash_original_field = "6675105CDD5B4EB7AAFB0E5517EA4DE5", hash_generated_field = "1C0DB433628B8D49D8F09C8A349C96D3")

    private boolean _detailsComputed;

    /**
     * Create TimeInfo object with raw packet message and destination time received.
     *
     * @param message NTP message packet
     * @param returnTime  destination receive time
     * @throws IllegalArgumentException if message is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.314 -0500", hash_original_method = "A7BEDAC109747D82D490F131B6CCC1A3", hash_generated_method = "8AB06C0BE9F5D455EF3BC83A95D0EBA3")
    
public TimeInfo(NtpV3Packet message, long returnTime) {
        this(message, returnTime, null, true);
    }

    /**
     * Create TimeInfo object with raw packet message and destination time received.
     *
     * @param message NTP message packet
     * @param returnTime  destination receive time
     * @param comments List of errors/warnings identified during processing
     * @throws IllegalArgumentException if message is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.319 -0500", hash_original_method = "C2AADFE11E1A3D243B7C66EFA8EB257F", hash_generated_method = "8670EDA6E6A093F94862510C8FAD3351")
    
public TimeInfo(NtpV3Packet message, long returnTime, List comments)
    {
            this(message, returnTime, comments, true);
    }

    /**
     * Create TimeInfo object with raw packet message and destination time received.
     * Auto-computes details if computeDetails flag set otherwise this is delayed
     * until computeDetails() is called. Delayed computation is for fast
     * intialization when sub-millisecond timing is needed.
     *
     * @param msgPacket NTP message packet
     * @param returnTime  destination receive time
     * @param doComputeDetails  flag to pre-compute delay/offset values
     * @throws IllegalArgumentException if message is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.327 -0500", hash_original_method = "55D7CD04E09ADF38D9006E9AF738C98A", hash_generated_method = "81C27825B791A36CD6CE2C59B1B76623")
    
public TimeInfo(NtpV3Packet msgPacket, long returnTime, boolean doComputeDetails)
    {
            this(msgPacket, returnTime, null, doComputeDetails);
    }

    /**
     * Create TimeInfo object with raw packet message and destination time received.
     * Auto-computes details if computeDetails flag set otherwise this is delayed
     * until computeDetails() is called. Delayed computation is for fast
     * intialization when sub-millisecond timing is needed.
     *
     * @param message NTP message packet
     * @param returnTime  destination receive time
     * @param comments  list of comments used to store errors/warnings with message
     * @param doComputeDetails  flag to pre-compute delay/offset values
     * @throws IllegalArgumentException if message is null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.334 -0500", hash_original_method = "35CEE337B7CF2CE947FEFF13BC2D0A5B", hash_generated_method = "FB209E38D853AAC0B760690DC6CFAAB7")
    
public TimeInfo(NtpV3Packet message, long returnTime, List comments,
                   boolean doComputeDetails)
    {
        if (message == null)
            throw new IllegalArgumentException("message cannot be null");
        this._returnTime = returnTime;
        this._message = message;
        this._comments = comments;
        if (doComputeDetails)
            computeDetails();
    }

    /**
     * Add comment (error/warning) to list of comments associated
     * with processing of NTP parameters. If comment list not create
     * then one will be created.
     *
     * @param comment
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.340 -0500", hash_original_method = "812B8FA1D533EE1EF3FF794B2C641F6A", hash_generated_method = "89C99F37789F7E7DC8FA54962F0D8B6B")
    
public void addComment(String comment)
    {
        if (_comments == null) {
            _comments = new ArrayList();
        }
        _comments.add(comment);
    }

    /**
     * Compute and validate details of the NTP message packet. Computed
     * fields include the offset and delay.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.351 -0500", hash_original_method = "32CFE25E6847EC55A20B0F496EFF6C58", hash_generated_method = "73BCBBEE32C42A6ECD2A4A2C30454ABE")
    
public void computeDetails()
    {
        if (_detailsComputed) {
            return; // details already computed - do nothing
        }
        _detailsComputed = true;
        if (_comments == null) {
            _comments = new ArrayList();
        }

        TimeStamp origNtpTime = _message.getOriginateTimeStamp();
        long origTime = origNtpTime.getTime();

        // Receive Time is time request received by server (t2)
        TimeStamp rcvNtpTime = _message.getReceiveTimeStamp();
        long rcvTime = rcvNtpTime.getTime();

        // Transmit time is time reply sent by server (t3)
        TimeStamp xmitNtpTime = _message.getTransmitTimeStamp();
        long xmitTime = xmitNtpTime.getTime();

        /*
         * Round-trip network delay and local clock offset (or time drift) is calculated
         * according to this standard NTP equation:
         *
         * LocalClockOffset = ((ReceiveTimestamp - OriginateTimestamp) +
         *		        (TransmitTimestamp - DestinationTimestamp)) / 2
         *
         * equations from RFC-1305 (NTPv3)
         *      roundtrip delay = (t4 - t1) - (t3 - t2)
         *      local clock offset = ((t2 - t1) + (t3 - t4)) / 2
         *
         * It takes into account network delays and assumes that they are symmetrical.
         *
         * Note the typo in SNTP RFCs 1769/2030 which state that the delay
         * is (T4 - T1) - (T2 - T3) with the "T2" and "T3" switched.
         */
        if (origNtpTime.ntpValue() == 0)
        {
            // without originate time cannot determine when packet went out
            // might be via a broadcast NTP packet...
            if (xmitNtpTime.ntpValue() != 0)
            {
                _offset = new Long(xmitTime - _returnTime);
                _comments.add("Error: zero orig time -- cannot compute delay");
            } else
                _comments.add("Error: zero orig time -- cannot compute delay/offset");
        } else if (rcvNtpTime.ntpValue() == 0 || xmitNtpTime.ntpValue() == 0)
        {
            _comments.add("Warning: zero rcvNtpTime or xmitNtpTime");
            // assert destTime >= origTime since network delay cannot be negative
            if (origTime > _returnTime)
                _comments.add("Error: OrigTime > DestRcvTime");
            else
            {
                // without receive or xmit time cannot figure out processing time
                // so delay is simply the network travel time
                _delay = new Long(_returnTime - origTime);
            }
            // TODO: is offset still valid if rcvNtpTime=0 || xmitNtpTime=0 ???
            // Could always hash origNtpTime (sendTime) but if host doesn't set it
            // then it's an malformed ntp host anyway and we don't care?
            // If server is in broadcast mode then we never send out a query in first place...
            if (rcvNtpTime.ntpValue() != 0)
            {
                // xmitTime is 0 just use rcv time
                _offset = new Long(rcvTime - origTime);
            } else if (xmitNtpTime.ntpValue() != 0)
            {
                // rcvTime is 0 just use xmitTime time
                _offset = new Long(xmitTime - _returnTime);
            }
        } else
        {
             long delayValue = _returnTime - origTime;
             // assert xmitTime >= rcvTime: difference typically < 1ms
             if (xmitTime < rcvTime)
             {
                 // server cannot send out a packet before receiving it...
                 _comments.add("Error: xmitTime < rcvTime"); // time-travel not allowed
             } else
             {
                 // subtract processing time from round-trip network delay
                 long delta = xmitTime - rcvTime;
                 // in normal cases the processing delta is less than
                 // the total roundtrip network travel time.
                 if (delta <= delayValue)
                 {
                     delayValue -= delta; // delay = (t4 - t1) - (t3 - t2)
                 } else
                 {
                     // if delta - delayValue == 1 ms then it's a round-off error
                     // e.g. delay=3ms, processing=4ms
                     if (delta - delayValue == 1)
                     {
                         // delayValue == 0 -> local clock saw no tick change but destination clock did
                         if (delayValue != 0)
                         {
                             _comments.add("Info: processing time > total network time by 1 ms -> assume zero delay");
                             delayValue = 0;
                         }
                     } else
                         _comments.add("Warning: processing time > total network time");
                 }
             }
             _delay = new Long(delayValue);
            if (origTime > _returnTime) // assert destTime >= origTime
                _comments.add("Error: OrigTime > DestRcvTime");

            _offset = new Long(((rcvTime - origTime) + (xmitTime - _returnTime)) / 2);
        }
    }

    /**
     * Return list of comments (if any) during processing of NTP packet.
     *
     * @return List or null if not yet computed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.360 -0500", hash_original_method = "C8BD94BFF6F4703C3B4097554F7F3E14", hash_generated_method = "EA5E25EBFC7B6942A0DF65BD2199DED4")
    
public List getComments()
    {
        return _comments;
    }

    /**
     * Get round-trip network delay. If null then could not compute the delay.
     *
     * @return Long or null if delay not available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.365 -0500", hash_original_method = "60E71E7E8C148D2D9546EC327C5A4A6E", hash_generated_method = "708A8EC4B16B02A549CFF573ED6C3AD9")
    
public Long getDelay()
    {
        return _delay;
    }

    /**
     * Get clock offset needed to adjust local clock to match remote clock. If null then could not
     * compute the offset.
     *
     * @return Long or null if offset not available.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.370 -0500", hash_original_method = "3E446195E1000396C441B67E7F5BDA4E", hash_generated_method = "179D5EBCECAA489EEECE9F10A5D123CF")
    
public Long getOffset()
    {
        return _offset;
    }

    /**
     * Returns NTP message packet.
     *
     * @return NTP message packet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.375 -0500", hash_original_method = "A143145314F67BB6E078A56F005CBD11", hash_generated_method = "9778824825A45E8FD6CE8CF9713020D7")
    
public NtpV3Packet getMessage()
    {
        return _message;
    }

    /**
     * Returns time at which time message packet was received by local machine.
     *
     * @return packet return time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.379 -0500", hash_original_method = "3DFD7BF73FEC919AE8CDDEFED67FB1EF", hash_generated_method = "B092E394FC8BEEC0211769076A7D8BE5")
    
public long getReturnTime()
    {
        return _returnTime;
    }

}
