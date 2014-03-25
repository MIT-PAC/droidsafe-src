/*
 * Copyright (C) 2007 The Android Open Source Project
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

package android.bluetooth;

/**
 * The result of execution of an single AT command.<p>
 *
 *
 * This class can represent the final response to an AT command line, and also
 * intermediate responses to a single command within a chained AT command
 * line.<p>
 *
 * The actual responses that are intended to be send in reply to the AT command
 * line are stored in a string array. The final response is stored as an
 * int enum, converted to a string when toString() is called. Only a single
 * final response is sent from multiple commands chained into a single command
 * line.<p>
 * @hide
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class AtCommandResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.750 -0400", hash_original_field = "AE73E45FFFE246F04DC13AA08C45502F", hash_generated_field = "C5FF52EE5D3BB415E628F5D7B81CBD5E")

    public static final int OK = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.756 -0400", hash_original_field = "978AE58344B7583D6BC144F01B4A89F4", hash_generated_field = "9D5FE7A66E8E9BF6DF18D5C3009E6D60")

    public static final int ERROR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.762 -0400", hash_original_field = "F17A3656D9C83D403F553FA6E3BCC447", hash_generated_field = "26132624335BE812F5097C6F660514C2")

    public static final int UNSOLICITED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.769 -0400", hash_original_field = "247CFCEF9016A799EC82850A78AB69B7", hash_generated_field = "BBE0EFD251553EA6A35912C61D58EA05")


    private static final String OK_STRING = "OK";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.775 -0400", hash_original_field = "D67D42C3428CE72B49351E289A5E8E14", hash_generated_field = "69CD18B35BAB5C84293AE2F554F99E83")

    private static final String ERROR_STRING = "ERROR";

    /** Append a string to a string builder, joining with a double
     * CRLF. Used to create multi-line AT command replies
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.830 -0400", hash_original_method = "187DE99AA0E1DE90079EFA680A537E40", hash_generated_method = "1C74B89D172F15018116D3ADD78FF4C3")
    
public static void appendWithCrlf(StringBuilder str1, String str2) {
        if (str1.length() > 0 && str2.length() > 0) {
            str1.append("\r\n\r\n");
        }
        str1.append(str2);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.781 -0400", hash_original_field = "457E6BFD9A88F809DF3F4A88B9B7B893", hash_generated_field = "77069BAE5867220B0011AB47341F29C2")


    private int mResultCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.786 -0400", hash_original_field = "01B3C4998D6877BEE3F4439459EFC534", hash_generated_field = "ADC1F85C044EB0895B134C7CFC5796B6")

    private StringBuilder mResponse; // Response with CRLF line breaks

    /**
     * Construct a new AtCommandResult with given result code, and an empty
     * response array.
     * @param resultCode One of OK, ERROR or UNSOLICITED.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.792 -0400", hash_original_method = "0CA47F85F22831C76265289E7FD79125", hash_generated_method = "340A64C4C0FDF834096B8227F2AD7752")
    
public AtCommandResult(int resultCode) {
        mResultCode = resultCode;
        mResponse = new StringBuilder();
    }

    /**
     * Construct a new AtCommandResult with result code OK, and the specified
     * single line response.
     * @param response The single line response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.798 -0400", hash_original_method = "155F0203C202F1398DFC75532D56E514", hash_generated_method = "5A56BE707FE15F6C15227B28F36F194C")
    
public AtCommandResult(String response) {
        this(OK);
        addResponse(response);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.803 -0400", hash_original_method = "DAC102A9F551BEDDEF83F16167EFAEA6", hash_generated_method = "BAB089F9DACBDE2D78C92F55EB927359")
    
public int getResultCode() {
        return mResultCode;
    }

    /**
     * Add another line to the response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.809 -0400", hash_original_method = "E682935B1A0A2E688E0EDE52B81DA148", hash_generated_method = "7A41EE5AA907CDB020EFC139D49BB6F2")
    
public void addResponse(String response) {
        appendWithCrlf(mResponse, response);
    }

    /**
     * Add the given result into this AtCommandResult object.<p>
     * Used to combine results from multiple commands in a single command line
     * (command chaining).
     * @param result The AtCommandResult to add to this result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.814 -0400", hash_original_method = "4E6C71D5BCD272CA07436B720BF5B1F8", hash_generated_method = "EAB759B5144D2E7BBDE49353860A94CD")
    
public void addResult(AtCommandResult result) {
        if (result != null) {
            appendWithCrlf(mResponse, result.mResponse.toString());
            mResultCode = result.mResultCode;
        }
    }

    /**
     * Generate the string response ready to send
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 15:32:00.823 -0400", hash_original_method = "F45749C038E3DA7A80BFF6F195583EB7", hash_generated_method = "27DF04D1A08681E2AEA2289C7DD9B109")
    
public String toString() {
        StringBuilder result = new StringBuilder(mResponse.toString());
        switch (mResultCode) {
        case OK:
            appendWithCrlf(result, OK_STRING);
            break;
        case ERROR:
            appendWithCrlf(result, ERROR_STRING);
            break;
        }
        return result.toString();
    }
};
