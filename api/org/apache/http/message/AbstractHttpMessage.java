package org.apache.http.message;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.280 -0400", hash_original_field = "F5C7F01E4A3E94206E282D02BF390DB2", hash_generated_field = "34FF19CD0855E5D63A04F524D7452FF4")

    protected HeaderGroup headergroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.280 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.280 -0400", hash_original_method = "926C531625268700794509BCC2F5F77F", hash_generated_method = "F64E6306B6CC36DC6AE4D39268C8D717")
    protected  AbstractHttpMessage(final HttpParams params) {
        super();
        this.headergroup = new HeaderGroup();
        this.params = params;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.281 -0400", hash_original_method = "2222B1AD198C1052436204E49A67A13C", hash_generated_method = "20CE23CB860DE8F239A1882E6A61E5B3")
    protected  AbstractHttpMessage() {
        this(null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.281 -0400", hash_original_method = "9EF327933AC8CF093A78CA62674DD20F", hash_generated_method = "268D40C59F0D2BD903C5EE428D948DEE")
    public boolean containsHeader(String name) {
        addTaint(name.getTaint());
        boolean varBAF0911C5B07CAA71AE5E495DF06E2EB_966778092 = (this.headergroup.containsHeader(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415257622 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415257622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.281 -0400", hash_original_method = "FE431DBB9584369B7EDB43E7189B0AE3", hash_generated_method = "4AAEC0D0A533BDCA47B49A1FE049B0B9")
    public Header[] getHeaders(final String name) {
        addTaint(name.getTaint());
Header[] var4405D79A789F00918F592F035CB6C2D8_1816556279 =         this.headergroup.getHeaders(name);
        var4405D79A789F00918F592F035CB6C2D8_1816556279.addTaint(taint);
        return var4405D79A789F00918F592F035CB6C2D8_1816556279;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.281 -0400", hash_original_method = "4F426424B706B56A99E07E40B5C52BFA", hash_generated_method = "B88C69D61A15834D8BE8599B8C63371D")
    public Header getFirstHeader(final String name) {
        addTaint(name.getTaint());
Header var76E8CB6F7B6FA9646332056848EE09DA_1393411267 =         this.headergroup.getFirstHeader(name);
        var76E8CB6F7B6FA9646332056848EE09DA_1393411267.addTaint(taint);
        return var76E8CB6F7B6FA9646332056848EE09DA_1393411267;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.282 -0400", hash_original_method = "2D4239F1E5F9F68D789A00645007924A", hash_generated_method = "E00122946051FBB1281500254A1D48E4")
    public Header getLastHeader(final String name) {
        addTaint(name.getTaint());
Header varDCA51A694DA7D6393945A3D3B01EF2B5_1605776514 =         this.headergroup.getLastHeader(name);
        varDCA51A694DA7D6393945A3D3B01EF2B5_1605776514.addTaint(taint);
        return varDCA51A694DA7D6393945A3D3B01EF2B5_1605776514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.282 -0400", hash_original_method = "89AD2C028927AB3E8715A79204D69C99", hash_generated_method = "60A8AC79AD2F633B0FE0068B792A5540")
    public Header[] getAllHeaders() {
Header[] var99C90132A83F658FD46240FBE89AABEC_608863904 =         this.headergroup.getAllHeaders();
        var99C90132A83F658FD46240FBE89AABEC_608863904.addTaint(taint);
        return var99C90132A83F658FD46240FBE89AABEC_608863904;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.282 -0400", hash_original_method = "1DE731CFF4ECF4DBA0EF3FE32BB726E4", hash_generated_method = "751B734939824D5C25A49ACB3EDE30C5")
    public void addHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.addHeader(header);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.283 -0400", hash_original_method = "4C12242853C02960B9FD442E279D83C0", hash_generated_method = "A549A2C1980B45840E8D06B62F3AD321")
    public void addHeader(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException varDDD3396BC702FA063F0107D538A5EACE_175383783 = new IllegalArgumentException("Header name may not be null");
            varDDD3396BC702FA063F0107D538A5EACE_175383783.addTaint(taint);
            throw varDDD3396BC702FA063F0107D538A5EACE_175383783;
        } 
        this.headergroup.addHeader(new BasicHeader(name, value));
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.283 -0400", hash_original_method = "65F67011ED88E162C7A3317CC96C8B85", hash_generated_method = "F1D2C2DCD3D68500794D8C867A8BD15E")
    public void setHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.updateHeader(header);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.283 -0400", hash_original_method = "59EEDD7DD894E22B8BE3BEB8962485C4", hash_generated_method = "3AF20F5DBDDB4298D3D05CD99ED92196")
    public void setHeader(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException varDDD3396BC702FA063F0107D538A5EACE_371022152 = new IllegalArgumentException("Header name may not be null");
            varDDD3396BC702FA063F0107D538A5EACE_371022152.addTaint(taint);
            throw varDDD3396BC702FA063F0107D538A5EACE_371022152;
        } 
        this.headergroup.updateHeader(new BasicHeader(name, value));
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.284 -0400", hash_original_method = "F77171669C40FC4A8C250022B7C99495", hash_generated_method = "4958BB23364477624DFE7A07616288AB")
    public void setHeaders(final Header[] headers) {
        addTaint(headers[0].getTaint());
        this.headergroup.setHeaders(headers);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.284 -0400", hash_original_method = "167D8764CCE16F3185A846BF9C0F5516", hash_generated_method = "9CA5D0EFAEF56E4ED8F969F1B320D0DE")
    public void removeHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.removeHeader(header);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.284 -0400", hash_original_method = "D7D4084B603700D250D598944C009D40", hash_generated_method = "8DECB189B49C11DFF23DD66904375BE4")
    public void removeHeaders(final String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
            return;
        } 
for(Iterator i = this.headergroup.iterator();i.hasNext();)
        {
            Header header = (Header) i.next();
    if(name.equalsIgnoreCase(header.getName()))            
            {
                i.remove();
            } 
        } 
        
        
            
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.285 -0400", hash_original_method = "7F921B9752F1205280862FD328D06FCE", hash_generated_method = "83BBF5634A6BF1CC797647B75C640B93")
    public HeaderIterator headerIterator() {
HeaderIterator varBC8FD1A25E6CA34046651A289C8D3833_485808447 =         this.headergroup.iterator();
        varBC8FD1A25E6CA34046651A289C8D3833_485808447.addTaint(taint);
        return varBC8FD1A25E6CA34046651A289C8D3833_485808447;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.285 -0400", hash_original_method = "68644A261C0F1E0602A67E0AF6E4CB07", hash_generated_method = "63722F77C2C74054E351DF4FB04B3637")
    public HeaderIterator headerIterator(String name) {
        addTaint(name.getTaint());
HeaderIterator var50B3BE6049EC99BC0B6303B951AFDF6C_390273764 =         this.headergroup.iterator(name);
        var50B3BE6049EC99BC0B6303B951AFDF6C_390273764.addTaint(taint);
        return var50B3BE6049EC99BC0B6303B951AFDF6C_390273764;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.286 -0400", hash_original_method = "D8EA4E4823DF4752A606F523C6CA7ECB", hash_generated_method = "AA66697F63A964CA147A0A0E60C61ED8")
    public HttpParams getParams() {
    if(this.params == null)        
        {
            this.params = new BasicHttpParams();
        } 
HttpParams var751A5B03769AE238544A23D7966F9A50_1416935422 =         this.params;
        var751A5B03769AE238544A23D7966F9A50_1416935422.addTaint(taint);
        return var751A5B03769AE238544A23D7966F9A50_1416935422;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.286 -0400", hash_original_method = "1CAC19773CE7693AFF1DBB697E1BBCDE", hash_generated_method = "C2E5E177F3FC05B796ED99408DB92537")
    public void setParams(final HttpParams params) {
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1187967424 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1187967424.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1187967424;
        } 
        this.params = params;
        
        
            
        
        
    }

    
}

