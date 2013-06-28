package org.apache.http.message;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.util.CharArrayBuffer;

public class HeaderGroup implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.348 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.349 -0400", hash_original_method = "04659297943FDC7530B5F805B712786E", hash_generated_method = "EF8745843E1EC462E93115E80BE27206")
    public  HeaderGroup() {
        this.headers = new ArrayList(16);
        // ---------- Original Method ----------
        //this.headers = new ArrayList(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.349 -0400", hash_original_method = "DD1F10463F473A3E036D58A6099CEA6B", hash_generated_method = "9DDCABDB7D36845CE4D14BEAEAFE75FD")
    public void clear() {
        headers.clear();
        // ---------- Original Method ----------
        //headers.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.349 -0400", hash_original_method = "975CD35AA91822366EBBB59081D175D2", hash_generated_method = "87514AA92489D80E6FED3CACEA7C91F7")
    public void addHeader(Header header) {
        headers.add(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.add(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.350 -0400", hash_original_method = "FC1D35A98936766B0E3F368A26829970", hash_generated_method = "0A289C1D41051BF2F46FD405A0AD3407")
    public void removeHeader(Header header) {
        headers.remove(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.remove(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.351 -0400", hash_original_method = "6490900761BA3EE42006578E9056D699", hash_generated_method = "7E06F37D2D8BB290E1001614E0894EE5")
    public void updateHeader(Header header) {
        {
            int i = 0;
            boolean var993C568E006F89931A48D273F33DE7AA_2088367447 = (i < this.headers.size());
            {
                Header current = (Header) this.headers.get(i);
                {
                    boolean var95367987BC89D548ACA7E5200A55278A_748292766 = (current.getName().equalsIgnoreCase(header.getName()));
                    {
                        this.headers.set(i, header);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        this.headers.add(header);
        addTaint(header.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.352 -0400", hash_original_method = "21A092A9E4BD805516734B366EB966A8", hash_generated_method = "8FAE3E5AF94BC3D27B6034A4F79B3852")
    public void setHeaders(Header[] headers) {
        clear();
        {
            int i = 0;
            {
                this.headers.add(headers[i]);
            } //End block
        } //End collapsed parenthetic
        addTaint(headers[0].getTaint());
        // ---------- Original Method ----------
        //clear();
        //if (headers == null) {
            //return;
        //}
        //for (int i = 0; i < headers.length; i++) {
            //this.headers.add(headers[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.357 -0400", hash_original_method = "401EFCB61975E058185EEB3D46A8D6DB", hash_generated_method = "9B007C645C3937B11F92D1DDE75153CD")
    public Header getCondensedHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_1673543363 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1374789869 = null; //Variable for return #2
        Header varB4EAC82CA7396A68D541C85D26508E83_508513578 = null; //Variable for return #3
        Header[] headers = getHeaders(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1673543363 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1374789869 = headers[0];
        } //End block
        {
            CharArrayBuffer valueBuffer = new CharArrayBuffer(128);
            valueBuffer.append(headers[0].getValue());
            {
                int i = 1;
                {
                    valueBuffer.append(", ");
                    valueBuffer.append(headers[i].getValue());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_508513578 = new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
        } //End block
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_628718958; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_628718958 = varB4EAC82CA7396A68D541C85D26508E83_1673543363;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_628718958 = varB4EAC82CA7396A68D541C85D26508E83_1374789869;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_628718958 = varB4EAC82CA7396A68D541C85D26508E83_508513578;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_628718958.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_628718958;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.359 -0400", hash_original_method = "C3B2FF3CCB5B189FEFC22CBF4687F83D", hash_generated_method = "D672C0738EEF35624E8FEC52B8055441")
    public Header[] getHeaders(String name) {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_304890606 = null; //Variable for return #1
        ArrayList headersFound = new ArrayList();
        {
            int i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_618893288 = (i < headers.size());
            {
                Header header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_998314466 = (header.getName().equalsIgnoreCase(name));
                    {
                        headersFound.add(header);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_304890606 = (Header[]) headersFound.toArray(new Header[headersFound.size()]);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_304890606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_304890606;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.360 -0400", hash_original_method = "1B5D001D749637B235D3368FA2C6DC92", hash_generated_method = "0CC322579D1F6F66881D6FF142218A6B")
    public Header getFirstHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_792373787 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1956871755 = null; //Variable for return #2
        {
            int i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_391300261 = (i < headers.size());
            {
                Header header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_1815001906 = (header.getName().equalsIgnoreCase(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_792373787 = header;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1956871755 = null;
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_1280523828; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1280523828 = varB4EAC82CA7396A68D541C85D26508E83_792373787;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1280523828 = varB4EAC82CA7396A68D541C85D26508E83_1956871755;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1280523828.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1280523828;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.361 -0400", hash_original_method = "F097824BB9F324FCD125DCECBE8EB60F", hash_generated_method = "CE1FCD7E8506117D97515B51D02FFBEB")
    public Header getLastHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_503181251 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_479604901 = null; //Variable for return #2
        {
            int i = headers.size() - 1;
            {
                Header header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_182624153 = (header.getName().equalsIgnoreCase(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_503181251 = header;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_479604901 = null;
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_1427931076; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1427931076 = varB4EAC82CA7396A68D541C85D26508E83_503181251;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1427931076 = varB4EAC82CA7396A68D541C85D26508E83_479604901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1427931076.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1427931076;
        // ---------- Original Method ----------
        //for (int i = headers.size() - 1; i >= 0; i--) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}            
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.362 -0400", hash_original_method = "51A146DC1B834742F5A648A6C7C2FBE7", hash_generated_method = "60060C74450F5BC9138DB34C92CA1E6A")
    public Header[] getAllHeaders() {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_1497023482 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1497023482 = (Header[]) headers.toArray(new Header[headers.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1497023482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1497023482;
        // ---------- Original Method ----------
        //return (Header[]) headers.toArray(new Header[headers.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.362 -0400", hash_original_method = "8F463ADE51DCD8AE5187274242206DA5", hash_generated_method = "5DDA9B7DEF72DCF4CC3ADC2ACC19BDCF")
    public boolean containsHeader(String name) {
        {
            int i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_1649624777 = (i < headers.size());
            {
                Header header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_1672915509 = (header.getName().equalsIgnoreCase(name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1888421378 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1888421378;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.363 -0400", hash_original_method = "216CA9BCEE6B2216E69E554CBCCBB21C", hash_generated_method = "14348E45548479C8D926E6C70D20192E")
    public HeaderIterator iterator() {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_204739080 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_204739080 = new BasicListHeaderIterator(this.headers, null);
        varB4EAC82CA7396A68D541C85D26508E83_204739080.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_204739080;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.364 -0400", hash_original_method = "DFA4A10C9A5AF888C1AA8746F1A85305", hash_generated_method = "6530328B9A9547548ACB6342768A1D65")
    public HeaderIterator iterator(final String name) {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_1779202835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1779202835 = new BasicListHeaderIterator(this.headers, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1779202835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1779202835;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.365 -0400", hash_original_method = "5B227975880483464D857E333DC9323C", hash_generated_method = "588616E5AAC31FE34A04CD2EBA459CCF")
    public HeaderGroup copy() {
        HeaderGroup varB4EAC82CA7396A68D541C85D26508E83_1730669205 = null; //Variable for return #1
        HeaderGroup clone = new HeaderGroup();
        clone.headers.addAll(this.headers);
        varB4EAC82CA7396A68D541C85D26508E83_1730669205 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1730669205.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1730669205;
        // ---------- Original Method ----------
        //HeaderGroup clone = new HeaderGroup();
        //clone.headers.addAll(this.headers);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.366 -0400", hash_original_method = "A187915CF1AFFDE7143E028BA9E9F5A2", hash_generated_method = "76F482888910E7B0BA5A475372ED5BFB")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_168313326 = null; //Variable for return #1
        HeaderGroup clone = (HeaderGroup) super.clone();
        clone.headers = new ArrayList(this.headers);
        varB4EAC82CA7396A68D541C85D26508E83_168313326 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_168313326.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_168313326;
        // ---------- Original Method ----------
        //HeaderGroup clone = (HeaderGroup) super.clone();
        //clone.headers = new ArrayList(this.headers);
        //return clone;
    }

    
}

