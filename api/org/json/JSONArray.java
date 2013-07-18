package org.json;

// Droidsafe Imports
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class JSONArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.238 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "76A4FC356F020E02D923B1E56C39C10C")

    private List<Object> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.239 -0400", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "C0E1FE19CFD6C8C417EA7BEBD218CAB1")
    public  JSONArray() {
        values = new ArrayList<Object>();
        // ---------- Original Method ----------
        //values = new ArrayList<Object>();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.240 -0400", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "E6A4FFA55DC1BD2AB18CE91D87343D3B")
    public  JSONArray(Collection copyFrom) {
        this();
        addTaint(copyFrom.getTaint());
        Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        values.addAll(copyFromTyped);
        // ---------- Original Method ----------
        //Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        //values.addAll(copyFromTyped);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.246 -0400", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "910A228D079209F39F6C48E8E0F35829")
    public  JSONArray(JSONTokener readFrom) throws JSONException {
        addTaint(readFrom.getTaint());
        Object object = readFrom.nextValue();
        if(object instanceof JSONArray)        
        {
            values = ((JSONArray) object).values;
        } //End block
        else
        {
            org.json.JSONException varD9CAFF6E5F5E847FEF76BC01289F6D9D_1304715677 = JSON.typeMismatch(object, "JSONArray");
            varD9CAFF6E5F5E847FEF76BC01289F6D9D_1304715677.addTaint(taint);
            throw varD9CAFF6E5F5E847FEF76BC01289F6D9D_1304715677;
        } //End block
        // ---------- Original Method ----------
        //Object object = readFrom.nextValue();
        //if (object instanceof JSONArray) {
            //values = ((JSONArray) object).values;
        //} else {
            //throw JSON.typeMismatch(object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.247 -0400", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "9DFE658011D3DBAD15ECDD1AD977929B")
    public  JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.247 -0400", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "3378ED80D83483144E6722F83CA13B24")
    public int length() {
        int var45ED98251535301233938FEAC38EF89B_1268419864 = (values.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269144823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1269144823;
        // ---------- Original Method ----------
        //return values.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.247 -0400", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "FBB5E0588021B80378F52E4ECD8E1066")
    public JSONArray put(boolean value) {
        addTaint(value);
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_52813890 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_52813890.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_52813890;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.248 -0400", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "1B8DA0E91C8FF04BDF1D4A8A931E55C4")
    public JSONArray put(double value) throws JSONException {
        addTaint(value);
        values.add(JSON.checkDouble(value));
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1895846582 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1895846582.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1895846582;
        // ---------- Original Method ----------
        //values.add(JSON.checkDouble(value));
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.248 -0400", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "11D7A3767998B34A29B6209EC28A7EF1")
    public JSONArray put(int value) {
        addTaint(value);
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_68602618 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_68602618.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_68602618;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.248 -0400", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "EEB117104B4F387021D13B37DD5ED60D")
    public JSONArray put(long value) {
        addTaint(value);
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_194370073 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_194370073.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_194370073;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.248 -0400", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "FAC0656A0E2B46374BF4A564B826D17D")
    public JSONArray put(Object value) {
        addTaint(value.getTaint());
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_559238665 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_559238665.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_559238665;
        // ---------- Original Method ----------
        //values.add(value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.249 -0400", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "4E0A9A6C0CB0B9613CD1D1EC01DDF802")
    public JSONArray put(int index, boolean value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray var61C7A82145F58415AC9751EC1E113EA9_154269401 =         put(index, (Boolean) value);
        var61C7A82145F58415AC9751EC1E113EA9_154269401.addTaint(taint);
        return var61C7A82145F58415AC9751EC1E113EA9_154269401;
        // ---------- Original Method ----------
        //return put(index, (Boolean) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.249 -0400", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "E9E3D260A24D599B1B4EF35C9D526B97")
    public JSONArray put(int index, double value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray varD2648A584BB78028772896479DD96F21_639000144 =         put(index, (Double) value);
        varD2648A584BB78028772896479DD96F21_639000144.addTaint(taint);
        return varD2648A584BB78028772896479DD96F21_639000144;
        // ---------- Original Method ----------
        //return put(index, (Double) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.249 -0400", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "FDEFEBA7ED420E39A08878C6D38D3CF4")
    public JSONArray put(int index, int value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray varF18272C2716313036EEA794AD07A8D95_564956634 =         put(index, (Integer) value);
        varF18272C2716313036EEA794AD07A8D95_564956634.addTaint(taint);
        return varF18272C2716313036EEA794AD07A8D95_564956634;
        // ---------- Original Method ----------
        //return put(index, (Integer) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.250 -0400", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "ED64E1EB95D7FD03D42CAEF317CFE5F6")
    public JSONArray put(int index, long value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray varF9E382633A80BF41E4480AA88C638D2C_879243110 =         put(index, (Long) value);
        varF9E382633A80BF41E4480AA88C638D2C_879243110.addTaint(taint);
        return varF9E382633A80BF41E4480AA88C638D2C_879243110;
        // ---------- Original Method ----------
        //return put(index, (Long) value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.250 -0400", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "93BCA47B58D22E1A1F994A4FFAE6CEDC")
    public JSONArray put(int index, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(index);
        if(value instanceof Number)        
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } //End block
        while
(values.size() <= index)        
        {
            values.add(null);
        } //End block
        values.set(index, value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1568699545 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1568699545.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1568699545;
        // ---------- Original Method ----------
        //if (value instanceof Number) {
            //JSON.checkDouble(((Number) value).doubleValue());
        //}
        //while (values.size() <= index) {
            //values.add(null);
        //}
        //values.set(index, value);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.250 -0400", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "7E25DC8BBBA62B21DA75B04FB5B24BB6")
    public boolean isNull(int index) {
        addTaint(index);
        Object value = opt(index);
        boolean varF3F7EF11D8A95BF17F84F4328D5CEC8D_394170577 = (value == null || value == JSONObject.NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1614060199 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1614060199;
        // ---------- Original Method ----------
        //Object value = opt(index);
        //return value == null || value == JSONObject.NULL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.251 -0400", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "E13FD86E113EAA0F7AF777EBCD6F4B7E")
    public Object get(int index) throws JSONException {
        addTaint(index);
        try 
        {
            Object value = values.get(index);
            if(value == null)            
            {
                JSONException var61C1F28B1022BBEB26A222F940677CBE_36470979 = new JSONException("Value at " + index + " is null.");
                var61C1F28B1022BBEB26A222F940677CBE_36470979.addTaint(taint);
                throw var61C1F28B1022BBEB26A222F940677CBE_36470979;
            } //End block
Object varAF280DA2BC37D8BE783D8499160168DE_803540999 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_803540999.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_803540999;
        } //End block
        catch (IndexOutOfBoundsException e)
        {
            JSONException varAFF4E3EB559CFFC23FDFFED9030230B2_1202757004 = new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
            varAFF4E3EB559CFFC23FDFFED9030230B2_1202757004.addTaint(taint);
            throw varAFF4E3EB559CFFC23FDFFED9030230B2_1202757004;
        } //End block
        // ---------- Original Method ----------
        //try {
            //Object value = values.get(index);
            //if (value == null) {
                //throw new JSONException("Value at " + index + " is null.");
            //}
            //return value;
        //} catch (IndexOutOfBoundsException e) {
            //throw new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.251 -0400", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "0C21B02A89CA62C5CBE42F711F383608")
    public Object opt(int index) {
        addTaint(index);
        if(index < 0 || index >= values.size())        
        {
Object var540C13E9E156B687226421B24F2DF178_650214439 =             null;
            var540C13E9E156B687226421B24F2DF178_650214439.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_650214439;
        } //End block
Object var5DE7A94CAEDFFCB90D8B52A8BC544B32_749529514 =         values.get(index);
        var5DE7A94CAEDFFCB90D8B52A8BC544B32_749529514.addTaint(taint);
        return var5DE7A94CAEDFFCB90D8B52A8BC544B32_749529514;
        // ---------- Original Method ----------
        //if (index < 0 || index >= values.size()) {
            //return null;
        //}
        //return values.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.258 -0400", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "69BAC835BFCF2ADC05D4753A2AF2DCD6")
    public boolean getBoolean(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Boolean result = JSON.toBoolean(object);
        if(result == null)        
        {
            org.json.JSONException varC3BFCD2CB6FB5EDA1A44F3A1C59E2B7C_1898961197 = JSON.typeMismatch(index, object, "boolean");
            varC3BFCD2CB6FB5EDA1A44F3A1C59E2B7C_1898961197.addTaint(taint);
            throw varC3BFCD2CB6FB5EDA1A44F3A1C59E2B7C_1898961197;
        } //End block
        boolean varB4A88417B3D0170D754C647C30B7216A_409651208 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240929169 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240929169;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Boolean result = JSON.toBoolean(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "boolean");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.259 -0400", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "71B6EFC7A850633813A194643F9471D4")
    public boolean optBoolean(int index) {
        addTaint(index);
        boolean var5056EE15CE30E7DC2B586E1B4B41FAB7_973869480 = (optBoolean(index, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_949937201 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_949937201;
        // ---------- Original Method ----------
        //return optBoolean(index, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.259 -0400", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "A23A5F2070AB9CFC41F1DF4597892B0D")
    public boolean optBoolean(int index, boolean fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Boolean result = JSON.toBoolean(object);
        boolean varD432CC74B2878A4B571046B2CA3AAD1D_1837022804 = (result != null ? result : fallback);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1186766326 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1186766326;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Boolean result = JSON.toBoolean(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.265 -0400", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "AE5270E0E2CCD2AC641F7796A726E275")
    public double getDouble(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Double result = JSON.toDouble(object);
        if(result == null)        
        {
            org.json.JSONException var530E815ACC0A4F0CEF9AD0962B4489F1_1146269258 = JSON.typeMismatch(index, object, "double");
            var530E815ACC0A4F0CEF9AD0962B4489F1_1146269258.addTaint(taint);
            throw var530E815ACC0A4F0CEF9AD0962B4489F1_1146269258;
        } //End block
        double varB4A88417B3D0170D754C647C30B7216A_1933912303 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_327843487 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_327843487;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Double result = JSON.toDouble(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "double");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.266 -0400", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "D2C91C021A225DB100143DECD98170FA")
    public double optDouble(int index) {
        addTaint(index);
        double varB2E7B85686D192BCF9FAD6B3AA5DB29C_1958069258 = (optDouble(index, Double.NaN));
                double varE8CD7DA078A86726031AD64F35F5A6C0_572878743 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_572878743;
        // ---------- Original Method ----------
        //return optDouble(index, Double.NaN);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.267 -0400", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "7F890600DB91B690152382B95DAB1524")
    public double optDouble(int index, double fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Double result = JSON.toDouble(object);
        double varD432CC74B2878A4B571046B2CA3AAD1D_20571712 = (result != null ? result : fallback);
                double varE8CD7DA078A86726031AD64F35F5A6C0_264703627 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_264703627;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Double result = JSON.toDouble(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.274 -0400", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "56B563F0D1537B2B84CBF42FFB50C7A5")
    public int getInt(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Integer result = JSON.toInteger(object);
        if(result == null)        
        {
            org.json.JSONException varEFC8D92C523694DA451C34A8DC9FE224_2144007622 = JSON.typeMismatch(index, object, "int");
            varEFC8D92C523694DA451C34A8DC9FE224_2144007622.addTaint(taint);
            throw varEFC8D92C523694DA451C34A8DC9FE224_2144007622;
        } //End block
        int varB4A88417B3D0170D754C647C30B7216A_292386622 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742601703 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_742601703;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Integer result = JSON.toInteger(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "int");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.275 -0400", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "8F4AA829A065846D168A0D7BAA7DE2E3")
    public int optInt(int index) {
        addTaint(index);
        int var3FB5AE27BA7BE5FCA90324057F944DC9_623765566 = (optInt(index, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734866620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_734866620;
        // ---------- Original Method ----------
        //return optInt(index, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.276 -0400", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "5C53496F5C6F04703D31C96A87A2CEFD")
    public int optInt(int index, int fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Integer result = JSON.toInteger(object);
        int varD432CC74B2878A4B571046B2CA3AAD1D_824855074 = (result != null ? result : fallback);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118217585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_118217585;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Integer result = JSON.toInteger(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.286 -0400", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "8E25B57EF8519564E3CA4F7CEE0CED9E")
    public long getLong(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Long result = JSON.toLong(object);
        if(result == null)        
        {
            org.json.JSONException var4CB0CCACCD7D523A422A3398B869157B_577346575 = JSON.typeMismatch(index, object, "long");
            var4CB0CCACCD7D523A422A3398B869157B_577346575.addTaint(taint);
            throw var4CB0CCACCD7D523A422A3398B869157B_577346575;
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_417949649 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_732693236 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_732693236;
        // ---------- Original Method ----------
        //Object object = get(index);
        //Long result = JSON.toLong(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "long");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.287 -0400", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "C949A1662E590E7190C67E89115B4211")
    public long optLong(int index) {
        addTaint(index);
        long varE9BC627F2E3C0E875E849669EBF00293_1051795501 = (optLong(index, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_129421493 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_129421493;
        // ---------- Original Method ----------
        //return optLong(index, 0L);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.288 -0400", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "6B01328B52986C598E476F0C8D4FFEC4")
    public long optLong(int index, long fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Long result = JSON.toLong(object);
        long varD432CC74B2878A4B571046B2CA3AAD1D_715387382 = (result != null ? result : fallback);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_508061920 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_508061920;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //Long result = JSON.toLong(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.297 -0400", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "C1CA708844FA2ACACE0A13E2E1E204C3")
    public String getString(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        String result = JSON.toString(object);
        if(result == null)        
        {
            org.json.JSONException var65EEA5FCFA3AB0253C68896E8D325672_2026765852 = JSON.typeMismatch(index, object, "String");
            var65EEA5FCFA3AB0253C68896E8D325672_2026765852.addTaint(taint);
            throw var65EEA5FCFA3AB0253C68896E8D325672_2026765852;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1025089925 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1025089925.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1025089925;
        // ---------- Original Method ----------
        //Object object = get(index);
        //String result = JSON.toString(object);
        //if (result == null) {
            //throw JSON.typeMismatch(index, object, "String");
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.298 -0400", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "D83F4FBDB93EFAB5E64C106B4AACA272")
    public String optString(int index) {
        addTaint(index);
String var2A75D9FFD03F8140445734C02AD94794_552234192 =         optString(index, "");
        var2A75D9FFD03F8140445734C02AD94794_552234192.addTaint(taint);
        return var2A75D9FFD03F8140445734C02AD94794_552234192;
        // ---------- Original Method ----------
        //return optString(index, "");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.298 -0400", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "2DF1A6265C8E5E60939885FE6CBC88F8")
    public String optString(int index, String fallback) {
        addTaint(fallback.getTaint());
        addTaint(index);
        Object object = opt(index);
        String result = JSON.toString(object);
String varB29C31EA7BA163F0F2187995ADA1E48E_198365971 =         result != null ? result : fallback;
        varB29C31EA7BA163F0F2187995ADA1E48E_198365971.addTaint(taint);
        return varB29C31EA7BA163F0F2187995ADA1E48E_198365971;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //String result = JSON.toString(object);
        //return result != null ? result : fallback;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.308 -0400", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "1583C87C3938B57825F1664A671481B0")
    public JSONArray getJSONArray(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        if(object instanceof JSONArray)        
        {
JSONArray varA31A6C9B348464F1BAAA1B1373E54400_1917228608 =             (JSONArray) object;
            varA31A6C9B348464F1BAAA1B1373E54400_1917228608.addTaint(taint);
            return varA31A6C9B348464F1BAAA1B1373E54400_1917228608;
        } //End block
        else
        {
            org.json.JSONException var9EC0179E95815E740963BC2B5DE2DDD8_1440084759 = JSON.typeMismatch(index, object, "JSONArray");
            var9EC0179E95815E740963BC2B5DE2DDD8_1440084759.addTaint(taint);
            throw var9EC0179E95815E740963BC2B5DE2DDD8_1440084759;
        } //End block
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONArray) {
            //return (JSONArray) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONArray");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.309 -0400", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "A78DCE47E9D5DF6F17ACAF640B60DAFA")
    public JSONArray optJSONArray(int index) {
        addTaint(index);
        Object object = opt(index);
JSONArray var37D15C802F10CA15BA7D983DBF1DB879_2006910764 =         object instanceof JSONArray ? (JSONArray) object : null;
        var37D15C802F10CA15BA7D983DBF1DB879_2006910764.addTaint(taint);
        return var37D15C802F10CA15BA7D983DBF1DB879_2006910764;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONArray ? (JSONArray) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.320 -0400", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "8BBADBFA8164AE0A9498D05CDE972F5A")
    public JSONObject getJSONObject(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        if(object instanceof JSONObject)        
        {
JSONObject varA963CC0194E284A145B65210ED1E5C63_1789935741 =             (JSONObject) object;
            varA963CC0194E284A145B65210ED1E5C63_1789935741.addTaint(taint);
            return varA963CC0194E284A145B65210ED1E5C63_1789935741;
        } //End block
        else
        {
            org.json.JSONException var007AB7E12D365874FDEC14AB90BDC16C_907515427 = JSON.typeMismatch(index, object, "JSONObject");
            var007AB7E12D365874FDEC14AB90BDC16C_907515427.addTaint(taint);
            throw var007AB7E12D365874FDEC14AB90BDC16C_907515427;
        } //End block
        // ---------- Original Method ----------
        //Object object = get(index);
        //if (object instanceof JSONObject) {
            //return (JSONObject) object;
        //} else {
            //throw JSON.typeMismatch(index, object, "JSONObject");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.321 -0400", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "9BCDA77AFAF2841A2977E66ECA884ED7")
    public JSONObject optJSONObject(int index) {
        addTaint(index);
        Object object = opt(index);
JSONObject varE8B2189D470FA34838D00114FC8343E3_878938952 =         object instanceof JSONObject ? (JSONObject) object : null;
        varE8B2189D470FA34838D00114FC8343E3_878938952.addTaint(taint);
        return varE8B2189D470FA34838D00114FC8343E3_878938952;
        // ---------- Original Method ----------
        //Object object = opt(index);
        //return object instanceof JSONObject ? (JSONObject) object : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.322 -0400", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "8EDF7D6308462A0F52343D1693104E51")
    public JSONObject toJSONObject(JSONArray names) throws JSONException {
        addTaint(names.getTaint());
        JSONObject result = new JSONObject();
        int length = Math.min(names.length(), values.size());
        if(length == 0)        
        {
JSONObject var540C13E9E156B687226421B24F2DF178_1112758201 =             null;
            var540C13E9E156B687226421B24F2DF178_1112758201.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1112758201;
        } //End block
for(int i = 0;i < length;i++)
        {
            String name = JSON.toString(names.opt(i));
            result.put(name, opt(i));
        } //End block
JSONObject varDC838461EE2FA0CA4C9BBB70A15456B0_984524759 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_984524759.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_984524759;
        // ---------- Original Method ----------
        //JSONObject result = new JSONObject();
        //int length = Math.min(names.length(), values.size());
        //if (length == 0) {
            //return null;
        //}
        //for (int i = 0; i < length; i++) {
            //String name = JSON.toString(names.opt(i));
            //result.put(name, opt(i));
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.322 -0400", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "AF0C4D71EEE6DD0CBB90CCA240A55385")
    public String join(String separator) throws JSONException {
        addTaint(separator.getTaint());
        JSONStringer stringer = new JSONStringer();
        stringer.open(JSONStringer.Scope.NULL, "");
for(int i = 0, size = values.size();i < size;i++)
        {
            if(i > 0)            
            {
                stringer.out.append(separator);
            } //End block
            stringer.value(values.get(i));
        } //End block
        stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
String var2127C9CDB37C196CD892BED0F39DA194_2088465176 =         stringer.out.toString();
        var2127C9CDB37C196CD892BED0F39DA194_2088465176.addTaint(taint);
        return var2127C9CDB37C196CD892BED0F39DA194_2088465176;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer();
        //stringer.open(JSONStringer.Scope.NULL, "");
        //for (int i = 0, size = values.size(); i < size; i++) {
            //if (i > 0) {
                //stringer.out.append(separator);
            //}
            //stringer.value(values.get(i));
        //}
        //stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
        //return stringer.out.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.323 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "73926439D7568B4D344C1C6194152AC3")
    @Override
    public String toString() {
        try 
        {
            JSONStringer stringer = new JSONStringer();
            writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_283834193 =             stringer.toString();
            varC93F6F7CA20C01E1D5F7833A2EB9AB40_283834193.addTaint(taint);
            return varC93F6F7CA20C01E1D5F7833A2EB9AB40_283834193;
        } //End block
        catch (JSONException e)
        {
String var540C13E9E156B687226421B24F2DF178_638470559 =             null;
            var540C13E9E156B687226421B24F2DF178_638470559.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_638470559;
        } //End block
        // ---------- Original Method ----------
        //try {
            //JSONStringer stringer = new JSONStringer();
            //writeTo(stringer);
            //return stringer.toString();
        //} catch (JSONException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.323 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "19A0A242E25591A706F3B13A792C5F23")
    public String toString(int indentSpaces) throws JSONException {
        addTaint(indentSpaces);
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_72170521 =         stringer.toString();
        varC93F6F7CA20C01E1D5F7833A2EB9AB40_72170521.addTaint(taint);
        return varC93F6F7CA20C01E1D5F7833A2EB9AB40_72170521;
        // ---------- Original Method ----------
        //JSONStringer stringer = new JSONStringer(indentSpaces);
        //writeTo(stringer);
        //return stringer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.323 -0400", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "CE2E2D3D8CA1E0494106A5B5CA37E7C6")
     void writeTo(JSONStringer stringer) throws JSONException {
        addTaint(stringer.getTaint());
        stringer.array();
for(Object value : values)
        {
            stringer.value(value);
        } //End block
        stringer.endArray();
        // ---------- Original Method ----------
        //stringer.array();
        //for (Object value : values) {
            //stringer.value(value);
        //}
        //stringer.endArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.324 -0400", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "2571B6D7B00A01158432B7275D629C71")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var7207C24CA990068A1C31A05FBBC074BD_285418248 = (o instanceof JSONArray && ((JSONArray) o).values.equals(values));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2082755757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2082755757;
        // ---------- Original Method ----------
        //return o instanceof JSONArray && ((JSONArray) o).values.equals(values);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:43.324 -0400", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "F2FF44E0AEEA75E6A231F6BE1DEA4074")
    @Override
    public int hashCode() {
        int varDF30FCF4BDECEBA23083ED6215F392A3_1492259068 = (values.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170202626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1170202626;
        // ---------- Original Method ----------
        //return values.hashCode();
    }

    
}

