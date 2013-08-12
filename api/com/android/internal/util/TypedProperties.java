package com.android.internal.util;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;






public class TypedProperties extends HashMap<String, Object> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.004 -0400", hash_original_method = "ECB16241B0AB765E13051ACDAE33A02C", hash_generated_method = "B248ACEE9001880DCCB88F00DD01C611")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.006 -0400", hash_original_method = "DEE9183B66993F47A34635E71D1E1A05", hash_generated_method = "69300B76275FA1D07475FDA099F68801")
    public void load(Reader r) throws IOException {
        addTaint(r.getTaint());
        parse(r, this);
        // ---------- Original Method ----------
        //parse(r, this);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.006 -0400", hash_original_method = "47BA0B831F55080B235C21EE87FA94B0", hash_generated_method = "025AA13D8F656B8C25588311D04184E7")
    @Override
    public Object get(Object key) {
        addTaint(key.getTaint());
        Object value = super.get(key);
        if(value == NULL_STRING)        
        {
Object var540C13E9E156B687226421B24F2DF178_2099066019 =             null;
            var540C13E9E156B687226421B24F2DF178_2099066019.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2099066019;
        } //End block
Object varAF280DA2BC37D8BE783D8499160168DE_1097815022 =         value;
        varAF280DA2BC37D8BE783D8499160168DE_1097815022.addTaint(taint);
        return varAF280DA2BC37D8BE783D8499160168DE_1097815022;
        // ---------- Original Method ----------
        //Object value = super.get(key);
        //if (value == NULL_STRING) {
            //return null;
        //}
        //return value;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.007 -0400", hash_original_method = "6663F38CAE0A0F250100A85B4A9042B2", hash_generated_method = "EED3ECB1EDE88E3F7D9FA2E6AE570EE5")
    public boolean getBoolean(String property, boolean def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            boolean var4ED9407630EB1000C0F6B63842DEFA7D_767149822 = (def);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_240352825 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_240352825;
        } //End block
        if(value instanceof Boolean)        
        {
            boolean varBC26109FD0D926BA548E7B8E99E609D9_549877851 = (((Boolean)value).booleanValue());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2127081517 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2127081517;
        } //End block
        TypeException var805FC76681DEDC2E36CC0BB21EC1A30E_1175591022 = new TypeException(property, value, "boolean");
        var805FC76681DEDC2E36CC0BB21EC1A30E_1175591022.addTaint(taint);
        throw var805FC76681DEDC2E36CC0BB21EC1A30E_1175591022;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.007 -0400", hash_original_method = "C59AE35C77F78F452B75D7268F0F89E8", hash_generated_method = "1FA0A6C014782CB1E4D5AF732C98795A")
    public byte getByte(String property, byte def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            byte var4ED9407630EB1000C0F6B63842DEFA7D_1634428899 = (def);
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_1491667634 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_1491667634;
        } //End block
        if(value instanceof Byte)        
        {
            byte var35348045D56C47B658DEA945656F8AB7_1368402157 = (((Byte)value).byteValue());
                        byte var40EA57D3EE3C07BF1C102B466E1C3091_867005112 = getTaintByte();
            return var40EA57D3EE3C07BF1C102B466E1C3091_867005112;
        } //End block
        TypeException varFA332DAFF3AC9BC520CDDB2CC83F6468_1569438294 = new TypeException(property, value, "byte");
        varFA332DAFF3AC9BC520CDDB2CC83F6468_1569438294.addTaint(taint);
        throw varFA332DAFF3AC9BC520CDDB2CC83F6468_1569438294;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.008 -0400", hash_original_method = "B3F410F783F41DCDA5B135E26EFE8189", hash_generated_method = "05CE8A8BB62ACF970DC4039235F1606C")
    public short getShort(String property, short def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            short var4ED9407630EB1000C0F6B63842DEFA7D_1019619165 = (def);
                        short var4F09DAA9D95BCB166A302407A0E0BABE_1300934979 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_1300934979;
        } //End block
        if(value instanceof Short)        
        {
            short varBC17CBC160D99E82160E3FB34D373031_1930120618 = (((Short)value).shortValue());
                        short var4F09DAA9D95BCB166A302407A0E0BABE_1161277072 = getTaintShort();
            return var4F09DAA9D95BCB166A302407A0E0BABE_1161277072;
        } //End block
        TypeException varC16218961456E8C504AD0F5969DBBA4E_1747772673 = new TypeException(property, value, "short");
        varC16218961456E8C504AD0F5969DBBA4E_1747772673.addTaint(taint);
        throw varC16218961456E8C504AD0F5969DBBA4E_1747772673;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.008 -0400", hash_original_method = "81A20114A7AF0172426C6E77D3C9CCF3", hash_generated_method = "B201FC2CF1F5F820356ABD381061D930")
    public int getInt(String property, int def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            int var4ED9407630EB1000C0F6B63842DEFA7D_2087871199 = (def);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266630413 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1266630413;
        } //End block
        if(value instanceof Integer)        
        {
            int varC887A84560F2A8EFD700BC80AB572403_1672044952 = (((Integer)value).intValue());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57792302 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_57792302;
        } //End block
        TypeException varD6080985D485A0D220638E1A1D7F8E6B_2121772092 = new TypeException(property, value, "int");
        varD6080985D485A0D220638E1A1D7F8E6B_2121772092.addTaint(taint);
        throw varD6080985D485A0D220638E1A1D7F8E6B_2121772092;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.009 -0400", hash_original_method = "4BF2AEC507B97708CFEE1BE095F3CD54", hash_generated_method = "A07E78559422DD5C21B234D7683A4C3E")
    public long getLong(String property, long def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            long var4ED9407630EB1000C0F6B63842DEFA7D_1370954901 = (def);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1664233572 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1664233572;
        } //End block
        if(value instanceof Long)        
        {
            long var6A7295A730E93D60401BA7C11CED8342_864555522 = (((Long)value).longValue());
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_730532629 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_730532629;
        } //End block
        TypeException var70EE1BF703E76CCF216D91244CD5D8EB_1142711551 = new TypeException(property, value, "long");
        var70EE1BF703E76CCF216D91244CD5D8EB_1142711551.addTaint(taint);
        throw var70EE1BF703E76CCF216D91244CD5D8EB_1142711551;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.009 -0400", hash_original_method = "173DB4357D41B8C372C6266493A88C42", hash_generated_method = "F556B682D6F9C9038D7BE990249E69F4")
    public float getFloat(String property, float def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            float var4ED9407630EB1000C0F6B63842DEFA7D_454114966 = (def);
                        float var546ADE640B6EDFBC8A086EF31347E768_1853588985 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1853588985;
        } //End block
        if(value instanceof Float)        
        {
            float var86A11069791AE9DD813EDB7FB244EF59_22948733 = (((Float)value).floatValue());
                        float var546ADE640B6EDFBC8A086EF31347E768_1214218403 = getTaintFloat();
            return var546ADE640B6EDFBC8A086EF31347E768_1214218403;
        } //End block
        TypeException varF6F8A1C3A685815745BED356E7A54870_726035594 = new TypeException(property, value, "float");
        varF6F8A1C3A685815745BED356E7A54870_726035594.addTaint(taint);
        throw varF6F8A1C3A685815745BED356E7A54870_726035594;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.009 -0400", hash_original_method = "319F68DA9A588357DEFC3D0ED78EA71B", hash_generated_method = "13F0BEC11F1E546F3FC974231C7AABCD")
    public double getDouble(String property, double def) {
        addTaint(def);
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            double var4ED9407630EB1000C0F6B63842DEFA7D_1707741664 = (def);
                        double varE8CD7DA078A86726031AD64F35F5A6C0_1508692769 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_1508692769;
        } //End block
        if(value instanceof Double)        
        {
            double var7B9B10BAB0658D50E2E730FEA63F2E53_1627929065 = (((Double)value).doubleValue());
                        double varE8CD7DA078A86726031AD64F35F5A6C0_397878718 = getTaintDouble();
            return varE8CD7DA078A86726031AD64F35F5A6C0_397878718;
        } //End block
        TypeException var01C5E7F897D5B2010CD911DD5902A148_1488369632 = new TypeException(property, value, "double");
        var01C5E7F897D5B2010CD911DD5902A148_1488369632.addTaint(taint);
        throw var01C5E7F897D5B2010CD911DD5902A148_1488369632;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.010 -0400", hash_original_method = "3AAFD700C2ABAD81E6BE42DE7BFF48B2", hash_generated_method = "8288FA61AE0AD529DC80D51BD04095A3")
    public String getString(String property, String def) {
        addTaint(def.getTaint());
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
String var9EA315D7588BA8DB5A3E312497990346_143773384 =             def;
            var9EA315D7588BA8DB5A3E312497990346_143773384.addTaint(taint);
            return var9EA315D7588BA8DB5A3E312497990346_143773384;
        } //End block
        if(value == NULL_STRING)        
        {
String var540C13E9E156B687226421B24F2DF178_1844628230 =             null;
            var540C13E9E156B687226421B24F2DF178_1844628230.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1844628230;
        } //End block
        else
        if(value instanceof String)        
        {
String var39E2DC4C41DC437ADA614281BF13F76E_1442057523 =             (String)value;
            var39E2DC4C41DC437ADA614281BF13F76E_1442057523.addTaint(taint);
            return var39E2DC4C41DC437ADA614281BF13F76E_1442057523;
        } //End block
        TypeException varF6E7BAB97C0421CD0B5E979DA1F90E27_1066309139 = new TypeException(property, value, "string");
        varF6E7BAB97C0421CD0B5E979DA1F90E27_1066309139.addTaint(taint);
        throw varF6E7BAB97C0421CD0B5E979DA1F90E27_1066309139;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.011 -0400", hash_original_method = "AE35D37F95D56A154F209F071D3D7624", hash_generated_method = "2EF270933B81A2B553954311F11D09AA")
    public boolean getBoolean(String property) {
        addTaint(property.getTaint());
        boolean var529988CA16C5F5802282EAD0E30C140A_1371807717 = (getBoolean(property, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_821800398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_821800398;
        // ---------- Original Method ----------
        //return getBoolean(property, false);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.011 -0400", hash_original_method = "370EA3A899989D3F86644B48EA45FC9B", hash_generated_method = "684A53494EC477EE686BEA98A1EC0B58")
    public byte getByte(String property) {
        addTaint(property.getTaint());
        byte varC9B8276C3E1D7595B77771EE3F0087F0_1103197415 = (getByte(property, (byte)0));
                byte var40EA57D3EE3C07BF1C102B466E1C3091_1233193723 = getTaintByte();
        return var40EA57D3EE3C07BF1C102B466E1C3091_1233193723;
        // ---------- Original Method ----------
        //return getByte(property, (byte)0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.012 -0400", hash_original_method = "FA3A5E6826A1DDB74D3D7C867E30B692", hash_generated_method = "197A7681C71336DF60793487AA3D029E")
    public short getShort(String property) {
        addTaint(property.getTaint());
        short var4B052920E7CCC9197C31F3A2450C4E1C_1077348533 = (getShort(property, (short)0));
                short var4F09DAA9D95BCB166A302407A0E0BABE_986060935 = getTaintShort();
        return var4F09DAA9D95BCB166A302407A0E0BABE_986060935;
        // ---------- Original Method ----------
        //return getShort(property, (short)0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.012 -0400", hash_original_method = "01591AA36D981ABFF3C80720671DB519", hash_generated_method = "8CD3686892BD6A3843C47FC8C3F58BAD")
    public int getInt(String property) {
        addTaint(property.getTaint());
        int var86D5DBE0AC915FEAEA96C1A01E1FA9EE_1944746201 = (getInt(property, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325224770 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325224770;
        // ---------- Original Method ----------
        //return getInt(property, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.012 -0400", hash_original_method = "6768A5BD1563E9807D6B08281CAC66B5", hash_generated_method = "5A18EEC9A3BD6AFE5D8939F91A50696F")
    public long getLong(String property) {
        addTaint(property.getTaint());
        long varE66401AC426032A8470C9A94550AD9F3_1412189566 = (getLong(property, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2058046624 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2058046624;
        // ---------- Original Method ----------
        //return getLong(property, 0L);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.013 -0400", hash_original_method = "EF3DC0C356750228212346284358116F", hash_generated_method = "F406A76A92D7DE17E0DA3E9D4B1843E9")
    public float getFloat(String property) {
        addTaint(property.getTaint());
        float var0D7442006E3760390B764A317DB2FEE7_1580753643 = (getFloat(property, 0.0f));
                float var546ADE640B6EDFBC8A086EF31347E768_859060322 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_859060322;
        // ---------- Original Method ----------
        //return getFloat(property, 0.0f);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.013 -0400", hash_original_method = "C54C18DE732B31DF63D9F3187CBED443", hash_generated_method = "38FE2A40BA1835C84BF96526AAEAA3C9")
    public double getDouble(String property) {
        addTaint(property.getTaint());
        double var2B9ADFF79C4BD15579BD19CD22C6939C_762723204 = (getDouble(property, 0.0));
                double varE8CD7DA078A86726031AD64F35F5A6C0_1799382527 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1799382527;
        // ---------- Original Method ----------
        //return getDouble(property, 0.0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.014 -0400", hash_original_method = "1EC3769C452BFA246F7089382554F763", hash_generated_method = "99FC8D31917085147AB34B61EC93D650")
    public String getString(String property) {
        addTaint(property.getTaint());
String var7A5DD373B6F6A93BF1E779B195389AB3_293584381 =         getString(property, "");
        var7A5DD373B6F6A93BF1E779B195389AB3_293584381.addTaint(taint);
        return var7A5DD373B6F6A93BF1E779B195389AB3_293584381;
        // ---------- Original Method ----------
        //return getString(property, "");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.014 -0400", hash_original_method = "56B937E7FCE24CC3D04453B96CCA1E2A", hash_generated_method = "9E9C49599682E8F4D5CC3E99F00E8C1A")
    public int getStringInfo(String property) {
        addTaint(property.getTaint());
        Object value = super.get(property);
        if(value == null)        
        {
            int varE3B52244A591230772525EE907D6F277_1433663560 = (STRING_NOT_SET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027896696 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027896696;
        } //End block
        if(value == NULL_STRING)        
        {
            int var54E9B3628DE5BAA0D9FC0A2268227499_1465539473 = (STRING_NULL);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410532576 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410532576;
        } //End block
        else
        if(value instanceof String)        
        {
            int var12D656F886AA19C138EA79FB0A61AE8D_1769190871 = (STRING_SET);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534291153 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1534291153;
        } //End block
        int varF5D0E3DA79184C510C9C08B8BA755031_1434852149 = (STRING_TYPE_MISMATCH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2072082682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2072082682;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_method = "443E7125F6059ABCC086317CFCE0D16A", hash_generated_method = "A8983884B495BA3B97B314285EB42E8F")
          ParseException(StreamTokenizer state, String expected) {
            super("expected " + expected + ", saw " + state.toString());
            addTaint(expected.getTaint());
            addTaint(state.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    public static class TypeException extends IllegalArgumentException {
        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_method = "869ADEB9A2A381133512C58E64F92EC9", hash_generated_method = "D8A96D8861D95E88CC89251CEBCEE702")
          TypeException(String property, Object value, String requestedType) {
            super(property + " has type " + value.getClass().getName() +
                ", not " + requestedType);
            addTaint(requestedType.getTaint());
            addTaint(value.getTaint());
            addTaint(property.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "3A718E6E8AB09C6754F8AB0221E65E20", hash_generated_field = "636FC1AE7A17ECC84638758548E6F26E")

    static final String NULL_STRING = new String("<TypedProperties:NULL_STRING>");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "8BEE494A88E22DCABEE74AB284604CC7", hash_generated_field = "E1ACD2CFB22CAE29B9CA75C3973872EE")

    static final int TYPE_UNSET = 'x';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "6F4F342B95B25A4C75EC3E906175F9FD", hash_generated_field = "E580A7D7D1050DD90A59D8546A666FFF")

    static final int TYPE_BOOLEAN = 'Z';
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "A8690542C0AB936750AA1E6687044E52", hash_generated_field = "6BE67BABA764A60D2B4FFE61896B284A")

    static final int TYPE_BYTE = 'I' | 1 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "90696F1E8ABEB0FEED1B6F2C4B47E1B8", hash_generated_field = "9A2BA086324E44D0FD861C86FC7A5A06")

    static final int TYPE_SHORT = 'I' | 2 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "0D96262233FDA3056EC39C2525472EED", hash_generated_field = "DA873A8AC9972659FE05932734984FC1")

    static final int TYPE_INT = 'I' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "BFE64E825AE82B22B575380A7CDD29C3", hash_generated_field = "69BA5615F8B78F22534B8C5C19228490")

    static final int TYPE_LONG = 'I' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "0DF111D0C091F889C4759ED9AD27A2BC", hash_generated_field = "ED0FC9DA000EBF50B25ED5400E99DA5D")

    static final int TYPE_FLOAT = 'F' | 4 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "20D27AE0ED1D92F1442681FB825E7E45", hash_generated_field = "5867595828327917045FEC3E185B8B83")

    static final int TYPE_DOUBLE = 'F' | 8 << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "8D84765DDCB1613978CF4AD92E9CB971", hash_generated_field = "235CD5ED9F27E795117F17DF7BCAFA50")

    static final int TYPE_STRING = 'L' | 's' << 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "E6C6E5779FBFA8F41BB41D93E7906B60", hash_generated_field = "1734EA463E0596C6DBE64154CCF362D1")

    static final int TYPE_ERROR = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.015 -0400", hash_original_field = "C7D8F11623D863085E5C58A402C4DC53", hash_generated_field = "83B21DDE04AFBBC067D3B1D2ABBE2EB9")

    public static final int STRING_TYPE_MISMATCH = -2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.016 -0400", hash_original_field = "AE02F525260A243A38AE270481D5B588", hash_generated_field = "00B47C8F77B363A29A3C021DA8F3516B")

    public static final int STRING_NOT_SET = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.016 -0400", hash_original_field = "A84984543701A93AF491BB6ED525A1D2", hash_generated_field = "E18A84E3EBC448C32F75BCB5481CA863")

    public static final int STRING_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:27.016 -0400", hash_original_field = "4E91184683D8761F7BD0C10F98F6C48F", hash_generated_field = "72988529DEBF8FACA5F4299D7353C743")

    public static final int STRING_SET = 1;
}

