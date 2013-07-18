package java.nio.charset;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MalformedInputException extends CharacterCodingException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.661 -0400", hash_original_field = "041709F4FF2A8080D6F626D7CB84757B", hash_generated_field = "939A3890EE1598347B6974B9F9310D43")

    private int inputLength;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.661 -0400", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "8016B46A7DF01A09F456F05131FC6411")
    public  MalformedInputException(int length) {
        this.inputLength = length;
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.662 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "A5CFF569EC8CEB726074F3BAD3E1C271")
    public int getInputLength() {
        int varF1CEB9E26A0768A795CBAD9C5D7C65DC_70897077 = (this.inputLength);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574268066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_574268066;
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.662 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "4B9AD19AB9278C6D137F24712D022740")
    @Override
    public String getMessage() {
String var81FD86717EF7CC5DC6C9094CF8A5F984_720493170 =         "Length: " + inputLength;
        var81FD86717EF7CC5DC6C9094CF8A5F984_720493170.addTaint(taint);
        return var81FD86717EF7CC5DC6C9094CF8A5F984_720493170;
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.662 -0400", hash_original_field = "95AAF9962932929B8D57DEC535383638", hash_generated_field = "AD2DD481E60844E3D7253976946DDA58")

    private static final long serialVersionUID = -3438823399834806194L;
}

