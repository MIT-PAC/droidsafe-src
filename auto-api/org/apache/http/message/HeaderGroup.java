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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.321 -0400", hash_original_field = "4340FD73E75DF7A9D9E45902A59BA3A4", hash_generated_field = "144EBE63A318E4E8C50ABA547D9431E1")

    private List headers;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.331 -0400", hash_original_method = "04659297943FDC7530B5F805B712786E", hash_generated_method = "EF8745843E1EC462E93115E80BE27206")
    public  HeaderGroup() {
        this.headers = new ArrayList(16);
        // ---------- Original Method ----------
        //this.headers = new ArrayList(16);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.332 -0400", hash_original_method = "DD1F10463F473A3E036D58A6099CEA6B", hash_generated_method = "9DDCABDB7D36845CE4D14BEAEAFE75FD")
    public void clear() {
        headers.clear();
        // ---------- Original Method ----------
        //headers.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.332 -0400", hash_original_method = "975CD35AA91822366EBBB59081D175D2", hash_generated_method = "87514AA92489D80E6FED3CACEA7C91F7")
    public void addHeader(Header header) {
        headers.add(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.add(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.334 -0400", hash_original_method = "FC1D35A98936766B0E3F368A26829970", hash_generated_method = "0A289C1D41051BF2F46FD405A0AD3407")
    public void removeHeader(Header header) {
        headers.remove(header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //if (header == null) {
            //return;
        //}
        //headers.remove(header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.345 -0400", hash_original_method = "6490900761BA3EE42006578E9056D699", hash_generated_method = "5B4D3AB39E23491190F03F415057521C")
    public void updateHeader(Header header) {
        {
            int i;
            i = 0;
            boolean var993C568E006F89931A48D273F33DE7AA_635834548 = (i < this.headers.size());
            {
                Header current;
                current = (Header) this.headers.get(i);
                {
                    boolean var95367987BC89D548ACA7E5200A55278A_1393411377 = (current.getName().equalsIgnoreCase(header.getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.347 -0400", hash_original_method = "21A092A9E4BD805516734B366EB966A8", hash_generated_method = "9E2D57369552BAD5F529DC2BCD1CEF1D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.348 -0400", hash_original_method = "401EFCB61975E058185EEB3D46A8D6DB", hash_generated_method = "EE0F6310979AA209A138BA1F0AB54F29")
    public Header getCondensedHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_438851640 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1094678844 = null; //Variable for return #2
        Header varB4EAC82CA7396A68D541C85D26508E83_1414061002 = null; //Variable for return #3
        Header[] headers;
        headers = getHeaders(name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_438851640 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1094678844 = headers[0];
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
            varB4EAC82CA7396A68D541C85D26508E83_1414061002 = new BasicHeader(name.toLowerCase(Locale.ENGLISH), valueBuffer.toString());
        } //End block
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_69775530; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_69775530 = varB4EAC82CA7396A68D541C85D26508E83_438851640;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_69775530 = varB4EAC82CA7396A68D541C85D26508E83_1094678844;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_69775530 = varB4EAC82CA7396A68D541C85D26508E83_1414061002;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_69775530.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_69775530;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.349 -0400", hash_original_method = "C3B2FF3CCB5B189FEFC22CBF4687F83D", hash_generated_method = "169DBC75B9992D8926FC746612614940")
    public Header[] getHeaders(String name) {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_830420451 = null; //Variable for return #1
        ArrayList headersFound;
        headersFound = new ArrayList();
        {
            int i;
            i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_1206563017 = (i < headers.size());
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_1314531066 = (header.getName().equalsIgnoreCase(name));
                    {
                        headersFound.add(header);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_830420451 = (Header[]) headersFound.toArray(new Header[headersFound.size()]);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_830420451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_830420451;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.350 -0400", hash_original_method = "1B5D001D749637B235D3368FA2C6DC92", hash_generated_method = "E2BB558BEF41772FA2480B350B2ABE4B")
    public Header getFirstHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_39738088 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_178275251 = null; //Variable for return #2
        {
            int i;
            i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_10588030 = (i < headers.size());
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_87832067 = (header.getName().equalsIgnoreCase(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_39738088 = header;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_178275251 = null;
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_1430233426; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1430233426 = varB4EAC82CA7396A68D541C85D26508E83_39738088;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1430233426 = varB4EAC82CA7396A68D541C85D26508E83_178275251;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1430233426.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1430233426;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.353 -0400", hash_original_method = "F097824BB9F324FCD125DCECBE8EB60F", hash_generated_method = "79D962011547F2D280B1903A6F1808B9")
    public Header getLastHeader(String name) {
        Header varB4EAC82CA7396A68D541C85D26508E83_2114595137 = null; //Variable for return #1
        Header varB4EAC82CA7396A68D541C85D26508E83_1575968815 = null; //Variable for return #2
        {
            int i;
            i = headers.size() - 1;
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_392968637 = (header.getName().equalsIgnoreCase(name));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2114595137 = header;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1575968815 = null;
        addTaint(name.getTaint());
        Header varA7E53CE21691AB073D9660D615818899_265769204; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_265769204 = varB4EAC82CA7396A68D541C85D26508E83_2114595137;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_265769204 = varB4EAC82CA7396A68D541C85D26508E83_1575968815;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_265769204.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_265769204;
        // ---------- Original Method ----------
        //for (int i = headers.size() - 1; i >= 0; i--) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return header;
            //}            
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.353 -0400", hash_original_method = "51A146DC1B834742F5A648A6C7C2FBE7", hash_generated_method = "D8884909072DDE7145116849C9DE4A19")
    public Header[] getAllHeaders() {
        Header[] varB4EAC82CA7396A68D541C85D26508E83_584611319 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_584611319 = (Header[]) headers.toArray(new Header[headers.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_584611319.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_584611319;
        // ---------- Original Method ----------
        //return (Header[]) headers.toArray(new Header[headers.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.365 -0400", hash_original_method = "8F463ADE51DCD8AE5187274242206DA5", hash_generated_method = "2916C0ADFB22EC1F2111ED9385B8D407")
    public boolean containsHeader(String name) {
        {
            int i;
            i = 0;
            boolean var69EAF81BA8786646830CC93F3A253AAC_2130632336 = (i < headers.size());
            {
                Header header;
                header = (Header) headers.get(i);
                {
                    boolean var9E3FA3C2985B01AC5BE4A451C9CC6881_1926966480 = (header.getName().equalsIgnoreCase(name));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1725074092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1725074092;
        // ---------- Original Method ----------
        //for (int i = 0; i < headers.size(); i++) {
            //Header header = (Header) headers.get(i);
            //if (header.getName().equalsIgnoreCase(name)) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.377 -0400", hash_original_method = "216CA9BCEE6B2216E69E554CBCCBB21C", hash_generated_method = "D76B8D4274ECF37BE16EF56ACE124622")
    public HeaderIterator iterator() {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_291695730 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_291695730 = new BasicListHeaderIterator(this.headers, null);
        varB4EAC82CA7396A68D541C85D26508E83_291695730.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_291695730;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.379 -0400", hash_original_method = "DFA4A10C9A5AF888C1AA8746F1A85305", hash_generated_method = "8836B45A80F6D324CACFD45F9E160BAD")
    public HeaderIterator iterator(final String name) {
        HeaderIterator varB4EAC82CA7396A68D541C85D26508E83_606407207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_606407207 = new BasicListHeaderIterator(this.headers, name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_606407207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_606407207;
        // ---------- Original Method ----------
        //return new BasicListHeaderIterator(this.headers, name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.380 -0400", hash_original_method = "5B227975880483464D857E333DC9323C", hash_generated_method = "45B6DD83BB5699F625133D0DA42CD0F2")
    public HeaderGroup copy() {
        HeaderGroup varB4EAC82CA7396A68D541C85D26508E83_927048858 = null; //Variable for return #1
        HeaderGroup clone;
        clone = new HeaderGroup();
        clone.headers.addAll(this.headers);
        varB4EAC82CA7396A68D541C85D26508E83_927048858 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_927048858.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_927048858;
        // ---------- Original Method ----------
        //HeaderGroup clone = new HeaderGroup();
        //clone.headers.addAll(this.headers);
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.380 -0400", hash_original_method = "A187915CF1AFFDE7143E028BA9E9F5A2", hash_generated_method = "CBC00D3E29DAE0E807153DA033C9AAAD")
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1105941374 = null; //Variable for return #1
        HeaderGroup clone;
        clone = (HeaderGroup) super.clone();
        clone.headers = new ArrayList(this.headers);
        varB4EAC82CA7396A68D541C85D26508E83_1105941374 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1105941374.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1105941374;
        // ---------- Original Method ----------
        //HeaderGroup clone = (HeaderGroup) super.clone();
        //clone.headers = new ArrayList(this.headers);
        //return clone;
    }

    
}

