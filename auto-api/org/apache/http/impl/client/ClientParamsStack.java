package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.params.HttpParams;
import org.apache.http.params.AbstractHttpParams;

public class ClientParamsStack extends AbstractHttpParams {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.031 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.031 -0400", hash_original_field = "B53EE9455AAD23E9E0EA1ED07FD13055", hash_generated_field = "32F39C15B73E9C028569FCAD17E48131")

    protected HttpParams applicationParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.031 -0400", hash_original_field = "56DB28FA3D8177D1E4C4B572AA551E0D", hash_generated_field = "B6902EA3DF78F5E3948D83F83F61C305")

    protected HttpParams clientParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.031 -0400", hash_original_field = "28169C02AAF610040FC1D9A704AD1C86", hash_generated_field = "D0B3BB526219F8C4CF831BDBA8B2E8F9")

    protected HttpParams requestParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.032 -0400", hash_original_field = "3870BE4BDB286515FD1211A71C20B84F", hash_generated_field = "0F3FDC4D6C99FE0F422F50FAC4EC37BE")

    protected HttpParams overrideParams;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.032 -0400", hash_original_method = "C6D32BE942F9C5459143EF4AC85BAF30", hash_generated_method = "C6E9AF9E1126F00797FE6895060FD1ED")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.032 -0400", hash_original_method = "7E64926BBCDB13033B63B7A286DDA4C5", hash_generated_method = "72B738219595F59BF455D7CE5AF10F63")
    public  ClientParamsStack(ClientParamsStack stack) {
        this(stack.getApplicationParams(),
             stack.getClientParams(),
             stack.getRequestParams(),
             stack.getOverrideParams());
        addTaint(stack.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.032 -0400", hash_original_method = "C87A48D0B50CCC317A58E3CCEC0DEAA5", hash_generated_method = "0455FA3A62AD64B5C37D27F42BE65E3C")
    public  ClientParamsStack(ClientParamsStack stack,
                             HttpParams aparams, HttpParams cparams,
                             HttpParams rparams, HttpParams oparams) {
        this((aparams != null) ? aparams : stack.getApplicationParams(),
             (cparams != null) ? cparams : stack.getClientParams(),
             (rparams != null) ? rparams : stack.getRequestParams(),
             (oparams != null) ? oparams : stack.getOverrideParams());
        addTaint(stack.getTaint());
        addTaint(aparams.getTaint());
        addTaint(cparams.getTaint());
        addTaint(rparams.getTaint());
        addTaint(oparams.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.033 -0400", hash_original_method = "411C2E82696B2A098C8F744317385115", hash_generated_method = "4DFFAF24CD7D97A20B6937A21BB7C099")
    public final HttpParams getApplicationParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_2146907592 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2146907592 = applicationParams;
        varB4EAC82CA7396A68D541C85D26508E83_2146907592.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2146907592;
        // ---------- Original Method ----------
        //return applicationParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.033 -0400", hash_original_method = "15DA57CD4E641FF95D2F8640F98E0183", hash_generated_method = "01FD7F1B100BDE19D243C4F7BB92C732")
    public final HttpParams getClientParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1710732949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1710732949 = clientParams;
        varB4EAC82CA7396A68D541C85D26508E83_1710732949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1710732949;
        // ---------- Original Method ----------
        //return clientParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.033 -0400", hash_original_method = "93598125634F09E7FC66E3A21BBB5179", hash_generated_method = "B3398AAF20B96B4C4F72CB23DA9B3316")
    public final HttpParams getRequestParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1221981184 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1221981184 = requestParams;
        varB4EAC82CA7396A68D541C85D26508E83_1221981184.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1221981184;
        // ---------- Original Method ----------
        //return requestParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.034 -0400", hash_original_method = "571781B35D1F87CE8D980CD8A67BB691", hash_generated_method = "AC9F44884C41E93F13991624C023CF83")
    public final HttpParams getOverrideParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_336034342 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_336034342 = overrideParams;
        varB4EAC82CA7396A68D541C85D26508E83_336034342.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_336034342;
        // ---------- Original Method ----------
        //return overrideParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.034 -0400", hash_original_method = "4085DCEEB969FCACB974F3F758D65674", hash_generated_method = "F227095B716793AA153482EA2EBAB870")
    public Object getParameter(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1851315912 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Parameter name must not be null.");
        } //End block
        Object result = null;
        {
            result = overrideParams.getParameter(name);
        } //End block
        {
            result = requestParams.getParameter(name);
        } //End block
        {
            result = clientParams.getParameter(name);
        } //End block
        {
            result = applicationParams.getParameter(name);
        } //End block
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_853337774 = (this.log.isDebugEnabled());
            {
                this.log.debug("'" + name + "': " + result);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1851315912 = result;
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1851315912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1851315912;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.035 -0400", hash_original_method = "2A511DFE1F081488F4D79D3E78FD00A2", hash_generated_method = "865784DEEEDA2A7E59E8F48C7351A9CE")
    public HttpParams setParameter(String name, Object value) throws UnsupportedOperationException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
            ("Setting parameters in a stack is not supported.");
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
            //("Setting parameters in a stack is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.035 -0400", hash_original_method = "91EEF8AA1623C8BE2C536A6D8B3A0F15", hash_generated_method = "890ED8CF612F0634A1C9996E2F80B67F")
    public boolean removeParameter(String name) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
        ("Removing parameters in a stack is not supported.");
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377571084 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377571084;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
        //("Removing parameters in a stack is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.036 -0400", hash_original_method = "EA9D71906AA8F5EAFC46BDFADD14632A", hash_generated_method = "DA21EE9AF7DAA0E3E67A32941F8E2BE7")
    public HttpParams copy() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_978475016 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_978475016 = this;
        varB4EAC82CA7396A68D541C85D26508E83_978475016.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_978475016;
        // ---------- Original Method ----------
        //return this;
    }

    
}

