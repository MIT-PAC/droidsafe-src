package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class URISyntaxException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.627 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.627 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.628 -0400", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "75306DCFD3F9DC065BB602B510176B2F")
    public  URISyntaxException(String input, String reason, int index) {
        super(reason);
        addTaint(reason.getTaint());
    if(input == null || reason == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_2047424473 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_2047424473.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_2047424473;
        } //End block
    if(index < -1)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1121630028 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1121630028.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1121630028;
        } //End block
        this.input = input;
        this.index = index;
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //if (index < -1) {
            //throw new IllegalArgumentException();
        //}
        //this.input = input;
        //this.index = index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.629 -0400", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "B73A4ECEA0499FECFFF695F3DD06AD19")
    public  URISyntaxException(String input, String reason) {
        super(reason);
        addTaint(reason.getTaint());
    if(input == null || reason == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1067851148 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1067851148.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1067851148;
        } //End block
        this.input = input;
        index = -1;
        // ---------- Original Method ----------
        //if (input == null || reason == null) {
            //throw new NullPointerException();
        //}
        //this.input = input;
        //index = -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.629 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "596F68341C53FEE0168B77793E43F26C")
    public int getIndex() {
        int var6A992D5529F459A44FEE58C733255E86_882234229 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577167281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577167281;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.630 -0400", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "96C7F511974ABCD6EC04988593501E64")
    public String getReason() {
String var1F56B99E8E42A81BCA45826E1719D3B0_410704981 =         super.getMessage();
        var1F56B99E8E42A81BCA45826E1719D3B0_410704981.addTaint(taint);
        return var1F56B99E8E42A81BCA45826E1719D3B0_410704981;
        // ---------- Original Method ----------
        //return super.getMessage();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.630 -0400", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "2D944DBA7CDCABA780492BAF1A81E0E5")
    public String getInput() {
String var5B0B1B23FE12EB4FF686B5A845BE063F_556133486 =         input;
        var5B0B1B23FE12EB4FF686B5A845BE063F_556133486.addTaint(taint);
        return var5B0B1B23FE12EB4FF686B5A845BE063F_556133486;
        // ---------- Original Method ----------
        //return input;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.630 -0400", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "093345389C47211FE48F6789C7D56C90")
    @Override
    public String getMessage() {
        String reason = super.getMessage();
    if(index != -1)        
        {
String varCF3DA0332ACECBC787059A397C73A1B9_929388963 =             reason + " at index " + index + ": " + input;
            varCF3DA0332ACECBC787059A397C73A1B9_929388963.addTaint(taint);
            return varCF3DA0332ACECBC787059A397C73A1B9_929388963;
        } //End block
String var08522B3B8EA22B8AC87557C32650139A_1764533901 =         reason + ": " + input;
        var08522B3B8EA22B8AC87557C32650139A_1764533901.addTaint(taint);
        return var08522B3B8EA22B8AC87557C32650139A_1764533901;
        // ---------- Original Method ----------
        //String reason = super.getMessage();
        //if (index != -1) {
            //return reason + " at index " + index + ": " + input;
        //}
        //return reason + ": " + input;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:50.631 -0400", hash_original_field = "6BAAC3C8A6CE54C09263198F1E53CEA3", hash_generated_field = "CB65BAFBA372A5B522C6FE0957B2DAA9")

    private static final long serialVersionUID = 2137979680897488891L;
}

