package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;




public class HeaderGroup implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.122 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.122 -0400", hash_original_method = "04659297943FDC7530B5F805B712786E", hash_generated_method = "EF8745843E1EC462E93115E80BE27206")
    public  HeaderGroup() {
        this.headers = new ArrayList(16);
        // ---------- Original Method ----------
        //this.headers = new ArrayList(16);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.123 -0400", hash_original_method = "DD1F10463F473A3E036D58A6099CEA6B", hash_generated_method = "9DDCABDB7D36845CE4D14BEAEAFE75FD")
    public void clear() {
        headers.clear();
        // ---------- Original Method ----------
        //headers.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.123 -0400", hash_original_method = "975CD35AA91822366EBBB59081D175D2", hash_generated_method = "0544C972D890A164B9839DD3EB542E77")
    public void addHeader(Header header) {
        addTaint(header.getTaint());
        if(header == null)        
        {
            return;
        } //End block
        headers.add(header);
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.add(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.123 -0400", hash_original_method = "FC1D35A98936766B0E3F368A26829970", hash_generated_method = "4B0957B1C54E4A83C2C732D130374CFB")
    public void removeHeader(Header header) {
        addTaint(header.getTaint());
        if(header == null)        
        {
            return;
        } //End block
        headers.remove(header);
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.remove(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.124 -0400", hash_original_method = "6490900761BA3EE42006578E9056D699", hash_generated_method = "219957827987C4001F9BFD3F09EB677C")
    public void updateHeader(Header header) {
        addTaint(header.getTaint());
        if(header == null)        
        {
            return;
        } //End block
for(int i = 0;i < this.headers.size();i++)
        {
            Header current = (Header) this.headers.get(i);
            if(current.getName().equalsIgnoreCase(header.getName()))            
            {
                this.headers.set(i, header);
                return;
            } //End block
        } //End block
        this.headers.add(header);
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //for (int i = 0; i < this.headers.size(); i++) {
            //Header current = (Header) this.headers.get(i);
            //if (current.getName().equalsIgnoreCase(header.getName())) {
                //this.headers.set(i, header);
                //return;
            //}
        //}
        //this.headers.add(header);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.125 -0400", hash_original_method = "21A092A9E4BD805516734B366EB966A8", hash_generated_method = "2E8385DFB46D1B39BD0FC89665461621")
    public void setHeaders(Header[] headers) {
        addTaint(headers[0].getTaint());
        clear();
        if(headers == null)        
        {
            return;
        } //End block
for(int i = 0;i < headers.length;i++)
        {
            this.headers.add(headers[i]);
        } //End block
        // ---------- Original Method ----------
        //clear();
        //if (headers == null) {
            //return;
        //}
        //for (int i = 0; i < headers.length; i++) {
            //this.headers.add(headers[i]);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.125 -0400", hash_original_method = "401EFCB61975E058185EEB3D46A8D6DB", hash_generated_method = "83AC3097FC072765B017CC297AB84F1C")
    public Header getCondensedHeader(String name) {
        addTaint(name.getTaint());
        Header[] headers = getHeaders(name);
        if(headers.length == 0)        
        {
Header var540C13E9E156B687226421B24F2DF178_1813974469 =             null;
            var540C13E9E156B687226421B24F2DF178_1813974469.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1813974469;
        } //End block
        else
        if(headers.length == 1)        
        {
Header var622D39B107FBA981AB2B306E352C2392_1764572787 =             headers[0];
            var622D39B107FBA981AB2B306E352C2392_1764572787.addTaint(taint);
            return var622D39B107FBA981AB2B306E352C2392_1764572787;
        } //End block
        else
        {
            CharArrayBuffer valueBuffer = new CharArrayBuffer(128);
            valueBuffer.append(headers[0].getValue());
for(int i = 1;i < headers.length;i++)
            {
                valueBuffer.append(", ");
                valueBuffer.append(headers[i].getValue());
            } //End block
Header var9D89503D2589DD41795CD030E6EE24C1_1794632938 =             new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
            var9D89503D2589DD41795CD030E6EE24C1_1794632938.addTaint(taint);
            return var9D89503D2589DD41795CD030E6EE24C1_1794632938;
        } //End block
        // ---------- Original Method ----------
        //Header[] headers = getHeaders(name);
        //if (headers.length == 0) {
            //return null;   
        //} else if (headers.length == 1) {
            //return headers[0];
        //} else {
            //CharArrayBuffer valueBuffer = new CharArrayBuffer(128);
            //valueBuffer.append(headers[0].getValue());
            //for (int i = 1; i < headers.length; i++) {
                //valueBuffer.append(", ");
                //valueBuffer.append(headers[i].getValue());
            //}
            //return new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.126 -0400", hash_original_method = "C3B2FF3CCB5B189FEFC22CBF4687F83D", hash_generated_method = "347025236D188C488A3E0FD305A694D2")
    public Header[] getHeaders(String name) {
        addTaint(name.getTaint());
        ArrayList headersFound = new ArrayList();
for(int i = 0;i < headers.size();i++)
        {
            Header header = (Header) headers.get(i);
            if(header.getName().equalsIgnoreCase(name))            
            {
                headersFound.add(header);
            } //End block
        } //End block
Header[] var01B2D19A9EC93F41FCE14F3ECF13509B_242661418 =         (Header[]) headersFound.toArray(new Header[headersFound.size()]);
        var01B2D19A9EC93F41FCE14F3ECF13509B_242661418.addTaint(taint);
        return var01B2D19A9EC93F41FCE14F3ECF13509B_242661418;
        // ---------- Original Method ----------
        //ArrayList headersFound = new ArrayList();
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //headersFound.add(header);
            //}
        //}
        //return (Header[]) headersFound.toArray(new Header[headersFound.size()]);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.126 -0400", hash_original_method = "1B5D001D749637B235D3368FA2C6DC92", hash_generated_method = "E84D6EE4AAFE1E2F2F0C0DAFCA9E67F0")
    public Header getFirstHeader(String name) {
        addTaint(name.getTaint());
for(int i = 0;i < headers.size();i++)
        {
            Header header = (Header) headers.get(i);
            if(header.getName().equalsIgnoreCase(name))            
            {
Header var108E3DF16511A75B853B5BA5497143AD_1560683469 =                 header;
                var108E3DF16511A75B853B5BA5497143AD_1560683469.addTaint(taint);
                return var108E3DF16511A75B853B5BA5497143AD_1560683469;
            } //End block
        } //End block
Header var540C13E9E156B687226421B24F2DF178_1599916538 =         null;
        var540C13E9E156B687226421B24F2DF178_1599916538.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1599916538;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}
        //}
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.127 -0400", hash_original_method = "F097824BB9F324FCD125DCECBE8EB60F", hash_generated_method = "8428980E180698D092C65252C6D7B33F")
    public Header getLastHeader(String name) {
        addTaint(name.getTaint());
for(int i = headers.size() - 1;i >= 0;i--)
        {
            Header header = (Header) headers.get(i);
            if(header.getName().equalsIgnoreCase(name))            
            {
Header var108E3DF16511A75B853B5BA5497143AD_1200845305 =                 header;
                var108E3DF16511A75B853B5BA5497143AD_1200845305.addTaint(taint);
                return var108E3DF16511A75B853B5BA5497143AD_1200845305;
            } //End block
        } //End block
Header var540C13E9E156B687226421B24F2DF178_2082080941 =         null;
        var540C13E9E156B687226421B24F2DF178_2082080941.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2082080941;
        // ---------- Original Method ----------
        //for (int i = headers.size() - 1; i >= 0; i--) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}            
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.127 -0400", hash_original_method = "51A146DC1B834742F5A648A6C7C2FBE7", hash_generated_method = "FBD6F853494928DD3F403D07BA32C6AF")
    public Header[] getAllHeaders() {
Header[] var31F9662A3F18835AF66E4DC1AE1B3E24_1413389393 =         (Header[]) headers.toArray(new Header[headers.size()]);
        var31F9662A3F18835AF66E4DC1AE1B3E24_1413389393.addTaint(taint);
        return var31F9662A3F18835AF66E4DC1AE1B3E24_1413389393;
        // ---------- Original Method ----------
        //return (Header[]) headers.toArray(new Header[headers.size()]);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.128 -0400", hash_original_method = "8F463ADE51DCD8AE5187274242206DA5", hash_generated_method = "222000D36AB181D5FC652BDE2926E9A4")
    public boolean containsHeader(String name) {
        addTaint(name.getTaint());
for(int i = 0;i < headers.size();i++)
        {
            Header header = (Header) headers.get(i);
            if(header.getName().equalsIgnoreCase(name))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1354007987 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_298656694 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_298656694;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1694165391 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_844469222 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_844469222;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.128 -0400", hash_original_method = "216CA9BCEE6B2216E69E554CBCCBB21C", hash_generated_method = "DF1852F998F6491790F9BDCEDCE5A8C8")
    public HeaderIterator iterator() {
HeaderIterator var78733DC078B20A3D11B9F03D1F78A2FB_1399433087 =         new BasicListHeaderIterator(this.headers, null);
        var78733DC078B20A3D11B9F03D1F78A2FB_1399433087.addTaint(taint);
        return var78733DC078B20A3D11B9F03D1F78A2FB_1399433087;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.129 -0400", hash_original_method = "DFA4A10C9A5AF888C1AA8746F1A85305", hash_generated_method = "1D1CB462AEDC557161A62B007D137948")
    public HeaderIterator iterator(final String name) {
        addTaint(name.getTaint());
HeaderIterator var246929CBF15E031415C5465B8F5BE4B4_1770318005 =         new BasicListHeaderIterator(this.headers, name);
        var246929CBF15E031415C5465B8F5BE4B4_1770318005.addTaint(taint);
        return var246929CBF15E031415C5465B8F5BE4B4_1770318005;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.129 -0400", hash_original_method = "5B227975880483464D857E333DC9323C", hash_generated_method = "74C37B1746EB4B188E4A0DEB9A96D96B")
    public HeaderGroup copy() {
        HeaderGroup clone = new HeaderGroup();
        clone.headers.addAll(this.headers);
HeaderGroup var3DE52045BFD3C1BF3742F994ED6139AD_1946952611 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1946952611.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1946952611;
        // ---------- Original Method ----------
        //HeaderGroup clone = new HeaderGroup();
        //clone.headers.addAll(this.headers);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.129 -0400", hash_original_method = "A187915CF1AFFDE7143E028BA9E9F5A2", hash_generated_method = "607B769646DBBF7372F582A303A4C16C")
    public Object clone() throws CloneNotSupportedException {
        HeaderGroup clone = (HeaderGroup) super.clone();
        clone.headers = new ArrayList(this.headers);
Object var3DE52045BFD3C1BF3742F994ED6139AD_2048756121 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_2048756121.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_2048756121;
        // ---------- Original Method ----------
        //HeaderGroup clone = (HeaderGroup) super.clone();
        //clone.headers = new ArrayList(this.headers);
        //return clone;
    }

    
}

