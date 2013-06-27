package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ConsoleMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.860 -0400", hash_original_field = "D3512852EA3D6B78A96B5192CDA7B029", hash_generated_field = "97B0FE7DDC2696309CFA4856C37F4CCB")

    private MessageLevel mLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.860 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

    private String mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.860 -0400", hash_original_field = "A0602330231F796D76F6986E849CC9C0", hash_generated_field = "B2CDD87A3B1C8A195FBE30ADD11DDBDF")

    private String mSourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.860 -0400", hash_original_field = "A7E1924A30B7B7623DEB6607AC977A24", hash_generated_field = "5A9E17AF4C282DA03F1D6A7DDEDBF4FD")

    private int mLineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.862 -0400", hash_original_method = "054E47655FB4B805E39E1B05003FB12B", hash_generated_method = "DDCC7C334FAE0D07349B61B820D51D6B")
    public  ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        mMessage = message;
        mSourceId = sourceId;
        mLineNumber = lineNumber;
        mLevel = msgLevel;
        // ---------- Original Method ----------
        //mMessage = message;
        //mSourceId = sourceId;
        //mLineNumber = lineNumber;
        //mLevel = msgLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.869 -0400", hash_original_method = "25C4EE735F0CFD6521F32D3F800D92AC", hash_generated_method = "43E9C204DDFBE7D50EF18219C8ED3F3A")
    public MessageLevel messageLevel() {
        MessageLevel varB4EAC82CA7396A68D541C85D26508E83_595801241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_595801241 = mLevel;
        varB4EAC82CA7396A68D541C85D26508E83_595801241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_595801241;
        // ---------- Original Method ----------
        //return mLevel;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.869 -0400", hash_original_method = "52DD879A1942417F2863E1B67C410E21", hash_generated_method = "1B3F1D02B4274DC424BF884126FE5B75")
    public String message() {
        String varB4EAC82CA7396A68D541C85D26508E83_996752929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_996752929 = mMessage;
        varB4EAC82CA7396A68D541C85D26508E83_996752929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_996752929;
        // ---------- Original Method ----------
        //return mMessage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.870 -0400", hash_original_method = "215864977BD1865913F9AFF2A58F69AA", hash_generated_method = "15E44A1090ADF8756BBBF801E63A1734")
    public String sourceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1603163774 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1603163774 = mSourceId;
        varB4EAC82CA7396A68D541C85D26508E83_1603163774.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1603163774;
        // ---------- Original Method ----------
        //return mSourceId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:59.870 -0400", hash_original_method = "C9721078850915D930C57EA652CD2BDC", hash_generated_method = "5A6D7B5F799BB80E51FB191349F23838")
    public int lineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409211208 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_409211208;
        // ---------- Original Method ----------
        //return mLineNumber;
    }

    
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    
}

