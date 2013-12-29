package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ConsoleMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.081 -0500", hash_original_field = "F8DBE95D4F9FC496EF752033A947CDF7", hash_generated_field = "97B0FE7DDC2696309CFA4856C37F4CCB")


    private MessageLevel mLevel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.082 -0500", hash_original_field = "AA6F183B8C0E9B6C851D4101DE6EFB65", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

    private String mMessage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.083 -0500", hash_original_field = "CC44D0A5A7ED4E3D9B0336B49DE14711", hash_generated_field = "B2CDD87A3B1C8A195FBE30ADD11DDBDF")

    private String mSourceId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.083 -0500", hash_original_field = "DEE863AC3FDA1E17F5CF881E973FC5C9", hash_generated_field = "5A9E17AF4C282DA03F1D6A7DDEDBF4FD")

    private int mLineNumber;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.084 -0500", hash_original_method = "054E47655FB4B805E39E1B05003FB12B", hash_generated_method = "2F5D3148E4FCB4C360EE2AEFE0793083")
    public ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        mMessage = message;
        mSourceId = sourceId;
        mLineNumber = lineNumber;
        mLevel = msgLevel;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.085 -0500", hash_original_method = "25C4EE735F0CFD6521F32D3F800D92AC", hash_generated_method = "18210675C93B752F02E9F36B0D2705A0")
    public MessageLevel messageLevel() {
        return mLevel;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.086 -0500", hash_original_method = "52DD879A1942417F2863E1B67C410E21", hash_generated_method = "696134DC9B45CAD98841BD668933B616")
    public String message() {
        return mMessage;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.087 -0500", hash_original_method = "215864977BD1865913F9AFF2A58F69AA", hash_generated_method = "2B7A356270C97681BD159D243FB405BC")
    public String sourceId() {
        return mSourceId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:32.087 -0500", hash_original_method = "C9721078850915D930C57EA652CD2BDC", hash_generated_method = "5F771892077D7F83A1324845BF2E2355")
    public int lineNumber() {
        return mLineNumber;
    }

    
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    
}

