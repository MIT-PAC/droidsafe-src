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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.888 -0400", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "B248ACEE9001880DCCB88F00DD01C611")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TypedProperties() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.889 -0400", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "B0F1021C69DC55C4E33DFB14CA289A1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void load(Reader r) throws IOException {
        dsTaint.addTaint(r.dsTaint);
        parse(r, this);
        // ---------- Original Method ----------
        //parse(r, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.889 -0400", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "CA49FF8D3FBB33308CDFB12A62AD2F9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.889 -0400", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "C3C233AD63C02E1023ED72512A873D5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String property, boolean def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            boolean var28F7FA156A0AF9E80777EF1AC0FADFEE_1870465994 = (((Boolean)value).booleanValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.890 -0400", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "DD78C8CE1DEF7A3A78E006961467D7FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByte(String property, byte def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            byte var2006B69F4737BD108E2C51959A456F7A_125054264 = (((Byte)value).byteValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.890 -0400", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "3CA3B1F70194A68484A7D39B7ACD6071")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(String property, short def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            short varFA0267FA29F4ECA5E451C256453D307B_2141810603 = (((Short)value).shortValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.890 -0400", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "F6973174EF84A7BDC37D4C153F2997B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String property, int def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            int var2BBA3283F2CE0451B65410804794C972_1417331837 = (((Integer)value).intValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.890 -0400", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "C2185ED11DE407E1B1D05F08BF31513F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String property, long def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            long var2BF4210A74E88C58627A5AE165A6F06C_1780827168 = (((Long)value).longValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.891 -0400", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "55CA588B3E36A085FEF1B63F87536A06")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(String property, float def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            float varE4BF96DFE206165467C1A9039FCB9A6E_1519341070 = (((Float)value).floatValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.899 -0400", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "DE61E4F8EA7278D682448FE6D78AC895")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(String property, double def) {
        dsTaint.addTaint(def);
        dsTaint.addTaint(property);
        Object value;
        value = super.get(property);
        {
            double varEDFD59838753B0C4E4C8E31575DD2EE2_1501964683 = (((Double)value).doubleValue());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.899 -0400", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "4AEA82E6667BFBA83CA23E55C7896CEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.902 -0400", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "B3508F1A8FBA992E75BE2CA2C69A5DD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean getBoolean(String property) {
        dsTaint.addTaint(property);
        boolean var388FDEBCBAD382EA0CA5866093D63382_725932301 = (getBoolean(property, false));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return getBoolean(property, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.902 -0400", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "3C601160A2030ECD345664752EDAC59E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte getByte(String property) {
        dsTaint.addTaint(property);
        byte var7F0FFF5B8051771B4969E8BA35C4D305_1985008233 = (getByte(property, (byte)0));
        return dsTaint.getTaintByte();
        // ---------- Original Method ----------
        //return getByte(property, (byte)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.902 -0400", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "98EA92D53CC8BFF0CBC9B25966D40AF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public short getShort(String property) {
        dsTaint.addTaint(property);
        short var61F0CFA8A6350C1C49F6594873C25E68_932396916 = (getShort(property, (short)0));
        return dsTaint.getTaintShort();
        // ---------- Original Method ----------
        //return getShort(property, (short)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.903 -0400", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "6EEDE7F243B47415B715E1365D33BDA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getInt(String property) {
        dsTaint.addTaint(property);
        int var5E4DEF1A6D970073A28B08FAE5990986_1137442125 = (getInt(property, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getInt(property, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.903 -0400", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "1E36F3D064A41B5EEF64DCC79694341F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getLong(String property) {
        dsTaint.addTaint(property);
        long varF3B78247D366110C671AC1A4FCEF03B6_159182580 = (getLong(property, 0L));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return getLong(property, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.903 -0400", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "46F4F7ACC05E1A81E44465C5DD729645")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getFloat(String property) {
        dsTaint.addTaint(property);
        float var08EA92EAF84AA2796A6B4604865FDC5E_144120433 = (getFloat(property, 0.0f));
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return getFloat(property, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.903 -0400", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "83A0BF0E40328DF7CDE7989A253387AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public double getDouble(String property) {
        dsTaint.addTaint(property);
        double varCD55CE0B79D03320287DEC79B3D7917E_1739545932 = (getDouble(property, 0.0));
        return dsTaint.getTaintDouble();
        // ---------- Original Method ----------
        //return getDouble(property, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.904 -0400", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "61765D4F0F6C768EE40741CA53D661F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getString(String property) {
        dsTaint.addTaint(property);
        String var0422C1DF2C2BBC8057AC3DCCC52CD763_172729851 = (getString(property, ""));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getString(property, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.904 -0400", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "C926EA6D901487F2940E4F7CC3699B76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.905 -0400", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "219E77BF06699DADBA1012E3BA723D55")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
            dsTaint.addTaint(expected);
            dsTaint.addTaint(state.dsTaint);
            // ---------- Original Method ----------
        }

        
    }


    
    public static class TypeException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.906 -0400", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "442CDF16B240759BA1BA7BE71F64A398")
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


    
    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    static final int TYPE_UNSET = 'x';
    static final int TYPE_BOOLEAN = 'Z';
    static final int TYPE_BYTE = 'I' | 1 << 8;
    static final int TYPE_SHORT = 'I' | 2 << 8;
    static final int TYPE_INT = 'I' | 4 << 8;
    static final int TYPE_LONG = 'I' | 8 << 8;
    static final int TYPE_FLOAT = 'F' | 4 << 8;
    static final int TYPE_DOUBLE = 'F' | 8 << 8;
    static final int TYPE_STRING = 'L' | 's' << 8;
    static final int TYPE_ERROR = -1;
    public static final int STRING_TYPE_MISMATCH = -2;
    public static final int STRING_NOT_SET = -1;
    public static final int STRING_NULL = 0;
    public static final int STRING_SET = 1;
}

