package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class ConsoleMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.142 -0400", hash_original_field = "D3512852EA3D6B78A96B5192CDA7B029", hash_generated_field = "97B0FE7DDC2696309CFA4856C37F4CCB")

    private MessageLevel mLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.142 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

    private String mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.142 -0400", hash_original_field = "A0602330231F796D76F6986E849CC9C0", hash_generated_field = "B2CDD87A3B1C8A195FBE30ADD11DDBDF")

    private String mSourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.142 -0400", hash_original_field = "A7E1924A30B7B7623DEB6607AC977A24", hash_generated_field = "5A9E17AF4C282DA03F1D6A7DDEDBF4FD")

    private int mLineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.142 -0400", hash_original_method = "054E47655FB4B805E39E1B05003FB12B", hash_generated_method = "DDCC7C334FAE0D07349B61B820D51D6B")
    public  ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        mMessage = message;
        mSourceId = sourceId;
        mLineNumber = lineNumber;
        mLevel = msgLevel;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.143 -0400", hash_original_method = "25C4EE735F0CFD6521F32D3F800D92AC", hash_generated_method = "2632424AF9D613598B7BB5C0C37BC789")
    public MessageLevel messageLevel() {
        MessageLevel varB4EAC82CA7396A68D541C85D26508E83_188621800 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_188621800 = mLevel;
        varB4EAC82CA7396A68D541C85D26508E83_188621800.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_188621800;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.144 -0400", hash_original_method = "52DD879A1942417F2863E1B67C410E21", hash_generated_method = "35127B2F93D1103418D4DAADF9B170FC")
    public String message() {
        String varB4EAC82CA7396A68D541C85D26508E83_866999319 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_866999319 = mMessage;
        varB4EAC82CA7396A68D541C85D26508E83_866999319.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_866999319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.144 -0400", hash_original_method = "215864977BD1865913F9AFF2A58F69AA", hash_generated_method = "DAD077EA35EB841882004D3CB9310AB1")
    public String sourceId() {
        String varB4EAC82CA7396A68D541C85D26508E83_477453321 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_477453321 = mSourceId;
        varB4EAC82CA7396A68D541C85D26508E83_477453321.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_477453321;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.145 -0400", hash_original_method = "C9721078850915D930C57EA652CD2BDC", hash_generated_method = "7E3E5DC00BD00F9D2F201F97A175442F")
    public int lineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143580671 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143580671;
        
        
    }

    
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    
}

