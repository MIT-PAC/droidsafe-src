package org.xml.sax.helpers;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.854 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.854 -0400", hash_original_field = "9483150F544BF05C50199D7A88E919A3", hash_generated_field = "FF698A9C75F799EB4FE98C16A723AC90")

    String data[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.855 -0400", hash_original_method = "6313F45FC494FF406CD3064C58B63747", hash_generated_method = "125C4A40CDC675B4E661BFA7A14FF3ED")
    public  AttributesImpl() {
        length = 0;
        data = null;
        // ---------- Original Method ----------
        //length = 0;
        //data = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.855 -0400", hash_original_method = "8A0D874B41C17812C2FD00F4B363184D", hash_generated_method = "DECA55089DA1BBA83C0C88C650D479C0")
    public  AttributesImpl(Attributes atts) {
        setAttributes(atts);
        addTaint(atts.getTaint());
        // ---------- Original Method ----------
        //setAttributes(atts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.855 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "F00FEAA995D8DAAD9CF0169B33C9EC4F")
    public int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885946227 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_885946227;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.856 -0400", hash_original_method = "1BF0AE5363A8618B6A71FCEE06881B7C", hash_generated_method = "CEA895044EFC39E59435195A5F100E9E")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1786182390 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1609704178 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1786182390 = data[index*5];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1609704178 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1301327106; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1301327106 = varB4EAC82CA7396A68D541C85D26508E83_1786182390;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1301327106 = varB4EAC82CA7396A68D541C85D26508E83_1609704178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1301327106.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1301327106;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.857 -0400", hash_original_method = "92B1686F7E458511CE45EC4DB3E3CE89", hash_generated_method = "7B3A550B54C124923C79C6BFEBE7F9B5")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_964467384 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1182160355 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_964467384 = data[index*5+1];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1182160355 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1726372645; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1726372645 = varB4EAC82CA7396A68D541C85D26508E83_964467384;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1726372645 = varB4EAC82CA7396A68D541C85D26508E83_1182160355;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1726372645.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1726372645;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+1];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.857 -0400", hash_original_method = "32BD7D7FFA2C46007E9D534F2070D779", hash_generated_method = "D065AE224BF4745CE07BEA9FDDCB8D8D")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_800418505 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1473200695 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_800418505 = data[index*5+2];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1473200695 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_346405232; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_346405232 = varB4EAC82CA7396A68D541C85D26508E83_800418505;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_346405232 = varB4EAC82CA7396A68D541C85D26508E83_1473200695;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_346405232.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_346405232;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+2];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.858 -0400", hash_original_method = "CD55E4A1C2CBE3FE53B5A622E57F028C", hash_generated_method = "1C97477C4E7310F8E97BB846CA84C5A4")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_670845669 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_984714239 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_670845669 = data[index*5+3];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_984714239 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1621220117; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1621220117 = varB4EAC82CA7396A68D541C85D26508E83_670845669;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1621220117 = varB4EAC82CA7396A68D541C85D26508E83_984714239;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1621220117.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1621220117;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+3];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.859 -0400", hash_original_method = "7BC4C2655702EDFE2361F9F97C33BDBD", hash_generated_method = "E0D7D3F074416D1D2B4C2B379E3F9CEF")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1101456549 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_756139546 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1101456549 = data[index*5+4];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_756139546 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1700760685; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1700760685 = varB4EAC82CA7396A68D541C85D26508E83_1101456549;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1700760685 = varB4EAC82CA7396A68D541C85D26508E83_756139546;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1700760685.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1700760685;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //return data[index*5+4];
    //} else {
        //return null;
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.859 -0400", hash_original_method = "090A4B083F61ECB7CB7169BD1EF033DF", hash_generated_method = "5F8DFAE4ED3E799231AEFE3FF59F2CF8")
    public int getIndex(String uri, String localName) {
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_272328793 = (data[i].equals(uri) && data[i+1].equals(localName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254786563 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_254786563;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i].equals(uri) && data[i+1].equals(localName)) {
        //return i / 5;
        //}
    //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.860 -0400", hash_original_method = "EE3F059D65C038AB1F6CDD7302F8C95C", hash_generated_method = "B6361F19DB7F763D8E200D94078B1DB1")
    public int getIndex(String qName) {
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1962581841 = (data[i+2].equals(qName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179297889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1179297889;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i+2].equals(qName)) {
        //return i / 5;
        //}
    //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.863 -0400", hash_original_method = "B693D2A452C34B3F63F46AE3F73B4CD6", hash_generated_method = "6700DA14512653DB5B5E29191884E9ED")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_448847875 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2008011832 = null; //Variable for return #2
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_192270971 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_448847875 = data[i+3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2008011832 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1681780544; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1681780544 = varB4EAC82CA7396A68D541C85D26508E83_448847875;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1681780544 = varB4EAC82CA7396A68D541C85D26508E83_2008011832;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1681780544.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1681780544;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i].equals(uri) && data[i+1].equals(localName)) {
        //return data[i+3];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.865 -0400", hash_original_method = "EC27C5C1CA5357EEA1E16E770BA20FA2", hash_generated_method = "F607DE918FA257F6F6E23B76B58F45B4")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_463076261 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_83664745 = null; //Variable for return #2
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_677306517 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_463076261 = data[i+3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_83664745 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_18971079; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_18971079 = varB4EAC82CA7396A68D541C85D26508E83_463076261;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_18971079 = varB4EAC82CA7396A68D541C85D26508E83_83664745;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_18971079.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_18971079;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i+2].equals(qName)) {
        //return data[i+3];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.866 -0400", hash_original_method = "522BBD1273EB28D82A0CFFAB0B22501D", hash_generated_method = "E052F97A5ABF91EEBE487846819E48E5")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1598011820 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1049214071 = null; //Variable for return #2
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_1766477837 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1598011820 = data[i+4];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1049214071 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1203418595; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1203418595 = varB4EAC82CA7396A68D541C85D26508E83_1598011820;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1203418595 = varB4EAC82CA7396A68D541C85D26508E83_1049214071;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1203418595.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1203418595;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i].equals(uri) && data[i+1].equals(localName)) {
        //return data[i+4];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.867 -0400", hash_original_method = "4282B0A2744D6B6FFA141D6FBFC4111A", hash_generated_method = "1303B5B746147297D7EE78BDFFC3AFE5")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1230678350 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_915209747 = null; //Variable for return #2
        int max = length * 5;
        {
            int i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1162533273 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1230678350 = data[i+4];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_915209747 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1034679782; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1034679782 = varB4EAC82CA7396A68D541C85D26508E83_1230678350;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1034679782 = varB4EAC82CA7396A68D541C85D26508E83_915209747;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1034679782.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1034679782;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
        //if (data[i+2].equals(qName)) {
        //return data[i+4];
        //}
    //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.867 -0400", hash_original_method = "03C848B66796F8DBDE7832677AAFA935", hash_generated_method = "92D92F557DB91C808602D1F195D7407C")
    public void clear() {
        {
            {
                int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.868 -0400", hash_original_method = "AF86DF649668A0410832106AC7F2AE57", hash_generated_method = "383454FA757E91BF22D812C0DD7AABDF")
    public void setAttributes(Attributes atts) {
        clear();
        length = atts.getLength();
        {
            data = new String[length*5];
            {
                int i = 0;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.869 -0400", hash_original_method = "BEBCC50C9D4D6D2EEDEE155B4F15D792", hash_generated_method = "446F44EFE1522FA55D3A10F71A9677E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.870 -0400", hash_original_method = "FF1F65C71EB4DEEB1CAA0E424ECEBB91", hash_generated_method = "0C86CEEC437F23C72B5341F30A939074")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.871 -0400", hash_original_method = "CCD3032C3525D921C0B3FD28370332A3", hash_generated_method = "30657D28074FA7318F5DCEEB81AE8346")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.872 -0400", hash_original_method = "50F4EE4994BD814C254566A0C91A3159", hash_generated_method = "189634784CC3D87714F94F95CA9AE40B")
    public void setURI(int index, String uri) {
        {
            data[index*5] = uri;
        } //End block
        {
            badIndex(index);
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5] = uri;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.873 -0400", hash_original_method = "752FFE3C27BC55D6B126D5816B29C527", hash_generated_method = "EE4EC8CE033CC258B23E0FB3EE329175")
    public void setLocalName(int index, String localName) {
        {
            data[index*5+1] = localName;
        } //End block
        {
            badIndex(index);
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+1] = localName;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.873 -0400", hash_original_method = "092FB5C36230E9F885C6748AEF4243E2", hash_generated_method = "76CA5E4B31889C44B734382CBC5C6E51")
    public void setQName(int index, String qName) {
        {
            data[index*5+2] = qName;
        } //End block
        {
            badIndex(index);
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+2] = qName;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.873 -0400", hash_original_method = "C2C16165C0A88812FD10B2DCA3F19338", hash_generated_method = "65D3BD8341FEBE938E1850C8859B2D71")
    public void setType(int index, String type) {
        {
            data[index*5+3] = type;
        } //End block
        {
            badIndex(index);
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+3] = type;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.874 -0400", hash_original_method = "384311AE4C6374A489D3CC7FA620C40E", hash_generated_method = "7F3196238D00EEB51E7CF68BA42F8A65")
    public void setValue(int index, String value) {
        {
            data[index*5+4] = value;
        } //End block
        {
            badIndex(index);
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
        //data[index*5+4] = value;
    //} else {
        //badIndex(index);
    //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.874 -0400", hash_original_method = "CB574EAE8A001C113E60067C9D40C52E", hash_generated_method = "7CB08C395D683F782E241B21632C5B7B")
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
        String newData[] = new String[max];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:48.874 -0400", hash_original_method = "5A39796CA8340A67B1FFF4D32268D0FF", hash_generated_method = "0882442A793C9911842010C280906F43")
    private void badIndex(int index) throws ArrayIndexOutOfBoundsException {
        String msg = "Attempt to modify attribute at illegal index: " + index;
        if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(msg);
        addTaint(index);
        // ---------- Original Method ----------
        //String msg =
        //"Attempt to modify attribute at illegal index: " + index;
        //throw new ArrayIndexOutOfBoundsException(msg);
    }

    
}

