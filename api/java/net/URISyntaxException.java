package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;





public class URISyntaxException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")

    private String input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "6AA90214C9929DF4BA504F63570DAC48")
    public  URISyntaxException(String input, String reason, int index) {
        super(reason);
        addTaint(reason.getTaint());
        if(input == null || reason == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_1679238968 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_1679238968.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_1679238968;
        } //End block
        if(index < -1)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_13891424 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_13891424.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_13891424;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "85D864DCE56CA49E85233E322331C2E7")
    public  URISyntaxException(String input, String reason) {
        super(reason);
        addTaint(reason.getTaint());
        if(input == null || reason == null)        
        {
            NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_715320180 = new NullPointerException();
            var7338BC9F48D81FE0BBD6183F4014DCC4_715320180.addTaint(taint);
            throw var7338BC9F48D81FE0BBD6183F4014DCC4_715320180;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "9E1C4DB2CFE0B63B0CA65E85C8AFA556")
    public int getIndex() {
        int var6A992D5529F459A44FEE58C733255E86_1800364990 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138353066 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1138353066;
        // ---------- Original Method ----------
        //return index;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "5C095698B62A3383AF70BB8E8026C519")
    public String getReason() {
String var1F56B99E8E42A81BCA45826E1719D3B0_1797760676 =         super.getMessage();
        var1F56B99E8E42A81BCA45826E1719D3B0_1797760676.addTaint(taint);
        return var1F56B99E8E42A81BCA45826E1719D3B0_1797760676;
        // ---------- Original Method ----------
        //return super.getMessage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.869 -0400", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "DEC3C7F4788E6975F67E72CF28E34CFA")
    public String getInput() {
String var5B0B1B23FE12EB4FF686B5A845BE063F_1442527160 =         input;
        var5B0B1B23FE12EB4FF686B5A845BE063F_1442527160.addTaint(taint);
        return var5B0B1B23FE12EB4FF686B5A845BE063F_1442527160;
        // ---------- Original Method ----------
        //return input;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.870 -0400", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "9D14FA1997AF18AEC153A037BEC9BC4E")
    @Override
    public String getMessage() {
        String reason = super.getMessage();
        if(index != -1)        
        {
String varCF3DA0332ACECBC787059A397C73A1B9_255113724 =             reason + " at index " + index + ": " + input;
            varCF3DA0332ACECBC787059A397C73A1B9_255113724.addTaint(taint);
            return varCF3DA0332ACECBC787059A397C73A1B9_255113724;
        } //End block
String var08522B3B8EA22B8AC87557C32650139A_1344942731 =         reason + ": " + input;
        var08522B3B8EA22B8AC87557C32650139A_1344942731.addTaint(taint);
        return var08522B3B8EA22B8AC87557C32650139A_1344942731;
        // ---------- Original Method ----------
        //String reason = super.getMessage();
        //if (index != -1) {
            //return reason + " at index " + index + ": " + input;
        //}
        //return reason + ": " + input;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.870 -0400", hash_original_field = "6BAAC3C8A6CE54C09263198F1E53CEA3", hash_generated_field = "CB65BAFBA372A5B522C6FE0957B2DAA9")

    private static final long serialVersionUID = 2137979680897488891L;
}

