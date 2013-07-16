package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class TypedProperties extends HashMap<String, Object> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.957 -0400", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "B248ACEE9001880DCCB88F00DD01C611")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.960 -0400", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "69300B76275FA1D07475FDA099F68801")
    public void load(Reader r) throws IOException {
        addTaint(r.getTaint());
        parse(r, this);
        // ---------- Original Method ----------
        //parse(r, this);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.960 -0400", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "AE82895C51F80670D30106DEDB3CB83B")
    @Override
    public Object get(Object key) {
        addTaint(key.getTaint());
        Object value = super.get(key);
    if(value == NULL_STRING)        
        {
Object var540C13E9E156B687226421B24F2DF178_1468541273 =             null;
            var540C13E9E156B687226421B24F2DF178_1468541273.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1468541273;
        } //End block
Object varAF280DA2BC37D8BE783D8499160168DE_1459184988 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1459184988.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1459184988;
        // ---------- Original Method ----------
        //Object value = super.get(key);
        //if (value == NULL_STRING) {
            //return null;
        //}
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.960 -0400", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "09E675647EFEBEC14109FBB05AEEA3A6")
    public boolean getBoolean(String property, boolean def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            boolean var4ED9407630EB1000C0F6B63842DEFA7D_1310237414 = (def);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1026384525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1026384525;
        } //End block
    if(value instanceof Boolean)        
        {
            boolean varBC26109FD0D926BA548E7B8E99E609D9_4312216 = (((Boolean)value).booleanValue());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865886975 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_865886975;
        } //End block
        TypeException var805FC76681DEDC2E36CC0BB21EC1A30E_1098188743 = new TypeException(property, value, "boolean");
        var805FC76681DEDC2E36CC0BB21EC1A30E_1098188743.addTaint(taint);
        throw var805FC76681DEDC2E36CC0BB21EC1A30E_1098188743;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.961 -0400", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "B5566E44159C2EA21CFEB8AEAB484ED9")
    public byte getByte(String property, byte def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            byte var4ED9407630EB1000C0F6B63842DEFA7D_379125462 = (def);
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_1941934932 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_1941934932;
        } //End block
    if(value instanceof Byte)        
        {
            byte var35348045D56C47B658DEA945656F8AB7_1899853726 = (((Byte)value).byteValue());
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_524977587 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_524977587;
        } //End block
        TypeException varFA332DAFF3AC9BC520CDDB2CC83F6468_727646304 = new TypeException(property, value, "byte");
        varFA332DAFF3AC9BC520CDDB2CC83F6468_727646304.addTaint(taint);
        throw varFA332DAFF3AC9BC520CDDB2CC83F6468_727646304;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.961 -0400", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "4957634CA79F41017451B55DCB663389")
    public short getShort(String property, short def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            short var4ED9407630EB1000C0F6B63842DEFA7D_2143566727 = (def);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_1384266092 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_1384266092;
        } //End block
    if(value instanceof Short)        
        {
            short varBC17CBC160D99E82160E3FB34D373031_332908911 = (((Short)value).shortValue());
                        short var4F09DAA9D95BCB166A302407A0E0BABE_1516739332 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_1516739332;
        } //End block
        TypeException varC16218961456E8C504AD0F5969DBBA4E_173234992 = new TypeException(property, value, "short");
        varC16218961456E8C504AD0F5969DBBA4E_173234992.addTaint(taint);
        throw varC16218961456E8C504AD0F5969DBBA4E_173234992;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.962 -0400", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "56B6046AC34C8E004213A1EE74F4E241")
    public int getInt(String property, int def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            int var4ED9407630EB1000C0F6B63842DEFA7D_284237089 = (def);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074263208 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1074263208;
        } //End block
    if(value instanceof Integer)        
        {
            int varC887A84560F2A8EFD700BC80AB572403_865067166 = (((Integer)value).intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802249119 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802249119;
        } //End block
        TypeException varD6080985D485A0D220638E1A1D7F8E6B_1099453733 = new TypeException(property, value, "int");
        varD6080985D485A0D220638E1A1D7F8E6B_1099453733.addTaint(taint);
        throw varD6080985D485A0D220638E1A1D7F8E6B_1099453733;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.962 -0400", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "08687F7C8013CD82AF30D01735B3B963")
    public long getLong(String property, long def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            long var4ED9407630EB1000C0F6B63842DEFA7D_179647119 = (def);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_608880805 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_608880805;
        } //End block
    if(value instanceof Long)        
        {
            long var6A7295A730E93D60401BA7C11CED8342_957734010 = (((Long)value).longValue());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_487390166 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_487390166;
        } //End block
        TypeException var70EE1BF703E76CCF216D91244CD5D8EB_2056826536 = new TypeException(property, value, "long");
        var70EE1BF703E76CCF216D91244CD5D8EB_2056826536.addTaint(taint);
        throw var70EE1BF703E76CCF216D91244CD5D8EB_2056826536;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.963 -0400", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "7A63CF56F5B3915AB7AC7AEFA233AB21")
    public float getFloat(String property, float def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            float var4ED9407630EB1000C0F6B63842DEFA7D_1229306893 = (def);
                        float var546ADE640B6EDFBC8A086EF31347E768_1026250897 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1026250897;
        } //End block
    if(value instanceof Float)        
        {
            float var86A11069791AE9DD813EDB7FB244EF59_1143232504 = (((Float)value).floatValue());
                        float var546ADE640B6EDFBC8A086EF31347E768_1072443225 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1072443225;
        } //End block
        TypeException varF6F8A1C3A685815745BED356E7A54870_1764074532 = new TypeException(property, value, "float");
        varF6F8A1C3A685815745BED356E7A54870_1764074532.addTaint(taint);
        throw varF6F8A1C3A685815745BED356E7A54870_1764074532;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.963 -0400", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "32D0E945E0F674687637BE2F0C25A350")
    public double getDouble(String property, double def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            double var4ED9407630EB1000C0F6B63842DEFA7D_586935553 = (def);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_441175209 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_441175209;
        } //End block
    if(value instanceof Double)        
        {
            double var7B9B10BAB0658D50E2E730FEA63F2E53_403368577 = (((Double)value).doubleValue());
                        double varE8CD7DA078A86726031AD64F35F5A6C0_603614562 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_603614562;
        } //End block
        TypeException var01C5E7F897D5B2010CD911DD5902A148_314484927 = new TypeException(property, value, "double");
        var01C5E7F897D5B2010CD911DD5902A148_314484927.addTaint(taint);
        throw var01C5E7F897D5B2010CD911DD5902A148_314484927;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.964 -0400", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "816A5E12C1624478DD6AF1AD69493339")
    public String getString(String property, String def) {
        addTaint(def.getTaint());
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
String var9EA315D7588BA8DB5A3E312497990346_221001801 =             def;
            var9EA315D7588BA8DB5A3E312497990346_221001801.addTaint(taint);
            return var9EA315D7588BA8DB5A3E312497990346_221001801;
        } //End block
    if(value == NULL_STRING)        
        {
String var540C13E9E156B687226421B24F2DF178_1022692318 =             null;
            var540C13E9E156B687226421B24F2DF178_1022692318.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1022692318;
        } //End block
        else
    if(value instanceof String)        
        {
String var39E2DC4C41DC437ADA614281BF13F76E_447698670 =             (String)value;
            var39E2DC4C41DC437ADA614281BF13F76E_447698670.addTaint(taint);
            return var39E2DC4C41DC437ADA614281BF13F76E_447698670;
        } //End block
        TypeException varF6E7BAB97C0421CD0B5E979DA1F90E27_433036969 = new TypeException(property, value, "string");
        varF6E7BAB97C0421CD0B5E979DA1F90E27_433036969.addTaint(taint);
        throw varF6E7BAB97C0421CD0B5E979DA1F90E27_433036969;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.964 -0400", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "5497C83C69CC43FDFFC921101CE96685")
    public boolean getBoolean(String property) {
        addTaint(property.getTaint());
        boolean var529988CA16C5F5802282EAD0E30C140A_932554756 = (getBoolean(property, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_489441126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_489441126;
        // ---------- Original Method ----------
        //return getBoolean(property, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.964 -0400", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "1A60B251B50E2BA1B7BF5FCF714512B0")
    public byte getByte(String property) {
        addTaint(property.getTaint());
        byte varC9B8276C3E1D7595B77771EE3F0087F0_147352362 = (getByte(property, (byte)0));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_2108101505 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_2108101505;
        // ---------- Original Method ----------
        //return getByte(property, (byte)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.965 -0400", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "4A4802CC6D1D65E43BCF60D992FF86A3")
    public short getShort(String property) {
        addTaint(property.getTaint());
        short var4B052920E7CCC9197C31F3A2450C4E1C_3380518 = (getShort(property, (short)0));
                short var4F09DAA9D95BCB166A302407A0E0BABE_163947035 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_163947035;
        // ---------- Original Method ----------
        //return getShort(property, (short)0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.965 -0400", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "E538D1B5D9561D115553FF6A17520C42")
    public int getInt(String property) {
        addTaint(property.getTaint());
        int var86D5DBE0AC915FEAEA96C1A01E1FA9EE_114544575 = (getInt(property, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442736980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_442736980;
        // ---------- Original Method ----------
        //return getInt(property, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.965 -0400", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "1EA95FE26B5F0257F6D2DFC240C0C6D5")
    public long getLong(String property) {
        addTaint(property.getTaint());
        long varE66401AC426032A8470C9A94550AD9F3_910791570 = (getLong(property, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1939989898 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1939989898;
        // ---------- Original Method ----------
        //return getLong(property, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.966 -0400", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "EDE614AA2D236BB42FA74FC3493281A8")
    public float getFloat(String property) {
        addTaint(property.getTaint());
        float var0D7442006E3760390B764A317DB2FEE7_887283120 = (getFloat(property, 0.0f));
                float var546ADE640B6EDFBC8A086EF31347E768_1144299857 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1144299857;
        // ---------- Original Method ----------
        //return getFloat(property, 0.0f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.966 -0400", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "363BB5632C9189C68D4241593E7DDF0A")
    public double getDouble(String property) {
        addTaint(property.getTaint());
        double var2B9ADFF79C4BD15579BD19CD22C6939C_1387079151 = (getDouble(property, 0.0));
                double varE8CD7DA078A86726031AD64F35F5A6C0_738517695 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_738517695;
        // ---------- Original Method ----------
        //return getDouble(property, 0.0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.966 -0400", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "4909DA310CB1BBD3F3976E2292ACD075")
    public String getString(String property) {
        addTaint(property.getTaint());
String var7A5DD373B6F6A93BF1E779B195389AB3_859114418 =         getString(property, "");
        var7A5DD373B6F6A93BF1E779B195389AB3_859114418.addTaint(taint);
        return var7A5DD373B6F6A93BF1E779B195389AB3_859114418;
        // ---------- Original Method ----------
        //return getString(property, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.967 -0400", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "C60CA176C623B14B3D5D71283745D395")
    public int getStringInfo(String property) {
        addTaint(property.getTaint());
        Object value = super.get(property);
    if(value == null)        
        {
            int varE3B52244A591230772525EE907D6F277_2093567123 = (STRING_NOT_SET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334403873 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1334403873;
        } //End block
    if(value == NULL_STRING)        
        {
            int var54E9B3628DE5BAA0D9FC0A2268227499_1986688458 = (STRING_NULL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712855096 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712855096;
        } //End block
        else
    if(value instanceof String)        
        {
            int var12D656F886AA19C138EA79FB0A61AE8D_704241693 = (STRING_SET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003361922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003361922;
        } //End block
        int varF5D0E3DA79184C510C9C08B8BA755031_807726476 = (STRING_TYPE_MISMATCH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664078247 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_664078247;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.967 -0400", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "A8983884B495BA3B97B314285EB42E8F")
          ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
            addTaint(expected.getTaint());
            addTaint(state.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class TypeException extends IllegalArgumentException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "D8A96D8861D95E88CC89251CEBCEE702")
          TypeException(String property, Object value, String requestedType) {
            super(property + " has type " + value.getClass().getName() +
                ", not " + requestedType);
            addTaint(requestedType.getTaint());
            addTaint(value.getTaint());
            addTaint(property.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "3A718E6E8AB09C6754F8AB0221E65E20", hash_generated_field = "636FC1AE7A17ECC84638758548E6F26E")

    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "8BEE494A88E22DCABEE74AB284604CC7", hash_generated_field = "E1ACD2CFB22CAE29B9CA75C3973872EE")

    static final int TYPE_UNSET = 'x';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "E580A7D7D1050DD90A59D8546A666FFF")

    static final int TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "A8690542C0AB936750AA1E6687044E52", hash_generated_field = "6BE67BABA764A60D2B4FFE61896B284A")

    static final int TYPE_BYTE = 'I' | 1 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "90696F1E8ABEB0FEED1B6F2C4B47E1B8", hash_generated_field = "9A2BA086324E44D0FD861C86FC7A5A06")

    static final int TYPE_SHORT = 'I' | 2 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "0D96262233FDA3056EC39C2525472EED", hash_generated_field = "DA873A8AC9972659FE05932734984FC1")

    static final int TYPE_INT = 'I' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "BFE64E825AE82B22B575380A7CDD29C3", hash_generated_field = "69BA5615F8B78F22534B8C5C19228490")

    static final int TYPE_LONG = 'I' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "0DF111D0C091F889C4759ED9AD27A2BC", hash_generated_field = "ED0FC9DA000EBF50B25ED5400E99DA5D")

    static final int TYPE_FLOAT = 'F' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.968 -0400", hash_original_field = "20D27AE0ED1D92F1442681FB825E7E45", hash_generated_field = "5867595828327917045FEC3E185B8B83")

    static final int TYPE_DOUBLE = 'F' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.969 -0400", hash_original_field = "8D84765DDCB1613978CF4AD92E9CB971", hash_generated_field = "235CD5ED9F27E795117F17DF7BCAFA50")

    static final int TYPE_STRING = 'L' | 's' << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.969 -0400", hash_original_field = "E6C6E5779FBFA8F41BB41D93E7906B60", hash_generated_field = "1734EA463E0596C6DBE64154CCF362D1")

    static final int TYPE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.969 -0400", hash_original_field = "C7D8F11623D863085E5C58A402C4DC53", hash_generated_field = "83B21DDE04AFBBC067D3B1D2ABBE2EB9")

    public static final int STRING_TYPE_MISMATCH = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.969 -0400", hash_original_field = "AE02F525260A243A38AE270481D5B588", hash_generated_field = "00B47C8F77B363A29A3C021DA8F3516B")

    public static final int STRING_NOT_SET = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.969 -0400", hash_original_field = "A84984543701A93AF491BB6ED525A1D2", hash_generated_field = "E18A84E3EBC448C32F75BCB5481CA863")

    public static final int STRING_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.969 -0400", hash_original_field = "4E91184683D8761F7BD0C10F98F6C48F", hash_generated_field = "72988529DEBF8FACA5F4299D7353C743")

    public static final int STRING_SET = 1;
}

