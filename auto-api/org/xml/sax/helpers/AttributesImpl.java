package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.149 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.149 -0400", hash_original_field = "9483150F544BF05C50199D7A88E919A3", hash_generated_field = "FF698A9C75F799EB4FE98C16A723AC90")

    String data[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.156 -0400", hash_original_method = "6313F45FC494FF406CD3064C58B63747", hash_generated_method = "125C4A40CDC675B4E661BFA7A14FF3ED")
    public  AttributesImpl() {
        length = 0;
        data = null;
        // ---------- Original Method ----------
        //length = 0;
        //data = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.156 -0400", hash_original_method = "8A0D874B41C17812C2FD00F4B363184D", hash_generated_method = "DECA55089DA1BBA83C0C88C650D479C0")
    public  AttributesImpl(Attributes atts) {
        setAttributes(atts);
        addTaint(atts.getTaint());
        // ---------- Original Method ----------
        //setAttributes(atts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.156 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "99CF8FFD40D5537A321DBC4B2D8676C7")
    public int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016399332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2016399332;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.157 -0400", hash_original_method = "1BF0AE5363A8618B6A71FCEE06881B7C", hash_generated_method = "2CB7FA4FD890AB930670D5B603302466")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_893024134 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2043716938 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_893024134 = data[index*5];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2043716938 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_806719557; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_806719557 = varB4EAC82CA7396A68D541C85D26508E83_893024134;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_806719557 = varB4EAC82CA7396A68D541C85D26508E83_2043716938;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_806719557.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_806719557;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.158 -0400", hash_original_method = "92B1686F7E458511CE45EC4DB3E3CE89", hash_generated_method = "C688F223131F923CB3B83BE8B4874204")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1204677320 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1168573993 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1204677320 = data[index*5+1];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1168573993 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1678126886; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1678126886 = varB4EAC82CA7396A68D541C85D26508E83_1204677320;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1678126886 = varB4EAC82CA7396A68D541C85D26508E83_1168573993;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1678126886.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1678126886;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+1];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.168 -0400", hash_original_method = "32BD7D7FFA2C46007E9D534F2070D779", hash_generated_method = "AE29F7C3E4089EF6F1EA8CACF0187738")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_347633031 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1830535111 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_347633031 = data[index*5+2];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1830535111 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1877656723; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1877656723 = varB4EAC82CA7396A68D541C85D26508E83_347633031;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1877656723 = varB4EAC82CA7396A68D541C85D26508E83_1830535111;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1877656723.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1877656723;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+2];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.169 -0400", hash_original_method = "CD55E4A1C2CBE3FE53B5A622E57F028C", hash_generated_method = "D464777006F23C4CD0E20EC17AE180D9")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1349816469 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1975095241 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1349816469 = data[index*5+3];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1975095241 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1044155001; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1044155001 = varB4EAC82CA7396A68D541C85D26508E83_1349816469;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1044155001 = varB4EAC82CA7396A68D541C85D26508E83_1975095241;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1044155001.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1044155001;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+3];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_method = "7BC4C2655702EDFE2361F9F97C33BDBD", hash_generated_method = "F607DC7F3C594C811A5CAB15910F7BE8")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_2034601326 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1466168833 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2034601326 = data[index*5+4];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1466168833 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1476925262; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1476925262 = varB4EAC82CA7396A68D541C85D26508E83_2034601326;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1476925262 = varB4EAC82CA7396A68D541C85D26508E83_1466168833;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1476925262.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1476925262;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+4];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.170 -0400", hash_original_method = "090A4B083F61ECB7CB7169BD1EF033DF", hash_generated_method = "E53F92A81B7E70DBC95296F79F5752B9")
    public int getIndex(String uri, String localName) {
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_53997354 = (data[i].equals(uri) && data[i+1].equals(localName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478210435 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_478210435;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i].equals(uri) && data[i+1].equals(localName)) {
        //return i / 5;
        //}
    //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.171 -0400", hash_original_method = "EE3F059D65C038AB1F6CDD7302F8C95C", hash_generated_method = "96D8096A8BFE2586A15B2BB76E41F2F4")
    public int getIndex(String qName) {
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1947289798 = (data[i+2].equals(qName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183566877 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1183566877;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i+2].equals(qName)) {
        //return i / 5;
        //}
    //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.180 -0400", hash_original_method = "B693D2A452C34B3F63F46AE3F73B4CD6", hash_generated_method = "37EA8BE1335BE1E18F0D216A8D82FF42")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_536345105 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_801606532 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_1846490062 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_536345105 = data[i+3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_801606532 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1719711831; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1719711831 = varB4EAC82CA7396A68D541C85D26508E83_536345105;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1719711831 = varB4EAC82CA7396A68D541C85D26508E83_801606532;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1719711831.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1719711831;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i].equals(uri) && data[i+1].equals(localName)) {
        //return data[i+3];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.195 -0400", hash_original_method = "EC27C5C1CA5357EEA1E16E770BA20FA2", hash_generated_method = "32137DF7B06D0D766BE0E534246D4EA8")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_683057380 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_813072528 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1736174933 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_683057380 = data[i+3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_813072528 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1913210895; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1913210895 = varB4EAC82CA7396A68D541C85D26508E83_683057380;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1913210895 = varB4EAC82CA7396A68D541C85D26508E83_813072528;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1913210895.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1913210895;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i+2].equals(qName)) {
        //return data[i+3];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.196 -0400", hash_original_method = "522BBD1273EB28D82A0CFFAB0B22501D", hash_generated_method = "2F28FEBFDF64F01CE8653EF2E77F8C07")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_2106671902 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1319620389 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_958123020 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2106671902 = data[i+4];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1319620389 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_109790053; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_109790053 = varB4EAC82CA7396A68D541C85D26508E83_2106671902;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_109790053 = varB4EAC82CA7396A68D541C85D26508E83_1319620389;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_109790053.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_109790053;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i].equals(uri) && data[i+1].equals(localName)) {
        //return data[i+4];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.207 -0400", hash_original_method = "4282B0A2744D6B6FFA141D6FBFC4111A", hash_generated_method = "32061515C3AAF482371B1B80CD60A60A")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1940958925 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_758793118 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_48399344 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1940958925 = data[i+4];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_758793118 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1798158534; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1798158534 = varB4EAC82CA7396A68D541C85D26508E83_1940958925;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1798158534 = varB4EAC82CA7396A68D541C85D26508E83_758793118;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1798158534.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1798158534;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i+2].equals(qName)) {
        //return data[i+4];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.208 -0400", hash_original_method = "03C848B66796F8DBDE7832677AAFA935", hash_generated_method = "BDEFF4DE4CFAAB98784BA60D61D9B8E9")
    public void clear() {
        {
            {
                int i;
                i = 0;
                data [i] = null;
            } //End collapsed parenthetic
        } //End block
        length = 0;
        // ---------- Original Method ----------
        //if (data != null) {
        //for (int i = 0; i < (length * 5); i++)
        //data [i] = null;
    //}
        //length = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.209 -0400", hash_original_method = "AF86DF649668A0410832106AC7F2AE57", hash_generated_method = "69EAF91F95C75BDA8BE1B3A585586A11")
    public void setAttributes(Attributes atts) {
        clear();
        length = atts.getLength();
        {
            data = new String[length*5];
            {
                int i;
                i = 0;
                {
                    data[i*5] = atts.getURI(i);
                    data[i*5+1] = atts.getLocalName(i);
                    data[i*5+2] = atts.getQName(i);
                    data[i*5+3] = atts.getType(i);
                    data[i*5+4] = atts.getValue(i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //clear();
        //length = atts.getLength();
        //if (length > 0) {
            //data = new String[length*5];
            //for (int i = 0; i < length; i++) {
                //data[i*5] = atts.getURI(i);
                //data[i*5+1] = atts.getLocalName(i);
                //data[i*5+2] = atts.getQName(i);
                //data[i*5+3] = atts.getType(i);
                //data[i*5+4] = atts.getValue(i);
            //}
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.210 -0400", hash_original_method = "BEBCC50C9D4D6D2EEDEE155B4F15D792", hash_generated_method = "446F44EFE1522FA55D3A10F71A9677E9")
    public void addAttribute(String uri, String localName, String qName,
                  String type, String value) {
        ensureCapacity(length+1);
        data[length*5] = uri;
        data[length*5+1] = localName;
        data[length*5+2] = qName;
        data[length*5+3] = type;
        data[length*5+4] = value;
        // ---------- Original Method ----------
        //ensureCapacity(length+1);
        //data[length*5] = uri;
        //data[length*5+1] = localName;
        //data[length*5+2] = qName;
        //data[length*5+3] = type;
        //data[length*5+4] = value;
        //length++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.214 -0400", hash_original_method = "FF1F65C71EB4DEEB1CAA0E424ECEBB91", hash_generated_method = "F36A939953328C3439DA8023CF3A1212")
    public void setAttribute(int index, String uri, String localName,
                  String qName, String type, String value) {
        {
            data[index*5] = uri;
            data[index*5+1] = localName;
            data[index*5+2] = qName;
            data[index*5+3] = type;
            data[index*5+4] = value;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        addTaint(qName.getTaint());
        addTaint(type.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5] = uri;
        //data[index*5+1] = localName;
        //data[index*5+2] = qName;
        //data[index*5+3] = type;
        //data[index*5+4] = value;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.219 -0400", hash_original_method = "CCD3032C3525D921C0B3FD28370332A3", hash_generated_method = "B5190173607221806917170810758793")
    public void removeAttribute(int index) {
        {
            {
                System.arraycopy(data, (index+1)*5, data, index*5,
                 (length-index-1)*5);
            } //End block
            index = (length - 1) * 5;
            data [index++] = null;
            data [index++] = null;
            data [index++] = null;
            data [index++] = null;
            data [index] = null;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //if (index < length - 1) {
        //System.arraycopy(data, (index+1)*5, data, index*5,
                 //(length-index-1)*5);
        //}
        //index = (length - 1) * 5;
        //data [index++] = null;
        //data [index++] = null;
        //data [index++] = null;
        //data [index++] = null;
        //data [index] = null;
        //length--;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.220 -0400", hash_original_method = "50F4EE4994BD814C254566A0C91A3159", hash_generated_method = "B4607727E2BFBD0C69C92D5CA9EE6E5A")
    public void setURI(int index, String uri) {
        {
            data[index*5] = uri;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        addTaint(uri.getTaint());
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5] = uri;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.221 -0400", hash_original_method = "752FFE3C27BC55D6B126D5816B29C527", hash_generated_method = "24C22C1A236B075D788E2D1468D7187C")
    public void setLocalName(int index, String localName) {
        {
            data[index*5+1] = localName;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        addTaint(localName.getTaint());
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+1] = localName;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.221 -0400", hash_original_method = "092FB5C36230E9F885C6748AEF4243E2", hash_generated_method = "757DCBBD31735DBDCE0DC1D29156141F")
    public void setQName(int index, String qName) {
        {
            data[index*5+2] = qName;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        addTaint(qName.getTaint());
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+2] = qName;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.235 -0400", hash_original_method = "C2C16165C0A88812FD10B2DCA3F19338", hash_generated_method = "879767C66D5DDBB1CFF3245850923CC7")
    public void setType(int index, String type) {
        {
            data[index*5+3] = type;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        addTaint(type.getTaint());
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+3] = type;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.236 -0400", hash_original_method = "384311AE4C6374A489D3CC7FA620C40E", hash_generated_method = "A72654E196B760AD425242B9C63A35E9")
    public void setValue(int index, String value) {
        {
            data[index*5+4] = value;
        } //End block
        {
            badIndex(index);
        } //End block
        addTaint(index);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+4] = value;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.237 -0400", hash_original_method = "CB574EAE8A001C113E60067C9D40C52E", hash_generated_method = "C5AEF6B174B8219306F3AF6FA6335CE8")
    private void ensureCapacity(int n) {
        int max;
        {
            max = 25;
        } //End block
        {
            max = data.length;
        } //End block
        {
            max *= 2;
        } //End block
        String newData[];
        newData = new String[max];
        {
            System.arraycopy(data, 0, newData, 0, length*5);
        } //End block
        data = newData;
        addTaint(n);
        // ---------- Original Method ----------
        //if (n <= 0) {
            //return;
        //}
        //int max;
        //if (data == null || data.length == 0) {
            //max = 25;
        //}
        //else if (data.length >= n * 5) {
            //return;
        //}
        //else {
            //max = data.length;
        //}
        //while (max < n * 5) {
            //max *= 2;
        //}
        //String newData[] = new String[max];
        //if (length > 0) {
            //System.arraycopy(data, 0, newData, 0, length*5);
        //}
        //data = newData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:23.237 -0400", hash_original_method = "5A39796CA8340A67B1FFF4D32268D0FF", hash_generated_method = "5741BE8AFA74ABCF72FC32BDDEE79B14")
    private void badIndex(int index) throws ArrayIndexOutOfBoundsException {
        String msg;
        msg = "Attempt to modify attribute at illegal index: " + index;
        if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(msg);
        addTaint(index);
        // ---------- Original Method ----------
        //String msg =
        //"Attempt to modify attribute at illegal index: " + index;
        //throw new ArrayIndexOutOfBoundsException(msg);
    }

    
}

