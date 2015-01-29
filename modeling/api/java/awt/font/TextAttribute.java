/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
/**
 * @author Ilya S. Okomin
 * @version $Revision$
 */
package java.awt.font;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.text.AttributedCharacterIterator.Attribute;

/**
 * The TextAttribute class defines attribute keys and attribute values
 * for text rendering. Each TextAttributes should have the following
 * information:
 * <ul>
 * <li>key name;</li>
 * <li>valid values;</li>
 * <li>relevant constants;</li>
 * <li>default action if the attribute is absent;</li>
 * <li>default action's description.</li>
 * </ul>
 */
public final class TextAttribute extends Attribute {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.303 -0400", hash_original_field = "D4DAF953A48C7289DC7C967D60D5B675", hash_generated_field = "4AF3E36B295DA7F5A76B34A57B4D9D4F")

    private static final long serialVersionUID = 7744112784117861702L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.306 -0400", hash_original_field = "8C96C1E181850FA1C1CAA2752F78EABD", hash_generated_field = "B9D2F183CBBF0F028A851AE464060418")

    public static final TextAttribute BACKGROUND = new TextAttribute("background");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.308 -0400", hash_original_field = "21FDBB909CD6A2C68D7FB1AF31FA1429", hash_generated_field = "7D9EC4AFE08DCE886ED0667A77F1DF8A")

    public static final TextAttribute BIDI_EMBEDDING = new TextAttribute("bidi_embedding");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.309 -0400", hash_original_field = "C8BACE7F49EBEF2E6D83C81E4BB28314", hash_generated_field = "CF7A0C9752DC1D2795F1627C5C214E53")

    public static final TextAttribute CHAR_REPLACEMENT = new TextAttribute("char_replacement");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.311 -0400", hash_original_field = "953C973927FEE0CE867FE67DE9A92E45", hash_generated_field = "17C8EE8109C9AF5E3FFFE5F4F513D73B")

    public static final TextAttribute FAMILY = new TextAttribute("family");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.313 -0400", hash_original_field = "15C792440053C4026191066A60807F44", hash_generated_field = "A6402368FDCBBBFE245739559610E3F4")

    public static final TextAttribute FONT = new TextAttribute("font");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.314 -0400", hash_original_field = "3594D1CE1CC85C0EF49D22B1B26B286F", hash_generated_field = "D620FE98929DBD9F43ED9821382063C7")

    public static final TextAttribute FOREGROUND = new TextAttribute("foreground");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.316 -0400", hash_original_field = "736DD11007647A8046FE805193CBAD43", hash_generated_field = "628E8CF8B87D78D75D426E0329986121")

    public static final TextAttribute INPUT_METHOD_HIGHLIGHT = new TextAttribute(
            "input method highlight");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.317 -0400", hash_original_field = "02FA77C4A09BE6BCE0693BCAA0EE590C", hash_generated_field = "F1A6036010F8FC2BD21720CE35CB9258")

    public static final TextAttribute INPUT_METHOD_UNDERLINE = new TextAttribute(
            "input method underline");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.319 -0400", hash_original_field = "726ED9AEE79F8A4B64506F79F8F5851C", hash_generated_field = "D6DDDC9B00BC2C85A536D837494BCDDA")

    public static final TextAttribute JUSTIFICATION = new TextAttribute("justification");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.320 -0400", hash_original_field = "90F9BB782D1871E4B233E29C9538BA8A", hash_generated_field = "B7C5DE3796F51A31E3E330D743719DFE")

