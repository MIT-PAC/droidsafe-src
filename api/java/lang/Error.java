package java.lang;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Error extends Throwable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.892 -0400", hash_original_method = "7D5BF5C7538ED3BFC2F69913B33169E2", hash_generated_method = "E209531049EACBDCA8E9D86003B7419F")
    public  Error() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.893 -0400", hash_original_method = "C6CAA4A4AF257044103CFF33D3E9FE9A", hash_generated_method = "BA6104F93DF7E632F3B99CCF2AB73EAF")
    public  Error(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.893 -0400", hash_original_method = "66AA244741442CFF9E9D4A286C858491", hash_generated_method = "4D0727CB1564BB7B16A075EAA0BF5DA2")
    public  Error(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
        addTaint(throwable.getTaint());
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.894 -0400", hash_original_method = "4F891171DD00932FF603BE77BF813093", hash_generated_method = "591CF6D45CBAB7010B583E4819898275")
    public  Error(Throwable throwable) {
        super(throwable);
        addTaint(throwable.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:46.894 -0400", hash_original_field = "AA057B31F5429D746265653A5C2D4BB1", hash_generated_field = "0C6BB99ACF2AC755166A071BFA44B261")

    private static final long serialVersionUID = 4980196508277280342L;
}

