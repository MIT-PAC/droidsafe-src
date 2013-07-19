package org.apache.http.protocol;

// Droidsafe Imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.271 -0400", hash_original_field = "64A6AD684B4F541C1BD4714BB04DE78B", hash_generated_field = "7398F9B2AE291E5D2787309DA0C28986")

    protected List requestInterceptors = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.271 -0400", hash_original_field = "620ABA3C255A8A96966418E89DEDC718", hash_generated_field = "9A978F38560CD78676894BBBC402D767")

    protected List responseInterceptors = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.271 -0400", hash_original_method = "9C379E6850D70F22993610B85EB51FC7", hash_generated_method = "9C379E6850D70F22993610B85EB51FC7")
    public BasicHttpProcessor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.272 -0400", hash_original_method = "E1A96A9E1100F28388C805D474E7BAD5", hash_generated_method = "43CA18985E31F99BD906B71D514764B2")
    public void addRequestInterceptor(final HttpRequestInterceptor itcp) {
        addTaint(itcp.getTaint());
        if(itcp == null)        
        {
            return;
        } //End block
        if(this.requestInterceptors == null)        
        {
            this.requestInterceptors = new ArrayList();
        } //End block
        this.requestInterceptors.add(itcp);
        // ---------- Original Method ----------
        //if (itcp == null) {
            //return;
        //}
        //if (this.requestInterceptors == null) {
            //this.requestInterceptors = new ArrayList();
        //}
        //this.requestInterceptors.add(itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.272 -0400", hash_original_method = "7082E628C139155B4DBFBA26A9DAA55A", hash_generated_method = "220A31673FAEBBEF76A821D4B63DE459")
    public void addRequestInterceptor(final HttpRequestInterceptor itcp,
                                      int index) {
        addTaint(index);
        addTaint(itcp.getTaint());
        if(index < 0)        
        {
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_1354602270 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_1354602270.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_1354602270;
        } //End block
        if(itcp == null)        
        {
            return;
        } //End block
        if(this.requestInterceptors == null)        
        {
            if(index > 0)            
            {
                IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_783110524 = new IndexOutOfBoundsException(String.valueOf(index));
                varDC2A30BE720FF28962244F217E60E3D1_783110524.addTaint(taint);
                throw varDC2A30BE720FF28962244F217E60E3D1_783110524;
            } //End block
            this.requestInterceptors = new ArrayList();
        } //End block
        this.requestInterceptors.add(index, itcp);
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        //}
        //if (itcp == null) {
            //return;
        //}
        //if (this.requestInterceptors == null) {
            //if (index > 0) {
                //throw new IndexOutOfBoundsException(String.valueOf(index));
            //}
            //this.requestInterceptors = new ArrayList();
        //}
        //this.requestInterceptors.add(index, itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.273 -0400", hash_original_method = "306BD5279F186A7F697194E65EEC0E22", hash_generated_method = "A1E462AB0B6FE7C50515320F66C0F5A9")
    public void addResponseInterceptor(HttpResponseInterceptor itcp,
                                       int index) {
        addTaint(index);
        addTaint(itcp.getTaint());
        if(index < 0)        
        {
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_654197142 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_654197142.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_654197142;
        } //End block
        if(itcp == null)        
        {
            return;
        } //End block
        if(this.responseInterceptors == null)        
        {
            if(index > 0)            
            {
                IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_26302749 = new IndexOutOfBoundsException(String.valueOf(index));
                varDC2A30BE720FF28962244F217E60E3D1_26302749.addTaint(taint);
                throw varDC2A30BE720FF28962244F217E60E3D1_26302749;
            } //End block
            this.responseInterceptors = new ArrayList();
        } //End block
        this.responseInterceptors.add(index, itcp);
        // ---------- Original Method ----------
        //if (index < 0) {
            //throw new IndexOutOfBoundsException(String.valueOf(index));
        //}
        //if (itcp == null) {
            //return;
        //}
        //if (this.responseInterceptors == null) {
            //if (index > 0) {
                //throw new IndexOutOfBoundsException(String.valueOf(index));
            //}
            //this.responseInterceptors = new ArrayList();
        //}
        //this.responseInterceptors.add(index, itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.274 -0400", hash_original_method = "EFB13BD2F5F78871DC67563CE3418B82", hash_generated_method = "DD8F501BC781DCC0884C431D7779FD7B")
    public void removeRequestInterceptorByClass(final Class clazz) {
        addTaint(clazz.getTaint());
        if(this.requestInterceptors == null)        
        {
            return;
        } //End block
for(Iterator it = this.requestInterceptors.iterator();it.hasNext();)
        {
            Object request = it.next();
            if(request.getClass().equals(clazz))            
            {
                it.remove();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (this.requestInterceptors == null) {
            //return;
        //}
        //for (Iterator it = this.requestInterceptors.iterator();
             //it.hasNext(); ) {
            //Object request = it.next();
            //if (request.getClass().equals(clazz)) {
                //it.remove();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.274 -0400", hash_original_method = "DF5F226D1AE22FA4A42A4921E11EE920", hash_generated_method = "FC93A81C9CA01432D2758AFB2F7AF779")
    public void removeResponseInterceptorByClass(final Class clazz) {
        addTaint(clazz.getTaint());
        if(this.responseInterceptors == null)        
        {
            return;
        } //End block
for(Iterator it = this.responseInterceptors.iterator();it.hasNext();)
        {
            Object request = it.next();
            if(request.getClass().equals(clazz))            
            {
                it.remove();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (this.responseInterceptors == null) {
            //return;
        //}
        //for (Iterator it = this.responseInterceptors.iterator();
             //it.hasNext(); ) {
            //Object request = it.next();
            //if (request.getClass().equals(clazz)) {
                //it.remove();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.274 -0400", hash_original_method = "49979C36D9B3AD67BC7E969CE817FBA1", hash_generated_method = "71753161E07BAE536FAC5EC5823F5A84")
    public final void addInterceptor(final HttpRequestInterceptor interceptor) {
        addTaint(interceptor.getTaint());
        addRequestInterceptor(interceptor);
        // ---------- Original Method ----------
        //addRequestInterceptor(interceptor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.275 -0400", hash_original_method = "E7AC62DE103BF676D1A944DB4C5B9066", hash_generated_method = "10E088BA23162F45488EEEB272BA9A21")
    public final void addInterceptor(final HttpRequestInterceptor interceptor,
                                int index) {
        addTaint(index);
        addTaint(interceptor.getTaint());
        addRequestInterceptor(interceptor, index);
        // ---------- Original Method ----------
        //addRequestInterceptor(interceptor, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.275 -0400", hash_original_method = "88BEDAF27A7611A7A46622E627DC9A63", hash_generated_method = "FFFBC8087AA6CCEC29B0F972A711F8E1")
    public int getRequestInterceptorCount() {
        int var8B4705A5E70C7FBFDEA16C4AD5B18926_818514916 = ((this.requestInterceptors == null) ?
            0 : this.requestInterceptors.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45291381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45291381;
        // ---------- Original Method ----------
        //return (this.requestInterceptors == null) ?
            //0 : this.requestInterceptors.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.275 -0400", hash_original_method = "977729FD94F3060F22AEFDD0D34CFD7C", hash_generated_method = "0A8AB54413CBFE298FA0C5087D79A161")
    public HttpRequestInterceptor getRequestInterceptor(int index) {
        addTaint(index);
        if((this.requestInterceptors == null) ||
                (index < 0) || (index >= this.requestInterceptors.size()))        
        {
HttpRequestInterceptor var540C13E9E156B687226421B24F2DF178_794302719 =         null;
        var540C13E9E156B687226421B24F2DF178_794302719.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_794302719;
        }
HttpRequestInterceptor var39DF5014B1B8FB8C6EC2BA775A357664_41853991 =         (HttpRequestInterceptor) this.requestInterceptors.get(index);
        var39DF5014B1B8FB8C6EC2BA775A357664_41853991.addTaint(taint);
        return var39DF5014B1B8FB8C6EC2BA775A357664_41853991;
        // ---------- Original Method ----------
        //if ((this.requestInterceptors == null) ||
                //(index < 0) || (index >= this.requestInterceptors.size()))
            //return null;
        //return (HttpRequestInterceptor) this.requestInterceptors.get(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.276 -0400", hash_original_method = "145E2FEDCA1A32FEC7370D21776649A2", hash_generated_method = "2DD9E24066548ACA81CF15355B844800")
    public void clearRequestInterceptors() {
        this.requestInterceptors = null;
        // ---------- Original Method ----------
        //this.requestInterceptors = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.276 -0400", hash_original_method = "7D6C31789EA3365B9B9BD2DA3F7D37E3", hash_generated_method = "894F7DCE6C531A0C2211B0381105BA79")
    public void addResponseInterceptor(final HttpResponseInterceptor itcp) {
        addTaint(itcp.getTaint());
        if(itcp == null)        
        {
            return;
        } //End block
        if(this.responseInterceptors == null)        
        {
            this.responseInterceptors = new ArrayList();
        } //End block
        this.responseInterceptors.add(itcp);
        // ---------- Original Method ----------
        //if (itcp == null) {
            //return;
        //}
        //if (this.responseInterceptors == null) {
            //this.responseInterceptors = new ArrayList();
        //}
        //this.responseInterceptors.add(itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.276 -0400", hash_original_method = "7DCB6CEE097C8760F94401368BED6C8A", hash_generated_method = "9B7A7794B28BD32D297D341CE2B3D40C")
    public final void addInterceptor(final HttpResponseInterceptor interceptor) {
        addTaint(interceptor.getTaint());
        addResponseInterceptor(interceptor);
        // ---------- Original Method ----------
        //addResponseInterceptor(interceptor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.277 -0400", hash_original_method = "5F99216482E6DE112B8985A77BFA25FC", hash_generated_method = "38F6D938BB2F534B49F063C68850827A")
    public final void addInterceptor(final HttpResponseInterceptor interceptor,
                                     int index) {
        addTaint(index);
        addTaint(interceptor.getTaint());
        addResponseInterceptor(interceptor, index);
        // ---------- Original Method ----------
        //addResponseInterceptor(interceptor, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.277 -0400", hash_original_method = "076BC0B3D789CD5AF4622C7C18D19D27", hash_generated_method = "CB8F453D5AABC7B62AD23B63C75E91A0")
    public int getResponseInterceptorCount() {
        int varF627BE53DD27C71760DBA4AFD2455F39_1421890409 = ((this.responseInterceptors == null) ?
            0 : this.responseInterceptors.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982986189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982986189;
        // ---------- Original Method ----------
        //return (this.responseInterceptors == null) ?
            //0 : this.responseInterceptors.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.278 -0400", hash_original_method = "745ED53DD037C2DD0D029886B0DA9F3E", hash_generated_method = "B2A047C13FF2D708E06FCEFC1FCCB167")
    public HttpResponseInterceptor getResponseInterceptor(int index) {
        addTaint(index);
        if((this.responseInterceptors == null) ||
                (index < 0) || (index >= this.responseInterceptors.size()))        
        {
HttpResponseInterceptor var540C13E9E156B687226421B24F2DF178_912767935 =         null;
        var540C13E9E156B687226421B24F2DF178_912767935.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_912767935;
        }
HttpResponseInterceptor var32D940C10DC357DD7965B943C7C1E197_388270268 =         (HttpResponseInterceptor) this.responseInterceptors.get(index);
        var32D940C10DC357DD7965B943C7C1E197_388270268.addTaint(taint);
        return var32D940C10DC357DD7965B943C7C1E197_388270268;
        // ---------- Original Method ----------
        //if ((this.responseInterceptors == null) ||
                //(index < 0) || (index >= this.responseInterceptors.size()))
            //return null;
        //return (HttpResponseInterceptor) this.responseInterceptors.get(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.278 -0400", hash_original_method = "312DB737544A7054D89F25FB9ECC2521", hash_generated_method = "9D3E135536DF2EF44F610851B9BC1333")
    public void clearResponseInterceptors() {
        this.responseInterceptors = null;
        // ---------- Original Method ----------
        //this.responseInterceptors = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.279 -0400", hash_original_method = "2546A12B167929D122A18C572AD1485C", hash_generated_method = "566B3AE3377272C9B5236FD020F461D5")
    public void setInterceptors(final List list) {
        addTaint(list.getTaint());
        if(list == null)        
        {
            IllegalArgumentException varD88BA4B6DC7EDECCAAA4CA1A2FE96DEC_1549600882 = new IllegalArgumentException("List must not be null.");
            varD88BA4B6DC7EDECCAAA4CA1A2FE96DEC_1549600882.addTaint(taint);
            throw varD88BA4B6DC7EDECCAAA4CA1A2FE96DEC_1549600882;
        } //End block
        if(this.requestInterceptors != null)        
        {
            this.requestInterceptors.clear();
        } //End block
        if(this.responseInterceptors != null)        
        {
            this.responseInterceptors.clear();
        } //End block
for(int i = 0;i < list.size();i++)
        {
            Object obj = list.get(i);
            if(obj instanceof HttpRequestInterceptor)            
            {
                addInterceptor((HttpRequestInterceptor)obj);
            } //End block
            if(obj instanceof HttpResponseInterceptor)            
            {
                addInterceptor((HttpResponseInterceptor)obj);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (list == null) {
            //throw new IllegalArgumentException("List must not be null.");
        //}
        //if (this.requestInterceptors != null) {
            //this.requestInterceptors.clear();
        //}
        //if (this.responseInterceptors != null) {
            //this.responseInterceptors.clear();
        //}
        //for (int i = 0; i < list.size(); i++) {
            //Object obj = list.get(i);
            //if (obj instanceof HttpRequestInterceptor) {
                //addInterceptor((HttpRequestInterceptor)obj);
            //}
            //if (obj instanceof HttpResponseInterceptor) {
                //addInterceptor((HttpResponseInterceptor)obj);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.280 -0400", hash_original_method = "D115BE155D407C71B3079D92DD3ABF36", hash_generated_method = "BFCDBEB91DE292DDDFE071E86B5D1B74")
    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
        // ---------- Original Method ----------
        //clearRequestInterceptors();
        //clearResponseInterceptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.280 -0400", hash_original_method = "73AD1047DC7932E91E23500135DCAA1F", hash_generated_method = "045A26784079CCC24C8F518F7223AAFC")
    public void process(
            final HttpRequest request,
            final HttpContext context) throws IOException, HttpException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        if(this.requestInterceptors != null)        
        {
for(int i = 0;i < this.requestInterceptors.size();i++)
            {
                HttpRequestInterceptor interceptor = (HttpRequestInterceptor) this.requestInterceptors.get(i);
                interceptor.process(request, context);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (this.requestInterceptors != null) {
            //for (int i = 0; i < this.requestInterceptors.size(); i++) {
                //HttpRequestInterceptor interceptor =
                    //(HttpRequestInterceptor) this.requestInterceptors.get(i);
                //interceptor.process(request, context);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.281 -0400", hash_original_method = "41A094A5EA8F96220C5B29D851C7CE79", hash_generated_method = "BAA0D3342EE340E5417E26A8496BF8F5")
    public void process(
            final HttpResponse response,
            final HttpContext context) throws IOException, HttpException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        if(this.responseInterceptors != null)        
        {
for(int i = 0;i < this.responseInterceptors.size();i++)
            {
                HttpResponseInterceptor interceptor = (HttpResponseInterceptor) this.responseInterceptors.get(i);
                interceptor.process(response, context);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (this.responseInterceptors != null) {
            //for (int i = 0; i < this.responseInterceptors.size(); i++) {
                //HttpResponseInterceptor interceptor =
                    //(HttpResponseInterceptor) this.responseInterceptors.get(i);
                //interceptor.process(response, context);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.281 -0400", hash_original_method = "1B68B439697A421DCA2B8CED4C47D3CE", hash_generated_method = "3837A4C389E1F2B11375110EC4E1CAB7")
    protected void copyInterceptors(final BasicHttpProcessor target) {
        if(this.requestInterceptors != null)        
        {
            target.requestInterceptors =
                new ArrayList(this.requestInterceptors);
        } //End block
        if(this.responseInterceptors != null)        
        {
            target.responseInterceptors =
                new ArrayList(this.responseInterceptors);
        } //End block
        // ---------- Original Method ----------
        //if (this.requestInterceptors != null) {
            //target.requestInterceptors =
                //new ArrayList(this.requestInterceptors);
        //}
        //if (this.responseInterceptors != null) {
            //target.responseInterceptors =
                //new ArrayList(this.responseInterceptors);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.282 -0400", hash_original_method = "166F0C6BA2B53E84DB5B8B4516A0E908", hash_generated_method = "BF85303837D1D4127D70C81795AF1FFB")
    public BasicHttpProcessor copy() {
        BasicHttpProcessor clone = new BasicHttpProcessor();
        copyInterceptors(clone);
BasicHttpProcessor var3DE52045BFD3C1BF3742F994ED6139AD_1949790886 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1949790886.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1949790886;
        // ---------- Original Method ----------
        //BasicHttpProcessor clone = new BasicHttpProcessor();
        //copyInterceptors(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.282 -0400", hash_original_method = "5AA72A12635065E25111537F7EBBA8DC", hash_generated_method = "B46ED957BBB6B478A17955FB0BE46A9E")
    public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor clone = (BasicHttpProcessor) super.clone();
        copyInterceptors(clone);
Object var3DE52045BFD3C1BF3742F994ED6139AD_1366233133 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1366233133.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1366233133;
        // ---------- Original Method ----------
        //BasicHttpProcessor clone = (BasicHttpProcessor) super.clone();
        //copyInterceptors(clone);
        //return clone;
    }

    
}

