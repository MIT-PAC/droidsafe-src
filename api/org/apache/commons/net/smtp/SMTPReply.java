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
package org.apache.commons.net.smtp;

/***
 * SMTPReply stores a set of constants for SMTP reply codes.  To interpret
 * the meaning of the codes, familiarity with RFC 821 is assumed.
 * The mnemonic constant names are transcriptions from the code descriptions
 * of RFC 821.  For those who think in terms of the actual reply code values,
 * a set of CODE_NUM constants are provided where NUM is the numerical value
 * of the code.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class SMTPReply
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.529 -0500", hash_original_field = "E3D650CEF46B88A6570CBE70D82B8235", hash_generated_field = "5D8095CCEAE0CBD007731999A8EA3B83")


    public static final int CODE_211 = 211;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.534 -0500", hash_original_field = "D2B3448DDFC300BC580FA5D8E26EBF81", hash_generated_field = "FA719C58E80A8E032657CF0237CC345C")

    public static final int CODE_214 = 214;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.538 -0500", hash_original_field = "E8DBCCF4AA75CF7CBD58DFE4F64F49EB", hash_generated_field = "5D6DA935D974049F959E1D775847A0C0")

    public static final int CODE_215 = 215;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.542 -0500", hash_original_field = "C106D3C647D5D91FA8F850ED10B54ADA", hash_generated_field = "D7559CB92A4ADBFF1D16B44DA1477E25")

    public static final int CODE_220 = 220;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.549 -0500", hash_original_field = "483D53DEAB77319430A198C4EF18BD16", hash_generated_field = "78D74083B04057FF44310CD509B2E0CF")

    public static final int CODE_221 = 221;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.560 -0500", hash_original_field = "E035DE4CB107776C5A66F3F80C8F94C9", hash_generated_field = "25F5B7AF250D597B6A4DE2B1EC7B974C")

    public static final int CODE_250 = 250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.566 -0500", hash_original_field = "F948F8C6F3B4D8B7C59A40C3609BACF4", hash_generated_field = "99ED119A10D20D7190722983B79066FD")

    public static final int CODE_251 = 251;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.571 -0500", hash_original_field = "7FDF69E81A29A23B00705A402FBB26C8", hash_generated_field = "91D81011D6D8210BB5BFE3DA04083E6D")

    public static final int CODE_354 = 354;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.575 -0500", hash_original_field = "2677CA72A49ED4F8F54BAADD883EB1DD", hash_generated_field = "B0DBDFF7A6B97833065F108B5B4BAA9F")

    public static final int CODE_421 = 421;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.579 -0500", hash_original_field = "47EBC358FA5797402AE0D09D7C84170A", hash_generated_field = "DD10C917536555468C5269D8E79C6D0D")

    public static final int CODE_450 = 450;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.583 -0500", hash_original_field = "C24EB387C3AB57C4D4039575B64E8EDC", hash_generated_field = "B19FF6AD110A86E6409B632B58EBC689")

    public static final int CODE_451 = 451;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.586 -0500", hash_original_field = "9A4F09BF5B211EA67CA27D4446510259", hash_generated_field = "0983BDE56232A7FD410DE359D9ACAAE9")

    public static final int CODE_452 = 452;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.590 -0500", hash_original_field = "4510A7276D8B5445CF8A2557B0D1BE57", hash_generated_field = "14A794F72674553D840D67B5D0E8CF4F")

    public static final int CODE_500 = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.594 -0500", hash_original_field = "00839B80AC7C8440B849546C3855F420", hash_generated_field = "A0EF0FBFACE763F016E2344F7928B0EC")

    public static final int CODE_501 = 501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.598 -0500", hash_original_field = "BCD866A2D21BC79EDAC44F02AA613856", hash_generated_field = "809F555CF8711AA7691D752F89E97D9B")

    public static final int CODE_502 = 502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.601 -0500", hash_original_field = "461924BB26FC4C8854C5013A63FF9913", hash_generated_field = "6FC222B1F20DCBDE96F135EEFEC37A36")

    public static final int CODE_503 = 503;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.606 -0500", hash_original_field = "E737D9D215EF7D83028C0587BFDA6F42", hash_generated_field = "BFAFF0FF71D3479F100C627402B24857")

    public static final int CODE_504 = 504;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.610 -0500", hash_original_field = "F163F1713A10F3CC43D8F38ED8647495", hash_generated_field = "532E896737651BD3BE837883F91CC551")

    public static final int CODE_550 = 550;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.614 -0500", hash_original_field = "8FFA4A44FBF42396A176665C36D4BA23", hash_generated_field = "E7405034372D3E88BE8BF6AAB10CAC33")

    public static final int CODE_551 = 551;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.618 -0500", hash_original_field = "AA4D608DFA89D4F4CA7D90A7D9F0AF43", hash_generated_field = "6FA1550CF2CAC4FA57A81A5AC7E20895")

    public static final int CODE_552 = 552;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.622 -0500", hash_original_field = "B74CADCC408FF1B14B85D2DCB1F7D156", hash_generated_field = "178309B60B95BFA46A2874323345883C")

    public static final int CODE_553 = 553;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.626 -0500", hash_original_field = "CB4E86C90FCB6D32659D43D174BDE81A", hash_generated_field = "C1E3A112633D2887CE1323CD2C6B2F7E")

    public static final int CODE_554 = 554;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.634 -0500", hash_original_field = "B926802F04D9A4A06A67DF554E257CCA", hash_generated_field = "1346C62E29B5510B6F7F07A70ADBB025")


    public static final int SYSTEM_STATUS = CODE_211;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.638 -0500", hash_original_field = "0FE19E7AB3A10EEABA74107255D1A01F", hash_generated_field = "1048B54A8D726FF685D6715EF8AC47DF")

    public static final int HELP_MESSAGE = CODE_214;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.641 -0500", hash_original_field = "2C1E53CF7ADE49BCB41B74D9E15DF9DC", hash_generated_field = "FE6290DAE1F97F4651C97BEA127CDE74")

    public static final int SERVICE_READY = CODE_220;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.645 -0500", hash_original_field = "879A15DF09ECC9B602B41D5A6CC783FD", hash_generated_field = "4E7DB20064A1ED90E0FCB17E63167A2E")

    public static final int SERVICE_CLOSING_TRANSMISSION_CHANNEL = CODE_221;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.648 -0500", hash_original_field = "045E5319CDDBE59F61BD5BB59433F6B5", hash_generated_field = "89EFECBFDEF4D661B6A288695DDE96FA")

    public static final int ACTION_OK = CODE_250;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.654 -0500", hash_original_field = "766F0838EE17E2C8EEF420F7D06F63EB", hash_generated_field = "E047388B265F2E668897DB9F9FD957F9")

    public static final int USER_NOT_LOCAL_WILL_FORWARD = CODE_251;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.657 -0500", hash_original_field = "33DF8C29834D54A1E700B0ACB125A64B", hash_generated_field = "EF7116429B0F378B2F4B62BBD76E61E4")

    public static final int START_MAIL_INPUT = CODE_354;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.661 -0500", hash_original_field = "7041C55E24803C5A24FDDADC72C0C7A9", hash_generated_field = "16DE6E486F8E39B15359BEC9C1B6DBFC")

    public static final int SERVICE_NOT_AVAILABLE = CODE_421;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.665 -0500", hash_original_field = "A606EEBDD43A95AEA3FE89B234C4592D", hash_generated_field = "59595018D0C7D6729C79005C6D4404F0")

    public static final int ACTION_NOT_TAKEN = CODE_450;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.668 -0500", hash_original_field = "01BB5E0086BEB9C7CBBACCB4D6A04145", hash_generated_field = "D34D2F0E301A683CCB9FD98C857B11DF")

    public static final int ACTION_ABORTED = CODE_451;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.673 -0500", hash_original_field = "853F792752627AF0B1F0B18AC25DDC43", hash_generated_field = "D46DF003346BBB97A6C09507617921D2")

    public static final int INSUFFICIENT_STORAGE = CODE_452;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.676 -0500", hash_original_field = "477161036311BA4AC3C4F6F0CA8E1AF2", hash_generated_field = "2E0DBA232E4D029910BAE64214DA41E2")

    public static final int UNRECOGNIZED_COMMAND = CODE_500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.680 -0500", hash_original_field = "10C2163938FDF2C505D83A6236A38724", hash_generated_field = "E40C847F493DA45C0A625A2F1656D128")

    public static final int SYNTAX_ERROR_IN_ARGUMENTS = CODE_501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.684 -0500", hash_original_field = "B51E4543AE75A2A59F07AA4942B6F2FE", hash_generated_field = "3E422A45B62FE86686A6F94ADE2B5CD0")

    public static final int COMMAND_NOT_IMPLEMENTED = CODE_502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.688 -0500", hash_original_field = "6A93C3C25CE9DF08D1A4B8DD54DC7019", hash_generated_field = "DBED9814DAADFF96F8F30BA9933B075A")

    public static final int BAD_COMMAND_SEQUENCE = CODE_503;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.691 -0500", hash_original_field = "0808ECFA86417A1DE6A9424146E3F103", hash_generated_field = "182CB6B2DAC66DC66C9C774BA24249B5")

    public static final int COMMAND_NOT_IMPLEMENTED_FOR_PARAMETER = CODE_504;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.701 -0500", hash_original_field = "DE8E239DC071141461F7065954D9BA09", hash_generated_field = "AE1DBF66702C1680614BB84174824926")

    public static final int MAILBOX_UNAVAILABLE = CODE_550;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.705 -0500", hash_original_field = "5166439CE5B18303108FBD61BDAC7B5E", hash_generated_field = "C10A37582065FC8F37F13F5793885B10")

    public static final int USER_NOT_LOCAL = CODE_551;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.708 -0500", hash_original_field = "104E1F2B94EB070B678B06BF04979CB0", hash_generated_field = "03350DA98EF3C09468AA87EC3738BABF")

    public static final int STORAGE_ALLOCATION_EXCEEDED = CODE_552;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.712 -0500", hash_original_field = "AE273255B8DEE8D4AD90747DB3A7D54A", hash_generated_field = "153CABEE4C6B9EFCF3E604B2374FF697")

    public static final int MAILBOX_NAME_NOT_ALLOWED = CODE_553;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.716 -0500", hash_original_field = "CED9D8A5EC3AF317151A0906D6CD2E72", hash_generated_field = "F1C85BBB0B66B3C9B16570FB7F57CF5B")

    public static final int TRANSACTION_FAILED = CODE_554;

    /***
     * Determine if a reply code is a positive preliminary response.  All
     * codes beginning with a 1 are positive preliminary responses.
     * Postitive preliminary responses are used to indicate tentative success.
     * No further commands can be issued to the SMTP server after a positive
     * preliminary response until a follow up response is received from the
     * server.
     * <p>
     * <b> Note: </b> <em> No SMTP commands defined in RFC 822 provide this
     * type of reply. </em>
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a postive preliminary response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.723 -0500", hash_original_method = "8808742E73FD3FA546FD7E08E34E1555", hash_generated_method = "4A32F7BAE69E0E9EB8F923C70A16AC18")
    
public static boolean isPositivePreliminary(int reply)
    {
        return (reply >= 100 && reply < 200);
    }

    /***
     * Determine if a reply code is a positive completion response.  All
     * codes beginning with a 2 are positive completion responses.
     * The SMTP server will send a positive completion response on the final
     * successful completion of a command.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a postive completion response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.727 -0500", hash_original_method = "54F56FCB0FE10A11F3FC3B4B0BA615D4", hash_generated_method = "E5158DEF50508063A3FAA4CB78999168")
    
public static boolean isPositiveCompletion(int reply)
    {
        return (reply >= 200 && reply < 300);
    }

    /***
     * Determine if a reply code is a positive intermediate response.  All
     * codes beginning with a 3 are positive intermediate responses.
     * The SMTP server will send a positive intermediate response on the
     * successful completion of one part of a multi-part sequence of
     * commands.  For example, after a successful DATA command, a positive
     * intermediate response will be sent to indicate that the server is
     * ready to receive the message data.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a postive intermediate response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.731 -0500", hash_original_method = "C8C1F446DBB41359AB2C72DE65947E17", hash_generated_method = "87AB1F2A75B0DA527C4EB5550803BD97")
    
public static boolean isPositiveIntermediate(int reply)
    {
        return (reply >= 300 && reply < 400);
    }

    /***
     * Determine if a reply code is a negative transient response.  All
     * codes beginning with a 4 are negative transient responses.
     * The SMTP server will send a negative transient response on the
     * failure of a command that can be reattempted with success.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a negative transient response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.734 -0500", hash_original_method = "DC5C6AC2DFC5703884925E95380CED47", hash_generated_method = "1DE3EAECC7BBF780F5F9D829D9A6954B")
    
public static boolean isNegativeTransient(int reply)
    {
        return (reply >= 400 && reply < 500);
    }

    /***
     * Determine if a reply code is a negative permanent response.  All
     * codes beginning with a 5 are negative permanent responses.
     * The SMTP server will send a negative permanent response on the
     * failure of a command that cannot be reattempted with success.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a negative permanent response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.738 -0500", hash_original_method = "7730219D57FA624E42FCB8EA28B30401", hash_generated_method = "304A07393478892767F1C29F32540023")
    
public static boolean isNegativePermanent(int reply)
    {
        return (reply >= 500 && reply < 600);
    }

    // Cannot be instantiated
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:01.719 -0500", hash_original_method = "DFDBDCF3FC4B384EB118FCC808E12741", hash_generated_method = "9F880FB78080BC21BCBB0CC3E63B7555")
    
private SMTPReply()
    {}

}
