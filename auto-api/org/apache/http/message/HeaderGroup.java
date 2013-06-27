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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.149 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.158 -0400", hash_original_method = "04659297943FDC7530B5F805B712786E", hash_generated_method = "EF8745843E1EC462E93115E80BE27206")
    public  HeaderGroup() {
        this.headers = new ArrayList(16);
        // ---------- Original Method ----------
        //this.headers = new ArrayList(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.162 -0400", hash_original_method = "DD1F10463F473A3E036D58A6099CEA6B", hash_generated_method = "9DDCABDB7D36845CE4D14BEAEAFE75FD")
    public void clear() {
        headers.clear();
        // ---------- Original Method ----------
        //headers.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.162 -0400", hash_original_method = "975CD35AA91822366EBBB59081D175D2", hash_generated_method = "87514AA92489D80E6FED3CACEA7C91F7")
    public void addHeader(Header header) {
        headers.add(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.add(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.162 -0400", hash_original_method = "FC1D35A98936766B0E3F368A26829970", hash_generated_method = "0A289C1D41051BF2F46FD405A0AD3407")
    public void removeHeader(Header header) {
        headers.remove(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.remove(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.164 -0400", hash_original_method = "6490900761BA3EE42006578E9056D699", hash_generated_method = "C93E4BE51D12F3ADA40C8A0464A62027")
    public void updateHeader(Header header) {
        {
            int i;
            i = 0;
            boolean var993C568E006F89931A48D273F33DE7AA_1784264802 = (i < this.headers.size());
            {
                Header current;
                current = (Header) this.headers.get(i);
                {
                    boolean var95367987BC89D548ACA7E5200A55278A_189145759 = (current.getName().equalsIgnoreCase(header.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.164 -0400", hash_original_method = "21A092A9E4BD805516734B366EB966A8", hash_generated_method = "9E2D57369552BAD5F529DC2BCD1CEF1D")
    public void setHeaders(Header[] headers) {
        clear();
        {
            int i;
            i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.172 -0400", hash_original_method = "401EFCB61975E058185EEB3D46A8D6DB", hash_generated_method = "0C3AEBD69A1E3A65858420774F2DE2F2")
    public Header getCondensedHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_1630913842 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_684724698 = null; //Variable for return #2
        Header varB4EAC82CA7396A68D541C85D26508E83_165628281 = null; //Variable for return #3
        Header[] headers;
        headers = getHeaders(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1630913842 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_684724698 = headers[0];
        } //End block
        {
            CharArrayBuffer valueBuffer;
            valueBuffer = new CharArrayBuffer(128);
            valueBuffer.append(headers[0].getValue());
            {
                int i;
                i = 1;
                {
                    valueBuffer.append(", ");
                    valueBuffer.append(headers[i].getValue());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_165628281 = new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
        } //End block
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_1928475600; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1928475600 = varB4EAC82CA7396A68D541C85D26508E83_1630913842;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1928475600 = varB4EAC82CA7396A68D541C85D26508E83_684724698;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1928475600 = varB4EAC82CA7396A68D541C85D26508E83_165628281;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1928475600.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1928475600;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.173 -0400", hash_original_method = "C3B2FF3CCB5B189FEFC22CBF4687F83D", hash_generated_method = "D4C30DEDA9BBBCBAE35EE5BAFE0D9889")
    public Header[] getHeaders(String name) {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_1129399728 = null; //Variable for return #1
        ArrayList headersFound;
        headersFound = new ArrayList();
        {
            int i;
            i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_491746384 = (i < headers.size());
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_1311048766 = (header.getName().equalsIgnoreCase(name));
                    {
                        headersFound.add(header);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1129399728 = (Header[]) headersFound.toArray(new Header[headersFound.size()]);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1129399728.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1129399728;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.186 -0400", hash_original_method = "1B5D001D749637B235D3368FA2C6DC92", hash_generated_method = "3C8B7585C79669AF2FF09EE614AFD8CC")
    public Header getFirstHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_920096506 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1045166035 = null; //Variable for return #2
        {
            int i;
            i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_1663435049 = (i < headers.size());
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_314587894 = (header.getName().equalsIgnoreCase(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_920096506 = header;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1045166035 = null;
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_1594466348; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1594466348 = varB4EAC82CA7396A68D541C85D26508E83_920096506;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1594466348 = varB4EAC82CA7396A68D541C85D26508E83_1045166035;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1594466348.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1594466348;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.188 -0400", hash_original_method = "F097824BB9F324FCD125DCECBE8EB60F", hash_generated_method = "FEEB24B76C42F4644526654B5E6F730F")
    public Header getLastHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_217408479 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1542700131 = null; //Variable for return #2
        {
            int i;
            i = headers.size() - 1;
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_32392417 = (header.getName().equalsIgnoreCase(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_217408479 = header;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1542700131 = null;
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_456650404; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_456650404 = varB4EAC82CA7396A68D541C85D26508E83_217408479;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_456650404 = varB4EAC82CA7396A68D541C85D26508E83_1542700131;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_456650404.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_456650404;
        // ---------- Original Method ----------
        //for (int i = headers.size() - 1; i >= 0; i--) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}            
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.205 -0400", hash_original_method = "51A146DC1B834742F5A648A6C7C2FBE7", hash_generated_method = "9C93576C6212D0A887C6663650CDAFF7")
    public Header[] getAllHeaders() {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_1482567474 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1482567474 = (Header[]) headers.toArray(new Header[headers.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1482567474.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1482567474;
        // ---------- Original Method ----------
        //return (Header[]) headers.toArray(new Header[headers.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.205 -0400", hash_original_method = "8F463ADE51DCD8AE5187274242206DA5", hash_generated_method = "B2D4CBEEBD7A0C111394E1E2B6F0DA38")
    public boolean containsHeader(String name) {
        {
            int i;
            i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_2145576649 = (i < headers.size());
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_956202633 = (header.getName().equalsIgnoreCase(name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_935747542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_935747542;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.206 -0400", hash_original_method = "216CA9BCEE6B2216E69E554CBCCBB21C", hash_generated_method = "77A9EE3AB1F11A8DFB0F55BE350A37AA")
    public HeaderIterator iterator() {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_29953186 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_29953186 = new BasicListHeaderIterator(this.headers, null);
        varB4EAC82CA7396A68D541C85D26508E83_29953186.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29953186;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.206 -0400", hash_original_method = "DFA4A10C9A5AF888C1AA8746F1A85305", hash_generated_method = "DBB44556B1ACD164FE1D2EDEBC9A4C25")
    public HeaderIterator iterator(final String name) {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_2046617865 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2046617865 = new BasicListHeaderIterator(this.headers, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2046617865.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2046617865;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.207 -0400", hash_original_method = "5B227975880483464D857E333DC9323C", hash_generated_method = "81845191D3C503EC58F115B30A79EF48")
    public HeaderGroup copy() {
        HeaderGroup varB4EAC82CA7396A68D541C85D26508E83_336916888 = null; //Variable for return #1
        HeaderGroup clone;
        clone = new HeaderGroup();
        clone.headers.addAll(this.headers);
        varB4EAC82CA7396A68D541C85D26508E83_336916888 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_336916888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_336916888;
        // ---------- Original Method ----------
        //HeaderGroup clone = new HeaderGroup();
        //clone.headers.addAll(this.headers);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.218 -0400", hash_original_method = "A187915CF1AFFDE7143E028BA9E9F5A2", hash_generated_method = "E58C6001DB54DC1D1E33EC8C75045B8A")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_466890684 = null; //Variable for return #1
        HeaderGroup clone;
        clone = (HeaderGroup) super.clone();
        clone.headers = new ArrayList(this.headers);
        varB4EAC82CA7396A68D541C85D26508E83_466890684 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_466890684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_466890684;
        // ---------- Original Method ----------
        //HeaderGroup clone = (HeaderGroup) super.clone();
        //clone.headers = new ArrayList(this.headers);
        //return clone;
    }

    
}

