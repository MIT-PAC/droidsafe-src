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
 * Copyright (C) 2010 The Android Open Source Project
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.mtp;

/**
 * A class containing constants in the MTP and PTP specifications.
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class MtpConstants {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.732 -0400", hash_original_field = "C2842F002BBAEBF328EC2372BC784572", hash_generated_field = "FE85DFF7AF17B9FB6E345DDCFCC1ADE0")

    /** @hide */
    public static final int TYPE_UNDEFINED = 0x0000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.733 -0400", hash_original_field = "056D8405C8780CE6FEC8CC84B67A6F02", hash_generated_field = "8D4BD54A36EF735CDFCCEA6F53BF60F0")

    public static final int TYPE_INT8 = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.735 -0400", hash_original_field = "59B9B6EA1CA44A85E53C5F6C62DE7E53", hash_generated_field = "734EF38ED5F2ADFC087E3D0909F3D757")

    public static final int TYPE_UINT8 = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.737 -0400", hash_original_field = "5119F918FD3474B42A407CB9F3CB2278", hash_generated_field = "C6582708F588B4EBCE9126BC5E1DB747")

    public static final int TYPE_INT16 = 0x0003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.739 -0400", hash_original_field = "C6ADA5408C7EBC1013D2F085199FC454", hash_generated_field = "8AAF0223836132E8BA0C1BF7BB0A3555")

    public static final int TYPE_UINT16 = 0x0004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.740 -0400", hash_original_field = "6731A68C6F7BF2C4FF3B53B00DC783B9", hash_generated_field = "AC8C531253356942EA99E4EF1672A692")

    public static final int TYPE_INT32 = 0x0005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.743 -0400", hash_original_field = "7E24EA129355FFF096F415A8C6181C97", hash_generated_field = "50CACC602019A5CCA62736332101281B")

    public static final int TYPE_UINT32 = 0x0006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.745 -0400", hash_original_field = "ACD15AE053D494F2539EA3220B19C3D0", hash_generated_field = "B72A055A59E29446CE790C9FE36D1CB5")

    public static final int TYPE_INT64 = 0x0007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.746 -0400", hash_original_field = "1BDED0BC7814C8D2DAEC771AA88354C2", hash_generated_field = "9096CE97A62D5924C1A53336860461D5")

    public static final int TYPE_UINT64 = 0x0008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.748 -0400", hash_original_field = "A90BB9D206B031E71C4CE7B35827C745", hash_generated_field = "4777E6F477A0BADE1EE6A943EBBC5EAE")

    public static final int TYPE_INT128 = 0x0009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.750 -0400", hash_original_field = "98271EFA37598DBB4C771E44E1867595", hash_generated_field = "316B98C3BE74F547E53ADB531543161F")

    public static final int TYPE_UINT128 = 0x000A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.751 -0400", hash_original_field = "0A17FAC741FC750F990E20A2CCA074F8", hash_generated_field = "B7DAF5CB2C48F58C452EE12A81A2325A")

    public static final int TYPE_AINT8 = 0x4001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.753 -0400", hash_original_field = "CCF23E4A14FD9C221532D26E1852B3D6", hash_generated_field = "C7F77D2054B2B79F3CD74B7EEE0D9E19")

    public static final int TYPE_AUINT8 = 0x4002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.755 -0400", hash_original_field = "79303E1C79B4FEE92321F34B6BD600F3", hash_generated_field = "D98A3687586C23B5513ABA46C99DA88C")

    public static final int TYPE_AINT16 = 0x4003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.757 -0400", hash_original_field = "3DA0145CD1D98490CACA1AC634C6B92C", hash_generated_field = "B2BF5664DCD35AE78624E079AE36D616")

    public static final int TYPE_AUINT16 = 0x4004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.758 -0400", hash_original_field = "08BE3E77F7FE3914F70479DBA08BBAB6", hash_generated_field = "6FC88691D26D50FC1F125FC603873507")

    public static final int TYPE_AINT32 = 0x4005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.760 -0400", hash_original_field = "ECBCBB98E61B6D175C72209F3D831402", hash_generated_field = "AECDFE15E1AF991DF3A5D2DD82953BAD")

    public static final int TYPE_AUINT32 = 0x4006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.762 -0400", hash_original_field = "88B495CABB62C62DA3504E59E9A10A60", hash_generated_field = "3EEDE3B4FDC3837BF6C6A13FDEA9C781")

    public static final int TYPE_AINT64 = 0x4007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.764 -0400", hash_original_field = "425EE7F0802F9A8DBE50A47F393E06D2", hash_generated_field = "393535DB830465339E9284CEC9981225")

    public static final int TYPE_AUINT64 = 0x4008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.765 -0400", hash_original_field = "F9BDDBF0AD7979E66376DE7749877416", hash_generated_field = "8DDA16267F83AB763BFB722FEADE77EB")

    public static final int TYPE_AINT128 = 0x4009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.767 -0400", hash_original_field = "14D76CB1E1C8487EB5C2716CF62DDD28", hash_generated_field = "0C17FF0FD2B2099BBD58540A0BAE79F7")

    public static final int TYPE_AUINT128 = 0x400A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.768 -0400", hash_original_field = "54D62926287A1746ACEC640769E9D979", hash_generated_field = "DD49890F437E9368BFAFB689968A6574")

    public static final int TYPE_STR = 0xFFFF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.770 -0400", hash_original_field = "12EB2E377BE48775CD6F73B1A31FEA3B", hash_generated_field = "52D0F0E9CA99E9CDFE8040DF745A40E1")

    /** @hide */
    public static final int RESPONSE_UNDEFINED = 0x2000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.772 -0400", hash_original_field = "FB6C96A4D53458DF5FF79D436F3FC807", hash_generated_field = "A81CE257F826602C1C48EB27A4B367D6")

    public static final int RESPONSE_OK = 0x2001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.775 -0400", hash_original_field = "F08EB25D2C510546F0EACFFAA8AAE936", hash_generated_field = "A93B6AEF9DE1A5202A64E92DDA861E22")

    public static final int RESPONSE_GENERAL_ERROR = 0x2002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.776 -0400", hash_original_field = "BDFE15E7E78F4CE6283A430BDD12F2BD", hash_generated_field = "C1B7115392CABDD412D23F76157E47D7")

    public static final int RESPONSE_SESSION_NOT_OPEN = 0x2003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.778 -0400", hash_original_field = "F488098135D4687F30AA38E32BC94569", hash_generated_field = "B1C29137AD2F12C1DB97ED7107417496")

    public static final int RESPONSE_INVALID_TRANSACTION_ID = 0x2004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.780 -0400", hash_original_field = "DEBA9F81396051B1451703A49776E810", hash_generated_field = "C0D84BF9D27411DBFE242F1F22430616")

    public static final int RESPONSE_OPERATION_NOT_SUPPORTED = 0x2005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.782 -0400", hash_original_field = "669A8EA1736F5BF3804E41E7D2AA2174", hash_generated_field = "D1D224AE219492F570E7AC983A4D5AB2")

    public static final int RESPONSE_PARAMETER_NOT_SUPPORTED = 0x2006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.784 -0400", hash_original_field = "D8B6BFC535A3178E83975DC661C8AB94", hash_generated_field = "FEBAAD1FD129EFB5293B06A1C952ED53")

    public static final int RESPONSE_INCOMPLETE_TRANSFER = 0x2007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.786 -0400", hash_original_field = "60BC1EDE426774B69DA68A6829175B3A", hash_generated_field = "22AE9A29F0E164842748AB215A788158")

    public static final int RESPONSE_INVALID_STORAGE_ID = 0x2008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.788 -0400", hash_original_field = "05F1F819339B97A3DE48D08071972505", hash_generated_field = "B6077BE51113019E38242A8370E1E31D")

    public static final int RESPONSE_INVALID_OBJECT_HANDLE = 0x2009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.790 -0400", hash_original_field = "7695CBD0FD5F509E0C32F5E1CE99A8F0", hash_generated_field = "3B5BDA88CAC1F61AB94EDD432C84D29D")

    public static final int RESPONSE_DEVICE_PROP_NOT_SUPPORTED = 0x200A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.792 -0400", hash_original_field = "F4B069D852F7F3E027E4AE57952E455E", hash_generated_field = "D6CA64A5F86D7A967C64BC50D8B65BBB")

    public static final int RESPONSE_INVALID_OBJECT_FORMAT_CODE = 0x200B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.794 -0400", hash_original_field = "F9B3616BFD4C7C5AD5E5FA0F00EE8BDF", hash_generated_field = "EBDCE41FA40C7AAD1514E44F5A039842")

    public static final int RESPONSE_STORAGE_FULL = 0x200C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.795 -0400", hash_original_field = "88B4DF4BB2069F4307D8D473092B5038", hash_generated_field = "E03D38B00501067F18009856FF62E2F5")

    public static final int RESPONSE_OBJECT_WRITE_PROTECTED = 0x200D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.797 -0400", hash_original_field = "A5979143C731DAF380D7C97A5F28B363", hash_generated_field = "1EBB09F3F37F94446D548245358BF3E1")

    public static final int RESPONSE_STORE_READ_ONLY = 0x200E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.799 -0400", hash_original_field = "86A0D4E78D9D3A755916FDB2C71DEE01", hash_generated_field = "D355E57F104E966993884CCE7E3DDA37")

    public static final int RESPONSE_ACCESS_DENIED = 0x200F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.801 -0400", hash_original_field = "CD59A678D80AC53229F3CC2C193BB2DC", hash_generated_field = "D2C0E2624DAE954899EA040AEF7D14C7")

    public static final int RESPONSE_NO_THUMBNAIL_PRESENT = 0x2010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.803 -0400", hash_original_field = "2E58F50343883A20AB24B5E3672F8789", hash_generated_field = "622C3DD6D12EF93E2EFF25905FF9E73F")

    public static final int RESPONSE_SELF_TEST_FAILED = 0x2011;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.804 -0400", hash_original_field = "56A83A20F86FB9559EF8FADFE6158E7F", hash_generated_field = "85D069129AA8450212B9D7AC4F58B6B6")

    public static final int RESPONSE_PARTIAL_DELETION = 0x2012;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.807 -0400", hash_original_field = "4D20F66522A4E1EDC5C85888CF2677DA", hash_generated_field = "2305DED3285273015D457CED540200F7")

    public static final int RESPONSE_STORE_NOT_AVAILABLE = 0x2013;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.808 -0400", hash_original_field = "C868A219FEC5AE467F7F9B8C6262EBFB", hash_generated_field = "9690D8E461DCD0C00666C642390430B2")

    public static final int RESPONSE_SPECIFICATION_BY_FORMAT_UNSUPPORTED = 0x2014;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.810 -0400", hash_original_field = "C088CE074978D1C19C4C670FC88D6A5E", hash_generated_field = "854972D5A373F692A3549C3D27B623C8")

    public static final int RESPONSE_NO_VALID_OBJECT_INFO = 0x2015;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.812 -0400", hash_original_field = "9A089DB32689C7BEF23E9FAF3B56BFA5", hash_generated_field = "45C67027FC71F627A08E6852DA19BF46")

    public static final int RESPONSE_INVALID_CODE_FORMAT = 0x2016;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.814 -0400", hash_original_field = "F3A061533F916C77EF7CAB6B94269799", hash_generated_field = "CEA30267C72184CBE2F2C4D842881F13")

    public static final int RESPONSE_UNKNOWN_VENDOR_CODE = 0x2017;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.815 -0400", hash_original_field = "17E5463FEED8E152054E8C7336A97DD6", hash_generated_field = "D8C5BFA686DC31E24863F621359FDF6F")

    public static final int RESPONSE_CAPTURE_ALREADY_TERMINATED = 0x2018;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.817 -0400", hash_original_field = "9673C919CB1C964FED7B70A39F0DB43D", hash_generated_field = "50453D060D5EDF6067F497A5BDA41C2F")

    public static final int RESPONSE_DEVICE_BUSY = 0x2019;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.819 -0400", hash_original_field = "872FEDEC88D3A51083B738F6CB6DE664", hash_generated_field = "65072FF12E0BA6B5870478677F5F5E18")

    public static final int RESPONSE_INVALID_PARENT_OBJECT = 0x201A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.821 -0400", hash_original_field = "73A66F56F54CF1F0EE3D9E1A8B96C48A", hash_generated_field = "27E1E68BF9C7E34B9FE5EBEB8D5158E0")

    public static final int RESPONSE_INVALID_DEVICE_PROP_FORMAT = 0x201B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.823 -0400", hash_original_field = "8348D5C8B5C54BBA6054949588F2924E", hash_generated_field = "1AED3E7B7BC08A480118911C5D01E7B7")

    public static final int RESPONSE_INVALID_DEVICE_PROP_VALUE = 0x201C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.825 -0400", hash_original_field = "183FCD4DAB2D2F3D77157443C74FC3C8", hash_generated_field = "1FE6276CA84C41A9E6EDE3475D2C9A74")

    public static final int RESPONSE_INVALID_PARAMETER = 0x201D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.827 -0400", hash_original_field = "22C9347ED4EADE46432657E7537B21DD", hash_generated_field = "DBF2577D6027C4033746A5FF7478CFB6")

    public static final int RESPONSE_SESSION_ALREADY_OPEN = 0x201E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.828 -0400", hash_original_field = "150A85C3CB7B66AA9E5C15EED5B4C4EF", hash_generated_field = "103182ED596A83BB39FE3472D01EB320")

    public static final int RESPONSE_TRANSACTION_CANCELLED = 0x201F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.830 -0400", hash_original_field = "F411229A67416194CD58C095DD5A19E2", hash_generated_field = "1C0164710F556C8492669A95C2F70862")

    public static final int RESPONSE_SPECIFICATION_OF_DESTINATION_UNSUPPORTED = 0x2020;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.832 -0400", hash_original_field = "EE1B6E44A9DF3414BED8F7882ACA81A8", hash_generated_field = "DA63615EA091CDDA27E19A16E8E9FB96")

    public static final int RESPONSE_INVALID_OBJECT_PROP_CODE = 0xA801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.834 -0400", hash_original_field = "F74890BF5F840C2878644BF3B7813CA0", hash_generated_field = "AAA17C19DCAA41F617EF7657B73F50EF")

    public static final int RESPONSE_INVALID_OBJECT_PROP_FORMAT = 0xA802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.836 -0400", hash_original_field = "9B47A3C0730FFFA0A38C6F0C2D8DA150", hash_generated_field = "78C6C63E0AA6D0F17F8BB82C4C04DCF1")

    public static final int RESPONSE_INVALID_OBJECT_PROP_VALUE = 0xA803;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.838 -0400", hash_original_field = "E53CB757E178C4F911D0F9283AA22C2C", hash_generated_field = "60C49DE1FCC1D783E0701B68A1AB0121")

    public static final int RESPONSE_INVALID_OBJECT_REFERENCE = 0xA804;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.840 -0400", hash_original_field = "74137C38210969EFC3EC704712A4ED84", hash_generated_field = "E05E04F08415C0DD61DAAFC6EFF339EF")

    public static final int RESPONSE_GROUP_NOT_SUPPORTED = 0xA805;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.842 -0400", hash_original_field = "710A7984118E55E47CD31404D26B59DC", hash_generated_field = "E92A61F03FCD4CD3DE3292D7AD02768E")

    public static final int RESPONSE_INVALID_DATASET = 0xA806;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.844 -0400", hash_original_field = "74B71AD15627F26F5D0D30954DF5B638", hash_generated_field = "E62F8B7BCE1D09E38809714625557EE3")

    public static final int RESPONSE_SPECIFICATION_BY_GROUP_UNSUPPORTED = 0xA807;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.846 -0400", hash_original_field = "C72252849F902393285BE01435AC58D8", hash_generated_field = "05BC30948B885219B79E87267464B3D6")

    public static final int RESPONSE_SPECIFICATION_BY_DEPTH_UNSUPPORTED = 0xA808;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.848 -0400", hash_original_field = "C64E4F3E07D62636DD63BBC1F08B5A32", hash_generated_field = "01CFD4D9C89062B5E18D206BD36A1A57")

    public static final int RESPONSE_OBJECT_TOO_LARGE = 0xA809;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.849 -0400", hash_original_field = "656415B0B773AA6A9D24277129A0EC91", hash_generated_field = "11C551BE781F03D95DF4F97036ABBC91")

    public static final int RESPONSE_OBJECT_PROP_NOT_SUPPORTED = 0xA80A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.851 -0400", hash_original_field = "D0160C5D6A9B7862A703815DB0FEFD32", hash_generated_field = "9B861776AB00EE3AF2A5313B033838E9")

    /** Undefined format code */
    public static final int FORMAT_UNDEFINED = 0x3000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.853 -0400", hash_original_field = "E9C39FAEDD814755F96599DA7012D9D2", hash_generated_field = "78E4AC4B840293E19F9358207ECD55CE")

    public static final int FORMAT_ASSOCIATION = 0x3001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.855 -0400", hash_original_field = "311F7A2391F92DFDC4128DD025F5FE28", hash_generated_field = "3A179EE35A7798F7E1398CBFA4649BEB")

    public static final int FORMAT_SCRIPT = 0x3002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.857 -0400", hash_original_field = "E56DFCE5E6D998B59AB7EEE294F0A0AA", hash_generated_field = "A67C3730DA12532CB347354D9546DBD2")

    public static final int FORMAT_EXECUTABLE = 0x3003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.858 -0400", hash_original_field = "361EB4FD14CA102321AE8FAFA9A7BCA2", hash_generated_field = "BBD8A5A739A050F5B4923259E2576769")

    public static final int FORMAT_TEXT = 0x3004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.860 -0400", hash_original_field = "1BFA45EA89064AE8E78461E1A3A6FF58", hash_generated_field = "47E8260F4E4CBDC98C3A43E962175E99")

    public static final int FORMAT_HTML = 0x3005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.862 -0400", hash_original_field = "EA76D5FE04D9C36338D9F91ED25299B0", hash_generated_field = "88EE0AC85E98442E1A7960DA251D8193")

    public static final int FORMAT_DPOF = 0x3006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.863 -0400", hash_original_field = "29DFBBA79C6CB57AD563B7900FAC880C", hash_generated_field = "42709B75725D09AF07ADD6EA74ECA897")

    public static final int FORMAT_AIFF = 0x3007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.866 -0400", hash_original_field = "FF57106E148715F8539B9EB92819AC52", hash_generated_field = "F647592A499EC1D5F6807C0DE0F79563")

    public static final int FORMAT_WAV = 0x3008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.867 -0400", hash_original_field = "6E1AFE959D8571B9904A4D91EFB002FF", hash_generated_field = "859698F746CC0D134C3885FBC5122ADA")

    public static final int FORMAT_MP3 = 0x3009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.869 -0400", hash_original_field = "2C982EE48958C39BA098683C2E0BF044", hash_generated_field = "9D97794FFAB36E77E50F3B0D25B5C934")

    public static final int FORMAT_AVI = 0x300A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.871 -0400", hash_original_field = "0678197D2CDD9EFFC9A9EE08696EC047", hash_generated_field = "1D3349BAF7CFCBFFE73C8D813F0395DE")

    public static final int FORMAT_MPEG = 0x300B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.873 -0400", hash_original_field = "86D81513DB5620164E092DE4C3747B81", hash_generated_field = "D1428148445F7424371243293D57CC00")

    public static final int FORMAT_ASF = 0x300C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.874 -0400", hash_original_field = "CBC9FACE682EC1AFB9797330141A452A", hash_generated_field = "FFD800B3E23823CBD1EC4BDF8654FEA6")

    public static final int FORMAT_EXIF_JPEG = 0x3801;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.876 -0400", hash_original_field = "4EE35ED410D6CF87CAA22BEDE54CA8C6", hash_generated_field = "5B47AD1AFBFA2FAB704E4ABEC29F7C57")

    public static final int FORMAT_TIFF_EP = 0x3802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.878 -0400", hash_original_field = "917A60497DBD05CE0E4E3F4EDB1B52C2", hash_generated_field = "4B5CDE5D9BD70E733DF519635177869C")

    public static final int FORMAT_BMP = 0x3804;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.880 -0400", hash_original_field = "F824A800FF1333E82D541D880D7369E9", hash_generated_field = "B4645EF528FE84D447943C6FECF9C36C")

    public static final int FORMAT_GIF = 0x3807;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.881 -0400", hash_original_field = "BA8F77CEC946A3A4D6EE649CD5098D49", hash_generated_field = "9928D22DFEF426602C5681239E28C8CF")

    public static final int FORMAT_JFIF = 0x3808;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.883 -0400", hash_original_field = "DC4F56EEF1D293273BC4AA3B6FFC9623", hash_generated_field = "528D25E7209200F6C94A467439F2B34C")

    public static final int FORMAT_PICT = 0x380A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.885 -0400", hash_original_field = "F9975542B4787308EF482E2012DBEBC3", hash_generated_field = "9C4EF7850439BD19921CD099AE884B39")

    public static final int FORMAT_PNG = 0x380B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.887 -0400", hash_original_field = "19A3345C0CD54F86C08C62273C950EC2", hash_generated_field = "A93A069B4DFA13F1C25C796E02D81520")

    public static final int FORMAT_TIFF = 0x380D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.889 -0400", hash_original_field = "DA543319FF16BA4F3E35F43EC3A65957", hash_generated_field = "E080CA2EC1E6417F4C0857D0283EC486")

    public static final int FORMAT_JP2 = 0x380F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.891 -0400", hash_original_field = "5AD2FE024BF09A4FD78BF79E0C8A4A35", hash_generated_field = "397EF0B44B2B9DBDC9AC3DA4CA780C58")

    public static final int FORMAT_JPX = 0x3810;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.893 -0400", hash_original_field = "ECA41F93D9C2963FA82953411BBE8F42", hash_generated_field = "610E905996CB9ECC33BAEA767254B5B1")

    public static final int FORMAT_UNDEFINED_FIRMWARE = 0xB802;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.895 -0400", hash_original_field = "516511DFC54C92DCE416184DE940ED4A", hash_generated_field = "D2FE515CC8FAB0467FD09CD1626F3686")

    public static final int FORMAT_WINDOWS_IMAGE_FORMAT = 0xB881;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.897 -0400", hash_original_field = "5CD67F219DF0DADF5F08A090AC1C7FA6", hash_generated_field = "EB0FBED880D3E7998873D0455564853C")

    public static final int FORMAT_UNDEFINED_AUDIO = 0xB900;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.898 -0400", hash_original_field = "AC2433C720A47EF1A607BCCBF9DCA888", hash_generated_field = "BEDDE9005872F399CF122F21DC0D9EF8")

    public static final int FORMAT_WMA = 0xB901;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.900 -0400", hash_original_field = "105185578CE656C52B8C4EF98D1FBF0A", hash_generated_field = "292D1FBDF0D02A57F9E938F63F67F1E6")

    public static final int FORMAT_OGG = 0xB902;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.902 -0400", hash_original_field = "BA4F35212A415C8932F77BAFC50C3D8F", hash_generated_field = "D22C82667F11BECE2BDE8F2908452DAB")

    public static final int FORMAT_AAC = 0xB903;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.903 -0400", hash_original_field = "0B571686C446CB62ECB2E0605F51F26E", hash_generated_field = "AE9E6AB4BB16CF4602E612B83C201785")

    public static final int FORMAT_AUDIBLE = 0xB904;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.905 -0400", hash_original_field = "6F7F63FB8EDFE16D7B9099158AEB22C7", hash_generated_field = "F7AFDB18CE5490A490BA4D7347C3BE5C")

    public static final int FORMAT_FLAC = 0xB906;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.907 -0400", hash_original_field = "424D6FFF38314BD476A5204D61E33E51", hash_generated_field = "17AE6BD7023D4C1759D638020298962F")

    public static final int FORMAT_UNDEFINED_VIDEO = 0xB980;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.908 -0400", hash_original_field = "A6AAF4A4AB137A8F609D151551B6E7CF", hash_generated_field = "A2D456251C02C21CF070527CFC727FD5")

    public static final int FORMAT_WMV = 0xB981;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.911 -0400", hash_original_field = "8E6ECF47AE521A00B2350591F6E4236C", hash_generated_field = "31E1EB867E017822151846BCC186F3DE")

    public static final int FORMAT_MP4_CONTAINER = 0xB982;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.912 -0400", hash_original_field = "CEB85D1494B2DBDC79F15DFE76D66FE4", hash_generated_field = "EF3B7EBCB7DB91BDC01F76EB22870D1A")

    public static final int FORMAT_MP2 = 0xB983;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.914 -0400", hash_original_field = "6432AC79FE232F1912DB0062819C7FBE", hash_generated_field = "6B9974F0FFE894FEB02CD2F91206B35B")

    public static final int FORMAT_3GP_CONTAINER = 0xB984;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.916 -0400", hash_original_field = "B189F9C7903F1E8E253C9F71AF88E9B5", hash_generated_field = "5AC53A637F2D3D639C66804C5F7E65B3")

    public static final int FORMAT_UNDEFINED_COLLECTION = 0xBA00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.918 -0400", hash_original_field = "5A949788CB827779E4BF24268644F2DD", hash_generated_field = "3C17C08E7E1130B4845EABD19166D187")

    public static final int FORMAT_ABSTRACT_MULTIMEDIA_ALBUM = 0xBA01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.920 -0400", hash_original_field = "6D38814A28864B7DF27AAEB4A9FB1FC3", hash_generated_field = "A149E208C5946661AB670874E24544B7")

    public static final int FORMAT_ABSTRACT_IMAGE_ALBUM = 0xBA02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.922 -0400", hash_original_field = "858B40EEF77FF37CBECD62397EB25421", hash_generated_field = "8631AF11C0BF2FE5463292F52C530E5D")

    public static final int FORMAT_ABSTRACT_AUDIO_ALBUM = 0xBA03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.923 -0400", hash_original_field = "6E605107BD95BF6CEB835AEA5C0FCBE8", hash_generated_field = "39FBBA65F59A38C95C619BDD827CB58B")

    public static final int FORMAT_ABSTRACT_VIDEO_ALBUM = 0xBA04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.925 -0400", hash_original_field = "4FE677031F3D56455FDC3B4028DEE0EB", hash_generated_field = "A39D52B8B47B27454E107035036F0F02")

    public static final int FORMAT_ABSTRACT_AV_PLAYLIST = 0xBA05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.927 -0400", hash_original_field = "C1DBF6DC6090B69F3C9A4810414D851C", hash_generated_field = "F738388369D3ACBCC8F8EDF5A6C90D53")

    public static final int FORMAT_ABSTRACT_AUDIO_PLAYLIST = 0xBA09;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.929 -0400", hash_original_field = "181F0CFCFE3EA80F5CD5736DB6448C21", hash_generated_field = "F6AF52BBB8A5CEBCC588FC999F3EBEEB")

    public static final int FORMAT_ABSTRACT_VIDEO_PLAYLIST = 0xBA0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.930 -0400", hash_original_field = "C95EBC773D7D67DFF4089C3D422D846E", hash_generated_field = "E7A5B0559ECD9204E5F8D0F53F7D21C7")

    public static final int FORMAT_ABSTRACT_MEDIACAST = 0xBA0B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.932 -0400", hash_original_field = "ABF7BCEEC902686F53A184F0CAAB19BE", hash_generated_field = "C027B4DA98F5BC3FB5256AB04B5838E0")

    public static final int FORMAT_WPL_PLAYLIST = 0xBA10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.934 -0400", hash_original_field = "42F4C2BF945D1D0BB401B5DFCDF1589D", hash_generated_field = "7BAA474E2404D5869D70BE58F6320B1C")

    public static final int FORMAT_M3U_PLAYLIST = 0xBA11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.936 -0400", hash_original_field = "EBF3EFD43562EF6EB5E2C507A4188AD2", hash_generated_field = "7F3ADF1059D3E776E24D19A094E9BA46")

    public static final int FORMAT_MPL_PLAYLIST = 0xBA12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.938 -0400", hash_original_field = "EA284E1B21EC8AB6FD11070C39EBBE46", hash_generated_field = "A35DFA74CD01537CA547DBE71C6844AF")

    public static final int FORMAT_ASX_PLAYLIST = 0xBA13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.940 -0400", hash_original_field = "00C5EDA5DE09D43F31E04645A76FF170", hash_generated_field = "EDC58725B74A84FB36D847067720F4BF")

    public static final int FORMAT_PLS_PLAYLIST = 0xBA14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.942 -0400", hash_original_field = "728BF667FE12DB4BDA24E51DB1905705", hash_generated_field = "8A166454CAFDE4F035CCD57D4EB9742D")

    public static final int FORMAT_UNDEFINED_DOCUMENT = 0xBA80;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.944 -0400", hash_original_field = "7F0C07E1475BFB3DF3440BA57F3C204D", hash_generated_field = "F7EE28FFADD848C453127749B6B27B1C")

    public static final int FORMAT_ABSTRACT_DOCUMENT = 0xBA81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.945 -0400", hash_original_field = "CE5A1FEB8A81A1D2D264A10D6F06ABC8", hash_generated_field = "B588924EE4A6ED5A59310B2C2A048C01")

    public static final int FORMAT_XML_DOCUMENT = 0xBA82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.947 -0400", hash_original_field = "56F3D250802F3E5F7AE6455470C55664", hash_generated_field = "BA09A8E62D83FB18370794AFB125ADF2")

    public static final int FORMAT_MS_WORD_DOCUMENT = 0xBA83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.949 -0400", hash_original_field = "2AC6B9BBF0374E3CF14ADD31BF81BB89", hash_generated_field = "BB392208F8D19AE9AB436C95E002D68E")

    public static final int FORMAT_MS_EXCEL_SPREADSHEET = 0xBA85;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.950 -0400", hash_original_field = "E6B566766F0CAF8884DD935C4434DFBC", hash_generated_field = "D31088FE2117F1842BA3DEDCDC5FB669")

    public static final int FORMAT_MS_POWERPOINT_PRESENTATION = 0xBA86;

    /**
      * Returns true if the object is abstract (that is, it has no representation
      * in the underlying file system).
      *
      * @param format the format of the object
      * @return true if the object is abstract
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.952 -0400", hash_original_method = "81ADBCE0EAE2204E2D9E7EA7185BA418", hash_generated_method = "4FEDC01EF48253C423995F3CCD5D02B0")
    
public static boolean isAbstractObject(int format) {
        switch (format) {
            case FORMAT_ABSTRACT_MULTIMEDIA_ALBUM:
            case FORMAT_ABSTRACT_IMAGE_ALBUM:
            case FORMAT_ABSTRACT_AUDIO_ALBUM:
            case FORMAT_ABSTRACT_VIDEO_ALBUM:
            case FORMAT_ABSTRACT_AV_PLAYLIST:
            case FORMAT_ABSTRACT_AUDIO_PLAYLIST:
            case FORMAT_ABSTRACT_VIDEO_PLAYLIST:
            case FORMAT_ABSTRACT_MEDIACAST:
            case FORMAT_ABSTRACT_DOCUMENT:
                return true;
            default:
                return false;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.955 -0400", hash_original_field = "57B3D5E9F3F5071F8D4856A9B325F2DF", hash_generated_field = "B88780BC1B9FF7C21C05F9CB23FC2B68")

    /** @hide */
    public static final int PROPERTY_STORAGE_ID = 0xDC01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.957 -0400", hash_original_field = "6410B216D82DD63ED6E4D457811F9DF7", hash_generated_field = "65D4FEEA278626E69B2EEF1F9AD952A8")

    public static final int PROPERTY_OBJECT_FORMAT = 0xDC02;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.959 -0400", hash_original_field = "E295ABF65D1801EC1D22EB6586FACB52", hash_generated_field = "54253DED8B53C5DD7E476490E7843DB1")

    public static final int PROPERTY_PROTECTION_STATUS = 0xDC03;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.961 -0400", hash_original_field = "216D23E9340B23E1355F01F0E95C6212", hash_generated_field = "9A2F589A579080C94F1DA2F79B7BF803")

    public static final int PROPERTY_OBJECT_SIZE = 0xDC04;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.963 -0400", hash_original_field = "1AF69732389377657E9A9E8810965FD5", hash_generated_field = "0C37A7C13471BC23AA07FD98CB9D8E1B")

    public static final int PROPERTY_ASSOCIATION_TYPE = 0xDC05;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.964 -0400", hash_original_field = "579307204812FF5C4D8603B852B5A94D", hash_generated_field = "7E110E80A1D25A9863988610F99BB988")

    public static final int PROPERTY_ASSOCIATION_DESC = 0xDC06;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.966 -0400", hash_original_field = "672C7145CAE851EB2B2E6FFF51D19FD2", hash_generated_field = "AFFF2CD7E193DB3EE3638199D462421A")

    public static final int PROPERTY_OBJECT_FILE_NAME = 0xDC07;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.968 -0400", hash_original_field = "075B4BDC946AEC4E28ADC3431852D188", hash_generated_field = "42F9BF7C4BF79B13331E8F364CC56D51")

    public static final int PROPERTY_DATE_CREATED = 0xDC08;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.970 -0400", hash_original_field = "BC8B7E3D924DA06A128A3C2B69B3B996", hash_generated_field = "7AF9FC6FB39927349995CBF4CF823A9E")

    public static final int PROPERTY_DATE_MODIFIED = 0xDC09;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.971 -0400", hash_original_field = "1F22745B5959B146F4236C62BD986407", hash_generated_field = "0A23B426A824DCD6BA09E3817E47266D")

    public static final int PROPERTY_KEYWORDS = 0xDC0A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.973 -0400", hash_original_field = "74198BBD1866DBC5B5CB32154863E818", hash_generated_field = "F74E60BF84265B8B3B3723DABB754F54")

    public static final int PROPERTY_PARENT_OBJECT = 0xDC0B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.975 -0400", hash_original_field = "849E51E6121095C3B0F0339C5CFFD1A7", hash_generated_field = "503430D05D0100BCA6CEA83382FC3DFB")

    public static final int PROPERTY_ALLOWED_FOLDER_CONTENTS = 0xDC0C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.977 -0400", hash_original_field = "56B186DEE0C3711AD189B50FA8F30F4C", hash_generated_field = "444B3A65843F0F90FE57DD33B04A1EE1")

    public static final int PROPERTY_HIDDEN = 0xDC0D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.979 -0400", hash_original_field = "C1BE8B4BCEF44E72DB758A33222DA81D", hash_generated_field = "4A8F1C807F170B384F73276709C3BD9B")

    public static final int PROPERTY_SYSTEM_OBJECT = 0xDC0E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.980 -0400", hash_original_field = "9688C8C28AD89E0AED1C5F7D2321659C", hash_generated_field = "059920A1C67F20040FEF66E92C12E008")

    public static final int PROPERTY_PERSISTENT_UID = 0xDC41;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.982 -0400", hash_original_field = "97DBC484ACD9D5914DFC5218A0F969FD", hash_generated_field = "60DA5E66C29F6D5F491AADC49699672E")

    public static final int PROPERTY_SYNC_ID = 0xDC42;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.984 -0400", hash_original_field = "EF92027827C1193F3ED9BE7526736F72", hash_generated_field = "39C67F9E83032AA252A8AA2D8222ECEA")

    public static final int PROPERTY_PROPERTY_BAG = 0xDC43;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.986 -0400", hash_original_field = "C3540AC5E600D7B84F876C3EB8663218", hash_generated_field = "510726B3144147E682E4E4059EE26D89")

    public static final int PROPERTY_NAME = 0xDC44;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.988 -0400", hash_original_field = "B67230F187038588C8EBDB96E22BF7DC", hash_generated_field = "29555C9FAE7E953EF615F7A207354AD6")

    public static final int PROPERTY_CREATED_BY = 0xDC45;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.989 -0400", hash_original_field = "F9E1F7F276CEAE3DA8F7E33F6582A97F", hash_generated_field = "F3655084C566FED7AA6376248A6F3D62")

    public static final int PROPERTY_ARTIST = 0xDC46;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.991 -0400", hash_original_field = "A508D9B70CA817E8A82FB80E30A10236", hash_generated_field = "53F3DDFA62AE4ECB19D54415F52460CF")

    public static final int PROPERTY_DATE_AUTHORED = 0xDC47;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.993 -0400", hash_original_field = "AAAEA007A7B935DDF93643483E705B91", hash_generated_field = "133392C213F1A108073A8C5250BE4737")

    public static final int PROPERTY_DESCRIPTION = 0xDC48;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.994 -0400", hash_original_field = "84A47BD4D2950364B33D0C4B0BE51073", hash_generated_field = "12CF5721FB342220A37AE888EA9E50BD")

    public static final int PROPERTY_URL_REFERENCE = 0xDC49;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.997 -0400", hash_original_field = "499C5C3C3B29D5D1CB1072D70EEA6897", hash_generated_field = "5E9982E493853A368882F7E4F7B27C01")

    public static final int PROPERTY_LANGUAGE_LOCALE = 0xDC4A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:18.998 -0400", hash_original_field = "32A02952375F615FC5012616E43608F5", hash_generated_field = "2E7D3151745977773D8D1B8A562D2CFD")

    public static final int PROPERTY_COPYRIGHT_INFORMATION = 0xDC4B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.001 -0400", hash_original_field = "564F08BC8C8A33BEC11A54C3183AE8AC", hash_generated_field = "B0DAEC91E9728196282343FBD8B3E0CC")

    public static final int PROPERTY_SOURCE = 0xDC4C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.003 -0400", hash_original_field = "227CEB535506135A28E8247236DC774E", hash_generated_field = "773C1678F33850E347ACC47263280E74")

    public static final int PROPERTY_ORIGIN_LOCATION = 0xDC4D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.004 -0400", hash_original_field = "8C813DB091EE3FF16F7E0970FD226CE7", hash_generated_field = "E8EB37433B591A4919DE3851E11E8D36")

    public static final int PROPERTY_DATE_ADDED = 0xDC4E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.006 -0400", hash_original_field = "50FEB77575DDC0C593010188BADC06C8", hash_generated_field = "F000DBA72BE145E30E859AF99F1E3C54")

    public static final int PROPERTY_NON_CONSUMABLE = 0xDC4F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.008 -0400", hash_original_field = "F7904F60247D1D114BD453BBA5A3AA7B", hash_generated_field = "7FB65E8A28E699BA0C2FA41F94E9B807")

    public static final int PROPERTY_CORRUPT_UNPLAYABLE = 0xDC50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.010 -0400", hash_original_field = "91CCA8CFD833D568B4C65C8BEBEB78F4", hash_generated_field = "46CCD7A2D8FD2A8D1CD81DCBD410C18E")

    public static final int PROPERTY_PRODUCER_SERIAL_NUMBER = 0xDC51;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.011 -0400", hash_original_field = "E0D43CE5D4740E0B3CC7559878F02138", hash_generated_field = "2B8F13927AA1A7BC9E14B1B978D78939")

    public static final int PROPERTY_REPRESENTATIVE_SAMPLE_FORMAT = 0xDC81;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.013 -0400", hash_original_field = "C9148C794B543460E69A039DD4AFB357", hash_generated_field = "695A0637B6D5FD1DD796B85A8D7E6481")

    public static final int PROPERTY_REPRESENTATIVE_SAMPLE_SIZE = 0xDC82;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.015 -0400", hash_original_field = "ABEAFC09D38AACC3451BA97A7E9D4626", hash_generated_field = "554D2AB0DB723DA36337A3A67FB0B9B7")

    public static final int PROPERTY_REPRESENTATIVE_SAMPLE_HEIGHT = 0xDC83;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.017 -0400", hash_original_field = "F081CA7554B4361B40EFA77924B6A72F", hash_generated_field = "DFD5BBD636A31234B3A30AD71C073DD1")

    public static final int PROPERTY_REPRESENTATIVE_SAMPLE_WIDTH = 0xDC84;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.018 -0400", hash_original_field = "70BE619E223365F53A25A2ABB48BCB17", hash_generated_field = "FEE72D9B8F7D32E5B94F00705DE2C7D2")

    public static final int PROPERTY_REPRESENTATIVE_SAMPLE_DURATION = 0xDC85;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.020 -0400", hash_original_field = "563017D9624D26B74F80CD464F91F18C", hash_generated_field = "9D48F7209EC128E042E7AF561BA66F9E")

    public static final int PROPERTY_REPRESENTATIVE_SAMPLE_DATA = 0xDC86;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.022 -0400", hash_original_field = "2CDB82E3CACFC7C74055F9D4B837B089", hash_generated_field = "6ACE1444818B4F242FE40B1B1819B68E")

    public static final int PROPERTY_WIDTH = 0xDC87;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.024 -0400", hash_original_field = "56D4734A7D2FC320D1D2D33DC0781BC1", hash_generated_field = "9DC48A967E39A8DC501F5263F2F3B9D1")

    public static final int PROPERTY_HEIGHT = 0xDC88;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.026 -0400", hash_original_field = "FE4D4A06BC224DB208E3F2AA49586E18", hash_generated_field = "1A151D9C30D19D44DCDA5CEFFB46A327")

    public static final int PROPERTY_DURATION = 0xDC89;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.027 -0400", hash_original_field = "8B583B63629D5125988AA3E6FAC693AF", hash_generated_field = "29ADBB8581F570D140DCABDE2C7AF87D")

    public static final int PROPERTY_RATING = 0xDC8A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.030 -0400", hash_original_field = "381A5BA8D247027D9718DC2D162AD469", hash_generated_field = "CECE897142D843A18A23286E66436A32")

    public static final int PROPERTY_TRACK = 0xDC8B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.032 -0400", hash_original_field = "5466EA90E310F97085DB650120CC1450", hash_generated_field = "3A1E2D9996D778D0EB558B7BFB5EBE16")

    public static final int PROPERTY_GENRE = 0xDC8C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.034 -0400", hash_original_field = "C3923B9AF158100EEFEEE233EE0E755A", hash_generated_field = "4191275F5661063630973CC359C5514F")

    public static final int PROPERTY_CREDITS = 0xDC8D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.035 -0400", hash_original_field = "CB283B24AF8283167D9E00B29B53E98B", hash_generated_field = "3A54153461C1F73392D7F031F404827F")

    public static final int PROPERTY_LYRICS = 0xDC8E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.037 -0400", hash_original_field = "E61FB36FC89AF929BC1D6476D52A7BDC", hash_generated_field = "393BD73BD2FC5A95E422CE47271CF35E")

    public static final int PROPERTY_SUBSCRIPTION_CONTENT_ID = 0xDC8F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.039 -0400", hash_original_field = "ECB4B3F8FA28F6920B6DB8A827E22B13", hash_generated_field = "2707A78FEB83160181993F85D1C35117")

    public static final int PROPERTY_PRODUCED_BY = 0xDC90;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.040 -0400", hash_original_field = "D2C524C0063BB7F4B207BCCD6CF77FF7", hash_generated_field = "C50A6E6AE1A4101605A046D6AD233D34")

    public static final int PROPERTY_USE_COUNT = 0xDC91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.042 -0400", hash_original_field = "3A9D65B467EFB707A24E251B604D8C41", hash_generated_field = "B0D2BC260AC373814804A5306D7F6709")

    public static final int PROPERTY_SKIP_COUNT = 0xDC92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.044 -0400", hash_original_field = "304740E8C6DE65FE2CF194C92E7A4F58", hash_generated_field = "F7CFBAEDF6415513D188FB496E9744C6")

    public static final int PROPERTY_LAST_ACCESSED = 0xDC93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.046 -0400", hash_original_field = "A80A577C1B9580F0ED02A3860208BE65", hash_generated_field = "19385CA11A4FB7B8347107D5525222EF")

    public static final int PROPERTY_PARENTAL_RATING = 0xDC94;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.048 -0400", hash_original_field = "8218A11495CA27727F852B09DB729362", hash_generated_field = "9500DC15EF95E105023F1ACC4017677F")

    public static final int PROPERTY_META_GENRE = 0xDC95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.051 -0400", hash_original_field = "5DB9873D4485674AB840458FA6F1E4C1", hash_generated_field = "336CEA9C3FC56D697EE59B8A08193B4C")

    public static final int PROPERTY_COMPOSER = 0xDC96;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.052 -0400", hash_original_field = "0506A7E16DC1C0599252678AFEDF6AAE", hash_generated_field = "BE17DA9328F71F58F42A62225348F8BC")

    public static final int PROPERTY_EFFECTIVE_RATING = 0xDC97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.054 -0400", hash_original_field = "EF54A948E609308BEB9B091AEC92CF07", hash_generated_field = "475883C5884964E705DA645761BB36D0")

    public static final int PROPERTY_SUBTITLE = 0xDC98;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.056 -0400", hash_original_field = "C6EA1035F72B6FEF2A7C03E56E40C0CE", hash_generated_field = "AC836910B2965CD92B5F174C5686B5CA")

    public static final int PROPERTY_ORIGINAL_RELEASE_DATE = 0xDC99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.058 -0400", hash_original_field = "37AF9612F172D51979CDF7DBF2A40C1A", hash_generated_field = "C6371174C2CC993AD2A62BD3326E48BC")

    public static final int PROPERTY_ALBUM_NAME = 0xDC9A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.059 -0400", hash_original_field = "8441E169646DB5B7F1D6A81701379C6E", hash_generated_field = "4D871C8E30D5F591BBD5B38EEC62AA47")

    public static final int PROPERTY_ALBUM_ARTIST = 0xDC9B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.061 -0400", hash_original_field = "02FA2E23A61B5403C2D8BFB5B199DB0A", hash_generated_field = "A340071A32475C3376076D8561FD62A5")

    public static final int PROPERTY_MOOD = 0xDC9C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.063 -0400", hash_original_field = "6C0D46AC017A09D040257E0C3F45C755", hash_generated_field = "43F262A230A0661D1FDE591B8B83AB28")

    public static final int PROPERTY_DRM_STATUS = 0xDC9D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.065 -0400", hash_original_field = "1CB906EC56B5F19831A197A429C6A64F", hash_generated_field = "DC4A3E194A89013AED778D821A34D65B")

    public static final int PROPERTY_SUB_DESCRIPTION = 0xDC9E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.066 -0400", hash_original_field = "E743B18239FCAE0FE8AA33F4F56E6F4C", hash_generated_field = "40558BA13BF98208402DCDFFD740AA26")

    public static final int PROPERTY_IS_CROPPED = 0xDCD1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.068 -0400", hash_original_field = "49559BBDCF1ED1338908A98DFDA5C5EC", hash_generated_field = "48DC6752E20C1DD1D563B730CDD20146")

    public static final int PROPERTY_IS_COLOUR_CORRECTED = 0xDCD2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.070 -0400", hash_original_field = "62F4A6760AB138CE3ECE141BC7FFA0CE", hash_generated_field = "A7D39BAF2EE248CA44E2A0E3B6DEDC8C")

    public static final int PROPERTY_IMAGE_BIT_DEPTH = 0xDCD3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.072 -0400", hash_original_field = "0D3B2B9B6E07A6B1A74E82F82B916D9A", hash_generated_field = "2FB3B3437E6419EF4D5927F335A35148")

    public static final int PROPERTY_F_NUMBER = 0xDCD4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.073 -0400", hash_original_field = "64FD1C53D40BFFAE652C2BF1DAF77B4D", hash_generated_field = "BF7406F7719063CB4152439A871D42F8")

    public static final int PROPERTY_EXPOSURE_TIME = 0xDCD5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.075 -0400", hash_original_field = "1AE8015BC1D3BA0EB533F91798EEEACB", hash_generated_field = "7FFCA349EAB644C77E5F28E02D2BE47B")

    public static final int PROPERTY_EXPOSURE_INDEX = 0xDCD6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.077 -0400", hash_original_field = "D7860AE86A63FDC9CE6C88FF9DC71C6E", hash_generated_field = "AEDF78DEBB01BEE61F493CEB991E9D62")

    public static final int PROPERTY_TOTAL_BITRATE = 0xDE91;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.079 -0400", hash_original_field = "53F2650291C57773F1FCBE607151DD0A", hash_generated_field = "B895D0DF4AFE4FB5E7D8A51974607D6E")

    public static final int PROPERTY_BITRATE_TYPE = 0xDE92;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.080 -0400", hash_original_field = "DC0F6D32F014D4E1418D3AD6078413A4", hash_generated_field = "084E72B530D46A101B48F0398B45A310")

    public static final int PROPERTY_SAMPLE_RATE = 0xDE93;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.082 -0400", hash_original_field = "46869558FEFFD392226A665D665F2123", hash_generated_field = "02A84C85C13447B8DBBBFAF22E05FB61")

    public static final int PROPERTY_NUMBER_OF_CHANNELS = 0xDE94;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.084 -0400", hash_original_field = "8D05EA506CC79AB52BB032BF4D8E0B3B", hash_generated_field = "FD3AACD2001B0E636C936B10264FD6E1")

    public static final int PROPERTY_AUDIO_BIT_DEPTH = 0xDE95;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.086 -0400", hash_original_field = "6C3EF9E4AFCFBE6BBC40C8C862B94CB9", hash_generated_field = "8A6A7BAD669B1FD02A2F7932F70E43A2")

    public static final int PROPERTY_SCAN_TYPE = 0xDE97;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.087 -0400", hash_original_field = "7A8DD8D7B1941892059B304D949F7BC2", hash_generated_field = "B3DDFBDCBC909191DC6EDDCD1CC9EAB1")

    public static final int PROPERTY_AUDIO_WAVE_CODEC = 0xDE99;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.090 -0400", hash_original_field = "FC96D830E15DF57F1F507380B4C516D8", hash_generated_field = "C05F31F407B55F4BCA3EACF874AA01B0")

    public static final int PROPERTY_AUDIO_BITRATE = 0xDE9A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.091 -0400", hash_original_field = "E1805EDAF8D1998A85E574235D969E99", hash_generated_field = "D91FD53647DA829F2E725162AFA105EB")

    public static final int PROPERTY_VIDEO_FOURCC_CODEC = 0xDE9B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.093 -0400", hash_original_field = "18B365C403E74C9EF941A80F78275063", hash_generated_field = "22FFFD896F10C085CDAD0072C2D5B565")

    public static final int PROPERTY_VIDEO_BITRATE = 0xDE9C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.095 -0400", hash_original_field = "FDC43D2993E05205010F2035346B0860", hash_generated_field = "7940F3E0C08A6EE7BAA3F3DBF3584FA5")

    public static final int PROPERTY_FRAMES_PER_THOUSAND_SECONDS = 0xDE9D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.096 -0400", hash_original_field = "840CECF75DDB48FBAEA5B248C4F6DE79", hash_generated_field = "81FAF209B600CF5D8FC8B2424E7F48D5")

    public static final int PROPERTY_KEYFRAME_DISTANCE = 0xDE9E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.099 -0400", hash_original_field = "6FBAE67FFC8E9A715499D1319DBD823F", hash_generated_field = "8F5970D1268770FC5D3412101520413B")

    public static final int PROPERTY_BUFFER_SIZE = 0xDE9F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.101 -0400", hash_original_field = "FECA643323777DE4EAD9B851FAD5C1D7", hash_generated_field = "7674ACE4E35342FCD376750EF5DAD525")

    public static final int PROPERTY_ENCODING_QUALITY = 0xDEA0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.102 -0400", hash_original_field = "66A4E24418D08000772BF22DC08547F9", hash_generated_field = "E354706AA923C96AB3D406BEC030FC40")

    public static final int PROPERTY_ENCODING_PROFILE = 0xDEA1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.104 -0400", hash_original_field = "E140FE201AA8DCB6D5CA50E88D39D9A8", hash_generated_field = "8587BCBAB37B9C51C4C004087C8F38AD")

    public static final int PROPERTY_DISPLAY_NAME = 0xDCE0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.106 -0400", hash_original_field = "64BA217E25AB2263E2D0A538454330C4", hash_generated_field = "ABF0BDF088A009CB8E97A70C33E69063")

    /** @hide */
    public static final int DEVICE_PROPERTY_UNDEFINED = 0x5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.107 -0400", hash_original_field = "7AEACB1AFBC9BFE5C42C9D74CD6A865E", hash_generated_field = "77D80F9046961C493938A17894791D1E")

    public static final int DEVICE_PROPERTY_BATTERY_LEVEL = 0x5001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.109 -0400", hash_original_field = "D4A1377D86C7F9AE4D314756FB42E9AA", hash_generated_field = "3EE36EBDFBEEDE19D4AEF0DD0C9C2D2F")

    public static final int DEVICE_PROPERTY_FUNCTIONAL_MODE = 0x5002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.111 -0400", hash_original_field = "155C3D747F2AD110ACBE01BC97D0D97B", hash_generated_field = "25389CEFA8D2DF1F382B83D888C864D0")

    public static final int DEVICE_PROPERTY_IMAGE_SIZE = 0x5003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.112 -0400", hash_original_field = "2AE7555C8F89084A1457BAEB9CDA449F", hash_generated_field = "CF892C0FCA082AF8EA9EECACAFB35E6D")

    public static final int DEVICE_PROPERTY_COMPRESSION_SETTING = 0x5004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.114 -0400", hash_original_field = "42B16091B944CEE386B7B48965F1F3B1", hash_generated_field = "281C7CEB116738EEF35D8DEA3C542F91")

    public static final int DEVICE_PROPERTY_WHITE_BALANCE = 0x5005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.116 -0400", hash_original_field = "DE3A53C443571E70183016D3E56D4EFC", hash_generated_field = "EB5B1DA84DE364EA3D340DEA72E30493")

    public static final int DEVICE_PROPERTY_RGB_GAIN = 0x5006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.118 -0400", hash_original_field = "3F034CAEC7915AC36C7773F1C4257AF0", hash_generated_field = "986A17673A1A0706FF7523322B6391B1")

    public static final int DEVICE_PROPERTY_F_NUMBER = 0x5007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.120 -0400", hash_original_field = "4242797E109E478DED77CF459487DBE2", hash_generated_field = "E15702BBB7158029CFD990D4B794D89F")

    public static final int DEVICE_PROPERTY_FOCAL_LENGTH = 0x5008;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.121 -0400", hash_original_field = "AD9F2326ECE13006B99EDD61E42D304F", hash_generated_field = "921C622F033B4198AE16CF76E032FF83")

    public static final int DEVICE_PROPERTY_FOCUS_DISTANCE = 0x5009;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.123 -0400", hash_original_field = "BBC7C0A5BD0906F68CDF1AA6B23438BC", hash_generated_field = "C29D5D4FF61B98163C4533B9D948F4E8")

    public static final int DEVICE_PROPERTY_FOCUS_MODE = 0x500A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.124 -0400", hash_original_field = "35034CDDDD7F6B9ABD2724DAD22E3098", hash_generated_field = "2970C3F35D17D05B6E19AE3C13167F03")

    public static final int DEVICE_PROPERTY_EXPOSURE_METERING_MODE = 0x500B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.126 -0400", hash_original_field = "6198D6BFB9AEA424B7C21FA2DB21AADC", hash_generated_field = "047BAB5E75CA48D4A720EE4555094063")

    public static final int DEVICE_PROPERTY_FLASH_MODE = 0x500C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.128 -0400", hash_original_field = "593F9445B5956EE3E78B75F49E0460D5", hash_generated_field = "12AE844B8B2301838A06BC30FBC90729")

    public static final int DEVICE_PROPERTY_EXPOSURE_TIME = 0x500D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.129 -0400", hash_original_field = "4669A3105755BF861877CFDC7F170E38", hash_generated_field = "46C9213E5AD6F6410747A3708A5BAB13")

    public static final int DEVICE_PROPERTY_EXPOSURE_PROGRAM_MODE = 0x500E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.131 -0400", hash_original_field = "C2F5DC04D7F4731B74D13DDAA9CAB73B", hash_generated_field = "10A060E2064C8A77871389BC78AB0B47")

    public static final int DEVICE_PROPERTY_EXPOSURE_INDEX = 0x500F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.132 -0400", hash_original_field = "AC1F1EE3460B24FF145052D03A2776EA", hash_generated_field = "C8780097AF56C845A5751070559266B1")

    public static final int DEVICE_PROPERTY_EXPOSURE_BIAS_COMPENSATION = 0x5010;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.135 -0400", hash_original_field = "D551C3539D0B202FF3C7D23A960CC5D8", hash_generated_field = "81985ABB88B6FBC3CD846844112B48D1")

    public static final int DEVICE_PROPERTY_DATETIME = 0x5011;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.137 -0400", hash_original_field = "C1FEFE2C644EB68E6C93DCA0492E8F9F", hash_generated_field = "1743E49FE74CA90274B8034EA309A59B")

    public static final int DEVICE_PROPERTY_CAPTURE_DELAY = 0x5012;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.139 -0400", hash_original_field = "7891C6329E2A4820C67FA599EF85DAF3", hash_generated_field = "EE1331AC70F70172A4F9FB99059E783F")

    public static final int DEVICE_PROPERTY_STILL_CAPTURE_MODE = 0x5013;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.140 -0400", hash_original_field = "784383CFAAE5D8D3D65B7692D8D91E17", hash_generated_field = "597ADD9C8ACA45FB5234C77480716EE4")

    public static final int DEVICE_PROPERTY_CONTRAST = 0x5014;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.142 -0400", hash_original_field = "73F9486AEC25F706D4F3AF1391EDDAEB", hash_generated_field = "082E42494C49E54C65E3642F09117EB9")

    public static final int DEVICE_PROPERTY_SHARPNESS = 0x5015;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.144 -0400", hash_original_field = "B6076650AEA8DFFC6D6E39A46C951573", hash_generated_field = "CA04161F2A7F13FF92A907E717D00E86")

    public static final int DEVICE_PROPERTY_DIGITAL_ZOOM = 0x5016;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.146 -0400", hash_original_field = "E27BA92010177D87BA7DA8948C232C0C", hash_generated_field = "4A97A6A2210FB928851AACE6608CD22E")

    public static final int DEVICE_PROPERTY_EFFECT_MODE = 0x5017;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.147 -0400", hash_original_field = "C7DFAD31954273B7129E3AE3DED93250", hash_generated_field = "721FC2FFF52E8902A88B65D37CB08B1B")

    public static final int DEVICE_PROPERTY_BURST_NUMBER= 0x5018;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.149 -0400", hash_original_field = "59AFD8B146A34C0C11529E1223ECF7B2", hash_generated_field = "7DFCB2C87E72B15CC9C977B177DCD5C5")

    public static final int DEVICE_PROPERTY_BURST_INTERVAL = 0x5019;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.151 -0400", hash_original_field = "65D745AC165E38DD965A25E975ED97EA", hash_generated_field = "C1641EE94275382E7E9D24C1D123C124")

    public static final int DEVICE_PROPERTY_TIMELAPSE_NUMBER = 0x501A;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.152 -0400", hash_original_field = "FA9626A531B3E6A0EDE233D026C0743C", hash_generated_field = "FE476CA16AF36F0A2E60D59E0D025D38")

    public static final int DEVICE_PROPERTY_TIMELAPSE_INTERVAL = 0x501B;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.154 -0400", hash_original_field = "5ACAD86408D7FB34F7C8968C7C20FEB8", hash_generated_field = "A014A30709D49C2DC6B8230A34D18E63")

    public static final int DEVICE_PROPERTY_FOCUS_METERING_MODE = 0x501C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.156 -0400", hash_original_field = "B7B79B7D680F57D4503D97B6E17EA22F", hash_generated_field = "D8DD77848848D1DF076E0A88E179452F")

    public static final int DEVICE_PROPERTY_UPLOAD_URL = 0x501D;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.157 -0400", hash_original_field = "54134093D78C38877C87EF16AC04C3BB", hash_generated_field = "58AA3169FC8CB80C7800E39AFA30AEF9")

    public static final int DEVICE_PROPERTY_ARTIST = 0x501E;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.159 -0400", hash_original_field = "873976D80ADD10875F5EC507B8738042", hash_generated_field = "538815223F9A222AEC86C7CDB5241BEC")

    public static final int DEVICE_PROPERTY_COPYRIGHT_INFO = 0x501F;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.161 -0400", hash_original_field = "2CAC6C432FC210AD6A39DCC51DD8DA83", hash_generated_field = "48CDBE3B41AF3B631BCC4BE6BBF43F16")

    public static final int DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER = 0xD401;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.163 -0400", hash_original_field = "87C04C487C35FAA006892BABA04FAC35", hash_generated_field = "2F73C995483AC22A9D939C27C3B926AF")

    public static final int DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME = 0xD402;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.165 -0400", hash_original_field = "37F131A9C9D3FE8E27E63B292BBCE7B9", hash_generated_field = "C42F4FE1F19E0971FA651A075F704409")

    public static final int DEVICE_PROPERTY_VOLUME = 0xD403;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.167 -0400", hash_original_field = "9DB82C36700CE623829E129F40AB243E", hash_generated_field = "EBC878ECB7070A15F695A27804A25FCC")

    public static final int DEVICE_PROPERTY_SUPPORTED_FORMATS_ORDERED = 0xD404;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.169 -0400", hash_original_field = "FE227750D16767AF1FB54931115F8943", hash_generated_field = "92E6F3957369DAA972C831166CBE0C20")

    public static final int DEVICE_PROPERTY_DEVICE_ICON = 0xD405;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.170 -0400", hash_original_field = "41BBF9732B5CD62055FCB0361D7F2C65", hash_generated_field = "26D40C9F37CDE89A35C44C51D0F8E78E")

    public static final int DEVICE_PROPERTY_PLAYBACK_RATE = 0xD410;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.172 -0400", hash_original_field = "203A0912549980494C777673C12B5C51", hash_generated_field = "41561BFAA5E25FCB82393607BDF81785")

    public static final int DEVICE_PROPERTY_PLAYBACK_OBJECT = 0xD411;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.174 -0400", hash_original_field = "D54077F50C0C58ACCFA81F69D1BCBE16", hash_generated_field = "849B5CA9C1A291C9CEF5710BD85ACF45")

    public static final int DEVICE_PROPERTY_PLAYBACK_CONTAINER_INDEX = 0xD412;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.175 -0400", hash_original_field = "6FE4BD203327FA5E506CA5AD0E0CE3B8", hash_generated_field = "BA0419042FDCEFF7364DC3BA551A4ADC")

    public static final int DEVICE_PROPERTY_SESSION_INITIATOR_VERSION_INFO = 0xD406;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.177 -0400", hash_original_field = "B070DDCC7B311C66F1E85C05C2EA7014", hash_generated_field = "86221C50F7D683811899400EC66E61CC")

    public static final int DEVICE_PROPERTY_PERCEIVED_DEVICE_TYPE = 0xD407;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.181 -0400", hash_original_field = "F1F995379F7EBA5BAAF2C4515A4805D4", hash_generated_field = "46ED4492420A50288E5F18C7F09A8ECF")

    public static final int PROTECTION_STATUS_NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.183 -0400", hash_original_field = "0899DB40E8FA82C7723124948F2661B3", hash_generated_field = "2335E8A4389010428B3063F7B809D6DF")

    public static final int PROTECTION_STATUS_READ_ONLY = 0x8001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.184 -0400", hash_original_field = "5A265139D928D383E4C6335182CEC3C9", hash_generated_field = "C2D51B18F747F00A6B67E0404AA6119B")

    public static final int PROTECTION_STATUS_READ_ONLY_DATA = 0x8002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.186 -0400", hash_original_field = "548928E5A4DD65DFA67F6ACB715D8246", hash_generated_field = "4E5D35A75C0591BB4A3A4825552C31CF")

    public static final int PROTECTION_STATUS_NON_TRANSFERABLE_DATA = 0x8003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:19.188 -0400", hash_original_field = "E01A561F1563C138C70344A2ED0C8900", hash_generated_field = "2205A5737ABECDA4F5A5A2E3B205BD74")

    public static final int ASSOCIATION_TYPE_GENERIC_FOLDER = 0x0001;
}
