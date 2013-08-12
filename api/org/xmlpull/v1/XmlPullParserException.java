package org.xmlpull.v1;

// Droidsafe Imports
import droidsafe.annotations.*;





public class XmlPullParserException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.534 -0400", hash_original_field = "951DA6B7179A4F697CC89D36ACF74E52", hash_generated_field = "EDAD1988191BC8FE2A32ADF91A96320C")

    protected Throwable detail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.535 -0400", hash_original_field = "22776FFD2C63CB4C7CEDBC66AF6F6A56", hash_generated_field = "156AAEA15ABF3CBA31DAC677D9612539")

    protected int row = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.535 -0400", hash_original_field = "B3A19A47A90FB8C09BFA54CBD0EAC83C", hash_generated_field = "A5B3244522132AF33705DB6C2189351A")

    protected int column = -1;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.535 -0400", hash_original_method = "81C346207A813FD28C849879E7041B6E", hash_generated_method = "B09839E492214B3948379BFD0CEB6868")
    public  XmlPullParserException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.536 -0400", hash_original_method = "28FAE29CB2E621B52838DE3161E10D49", hash_generated_method = "52B35FFCBC0C7A8BB727CD4869DB3B0F")
    public  XmlPullParserException(String msg, XmlPullParser parser, Throwable chain) {
        super ((msg == null ? "" : msg+" ")
               + (parser == null ? "" : "(position:"+parser.getPositionDescription()+") ")
               + (chain == null ? "" : "caused by: "+chain));
        addTaint(msg.getTaint());
        if(parser != null)        
        {
            this.row = parser.getLineNumber();
            this.column = parser.getColumnNumber();
        } //End block
        this.detail = chain;
        // ---------- Original Method ----------
        //if (parser != null) {
            //this.row = parser.getLineNumber();
            //this.column = parser.getColumnNumber();
        //}
        //this.detail = chain;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.536 -0400", hash_original_method = "94BA5080D380911C58CAC3733D4C69AF", hash_generated_method = "3665B395F702A49896CCCF9C990D8296")
    public Throwable getDetail() {
Throwable var7D32F5AE0FDCBBF6DD3F34C021592055_1842659053 =         detail;
        var7D32F5AE0FDCBBF6DD3F34C021592055_1842659053.addTaint(taint);
        return var7D32F5AE0FDCBBF6DD3F34C021592055_1842659053;
        // ---------- Original Method ----------
        //return detail;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.536 -0400", hash_original_method = "0760FB4E162E5971E2E765B2D1FE0093", hash_generated_method = "9A58DFA8C78D0687506ED4D1DD5BF147")
    public int getLineNumber() {
        int varF1965A857BC285D26FE22023AA5AB50D_1201842244 = (row);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563687259 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_563687259;
        // ---------- Original Method ----------
        //return row;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.537 -0400", hash_original_method = "52272B3AE5723072E22E93854866B927", hash_generated_method = "037AD8D8A7849CCEC04CDCE078C6C353")
    public int getColumnNumber() {
        int var1AFD32818D1C9525F82AFF4C09EFD254_1936789867 = (column);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230792397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_230792397;
        // ---------- Original Method ----------
        //return column;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:44.537 -0400", hash_original_method = "5154476310B69FA819C717F88BC0BDF0", hash_generated_method = "36A73D63E2EC7B0A992B319411FE8940")
    public void printStackTrace() {
        if(detail == null)        
        {
            super.printStackTrace();
        } //End block
        else
        {
            synchronized
(System.err)            {
                System.err.println(super.getMessage() + "; nested exception is:");
                detail.printStackTrace();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (detail == null) {
            //super.printStackTrace();
        //} else {
            //synchronized(System.err) {
                //System.err.println(super.getMessage() + "; nested exception is:");
                //detail.printStackTrace();
            //}
        //}
    }

    
}

