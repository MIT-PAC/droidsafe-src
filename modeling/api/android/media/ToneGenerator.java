/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.media;

/**
 * This class provides methods to play DTMF tones (ITU-T Recommendation Q.23),
 * call supervisory tones (3GPP TS 22.001, CEPT) and proprietary tones (3GPP TS 31.111).
 * Depending on call state and routing options, tones are mixed to the downlink audio
 * or output to the speaker phone or headset.
 * This API is not for generating tones over the uplink audio path.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class ToneGenerator
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.987 -0400", hash_original_field = "BF62C4F6D817E41601A646C19B726C06", hash_generated_field = "D1FD02BB136F81BE394DAF7212034851")

    /*
     * List of all available tones: These constants must be kept consistant with
     * the enum in ToneGenerator C++ class.     */

    /**
     * DTMF tone for key 0: 1336Hz, 941Hz, continuous</p>
     *
     * @see #ToneGenerator(int, int)
     */
    public static final int TONE_DTMF_0 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.989 -0400", hash_original_field = "E2BD94E23084D8F7C134CE1A1B70F2B4", hash_generated_field = "93EC90B4EB7E3E6307BD4BF70302E34F")

    public static final int TONE_DTMF_1 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.991 -0400", hash_original_field = "3DC710D725EE0E7CE3D9B6523CBB5C1B", hash_generated_field = "075802209DE39E72FBB34AE344BE6998")

    public static final int TONE_DTMF_2 = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.994 -0400", hash_original_field = "36FE6F88DA9A5FDA1397EAED3C42C457", hash_generated_field = "3076E1E55D93D91454BAF11E0675B55E")

    public static final int TONE_DTMF_3 = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.996 -0400", hash_original_field = "A0B714AC30DD27C687BED2D07B097EBF", hash_generated_field = "802E8F1050E46C5FA92F95CC60A2342C")

    public static final int TONE_DTMF_4 = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:14.999 -0400", hash_original_field = "D88750325CD9A60395937BABA937D42F", hash_generated_field = "5AF5DCE479EDE7B15263D08F7496B3A8")

    public static final int TONE_DTMF_5 = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.001 -0400", hash_original_field = "88BE3D1A6FA5CE58E671227E58D73402", hash_generated_field = "C770BBDD995EBF3829CE04D970A1F7C9")

    public static final int TONE_DTMF_6 = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.003 -0400", hash_original_field = "47B3A46ABDC8707C67CA9C66CD519E10", hash_generated_field = "0E215A85EA8E9D7A4EDC227A721DE0E6")

    public static final int TONE_DTMF_7 = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.005 -0400", hash_original_field = "024B817CB5DEE70F057D84DF4D29C049", hash_generated_field = "0629C4ECE7871832B7AB534BF8BE849F")

    public static final int TONE_DTMF_8 = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.007 -0400", hash_original_field = "5C518FB8E1967EE63254F69BC53D09A3", hash_generated_field = "05C3BF794ADB662FE0D3720D7A4152C6")

    public static final int TONE_DTMF_9 = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.009 -0400", hash_original_field = "DD2E34B28434D7B306DB76A641441E17", hash_generated_field = "A5F252B8046F80F5EFEF485D8CA05986")

    public static final int TONE_DTMF_S = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.012 -0400", hash_original_field = "3C0489304802037C3272FC5B606464B0", hash_generated_field = "D92997D70282E92CF3470ED4E8A2206C")

    public static final int TONE_DTMF_P = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.014 -0400", hash_original_field = "C13D4EF22045E6D2080ED6FBD0691ABE", hash_generated_field = "A9653AE2F46E8B61ADFDA2E5D1B13A2E")

    public static final int TONE_DTMF_A = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.016 -0400", hash_original_field = "D3DA47B88D3CCC67A79E13993E980FAF", hash_generated_field = "796C2969DEC479133577F80441E47C17")

    public static final int TONE_DTMF_B = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.018 -0400", hash_original_field = "92CC6498C774B9B986652742A023EDF3", hash_generated_field = "72903EAF7F917975E6890AEB2B31B66C")

    public static final int TONE_DTMF_C = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.020 -0400", hash_original_field = "41AC6D389A820CE6C6B649EC4E3C3692", hash_generated_field = "6BD1F615842C02D1AC2D3DD784A30A5B")

    public static final int TONE_DTMF_D = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.022 -0400", hash_original_field = "85D53A4B4C8B81751E896A47D6E29036", hash_generated_field = "52433E4AF6A748987FD4D6044774C978")

    public static final int TONE_SUP_DIAL = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.024 -0400", hash_original_field = "BF7285D68F7FC1C71A3600166E6B2036", hash_generated_field = "3D91BC6C241AC1AC4586F0A0DDF94299")

    public static final int TONE_SUP_BUSY = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.027 -0400", hash_original_field = "FA6EC24670E284E69F607038D6BF633B", hash_generated_field = "129A62445C84EE5F9385E0A9009F4383")

    public static final int TONE_SUP_CONGESTION = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.029 -0400", hash_original_field = "C43F3EC855FF86BC25A0C2704D3C0D80", hash_generated_field = "4DD245BD83FBAD8ADA331F095BC8BBAA")

    public static final int TONE_SUP_RADIO_ACK = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.031 -0400", hash_original_field = "F91D0B4A64B68E03BDDBDCD6DB172040", hash_generated_field = "E7F47C3EF74A5836DAD52D56E64D1274")

    public static final int TONE_SUP_RADIO_NOTAVAIL = 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.033 -0400", hash_original_field = "40ED1B6372F8832E4FA31535AC1144E3", hash_generated_field = "86F894F71BD6AFFC0A6923E844CE63C0")

    public static final int TONE_SUP_ERROR = 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.035 -0400", hash_original_field = "F9F3676FEB558CBD14719F6D3A863053", hash_generated_field = "CF62FCC673268993F7AA70CDD18E2E77")

    public static final int TONE_SUP_CALL_WAITING = 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.038 -0400", hash_original_field = "57DCEFEBB087AE31118D75733ED92361", hash_generated_field = "5883C6145A4EBD499A9F22CE2E302553")

    public static final int TONE_SUP_RINGTONE = 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.040 -0400", hash_original_field = "67E0947BFF9A100972258BFB821DCB57", hash_generated_field = "675F68BE4560D228AEAFDF5AB40F24B4")

    public static final int TONE_PROP_BEEP = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.042 -0400", hash_original_field = "7820A5DD0F3440FE635EE50F5D2879A2", hash_generated_field = "1DFDA1E2E7A97E55CD0C6ADF9BCC0DBE")

    public static final int TONE_PROP_ACK = 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.044 -0400", hash_original_field = "1019DA0B477DB87628D5418F9FD72CB6", hash_generated_field = "2B0BEE503175171297EE88D5C61F7D17")

    public static final int TONE_PROP_NACK = 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.047 -0400", hash_original_field = "F61ACD6E2EEFD2C0F7C336A4F6448609", hash_generated_field = "E75F885EE5F878FEF16D10A3D7978793")

    public static final int  TONE_PROP_PROMPT = 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.049 -0400", hash_original_field = "FB7A2B4DC5BFC00E96EA125DF67B6B2C", hash_generated_field = "02E637CB154B1AFB61ACB00B5B320D91")

    public static final int TONE_PROP_BEEP2 = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.051 -0400", hash_original_field = "7E3440E9826972F31EF9477B184F195E", hash_generated_field = "D49A9600EE8961A7DAF5020F74CB8195")

    public static final int TONE_SUP_INTERCEPT = 29;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.053 -0400", hash_original_field = "C49B5AEC5DE2E69BF83888DEB6C1371E", hash_generated_field = "CF340C931D22FDBDE71681C111A2AF4F")

    public static final int TONE_SUP_INTERCEPT_ABBREV = 30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.055 -0400", hash_original_field = "FB487AA8095FBCC17E75FF710116F275", hash_generated_field = "61629959F9BC528ADD96AC594EA19FE2")

    public static final int TONE_SUP_CONGESTION_ABBREV = 31;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.057 -0400", hash_original_field = "C16DD8114E7A00478CA9B4F76C7EDC3B", hash_generated_field = "F758809DBEFC8965520A04BE084C6973")

    public static final int TONE_SUP_CONFIRM = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.059 -0400", hash_original_field = "0661C5C80032E0706B170841CD96EC79", hash_generated_field = "F2C335A0CC07DFB6024C188F0E0A50DA")

    public static final int TONE_SUP_PIP = 33;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.061 -0400", hash_original_field = "B12393744FC5A10FA737C679FBDEA8D3", hash_generated_field = "3D5F1ABADF9C307F20ED1B7F27DB8D5C")

    public static final int TONE_CDMA_DIAL_TONE_LITE = 34;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.063 -0400", hash_original_field = "1F37FBE05CBCA3CE01D6417EA790BE99", hash_generated_field = "C62B23896085796E222F0C07D4E90561")

    public static final int TONE_CDMA_NETWORK_USA_RINGBACK = 35;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.065 -0400", hash_original_field = "14A70C83570D05F19E36C1AEFD723451", hash_generated_field = "20CBF79BF6B975524F119F01E595AECA")

    public static final int TONE_CDMA_INTERCEPT = 36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.067 -0400", hash_original_field = "551A69F2FDBB448D76A0F5F3A02BD9FE", hash_generated_field = "5E5164CA868190A2BA415646B59FB9FC")

    public static final int TONE_CDMA_ABBR_INTERCEPT = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.070 -0400", hash_original_field = "C9EFAFF7B9440ACE93E94C2FB001561A", hash_generated_field = "0FD92E9BEC461241370EA434C4C30B0D")

    public static final int TONE_CDMA_REORDER = 38;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.072 -0400", hash_original_field = "C816A4C719913938C89CA8A13C2712E0", hash_generated_field = "8B2D6D99269FAAD6D0D71F6518726B92")

    public static final int TONE_CDMA_ABBR_REORDER = 39;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.074 -0400", hash_original_field = "E4F75D9D8C22442DF4CC61E91573F6C0", hash_generated_field = "F35E6FE5F5A764F7B38D202772CACF78")

    public static final int TONE_CDMA_NETWORK_BUSY = 40;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.076 -0400", hash_original_field = "9260EFC7016BF43D1546A4A29FC16251", hash_generated_field = "8CE3659FC91BD07035734A75AA000DD5")

    public static final int TONE_CDMA_CONFIRM = 41;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.079 -0400", hash_original_field = "62C93B9850B82BC4C7DE1F8563BC6DB3", hash_generated_field = "82A5A56B32BC59A542D5C47381DB896C")

    public static final int TONE_CDMA_ANSWER = 42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.081 -0400", hash_original_field = "DC9F8BE0B8563D22D95608E88F768127", hash_generated_field = "D8F226D7CE29B12E2C0D265A2146C6D3")

    public static final int TONE_CDMA_NETWORK_CALLWAITING = 43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.083 -0400", hash_original_field = "CD588055B5A5C8A59ED7DA4DCCC46B69", hash_generated_field = "D140EEB97527349BDC65A3804886B08F")

    public static final int TONE_CDMA_PIP = 44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.085 -0400", hash_original_field = "993B62C8FF67B11DED4B014A49830163", hash_generated_field = "657D21253A68F8B02BA07BE6EE3B6C40")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_NORMAL = 45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.087 -0400", hash_original_field = "1B0586408A270016E84AE32C0A76C6BA", hash_generated_field = "A90B86C1CB29586810B01CC5441BFFD5")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_INTERGROUP = 46;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.089 -0400", hash_original_field = "A8E31611D9BEA6691BCB2B3EF9005BE0", hash_generated_field = "5DF2F5AAF2C19C8068FA553578A16DE7")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_SP_PRI = 47;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.091 -0400", hash_original_field = "23613F7E5AE52FD5C0C21A9C982ED407", hash_generated_field = "952DA1703C08AB91702F07FB96C06299")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT3 = 48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.093 -0400", hash_original_field = "E74857E5697BC4E4C3A57C182DB407E6", hash_generated_field = "532B59E6BC8C45791E51C6C5AAE64430")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PING_RING = 49;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.095 -0400", hash_original_field = "1890D9C59CB222A6E361F80D8822FE6E", hash_generated_field = "AA4DAE77FE6F489E95C81D997035D386")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT5 = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.097 -0400", hash_original_field = "4B19FF864AD66C45A8E6B98095864FA0", hash_generated_field = "4CB32CB1A070E429375D12AE8FAAC79E")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT6 = 51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.100 -0400", hash_original_field = "DA71BBECFA864CCE6F05E183589CB4BF", hash_generated_field = "428FE58F6B456F4D7F30EB11264FCA30")

    public static final int TONE_CDMA_CALL_SIGNAL_ISDN_PAT7 = 52;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.102 -0400", hash_original_field = "8615A93918543A61E7404DD8CFA286EF", hash_generated_field = "617CB89C0038837612248A69E43A9A4D")

    public static final int TONE_CDMA_HIGH_L = 53;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.104 -0400", hash_original_field = "A2D64EC37599BA0B6092C41D64030422", hash_generated_field = "4EF798DB87BFFA67BFF8AB28BFFE3236")

    public static final int TONE_CDMA_MED_L = 54;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.106 -0400", hash_original_field = "F99E6D589321CC890052C8CB0EAB4AB1", hash_generated_field = "B89D9DB51414F6E251F92571EA24F13A")

    public static final int TONE_CDMA_LOW_L = 55;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.107 -0400", hash_original_field = "9134E9B51C81EEDE9293A345915D9AF2", hash_generated_field = "3E3D5B57B0FBCADD55C9CF5028A07E7D")

    public static final int TONE_CDMA_HIGH_SS = 56;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.109 -0400", hash_original_field = "3DF6A3B74FAD3BE3EA07A2CD070EA825", hash_generated_field = "7C5CC709342C51580BC9548CAEFCB2DC")

    public static final int TONE_CDMA_MED_SS = 57;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.111 -0400", hash_original_field = "A8488D3503D63AB9C434487EAF1F0699", hash_generated_field = "9AEE5124CECA63BC6B40D860BC15B7EF")

    public static final int TONE_CDMA_LOW_SS = 58;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.113 -0400", hash_original_field = "3B582F37186139FE063D1C7A96B0089B", hash_generated_field = "2EB4E98C6269C2652E85EE681C094286")

    public static final int TONE_CDMA_HIGH_SSL = 59;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.116 -0400", hash_original_field = "5D2E87F2D61D1B9410C229DCFB327C28", hash_generated_field = "1429CC92697599E025C030BC6625B466")

    public static final int TONE_CDMA_MED_SSL = 60;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.118 -0400", hash_original_field = "EA3A8CB059F3F4AB78AFECF68EE6439F", hash_generated_field = "C1D58496C54A149E546D6A0B85F12E5F")

    public static final int TONE_CDMA_LOW_SSL = 61;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.120 -0400", hash_original_field = "8827A89DD6EB124E135087CDE57A8947", hash_generated_field = "CD87AD4AC4E4EC8453E78730BEE02972")

    public static final int TONE_CDMA_HIGH_SS_2 = 62;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.122 -0400", hash_original_field = "C77080B046E97F3255F924188E650C76", hash_generated_field = "EF1F8C994ADB06E9706025280EAAC0CA")

    public static final int TONE_CDMA_MED_SS_2 = 63;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.124 -0400", hash_original_field = "7EFA95B1B6994ED14ABBCC062B63B175", hash_generated_field = "00F31AAD42A41C6E6F2133450D2A934A")

    public static final int TONE_CDMA_LOW_SS_2 = 64;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.127 -0400", hash_original_field = "14FAFAD4A3C1ED9685D59C33CB5DCA72", hash_generated_field = "9CBCB8749DBA33F5618E18F15053E513")

    public static final int TONE_CDMA_HIGH_SLS = 65;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.129 -0400", hash_original_field = "4F00A756C1A05B6D2F6799FCAB14E014", hash_generated_field = "10328B0F43726ED2DFA5BA04F4419197")

    public static final int TONE_CDMA_MED_SLS = 66;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.131 -0400", hash_original_field = "FC4F41289B5DFF3636562F73D8B5BD2F", hash_generated_field = "26EA3AD071AB553763AB872D9B066607")

    public static final int TONE_CDMA_LOW_SLS = 67;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.133 -0400", hash_original_field = "FEA3E5598D4BDD5D187871CFBDF44919", hash_generated_field = "F162F282C31EC3DA36E4173285185680")

    public static final int TONE_CDMA_HIGH_S_X4 = 68;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.135 -0400", hash_original_field = "DAB30A004FFE33A84BD24C41B71A4024", hash_generated_field = "528F6AA8D19AFAF10FD3234E3C5AA9CB")

    public static final int TONE_CDMA_MED_S_X4 = 69;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.137 -0400", hash_original_field = "6F2E2186C83C7B624DF56731F1A62DE8", hash_generated_field = "2ABCC1D6347B4AAA5385E9A9F3DE356B")

    public static final int TONE_CDMA_LOW_S_X4 = 70;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.139 -0400", hash_original_field = "36A243FA520D0FB72E3503A9FBE4E262", hash_generated_field = "DE857F4D5F8FCB0B052E2BDD66FFC71A")

    public static final int TONE_CDMA_HIGH_PBX_L = 71;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.141 -0400", hash_original_field = "6E47F9C90EB9B25031DFC5B3B58DA14F", hash_generated_field = "51347C5D6012C4543B86532DBE4EF091")

    public static final int TONE_CDMA_MED_PBX_L = 72;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.143 -0400", hash_original_field = "6E3DB6C7B318CCD4F2E3C2DE7C99AC0F", hash_generated_field = "3116CF3D31101F33E179498DC62AB83B")

    public static final int TONE_CDMA_LOW_PBX_L = 73;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.146 -0400", hash_original_field = "B2092CAEB766618CB23F2D2A28FDA0E6", hash_generated_field = "FA268DDBCDBC5C6CBD989C172B9C0C52")

    public static final int TONE_CDMA_HIGH_PBX_SS = 74;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.148 -0400", hash_original_field = "148C7D97115D12F2668F742A7755B84D", hash_generated_field = "2AB15C0AF44F80066B9D5D5FC9376F42")

    public static final int TONE_CDMA_MED_PBX_SS = 75;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.150 -0400", hash_original_field = "DB7E7FB08200FA8B61E9F830AF4C4E4C", hash_generated_field = "8F97BCE27E3896730259EA7FE01A7184")

    public static final int TONE_CDMA_LOW_PBX_SS = 76;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.152 -0400", hash_original_field = "195188C84C5A2B55261B481E55C32B44", hash_generated_field = "4B14FCC322A5311ACADFCF556B8FE884")

    public static final int TONE_CDMA_HIGH_PBX_SSL = 77;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.154 -0400", hash_original_field = "3998AF1371B9F67287087CD6877034CF", hash_generated_field = "D4696F6CF611750A0D035477F7D73059")

    public static final int TONE_CDMA_MED_PBX_SSL = 78;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.155 -0400", hash_original_field = "85D022AD2A0C3887B3C5560577A0D8D3", hash_generated_field = "128F43BDE03BBC4164A99BE353925D9D")

    public static final int TONE_CDMA_LOW_PBX_SSL = 79;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.157 -0400", hash_original_field = "8AC1892A6CD747A45A8937252E2DCB34", hash_generated_field = "27835E4B45F3CFAD8E3626B03224ACE0")

    public static final int TONE_CDMA_HIGH_PBX_SLS = 80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.160 -0400", hash_original_field = "20D4E989BBA09EF39A4D64A8D5593D04", hash_generated_field = "DCC901B7AD152E63ABCAD1D04140C555")

    public static final int TONE_CDMA_MED_PBX_SLS = 81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.162 -0400", hash_original_field = "3D2A32A579536E6967E7A82F74ADE971", hash_generated_field = "12D4FB4431062867DE01A7C04900E840")

    public static final int TONE_CDMA_LOW_PBX_SLS = 82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.164 -0400", hash_original_field = "C1DEE7E56D85ED0AC6D31C3BB48DB547", hash_generated_field = "CEBE3CBAC19FFDCB76C339A3991FE3FE")

    public static final int TONE_CDMA_HIGH_PBX_S_X4 = 83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.167 -0400", hash_original_field = "D45C9BD2279354CB343457C4A5078B9F", hash_generated_field = "B80C30B005120A1CB8D216F324CC9ABF")

    public static final int TONE_CDMA_MED_PBX_S_X4 = 84;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.169 -0400", hash_original_field = "A6F8D11D7C9D84C301DC283A3503EC1A", hash_generated_field = "7DEECD8642593821B8712E80B0E67E8A")

    public static final int TONE_CDMA_LOW_PBX_S_X4 = 85;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.171 -0400", hash_original_field = "28CB83C00925CC53234FD6D9E1724BC3", hash_generated_field = "5192352326E1003ABAB66801F76A548C")

    public static final int    TONE_CDMA_ALERT_NETWORK_LITE = 86;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.173 -0400", hash_original_field = "6695F68A5CF54D6EBA6FEF2A9C752B12", hash_generated_field = "03C736C26200BAF07149B1D659FAECD9")

    public static final int    TONE_CDMA_ALERT_AUTOREDIAL_LITE = 87;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.175 -0400", hash_original_field = "5897A1B9BA8295103F00849B4168313D", hash_generated_field = "B9EB517C692CB72BA821ACD7A82693FE")

    public static final int    TONE_CDMA_ONE_MIN_BEEP = 88;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.177 -0400", hash_original_field = "1100A1BCE44B600CAE37873653353F1D", hash_generated_field = "14A667768968FAB30BECCE5CBF45A45B")

    public static final int    TONE_CDMA_KEYPAD_VOLUME_KEY_LITE = 89;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.179 -0400", hash_original_field = "5F1F01CA8741F165DF756F17EA779FBF", hash_generated_field = "657D90A5034D6C9E09B8E4A49646AA5A")

    public static final int    TONE_CDMA_PRESSHOLDKEY_LITE = 90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.181 -0400", hash_original_field = "C1316D2FD93ED07D5854A21A5D9D069B", hash_generated_field = "3B9834BC7660F627AA0ABC8581562EDA")

    public static final int    TONE_CDMA_ALERT_INCALL_LITE = 91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.183 -0400", hash_original_field = "0C5E2DDFCEDB513F964522CD27FF8D88", hash_generated_field = "B1F9FB90B1E24E743472256154BBC3DB")

    public static final int    TONE_CDMA_EMERGENCY_RINGBACK = 92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.185 -0400", hash_original_field = "44CB1CE2BA94CB49F2FA4F51462EEBD7", hash_generated_field = "5B900DD66371937B2248624044D35B19")

    public static final int    TONE_CDMA_ALERT_CALL_GUARD = 93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.187 -0400", hash_original_field = "A48F6C980FDF20E722B5C032F9F5FADC", hash_generated_field = "AA5D3CF2DDD48736DA48998DF7D69FFA")

    public static final int    TONE_CDMA_SOFT_ERROR_LITE = 94;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.190 -0400", hash_original_field = "8F193078B0ACFD4330D1D4DDFC67F120", hash_generated_field = "8085EF972DF2B77708250D47F9C44468")

    public static final int    TONE_CDMA_CALLDROP_LITE = 95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.191 -0400", hash_original_field = "E3CB88F1EA06C8D9F0BC18258A5DEA1A", hash_generated_field = "B35B9EBF835586A18A8D8697E31C1F3C")

    public static final int    TONE_CDMA_NETWORK_BUSY_ONE_SHOT = 96;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.194 -0400", hash_original_field = "EB1FE6FDA11A2CB1CEC28201721519B7", hash_generated_field = "1EB18F6C3ADB89171E158C45CEB0892E")

    public static final int    TONE_CDMA_ABBR_ALERT = 97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.196 -0400", hash_original_field = "584466E50592228AE36B934042E7E464", hash_generated_field = "34EE1D1D3438208EC66280793FC85A78")

    public static final int TONE_CDMA_SIGNAL_OFF = 98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.198 -0400", hash_original_field = "1E467C0EB8CBCA8F22210EB85551DB74", hash_generated_field = "95803DAF16F02F2A59E8EF672DD8F121")

    public static final int MAX_VOLUME = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.200 -0400", hash_original_field = "F0B612BB1E6C38651A146B90CDFAFFCA", hash_generated_field = "6A6A5C676BB8CA49C9DC3F126271272D")

    public static final int MIN_VOLUME = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.220 -0400", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "4FF8A42CAE4591AC91206314B4192EA4")

    @SuppressWarnings("unused")
    private int mNativeContext;

    /**
     * ToneGenerator class contructor specifying output stream type and volume.
     *
     * @param streamType The streame type used for tone playback (e.g. STREAM_MUSIC).
     * @param volume     The volume of the tone, given in percentage of maximum volume (from 0-100).
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.201 -0400", hash_original_method = "F456C830515CA57E64333B5502C7B0DC", hash_generated_method = "F1EEBAD7F1E5D8AF2624926687B33B24")
    
public ToneGenerator(int streamType, int volume) {
        native_setup(streamType, volume);
    }

    /**
     * This method starts the playback of a tone of the specified type.
     * only one tone can play at a time: if a tone is playing while this method is called,
     * this tone is stopped and replaced by the one requested.
     * @param toneType   The type of tone generated chosen from the following list:
     * <ul>
     * <li>{@link #TONE_DTMF_0}
     * <li>{@link #TONE_DTMF_1}
     * <li>{@link #TONE_DTMF_2}
     * <li>{@link #TONE_DTMF_3}
     * <li>{@link #TONE_DTMF_4}
     * <li>{@link #TONE_DTMF_5}
     * <li>{@link #TONE_DTMF_6}
     * <li>{@link #TONE_DTMF_7}
     * <li>{@link #TONE_DTMF_8}
     * <li>{@link #TONE_DTMF_9}
     * <li>{@link #TONE_DTMF_A}
     * <li>{@link #TONE_DTMF_B}
     * <li>{@link #TONE_DTMF_C}
     * <li>{@link #TONE_DTMF_D}
     * <li>{@link #TONE_SUP_DIAL}
     * <li>{@link #TONE_SUP_BUSY}
     * <li>{@link #TONE_SUP_CONGESTION}
     * <li>{@link #TONE_SUP_RADIO_ACK}
     * <li>{@link #TONE_SUP_RADIO_NOTAVAIL}
     * <li>{@link #TONE_SUP_ERROR}
     * <li>{@link #TONE_SUP_CALL_WAITING}
     * <li>{@link #TONE_SUP_RINGTONE}
     * <li>{@link #TONE_PROP_BEEP}
     * <li>{@link #TONE_PROP_ACK}
     * <li>{@link #TONE_PROP_NACK}
     * <li>{@link #TONE_PROP_PROMPT}
     * <li>{@link #TONE_PROP_BEEP2}
     * <li>{@link #TONE_SUP_INTERCEPT}
     * <li>{@link #TONE_SUP_INTERCEPT_ABBREV}
     * <li>{@link #TONE_SUP_CONGESTION_ABBREV}
     * <li>{@link #TONE_SUP_CONFIRM}
     * <li>{@link #TONE_SUP_PIP}
     * <li>{@link #TONE_CDMA_DIAL_TONE_LITE}
     * <li>{@link #TONE_CDMA_NETWORK_USA_RINGBACK}
     * <li>{@link #TONE_CDMA_INTERCEPT}
     * <li>{@link #TONE_CDMA_ABBR_INTERCEPT}
     * <li>{@link #TONE_CDMA_REORDER}
     * <li>{@link #TONE_CDMA_ABBR_REORDER}
     * <li>{@link #TONE_CDMA_NETWORK_BUSY}
     * <li>{@link #TONE_CDMA_CONFIRM}
     * <li>{@link #TONE_CDMA_ANSWER}
     * <li>{@link #TONE_CDMA_NETWORK_CALLWAITING}
     * <li>{@link #TONE_CDMA_PIP}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_NORMAL}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_INTERGROUP}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_SP_PRI}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT3}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PING_RING}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT5}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT6}
     * <li>{@link #TONE_CDMA_CALL_SIGNAL_ISDN_PAT7}
     * <li>{@link #TONE_CDMA_HIGH_L}
     * <li>{@link #TONE_CDMA_MED_L}
     * <li>{@link #TONE_CDMA_LOW_L}
     * <li>{@link #TONE_CDMA_HIGH_SS}
     * <li>{@link #TONE_CDMA_MED_SS}
     * <li>{@link #TONE_CDMA_LOW_SS}
     * <li>{@link #TONE_CDMA_HIGH_SSL}
     * <li>{@link #TONE_CDMA_MED_SSL}
     * <li>{@link #TONE_CDMA_LOW_SSL}
     * <li>{@link #TONE_CDMA_HIGH_SS_2}
     * <li>{@link #TONE_CDMA_MED_SS_2}
     * <li>{@link #TONE_CDMA_LOW_SS_2}
     * <li>{@link #TONE_CDMA_HIGH_SLS}
     * <li>{@link #TONE_CDMA_MED_SLS}
     * <li>{@link #TONE_CDMA_LOW_SLS}
     * <li>{@link #TONE_CDMA_HIGH_S_X4}
     * <li>{@link #TONE_CDMA_MED_S_X4}
     * <li>{@link #TONE_CDMA_LOW_S_X4}
     * <li>{@link #TONE_CDMA_HIGH_PBX_L}
     * <li>{@link #TONE_CDMA_MED_PBX_L}
     * <li>{@link #TONE_CDMA_LOW_PBX_L}
     * <li>{@link #TONE_CDMA_HIGH_PBX_SS}
     * <li>{@link #TONE_CDMA_MED_PBX_SS}
     * <li>{@link #TONE_CDMA_LOW_PBX_SS}
     * <li>{@link #TONE_CDMA_HIGH_PBX_SSL}
     * <li>{@link #TONE_CDMA_MED_PBX_SSL}
     * <li>{@link #TONE_CDMA_LOW_PBX_SSL}
     * <li>{@link #TONE_CDMA_HIGH_PBX_SLS}
     * <li>{@link #TONE_CDMA_MED_PBX_SLS}
     * <li>{@link #TONE_CDMA_LOW_PBX_SLS}
     * <li>{@link #TONE_CDMA_HIGH_PBX_S_X4}
     * <li>{@link #TONE_CDMA_MED_PBX_S_X4}
     * <li>{@link #TONE_CDMA_LOW_PBX_S_X4}
     * <li>{@link #TONE_CDMA_ALERT_NETWORK_LITE}
     * <li>{@link #TONE_CDMA_ALERT_AUTOREDIAL_LITE}
     * <li>{@link #TONE_CDMA_ONE_MIN_BEEP}
     * <li>{@link #TONE_CDMA_KEYPAD_VOLUME_KEY_LITE}
     * <li>{@link #TONE_CDMA_PRESSHOLDKEY_LITE}
     * <li>{@link #TONE_CDMA_ALERT_INCALL_LITE}
     * <li>{@link #TONE_CDMA_EMERGENCY_RINGBACK}
     * <li>{@link #TONE_CDMA_ALERT_CALL_GUARD}
     * <li>{@link #TONE_CDMA_SOFT_ERROR_LITE}
     * <li>{@link #TONE_CDMA_CALLDROP_LITE}
     * <li>{@link #TONE_CDMA_NETWORK_BUSY_ONE_SHOT}
     * <li>{@link #TONE_CDMA_ABBR_ALERT}
     * <li>{@link #TONE_CDMA_SIGNAL_OFF}
     * </ul>
     * @see #ToneGenerator(int, int)
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.203 -0400", hash_original_method = "8EAA66237FD0D657A6089CD6D204D973", hash_generated_method = "D21A37F8C83D2EFC3CCA72F9E806CE49")
    
public boolean startTone(int toneType) {
        return startTone(toneType, -1);
    }

    /**
     * This method starts the playback of a tone of the specified type for the specified duration.
     * @param toneType   The type of tone generated @see {@link #startTone(int)}.
     * @param durationMs  The tone duration in milliseconds. If the tone is limited in time by definition,
     * the actual duration will be the minimum of durationMs and the defined tone duration. Setting durationMs to -1,
     * is equivalent to calling {@link #startTone(int)}.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.068 -0400", hash_original_method = "F753AB60830D7C8A33F2091CC5455863", hash_generated_method = "DC7059DF149C1A37B4C6A755465DCF7B")
    
    public boolean startTone(int toneType, int durationMs){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += toneType;
    	taintDouble += durationMs;
    	addTaint(taintDouble);
    
    	return ((taintDouble) == 1);
    }

    /**
     * This method stops the tone currently playing playback.
     * @see #ToneGenerator(int, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:59.555 -0400", hash_original_method = "DE1F7EDB373D887510AEE90FFA73BFA3", hash_generated_method = "89539093FB979FCD4FDD10C667AA550F")
    
    public void stopTone(){
    	//Formerly a native method
    }

    /**
     * Releases resources associated with this ToneGenerator object. It is good
     * practice to call this method when you're done using the ToneGenerator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:59.557 -0400", hash_original_method = "1E8C38EACEA1E94FE658824D01FD2A18", hash_generated_method = "278A7E53643DE73F8A80E1A85A107DD5")
    
    public void release(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:14:26.078 -0400", hash_original_method = "097066EF57BB064C231D14FA51E98EB9", hash_generated_method = "56EDBB818738D9870662876808D758BD")
    
    private final void native_setup(int streamType, int volume){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += streamType;
    	taintDouble += volume;
    	addTaint(taintDouble);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:21:59.564 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:15.218 -0400", hash_original_method = "3228EA20CE4FEF9678E1F1862B5AB446", hash_generated_method = "B426276F6755268DFF3429CB984C1F76")
    
@Override
    protected void finalize() { native_finalize(); } // accessed by native methods
}
