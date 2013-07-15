package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;

public final class BasicHttpProcessor implements HttpProcessor, HttpRequestInterceptorList, HttpResponseInterceptorList, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.885 -0400", hash_original_field = "64A6AD684B4F541C1BD4714BB04DE78B", hash_generated_field = "7398F9B2AE291E5D2787309DA0C28986")

    protected List requestInterceptors = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.886 -0400", hash_original_field = "620ABA3C255A8A96966418E89DEDC718", hash_generated_field = "9A978F38560CD78676894BBBC402D767")

    protected List responseInterceptors = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.886 -0400", hash_original_method = "9C379E6850D70F22993610B85EB51FC7", hash_generated_method = "9C379E6850D70F22993610B85EB51FC7")
    public BasicHttpProcessor ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.886 -0400", hash_original_method = "E1A96A9E1100F28388C805D474E7BAD5", hash_generated_method = "43CA18985E31F99BD906B71D514764B2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.887 -0400", hash_original_method = "7082E628C139155B4DBFBA26A9DAA55A", hash_generated_method = "05184C2CCE14C21A72E860584A6CCAC6")
    public void addRequestInterceptor(final HttpRequestInterceptor itcp,
                                      int index) {
        addTaint(index);
        addTaint(itcp.getTaint());
    if(index < 0)        
        {
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_454962772 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_454962772.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_454962772;
        } //End block
    if(itcp == null)        
        {
            return;
        } //End block
    if(this.requestInterceptors == null)        
        {
    if(index > 0)            
            {
                IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_600448331 = new IndexOutOfBoundsException(String.valueOf(index));
                varDC2A30BE720FF28962244F217E60E3D1_600448331.addTaint(taint);
                throw varDC2A30BE720FF28962244F217E60E3D1_600448331;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.887 -0400", hash_original_method = "306BD5279F186A7F697194E65EEC0E22", hash_generated_method = "7EA625890FABEBEF105D924EB1A7F32F")
    public void addResponseInterceptor(HttpResponseInterceptor itcp,
                                       int index) {
        addTaint(index);
        addTaint(itcp.getTaint());
    if(index < 0)        
        {
            IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_610622439 = new IndexOutOfBoundsException(String.valueOf(index));
            varDC2A30BE720FF28962244F217E60E3D1_610622439.addTaint(taint);
            throw varDC2A30BE720FF28962244F217E60E3D1_610622439;
        } //End block
    if(itcp == null)        
        {
            return;
        } //End block
    if(this.responseInterceptors == null)        
        {
    if(index > 0)            
            {
                IndexOutOfBoundsException varDC2A30BE720FF28962244F217E60E3D1_1783723724 = new IndexOutOfBoundsException(String.valueOf(index));
                varDC2A30BE720FF28962244F217E60E3D1_1783723724.addTaint(taint);
                throw varDC2A30BE720FF28962244F217E60E3D1_1783723724;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.888 -0400", hash_original_method = "EFB13BD2F5F78871DC67563CE3418B82", hash_generated_method = "DD8F501BC781DCC0884C431D7779FD7B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.889 -0400", hash_original_method = "DF5F226D1AE22FA4A42A4921E11EE920", hash_generated_method = "FC93A81C9CA01432D2758AFB2F7AF779")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.889 -0400", hash_original_method = "49979C36D9B3AD67BC7E969CE817FBA1", hash_generated_method = "71753161E07BAE536FAC5EC5823F5A84")
    public final void addInterceptor(final HttpRequestInterceptor interceptor) {
        addTaint(interceptor.getTaint());
        addRequestInterceptor(interceptor);
        // ---------- Original Method ----------
        //addRequestInterceptor(interceptor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.890 -0400", hash_original_method = "E7AC62DE103BF676D1A944DB4C5B9066", hash_generated_method = "10E088BA23162F45488EEEB272BA9A21")
    public final void addInterceptor(final HttpRequestInterceptor interceptor,
                                int index) {
        addTaint(index);
        addTaint(interceptor.getTaint());
        addRequestInterceptor(interceptor, index);
        // ---------- Original Method ----------
        //addRequestInterceptor(interceptor, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.890 -0400", hash_original_method = "88BEDAF27A7611A7A46622E627DC9A63", hash_generated_method = "39E74C78FF6C46F85C6EBF5E503115A9")
    public int getRequestInterceptorCount() {
        int var8B4705A5E70C7FBFDEA16C4AD5B18926_174293527 = ((this.requestInterceptors == null) ?
            0 : this.requestInterceptors.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117894955 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1117894955;
        // ---------- Original Method ----------
        //return (this.requestInterceptors == null) ?
            //0 : this.requestInterceptors.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.890 -0400", hash_original_method = "977729FD94F3060F22AEFDD0D34CFD7C", hash_generated_method = "C175697F0D9F3AB119EEEBEA5D48F350")
    public HttpRequestInterceptor getRequestInterceptor(int index) {
        addTaint(index);
    if((this.requestInterceptors == null) ||
                (index < 0) || (index >= this.requestInterceptors.size()))        
        {
HttpRequestInterceptor var540C13E9E156B687226421B24F2DF178_2045964215 =         null;
        var540C13E9E156B687226421B24F2DF178_2045964215.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2045964215;
        }
HttpRequestInterceptor var39DF5014B1B8FB8C6EC2BA775A357664_525323052 =         (HttpRequestInterceptor) this.requestInterceptors.get(index);
        var39DF5014B1B8FB8C6EC2BA775A357664_525323052.addTaint(taint);
        return var39DF5014B1B8FB8C6EC2BA775A357664_525323052;
        // ---------- Original Method ----------
        //if ((this.requestInterceptors == null) ||
                //(index < 0) || (index >= this.requestInterceptors.size()))
            //return null;
        //return (HttpRequestInterceptor) this.requestInterceptors.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.890 -0400", hash_original_method = "145E2FEDCA1A32FEC7370D21776649A2", hash_generated_method = "2DD9E24066548ACA81CF15355B844800")
    public void clearRequestInterceptors() {
        this.requestInterceptors = null;
        // ---------- Original Method ----------
        //this.requestInterceptors = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.891 -0400", hash_original_method = "7D6C31789EA3365B9B9BD2DA3F7D37E3", hash_generated_method = "894F7DCE6C531A0C2211B0381105BA79")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.891 -0400", hash_original_method = "7DCB6CEE097C8760F94401368BED6C8A", hash_generated_method = "9B7A7794B28BD32D297D341CE2B3D40C")
    public final void addInterceptor(final HttpResponseInterceptor interceptor) {
        addTaint(interceptor.getTaint());
        addResponseInterceptor(interceptor);
        // ---------- Original Method ----------
        //addResponseInterceptor(interceptor);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.891 -0400", hash_original_method = "5F99216482E6DE112B8985A77BFA25FC", hash_generated_method = "38F6D938BB2F534B49F063C68850827A")
    public final void addInterceptor(final HttpResponseInterceptor interceptor,
                                     int index) {
        addTaint(index);
        addTaint(interceptor.getTaint());
        addResponseInterceptor(interceptor, index);
        // ---------- Original Method ----------
        //addResponseInterceptor(interceptor, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.892 -0400", hash_original_method = "076BC0B3D789CD5AF4622C7C18D19D27", hash_generated_method = "18301058777DAE384D60928008ACE260")
    public int getResponseInterceptorCount() {
        int varF627BE53DD27C71760DBA4AFD2455F39_2080048160 = ((this.responseInterceptors == null) ?
            0 : this.responseInterceptors.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614277712 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1614277712;
        // ---------- Original Method ----------
        //return (this.responseInterceptors == null) ?
            //0 : this.responseInterceptors.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.892 -0400", hash_original_method = "745ED53DD037C2DD0D029886B0DA9F3E", hash_generated_method = "2AA8BB98F473EF91609EF0851037F85B")
    public HttpResponseInterceptor getResponseInterceptor(int index) {
        addTaint(index);
    if((this.responseInterceptors == null) ||
                (index < 0) || (index >= this.responseInterceptors.size()))        
        {
HttpResponseInterceptor var540C13E9E156B687226421B24F2DF178_1759215261 =         null;
        var540C13E9E156B687226421B24F2DF178_1759215261.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1759215261;
        }
HttpResponseInterceptor var32D940C10DC357DD7965B943C7C1E197_1084239370 =         (HttpResponseInterceptor) this.responseInterceptors.get(index);
        var32D940C10DC357DD7965B943C7C1E197_1084239370.addTaint(taint);
        return var32D940C10DC357DD7965B943C7C1E197_1084239370;
        // ---------- Original Method ----------
        //if ((this.responseInterceptors == null) ||
                //(index < 0) || (index >= this.responseInterceptors.size()))
            //return null;
        //return (HttpResponseInterceptor) this.responseInterceptors.get(index);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.893 -0400", hash_original_method = "312DB737544A7054D89F25FB9ECC2521", hash_generated_method = "9D3E135536DF2EF44F610851B9BC1333")
    public void clearResponseInterceptors() {
        this.responseInterceptors = null;
        // ---------- Original Method ----------
        //this.responseInterceptors = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.893 -0400", hash_original_method = "2546A12B167929D122A18C572AD1485C", hash_generated_method = "5E9388523A34F24974D64767AB30E0B4")
    public void setInterceptors(final List list) {
        addTaint(list.getTaint());
    if(list == null)        
        {
            IllegalArgumentException varD88BA4B6DC7EDECCAAA4CA1A2FE96DEC_971407428 = new IllegalArgumentException("List must not be null.");
            varD88BA4B6DC7EDECCAAA4CA1A2FE96DEC_971407428.addTaint(taint);
            throw varD88BA4B6DC7EDECCAAA4CA1A2FE96DEC_971407428;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.894 -0400", hash_original_method = "D115BE155D407C71B3079D92DD3ABF36", hash_generated_method = "BFCDBEB91DE292DDDFE071E86B5D1B74")
    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
        // ---------- Original Method ----------
        //clearRequestInterceptors();
        //clearResponseInterceptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.894 -0400", hash_original_method = "73AD1047DC7932E91E23500135DCAA1F", hash_generated_method = "045A26784079CCC24C8F518F7223AAFC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.894 -0400", hash_original_method = "41A094A5EA8F96220C5B29D851C7CE79", hash_generated_method = "BAA0D3342EE340E5417E26A8496BF8F5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.895 -0400", hash_original_method = "1B68B439697A421DCA2B8CED4C47D3CE", hash_generated_method = "3837A4C389E1F2B11375110EC4E1CAB7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.896 -0400", hash_original_method = "166F0C6BA2B53E84DB5B8B4516A0E908", hash_generated_method = "509710EB57DAAB8453BB351389B39FF3")
    public BasicHttpProcessor copy() {
        BasicHttpProcessor clone = new BasicHttpProcessor();
        copyInterceptors(clone);
BasicHttpProcessor var3DE52045BFD3C1BF3742F994ED6139AD_609239767 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_609239767.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_609239767;
        // ---------- Original Method ----------
        //BasicHttpProcessor clone = new BasicHttpProcessor();
        //copyInterceptors(clone);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.896 -0400", hash_original_method = "5AA72A12635065E25111537F7EBBA8DC", hash_generated_method = "CC319CB008BA01B34E33A18C24408B62")
    public Object clone() throws CloneNotSupportedException {
        BasicHttpProcessor clone = (BasicHttpProcessor) super.clone();
        copyInterceptors(clone);
Object var3DE52045BFD3C1BF3742F994ED6139AD_330046681 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_330046681.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_330046681;
        // ---------- Original Method ----------
        //BasicHttpProcessor clone = (BasicHttpProcessor) super.clone();
        //copyInterceptors(clone);
        //return clone;
    }

    
}

