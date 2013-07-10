package com.android.internal.util;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TypedProperties extends HashMap<String, Object> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.989 -0400", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "B248ACEE9001880DCCB88F00DD01C611")
    public  TypedProperties() {
        super();
        
    }

    
    @DSModeled(DSC.SAFE)
    static StreamTokenizer initTokenizer(Reader r) {
        StreamTokenizer st = new StreamTokenizer(r);
        st.resetSyntax();
        st.wordChars('0', '9');
        st.wordChars('A', 'Z');
        st.wordChars('a', 'z');
        st.wordChars('_', '_');
        st.wordChars('$', '$');
        st.wordChars('.', '.');
        st.wordChars('-', '-');
        st.wordChars('+', '+');
        st.ordinaryChar('=');
        st.whitespaceChars(' ', ' ');
        st.whitespaceChars('\t', '\t');
        st.whitespaceChars('\n', '\n');
        st.whitespaceChars('\r', '\r');
        st.quoteChar('"');
        st.slashStarComments(true);
        st.slashSlashComments(true);
        return st;
    }

    
    @DSModeled(DSC.SAFE)
    static int interpretType(String typeName) {
        if ("unset".equals(typeName)) {
            return TYPE_UNSET;
        } else if ("boolean".equals(typeName)) {
            return TYPE_BOOLEAN;
        } else if ("byte".equals(typeName)) {
            return TYPE_BYTE;
        } else if ("short".equals(typeName)) {
            return TYPE_SHORT;
        } else if ("int".equals(typeName)) {
            return TYPE_INT;
        } else if ("long".equals(typeName)) {
            return TYPE_LONG;
        } else if ("float".equals(typeName)) {
            return TYPE_FLOAT;
        } else if ("double".equals(typeName)) {
            return TYPE_DOUBLE;
        } else if ("String".equals(typeName)) {
            return TYPE_STRING;
        }
        return TYPE_ERROR;
    }

    
    @DSModeled(DSC.SAFE)
    static void parse(Reader r, Map<String, Object> map) throws ParseException, IOException {
        final StreamTokenizer st = initTokenizer(r);
        final String identifierPattern = "[a-zA-Z_$][0-9a-zA-Z_$]*";
        final Pattern propertyNamePattern =
            Pattern.compile("(" + identifierPattern + "\\.)*" + identifierPattern);
        while (true) {
            int token;
            token = st.nextToken();
            if (token == StreamTokenizer.TT_EOF) {
                break;
            }
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "type name");
            }
            final int type = interpretType(st.sval);
            if (type == TYPE_ERROR) {
                throw new ParseException(st, "valid type name");
            }
            st.sval = null;
            if (type == TYPE_UNSET) {
                token = st.nextToken();
                if (token != '(') {
                    throw new ParseException(st, "'('");
                }
            }
            token = st.nextToken();
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "property name");
            }
            final String propertyName = st.sval;
            if (!propertyNamePattern.matcher(propertyName).matches()) {
                throw new ParseException(st, "valid property name");
            }
            st.sval = null;
            if (type == TYPE_UNSET) {
                token = st.nextToken();
                if (token != ')') {
                    throw new ParseException(st, "')'");
                }
                map.remove(propertyName);
            } else {
                token = st.nextToken();
                if (token != '=') {
                    throw new ParseException(st, "'='");
                }
                final Object value = parseValue(st, type);
                final Object oldValue = map.remove(propertyName);
                if (oldValue != null) {
                    if (value.getClass() != oldValue.getClass()) {
                        throw new ParseException(st,
                            "(property previously declared as a different type)");
                    }
                }
                map.put(propertyName, value);
            }
            token = st.nextToken();
            if (token != ';') {
                throw new ParseException(st, "';'");
            }
        }
    }

    
    static Object parseValue(StreamTokenizer st, final int type) throws IOException {
        final int token = st.nextToken();
        if (type == TYPE_BOOLEAN) {
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "boolean constant");
            }
            if ("true".equals(st.sval)) {
                return Boolean.TRUE;
            } else if ("false".equals(st.sval)) {
                return Boolean.FALSE;
            }
            throw new ParseException(st, "boolean constant");
        } else if ((type & 0xff) == 'I') {
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "integer constant");
            }
            long value;
            try {
                value = Long.decode(st.sval);
            } catch (NumberFormatException ex) {
                throw new ParseException(st, "integer constant");
            }
            int width = (type >> 8) & 0xff;
            switch (width) {
            case 1:
                if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
                    throw new ParseException(st, "8-bit integer constant");
                }
                return new Byte((byte)value);
            case 2:
                if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
                    throw new ParseException(st, "16-bit integer constant");
                }
                return new Short((short)value);
            case 4:
                if (value < Integer.MIN_VALUE || value > Integer.MAX_VALUE) {
                    throw new ParseException(st, "32-bit integer constant");
                }
                return new Integer((int)value);
            case 8:
                if (value < Long.MIN_VALUE || value > Long.MAX_VALUE) {
                    throw new ParseException(st, "64-bit integer constant");
                }
                return new Long(value);
            default:
                throw new IllegalStateException(
                    "Internal error; unexpected integer type width " + width);
            }
        } else if ((type & 0xff) == 'F') {
            if (token != StreamTokenizer.TT_WORD) {
                throw new ParseException(st, "float constant");
            }
            double value;
            try {
                value = Double.parseDouble(st.sval);
            } catch (NumberFormatException ex) {
                throw new ParseException(st, "float constant");
            }
            if (((type >> 8) & 0xff) == 4) {
                double absValue = Math.abs(value);
                if (absValue != 0.0 && !Double.isInfinite(value) && !Double.isNaN(value)) {
                    if (absValue < Float.MIN_VALUE || absValue > Float.MAX_VALUE) {
                        throw new ParseException(st, "32-bit float constant");
                    }
                }
                return new Float((float)value);
            } else {
                return new Double(value);
            }
        } else if (type == TYPE_STRING) {
            if (token == '"') {
                return st.sval;
            } else if (token == StreamTokenizer.TT_WORD && "null".equals(st.sval)) {
                return NULL_STRING;
            }
            throw new ParseException(st, "double-quoted string or 'null'");
        }
        throw new IllegalStateException("Internal error; unknown type " + type);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.991 -0400", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "D00A13F2BF825310240AF8D8220CE5B0")
    public void load(Reader r) throws IOException {
        parse(r, this);
        addTaint(r.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.992 -0400", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "BAEB694611B086B6649716B182220292")
    @Override
    public Object get(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_216046517 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_1905727683 = null; 
        Object value = super.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_216046517 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1905727683 = value;
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_130728856; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_130728856 = varB4EAC82CA7396A68D541C85D26508E83_216046517;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_130728856 = varB4EAC82CA7396A68D541C85D26508E83_1905727683;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_130728856.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_130728856;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.993 -0400", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "921324951CCBCC67CFB637730A24F3A9")
    public boolean getBoolean(String property, boolean def) {
        Object value = super.get(property);
        {
            boolean var28F7FA156A0AF9E80777EF1AC0FADFEE_1778189401 = (((Boolean)value).booleanValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "boolean");
        addTaint(property.getTaint());
        addTaint(def);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_709166092 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_709166092;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.993 -0400", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "C58DD44E9B2E7F191F898ED6A37FF15F")
    public byte getByte(String property, byte def) {
        Object value = super.get(property);
        {
            byte var2006B69F4737BD108E2C51959A456F7A_2114754991 = (((Byte)value).byteValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "byte");
        addTaint(property.getTaint());
        addTaint(def);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1968072851 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1968072851;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.994 -0400", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "1DCCB16DE4F57B7B782E82E05414D19E")
    public short getShort(String property, short def) {
        Object value = super.get(property);
        {
            short varFA0267FA29F4ECA5E451C256453D307B_1593221205 = (((Short)value).shortValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "short");
        addTaint(property.getTaint());
        addTaint(def);
        short var4F09DAA9D95BCB166A302407A0E0BABE_2111623667 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_2111623667;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.994 -0400", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "896ADB48153BFB1A646D84E70C10216A")
    public int getInt(String property, int def) {
        Object value = super.get(property);
        {
            int var2BBA3283F2CE0451B65410804794C972_1369985599 = (((Integer)value).intValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "int");
        addTaint(property.getTaint());
        addTaint(def);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435600504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_435600504;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.995 -0400", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "EE2E594E256805091E32C942BDF102D4")
    public long getLong(String property, long def) {
        Object value = super.get(property);
        {
            long var2BF4210A74E88C58627A5AE165A6F06C_991141303 = (((Long)value).longValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "long");
        addTaint(property.getTaint());
        addTaint(def);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1718102253 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1718102253;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.995 -0400", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "6C82EFD73AD548FC73F520B83946676C")
    public float getFloat(String property, float def) {
        Object value = super.get(property);
        {
            float varE4BF96DFE206165467C1A9039FCB9A6E_1045207307 = (((Float)value).floatValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "float");
        addTaint(property.getTaint());
        addTaint(def);
        float var546ADE640B6EDFBC8A086EF31347E768_468457308 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_468457308;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.995 -0400", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "02544DFA3A8E5B1C3489A98B0C8D40A1")
    public double getDouble(String property, double def) {
        Object value = super.get(property);
        {
            double varEDFD59838753B0C4E4C8E31575DD2EE2_1935269300 = (((Double)value).doubleValue());
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "double");
        addTaint(property.getTaint());
        addTaint(def);
        double varE8CD7DA078A86726031AD64F35F5A6C0_300425383 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_300425383;
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.996 -0400", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "518BB730A7F6CFED5A45844F3661059C")
    public String getString(String property, String def) {
        String varB4EAC82CA7396A68D541C85D26508E83_600369339 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1601441306 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_944983564 = null; 
        Object value = super.get(property);
        {
            varB4EAC82CA7396A68D541C85D26508E83_600369339 = def;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1601441306 = null;
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_944983564 = (String)value;
        } 
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "string");
        addTaint(property.getTaint());
        addTaint(def.getTaint());
        String varA7E53CE21691AB073D9660D615818899_437208056; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_437208056 = varB4EAC82CA7396A68D541C85D26508E83_600369339;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_437208056 = varB4EAC82CA7396A68D541C85D26508E83_1601441306;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_437208056 = varB4EAC82CA7396A68D541C85D26508E83_944983564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_437208056.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_437208056;
        
        
        
            
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.997 -0400", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "1FB38B20C02EE119360DDAAF8E50D4A4")
    public boolean getBoolean(String property) {
        boolean var388FDEBCBAD382EA0CA5866093D63382_609954316 = (getBoolean(property, false));
        addTaint(property.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1484039641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1484039641;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.997 -0400", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "D8E1B207D92494D97AE10FCA487515AD")
    public byte getByte(String property) {
        byte var7F0FFF5B8051771B4969E8BA35C4D305_2026408333 = (getByte(property, (byte)0));
        addTaint(property.getTaint());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_1641446502 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1641446502;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.997 -0400", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "50E8FDDFF9CD01997BA4DD301E3C88A7")
    public short getShort(String property) {
        short var61F0CFA8A6350C1C49F6594873C25E68_1920172822 = (getShort(property, (short)0));
        addTaint(property.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_925991428 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_925991428;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.997 -0400", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "C1CE01D0F8CCF185AAB55BA42963B73F")
    public int getInt(String property) {
        int var5E4DEF1A6D970073A28B08FAE5990986_1597616264 = (getInt(property, 0));
        addTaint(property.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719788197 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_719788197;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.998 -0400", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "33E3A4F4994410A6F74E58A10E69FAF0")
    public long getLong(String property) {
        long varF3B78247D366110C671AC1A4FCEF03B6_67019755 = (getLong(property, 0L));
        addTaint(property.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1476169550 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1476169550;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.998 -0400", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "BB4BBA76DC06BCE44A80DC4F71C90040")
    public float getFloat(String property) {
        float var08EA92EAF84AA2796A6B4604865FDC5E_1071162943 = (getFloat(property, 0.0f));
        addTaint(property.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_97414449 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_97414449;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.998 -0400", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "1A9DECA6085119C134713D2D0436D24C")
    public double getDouble(String property) {
        double varCD55CE0B79D03320287DEC79B3D7917E_521106297 = (getDouble(property, 0.0));
        addTaint(property.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1568274322 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1568274322;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.998 -0400", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "999B32B2ED0BC293AD29AAD264880CF3")
    public String getString(String property) {
        String varB4EAC82CA7396A68D541C85D26508E83_1519035011 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1519035011 = getString(property, "");
        addTaint(property.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1519035011.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1519035011;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.999 -0400", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "B58FA74DC75009835102C5DE2A08EBF9")
    public int getStringInfo(String property) {
        Object value = super.get(property);
        addTaint(property.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763045787 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763045787;
        
        
        
            
        
        
            
        
            
        
        
    }

    
    public static class ParseException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.999 -0400", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "12B5BA8B7ED997C9D0ADBB616ABDA118")
          ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
            addTaint(state.getTaint());
            addTaint(expected.getTaint());
            
        }

        
    }


    
    public static class TypeException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.999 -0400", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "016BE3813E68089E21CD5E928E0A56E6")
          TypeException(String property, Object value, String requestedType) {
            super(property + " has type " + value.getClass().getName() +
                ", not " + requestedType);
            addTaint(property.getTaint());
            addTaint(value.getTaint());
            addTaint(requestedType.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.999 -0400", hash_original_field = "3A718E6E8AB09C6754F8AB0221E65E20", hash_generated_field = "636FC1AE7A17ECC84638758548E6F26E")

    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.999 -0400", hash_original_field = "8BEE494A88E22DCABEE74AB284604CC7", hash_generated_field = "E1ACD2CFB22CAE29B9CA75C3973872EE")

    static final int TYPE_UNSET = 'x';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:32.999 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "E580A7D7D1050DD90A59D8546A666FFF")

    static final int TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "A8690542C0AB936750AA1E6687044E52", hash_generated_field = "6BE67BABA764A60D2B4FFE61896B284A")

    static final int TYPE_BYTE = 'I' | 1 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "90696F1E8ABEB0FEED1B6F2C4B47E1B8", hash_generated_field = "9A2BA086324E44D0FD861C86FC7A5A06")

    static final int TYPE_SHORT = 'I' | 2 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "0D96262233FDA3056EC39C2525472EED", hash_generated_field = "DA873A8AC9972659FE05932734984FC1")

    static final int TYPE_INT = 'I' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "BFE64E825AE82B22B575380A7CDD29C3", hash_generated_field = "69BA5615F8B78F22534B8C5C19228490")

    static final int TYPE_LONG = 'I' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "0DF111D0C091F889C4759ED9AD27A2BC", hash_generated_field = "ED0FC9DA000EBF50B25ED5400E99DA5D")

    static final int TYPE_FLOAT = 'F' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "20D27AE0ED1D92F1442681FB825E7E45", hash_generated_field = "5867595828327917045FEC3E185B8B83")

    static final int TYPE_DOUBLE = 'F' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "8D84765DDCB1613978CF4AD92E9CB971", hash_generated_field = "235CD5ED9F27E795117F17DF7BCAFA50")

    static final int TYPE_STRING = 'L' | 's' << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "E6C6E5779FBFA8F41BB41D93E7906B60", hash_generated_field = "1734EA463E0596C6DBE64154CCF362D1")

    static final int TYPE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "C7D8F11623D863085E5C58A402C4DC53", hash_generated_field = "83B21DDE04AFBBC067D3B1D2ABBE2EB9")

    public static final int STRING_TYPE_MISMATCH = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "AE02F525260A243A38AE270481D5B588", hash_generated_field = "00B47C8F77B363A29A3C021DA8F3516B")

    public static final int STRING_NOT_SET = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "A84984543701A93AF491BB6ED525A1D2", hash_generated_field = "E18A84E3EBC448C32F75BCB5481CA863")

    public static final int STRING_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:33.000 -0400", hash_original_field = "4E91184683D8761F7BD0C10F98F6C48F", hash_generated_field = "72988529DEBF8FACA5F4299D7353C743")

    public static final int STRING_SET = 1;
}

