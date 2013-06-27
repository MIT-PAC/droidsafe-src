package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.xml.sax.Attributes;

public class AttributesImpl implements Attributes {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.113 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "136C4DD872F8065EECD33F6CD4E7556E")

    int length;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.113 -0400", hash_original_field = "9483150F544BF05C50199D7A88E919A3", hash_generated_field = "FF698A9C75F799EB4FE98C16A723AC90")

    String data[];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.116 -0400", hash_original_method = "6313F45FC494FF406CD3064C58B63747", hash_generated_method = "125C4A40CDC675B4E661BFA7A14FF3ED")
    public  AttributesImpl() {
        length = 0;
        data = null;
        // ---------- Original Method ----------
        //length = 0;
        //data = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.116 -0400", hash_original_method = "8A0D874B41C17812C2FD00F4B363184D", hash_generated_method = "DECA55089DA1BBA83C0C88C650D479C0")
    public  AttributesImpl(Attributes atts) {
        setAttributes(atts);
        addTaint(atts.getTaint());
        // ---------- Original Method ----------
        //setAttributes(atts);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.116 -0400", hash_original_method = "A993727E7D5DC0CA2BB581135F7F678B", hash_generated_method = "C0272E025B312325DD14245C55B395E1")
    public int getLength() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633059991 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_633059991;
        // ---------- Original Method ----------
        //return length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.127 -0400", hash_original_method = "1BF0AE5363A8618B6A71FCEE06881B7C", hash_generated_method = "2585990CDEDC8818D88E7956DE26B833")
    public String getURI(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_458147116 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_545391340 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_458147116 = data[index*5];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_545391340 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1677475219; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1677475219 = varB4EAC82CA7396A68D541C85D26508E83_458147116;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1677475219 = varB4EAC82CA7396A68D541C85D26508E83_545391340;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1677475219.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1677475219;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
	    //return data[index*5];
	//} else {
	    //return null;
	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.128 -0400", hash_original_method = "92B1686F7E458511CE45EC4DB3E3CE89", hash_generated_method = "476E1FA918C54D532DCC05BB224FC3D9")
    public String getLocalName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_690459985 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_484409131 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_690459985 = data[index*5+1];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_484409131 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_348817142; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_348817142 = varB4EAC82CA7396A68D541C85D26508E83_690459985;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_348817142 = varB4EAC82CA7396A68D541C85D26508E83_484409131;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_348817142.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_348817142;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
	    //return data[index*5+1];
	//} else {
	    //return null;
	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.129 -0400", hash_original_method = "32BD7D7FFA2C46007E9D534F2070D779", hash_generated_method = "FE1C391CA03FB0709A5F4A0918F7D52C")
    public String getQName(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1570461349 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2047658256 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1570461349 = data[index*5+2];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2047658256 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1085843119; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1085843119 = varB4EAC82CA7396A68D541C85D26508E83_1570461349;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1085843119 = varB4EAC82CA7396A68D541C85D26508E83_2047658256;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1085843119.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1085843119;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
	    //return data[index*5+2];
	//} else {
	    //return null;
	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.130 -0400", hash_original_method = "CD55E4A1C2CBE3FE53B5A622E57F028C", hash_generated_method = "FF56B3D1F69266329DF62C83178B09DB")
    public String getType(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1341316283 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_973878215 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1341316283 = data[index*5+3];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_973878215 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1561623269; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1561623269 = varB4EAC82CA7396A68D541C85D26508E83_1341316283;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1561623269 = varB4EAC82CA7396A68D541C85D26508E83_973878215;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1561623269.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1561623269;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
	    //return data[index*5+3];
	//} else {
	    //return null;
	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.134 -0400", hash_original_method = "7BC4C2655702EDFE2361F9F97C33BDBD", hash_generated_method = "CC96F9DB89041A126FC263A45CF0CAD9")
    public String getValue(int index) {
        String varB4EAC82CA7396A68D541C85D26508E83_1921188604 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2041558205 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1921188604 = data[index*5+4];
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2041558205 = null;
        } //End block
        addTaint(index);
        String varA7E53CE21691AB073D9660D615818899_1447469489; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1447469489 = varB4EAC82CA7396A68D541C85D26508E83_1921188604;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1447469489 = varB4EAC82CA7396A68D541C85D26508E83_2041558205;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1447469489.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1447469489;
        // ---------- Original Method ----------
        //if (index >= 0 && index < length) {
	    //return data[index*5+4];
	//} else {
	    //return null;
	//}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.143 -0400", hash_original_method = "090A4B083F61ECB7CB7169BD1EF033DF", hash_generated_method = "61A730E868C5333E06DD8C8B0C34AB66")
    public int getIndex(String uri, String localName) {
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_420459776 = (data[i].equals(uri) && data[i+1].equals(localName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084307389 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1084307389;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
	    //if (data[i].equals(uri) && data[i+1].equals(localName)) {
		//return i / 5;
	    //}
	//}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.143 -0400", hash_original_method = "EE3F059D65C038AB1F6CDD7302F8C95C", hash_generated_method = "D4BAAADB9C4401353CB48A30EB83E466")
    public int getIndex(String qName) {
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1468226565 = (data[i+2].equals(qName));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(qName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723145849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_723145849;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
	    //if (data[i+2].equals(qName)) {
		//return i / 5;
	    //}
	//}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.144 -0400", hash_original_method = "B693D2A452C34B3F63F46AE3F73B4CD6", hash_generated_method = "DFD336B74E0816AC7C298B41B004392F")
    public String getType(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_980080279 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1555954434 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_486263027 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_980080279 = data[i+3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1555954434 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1561774708; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1561774708 = varB4EAC82CA7396A68D541C85D26508E83_980080279;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1561774708 = varB4EAC82CA7396A68D541C85D26508E83_1555954434;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1561774708.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1561774708;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
	    //if (data[i].equals(uri) && data[i+1].equals(localName)) {
		//return data[i+3];
	    //}
	//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.145 -0400", hash_original_method = "EC27C5C1CA5357EEA1E16E770BA20FA2", hash_generated_method = "E8E3FDA02EE361B609D51B177B5A3421")
    public String getType(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_921845318 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_232680551 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1374750305 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_921845318 = data[i+3];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_232680551 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_667020495; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_667020495 = varB4EAC82CA7396A68D541C85D26508E83_921845318;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_667020495 = varB4EAC82CA7396A68D541C85D26508E83_232680551;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_667020495.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_667020495;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
	    //if (data[i+2].equals(qName)) {
		//return data[i+3];
	    //}
	//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.175 -0400", hash_original_method = "522BBD1273EB28D82A0CFFAB0B22501D", hash_generated_method = "89D353BF1AA09D5E9BE232BAC6C62AB6")
    public String getValue(String uri, String localName) {
        String varB4EAC82CA7396A68D541C85D26508E83_471748267 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1491097416 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean varAAE6B8DFDBCC8D3ED97D54A22B8218A3_1834468384 = (data[i].equals(uri) && data[i+1].equals(localName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_471748267 = data[i+4];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1491097416 = null;
        addTaint(uri.getTaint());
        addTaint(localName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_428736808; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_428736808 = varB4EAC82CA7396A68D541C85D26508E83_471748267;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_428736808 = varB4EAC82CA7396A68D541C85D26508E83_1491097416;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_428736808.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_428736808;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
	    //if (data[i].equals(uri) && data[i+1].equals(localName)) {
		//return data[i+4];
	    //}
	//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.176 -0400", hash_original_method = "4282B0A2744D6B6FFA141D6FBFC4111A", hash_generated_method = "AE14A9D9391949BF946492A245201975")
    public String getValue(String qName) {
        String varB4EAC82CA7396A68D541C85D26508E83_1342938978 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_602567844 = null; //Variable for return #2
        int max;
        max = length * 5;
        {
            int i;
            i = 0;
            i += 5;
            {
                {
                    boolean var79D134C69AFAFBBA44E0F9F404A7B8C5_1595445476 = (data[i+2].equals(qName));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1342938978 = data[i+4];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_602567844 = null;
        addTaint(qName.getTaint());
        String varA7E53CE21691AB073D9660D615818899_2102144195; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2102144195 = varB4EAC82CA7396A68D541C85D26508E83_1342938978;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2102144195 = varB4EAC82CA7396A68D541C85D26508E83_602567844;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2102144195.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2102144195;
        // ---------- Original Method ----------
        //int max = length * 5;
        //for (int i = 0; i < max; i += 5) {
	    //if (data[i+2].equals(qName)) {
		//return data[i+4];
	    //}
	//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.176 -0400", hash_original_method = "03C848B66796F8DBDE7832677AAFA935", hash_generated_method = "BDEFF4DE4CFAAB98784BA60D61D9B8E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.187 -0400", hash_original_method = "AF86DF649668A0410832106AC7F2AE57", hash_generated_method = "69EAF91F95C75BDA8BE1B3A585586A11")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.188 -0400", hash_original_method = "BEBCC50C9D4D6D2EEDEE155B4F15D792", hash_generated_method = "446F44EFE1522FA55D3A10F71A9677E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.196 -0400", hash_original_method = "FF1F65C71EB4DEEB1CAA0E424ECEBB91", hash_generated_method = "F36A939953328C3439DA8023CF3A1212")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.199 -0400", hash_original_method = "CCD3032C3525D921C0B3FD28370332A3", hash_generated_method = "B5190173607221806917170810758793")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.200 -0400", hash_original_method = "50F4EE4994BD814C254566A0C91A3159", hash_generated_method = "B4607727E2BFBD0C69C92D5CA9EE6E5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.203 -0400", hash_original_method = "752FFE3C27BC55D6B126D5816B29C527", hash_generated_method = "24C22C1A236B075D788E2D1468D7187C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.204 -0400", hash_original_method = "092FB5C36230E9F885C6748AEF4243E2", hash_generated_method = "757DCBBD31735DBDCE0DC1D29156141F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.215 -0400", hash_original_method = "C2C16165C0A88812FD10B2DCA3F19338", hash_generated_method = "879767C66D5DDBB1CFF3245850923CC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.215 -0400", hash_original_method = "384311AE4C6374A489D3CC7FA620C40E", hash_generated_method = "A72654E196B760AD425242B9C63A35E9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.216 -0400", hash_original_method = "CB574EAE8A001C113E60067C9D40C52E", hash_generated_method = "C5AEF6B174B8219306F3AF6FA6335CE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:22.216 -0400", hash_original_method = "5A39796CA8340A67B1FFF4D32268D0FF", hash_generated_method = "5741BE8AFA74ABCF72FC32BDDEE79B14")
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

