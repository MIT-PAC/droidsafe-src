package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.539 -0400", hash_original_field = "64A6AD684B4F541C1BD4714BB04DE78B", hash_generated_field = "7398F9B2AE291E5D2787309DA0C28986")

    protected List requestInterceptors = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.540 -0400", hash_original_field = "620ABA3C255A8A96966418E89DEDC718", hash_generated_field = "9A978F38560CD78676894BBBC402D767")

    protected List responseInterceptors = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.540 -0400", hash_original_method = "9C379E6850D70F22993610B85EB51FC7", hash_generated_method = "9C379E6850D70F22993610B85EB51FC7")
    public BasicHttpProcessor ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.540 -0400", hash_original_method = "E1A96A9E1100F28388C805D474E7BAD5", hash_generated_method = "5729BF28575F831BE2B9EC105567DAA5")
    public void addRequestInterceptor(final HttpRequestInterceptor itcp) {
        {
            this.requestInterceptors = new ArrayList();
        } 
        this.requestInterceptors.add(itcp);
        addTaint(itcp.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.541 -0400", hash_original_method = "7082E628C139155B4DBFBA26A9DAA55A", hash_generated_method = "3FE4541B7D0716601BC1C6A85A8E9DF1")
    public void addRequestInterceptor(final HttpRequestInterceptor itcp,
                                      int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            } 
            this.requestInterceptors = new ArrayList();
        } 
        this.requestInterceptors.add(index, itcp);
        addTaint(itcp.getTaint());
        addTaint(index);
        
        
            
        
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.541 -0400", hash_original_method = "306BD5279F186A7F697194E65EEC0E22", hash_generated_method = "1BA05A81A6110334248F8EA2730485A4")
    public void addResponseInterceptor(HttpResponseInterceptor itcp,
                                       int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException(String.valueOf(index));
            } 
            this.responseInterceptors = new ArrayList();
        } 
        this.responseInterceptors.add(index, itcp);
        addTaint(itcp.getTaint());
        addTaint(index);
        
        
            
        
        
            
        
        
            
                
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.541 -0400", hash_original_method = "EFB13BD2F5F78871DC67563CE3418B82", hash_generated_method = "E286830F712664F2D795B1A7C70FE8A0")
    public void removeRequestInterceptorByClass(final Class clazz) {
        {
            Iterator it = this.requestInterceptors.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1255322438 = (it.hasNext());
            {
                Object request = it.next();
                {
                    boolean var82F0FBD1AF8CFC9AE184931728FE3420_1608542486 = (request.getClass().equals(clazz));
                    {
                        it.remove();
                    } 
                } 
            } 
        } 
        addTaint(clazz.getTaint());
        
        
            
        
        
             
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.542 -0400", hash_original_method = "DF5F226D1AE22FA4A42A4921E11EE920", hash_generated_method = "791EBC84AF4AD1C3B026434328797FBF")
    public void removeResponseInterceptorByClass(final Class clazz) {
        {
            Iterator it = this.responseInterceptors.iterator();
            boolean var03729FD53960D8DCA3A41A13A0229637_1780223486 = (it.hasNext());
            {
                Object request = it.next();
                {
                    boolean var82F0FBD1AF8CFC9AE184931728FE3420_1042980407 = (request.getClass().equals(clazz));
                    {
                        it.remove();
                    } 
                } 
            } 
        } 
        addTaint(clazz.getTaint());
        
        
            
        
        
             
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.542 -0400", hash_original_method = "49979C36D9B3AD67BC7E969CE817FBA1", hash_generated_method = "B3098BA03CA7D654AC55005C449E59B3")
    public final void addInterceptor(final HttpRequestInterceptor interceptor) {
        addRequestInterceptor(interceptor);
        addTaint(interceptor.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.542 -0400", hash_original_method = "E7AC62DE103BF676D1A944DB4C5B9066", hash_generated_method = "E13EDB853D3E84B02EA15A272D9445BE")
    public final void addInterceptor(final HttpRequestInterceptor interceptor,
                                int index) {
        addRequestInterceptor(interceptor, index);
        addTaint(interceptor.getTaint());
        addTaint(index);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.543 -0400", hash_original_method = "88BEDAF27A7611A7A46622E627DC9A63", hash_generated_method = "D93543DFC189CFB4B9497B7C451E417D")
    public int getRequestInterceptorCount() {
        {
            Object varC9BB4A0E139B0FEBD36C2866B025E728_1977764589 = (this.requestInterceptors.size());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713238555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1713238555;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.544 -0400", hash_original_method = "977729FD94F3060F22AEFDD0D34CFD7C", hash_generated_method = "2C5287435CF24A63810403C6701C7573")
    public HttpRequestInterceptor getRequestInterceptor(int index) {
        HttpRequestInterceptor varB4EAC82CA7396A68D541C85D26508E83_1395786658 = null; 
        HttpRequestInterceptor varB4EAC82CA7396A68D541C85D26508E83_1469220031 = null; 
        {
            boolean var787E3002D53A5FD2C8D54EB0004069BE_241561383 = ((this.requestInterceptors == null) ||
                (index < 0) || (index >= this.requestInterceptors.size()));
            varB4EAC82CA7396A68D541C85D26508E83_1395786658 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1469220031 = (HttpRequestInterceptor) this.requestInterceptors.get(index);
        addTaint(index);
        HttpRequestInterceptor varA7E53CE21691AB073D9660D615818899_1677395548; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1677395548 = varB4EAC82CA7396A68D541C85D26508E83_1395786658;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1677395548 = varB4EAC82CA7396A68D541C85D26508E83_1469220031;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1677395548.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1677395548;
        
        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.544 -0400", hash_original_method = "145E2FEDCA1A32FEC7370D21776649A2", hash_generated_method = "2DD9E24066548ACA81CF15355B844800")
    public void clearRequestInterceptors() {
        this.requestInterceptors = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.545 -0400", hash_original_method = "7D6C31789EA3365B9B9BD2DA3F7D37E3", hash_generated_method = "A4249BB38E8454624389E563DC774707")
    public void addResponseInterceptor(final HttpResponseInterceptor itcp) {
        {
            this.responseInterceptors = new ArrayList();
        } 
        this.responseInterceptors.add(itcp);
        addTaint(itcp.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.545 -0400", hash_original_method = "7DCB6CEE097C8760F94401368BED6C8A", hash_generated_method = "D45B0BD92EFF21D69D44B0ABAA5A6663")
    public final void addInterceptor(final HttpResponseInterceptor interceptor) {
        addResponseInterceptor(interceptor);
        addTaint(interceptor.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.546 -0400", hash_original_method = "5F99216482E6DE112B8985A77BFA25FC", hash_generated_method = "48EEFADFF4E1F167EA2F82D45D622626")
    public final void addInterceptor(final HttpResponseInterceptor interceptor,
                                     int index) {
        addResponseInterceptor(interceptor, index);
        addTaint(interceptor.getTaint());
        addTaint(index);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.546 -0400", hash_original_method = "076BC0B3D789CD5AF4622C7C18D19D27", hash_generated_method = "91E57815979B26907423029D814F161D")
    public int getResponseInterceptorCount() {
        {
            Object varDD2145D64EE81BF609D946E42BC0115C_1145026235 = (this.responseInterceptors.size());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348289934 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_348289934;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.547 -0400", hash_original_method = "745ED53DD037C2DD0D029886B0DA9F3E", hash_generated_method = "47FE016B33509EB3DB887216BA1F0AA3")
    public HttpResponseInterceptor getResponseInterceptor(int index) {
        HttpResponseInterceptor varB4EAC82CA7396A68D541C85D26508E83_740745119 = null; 
        HttpResponseInterceptor varB4EAC82CA7396A68D541C85D26508E83_526996249 = null; 
        {
            boolean var4F430D8B1FD18D0B08C9061C883BF7A0_1930701298 = ((this.responseInterceptors == null) ||
                (index < 0) || (index >= this.responseInterceptors.size()));
            varB4EAC82CA7396A68D541C85D26508E83_740745119 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_526996249 = (HttpResponseInterceptor) this.responseInterceptors.get(index);
        addTaint(index);
        HttpResponseInterceptor varA7E53CE21691AB073D9660D615818899_423973238; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_423973238 = varB4EAC82CA7396A68D541C85D26508E83_740745119;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_423973238 = varB4EAC82CA7396A68D541C85D26508E83_526996249;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_423973238.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_423973238;
        
        
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.547 -0400", hash_original_method = "312DB737544A7054D89F25FB9ECC2521", hash_generated_method = "9D3E135536DF2EF44F610851B9BC1333")
    public void clearResponseInterceptors() {
        this.responseInterceptors = null;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.547 -0400", hash_original_method = "2546A12B167929D122A18C572AD1485C", hash_generated_method = "25790765D4100E4D7A3B50A3144FEEAC")
    public void setInterceptors(final List list) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("List must not be null.");
        } 
        {
            this.requestInterceptors.clear();
        } 
        {
            this.responseInterceptors.clear();
        } 
        {
            int i = 0;
            boolean var2B834AABD5D06D0BFBC1C152A3388528_1393796649 = (i < list.size());
            {
                Object obj = list.get(i);
                {
                    addInterceptor((HttpRequestInterceptor)obj);
                } 
                {
                    addInterceptor((HttpResponseInterceptor)obj);
                } 
            } 
        } 
        addTaint(list.getTaint());
        
        
            
        
        
            
        
        
            
        
        
            
            
                
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.547 -0400", hash_original_method = "D115BE155D407C71B3079D92DD3ABF36", hash_generated_method = "BFCDBEB91DE292DDDFE071E86B5D1B74")
    public void clearInterceptors() {
        clearRequestInterceptors();
        clearResponseInterceptors();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.548 -0400", hash_original_method = "73AD1047DC7932E91E23500135DCAA1F", hash_generated_method = "7FAA82D7F4130FE3109038519B6EFFBA")
    public void process(
            final HttpRequest request,
            final HttpContext context) throws IOException, HttpException {
        {
            {
                int i = 0;
                boolean var30C3A13A5813B16653C1BB8BEDEA22EF_1663688238 = (i < this.requestInterceptors.size());
                {
                    HttpRequestInterceptor interceptor = (HttpRequestInterceptor) this.requestInterceptors.get(i);
                    interceptor.process(request, context);
                } 
            } 
        } 
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        
        
            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.548 -0400", hash_original_method = "41A094A5EA8F96220C5B29D851C7CE79", hash_generated_method = "E0B69BEC2775333166F16BB000162288")
    public void process(
            final HttpResponse response,
            final HttpContext context) throws IOException, HttpException {
        {
            {
                int i = 0;
                boolean varAFFEFE24359741647E602E772E48CD6B_950659599 = (i < this.responseInterceptors.size());
                {
                    HttpResponseInterceptor interceptor = (HttpResponseInterceptor) this.responseInterceptors.get(i);
                    interceptor.process(response, context);
                } 
            } 
        } 
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        
        
            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.549 -0400", hash_original_method = "1B68B439697A421DCA2B8CED4C47D3CE", hash_generated_method = "C61FC0BAB768F71C911CD15A002A9487")
    protected void copyInterceptors(final BasicHttpProcessor target) {
        {
            target.requestInterceptors =
                new ArrayList(this.requestInterceptors);
        } 
        {
            target.responseInterceptors =
                new ArrayList(this.responseInterceptors);
        } 
        
        
            
                
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.549 -0400", hash_original_method = "166F0C6BA2B53E84DB5B8B4516A0E908", hash_generated_method = "2544166FB05E7DD210C87228D0B08823")
    public BasicHttpProcessor copy() {
        BasicHttpProcessor varB4EAC82CA7396A68D541C85D26508E83_882033609 = null; 
        BasicHttpProcessor clone = new BasicHttpProcessor();
        copyInterceptors(clone);
        varB4EAC82CA7396A68D541C85D26508E83_882033609 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_882033609.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_882033609;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.550 -0400", hash_original_method = "5AA72A12635065E25111537F7EBBA8DC", hash_generated_method = "57B9927BC4A27954799FA7936E7466B9")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_149444383 = null; 
        BasicHttpProcessor clone = (BasicHttpProcessor) super.clone();
        copyInterceptors(clone);
        varB4EAC82CA7396A68D541C85D26508E83_149444383 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_149444383.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_149444383;
        
        
        
        
    }

    
}

