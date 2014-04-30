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
import java.net.DatagramPacket;

/***
 * Implementation of NtpV3Packet with methods converting Java objects to/from
 * the Network Time Protocol (NTP) data message header format described in RFC-1305.
 *
 * @author Naz Irizarry, MITRE Corp
 * @author Jason Mathews, MITRE Corp
 *
 * @version $Revision: 165675 $ $Date: 2005-05-02 15:09:55 -0500 (Mon, 02 May 2005) $
 */
public class NtpV3Impl implements NtpV3Packet
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.021 -0500", hash_original_field = "2FE8B959F33371290601EAB99A984ADD", hash_generated_field = "2C4223A63C74CABEB2FDCCA04ED07C75")

    private static final int MODE_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.033 -0500", hash_original_field = "41484C45A110C0E16850AF102BDDA7CF", hash_generated_field = "DD51AB82431B0461A989487137F5B324")

    private static final int MODE_SHIFT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.044 -0500", hash_original_field = "539DD8A2DDFD2ED99C19260A86F0CD9C", hash_generated_field = "52C279095B78062175A994B129E1355A")

    private static final int VERSION_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.055 -0500", hash_original_field = "546D23CC1E4F30F1C2A6D3D48C255813", hash_generated_field = "BC98D967D2A063B23507EA946711A75B")

    private static final int VERSION_SHIFT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.062 -0500", hash_original_field = "9B533DF0FADF10B8A1A78B5D61445652", hash_generated_field = "EC7F2A32367E9CB7C3E174485DFCF12C")

    private static final int LI_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.071 -0500", hash_original_field = "416D159C5D1B283FACA3351DD70D40A5", hash_generated_field = "5A89344241C96B983A4B5EA5C75F8A3C")

    private static final int LI_SHIFT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.079 -0500", hash_original_field = "34B8081D10267B7D5F7CFA0E88E702EF", hash_generated_field = "E09C424F8A31F9CE06F6368CC7E6A3D4")

    private static final int STRATUM_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.087 -0500", hash_original_field = "42A660FE12D3D204BFDF31A90D0A2D8B", hash_generated_field = "27594DAE19890C46612EB7B82DFEB925")

    private static final int POLL_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.094 -0500", hash_original_field = "0E5CA284297025D0EFE27970A42162B6", hash_generated_field = "7C70C577E827951CA59A3147AC6506DF")

    private static final int PRECISION_INDEX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.107 -0500", hash_original_field = "3C97ED78D076847474DD47075B3C3C46", hash_generated_field = "CC8577655A8E028550A0C6E31D4EB2B7")

    private static final int ROOT_DELAY_INDEX = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.114 -0500", hash_original_field = "D3DA64ECE15DE520A524EEF8DE0A2B87", hash_generated_field = "175D294D7AA28BC9DB577D5B1D3347E6")

    private static final int ROOT_DISPERSION_INDEX = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.122 -0500", hash_original_field = "BF526FAE4F47E15109367ADE32E065F1", hash_generated_field = "6A44194E345D16EB4F359CA92D78EF92")

    private static final int REFERENCE_ID_INDEX = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.129 -0500", hash_original_field = "3868B2A74D4EB39F0B61A2A4914C18D4", hash_generated_field = "A031AB42AB79CA5410E2B59FA6BAA3DC")

    private static final int REFERENCE_TIMESTAMP_INDEX = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.138 -0500", hash_original_field = "1399324B4EB43B8B6B4E1F097590DA05", hash_generated_field = "CD343D8CEAD0462D499B71887AE49C21")

    private static final int ORIGINATE_TIMESTAMP_INDEX = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.145 -0500", hash_original_field = "8155A8848964E81C514B3AAA6AE7C019", hash_generated_field = "DF348F6863A1D0C32C5C8F83232CF352")

    private static final int RECEIVE_TIMESTAMP_INDEX = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.153 -0500", hash_original_field = "7F934EBB49B32D0CF1F7501222057B6F", hash_generated_field = "6EA8E85EC4F5F8510491554C2296BEE2")

    private static final int TRANSMIT_TIMESTAMP_INDEX = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.160 -0500", hash_original_field = "F26FB6951E305C30C9D7D35FB5E3263D", hash_generated_field = "AD0A56D08FD1C6275D479677EE919306")

    private static final int KEY_IDENTIFIER_INDEX = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.167 -0500", hash_original_field = "5A62262FEAABCA47D051BBF97CA7D525", hash_generated_field = "83A4CA2AB188C6B507C80A507004D70B")

    private static final int MESSAGE_DIGEST = 54;

    /***
     * Convert byte to unsigned integer.
     * Java only has signed types so we have to do
     * more work to get unsigned ops.
     *
     * @param b
     * @return unsigned int value of byte
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.482 -0500", hash_original_method = "0171304E9D51F893DC3CA5BAB2B76EB8", hash_generated_method = "A4B4E5A7CB28AAF70EFE75349DF9314D")
    
protected final static int ui(byte b)
    {
        int i = b & 0xFF;
        return i;
    }

    /***
     * Convert byte to unsigned long.
     * Java only has signed types so we have to do
     * more work to get unsigned ops
     *
     * @param b
     * @return unsigned long value of byte
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.488 -0500", hash_original_method = "DF2E03043ADDA78F2D8E4BCDFB1D36C4", hash_generated_method = "DE9F6F930A27B3DA4B282721C822DF37")
    
protected final static long ul(byte b)
    {
        long i = b & 0xFF;
        return i;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.175 -0500", hash_original_field = "A6385E83F8F84C48091095858EC308D8", hash_generated_field = "A0AA2FE522842972BFE03F375CB01402")

    private byte[] buf = new byte[48];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.182 -0500", hash_original_field = "A1D26CC6B997CD5A7248D6E02382993B", hash_generated_field = "19B7EAD3976E05D3BCEEC1DF62B85F44")

    private DatagramPacket dp;

    /** Creates a new instance of NtpV3Impl */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.189 -0500", hash_original_method = "56AB1D6DB13A65C15890A0555B72FBBF", hash_generated_method = "04376E4F938AA94376D86D8CAEB2C6ED")
    
