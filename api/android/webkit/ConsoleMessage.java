package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ConsoleMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.503 -0400", hash_original_field = "D3512852EA3D6B78A96B5192CDA7B029", hash_generated_field = "97B0FE7DDC2696309CFA4856C37F4CCB")

    private MessageLevel mLevel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.503 -0400", hash_original_field = "E40274F3EBBA90624D5314C8AC41E0C5", hash_generated_field = "5FF5AC6E2E7DC6F2224CC91B0CC8DE72")

    private String mMessage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.503 -0400", hash_original_field = "A0602330231F796D76F6986E849CC9C0", hash_generated_field = "B2CDD87A3B1C8A195FBE30ADD11DDBDF")

    private String mSourceId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.503 -0400", hash_original_field = "A7E1924A30B7B7623DEB6607AC977A24", hash_generated_field = "5A9E17AF4C282DA03F1D6A7DDEDBF4FD")

    private int mLineNumber;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.504 -0400", hash_original_method = "054E47655FB4B805E39E1B05003FB12B", hash_generated_method = "DDCC7C334FAE0D07349B61B820D51D6B")
    public  ConsoleMessage(String message, String sourceId, int lineNumber, MessageLevel msgLevel) {
        mMessage = message;
        mSourceId = sourceId;
        mLineNumber = lineNumber;
        mLevel = msgLevel;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.504 -0400", hash_original_method = "25C4EE735F0CFD6521F32D3F800D92AC", hash_generated_method = "A9A8F6AB4C653FB79DDD28F6984F308D")
    public MessageLevel messageLevel() {
MessageLevel var05CC33B523E1688D6A6418938B16DC34_1407373806 =         mLevel;
        var05CC33B523E1688D6A6418938B16DC34_1407373806.addTaint(taint);
        return var05CC33B523E1688D6A6418938B16DC34_1407373806;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.505 -0400", hash_original_method = "52DD879A1942417F2863E1B67C410E21", hash_generated_method = "BA8CBB80F0FB17A64DDCF1ACF41A748D")
    public String message() {
String varF433E876D1576C042493660DEE33CDC1_1103553105 =         mMessage;
        varF433E876D1576C042493660DEE33CDC1_1103553105.addTaint(taint);
        return varF433E876D1576C042493660DEE33CDC1_1103553105;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.505 -0400", hash_original_method = "215864977BD1865913F9AFF2A58F69AA", hash_generated_method = "745943D1BA6172EE73873CD78D89D665")
    public String sourceId() {
String var26E715FA700CB10D6478010686DA2BC6_1072522943 =         mSourceId;
        var26E715FA700CB10D6478010686DA2BC6_1072522943.addTaint(taint);
        return var26E715FA700CB10D6478010686DA2BC6_1072522943;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.505 -0400", hash_original_method = "C9721078850915D930C57EA652CD2BDC", hash_generated_method = "1BB6AAD3764678FA256A5A44DC572EB6")
    public int lineNumber() {
        int varA7E1924A30B7B7623DEB6607AC977A24_1224387542 = (mLineNumber);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1507627641 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1507627641;
        
        
    }

    
    public enum MessageLevel {
        TIP,
        LOG,
        WARNING,
        ERROR,
        DEBUG
    }

    
}