    public static final Float JUSTIFICATION_FULL = new Float(1.0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.322 -0400", hash_original_field = "C1E2740B179A38B3B3508DEC9E8917BE", hash_generated_field = "DFC43B12F99B18207625F02E0747C090")

    public static final Float JUSTIFICATION_NONE = new Float(0.0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.323 -0400", hash_original_field = "9830E5D6B5A478764A6EA395CADD0C21", hash_generated_field = "986B575FBE886E6EEF97D719640E7C32")

    public static final TextAttribute KERNING = new TextAttribute("kerning");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.325 -0400", hash_original_field = "3D002B44591CC21F35D417223B468893", hash_generated_field = "5580F8246258F574404B213799ABB8B5")

    public static final Integer KERNING_ON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.326 -0400", hash_original_field = "39120652070684C8DED81F6C91619745", hash_generated_field = "1D27A2094FAED8AF4EE37FF90614E1C0")

    public static final TextAttribute LIGATURES = new TextAttribute("ligatures");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.328 -0400", hash_original_field = "4104314A69F6046B3CCC40414BA6F2F5", hash_generated_field = "6598DD12FF0D0577EFC6666440EFCEF9")

    public static final Integer LIGATURES_ON = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.329 -0400", hash_original_field = "93C696AB672778D141D4F3F5FB4ABA93", hash_generated_field = "316F500F60EBE87D4B743783F9E3E87C")

    public static final TextAttribute NUMERIC_SHAPING = new TextAttribute("numeric_shaping");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.331 -0400", hash_original_field = "70D6DAB8431FA9FDA2C1924F54F0835E", hash_generated_field = "3175DB1FAC5E0ECF9385766F09E65500")

    public static final TextAttribute POSTURE = new TextAttribute("posture");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.333 -0400", hash_original_field = "0114FCD254BD721E0091FF907484EC81", hash_generated_field = "185C8E084D42D9087DA907AC4E76EF88")

    public static final Float POSTURE_REGULAR = new Float(0.0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.334 -0400", hash_original_field = "9A5855A2CF9F7C896B36C35BC5EE3986", hash_generated_field = "8204DC3F8F1146943F73868D60CD0260")

    public static final Float POSTURE_OBLIQUE = new Float(0.20f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.336 -0400", hash_original_field = "E306A8E5E6EE4BCF6B1F69B96E74E64E", hash_generated_field = "EA9517A98BBDD61BDF2B286024F2C354")

    public static final TextAttribute RUN_DIRECTION = new TextAttribute("run_direction");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.338 -0400", hash_original_field = "1108D214E944A6C2DC63DF5264E76A5F", hash_generated_field = "9E9E176B19A2AFE5BFD603CA5E9277A3")

    public static final Boolean RUN_DIRECTION_LTR = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.340 -0400", hash_original_field = "9986C3DD1017C9749C88C651AFA27B0A", hash_generated_field = "D62E7A8EEEC762F47BBE2A4A488AD817")

    public static final Boolean RUN_DIRECTION_RTL = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.342 -0400", hash_original_field = "F9A3E3730830387C587BC66170E0C3A9", hash_generated_field = "85647C81751BD2B5D47B1F6CBF7124EC")

    public static final TextAttribute SIZE = new TextAttribute("size");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.344 -0400", hash_original_field = "967D19027818659EC1CAF8C86089B6C3", hash_generated_field = "26388274EB71F4BF63F4B6CCA4C78693")

    public static final TextAttribute STRIKETHROUGH = new TextAttribute("strikethrough");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.345 -0400", hash_original_field = "C56E19627BA576C5FF65675D2D34FADF", hash_generated_field = "6A23CD26A0CB1FEEAF182F217BFF90EF")

    public static final Boolean STRIKETHROUGH_ON = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.347 -0400", hash_original_field = "F7575B1E817CEA1E5EB0E9868738E7F8", hash_generated_field = "3F809892ADD994253DC0C20F683B1E81")

    public static final TextAttribute SUPERSCRIPT = new TextAttribute("superscript");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.348 -0400", hash_original_field = "8906882BF042E96906DFFD8819E22BC6", hash_generated_field = "BFF98A3B98BF65B727975C581E595CFD")

    public static final Integer SUPERSCRIPT_SUB = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.350 -0400", hash_original_field = "C65ECC7780981AF7771DA55D8442ED22", hash_generated_field = "35D47C333A4E64C2DC592AFEEB70D994")

    public static final Integer SUPERSCRIPT_SUPER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.351 -0400", hash_original_field = "9F4CC376791518BA2627C0F4D0DECE50", hash_generated_field = "25844543760C09F72D0B1DD79C96E000")

    public static final TextAttribute SWAP_COLORS = new TextAttribute("swap_colors");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.353 -0400", hash_original_field = "DB1FBC73A3353D65E9710468C8BAC191", hash_generated_field = "82B515229D3BD257B2CFF23D3960874F")

    public static final Boolean SWAP_COLORS_ON = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.354 -0400", hash_original_field = "3BDAB4AF8145D80D99B62535133C2AC1", hash_generated_field = "348C9F62D89A8887C13DB3537B240073")

    public static final TextAttribute TRACKING = new TextAttribute("tracking");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.357 -0400", hash_original_field = "A80DBB14548245FE9C243856DF881B5F", hash_generated_field = "92781D5523D63F97154688A0D2A48D5D")

    public static final Float TRACKING_LOOSE = 0.04f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.358 -0400", hash_original_field = "E8CCF9DDFC575F8D967067F7F5FBBC5F", hash_generated_field = "533D243332AE225D89F623C472ED3080")

    public static final Float TRACKING_TIGHT = -0.04f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.360 -0400", hash_original_field = "9C63816711D0496C56C277D3DC6FC381", hash_generated_field = "A6DD51764123D576EE85D224DF488BE7")

    public static final TextAttribute TRANSFORM = new TextAttribute("transform");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.361 -0400", hash_original_field = "F31AE54EBDFF7B07C680ACED496E7FCD", hash_generated_field = "D73D742049BE2AED4B5EE3853D941F0F")

    public static final TextAttribute UNDERLINE = new TextAttribute("underline");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.363 -0400", hash_original_field = "D8AD5E022C55C3F507AF7D69394FF8F8", hash_generated_field = "8A26F12807CE8B4E7BAFDE94E6B9CAC2")

    public static final Integer UNDERLINE_ON = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.365 -0400", hash_original_field = "63ADF52879020712316C68577DD21ABE", hash_generated_field = "F66896C2FD589C8A24251B583E5790CF")

    public static final Integer UNDERLINE_LOW_ONE_PIXEL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.366 -0400", hash_original_field = "14BB1FAAFAC5FFB8642F927A0745968A", hash_generated_field = "59BD53B160AB6753B1297DECCB821B46")

    public static final Integer UNDERLINE_LOW_TWO_PIXEL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.368 -0400", hash_original_field = "B4B33B2BF526C2D227CEB41713ADFED1", hash_generated_field = "B4FAA5183FB6218C20940B07C2910785")

    public static final Integer UNDERLINE_LOW_DOTTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.370 -0400", hash_original_field = "1B5D6E2D8362144D2F5550A45DC275B5", hash_generated_field = "0C854CE1D22A258E8F00C771EDC97234")

    public static final Integer UNDERLINE_LOW_GRAY = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.371 -0400", hash_original_field = "07353FF29069F5A852E847E90A55B77B", hash_generated_field = "1B00C69354EAD0AFB9FB22B642B72F06")

    public static final Integer UNDERLINE_LOW_DASHED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.373 -0400", hash_original_field = "9F55A0E2F3C80A50E2EE3DDCE773DE57", hash_generated_field = "4C5A422F95E1AA81FE03DB05B119E46A")

    public static final TextAttribute WEIGHT = new TextAttribute("weight");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.374 -0400", hash_original_field = "1DE331E160405646518A876876F98C93", hash_generated_field = "A9D282B37FDD2D331903C65728FB2EB9")

    public static final Float WEIGHT_EXTRA_LIGHT = new Float(0.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.376 -0400", hash_original_field = "EC51B24DBC93C491F610FAC1F285AC56", hash_generated_field = "8201679293C050C625F0E6CFD2F5ACAD")

    public static final Float WEIGHT_LIGHT = new Float(0.75f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.378 -0400", hash_original_field = "CB5C69B855F65C08F0D3EC1B1ECDEA15", hash_generated_field = "69D4BB9D2E6F068EE4EDBB4F4DFEC4E6")

    public static final Float WEIGHT_DEMILIGHT = new Float(0.875f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.379 -0400", hash_original_field = "D3FF1D42ACAC3DAB4F1266CC0137BEF8", hash_generated_field = "4314D341BEB92857336EDDC8872CA0FB")

    public static final Float WEIGHT_REGULAR = new Float(1.0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.381 -0400", hash_original_field = "DA324B98D0F64735C7EBDFCB01216F56", hash_generated_field = "D8F0CE2A38EA07875D05104BB5CA789D")

    public static final Float WEIGHT_SEMIBOLD = new Float(1.25f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.383 -0400", hash_original_field = "20F1DACF37A491E4E8C3EE7B829B5853", hash_generated_field = "0063849BB781A328B9578B195FB1421B")

    public static final Float WEIGHT_MEDIUM = new Float(1.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.386 -0400", hash_original_field = "C35C502D0044B5E1DE9B660ADBDB87E2", hash_generated_field = "4F32C058DD1DB6003972D95776412B93")

    public static final Float WEIGHT_DEMIBOLD = new Float(1.75f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.389 -0400", hash_original_field = "BF4F534A93DA2E3C668F03D45CC520D0", hash_generated_field = "39AC43EEA399126D0E4C49FD28FC0A9F")

    public static final Float WEIGHT_BOLD = new Float(2.0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.392 -0400", hash_original_field = "5C7CE7B9E4BEE47BDA6AAE86131C761E", hash_generated_field = "665669DC961992FAB6CAF0AF4356042B")

    public static final Float WEIGHT_HEAVY = new Float(2.25f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.395 -0400", hash_original_field = "A366FE75976CF10AF207E44F8B3F39D9", hash_generated_field = "1626CD15D4C76D495D37E58747A50E8D")

    public static final Float WEIGHT_EXTRABOLD = new Float(2.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.396 -0400", hash_original_field = "43DA27423AFB73C6BF42F50DA91CE703", hash_generated_field = "5CF9380ED122C8F97A755F62972642DE")

    public static final Float WEIGHT_ULTRABOLD = new Float(2.75f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.398 -0400", hash_original_field = "5DE98C3E18E447EAD490E74DA01000CE", hash_generated_field = "FAD1282FD4F69CC5BD106C9784817C76")

    public static final TextAttribute WIDTH = new TextAttribute("width");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.400 -0400", hash_original_field = "F603620E255043B5625A3B46648823CF", hash_generated_field = "CF7CC27E779AE5B20FFE54F652637EF3")

    public static final Float WIDTH_CONDENSED = new Float(0.75f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.402 -0400", hash_original_field = "508879E60224AAD5D843EB5243F3E0EC", hash_generated_field = "170B24171AAC8058C96ECB7089440E7D")

    public static final Float WIDTH_SEMI_CONDENSED = new Float(0.875f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.404 -0400", hash_original_field = "D8D3E3EB4FBE21F57B1F37541055B24D", hash_generated_field = "47BC2BBBF9C93840015074838BCFF39E")

    public static final Float WIDTH_REGULAR = new Float(1.0f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.405 -0400", hash_original_field = "B0648F1136B53866D2EC184B90FFCDF7", hash_generated_field = "F31CD845D39CC5E433B7A49AC05FD99C")

    public static final Float WIDTH_SEMI_EXTENDED = new Float(1.25f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.407 -0400", hash_original_field = "D812AB76A2C3611C5214F9A54AAED043", hash_generated_field = "F14A28289258E8E53148059980FEE7AF")

    public static final Float WIDTH_EXTENDED = new Float(1.5f);

    /**
     * Instantiates a new TextAttribute with the specified name.
     *
     * @param name the name of TextAttribute.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:12.305 -0400", hash_original_method = "15EB03FA0194F74DE4425326F21E5173", hash_generated_method = "C5FCD57BCC48D6AB7F2665345C0A88DA")
    
protected TextAttribute(String name) {
        super(name);
    }

}
