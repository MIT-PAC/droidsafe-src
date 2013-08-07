package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.address.GenericURI;

import java.text.ParseException;






public final class CallInfo extends ParametersHeader implements javax.sip.header.CallInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.137 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFBF7E2410210225F23571A6DEE68EDE")

    protected GenericURI info;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.138 -0400", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "37A5CF038F326ECEA85878995B55B295")
    public  CallInfo() {
        super(CALL_INFO);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.138 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "9CC11A338D7277C5D909129D2A106233")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1148163205 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1148163205.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1148163205;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.139 -0400", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "A2745F303A19716ECA7D9A0EE73F5A56")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        buffer.append(LESS_THAN);
        info.encode(buffer);
        buffer.append(GREATER_THAN);
        if(parameters != null && !parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_513123817 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_513123817.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_513123817;
        // ---------- Original Method ----------
        //buffer.append(LESS_THAN);
        //info.encode(buffer);
        //buffer.append(GREATER_THAN);
        //if (parameters != null && !parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.140 -0400", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "B22A1F3810BDE372597A956835AFA639")
    public String getPurpose() {
String var3F988F8FBD14A53C10BD182A8966AA04_1954230540 =         this.getParameter("purpose");
        var3F988F8FBD14A53C10BD182A8966AA04_1954230540.addTaint(taint);
        return var3F988F8FBD14A53C10BD182A8966AA04_1954230540;
        // ---------- Original Method ----------
        //return this.getParameter("purpose");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.140 -0400", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "F1644944AFB908CFDB36F87B3461E693")
    public javax.sip.address.URI getInfo() {
javax.sip.address.URI var43CF3338FDBA93597A9562D3166E9DC4_1085079743 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_1085079743.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_1085079743;
        // ---------- Original Method ----------
        //return info;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.141 -0400", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "E6A59A4EB7A49448D7AE1D2B0186D97E")
    public void setPurpose(String purpose) {
        addTaint(purpose.getTaint());
        if(purpose == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_563716051 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_563716051.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_563716051;
        }
        try 
        {
            this.setParameter("purpose", purpose);
        } //End block
        catch (ParseException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //if (purpose == null)
            //throw new NullPointerException("null arg");
        //try {
            //this.setParameter("purpose", purpose);
        //} catch (ParseException ex) {
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.141 -0400", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "529B104F54989C0661DF25CACCDA676F")
    public void setInfo(javax.sip.address.URI info) {
        this.info = (GenericURI) info;
        // ---------- Original Method ----------
        //this.info = (GenericURI) info;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.142 -0400", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "272A4FF00BDD534D0E82DDF0CAA08F7E")
    public Object clone() {
        CallInfo retval = (CallInfo) super.clone();
        if(this.info != null)        
        retval.info = (GenericURI) this.info.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_733990510 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_733990510.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_733990510;
        // ---------- Original Method ----------
        //CallInfo retval = (CallInfo) super.clone();
        //if (this.info != null)
            //retval.info = (GenericURI) this.info.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.142 -0400", hash_original_field = "4494FB805A36EA869D54FB33F6FB1EA4", hash_generated_field = "2D62DF7E0A2A79C01356DE01B010437F")

    private static final long serialVersionUID = -8179246487696752928L;
}

