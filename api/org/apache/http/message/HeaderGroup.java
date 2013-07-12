package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

public class HeaderGroup implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.738 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.739 -0400", hash_original_method = "04659297943FDC7530B5F805B712786E", hash_generated_method = "EF8745843E1EC462E93115E80BE27206")
    public  HeaderGroup() {
        this.headers = new ArrayList(16);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.739 -0400", hash_original_method = "DD1F10463F473A3E036D58A6099CEA6B", hash_generated_method = "9DDCABDB7D36845CE4D14BEAEAFE75FD")
    public void clear() {
        headers.clear();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.739 -0400", hash_original_method = "975CD35AA91822366EBBB59081D175D2", hash_generated_method = "0544C972D890A164B9839DD3EB542E77")
    public void addHeader(Header header) {
        addTaint(header.getTaint());
    if(header == null)        
        {
            return;
        } 
        headers.add(header);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.739 -0400", hash_original_method = "FC1D35A98936766B0E3F368A26829970", hash_generated_method = "4B0957B1C54E4A83C2C732D130374CFB")
    public void removeHeader(Header header) {
        addTaint(header.getTaint());
    if(header == null)        
        {
            return;
        } 
        headers.remove(header);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.740 -0400", hash_original_method = "6490900761BA3EE42006578E9056D699", hash_generated_method = "219957827987C4001F9BFD3F09EB677C")
    public void updateHeader(Header header) {
        addTaint(header.getTaint());
    if(header == null)        
        {
            return;
        } 
for(int i = 0;i < this.headers.size();i++)
        {
            Header current = (Header) this.headers.get(i);
    if(current.getName().equalsIgnoreCase(header.getName()))            
            {
                this.headers.set(i, header);
                return;
            } 
        } 
        this.headers.add(header);
        
        
            
        
        
            
            
                
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.740 -0400", hash_original_method = "21A092A9E4BD805516734B366EB966A8", hash_generated_method = "2E8385DFB46D1B39BD0FC89665461621")
    public void setHeaders(Header[] headers) {
        addTaint(headers[0].getTaint());
        clear();
    if(headers == null)        
        {
            return;
        } 
for(int i = 0;i < headers.length;i++)
        {
            this.headers.add(headers[i]);
        } 
        
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.741 -0400", hash_original_method = "401EFCB61975E058185EEB3D46A8D6DB", hash_generated_method = "213B758143EE651EB3B357BA1ADA86D3")
    public Header getCondensedHeader(String name) {
        addTaint(name.getTaint());
        Header[] headers = getHeaders(name);
    if(headers.length == 0)        
        {
Header var540C13E9E156B687226421B24F2DF178_597285079 =             null;
            var540C13E9E156B687226421B24F2DF178_597285079.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_597285079;
        } 
        else
    if(headers.length == 1)        
        {
Header var622D39B107FBA981AB2B306E352C2392_373571504 =             headers[0];
            var622D39B107FBA981AB2B306E352C2392_373571504.addTaint(taint);
            return var622D39B107FBA981AB2B306E352C2392_373571504;
        } 
        else
        {
            CharArrayBuffer valueBuffer = new CharArrayBuffer(128);
            valueBuffer.append(headers[0].getValue());
for(int i = 1;i < headers.length;i++)
            {
                valueBuffer.append(", ");
                valueBuffer.append(headers[i].getValue());
            } 
Header var9D89503D2589DD41795CD030E6EE24C1_1450821440 =             new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
            var9D89503D2589DD41795CD030E6EE24C1_1450821440.addTaint(taint);
            return var9D89503D2589DD41795CD030E6EE24C1_1450821440;
        } 
        
        
        
            
        
            
        
            
            
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.742 -0400", hash_original_method = "C3B2FF3CCB5B189FEFC22CBF4687F83D", hash_generated_method = "5ABB7E093EE7A7983CD3AEBEE0E94B44")
    public Header[] getHeaders(String name) {
        addTaint(name.getTaint());
        ArrayList headersFound = new ArrayList();
for(int i = 0;i < headers.size();i++)
        {
            Header header = (Header) headers.get(i);
    if(header.getName().equalsIgnoreCase(name))            
            {
                headersFound.add(header);
            } 
        } 
Header[] var01B2D19A9EC93F41FCE14F3ECF13509B_454531393 =         (Header[]) headersFound.toArray(new Header[headersFound.size()]);
        var01B2D19A9EC93F41FCE14F3ECF13509B_454531393.addTaint(taint);
        return var01B2D19A9EC93F41FCE14F3ECF13509B_454531393;
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.742 -0400", hash_original_method = "1B5D001D749637B235D3368FA2C6DC92", hash_generated_method = "0CC5015CA36D04DC1341629A0B90851B")
    public Header getFirstHeader(String name) {
        addTaint(name.getTaint());
for(int i = 0;i < headers.size();i++)
        {
            Header header = (Header) headers.get(i);
    if(header.getName().equalsIgnoreCase(name))            
            {
Header var108E3DF16511A75B853B5BA5497143AD_2071179419 =                 header;
                var108E3DF16511A75B853B5BA5497143AD_2071179419.addTaint(taint);
                return var108E3DF16511A75B853B5BA5497143AD_2071179419;
            } 
        } 
Header var540C13E9E156B687226421B24F2DF178_9925462 =         null;
        var540C13E9E156B687226421B24F2DF178_9925462.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_9925462;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.743 -0400", hash_original_method = "F097824BB9F324FCD125DCECBE8EB60F", hash_generated_method = "24E3C9521783381BF8B5A1F08EB1696C")
    public Header getLastHeader(String name) {
        addTaint(name.getTaint());
for(int i = headers.size() - 1;i >= 0;i--)
        {
            Header header = (Header) headers.get(i);
    if(header.getName().equalsIgnoreCase(name))            
            {
Header var108E3DF16511A75B853B5BA5497143AD_1070907535 =                 header;
                var108E3DF16511A75B853B5BA5497143AD_1070907535.addTaint(taint);
                return var108E3DF16511A75B853B5BA5497143AD_1070907535;
            } 
        } 
Header var540C13E9E156B687226421B24F2DF178_823312534 =         null;
        var540C13E9E156B687226421B24F2DF178_823312534.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_823312534;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.744 -0400", hash_original_method = "51A146DC1B834742F5A648A6C7C2FBE7", hash_generated_method = "38681EF9B9D5789821C9A3B236E48195")
    public Header[] getAllHeaders() {
Header[] var31F9662A3F18835AF66E4DC1AE1B3E24_156864744 =         (Header[]) headers.toArray(new Header[headers.size()]);
        var31F9662A3F18835AF66E4DC1AE1B3E24_156864744.addTaint(taint);
        return var31F9662A3F18835AF66E4DC1AE1B3E24_156864744;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.744 -0400", hash_original_method = "8F463ADE51DCD8AE5187274242206DA5", hash_generated_method = "EDCBB1543BB203554E1799E43EFFA785")
    public boolean containsHeader(String name) {
        addTaint(name.getTaint());
for(int i = 0;i < headers.size();i++)
        {
            Header header = (Header) headers.get(i);
    if(header.getName().equalsIgnoreCase(name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_317329047 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1222483500 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1222483500;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_848176866 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1134179167 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1134179167;
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.745 -0400", hash_original_method = "216CA9BCEE6B2216E69E554CBCCBB21C", hash_generated_method = "6E1CAF8BBC28C4176E569929727597D3")
    public HeaderIterator iterator() {
HeaderIterator var78733DC078B20A3D11B9F03D1F78A2FB_747055776 =         new BasicListHeaderIterator(this.headers, null);
        var78733DC078B20A3D11B9F03D1F78A2FB_747055776.addTaint(taint);
        return var78733DC078B20A3D11B9F03D1F78A2FB_747055776;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.745 -0400", hash_original_method = "DFA4A10C9A5AF888C1AA8746F1A85305", hash_generated_method = "5584D699606382FF8ECA9C3DA2211D6B")
    public HeaderIterator iterator(final String name) {
        addTaint(name.getTaint());
HeaderIterator var246929CBF15E031415C5465B8F5BE4B4_523111504 =         new BasicListHeaderIterator(this.headers, name);
        var246929CBF15E031415C5465B8F5BE4B4_523111504.addTaint(taint);
        return var246929CBF15E031415C5465B8F5BE4B4_523111504;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.745 -0400", hash_original_method = "5B227975880483464D857E333DC9323C", hash_generated_method = "1036F419E567C1A09636EAD29BF4A943")
    public HeaderGroup copy() {
        HeaderGroup clone = new HeaderGroup();
        clone.headers.addAll(this.headers);
HeaderGroup var3DE52045BFD3C1BF3742F994ED6139AD_755254107 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_755254107.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_755254107;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.746 -0400", hash_original_method = "A187915CF1AFFDE7143E028BA9E9F5A2", hash_generated_method = "AEEFB47E754C842EAE48D5C2361C6203")
    public Object clone() throws CloneNotSupportedException {
        HeaderGroup clone = (HeaderGroup) super.clone();
        clone.headers = new ArrayList(this.headers);
Object var3DE52045BFD3C1BF3742F994ED6139AD_774754164 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_774754164.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_774754164;
        
        
        
        
    }

    
}

