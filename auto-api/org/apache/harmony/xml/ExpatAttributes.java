package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Attributes;

abstract class ExpatAttributes implements Attributes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.306 -0400", hash_original_method = "D4DF1C9BC2FF91CA250847447EABC788", hash_generated_method = "D4DF1C9BC2FF91CA250847447EABC788")
    public ExpatAttributes ()
    {
        //Synthesized constructor
    }


    public abstract int getLength();

    
    abstract int getParserPointer();

    
    public abstract int getPointer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.323 -0400", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "4FBAE7AF3C2C14A332A8FF5FAFCBEA01")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1519330189 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_414941892 = null; //Variable for return #2
        {
            boolean var203EB8F451F243B3D8A451211B677024_104168786 = (index < 0 || index >= getLength());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1519330189 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_414941892 = getURI(getParserPointer(), getPointer(), index);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_214717164; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_214717164 = varB4EAC82CA7396A68D541C85D26508E83_1519330189;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_214717164 = varB4EAC82CA7396A68D541C85D26508E83_414941892;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_214717164.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_214717164;
        // ---------- Original Method ----------
        //if (index < 0 || index >= getLength()) {
            //return null;
        //}
        //return getURI(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.323 -0400", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "AA6E3C9CFB7540A5AA7CF4F27C42644A")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1074024091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1074024091 = (index < 0 || index >= getLength())
                ? null
                : getLocalName(getParserPointer(), getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1074024091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1074024091;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getLocalName(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.324 -0400", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "BA366A063BA5AF3D5B42F6E827D9E8E3")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1247110020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1247110020 = (index < 0 || index >= getLength())
                ? null
                : getQName(getParserPointer(), getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1247110020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1247110020;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getQName(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.324 -0400", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "122F516EE7A0FE99463838D3132EADB5")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1205102982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1205102982 = (index < 0 || index >= getLength()) ? null : CDATA;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1205102982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1205102982;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength()) ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.336 -0400", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "D4CAFE4738D3A45CDFA9A992AFA1FB75")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1518485044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1518485044 = (index < 0 || index >= getLength())
                ? null
                : getValueByIndex(getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1518485044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1518485044;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getValueByIndex(getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.337 -0400", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "2DC7F3890C5EF685F19704B2987A0178")
    public int getIndex(String uri, String localName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        int pointer;
        pointer = getPointer();
        int var475C57EF25B01A7CB049CE2D3EAD6E3C_164613951 = (getIndex(pointer, uri, localName));
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736820525 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736820525;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return -1;
        //}
        //return getIndex(pointer, uri, localName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.342 -0400", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "FC246D30A8E669491BD834319679809A")
    public int getIndex(String qName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        int pointer;
        pointer = getPointer();
        int var96B5423CA7106BED454AAFC40E7EE7D4_1995899728 = (getIndexForQName(pointer, qName));
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912829951 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1912829951;
        // ---------- Original Method ----------
        //if (qName == null) {
            //throw new NullPointerException("uri");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return -1;
        //}
        //return getIndexForQName(pointer, qName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.363 -0400", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "D4FC24D9A45482E29C053729F369560F")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1698331230 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1698331230 = getIndex(uri, localName) == -1 ? null : CDATA;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1698331230.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698331230;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //return getIndex(uri, localName) == -1 ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.364 -0400", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "F982DE49046F3B18BE3BF7A866A7F294")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1896973650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1896973650 = getIndex(qName) == -1 ? null : CDATA;
        addTaint(qName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1896973650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1896973650;
        // ---------- Original Method ----------
        //return getIndex(qName) == -1 ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.364 -0400", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "EC399D922CCAF96F92B1CDB204BFC06B")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_631417437 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1680788755 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        int pointer;
        pointer = getPointer();
        {
            varB4EAC82CA7396A68D541C85D26508E83_631417437 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1680788755 = getValue(pointer, uri, localName);
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_196277230; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_196277230 = varB4EAC82CA7396A68D541C85D26508E83_631417437;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_196277230 = varB4EAC82CA7396A68D541C85D26508E83_1680788755;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_196277230.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_196277230;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return null;
        //}
        //return getValue(pointer, uri, localName);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.365 -0400", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "C8DCBEA7ECBD2A7CCD136212FE9553C3")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_389034739 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1285167856 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("qName");
        } //End block
        int pointer;
        pointer = getPointer();
        {
            varB4EAC82CA7396A68D541C85D26508E83_389034739 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1285167856 = getValueForQName(pointer, qName);
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_137767612; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_137767612 = varB4EAC82CA7396A68D541C85D26508E83_389034739;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_137767612 = varB4EAC82CA7396A68D541C85D26508E83_1285167856;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_137767612.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_137767612;
        // ---------- Original Method ----------
        //if (qName == null) {
            //throw new NullPointerException("qName");
        //}
        //int pointer = getPointer();
        //if (pointer == 0) {
            //return null;
        //}
        //return getValueForQName(pointer, qName);
    }

    
        private static String getURI(int pointer, int attributePointer, int index) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String getLocalName(int pointer, int attributePointer, int index) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String getQName(int pointer, int attributePointer, int index) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String getValueByIndex(int attributePointer, int index) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static int getIndex(int attributePointer, String uri, String localName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int getIndexForQName(int attributePointer, String qName) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static String getValue(int attributePointer, String uri, String localName) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static String getValueForQName(int attributePointer, String qName) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.384 -0400", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "89627B71E85340B676FC2D21222B8514")
    protected void freeAttributes(int pointer) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.384 -0400", hash_original_field = "833C91B89EDFBBA3080C06DEF8403445", hash_generated_field = "050E939B0DC084CC0946490A05021B46")

    private static String CDATA = "CDATA";
}