public NtpV3Impl()
    {
    }

    /***
     * Returns mode as defined in RFC-1305 which is a 3-bit integer
     * whose value is indicated by the MODE_xxx parameters.
     *
     * @return mode as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.196 -0500", hash_original_method = "7D0B0A9AF833698ABF65556CDE45F0FD", hash_generated_method = "B725DA878279469973907E6ABC79C2A4")
    
public int getMode()
    {
        return (ui(buf[MODE_INDEX]) >> MODE_SHIFT) & 0x7;
    }

    /***
     * Return human-readable name of message mode type as described in
     * RFC 1305.
     * @return mode name as string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.203 -0500", hash_original_method = "F22127C74A867B2EC94D89018EFE3845", hash_generated_method = "C359045FA79E14E22DCC1046DD19668F")
    
public String getModeName()
    {
        return NtpUtils.getModeName(getMode());
    }

    /***
     * Set mode as defined in RFC-1305.
     * @param mode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.209 -0500", hash_original_method = "CF5027E36B3B0FD4CBDEC387D0508ECD", hash_generated_method = "D54D59181F0F31A5170990BF890D6DBE")
    
public void setMode(int mode)
    {
        buf[MODE_INDEX] = (byte) (buf[MODE_INDEX] & 0xF8 | mode & 0x7);
    }

    /***
     * Returns leap indicator as defined in RFC-1305 which is a two-bit code:
     *	0=no warning
     *	1=last minute has 61 seconds
     *	2=last minute has 59 seconds
     *	3=alarm condition (clock not synchronized)
     *
     * @return leap indicator as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.215 -0500", hash_original_method = "8B2E999D4C14A3FB40609B3879946752", hash_generated_method = "BBDE83241D72E7B781428F38901D4628")
    
public int getLeapIndicator()
    {
        return (ui(buf[LI_INDEX]) >> LI_SHIFT) & 0x3;
    }

    /***
     * Set leap indicator as defined in RFC-1305.
     * @param li leap indicator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.228 -0500", hash_original_method = "D7075F27D91E684AB85C105ACFB1F965", hash_generated_method = "9BEB059139C5D47815DF2FF9932FB8A4")
    
public void setLeapIndicator(int li)
    {
        buf[LI_INDEX] = (byte) (buf[LI_INDEX] & 0x3F | ((li & 0x3) << LI_SHIFT));
    }

    /***
     * Returns poll interval as defined in RFC-1305, which is an eight-bit
     * signed integer indicating the maximum interval between successive
     * messages, in seconds to the nearest power of two (e.g. value of six
     * indicates an interval of 64 seconds. The values that can appear in
     * this field range from NTP_MINPOLL to NTP_MAXPOLL inclusive.
     *
     * @return poll interval as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.252 -0500", hash_original_method = "3CD93C8C7EE063287F717AF592A763CB", hash_generated_method = "11BA5AB9665C51C20E30B1202A456493")
    
public int getPoll()
    {
        return (int) (buf[POLL_INDEX]);
    }

    /***
     * Set poll interval as defined in RFC-1305.
     *
     * @param poll poll interval.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.258 -0500", hash_original_method = "D5A99B652932697D58335DE775809A17", hash_generated_method = "675C23F3DB0B4691CC38B872BE8A3322")
    
public void setPoll(int poll)
    {
        buf[POLL_INDEX] = (byte) (poll & 0xFF);
    }

    /***
     * Returns precision as defined in RFC-1305 encoded as an 8-bit signed
     * integer (seconds to nearest power of two).
     * Values normally range from -6 to -20.
     *
     * @return precision as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.264 -0500", hash_original_method = "AB112CDBC99CDBBC0B2ADCE2EEEE4940", hash_generated_method = "1DF225CF77A96D12723D8628E9BF7227")
    
public int getPrecision()
    {
        return (int) buf[PRECISION_INDEX];
    }

    /***
     * Set precision as defined in RFC-1305.
     * @param precision
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.271 -0500", hash_original_method = "6D1B48F235C1EB1B39B266E41FBB4CE2", hash_generated_method = "11C819F5B4D952E15D76D57E9561B0CA")
    
public void setPrecision(int precision)
    {
        buf[PRECISION_INDEX] = (byte) (precision & 0xFF);
    }

    /***
     * Returns NTP version number as defined in RFC-1305.
     *
     * @return NTP version number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.278 -0500", hash_original_method = "FE510F509F21ED9CA019DFA4EC302B5D", hash_generated_method = "077DF4EE7303384C62F8C2234E6A537D")
    
public int getVersion()
    {
        return (ui(buf[VERSION_INDEX]) >> VERSION_SHIFT) & 0x7;
    }

    /***
     * Set NTP version as defined in RFC-1305.
     *
     * @param version NTP version.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.285 -0500", hash_original_method = "534C87901DE70C4F91736D0B4CCA7CBC", hash_generated_method = "C0A13467F4CDEB65017EEA8776C31D21")
    
public void setVersion(int version)
    {
        buf[VERSION_INDEX] = (byte) (buf[VERSION_INDEX] & 0xC7 | ((version & 0x7) << VERSION_SHIFT));
    }

    /***
     * Returns Stratum as defined in RFC-1305, which indicates the stratum level
     * of the local clock, with values defined as follows: 0=unspecified,
     * 1=primary ref clock, and all others a secondary reference (via NTP).
     *
     * @return Stratum level as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.291 -0500", hash_original_method = "10104AF3FD0E53252786DCDB90267E69", hash_generated_method = "5446A856891AB45A3123D5AE436C749E")
    
public int getStratum()
    {
        return ui(buf[STRATUM_INDEX]);
    }

    /***
     * Set stratum level as defined in RFC-1305.
     *
     * @param stratum stratum level.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.298 -0500", hash_original_method = "25E44B806095FE646975D81030DABAA8", hash_generated_method = "208AE2C517C97EA94B182F7647973F82")
    
public void setStratum(int stratum)
    {
        buf[STRATUM_INDEX] = (byte) (stratum & 0xFF);
    }

    /***
     * Return root delay as defined in RFC-1305, which is the total roundtrip delay
     * to the primary reference source, in seconds. Values can take positive and
     * negative values, depending on clock precision and skew.
     *
     * @return root delay as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.303 -0500", hash_original_method = "A458E6E63A532FBB9F1ADD8DEF92B535", hash_generated_method = "06A31EAF6444E2EFC73D52371D5E8E82")
    
public int getRootDelay()
    {
        return getInt(ROOT_DELAY_INDEX);
    }

    /***
     * Return root delay as defined in RFC-1305 in milliseconds, which is
     * the total roundtrip delay to the primary reference source, in
     * seconds. Values can take positive and negative values, depending
     * on clock precision and skew.
     *
     * @return root delay in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.310 -0500", hash_original_method = "4C21E49917B9964F0E5D6A3038BB6F39", hash_generated_method = "E16F1404407C6C28AB580FB76C34AE86")
    
public double getRootDelayInMillisDouble()
    {
        double l = getRootDelay();
        return l / 65.536;
    }

    /***
     * Returns root dispersion as defined in RFC-1305.
     * @return root dispersion.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.317 -0500", hash_original_method = "442295459E0D2D873FF8ED31C62CFC9A", hash_generated_method = "87441CD5562098FD11C446271F9D9F05")
    
public int getRootDispersion()
    {
        return getInt(ROOT_DISPERSION_INDEX);
    }

    /***
     * Returns root dispersion (as defined in RFC-1305) in milliseconds.
     *
     * @return root dispersion in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.323 -0500", hash_original_method = "0B491ABD6AA29C0239DA7345FC26F8C7", hash_generated_method = "5D63DC8A2E369D574D8B87E961AA4943")
    
public long getRootDispersionInMillis()
    {
        long l = getRootDispersion();
        return (l * 1000) / 65536L;
    }

    /***
     * Returns root dispersion (as defined in RFC-1305) in milliseconds
     * as double precision value.
     *
     * @return root dispersion in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.329 -0500", hash_original_method = "890BEAD251BEBE1C53C77CDCEA7FF0B8", hash_generated_method = "D36D88F29FFC768D84B7EB94745A4920")
    
public double getRootDispersionInMillisDouble()
    {
        double l = getRootDispersion();
        return l / 65.536;
    }

    /***
     * Set reference clock identifier field with 32-bit unsigned integer value.
     * See RFC-1305 for description.
     *
     * @param refId reference clock identifier.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.335 -0500", hash_original_method = "7932B9ADB1B5585C29CED3AFA54BEE8E", hash_generated_method = "8D0C2027AE19251F7D151574DC7EDF8B")
    
public void setReferenceId(int refId)
    {
        for (int i = 3; i >= 0; i--) {
            buf[REFERENCE_ID_INDEX + i] = (byte) (refId & 0xff);
            refId >>>= 8; // shift right one-byte
        }
    }

    /***
     * Returns the reference id as defined in RFC-1305, which is
     * a 32-bit integer whose value is dependent on several criteria.
     *
     * @return the reference id as defined in RFC-1305.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.342 -0500", hash_original_method = "F8186C2267AFFA0821CD79FB056BD960", hash_generated_method = "4F55489FD1CFEACB12D3EFCB2DA7041F")
    
public int getReferenceId()
    {
        return getInt(REFERENCE_ID_INDEX);
    }

    /***
     * Returns the reference id string. String cannot be null but
     * value is dependent on the version of the NTP spec supported
     * and stratum level. Value can be an empty string, clock type string,
     * IP address, or a hex string.
     *
     * @return the reference id string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.351 -0500", hash_original_method = "B2095AB481AC0F339BA7248C60DB2A9F", hash_generated_method = "8295557AE1B8E8AE56D62E51556CD765")
    
public String getReferenceIdString()
    {
        int version = getVersion();
        int stratum = getStratum();
        if (version == VERSION_3 || version == VERSION_4) {
            if (stratum == 0 || stratum == 1) {
                return idAsString(); // 4-character ASCII string (e.g. GPS, USNO)
            }
            // in NTPv4 servers this is latest transmit timestamp of ref source
            if (version == VERSION_4)
                return idAsHex();
        }

        // Stratum 2 and higher this is a four-octet IPv4 address
        // of the primary reference host.
        if (stratum >= 2) {
            return idAsIPAddress();
        }
        return idAsHex();
    }

    /***
     * Returns Reference id as dotted IP address.
     * @return refId as IP address string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.358 -0500", hash_original_method = "DA0D07749F50BCDD6CD0799E453E7E9C", hash_generated_method = "CC98DAAB6ACCCA23ED21B8685D8B698C")
    
private String idAsIPAddress()
    {
        return ui(buf[REFERENCE_ID_INDEX]) + "." +
                ui(buf[REFERENCE_ID_INDEX + 1]) + "." +
                ui(buf[REFERENCE_ID_INDEX + 2]) + "." +
                ui(buf[REFERENCE_ID_INDEX + 3]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.366 -0500", hash_original_method = "B4C4FDFBF04F369D3D30AB6C2A0BC3B0", hash_generated_method = "03D5BB15E6A159CD30B1DCBE8D0FBAFA")
    
private String idAsString()
    {
        String id = "";
        for (int i = 0; i <= 3; i++) {
            char c = (char) buf[REFERENCE_ID_INDEX + i];
            if (c == 0) break; // 0-terminated string
            id = id + c;
        }
        return id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.372 -0500", hash_original_method = "EA09CBE55EDFF48FC4B0BCC23E149C48", hash_generated_method = "65218C914542B36494DFCC9FECDA7400")
    
private String idAsHex()
    {
        return Integer.toHexString(getReferenceId());
    }

    /***
     * Returns the transmit timestamp as defined in RFC-1305.
     *
     * @return the transmit timestamp as defined in RFC-1305.
     * Never returns a null object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.379 -0500", hash_original_method = "E279E41F7A301CA8E72A6CE868C4AC44", hash_generated_method = "EFBE0E7735C9C3B6A1C7F16D3EF687FE")
    
public TimeStamp getTransmitTimeStamp()
    {
        return getTimestamp(TRANSMIT_TIMESTAMP_INDEX);
    }

    /***
     * Set transmit time with NTP timestamp.
     * If <code>ts</code> is null then zero time is used.
     *
     * @param ts NTP timestamp
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.387 -0500", hash_original_method = "3924E6FCBBFFF0B4082ADF5A3B8D8C28", hash_generated_method = "175FD56672615987D184B06E215228F4")
    
public void setTransmitTime(TimeStamp ts)
    {
        setTimestamp(TRANSMIT_TIMESTAMP_INDEX, ts);
    }

    /***
     * Set originate timestamp given NTP TimeStamp object.
     * If <code>ts</code> is null then zero time is used.
     *
     * @param ts NTP timestamp
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.394 -0500", hash_original_method = "ED338495931D9D6FD55A4F141FB5F544", hash_generated_method = "B36C738A8E8CD599C6B0A92B82DDFFA8")
    
public void setOriginateTimeStamp(TimeStamp ts)
    {
        setTimestamp(ORIGINATE_TIMESTAMP_INDEX, ts);
    }

    /***
     * Returns the originate time as defined in RFC-1305.
     *
     * @return the originate time.
     * Never returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.401 -0500", hash_original_method = "290DE7EE739EE3B90035E8874D3F9C4D", hash_generated_method = "5473DBF06ABFDF38E46D9CB3A4CD24E4")
    
public TimeStamp getOriginateTimeStamp()
    {
        return getTimestamp(ORIGINATE_TIMESTAMP_INDEX);
    }

    /***
     * Returns the reference time as defined in RFC-1305.
     *
     * @return the reference time as <code>TimeStamp</code> object.
     * Never returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.407 -0500", hash_original_method = "476D6518FCF4B392876919C596F419E0", hash_generated_method = "99C11107B395D6F0519E8EE103DF2579")
    
public TimeStamp getReferenceTimeStamp()
    {
        return getTimestamp(REFERENCE_TIMESTAMP_INDEX);
    }

    /***
     * Set Reference time with NTP timestamp. If <code>ts</code> is null
     * then zero time is used.
     *
     * @param ts NTP timestamp
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.415 -0500", hash_original_method = "5C897BE3879C79AA2A25AC906BE610C4", hash_generated_method = "89C0DECC545A234772A90919C7CA7887")
    
public void setReferenceTime(TimeStamp ts)
    {
        setTimestamp(REFERENCE_TIMESTAMP_INDEX, ts);
    }

    /***
     * Returns receive timestamp as defined in RFC-1305.
     *
     * @return the receive time.
     * Never returns null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.422 -0500", hash_original_method = "3C0CCAF882CE3FCBF0A7F0E522505ABF", hash_generated_method = "C685C85284B638F81BE43425AF9C0583")
    
public TimeStamp getReceiveTimeStamp()
    {
        return getTimestamp(RECEIVE_TIMESTAMP_INDEX);
    }

    /***
     * Set receive timestamp given NTP TimeStamp object.
     * If <code>ts</code> is null then zero time is used.
     *
     * @param ts timestamp
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.428 -0500", hash_original_method = "2CADE0318D073EF16BF7D9CD1359C657", hash_generated_method = "BA4150813AFE09A89A38C96CC4B3583D")
    
public void setReceiveTimeStamp(TimeStamp ts)
    {
        setTimestamp(RECEIVE_TIMESTAMP_INDEX, ts);
    }

    /***
     * Return type of time packet. The values (e.g. NTP, TIME, ICMP, ...)
     * correspond to the protocol used to obtain the timing information.
     *
     * @return packet type string identifier which in this case is "NTP".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.434 -0500", hash_original_method = "99618E6002065D128B215F15D46D3D9E", hash_generated_method = "9C8339B568CAB6AF36E4F3F602A5E791")
    
public String getType()
    {
        return "NTP";
    }

    /***
     * @return 4 bytes as 32-bit int
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.441 -0500", hash_original_method = "E655749BCC9D56EF1F2A478F58B47EB8", hash_generated_method = "0F9BE63D8BB8EF63DE77A99AD87047B6")
    
private int getInt(int index)
    {
        int i = ui(buf[index]) << 24 |
                ui(buf[index + 1]) << 16 |
                ui(buf[index + 2]) << 8 |
                ui(buf[index + 3]);

        return i;
    }

    /***
     * Get NTP Timestamp at specified starting index.
     *
     * @param index index into data array
     * @return TimeStamp object for 64 bits starting at index
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.447 -0500", hash_original_method = "B83E15F460DC4E1D4997705ED25B8372", hash_generated_method = "B809C1F0D206C64875DCFE36A5FE6C9A")
    
private TimeStamp getTimestamp(int index)
    {
        return new TimeStamp(getLong(index));
    }

    /***
     * Get Long value represented by bits starting at specified index.
     *
     * @return 8 bytes as 64-bit long
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.454 -0500", hash_original_method = "AD4290C26C00006A77EEE311B3B4F79D", hash_generated_method = "E29E5D2E3506A0643288A03E59FF91AC")
    
private long getLong(int index)
    {
        long i = ul(buf[index]) << 56 |
                ul(buf[index + 1]) << 48 |
                ul(buf[index + 2]) << 40 |
                ul(buf[index + 3]) << 32 |
                ul(buf[index + 4]) << 24 |
                ul(buf[index + 5]) << 16 |
                ul(buf[index + 6]) << 8 |
                ul(buf[index + 7]);
        return i;
    }

    /***
     * Sets the NTP timestamp at the given array index.
     *
     * @param index index into the byte array.
     * @param t TimeStamp.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.462 -0500", hash_original_method = "FFE516C1F5384A2927164F9CE3092312", hash_generated_method = "9BF059FF0CE621C4CAAB44A5AE165422")
    
private void setTimestamp(int index, TimeStamp t)
    {
        long ntpTime = (t == null) ? 0 : t.ntpValue();
        // copy 64-bits from Long value into 8 x 8-bit bytes of array
        // one byte at a time shifting 8-bits for each position.
        for (int i = 7; i >= 0; i--) {
            buf[index + i] = (byte) (ntpTime & 0xFF);
            ntpTime >>>= 8; // shift to next byte
        }
        // buf[index] |= 0x80;  // only set if 1900 baseline....
    }

    /***
     * Returns the datagram packet with the NTP details already filled in.
     *
     * @return a datagram packet.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.469 -0500", hash_original_method = "3554DDAF3E43102C2F3BCDCF24AD44C3", hash_generated_method = "FE246EB105B560679DAF5A0BEA5E0FD8")
    
public DatagramPacket getDatagramPacket()
    {
        if (dp == null)
            synchronized(this) {
                if (dp == null) {
                    dp = new DatagramPacket(buf, buf.length);
                    dp.setPort(NTP_PORT);
                }
            }
        return dp;
    }

    /***
     * Set the contents of this object from source datagram packet.
     *
     * @param srcDp source DatagramPacket to copy contents from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.475 -0500", hash_original_method = "76894E18081009582DBFA4E6C5049BE4", hash_generated_method = "552930C534B25B60782B4BA8863ACEBB")
    
public void setDatagramPacket(DatagramPacket srcDp)
    {
        byte[] incomingBuf = srcDp.getData();
        int len = srcDp.getLength();
        if (len > buf.length)
            len = buf.length;

        System.arraycopy(incomingBuf, 0, buf, 0, len);
    }

    /***
     * Returns details of NTP packet as a string.
     *
     * @return details of NTP packet as a string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:53.495 -0500", hash_original_method = "A02BC8EA24DC526040D0D1A34629C374", hash_generated_method = "96D59C65BFD95080684CFF943D5818A3")
    
public String toString()
    {
        return "[" +
                "version:" + getVersion() +
                ", mode:" + getMode() +
                ", poll:" + getPoll() +
                ", precision:" + getPrecision() +
                ", delay:" + getRootDelay() +
                ", dispersion(ms):" + getRootDispersionInMillisDouble() +
                ", id:" + getReferenceIdString() +
                ", xmitTime:" + getTransmitTimeStamp().toDateString() +
                " ]";
    }

}
