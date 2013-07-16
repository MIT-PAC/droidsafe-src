package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.address.*;
import java.text.ParseException;

public final class CallInfo extends ParametersHeader implements javax.sip.header.CallInfoHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.134 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFBF7E2410210225F23571A6DEE68EDE")

    protected GenericURI info;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.135 -0400", hash_original_method = "E32B7E5F9D4A1980425339805E4FFC9A", hash_generated_method = "37A5CF038F326ECEA85878995B55B295")
    public  CallInfo() {
        super(CALL_INFO);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.136 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "457BBFAB4224A90B4BAF9088F0C10002")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1277583923 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1277583923.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1277583923;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.136 -0400", hash_original_method = "A4CCBF948684EE8C510DCE8D73383A9B", hash_generated_method = "BBD2408BDE846F69288933F8A70CD74A")
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
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_536616393 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_536616393.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_536616393;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.137 -0400", hash_original_method = "5AE253F427E5A28ACB58F8121152C53D", hash_generated_method = "3D619FCC019912B6869E7117858ECE36")
    public String getPurpose() {
String var3F988F8FBD14A53C10BD182A8966AA04_37923370 =         this.getParameter("purpose");
        var3F988F8FBD14A53C10BD182A8966AA04_37923370.addTaint(taint);
        return var3F988F8FBD14A53C10BD182A8966AA04_37923370;
        // ---------- Original Method ----------
        //return this.getParameter("purpose");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.137 -0400", hash_original_method = "EF1B9495763809E09B57BAE8A2B95EE3", hash_generated_method = "69FC716E2FC47EF98A8FD4D09822255E")
    public javax.sip.address.URI getInfo() {
javax.sip.address.URI var43CF3338FDBA93597A9562D3166E9DC4_651947945 =         info;
        var43CF3338FDBA93597A9562D3166E9DC4_651947945.addTaint(taint);
        return var43CF3338FDBA93597A9562D3166E9DC4_651947945;
        // ---------- Original Method ----------
        //return info;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.137 -0400", hash_original_method = "02434F47BE675094B3D64F5516EB6DB6", hash_generated_method = "F77AEC79E49F644F17990A6D33E3F41B")
    public void setPurpose(String purpose) {
        addTaint(purpose.getTaint());
    if(purpose == null)        
        {
        NullPointerException varCF8D07C80828DCBD1FC1EB16BCF7D0F2_972973645 = new NullPointerException("null arg");
        varCF8D07C80828DCBD1FC1EB16BCF7D0F2_972973645.addTaint(taint);
        throw varCF8D07C80828DCBD1FC1EB16BCF7D0F2_972973645;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.138 -0400", hash_original_method = "5AA5786EA20C5BC42796F42D6FB1BBD6", hash_generated_method = "529B104F54989C0661DF25CACCDA676F")
    public void setInfo(javax.sip.address.URI info) {
        this.info = (GenericURI) info;
        // ---------- Original Method ----------
        //this.info = (GenericURI) info;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.138 -0400", hash_original_method = "13BFA074DC19025B66849B6C15AC7B30", hash_generated_method = "AA6C0F593881D8E803EC52CC85F9C0A3")
    public Object clone() {
        CallInfo retval = (CallInfo) super.clone();
    if(this.info != null)        
        retval.info = (GenericURI) this.info.clone();
Object varF9E19AD6135C970F387F77C6F3DE4477_467236559 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_467236559.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_467236559;
        // ---------- Original Method ----------
        //CallInfo retval = (CallInfo) super.clone();
        //if (this.info != null)
            //retval.info = (GenericURI) this.info.clone();
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.138 -0400", hash_original_field = "4494FB805A36EA869D54FB33F6FB1EA4", hash_generated_field = "2D62DF7E0A2A79C01356DE01B010437F")

    private static final long serialVersionUID = -8179246487696752928L;
}

