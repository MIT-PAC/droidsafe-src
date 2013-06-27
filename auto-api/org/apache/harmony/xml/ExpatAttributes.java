package org.apache.harmony.xml;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Attributes;

abstract class ExpatAttributes implements Attributes {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.436 -0400", hash_original_method = "D4DF1C9BC2FF91CA250847447EABC788", hash_generated_method = "D4DF1C9BC2FF91CA250847447EABC788")
    public ExpatAttributes ()
    {
        //Synthesized constructor
    }


    public abstract int getLength();

    
    abstract int getParserPointer();

    
    public abstract int getPointer();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.437 -0400", hash_original_method = "57C7829583448928D2E62C8F0C20470B", hash_generated_method = "49AF09B337C0DEF2696A6FA86E656ADC")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1313490275 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2042796311 = null; //Variable for return #2
        {
            boolean var203EB8F451F243B3D8A451211B677024_1943934152 = (index < 0 || index >= getLength());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1313490275 = null;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_2042796311 = getURI(getParserPointer(), getPointer(), index);
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_346837529; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_346837529 = varB4EAC82CA7396A68D541C85D26508E83_1313490275;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_346837529 = varB4EAC82CA7396A68D541C85D26508E83_2042796311;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_346837529.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_346837529;
        // ---------- Original Method ----------
        //if (index < 0 || index >= getLength()) {
            //return null;
        //}
        //return getURI(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.438 -0400", hash_original_method = "0BE26DE1FC37C5F8E294AD66DA35C798", hash_generated_method = "CE001BAE1A38B4C709494634FCE6CC89")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_695823256 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_695823256 = (index < 0 || index >= getLength())
                ? null
                : getLocalName(getParserPointer(), getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_695823256.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_695823256;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getLocalName(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.439 -0400", hash_original_method = "0E62167FF9D29B28633236898C212817", hash_generated_method = "ABD62EACDD906FF8698F623926907884")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1154673542 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1154673542 = (index < 0 || index >= getLength())
                ? null
                : getQName(getParserPointer(), getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1154673542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1154673542;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getQName(getParserPointer(), getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.440 -0400", hash_original_method = "906F8D6EEECA09A0EB9B2E9E5289B227", hash_generated_method = "DCCC480E587DFCCCD111BB6CD053BF53")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1899295397 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1899295397 = (index < 0 || index >= getLength()) ? null : CDATA;
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1899295397.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1899295397;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength()) ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.442 -0400", hash_original_method = "3269AF76DE45F61A692FCC87354CAB72", hash_generated_method = "E74F8272E4A85D5EE22B50CC3B5496CB")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_828071157 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_828071157 = (index < 0 || index >= getLength())
                ? null
                : getValueByIndex(getPointer(), index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_828071157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828071157;
        // ---------- Original Method ----------
        //return (index < 0 || index >= getLength())
                //? null
                //: getValueByIndex(getPointer(), index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.443 -0400", hash_original_method = "C871C7E3F593C081235C517FE9A1E558", hash_generated_method = "D61C32D5A5F4BC779E2C15E4D376C574")
    public int getIndex(String uri, String localName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        int pointer;
        pointer = getPointer();
        int var475C57EF25B01A7CB049CE2D3EAD6E3C_331927435 = (getIndex(pointer, uri, localName));
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682752741 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_682752741;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.446 -0400", hash_original_method = "980758BEF60D7C26C232D3CAD78E7835", hash_generated_method = "A5847AEC9033F12BEBAC5148C4BCA313")
    public int getIndex(String qName) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        int pointer;
        pointer = getPointer();
        int var96B5423CA7106BED454AAFC40E7EE7D4_1573227057 = (getIndexForQName(pointer, qName));
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608007508 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608007508;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.457 -0400", hash_original_method = "374AA6D4EA76C101E4A1F3245973703C", hash_generated_method = "5750072C98498346DE1D86EAA2459296")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_954948068 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_954948068 = getIndex(uri, localName) == -1 ? null : CDATA;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_954948068.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_954948068;
        // ---------- Original Method ----------
        //if (uri == null) {
            //throw new NullPointerException("uri");
        //}
        //if (localName == null) {
            //throw new NullPointerException("local name");
        //}
        //return getIndex(uri, localName) == -1 ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.458 -0400", hash_original_method = "845C2A9D603CFD94A25AD0FA47DD5097", hash_generated_method = "439FA2238BA8001D8AE01E2CD206406B")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1198207741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1198207741 = getIndex(qName) == -1 ? null : CDATA;
        addTaint(qName.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1198207741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1198207741;
        // ---------- Original Method ----------
        //return getIndex(qName) == -1 ? null : CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.464 -0400", hash_original_method = "C565081F95CF8700320081FA5DB3FD15", hash_generated_method = "7A9625E63C3563523616C9146B8EBB94")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1491011308 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1768443997 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("uri");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("local name");
        } //End block
        int pointer;
        pointer = getPointer();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1491011308 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1768443997 = getValue(pointer, uri, localName);
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_253253533; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_253253533 = varB4EAC82CA7396A68D541C85D26508E83_1491011308;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_253253533 = varB4EAC82CA7396A68D541C85D26508E83_1768443997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_253253533.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_253253533;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.474 -0400", hash_original_method = "11A6BF5F6E86FB8B88CA0053A4EF72DA", hash_generated_method = "B6FD727688C56C8FFB2F1A5D7DBE7643")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_838723781 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1057010378 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("qName");
        } //End block
        int pointer;
        pointer = getPointer();
        {
            varB4EAC82CA7396A68D541C85D26508E83_838723781 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1057010378 = getValueForQName(pointer, qName);
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1591241278; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1591241278 = varB4EAC82CA7396A68D541C85D26508E83_838723781;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1591241278 = varB4EAC82CA7396A68D541C85D26508E83_1057010378;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1591241278.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1591241278;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.476 -0400", hash_original_method = "9C2FF3514BF1A56FDD02B5A5C31F714B", hash_generated_method = "89627B71E85340B676FC2D21222B8514")
    protected void freeAttributes(int pointer) {
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.476 -0400", hash_original_field = "833C91B89EDFBBA3080C06DEF8403445", hash_generated_field = "050E939B0DC084CC0946490A05021B46")

    private static String CDATA = "CDATA";
}

