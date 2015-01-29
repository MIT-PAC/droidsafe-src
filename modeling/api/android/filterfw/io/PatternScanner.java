/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.filterfw.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @hide
 */
public class PatternScanner {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.304 -0400", hash_original_field = "A290E50B8177A9884997E916D2C15C66", hash_generated_field = "9DC1ACB3C7BF5C4637BD2832D9A95C39")


    private String mInput;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.306 -0400", hash_original_field = "AA5BC122BFD3FDE09C3C0798CC21DA9D", hash_generated_field = "DEAF1394A7999A31C0E2528E6FD2ED3D")

    private Pattern mIgnorePattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.308 -0400", hash_original_field = "9903C734D96A80C6871FB08938C010EE", hash_generated_field = "435D9FD8F79260F74ED3D88EC0019701")

    private int mOffset = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.310 -0400", hash_original_field = "B1DBA9E43F531923ABB5D2189CB944B0", hash_generated_field = "1680A9483C717DCA108BD9A19621310B")

    private int mLineNo = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.312 -0400", hash_original_field = "99D7C1F4F34BECC62A7843FDDCD301BB", hash_generated_field = "0CFF0315C2E38DCED8193220F3D64906")

    private int mStartOfLine = 0;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.315 -0400", hash_original_method = "1DBABFC33955166DF59C2E5D01EBCCC6", hash_generated_method = "AEAEBF81AF90D5D949215C414D268FB8")
    
public PatternScanner(String input) {
        mInput = input;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.317 -0400", hash_original_method = "673B37C4F59E021E6DBA5DF51AFBAEAA", hash_generated_method = "4D275FCA4C06F89A53D6C157446D1938")
    
public PatternScanner(String input, Pattern ignorePattern) {
        mInput = input;
        mIgnorePattern = ignorePattern;
        skip(mIgnorePattern);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.320 -0400", hash_original_method = "6F09EFC9900EDAFDE9F62F82EE45B407", hash_generated_method = "DE9E825175A58AE4EBE2BF08E82C96EF")
    
public String tryEat(Pattern pattern) {
        // Skip ignore pattern
        if (mIgnorePattern != null) {
            skip(mIgnorePattern);
        }

        // Create the matcher
        Matcher matcher = pattern.matcher(mInput);
        matcher.region(mOffset, mInput.length());

        // Attempt to match
        String result = null;
        if (matcher.lookingAt()) {
            updateLineCount(mOffset, matcher.end());
            mOffset = matcher.end();
            result = mInput.substring(matcher.start(), matcher.end());
        }

        // Skip ignore pattern
        if (result != null && mIgnorePattern != null) {
            skip(mIgnorePattern);
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.323 -0400", hash_original_method = "263CC4F15D5904D99A1467CF34290907", hash_generated_method = "5D4BA42F7A342B9206F9436530BFF296")
    
public String eat(Pattern pattern, String tokenName) {
        String result = tryEat(pattern);
        if (result == null) {
            throw new RuntimeException(unexpectedTokenMessage(tokenName));
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.325 -0400", hash_original_method = "65FF435DAE06C0A8E9E6A723E69B4B79", hash_generated_method = "4850C386FA3BDD95A9D93E35DA7362D1")
    
public boolean peek(Pattern pattern) {
        // Skip ignore pattern
        if (mIgnorePattern != null) {
            skip(mIgnorePattern);
        }

        // Create the matcher
        Matcher matcher = pattern.matcher(mInput);
        matcher.region(mOffset, mInput.length());

        // Attempt to match
        return matcher.lookingAt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.327 -0400", hash_original_method = "B287E65CA236FAC470609ED603A8963F", hash_generated_method = "C045CA8BC6C017F179919A683519C946")
    
public void skip(Pattern pattern) {
        Matcher matcher = pattern.matcher(mInput);
        matcher.region(mOffset, mInput.length());
        if (matcher.lookingAt()) {
            updateLineCount(mOffset, matcher.end());
            mOffset = matcher.end();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.329 -0400", hash_original_method = "A5C522DF0CF1E7756E40ED1CE7F9B1C0", hash_generated_method = "C9FAC82345B629201DF298D30E41FD88")
    
public boolean atEnd() {
        return mOffset >= mInput.length();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.331 -0400", hash_original_method = "1D877AD83D5DAE03FB9F330E2626E51B", hash_generated_method = "658DF92CBEB8D7B87A3317DCD325900F")
    
public int lineNo() {
        return mLineNo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.333 -0400", hash_original_method = "D7AC73CCF962EB4E35EED7CE7F39CE72", hash_generated_method = "E65C371B62A886582A8F70395ECAC208")
    
public String unexpectedTokenMessage(String tokenName) {
        String line = mInput.substring(mStartOfLine, mOffset);
        return "Unexpected token on line " + (mLineNo + 1) + " after '" + line + "' <- Expected " +
                tokenName + "!";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:13.335 -0400", hash_original_method = "E712B254712A6675EC077F9E86560C54", hash_generated_method = "63CFD6CF11CFB5E00D3092989D77D5F3")
    
public void updateLineCount(int start, int end) {
        for (int i = start; i < end; ++i) {
            if (mInput.charAt(i) == '\n') {
                ++mLineNo;
                mStartOfLine = i + 1;
            }
        }
    }
}
