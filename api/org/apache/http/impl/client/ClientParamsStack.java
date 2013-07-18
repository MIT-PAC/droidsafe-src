package org.apache.http.impl.client;

// Droidsafe Imports
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ClientParamsStack extends AbstractHttpParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_field = "B53EE9455AAD23E9E0EA1ED07FD13055", hash_generated_field = "32F39C15B73E9C028569FCAD17E48131")

    protected HttpParams applicationParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_field = "56DB28FA3D8177D1E4C4B572AA551E0D", hash_generated_field = "B6902EA3DF78F5E3948D83F83F61C305")

    protected HttpParams clientParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_field = "28169C02AAF610040FC1D9A704AD1C86", hash_generated_field = "D0B3BB526219F8C4CF831BDBA8B2E8F9")

    protected HttpParams requestParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_field = "3870BE4BDB286515FD1211A71C20B84F", hash_generated_field = "0F3FDC4D6C99FE0F422F50FAC4EC37BE")

    protected HttpParams overrideParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_method = "C6D32BE942F9C5459143EF4AC85BAF30", hash_generated_method = "C6E9AF9E1126F00797FE6895060FD1ED")
    public  ClientParamsStack(HttpParams aparams, HttpParams cparams,
                             HttpParams rparams, HttpParams oparams) {
        applicationParams = aparams;
        clientParams      = cparams;
        requestParams     = rparams;
        overrideParams    = oparams;
        // ---------- Original Method ----------
        //applicationParams = aparams;
        //clientParams      = cparams;
        //requestParams     = rparams;
        //overrideParams    = oparams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.660 -0400", hash_original_method = "7E64926BBCDB13033B63B7A286DDA4C5", hash_generated_method = "72B738219595F59BF455D7CE5AF10F63")
    public  ClientParamsStack(ClientParamsStack stack) {
        this(stack.getApplicationParams(),
             stack.getClientParams(),
             stack.getRequestParams(),
             stack.getOverrideParams());
        addTaint(stack.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "C87A48D0B50CCC317A58E3CCEC0DEAA5", hash_generated_method = "D691C9357E0E22689975809DB6A25598")
    public  ClientParamsStack(ClientParamsStack stack,
                             HttpParams aparams, HttpParams cparams,
                             HttpParams rparams, HttpParams oparams) {
        this((aparams != null) ? aparams : stack.getApplicationParams(),
             (cparams != null) ? cparams : stack.getClientParams(),
             (rparams != null) ? rparams : stack.getRequestParams(),
             (oparams != null) ? oparams : stack.getOverrideParams());
        addTaint(oparams.getTaint());
        addTaint(rparams.getTaint());
        addTaint(cparams.getTaint());
        addTaint(aparams.getTaint());
        addTaint(stack.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "411C2E82696B2A098C8F744317385115", hash_generated_method = "816A4B5D49BAFF786C2FA06083213C20")
    public final HttpParams getApplicationParams() {
HttpParams var7945C5CD29912AE84B51B5555B2E3FD1_929271068 =         applicationParams;
        var7945C5CD29912AE84B51B5555B2E3FD1_929271068.addTaint(taint);
        return var7945C5CD29912AE84B51B5555B2E3FD1_929271068;
        // ---------- Original Method ----------
        //return applicationParams;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "15DA57CD4E641FF95D2F8640F98E0183", hash_generated_method = "BCF880CEF7155110EAC5385E733B4BEC")
    public final HttpParams getClientParams() {
HttpParams var4ED3C0E8A5C13064D8D55F030D61EBE8_346035161 =         clientParams;
        var4ED3C0E8A5C13064D8D55F030D61EBE8_346035161.addTaint(taint);
        return var4ED3C0E8A5C13064D8D55F030D61EBE8_346035161;
        // ---------- Original Method ----------
        //return clientParams;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "93598125634F09E7FC66E3A21BBB5179", hash_generated_method = "820AB5273EDAC78B66D6EE2CA5C03135")
    public final HttpParams getRequestParams() {
HttpParams var62C79F52706619CE99D0ED6A53571A56_1101306739 =         requestParams;
        var62C79F52706619CE99D0ED6A53571A56_1101306739.addTaint(taint);
        return var62C79F52706619CE99D0ED6A53571A56_1101306739;
        // ---------- Original Method ----------
        //return requestParams;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "571781B35D1F87CE8D980CD8A67BB691", hash_generated_method = "56887F93667430EB745EDCEECF333FD5")
    public final HttpParams getOverrideParams() {
HttpParams var882137B6A0312415D38CC638EFA3E6F8_940761160 =         overrideParams;
        var882137B6A0312415D38CC638EFA3E6F8_940761160.addTaint(taint);
        return var882137B6A0312415D38CC638EFA3E6F8_940761160;
        // ---------- Original Method ----------
        //return overrideParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "4085DCEEB969FCACB974F3F758D65674", hash_generated_method = "55F10327350B82D258FA32517421DD6F")
    public Object getParameter(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var3FC67FE07BF58C90BEBF6F753BF67E4C_1238533821 = new IllegalArgumentException
                ("Parameter name must not be null.");
            var3FC67FE07BF58C90BEBF6F753BF67E4C_1238533821.addTaint(taint);
            throw var3FC67FE07BF58C90BEBF6F753BF67E4C_1238533821;
        } //End block
        Object result = null;
        if(overrideParams != null)        
        {
            result = overrideParams.getParameter(name);
        } //End block
        if((result == null) && (requestParams != null))        
        {
            result = requestParams.getParameter(name);
        } //End block
        if((result == null) && (clientParams != null))        
        {
            result = clientParams.getParameter(name);
        } //End block
        if((result == null) && (applicationParams != null))        
        {
            result = applicationParams.getParameter(name);
        } //End block
        if(this.log.isDebugEnabled())        
        {
            this.log.debug("'" + name + "': " + result);
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_1139863586 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1139863586.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1139863586;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException
                //("Parameter name must not be null.");
        //}
        //Object result = null;
        //if (overrideParams != null) {
            //result = overrideParams.getParameter(name);
        //}
        //if ((result == null) && (requestParams != null)) {
            //result = requestParams.getParameter(name);
        //}
        //if ((result == null) && (clientParams != null)) {
            //result = clientParams.getParameter(name);
        //}
        //if ((result == null) && (applicationParams != null)) {
            //result = applicationParams.getParameter(name);
        //}
        //if (this.log.isDebugEnabled()) {
            //this.log.debug("'" + name + "': " + result);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "2A511DFE1F081488F4D79D3E78FD00A2", hash_generated_method = "259EBF2AF4F46AC51A3AA4D995D39E5C")
    public HttpParams setParameter(String name, Object value) throws UnsupportedOperationException {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        UnsupportedOperationException var557F47975E6EEF696214487688534EB1_826838041 = new UnsupportedOperationException
            ("Setting parameters in a stack is not supported.");
        var557F47975E6EEF696214487688534EB1_826838041.addTaint(taint);
        throw var557F47975E6EEF696214487688534EB1_826838041;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
            //("Setting parameters in a stack is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "91EEF8AA1623C8BE2C536A6D8B3A0F15", hash_generated_method = "215EE401F742DCFDB8878699705345FF")
    public boolean removeParameter(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var5A55E1140B542B4286586C76AEBC5187_304022020 = new UnsupportedOperationException
        ("Removing parameters in a stack is not supported.");
        var5A55E1140B542B4286586C76AEBC5187_304022020.addTaint(taint);
        throw var5A55E1140B542B4286586C76AEBC5187_304022020;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
        //("Removing parameters in a stack is not supported.");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.661 -0400", hash_original_method = "EA9D71906AA8F5EAFC46BDFADD14632A", hash_generated_method = "60F5F8C29F281AB583CEDBDEB8B5190E")
    public HttpParams copy() {
HttpParams var72A74007B2BE62B849F475C7BDA4658B_1271248732 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1271248732.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1271248732;
        // ---------- Original Method ----------
        //return this;
    }

    
}

