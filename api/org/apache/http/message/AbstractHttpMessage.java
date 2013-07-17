package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;
import org.apache.http.params.BasicHttpParams;

public abstract class AbstractHttpMessage implements HttpMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.683 -0400", hash_original_field = "F5C7F01E4A3E94206E282D02BF390DB2", hash_generated_field = "34FF19CD0855E5D63A04F524D7452FF4")

    protected HeaderGroup headergroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.683 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.684 -0400", hash_original_method = "926C531625268700794509BCC2F5F77F", hash_generated_method = "F64E6306B6CC36DC6AE4D39268C8D717")
    protected  AbstractHttpMessage(final HttpParams params) {
        super();
        this.headergroup = new HeaderGroup();
        this.params = params;
        // ---------- Original Method ----------
        //this.headergroup = new HeaderGroup();
        //this.params = params;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.684 -0400", hash_original_method = "2222B1AD198C1052436204E49A67A13C", hash_generated_method = "20CE23CB860DE8F239A1882E6A61E5B3")
    protected  AbstractHttpMessage() {
        this(null);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.684 -0400", hash_original_method = "9EF327933AC8CF093A78CA62674DD20F", hash_generated_method = "97D1CCA527AF37690F29DE8E0BCCE24C")
    public boolean containsHeader(String name) {
        addTaint(name.getTaint());
        boolean varBAF0911C5B07CAA71AE5E495DF06E2EB_2145894270 = (this.headergroup.containsHeader(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461459578 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461459578;
        // ---------- Original Method ----------
        //return this.headergroup.containsHeader(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.685 -0400", hash_original_method = "FE431DBB9584369B7EDB43E7189B0AE3", hash_generated_method = "6337597CACA49126432352C4B2FE741D")
    public Header[] getHeaders(final String name) {
        addTaint(name.getTaint());
Header[] var4405D79A789F00918F592F035CB6C2D8_1670179873 =         this.headergroup.getHeaders(name);
        var4405D79A789F00918F592F035CB6C2D8_1670179873.addTaint(taint);
        return var4405D79A789F00918F592F035CB6C2D8_1670179873;
        // ---------- Original Method ----------
        //return this.headergroup.getHeaders(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.685 -0400", hash_original_method = "4F426424B706B56A99E07E40B5C52BFA", hash_generated_method = "4905E5B1CB92C2ECE09530334218E38D")
    public Header getFirstHeader(final String name) {
        addTaint(name.getTaint());
Header var76E8CB6F7B6FA9646332056848EE09DA_1599323020 =         this.headergroup.getFirstHeader(name);
        var76E8CB6F7B6FA9646332056848EE09DA_1599323020.addTaint(taint);
        return var76E8CB6F7B6FA9646332056848EE09DA_1599323020;
        // ---------- Original Method ----------
        //return this.headergroup.getFirstHeader(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.686 -0400", hash_original_method = "2D4239F1E5F9F68D789A00645007924A", hash_generated_method = "ED540D7ADD5CA89B60B8426BFE658696")
    public Header getLastHeader(final String name) {
        addTaint(name.getTaint());
Header varDCA51A694DA7D6393945A3D3B01EF2B5_1274028985 =         this.headergroup.getLastHeader(name);
        varDCA51A694DA7D6393945A3D3B01EF2B5_1274028985.addTaint(taint);
        return varDCA51A694DA7D6393945A3D3B01EF2B5_1274028985;
        // ---------- Original Method ----------
        //return this.headergroup.getLastHeader(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.686 -0400", hash_original_method = "89AD2C028927AB3E8715A79204D69C99", hash_generated_method = "FB781D83BA59E0C734F89E46CE10C4FC")
    public Header[] getAllHeaders() {
Header[] var99C90132A83F658FD46240FBE89AABEC_2062644187 =         this.headergroup.getAllHeaders();
        var99C90132A83F658FD46240FBE89AABEC_2062644187.addTaint(taint);
        return var99C90132A83F658FD46240FBE89AABEC_2062644187;
        // ---------- Original Method ----------
        //return this.headergroup.getAllHeaders();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.686 -0400", hash_original_method = "1DE731CFF4ECF4DBA0EF3FE32BB726E4", hash_generated_method = "751B734939824D5C25A49ACB3EDE30C5")
    public void addHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.addHeader(header);
        // ---------- Original Method ----------
        //this.headergroup.addHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.687 -0400", hash_original_method = "4C12242853C02960B9FD442E279D83C0", hash_generated_method = "AF4E25C365C3AAF720F69416CA5917BD")
    public void addHeader(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException varDDD3396BC702FA063F0107D538A5EACE_396352298 = new IllegalArgumentException("Header name may not be null");
            varDDD3396BC702FA063F0107D538A5EACE_396352298.addTaint(taint);
            throw varDDD3396BC702FA063F0107D538A5EACE_396352298;
        } //End block
        this.headergroup.addHeader(new BasicHeader(name, value));
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Header name may not be null");
        //}
        //this.headergroup.addHeader(new BasicHeader(name, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.687 -0400", hash_original_method = "65F67011ED88E162C7A3317CC96C8B85", hash_generated_method = "F1D2C2DCD3D68500794D8C867A8BD15E")
    public void setHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.updateHeader(header);
        // ---------- Original Method ----------
        //this.headergroup.updateHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.687 -0400", hash_original_method = "59EEDD7DD894E22B8BE3BEB8962485C4", hash_generated_method = "5B8DA74B1028E21580C006E7FE5946E3")
    public void setHeader(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException varDDD3396BC702FA063F0107D538A5EACE_429784054 = new IllegalArgumentException("Header name may not be null");
            varDDD3396BC702FA063F0107D538A5EACE_429784054.addTaint(taint);
            throw varDDD3396BC702FA063F0107D538A5EACE_429784054;
        } //End block
        this.headergroup.updateHeader(new BasicHeader(name, value));
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Header name may not be null");
        //}
        //this.headergroup.updateHeader(new BasicHeader(name, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.688 -0400", hash_original_method = "F77171669C40FC4A8C250022B7C99495", hash_generated_method = "4958BB23364477624DFE7A07616288AB")
    public void setHeaders(final Header[] headers) {
        addTaint(headers[0].getTaint());
        this.headergroup.setHeaders(headers);
        // ---------- Original Method ----------
        //this.headergroup.setHeaders(headers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.688 -0400", hash_original_method = "167D8764CCE16F3185A846BF9C0F5516", hash_generated_method = "9CA5D0EFAEF56E4ED8F969F1B320D0DE")
    public void removeHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.removeHeader(header);
        // ---------- Original Method ----------
        //this.headergroup.removeHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.688 -0400", hash_original_method = "D7D4084B603700D250D598944C009D40", hash_generated_method = "8DECB189B49C11DFF23DD66904375BE4")
    public void removeHeaders(final String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            return;
        } //End block
for(Iterator i = this.headergroup.iterator();i.hasNext();)
        {
            Header header = (Header) i.next();
            if(name.equalsIgnoreCase(header.getName()))            
            {
                i.remove();
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.689 -0400", hash_original_method = "7F921B9752F1205280862FD328D06FCE", hash_generated_method = "11DC556AB5A7CD2C30D25EE30BFEF6F5")
    public HeaderIterator headerIterator() {
HeaderIterator varBC8FD1A25E6CA34046651A289C8D3833_1881158950 =         this.headergroup.iterator();
        varBC8FD1A25E6CA34046651A289C8D3833_1881158950.addTaint(taint);
        return varBC8FD1A25E6CA34046651A289C8D3833_1881158950;
        // ---------- Original Method ----------
        //return this.headergroup.iterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.689 -0400", hash_original_method = "68644A261C0F1E0602A67E0AF6E4CB07", hash_generated_method = "9E0DBA1841149CB7A9122ACC60CBDE91")
    public HeaderIterator headerIterator(String name) {
        addTaint(name.getTaint());
HeaderIterator var50B3BE6049EC99BC0B6303B951AFDF6C_992847140 =         this.headergroup.iterator(name);
        var50B3BE6049EC99BC0B6303B951AFDF6C_992847140.addTaint(taint);
        return var50B3BE6049EC99BC0B6303B951AFDF6C_992847140;
        // ---------- Original Method ----------
        //return this.headergroup.iterator(name);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.690 -0400", hash_original_method = "D8EA4E4823DF4752A606F523C6CA7ECB", hash_generated_method = "AF65BD021E48BAE90ACBF2AF1B7E2A9E")
    public HttpParams getParams() {
        if(this.params == null)        
        {
            this.params = new BasicHttpParams();
        } //End block
HttpParams var751A5B03769AE238544A23D7966F9A50_192188733 =         this.params;
        var751A5B03769AE238544A23D7966F9A50_192188733.addTaint(taint);
        return var751A5B03769AE238544A23D7966F9A50_192188733;
        // ---------- Original Method ----------
        //if (this.params == null) {
            //this.params = new BasicHttpParams();
        //}
        //return this.params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.690 -0400", hash_original_method = "1CAC19773CE7693AFF1DBB697E1BBCDE", hash_generated_method = "364A72EFA84C692DE837E4DF51796BDF")
    public void setParams(final HttpParams params) {
        if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_388023714 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_388023714.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_388023714;
        } //End block
        this.params = params;
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new IllegalArgumentException("HTTP parameters may not be null");
        //}
        //this.params = params;
    }

    
}

