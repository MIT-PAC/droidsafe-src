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
    static String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    static int TYPE_UNSET = 'x';
    static int TYPE_BOOLEAN = 'Z';
    static int TYPE_BYTE = 'I' | 1 << 8;
    static int TYPE_SHORT = 'I' | 2 << 8;
    static int TYPE_INT = 'I' | 4 << 8;
    static int TYPE_LONG = 'I' | 8 << 8;
    static int TYPE_FLOAT = 'F' | 4 << 8;
    static int TYPE_DOUBLE = 'F' | 8 << 8;
    static int TYPE_STRING = 'L' | 's' << 8;
    static int TYPE_ERROR = -1;
    public static int STRING_TYPE_MISMATCH = -2;
    public static int STRING_NOT_SET = -1;
    public static int STRING_NULL = 0;
    public static int STRING_SET = 1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.706 -0400", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "99D98552C9EB13C233788EF3DBD93E56")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedProperties() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.727 -0400", hash_original_method = "21E5AE23294866B670D117774FF68B3C", hash_generated_method = "4E2718A6CE6F8281E96AE0770650B41B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.749 -0400", hash_original_method = "EF4819B29F3C178C4F6AF68711CF0B83", hash_generated_method = "C3543B83099E9A7A72D521A601682F75")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.754 -0400", hash_original_method = "785911ECAA138D2E7940B3C09FD49889", hash_generated_method = "ACED3B398D9F106AF32A8739882C8F9C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.790 -0400", hash_original_method = "9638F79FD1E953ECB07B4D80F472AAE0", hash_generated_method = "3E34D9E49FC438C8BA1C8D2DB6CBB0CB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.834 -0400", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "EC2909D08363E9B24643A2874C5B8E27")
    @DSModeled(DSC.SAFE)
    public void load(Reader r) throws IOException {
        dsTaint.addTaint(r.dsTaint);
        parse(r, this);
        // ---------- Original Method ----------
        //parse(r, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.887 -0400", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "8F3D8C2DAD00A308A93A7FC3EE9A8C44")
    @DSModeled(DSC.SAFE)
    @Override
    public Object get(Object key) {
        dsTaint.addTaint(key.dsTaint);
        Object value;
        value = super.get(key);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Object value = super.get(key);
        //if (value == NULL_STRING) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.902 -0400", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "EDEE4FC9E56C97C116BA56D7A0C0A4E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String property, boolean def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            boolean var28F7FA156A0AF9E80777EF1AC0FADFEE_1315231404 = (((Boolean)value).booleanValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "boolean");
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.024 -0400", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "EE5EBAF953C64948E8886D822CD344FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByte(String property, byte def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            byte var2006B69F4737BD108E2C51959A456F7A_93244077 = (((Byte)value).byteValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "byte");
        return dsTaint.getTaintByte();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.129 -0400", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "3118D086FF2C1BE264A966D530AF1EE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(String property, short def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            short varFA0267FA29F4ECA5E451C256453D307B_2104450665 = (((Short)value).shortValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "short");
        return dsTaint.getTaintShort();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.184 -0400", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "A16B82490056FC20B624087A0926C227")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String property, int def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            int var2BBA3283F2CE0451B65410804794C972_870256581 = (((Integer)value).intValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "int");
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.233 -0400", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "FEE3B613A7FAFDB00E2C422934AB8FB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String property, long def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            long var2BF4210A74E88C58627A5AE165A6F06C_1075527239 = (((Long)value).longValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "long");
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.282 -0400", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "9EBF93D8672E2214BFA93D63789E56EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(String property, float def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            float varE4BF96DFE206165467C1A9039FCB9A6E_765396105 = (((Float)value).floatValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "float");
        return dsTaint.getTaintFloat();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.309 -0400", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "62FC55299E50953061AADE333F6EACED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(String property, double def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            double varEDFD59838753B0C4E4C8E31575DD2EE2_1179388281 = (((Double)value).doubleValue());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "double");
        return dsTaint.getTaintDouble();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.350 -0400", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "ADAB89328D533F140019BD6503CF55FF")
    @DSModeled(DSC.SAFE)
    public String getString(String property, String def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        if (DroidSafeAndroidRuntime.control) throw new TypeException(property, value, "string");
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.370 -0400", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "CF9033AFC4D4A4B5A4C3DC70AE0EE91F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String property) {
        dsTaint.addTaint(property);
        boolean var388FDEBCBAD382EA0CA5866093D63382_1748853800 = (getBoolean(property, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBoolean(property, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.387 -0400", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "00ECC18DFCE5D22C1DF07AB081B928BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByte(String property) {
        dsTaint.addTaint(property);
        byte var7F0FFF5B8051771B4969E8BA35C4D305_1758375841 = (getByte(property, (byte)0));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return getByte(property, (byte)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.438 -0400", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "8915382D75203663B0DD90E4A9CD70F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(String property) {
        dsTaint.addTaint(property);
        short var61F0CFA8A6350C1C49F6594873C25E68_1006444724 = (getShort(property, (short)0));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return getShort(property, (short)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.476 -0400", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "5BE6C9AC51DBD7F70CE0C9541479F705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String property) {
        dsTaint.addTaint(property);
        int var5E4DEF1A6D970073A28B08FAE5990986_1528831853 = (getInt(property, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getInt(property, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.502 -0400", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "11F1470CAAFD82B9394647C8C03F3A38")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String property) {
        dsTaint.addTaint(property);
        long varF3B78247D366110C671AC1A4FCEF03B6_1868738984 = (getLong(property, 0L));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getLong(property, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.535 -0400", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "81470844D3D3111CFA9FC4B9EBC2D29D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(String property) {
        dsTaint.addTaint(property);
        float var08EA92EAF84AA2796A6B4604865FDC5E_1271993547 = (getFloat(property, 0.0f));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getFloat(property, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.559 -0400", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "6B7FD45EA055CEB51BBBB851B5E97CC7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(String property) {
        dsTaint.addTaint(property);
        double varCD55CE0B79D03320287DEC79B3D7917E_262740646 = (getDouble(property, 0.0));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return getDouble(property, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.585 -0400", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "22E1262F1409C78641FE70CE8DBEDF91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(String property) {
        dsTaint.addTaint(property);
        String var0422C1DF2C2BBC8057AC3DCCC52CD763_2147337094 = (getString(property, ""));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getString(property, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.638 -0400", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "34387AAB99CA735405460C024BC988B9")
    @DSModeled(DSC.SAFE)
    public int getStringInfo(String property) {
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        return dsTaint.getTaintInt();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.668 -0400", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "4001592C4EB837CD9E39243731C8D81F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
            dsTaint.addTaint(expected);
            dsTaint.addTaint(state.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class TypeException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:48.676 -0400", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "A97F74D358130CB999DC204E87C81164")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         TypeException(String property, Object value, String requestedType) {
            super(property + " has type " + value.getClass().getName() +
                ", not " + requestedType);
            dsTaint.addTaint(value.dsTaint);
            dsTaint.addTaint(property);
            dsTaint.addTaint(requestedType);
            // ---------- Original Method ----------
        }

        
    }


    
}


