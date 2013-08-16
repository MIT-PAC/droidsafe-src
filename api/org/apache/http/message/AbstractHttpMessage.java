package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpMessage;
import org.apache.http.params.HttpParams;
import org.apache.http.params.BasicHttpParams;

public abstract class AbstractHttpMessage implements HttpMessage {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.647 -0400", hash_original_field = "F5C7F01E4A3E94206E282D02BF390DB2", hash_generated_field = "34FF19CD0855E5D63A04F524D7452FF4")

    protected HeaderGroup headergroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.647 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.649 -0400", hash_original_method = "926C531625268700794509BCC2F5F77F", hash_generated_method = "F64E6306B6CC36DC6AE4D39268C8D717")
    protected  AbstractHttpMessage(final HttpParams params) {
        super();
        this.headergroup = new HeaderGroup();
        this.params = params;
        // ---------- Original Method ----------
        //this.headergroup = new HeaderGroup();
        //this.params = params;
    }

    
    @DSModeled(DSC.SAFE)
	public AbstractHttpMessage() {
		// TODO Auto-generated constructor stub
	}

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.651 -0400", hash_original_method = "9EF327933AC8CF093A78CA62674DD20F", hash_generated_method = "C176AB21E0DFFA2FF35A83D1F157B9F2")
    public boolean containsHeader(String name) {
        addTaint(name.getTaint());
        boolean varBAF0911C5B07CAA71AE5E495DF06E2EB_776724542 = (this.headergroup.containsHeader(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1085554019 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1085554019;
        // ---------- Original Method ----------
        //return this.headergroup.containsHeader(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.653 -0400", hash_original_method = "FE431DBB9584369B7EDB43E7189B0AE3", hash_generated_method = "EF8DE302BF149A50F035A1BB2F000237")
    public Header[] getHeaders(final String name) {
        addTaint(name.getTaint());
Header[] var4405D79A789F00918F592F035CB6C2D8_1820405280 =         this.headergroup.getHeaders(name);
        var4405D79A789F00918F592F035CB6C2D8_1820405280.addTaint(taint);
        return var4405D79A789F00918F592F035CB6C2D8_1820405280;
        // ---------- Original Method ----------
        //return this.headergroup.getHeaders(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.654 -0400", hash_original_method = "4F426424B706B56A99E07E40B5C52BFA", hash_generated_method = "878B71679C1BECB4683230820856838F")
    public Header getFirstHeader(final String name) {
        addTaint(name.getTaint());
Header var76E8CB6F7B6FA9646332056848EE09DA_598808874 =         this.headergroup.getFirstHeader(name);
        var76E8CB6F7B6FA9646332056848EE09DA_598808874.addTaint(taint);
        return var76E8CB6F7B6FA9646332056848EE09DA_598808874;
        // ---------- Original Method ----------
        //return this.headergroup.getFirstHeader(name);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.655 -0400", hash_original_method = "2D4239F1E5F9F68D789A00645007924A", hash_generated_method = "CC09081129781D653DD392FA6CC1A219")
    public Header getLastHeader(final String name) {
        addTaint(name.getTaint());
Header varDCA51A694DA7D6393945A3D3B01EF2B5_1953978623 =         this.headergroup.getLastHeader(name);
        varDCA51A694DA7D6393945A3D3B01EF2B5_1953978623.addTaint(taint);
        return varDCA51A694DA7D6393945A3D3B01EF2B5_1953978623;
        // ---------- Original Method ----------
        //return this.headergroup.getLastHeader(name);
    }

    @DSModeled(DSC.SAFE)
    @Override
	public Header[] getAllHeaders() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.657 -0400", hash_original_method = "1DE731CFF4ECF4DBA0EF3FE32BB726E4", hash_generated_method = "751B734939824D5C25A49ACB3EDE30C5")
    public void addHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.addHeader(header);
        // ---------- Original Method ----------
        //this.headergroup.addHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.659 -0400", hash_original_method = "4C12242853C02960B9FD442E279D83C0", hash_generated_method = "9D2609BFB83884704A65B5849DB05F1E")
    public void addHeader(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException varDDD3396BC702FA063F0107D538A5EACE_851700294 = new IllegalArgumentException("Header name may not be null");
            varDDD3396BC702FA063F0107D538A5EACE_851700294.addTaint(taint);
            throw varDDD3396BC702FA063F0107D538A5EACE_851700294;
        } //End block
        this.headergroup.addHeader(new BasicHeader(name, value));
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Header name may not be null");
        //}
        //this.headergroup.addHeader(new BasicHeader(name, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.661 -0400", hash_original_method = "65F67011ED88E162C7A3317CC96C8B85", hash_generated_method = "F1D2C2DCD3D68500794D8C867A8BD15E")
    public void setHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.updateHeader(header);
        // ---------- Original Method ----------
        //this.headergroup.updateHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.664 -0400", hash_original_method = "59EEDD7DD894E22B8BE3BEB8962485C4", hash_generated_method = "1F436CBC258CE64D9F3007B0DFEB4E87")
    public void setHeader(final String name, final String value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException varDDD3396BC702FA063F0107D538A5EACE_830321158 = new IllegalArgumentException("Header name may not be null");
            varDDD3396BC702FA063F0107D538A5EACE_830321158.addTaint(taint);
            throw varDDD3396BC702FA063F0107D538A5EACE_830321158;
        } //End block
        this.headergroup.updateHeader(new BasicHeader(name, value));
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("Header name may not be null");
        //}
        //this.headergroup.updateHeader(new BasicHeader(name, value));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.665 -0400", hash_original_method = "F77171669C40FC4A8C250022B7C99495", hash_generated_method = "4958BB23364477624DFE7A07616288AB")
    public void setHeaders(final Header[] headers) {
        addTaint(headers[0].getTaint());
        this.headergroup.setHeaders(headers);
        // ---------- Original Method ----------
        //this.headergroup.setHeaders(headers);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.667 -0400", hash_original_method = "167D8764CCE16F3185A846BF9C0F5516", hash_generated_method = "9CA5D0EFAEF56E4ED8F969F1B320D0DE")
    public void removeHeader(final Header header) {
        addTaint(header.getTaint());
        this.headergroup.removeHeader(header);
        // ---------- Original Method ----------
        //this.headergroup.removeHeader(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.669 -0400", hash_original_method = "D7D4084B603700D250D598944C009D40", hash_generated_method = "8DECB189B49C11DFF23DD66904375BE4")
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

    
    @Override
    @DSModeled(DSC.SAFE)
	public HeaderIterator headerIterator() {
		// TODO Auto-generated method stub
		return null;
	}

    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.671 -0400", hash_original_method = "68644A261C0F1E0602A67E0AF6E4CB07", hash_generated_method = "C5353D8868DBF237B583ADEB4A3EF94A")
    public HeaderIterator headerIterator(String name) {
        addTaint(name.getTaint());
HeaderIterator var50B3BE6049EC99BC0B6303B951AFDF6C_1710152334 =         this.headergroup.iterator(name);
        var50B3BE6049EC99BC0B6303B951AFDF6C_1710152334.addTaint(taint);
        return var50B3BE6049EC99BC0B6303B951AFDF6C_1710152334;
        // ---------- Original Method ----------
        //return this.headergroup.iterator(name);
    }

    @DSModeled(DSC.SAFE)
    @Override
	public HttpParams getParams() {
		// TODO Auto-generated method stub
		return null;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:01.674 -0400", hash_original_method = "1CAC19773CE7693AFF1DBB697E1BBCDE", hash_generated_method = "F349EF5C051056C4D7A363D77B2744C7")
    public void setParams(final HttpParams params) {
        if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1885690325 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1885690325.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1885690325;
        } //End block
        this.params = params;
        // ---------- Original Method ----------
        //if (params == null) {
            //throw new IllegalArgumentException("HTTP parameters may not be null");
        //}
        //this.params = params;
    }

    

}

