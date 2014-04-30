/*
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

package libcore.icu;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.text.Normalizer.Form;

public final class NativeNormalizer {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.264 -0400", hash_original_method = "D65E70031181AB5D265A8C6523D0F124", hash_generated_method = "1C313D14AF4530C20D33D0C81612E0F5")
    
public static boolean isNormalized(CharSequence src, Form form) {
        return isNormalizedImpl(src.toString(), toUNormalizationMode(form));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.266 -0400", hash_original_method = "1936BE9F2FD43F2EE4C7AD314CF6F77D", hash_generated_method = "F54559CE100D4113BCC2E91A207C75A8")
    
public static String normalize(CharSequence src, Form form) {
        return normalizeImpl(src.toString(), toUNormalizationMode(form));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.268 -0400", hash_original_method = "5AE67B19E0FEDFA45F97C74716CE3C5C", hash_generated_method = "27454E537866AAD6A83D3359E696A5B0")
    
private static int toUNormalizationMode(Form form) {
        // Translates Java enum constants to ICU int constants.
        // See UNormalizationMode in "unicode/unorm.h". Stable API since ICU 2.0.
        switch (form) {
        case NFC: return 4;
        case NFD: return 2;
        case NFKC: return 5;
        case NFKD: return 3;
        }
        throw new AssertionError("unknown Normalizer.Form " + form);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:31:16.526 -0400", hash_original_method = "5A0C8E109474D9610F76A5151F849B6A", hash_generated_method = "EEB38B81661E2216410961FADAF66532")
    
    private static String normalizeImpl(String src, int form){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += src.getTaintInt();
    	taintDouble += form;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:31:16.529 -0400", hash_original_method = "EE3335322C022FC69A7D7D5DDF7823DA", hash_generated_method = "D56D3F268C39B2DC47AF16A25FCEDF01")
    
    private static boolean isNormalizedImpl(String src, int form){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += src.getTaintInt();
    	taintDouble += form;
    
    	return toTaintBoolean(taintDouble);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:13:48.274 -0400", hash_original_method = "8A2F14029E65BB1B41923DA00040CBFE", hash_generated_method = "B72D1261B946E0DC337363522C54BB8A")
    
private NativeNormalizer() {}
}
