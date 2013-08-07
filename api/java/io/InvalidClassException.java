package java.io;

// Droidsafe Imports
import droidsafe.annotations.*;





public class InvalidClassException extends ObjectStreamException {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.135 -0400", hash_original_field = "26B2A720F7B8C9BD8D3999C52DA409D0", hash_generated_field = "B0C75E444ABFD30811DA4022885A4FE7")

    public String classname;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.135 -0400", hash_original_method = "EFF9B20162E74D1DBB80ACE44E70A573", hash_generated_method = "F8B3DAD56180F56E19D0C8EF9347D6B4")
    public  InvalidClassException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.136 -0400", hash_original_method = "A0014C5B63B7954D0D217FAB7EAA1F21", hash_generated_method = "63D5E8FE9E01F9230EB120DE904250B6")
    public  InvalidClassException(String className, String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        this.classname = className;
        // ---------- Original Method ----------
        //this.classname = className;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.136 -0400", hash_original_method = "F4D165DC6F6D9B89EF49B0E2E4445877", hash_generated_method = "2FDE4C90979F45C05A9F154547656CD5")
    @Override
    public String getMessage() {
        String msg = super.getMessage();
        if(classname != null)        
        {
            msg = classname + "; " + msg;
        } //End block
String varEDC5B72465A7F0BEE288689BCB1DD141_1986200140 =         msg;
        varEDC5B72465A7F0BEE288689BCB1DD141_1986200140.addTaint(taint);
        return varEDC5B72465A7F0BEE288689BCB1DD141_1986200140;
        // ---------- Original Method ----------
        //String msg = super.getMessage();
        //if (classname != null) {
            //msg = classname + "; " + msg;
        //}
        //return msg;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:44.136 -0400", hash_original_field = "72D7A703CD0FB4057452DEA0641D5BCD", hash_generated_field = "D4E2FCFAAD906D95CB6BCEB015D3083F")

    private static final long serialVersionUID = -4333316296251054416L;
}

