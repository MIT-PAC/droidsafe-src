package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public final class DefaultedHttpContext implements HttpContext {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.287 -0400", hash_original_field = "F5DDAF0CA7929578B408C909429F68F2", hash_generated_field = "E015EF617CD4ED004D5007AC30C609BC")

    private HttpContext local;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.287 -0400", hash_original_field = "A4A918A45181164207929D52AEC36AEC", hash_generated_field = "7ADABA5216B59FD658450669A2A3CCAA")

    private HttpContext defaults;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.288 -0400", hash_original_method = "A0575674BF73385D2F6A60AE80137BEF", hash_generated_method = "D565DB98F36958C516D0B8D790264749")
    public  DefaultedHttpContext(final HttpContext local, final HttpContext defaults) {
        super();
        if(local == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1754169037 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1754169037.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1754169037;
        } //End block
        this.local = local;
        this.defaults = defaults;
        // ---------- Original Method ----------
        //if (local == null) {
            //throw new IllegalArgumentException("HTTP context may not be null");
        //}
        //this.local = local;
        //this.defaults = defaults;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.288 -0400", hash_original_method = "E6F5162D8C28E0713279EA6EC6682784", hash_generated_method = "7FFE9201D75112B80592310207DFC96B")
    public Object getAttribute(final String id) {
        addTaint(id.getTaint());
        Object obj = this.local.getAttribute(id);
        if(obj == null)        
        {
Object varC79252184F2496367A47AE09C4AA2D30_494977809 =             this.defaults.getAttribute(id);
            varC79252184F2496367A47AE09C4AA2D30_494977809.addTaint(taint);
            return varC79252184F2496367A47AE09C4AA2D30_494977809;
        } //End block
        else
        {
Object var2FDE1120F80AA4E8798ECDBDB1C0E85C_1937522277 =             obj;
            var2FDE1120F80AA4E8798ECDBDB1C0E85C_1937522277.addTaint(taint);
            return var2FDE1120F80AA4E8798ECDBDB1C0E85C_1937522277;
        } //End block
        // ---------- Original Method ----------
        //Object obj = this.local.getAttribute(id);
        //if (obj == null) {
            //return this.defaults.getAttribute(id);
        //} else {
            //return obj;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.288 -0400", hash_original_method = "0AEE49A004EDC83FD5C79915CB13681F", hash_generated_method = "6B49A51354E9C8ACDCCD6CC822D06965")
    public Object removeAttribute(final String id) {
        addTaint(id.getTaint());
Object var74888A1C7728062EE6A275D5DB131063_859187654 =         this.local.removeAttribute(id);
        var74888A1C7728062EE6A275D5DB131063_859187654.addTaint(taint);
        return var74888A1C7728062EE6A275D5DB131063_859187654;
        // ---------- Original Method ----------
        //return this.local.removeAttribute(id);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.289 -0400", hash_original_method = "EE2D3704A963700B0310D3F12DCBDD4D", hash_generated_method = "3C5F2E0AF008CA77F93E9CF2D58E9412")
    public void setAttribute(final String id, final Object obj) {
        addTaint(obj.getTaint());
        addTaint(id.getTaint());
        this.local.setAttribute(id, obj);
        // ---------- Original Method ----------
        //this.local.setAttribute(id, obj);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.289 -0400", hash_original_method = "FA59965C12DF7B81C110308001A0693E", hash_generated_method = "906D37EFA7D5E5511A63E8246786E2FE")
    public HttpContext getDefaults() {
HttpContext var83675A281C45A942828F3DC842CC251B_1533726597 =         this.defaults;
        var83675A281C45A942828F3DC842CC251B_1533726597.addTaint(taint);
        return var83675A281C45A942828F3DC842CC251B_1533726597;
        // ---------- Original Method ----------
        //return this.defaults;
    }

    
}

