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
package org.apache.commons.net.nntp;

/***
 * NNTPReply stores a set of constants for NNTP reply codes.  To interpret
 * the meaning of the codes, familiarity with RFC 977 is assumed.
 * The mnemonic constant names are transcriptions from the code descriptions
 * of RFC 977.  For those who think in terms of the actual reply code values,
 * a set of CODE_NUM constants are provided where NUM is the numerical value
 * of the code.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class NNTPReply
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.360 -0500", hash_original_field = "6AA90F7420D1ECFBA88BD78FE174E9C9", hash_generated_field = "C6B840EFCD1D52FC873F1F6BE4E76DAB")


    public static final int CODE_100 = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.363 -0500", hash_original_field = "C31B46033013F5D77533C1F1B8CBCAD4", hash_generated_field = "87378D31AB55C2E1303A5D18A158DDB2")

    public static final int CODE_199 = 199;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.367 -0500", hash_original_field = "571AEF2654F55D6639C0349B9232E477", hash_generated_field = "355399EE1F0491B08B6DC64FB1815D76")

    public static final int CODE_200 = 200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.376 -0500", hash_original_field = "42EFB8461B158E8D609D4D1C0CDA8C89", hash_generated_field = "16638154936BD3D6AB7C9136238F76F9")

    public static final int CODE_201 = 201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.380 -0500", hash_original_field = "9158C7BEF266AAACB74135D9CF42E2A6", hash_generated_field = "9300CBC0A2C708125B325C4DBD145445")

    public static final int CODE_202 = 202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.383 -0500", hash_original_field = "738292E5B5E8F2031A6F27AFFF625535", hash_generated_field = "85929709AF48B23CB44AD049BE99DB8D")

    public static final int CODE_205 = 205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.389 -0500", hash_original_field = "E3D650CEF46B88A6570CBE70D82B8235", hash_generated_field = "5D8095CCEAE0CBD007731999A8EA3B83")

    public static final int CODE_211 = 211;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.395 -0500", hash_original_field = "E8DBCCF4AA75CF7CBD58DFE4F64F49EB", hash_generated_field = "5D6DA935D974049F959E1D775847A0C0")

    public static final int CODE_215 = 215;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.401 -0500", hash_original_field = "C106D3C647D5D91FA8F850ED10B54ADA", hash_generated_field = "D7559CB92A4ADBFF1D16B44DA1477E25")

    public static final int CODE_220 = 220;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.406 -0500", hash_original_field = "483D53DEAB77319430A198C4EF18BD16", hash_generated_field = "78D74083B04057FF44310CD509B2E0CF")

    public static final int CODE_221 = 221;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.414 -0500", hash_original_field = "5BB41D5C7E00D85A378DCC0F44842F9F", hash_generated_field = "D6D4E2F50289D6433433ACDDD78B0578")

    public static final int CODE_222 = 222;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.418 -0500", hash_original_field = "C6F9847BD1193ED9B94BA749A8512FC9", hash_generated_field = "960E597C6A3291BB43953539DE982C8A")

    public static final int CODE_223 = 223;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.422 -0500", hash_original_field = "58E8C6A5F50405C9043CD888F3922F3C", hash_generated_field = "ED6326893C1F93E3E623728F173BCA41")

    public static final int CODE_230 = 230;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.425 -0500", hash_original_field = "4C9E73AB950E61460F40494DDC865FF2", hash_generated_field = "BC612CB051DB2478D810A7A9F879722B")

    public static final int CODE_231 = 231;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.429 -0500", hash_original_field = "2B8D40C1105D381A71438842A469BA90", hash_generated_field = "AB4535D80D44D6F016DFCD110949189A")

    public static final int CODE_235 = 235;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.434 -0500", hash_original_field = "07971919FC0362FA273018D078582A3C", hash_generated_field = "6EA4C85D1DAC6FC5789F52B62796D025")

    public static final int CODE_240 = 240;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.437 -0500", hash_original_field = "6F90082DF98A7C9C8EDFAC2401EDDA62", hash_generated_field = "5AD0936877DA3770F7156D24A232AA2D")

    public static final int CODE_281 = 281;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.442 -0500", hash_original_field = "A56AFD92E700A5601AA9D5246119B581", hash_generated_field = "FA61B17B4DF40F698720E46417ECD795")

    public static final int CODE_335 = 335;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.446 -0500", hash_original_field = "5D9CECBC0F79E8CB021B31C2BBEB2165", hash_generated_field = "DBDB64875DF12E8D64D24C5A9895F61E")

    public static final int CODE_340 = 340;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.450 -0500", hash_original_field = "8BEFA03BBD570022D1E35D225BFBDD47", hash_generated_field = "C89EFF747517B117BE4C7EE93D6ECD13")

    public static final int CODE_381 = 381;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.460 -0500", hash_original_field = "00FDEB2368A0FBB533C96B2104A4678B", hash_generated_field = "E4D70AD3C5E3190A59C993784884F999")

    public static final int CODE_400 = 400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.464 -0500", hash_original_field = "839C538254BF8242D0A0E36E3011FAC5", hash_generated_field = "DD745C7A6F30979A92BA379777D8BA21")

    public static final int CODE_408 = 408;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.467 -0500", hash_original_field = "B20D7CA1FD9B100028A894A6074D0EAA", hash_generated_field = "7D0E27EEDEC8FBCD3A58026EA7D07CCE")

    public static final int CODE_411 = 411;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.471 -0500", hash_original_field = "668C2FF621ABD255EBB214CFD0DF3E4E", hash_generated_field = "E6977952E580449496D0F6A5F996DD79")

    public static final int CODE_412 = 412;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.474 -0500", hash_original_field = "E9E13516F29F3A67095BF39B599A92BE", hash_generated_field = "805A1823D1281C72745DCA83DFBCD21E")

    public static final int CODE_420 = 420;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.478 -0500", hash_original_field = "2677CA72A49ED4F8F54BAADD883EB1DD", hash_generated_field = "B0DBDFF7A6B97833065F108B5B4BAA9F")

    public static final int CODE_421 = 421;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.482 -0500", hash_original_field = "5E2303D7C084973866535107D81F29C2", hash_generated_field = "7B7F50460523089C5716057E6CCC80D9")

    public static final int CODE_422 = 422;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.485 -0500", hash_original_field = "7FBE691AD6A217A9FFE00CC5BEF4D5E6", hash_generated_field = "01D1674648DB79ABB98901D15500C9BF")

    public static final int CODE_423 = 423;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.489 -0500", hash_original_field = "2C677CEE9D882B1FD29F898D21DA32D4", hash_generated_field = "E30BE2187167BB307DBE4B79ED57F3D9")

    public static final int CODE_430 = 430;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.493 -0500", hash_original_field = "BD8965915B35F5CEBFDC7122785C154B", hash_generated_field = "411441BE8129E76700EADEA657E13DFC")

    public static final int CODE_435 = 435;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.496 -0500", hash_original_field = "A7A559B3780A2324A8DD73EF082E46F4", hash_generated_field = "9278CFE602FF1DEE21DD645FD2FB1633")

    public static final int CODE_436 = 436;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.500 -0500", hash_original_field = "A125D57258F3733969E050808A3FE97D", hash_generated_field = "AA42C360E6683EB56EE153F351418901")

    public static final int CODE_437 = 437;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.503 -0500", hash_original_field = "FFECB1150BF87EB6FCB0325E81F509F6", hash_generated_field = "9CE8705AEAFD0E77A7414E15BB671FA1")

    public static final int CODE_440 = 440;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.507 -0500", hash_original_field = "9EEC0452C5282B5CB29645F7A9F14D1B", hash_generated_field = "0B088E19ED671BBF6327DF51128C7642")

    public static final int CODE_441 = 441;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.510 -0500", hash_original_field = "FC5DE0622EC79FADE960CFD3E7315768", hash_generated_field = "690EAB031B039B54A3F8BAC41C1B22B4")

    public static final int CODE_482 = 482;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.514 -0500", hash_original_field = "4510A7276D8B5445CF8A2557B0D1BE57", hash_generated_field = "14A794F72674553D840D67B5D0E8CF4F")

    public static final int CODE_500 = 500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.522 -0500", hash_original_field = "00839B80AC7C8440B849546C3855F420", hash_generated_field = "A0EF0FBFACE763F016E2344F7928B0EC")

    public static final int CODE_501 = 501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.525 -0500", hash_original_field = "BCD866A2D21BC79EDAC44F02AA613856", hash_generated_field = "809F555CF8711AA7691D752F89E97D9B")

    public static final int CODE_502 = 502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.529 -0500", hash_original_field = "461924BB26FC4C8854C5013A63FF9913", hash_generated_field = "6FC222B1F20DCBDE96F135EEFEC37A36")

    public static final int CODE_503 = 503;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.532 -0500", hash_original_field = "90E5A8885CED402661553EBFE58C1F44", hash_generated_field = "F1FB528F5904DD7E1F16C384B5FBD3C4")


    public static final int HELP_TEXT_FOLLOWS                = CODE_100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.536 -0500", hash_original_field = "94DAAD06DEFF59FE15B9A404E6632094", hash_generated_field = "52C285DF6E89BBD463B034FAB12ED4E7")

    public static final int DEBUG_OUTPUT                     = CODE_199;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.539 -0500", hash_original_field = "D2F437F4C64E685081D6E462163A8C03", hash_generated_field = "06F1E40B5374DAC45853EB9A3D966E9B")

    public static final int SERVER_READY_POSTING_ALLOWED     = CODE_200;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.543 -0500", hash_original_field = "D1B23894132994B6AD6B65DDFA80A60F", hash_generated_field = "2BF1AB073EF3A808E2E5078FF0245510")

    public static final int SERVER_READY_POSTING_NOT_ALLOWED = CODE_201;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.546 -0500", hash_original_field = "28C8304D3D43CE97D777967F0CE10E94", hash_generated_field = "2288920B9EA4B5FE50F78C60D4B32312")

    public static final int SLAVE_STATUS_NOTED               = CODE_202;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.550 -0500", hash_original_field = "BDFD0269A89BBB131372971D8A9BA724", hash_generated_field = "CD46222A5ECEFC5805EC8D009C3EC5D2")

    public static final int CLOSING_CONNECTION               = CODE_205;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.554 -0500", hash_original_field = "64FE5A3D4512D84D98077A8BD427A8D9", hash_generated_field = "CC836E7917472CDD5F9B62E15506A845")

    public static final int GROUP_SELECTED                   = CODE_211;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.557 -0500", hash_original_field = "3519FC8AAE79F8BB7EEAD13A957D4FF5", hash_generated_field = "22F4DCCD4F5FB20EE596FF3331AE52F9")

    public static final int ARTICLE_RETRIEVED_HEAD_AND_BODY_FOLLOW = CODE_220;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.561 -0500", hash_original_field = "9402A2E1245B256727B3E38E0CE228C3", hash_generated_field = "24BD115379E51B350436A7E0AA23525B")

    public static final int ARTICLE_RETRIEVED_HEAD_FOLLOWS = CODE_221;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.564 -0500", hash_original_field = "F000036DE3A25EA010F061FFEE9BDDE1", hash_generated_field = "536282E56557216CB82782CD9E67EE3F")

    public static final int ARTICLE_RETRIEVED_BODY_FOLLOWS = CODE_222;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.568 -0500", hash_original_field = "8000A6084342B003EEB242A5CDA41C8D", hash_generated_field = "8E1D614A2891FAE26D68765F6BAF52D1")

    public static final int
      ARTICLE_RETRIEVED_REQUEST_TEXT_SEPARATELY = CODE_223;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.571 -0500", hash_original_field = "60FD84BD6AA6A3F2642D4FD158C3A7B1", hash_generated_field = "A344FDF8CF5688EF62AC0D925B9AD09A")

    public static final int ARTICLE_LIST_BY_MESSAGE_ID_FOLLOWS = CODE_230;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.574 -0500", hash_original_field = "90B382C5DCEA803CC206DDA93E0AF78B", hash_generated_field = "ED06B1BD6BE5842EAC8C2DE76FFD545A")

    public static final int NEW_NEWSGROUP_LIST_FOLLOWS         = CODE_231;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.587 -0500", hash_original_field = "781AA483A3699CBC3022B86F184F3373", hash_generated_field = "0B41163439BA3B638D613261D46774A8")

    public static final int ARTICLE_TRANSFERRED_OK             = CODE_235;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.592 -0500", hash_original_field = "64B26F14CEE357FD88E512D3EF69A085", hash_generated_field = "5F3B42C2D382216A57C4A25F421D542E")

    public static final int ARTICLE_POSTED_OK                  = CODE_240;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.596 -0500", hash_original_field = "B73BF89402DC0397C9897DFFC47570A4", hash_generated_field = "5DF18E4F44436105337074D41F511D4E")

    public static final int AUTHENTICATION_ACCEPTED            = CODE_281;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.600 -0500", hash_original_field = "90EFBA38DB2583B856713D48210609C6", hash_generated_field = "F0ACD9730B178250956D66333CEA8653")

    public static final int SEND_ARTICLE_TO_TRANSFER           = CODE_335;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.604 -0500", hash_original_field = "D696EEA6A0F1789FD7BB0682808E2920", hash_generated_field = "943FF0DEA07DD30B2477DD9A85BAC1EE")

    public static final int SEND_ARTICLE_TO_POST               = CODE_340;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.608 -0500", hash_original_field = "EF6200D278119A61E3E4B1C880986C06", hash_generated_field = "2F86865C56E472F9B299073B7F99D1A4")

    public static final int MORE_AUTH_INFO_REQUIRED            = CODE_381;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.613 -0500", hash_original_field = "FFD1216E5F70AD45401835757BC6E0D5", hash_generated_field = "E1A6BF65E75D5C854EDBD0DBF796C017")

    public static final int SERVICE_DISCONTINUED               = CODE_400;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.618 -0500", hash_original_field = "EB8B7FE2616E4DF4B04FE507F9A815AA", hash_generated_field = "411C09264CF6A99057B1054F051C794F")

    public static final int NO_SUCH_NEWSGROUP                  = CODE_411;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.622 -0500", hash_original_field = "564E4638D1E988534F743DDD4085DFDA", hash_generated_field = "F49E5A4AC17D0C2336ED626A4B1E9853")

    public static final int AUTHENTICATION_REQUIRED            = CODE_408;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.626 -0500", hash_original_field = "D74CB9FDFDB6771CEB26B2D2406472C0", hash_generated_field = "41EEDF2101E88A6A662AE69582580D46")

    public static final int NO_NEWSGROUP_SELECTED              = CODE_412;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.630 -0500", hash_original_field = "D6252DBDDBA177F75A98AAAC0CAF34D7", hash_generated_field = "1EA5C5AE827D3894ADC4E657A3674D2E")

    public static final int NO_CURRENT_ARTICLE_SELECTED        = CODE_420;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.634 -0500", hash_original_field = "142ACB20875FE729DC7643C0FA0A1FD2", hash_generated_field = "7605E5B65CB6040AC6389035C40CD441")

    public static final int NO_NEXT_ARTICLE                    = CODE_421;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.640 -0500", hash_original_field = "D17FE48159B152CBD43F134582CFEEBA", hash_generated_field = "1DE235EFFA2E127EEA627FCD8FAD8355")

    public static final int NO_PREVIOUS_ARTICLE                = CODE_422;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.645 -0500", hash_original_field = "63108C9B8DC286AE2EFE125B86A6A0E2", hash_generated_field = "775078B833D1FC944DC7038EDAAB37B9")

    public static final int NO_SUCH_ARTICLE_NUMBER             = CODE_423;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.651 -0500", hash_original_field = "B16E324A46E17CFD46DE0CA7E09CB522", hash_generated_field = "7B8A2E0823641AA6AA1E7FE3F9F32949")

    public static final int NO_SUCH_ARTICLE_FOUND              = CODE_430;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.660 -0500", hash_original_field = "302350DF2593300B2ECC3650EDA1F4DA", hash_generated_field = "E60ABFB96D084D265F7FE8488541EF85")

    public static final int ARTICLE_NOT_WANTED                 = CODE_435;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.666 -0500", hash_original_field = "57831DF7DE8662CC7543A71CD3CB7B5A", hash_generated_field = "CBD2C2A610A15413F5A4D629C5800AD7")

    public static final int TRANSFER_FAILED                    = CODE_436;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.673 -0500", hash_original_field = "ACD31FFBFC02C1F1F50E7CF90DF26244", hash_generated_field = "7608F235613225F5396EE4F26F88186E")

    public static final int ARTICLE_REJECTED                   = CODE_437;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.679 -0500", hash_original_field = "507099C1C1ACC93C45083B0B54D8DB09", hash_generated_field = "79CB53F8F64ED69835B69358430D493D")

    public static final int POSTING_NOT_ALLOWED                = CODE_440;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.685 -0500", hash_original_field = "6220D5FE03349E8B11A4875AFE640824", hash_generated_field = "B2290263BC3033108D521BD217D88D42")

    public static final int POSTING_FAILED                     = CODE_441;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.691 -0500", hash_original_field = "1303D8DE7189E539F6B7AFDF30F9AF6C", hash_generated_field = "B1DC82EBD0145915D38CB0FAAF2E8164")

    public static final int AUTHENTICATION_REJECTED            = CODE_482;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.695 -0500", hash_original_field = "ABB68DB406CE35111DCFEAB83D37D72A", hash_generated_field = "C6EE60EB3D9DC7551B087D88726F50F8")

    public static final int COMMAND_NOT_RECOGNIZED             = CODE_500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.699 -0500", hash_original_field = "B20CA800678993672289C91F7CBE421C", hash_generated_field = "7273A75B1FBE13D34C2D0A618A02D354")

    public static final int COMMAND_SYNTAX_ERROR               = CODE_501;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.703 -0500", hash_original_field = "7FDB50233D1659828C3D802C486D66A7", hash_generated_field = "F4969E3F20E690ADDD366FBE9BC2B60B")

    public static final int PERMISSION_DENIED                  = CODE_502;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.710 -0500", hash_original_field = "0A9857DA2ED38E73B3DE87C6738D59A4", hash_generated_field = "71F1210B52A44F78A60607F25ADAEC44")

    public static final int PROGRAM_FAULT                      = CODE_503;

    /***
     * Determine if a reply code is an informational response.  All
     * codes beginning with a 1 are positive informational responses.
     * Informational responses are used to provide human readable
     * information such as help text.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is an informational response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.722 -0500", hash_original_method = "023476721C0A94B504CC866383D1773A", hash_generated_method = "AA4C89CED7ED4B3C6AD226E2C77331C5")
    
public static boolean isInformational(int reply)
    {
        return (reply >= 100 && reply < 200);
    }

    /***
     * Determine if a reply code is a positive completion response.  All
     * codes beginning with a 2 are positive completion responses.
     * The NNTP server will send a positive completion response on the final
     * successful completion of a command.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a postive completion response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.728 -0500", hash_original_method = "54F56FCB0FE10A11F3FC3B4B0BA615D4", hash_generated_method = "E5158DEF50508063A3FAA4CB78999168")
    
public static boolean isPositiveCompletion(int reply)
    {
        return (reply >= 200 && reply < 300);
    }

    /***
     * Determine if a reply code is a positive intermediate response.  All
     * codes beginning with a 3 are positive intermediate responses.
     * The NNTP server will send a positive intermediate response on the
     * successful completion of one part of a multi-part command or
     * sequence of commands.  For example, after a successful POST command,
     * a positive intermediate response will be sent to indicate that the
     * server is ready to receive the article to be posted.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a postive intermediate response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.733 -0500", hash_original_method = "C8C1F446DBB41359AB2C72DE65947E17", hash_generated_method = "87AB1F2A75B0DA527C4EB5550803BD97")
    
public static boolean isPositiveIntermediate(int reply)
    {
        return (reply >= 300 && reply < 400);
    }

    /***
     * Determine if a reply code is a negative transient response.  All
     * codes beginning with a 4 are negative transient responses.
     * The NNTP server will send a negative transient response on the
     * failure of a correctly formatted command that could not be performed
     * for some reason.  For example, retrieving an article that does not
     * exist will result in a negative transient response.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a negative transient response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.739 -0500", hash_original_method = "DC5C6AC2DFC5703884925E95380CED47", hash_generated_method = "1DE3EAECC7BBF780F5F9D829D9A6954B")
    
public static boolean isNegativeTransient(int reply)
    {
        return (reply >= 400 && reply < 500);
    }

    /***
     * Determine if a reply code is a negative permanent response.  All
     * codes beginning with a 5 are negative permanent responses.
     * The NNTP server will send a negative permanent response when
     * it does not implement a command, a command is incorrectly formatted,
     * or a serious program error occurs.
     * <p>
     * @param reply  The reply code to test.
     * @return True if a reply code is a negative permanent response, false
     *         if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.750 -0500", hash_original_method = "7730219D57FA624E42FCB8EA28B30401", hash_generated_method = "304A07393478892767F1C29F32540023")
    
public static boolean isNegativePermanent(int reply)
    {
        return (reply >= 500 && reply < 600);
    }

    // Cannot be instantiated

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:07.716 -0500", hash_original_method = "D768CE8026EA9A8093F7E74AA979B58B", hash_generated_method = "31403F4926719D14741A9A8455FD1EDC")
    
private NNTPReply()
    {}

}

/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
