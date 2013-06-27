package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TypedProperties extends HashMap<String, Object> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.065 -0400", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "B248ACEE9001880DCCB88F00DD01C611")
    public  TypedProperties() {
        super();
        // ---------- Original Method ----------
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.066 -0400", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "D00A13F2BF825310240AF8D8220CE5B0")
    public void load(Reader r) throws IOException {
        parse(r, this);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //parse(r, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.067 -0400", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "ED9F2CCEEE85AE3AF92B88AE5C8962D8")
    @Override
    public Object get(Object key) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1865622013 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1520534879 = null; //Variable for return #2
        Object value;
        value = super.get(key);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1865622013 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1520534879 = value;
        addTaint(key.getTaint());
        Object varA7E53CE21691AB073D9660D615818899_1349781974; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1349781974 = varB4EAC82CA7396A68D541C85D26508E83_1865622013;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1349781974 = varB4EAC82CA7396A68D541C85D26508E83_1520534879;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1349781974.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1349781974;
        // ---------- Original Method ----------
        //Object value = super.get(key);
        //if (value == NULL_STRING) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.067 -0400", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "B06B77FC58865CB7CFA1BA13C2AFE7DA")
    public boolean getBoolean(String property, boolean def) {
        Object value;
        value = super.get(property);
        {
            boolean var28F7FA156A0AF9E80777EF1AC0FADFEE_1227164861 = (((Boolean)value).booleanValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "boolean");
        addTaint(property.getTaint());
        addTaint(def);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1237575407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1237575407;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Boolean) {
            //return ((Boolean)value).booleanValue();
        //}
        //throw new TypeException(property, value, "boolean");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.080 -0400", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "D8617E2F6A67F1857E2603707F8806E7")
    public byte getByte(String property, byte def) {
        Object value;
        value = super.get(property);
        {
            byte var2006B69F4737BD108E2C51959A456F7A_442969950 = (((Byte)value).byteValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "byte");
        addTaint(property.getTaint());
        addTaint(def);
        byte var40EA57D3EE3C07BF1C102B466E1C3091_787363084 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_787363084;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Byte) {
            //return ((Byte)value).byteValue();
        //}
        //throw new TypeException(property, value, "byte");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.081 -0400", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "A4C5F0A146A924883A021A14347A9529")
    public short getShort(String property, short def) {
        Object value;
        value = super.get(property);
        {
            short varFA0267FA29F4ECA5E451C256453D307B_1004118771 = (((Short)value).shortValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "short");
        addTaint(property.getTaint());
        addTaint(def);
        short var4F09DAA9D95BCB166A302407A0E0BABE_1701532960 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_1701532960;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Short) {
            //return ((Short)value).shortValue();
        //}
        //throw new TypeException(property, value, "short");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.082 -0400", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "34DD1734AC3733847365064450085AD5")
    public int getInt(String property, int def) {
        Object value;
        value = super.get(property);
        {
            int var2BBA3283F2CE0451B65410804794C972_577585457 = (((Integer)value).intValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "int");
        addTaint(property.getTaint());
        addTaint(def);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718550156 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718550156;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Integer) {
            //return ((Integer)value).intValue();
        //}
        //throw new TypeException(property, value, "int");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.083 -0400", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "6E03A8AB4D4938EC6A50B253EFF361C7")
    public long getLong(String property, long def) {
        Object value;
        value = super.get(property);
        {
            long var2BF4210A74E88C58627A5AE165A6F06C_559474210 = (((Long)value).longValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "long");
        addTaint(property.getTaint());
        addTaint(def);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_998152291 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_998152291;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Long) {
            //return ((Long)value).longValue();
        //}
        //throw new TypeException(property, value, "long");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.083 -0400", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "00ECEEBF2AEF8C5390FA2551950FBC60")
    public float getFloat(String property, float def) {
        Object value;
        value = super.get(property);
        {
            float varE4BF96DFE206165467C1A9039FCB9A6E_1566452308 = (((Float)value).floatValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "float");
        addTaint(property.getTaint());
        addTaint(def);
        float var546ADE640B6EDFBC8A086EF31347E768_54097118 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_54097118;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Float) {
            //return ((Float)value).floatValue();
        //}
        //throw new TypeException(property, value, "float");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.083 -0400", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "86D078750911649FC5E91FBDC143C24E")
    public double getDouble(String property, double def) {
        Object value;
        value = super.get(property);
        {
            double varEDFD59838753B0C4E4C8E31575DD2EE2_2069879383 = (((Double)value).doubleValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "double");
        addTaint(property.getTaint());
        addTaint(def);
        double varE8CD7DA078A86726031AD64F35F5A6C0_1559462877 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1559462877;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value instanceof Double) {
            //return ((Double)value).doubleValue();
        //}
        //throw new TypeException(property, value, "double");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.097 -0400", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "82C0B27EF7FEE65DE2047065B82F25DF")
    public String getString(String property, String def) {
        String varB4EAC82CA7396A68D541C85D26508E83_52885701 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_955381074 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1145535778 = null; //Variable for return #3
        Object value;
        value = super.get(property);
        {
            varB4EAC82CA7396A68D541C85D26508E83_52885701 = def;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_955381074 = null;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1145535778 = (String)value;
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "string");
        addTaint(property.getTaint());
        addTaint(def.getTaint());
        String varA7E53CE21691AB073D9660D615818899_1695465702; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1695465702 = varB4EAC82CA7396A68D541C85D26508E83_52885701;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1695465702 = varB4EAC82CA7396A68D541C85D26508E83_955381074;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1695465702 = varB4EAC82CA7396A68D541C85D26508E83_1145535778;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1695465702.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1695465702;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return def;
        //}
        //if (value == NULL_STRING) {
            //return null;
        //} else if (value instanceof String) {
            //return (String)value;
        //}
        //throw new TypeException(property, value, "string");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.098 -0400", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "9C6884A127836CA6638FEDCCA6066C27")
    public boolean getBoolean(String property) {
        boolean var388FDEBCBAD382EA0CA5866093D63382_801822660 = (getBoolean(property, false));
        addTaint(property.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1303382533 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1303382533;
        // ---------- Original Method ----------
        //return getBoolean(property, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.098 -0400", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "4E2070390A417E916D2FD89FEB4AACCD")
    public byte getByte(String property) {
        byte var7F0FFF5B8051771B4969E8BA35C4D305_858305201 = (getByte(property, (byte)0));
        addTaint(property.getTaint());
        byte var40EA57D3EE3C07BF1C102B466E1C3091_260385213 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_260385213;
        // ---------- Original Method ----------
        //return getByte(property, (byte)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.098 -0400", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "52F21F474E84CB08FAA876C1698DD514")
    public short getShort(String property) {
        short var61F0CFA8A6350C1C49F6594873C25E68_193224300 = (getShort(property, (short)0));
        addTaint(property.getTaint());
        short var4F09DAA9D95BCB166A302407A0E0BABE_945053499 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_945053499;
        // ---------- Original Method ----------
        //return getShort(property, (short)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.098 -0400", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "87A00481B2EBB677FF6B95AE42C4A382")
    public int getInt(String property) {
        int var5E4DEF1A6D970073A28B08FAE5990986_602710044 = (getInt(property, 0));
        addTaint(property.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1731419861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1731419861;
        // ---------- Original Method ----------
        //return getInt(property, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.099 -0400", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "21605325207BF4E9BA5C5C593453BDE9")
    public long getLong(String property) {
        long varF3B78247D366110C671AC1A4FCEF03B6_1166862900 = (getLong(property, 0L));
        addTaint(property.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_643513596 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_643513596;
        // ---------- Original Method ----------
        //return getLong(property, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.099 -0400", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "44D9FD6986F7CB8A9A474EFF1E53F2F6")
    public float getFloat(String property) {
        float var08EA92EAF84AA2796A6B4604865FDC5E_227675877 = (getFloat(property, 0.0f));
        addTaint(property.getTaint());
        float var546ADE640B6EDFBC8A086EF31347E768_948724444 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_948724444;
        // ---------- Original Method ----------
        //return getFloat(property, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.099 -0400", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "85B471CBA70631398317F6B520ED9344")
    public double getDouble(String property) {
        double varCD55CE0B79D03320287DEC79B3D7917E_1506555617 = (getDouble(property, 0.0));
        addTaint(property.getTaint());
        double varE8CD7DA078A86726031AD64F35F5A6C0_1202035758 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1202035758;
        // ---------- Original Method ----------
        //return getDouble(property, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.100 -0400", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "6312EF7B6C42F895240A586A7B8C8D37")
    public String getString(String property) {
        String varB4EAC82CA7396A68D541C85D26508E83_897156359 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_897156359 = getString(property, "");
        addTaint(property.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_897156359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_897156359;
        // ---------- Original Method ----------
        //return getString(property, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.107 -0400", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "312E4C2B7E1938D035BF5EC4B5558DDF")
    public int getStringInfo(String property) {
        Object value;
        value = super.get(property);
        addTaint(property.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249516321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_249516321;
        // ---------- Original Method ----------
        //Object value = super.get(property);
        //if (value == null) {
            //return STRING_NOT_SET;
        //}
        //if (value == NULL_STRING) {
            //return STRING_NULL;
        //} else if (value instanceof String) {
            //return STRING_SET;
        //}
        //return STRING_TYPE_MISMATCH;
    }

    
    public static class ParseException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.107 -0400", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "12B5BA8B7ED997C9D0ADBB616ABDA118")
          ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
            addTaint(state.getTaint());
            addTaint(expected.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class TypeException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "016BE3813E68089E21CD5E928E0A56E6")
          TypeException(String property, Object value, String requestedType) {
            super(property + " has type " + value.getClass().getName() +
                ", not " + requestedType);
            addTaint(property.getTaint());
            addTaint(value.getTaint());
            addTaint(requestedType.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "3A718E6E8AB09C6754F8AB0221E65E20", hash_generated_field = "40E9B03FADB1D9F3C24CC6E5C006D850")

    static String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "8BEE494A88E22DCABEE74AB284604CC7", hash_generated_field = "C04A990D3F3FAAFD8A5EA749AFB5D941")

    static int TYPE_UNSET = 'x';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "86A0F7D1D20E6B057DC1E5D1DD5FA46C")

    static int TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "A8690542C0AB936750AA1E6687044E52", hash_generated_field = "7E37769AF6C51ABB0E3F6C607D885F90")

    static int TYPE_BYTE = 'I' | 1 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "90696F1E8ABEB0FEED1B6F2C4B47E1B8", hash_generated_field = "D0BFA4620C0A533DE7B30E604889EC43")

    static int TYPE_SHORT = 'I' | 2 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "0D96262233FDA3056EC39C2525472EED", hash_generated_field = "2BE17E1ECED9D3AC0E3F985D30975FCB")

    static int TYPE_INT = 'I' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "BFE64E825AE82B22B575380A7CDD29C3", hash_generated_field = "2989EF4FE3F2B30E0108C548BB87E2DF")

    static int TYPE_LONG = 'I' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "0DF111D0C091F889C4759ED9AD27A2BC", hash_generated_field = "BB7AC28DEC8D5897929FD0112DD2BAF6")

    static int TYPE_FLOAT = 'F' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "20D27AE0ED1D92F1442681FB825E7E45", hash_generated_field = "E3C7442DBA6D408F71D16431D4BB62B3")

    static int TYPE_DOUBLE = 'F' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "8D84765DDCB1613978CF4AD92E9CB971", hash_generated_field = "83BF2E11527A33B777FF9E65A48E3A6E")

    static int TYPE_STRING = 'L' | 's' << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "E6C6E5779FBFA8F41BB41D93E7906B60", hash_generated_field = "149CC4ACF7BC21E3296D45058C189D60")

    static int TYPE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "C7D8F11623D863085E5C58A402C4DC53", hash_generated_field = "83B21DDE04AFBBC067D3B1D2ABBE2EB9")

    public static final int STRING_TYPE_MISMATCH = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "AE02F525260A243A38AE270481D5B588", hash_generated_field = "00B47C8F77B363A29A3C021DA8F3516B")

    public static final int STRING_NOT_SET = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "A84984543701A93AF491BB6ED525A1D2", hash_generated_field = "E18A84E3EBC448C32F75BCB5481CA863")

    public static final int STRING_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:25.108 -0400", hash_original_field = "4E91184683D8761F7BD0C10F98F6C48F", hash_generated_field = "72988529DEBF8FACA5F4299D7353C743")

    public static final int STRING_SET = 1;
}

