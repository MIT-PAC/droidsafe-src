package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;
import org.apache.http.params.BasicHttpParams;

public abstract class AbstractHttpMessage implements HttpMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.867 -0400", hash_original_field = "F5C7F01E4A3E94206E282D02BF390DB2", hash_generated_field = "34FF19CD0855E5D63A04F524D7452FF4")

    protected HeaderGroup headergroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.867 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.872 -0400", hash_original_method = "926C531625268700794509BCC2F5F77F", hash_generated_method = "F64E6306B6CC36DC6AE4D39268C8D717")
    protected  AbstractHttpMessage(final HttpParams params) {
        super();
        this.headergroup = new HeaderGroup();
        this.params = params;
        // ---------- Original Method ----------
        //this.headergroup = new HeaderGroup();
        //this.params = params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.874 -0400", hash_original_method = "2222B1AD198C1052436204E49A67A13C", hash_generated_method = "20CE23CB860DE8F239A1882E6A61E5B3")
    protected  AbstractHttpMessage() {
        this(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.885 -0400", hash_original_method = "9EF327933AC8CF093A78CA62674DD20F", hash_generated_method = "12803CABA230CD6BE186FF60E22597B7")
    public boolean containsHeader(String name) {
        boolean var6CFDAFB175557FEDC806A3C6134097EB_878211848 = (this.headergroup.containsHeader(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_675764974 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_675764974;
        // ---------- Original Method ----------
        //return this.headergroup.containsHeader(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.885 -0400", hash_original_method = "FE431DBB9584369B7EDB43E7189B0AE3", hash_generated_method = "8692951FAB04680102B9D127A0278A66")
    public Header[] getHeaders(final String name) {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_276728620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_276728620 = this.headergroup.getHeaders(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_276728620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_276728620;
        // ---------- Original Method ----------
        //return this.headergroup.getHeaders(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.885 -0400", hash_original_method = "4F426424B706B56A99E07E40B5C52BFA", hash_generated_method = "DDBCCD437E0ED20968E2DF01ED7C9C9C")
    public Header getFirstHeader(final String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_139772387 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_139772387 = this.headergroup.getFirstHeader(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_139772387.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_139772387;
        // ---------- Original Method ----------
        //return this.headergroup.getFirstHeader(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.886 -0400", hash_original_method = "2D4239F1E5F9F68D789A00645007924A", hash_generated_method = "2E70CE52E9EAB7E288E7A0D761FC404E")
    public Header getLastHeader(final String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_1461175585 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1461175585 = this.headergroup.getLastHeader(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1461175585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461175585;
        // ---------- Original Method ----------
        //return this.headergroup.getLastHeader(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.886 -0400", hash_original_method = "89AD2C028927AB3E8715A79204D69C99", hash_generated_method = "997F2F535947C5C2F5766DE97E6F7FA1")
    public Header[] getAllHeaders() {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_1006772287 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1006772287 = this.headergroup.getAllHeaders();
        varB4EAC82CA7396A68D541C85D26508E83_1006772287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1006772287;
        // ---------- Original Method ----------
        //return this.headergroup.getAllHeaders();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.886 -0400", hash_original_method = "1DE731CFF4ECF4DBA0EF3FE32BB726E4", hash_generated_method = "D10AB333B35B0881F9DFD4553CCE8AA5")
    public void addHeader(final Header header) {
        this.headergroup.addHeader(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //this.headergroup.addHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.887 -0400", hash_original_method = "4C12242853C02960B9FD442E279D83C0", hash_generated_method = "38A8DCC2D622B7B43F75D4AF99F331E1")
    public void addHeader(final String name, final String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header name may not be null");
        } //End block
        this.headergroup.addHeader(new BasicHeader(name, value));
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Header name may not be null");
        //}
        //this.headergroup.addHeader(new BasicHeader(name, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.895 -0400", hash_original_method = "65F67011ED88E162C7A3317CC96C8B85", hash_generated_method = "4BE07F750BB8F66382D08AE9729E52F9")
    public void setHeader(final Header header) {
        this.headergroup.updateHeader(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //this.headergroup.updateHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.896 -0400", hash_original_method = "59EEDD7DD894E22B8BE3BEB8962485C4", hash_generated_method = "141726AAF7AFE238C798FCF473AEFC2D")
    public void setHeader(final String name, final String value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Header name may not be null");
        } //End block
        this.headergroup.updateHeader(new BasicHeader(name, value));
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Header name may not be null");
        //}
        //this.headergroup.updateHeader(new BasicHeader(name, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.896 -0400", hash_original_method = "F77171669C40FC4A8C250022B7C99495", hash_generated_method = "A5395A9559E6830DA423FA04CA045ECA")
    public void setHeaders(final Header[] headers) {
        this.headergroup.setHeaders(headers);
        addTaint(headers[0].getTaint());
        // ---------- Original Method ----------
        //this.headergroup.setHeaders(headers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.897 -0400", hash_original_method = "167D8764CCE16F3185A846BF9C0F5516", hash_generated_method = "AD3A21AA5BA1E2771E80D3AC1D208B1A")
    public void removeHeader(final Header header) {
        this.headergroup.removeHeader(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //this.headergroup.removeHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.897 -0400", hash_original_method = "D7D4084B603700D250D598944C009D40", hash_generated_method = "E5F61EE3A55629B7C670A3E0FFD2CE11")
    public void removeHeaders(final String name) {
        {
            Iterator i;
            i = this.headergroup.iterator();
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1870000090 = (i.hasNext());
            {
                Header header;
                header = (Header) i.next();
                {
                    boolean var3104EEF4216C20140CD69A5852A34995_847436969 = (name.equalsIgnoreCase(header.getName()));
                    {
                        i.remove();
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
            //return;
        //}
        //for (Iterator i = this.headergroup.iterator(); i.hasNext(); ) {
            //Header header = (Header) i.next();
            //if (name.equalsIgnoreCase(header.getName())) {
                //i.remove();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.898 -0400", hash_original_method = "7F921B9752F1205280862FD328D06FCE", hash_generated_method = "ADD6B5846332EEEC0575842EE83E4757")
    public HeaderIterator headerIterator() {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_641644828 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_641644828 = this.headergroup.iterator();
        varB4EAC82CA7396A68D541C85D26508E83_641644828.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_641644828;
        // ---------- Original Method ----------
        //return this.headergroup.iterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.898 -0400", hash_original_method = "68644A261C0F1E0602A67E0AF6E4CB07", hash_generated_method = "8E38046D80E362ACF0CF8277AD5AEA65")
    public HeaderIterator headerIterator(String name) {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_75901829 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_75901829 = this.headergroup.iterator(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_75901829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75901829;
        // ---------- Original Method ----------
        //return this.headergroup.iterator(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.914 -0400", hash_original_method = "D8EA4E4823DF4752A606F523C6CA7ECB", hash_generated_method = "E7BA687C85EF7C43F11AD5B2477CF96C")
    public HttpParams getParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_113753769 = null; //Variable for return #1
        {
            this.params = new BasicHttpParams();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_113753769 = this.params;
        varB4EAC82CA7396A68D541C85D26508E83_113753769.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_113753769;
        // ---------- Original Method ----------
        //if (this.params == null) {
            //this.params = new BasicHttpParams();
        //}
        //return this.params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.914 -0400", hash_original_method = "1CAC19773CE7693AFF1DBB697E1BBCDE", hash_generated_method = "B9D66AFB7397FB748A83C13BBC948292")
    public void setParams(final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
        } //End block
        this.params = params;
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new IllegalArgumentException("HTTP parameters may not be null");
        //}
        //this.params = params;
    }

    
}

