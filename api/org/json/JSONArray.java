package org.json;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JSONArray {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.420 -0400", hash_original_field = "F09CC7EE3A9A93273F4B80601CAFB00C", hash_generated_field = "76A4FC356F020E02D923B1E56C39C10C")

    private List<Object> values;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.420 -0400", hash_original_method = "1427CA478AAC933787CA982EEEA58E55", hash_generated_method = "C0E1FE19CFD6C8C417EA7BEBD218CAB1")
    public  JSONArray() {
        values = new ArrayList<Object>();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.420 -0400", hash_original_method = "805B0E8915A04C6C98723D3A60FEDF41", hash_generated_method = "E6A4FFA55DC1BD2AB18CE91D87343D3B")
    public  JSONArray(Collection copyFrom) {
        this();
        addTaint(copyFrom.getTaint());
        Collection<?> copyFromTyped = (Collection<?>) copyFrom;
        values.addAll(copyFromTyped);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.424 -0400", hash_original_method = "7582B79BE7678565BA45DD0B34B6A75F", hash_generated_method = "49C0CB8B5654DAB25C9BBB5B2CE4E644")
    public  JSONArray(JSONTokener readFrom) throws JSONException {
        addTaint(readFrom.getTaint());
        Object object = readFrom.nextValue();
    if(object instanceof JSONArray)        
        {
            values = ((JSONArray) object).values;
        } 
        else
        {
            org.json.JSONException varD9CAFF6E5F5E847FEF76BC01289F6D9D_131094125 = JSON.typeMismatch(object, "JSONArray");
            varD9CAFF6E5F5E847FEF76BC01289F6D9D_131094125.addTaint(taint);
            throw varD9CAFF6E5F5E847FEF76BC01289F6D9D_131094125;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.425 -0400", hash_original_method = "FBB8D188E5327545CDAACE0ACBE68DD3", hash_generated_method = "9DFE658011D3DBAD15ECDD1AD977929B")
    public  JSONArray(String json) throws JSONException {
        this(new JSONTokener(json));
        addTaint(json.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.425 -0400", hash_original_method = "2C5D59A27A6C313C8872AC341D9D75C0", hash_generated_method = "46804B9C1B373F64869220B0DB2654D6")
    public int length() {
        int var45ED98251535301233938FEAC38EF89B_563589056 = (values.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799833111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_799833111;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.425 -0400", hash_original_method = "F9CCA0A17EFD82FAE33507862E5A944E", hash_generated_method = "DE5079C425330F4E6EA8E1D2909204E3")
    public JSONArray put(boolean value) {
        addTaint(value);
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1668094881 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1668094881.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1668094881;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.426 -0400", hash_original_method = "632D5AC8096954F0909B9EEBB1192731", hash_generated_method = "A07692A556A100A1523A2368159D7F10")
    public JSONArray put(double value) throws JSONException {
        addTaint(value);
        values.add(JSON.checkDouble(value));
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1565035765 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1565035765.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1565035765;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.426 -0400", hash_original_method = "324220FCD4B61377969B5003ED2C32CE", hash_generated_method = "875B01DE7AAF153B7E4017F7A98815A0")
    public JSONArray put(int value) {
        addTaint(value);
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1265583274 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1265583274.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1265583274;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.426 -0400", hash_original_method = "4C6CD72BE64F436E9F52C8D610641FF3", hash_generated_method = "0244A5FF357AAA63E315B776F2D7DF8B")
    public JSONArray put(long value) {
        addTaint(value);
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1446328862 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1446328862.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1446328862;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.427 -0400", hash_original_method = "1D7645A229713F67337A58F8FF42D21C", hash_generated_method = "367F0B08E3613DD1C9B655B43AB6A07A")
    public JSONArray put(Object value) {
        addTaint(value.getTaint());
        values.add(value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_156033697 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_156033697.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_156033697;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.427 -0400", hash_original_method = "A8D9FD0A2FF792A00A29218BCE37DF7B", hash_generated_method = "FFB507BB450468D63084DDFD0AE49CE8")
    public JSONArray put(int index, boolean value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray var61C7A82145F58415AC9751EC1E113EA9_1573810566 =         put(index, (Boolean) value);
        var61C7A82145F58415AC9751EC1E113EA9_1573810566.addTaint(taint);
        return var61C7A82145F58415AC9751EC1E113EA9_1573810566;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.427 -0400", hash_original_method = "EB27801A89D2451AEBF6D71C639BF890", hash_generated_method = "42D8AB1B21FB4E66471BB4F3050C8C01")
    public JSONArray put(int index, double value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray varD2648A584BB78028772896479DD96F21_1807086377 =         put(index, (Double) value);
        varD2648A584BB78028772896479DD96F21_1807086377.addTaint(taint);
        return varD2648A584BB78028772896479DD96F21_1807086377;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.428 -0400", hash_original_method = "95364EFCBA8D50C1E1F228177A921191", hash_generated_method = "9567ABF357EB5A0A0C69B9C4873E95CD")
    public JSONArray put(int index, int value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray varF18272C2716313036EEA794AD07A8D95_1134694871 =         put(index, (Integer) value);
        varF18272C2716313036EEA794AD07A8D95_1134694871.addTaint(taint);
        return varF18272C2716313036EEA794AD07A8D95_1134694871;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.428 -0400", hash_original_method = "3F2291B7B045A442A1A296D04FF74C3B", hash_generated_method = "0FE20A195550EF363BABF4CD0F108EE0")
    public JSONArray put(int index, long value) throws JSONException {
        addTaint(value);
        addTaint(index);
JSONArray varF9E382633A80BF41E4480AA88C638D2C_1016575008 =         put(index, (Long) value);
        varF9E382633A80BF41E4480AA88C638D2C_1016575008.addTaint(taint);
        return varF9E382633A80BF41E4480AA88C638D2C_1016575008;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.429 -0400", hash_original_method = "965F91AFDF1516EF58CC39AD3E1136B7", hash_generated_method = "715F07D45E82A9536E5F2B0372F7DE8C")
    public JSONArray put(int index, Object value) throws JSONException {
        addTaint(value.getTaint());
        addTaint(index);
    if(value instanceof Number)        
        {
            JSON.checkDouble(((Number) value).doubleValue());
        } 
        while
(values.size() <= index)        
        {
            values.add(null);
        } 
        values.set(index, value);
JSONArray var72A74007B2BE62B849F475C7BDA4658B_1634368254 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1634368254.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1634368254;
        
        
            
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.429 -0400", hash_original_method = "075BEAC25684C4B47CFBC04F9272F423", hash_generated_method = "9A447E96234BC0DA99EF351E95799DB4")
    public boolean isNull(int index) {
        addTaint(index);
        Object value = opt(index);
        boolean varF3F7EF11D8A95BF17F84F4328D5CEC8D_510769810 = (value == null || value == JSONObject.NULL);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305068801 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305068801;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.430 -0400", hash_original_method = "2917FB45D7E32294FB2932AB5B08992C", hash_generated_method = "1A108A2879EC2DDA0DD4E7071633895A")
    public Object get(int index) throws JSONException {
        addTaint(index);
        try 
        {
            Object value = values.get(index);
    if(value == null)            
            {
                JSONException var61C1F28B1022BBEB26A222F940677CBE_783893995 = new JSONException("Value at " + index + " is null.");
                var61C1F28B1022BBEB26A222F940677CBE_783893995.addTaint(taint);
                throw var61C1F28B1022BBEB26A222F940677CBE_783893995;
            } 
Object varAF280DA2BC37D8BE783D8499160168DE_7012773 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_7012773.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_7012773;
        } 
        catch (IndexOutOfBoundsException e)
        {
            JSONException varAFF4E3EB559CFFC23FDFFED9030230B2_968730186 = new JSONException("Index " + index + " out of range [0.." + values.size() + ")");
            varAFF4E3EB559CFFC23FDFFED9030230B2_968730186.addTaint(taint);
            throw varAFF4E3EB559CFFC23FDFFED9030230B2_968730186;
        } 
        
        
            
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.431 -0400", hash_original_method = "3B6F9D3E5AFD1AB6175A8B6BF8959553", hash_generated_method = "16F917EAE0CAC5FB7C0E550068D0F32A")
    public Object opt(int index) {
        addTaint(index);
    if(index < 0 || index >= values.size())        
        {
Object var540C13E9E156B687226421B24F2DF178_1815051359 =             null;
            var540C13E9E156B687226421B24F2DF178_1815051359.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1815051359;
        } 
Object var5DE7A94CAEDFFCB90D8B52A8BC544B32_1206404963 =         values.get(index);
        var5DE7A94CAEDFFCB90D8B52A8BC544B32_1206404963.addTaint(taint);
        return var5DE7A94CAEDFFCB90D8B52A8BC544B32_1206404963;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.436 -0400", hash_original_method = "24E6A67B676FCC7270A02518A61B22A2", hash_generated_method = "3019D247577401D443257D4B7F241EF6")
    public boolean getBoolean(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Boolean result = JSON.toBoolean(object);
    if(result == null)        
        {
            org.json.JSONException varC3BFCD2CB6FB5EDA1A44F3A1C59E2B7C_1842086530 = JSON.typeMismatch(index, object, "boolean");
            varC3BFCD2CB6FB5EDA1A44F3A1C59E2B7C_1842086530.addTaint(taint);
            throw varC3BFCD2CB6FB5EDA1A44F3A1C59E2B7C_1842086530;
        } 
        boolean varB4A88417B3D0170D754C647C30B7216A_267245562 = (result);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_447494266 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_447494266;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.436 -0400", hash_original_method = "A304D16233AC57FB2DDAD429570460E8", hash_generated_method = "505D891C5AF91477DA2957AB654CC53F")
    public boolean optBoolean(int index) {
        addTaint(index);
        boolean var5056EE15CE30E7DC2B586E1B4B41FAB7_1923793804 = (optBoolean(index, false));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1588758088 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1588758088;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.437 -0400", hash_original_method = "D837DFEA35C0469693745E1088FDEE2E", hash_generated_method = "020A5538333DAD6596B93B579F08E13B")
    public boolean optBoolean(int index, boolean fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Boolean result = JSON.toBoolean(object);
        boolean varD432CC74B2878A4B571046B2CA3AAD1D_865444281 = (result != null ? result : fallback);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1364721569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1364721569;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.442 -0400", hash_original_method = "6D74AEBF7F111E364BD2DB0E7727FAF6", hash_generated_method = "141DF2407FF6DF75A540F003AE01D7CA")
    public double getDouble(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Double result = JSON.toDouble(object);
    if(result == null)        
        {
            org.json.JSONException var530E815ACC0A4F0CEF9AD0962B4489F1_638785794 = JSON.typeMismatch(index, object, "double");
            var530E815ACC0A4F0CEF9AD0962B4489F1_638785794.addTaint(taint);
            throw var530E815ACC0A4F0CEF9AD0962B4489F1_638785794;
        } 
        double varB4A88417B3D0170D754C647C30B7216A_45134719 = (result);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1138739232 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1138739232;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.442 -0400", hash_original_method = "6ACFD4932D58B1B1AAD30FC39935EAD2", hash_generated_method = "D6E5EF4A8F3F7D27C0C14035A563790C")
    public double optDouble(int index) {
        addTaint(index);
        double varB2E7B85686D192BCF9FAD6B3AA5DB29C_1555475160 = (optDouble(index, Double.NaN));
                double varE8CD7DA078A86726031AD64F35F5A6C0_391757156 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_391757156;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.443 -0400", hash_original_method = "0BBC192CCA032D1199B25DAD0E3977E8", hash_generated_method = "1B3140DA8AAE63BA66E369BF4281A95B")
    public double optDouble(int index, double fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Double result = JSON.toDouble(object);
        double varD432CC74B2878A4B571046B2CA3AAD1D_1640444254 = (result != null ? result : fallback);
                double varE8CD7DA078A86726031AD64F35F5A6C0_1264538719 = getTaintDouble();
        return varE8CD7DA078A86726031AD64F35F5A6C0_1264538719;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.449 -0400", hash_original_method = "853222C548896141F9D1D8AF0338F5C4", hash_generated_method = "B050C26A3734892A792B4E146DE60AFF")
    public int getInt(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Integer result = JSON.toInteger(object);
    if(result == null)        
        {
            org.json.JSONException varEFC8D92C523694DA451C34A8DC9FE224_788205542 = JSON.typeMismatch(index, object, "int");
            varEFC8D92C523694DA451C34A8DC9FE224_788205542.addTaint(taint);
            throw varEFC8D92C523694DA451C34A8DC9FE224_788205542;
        } 
        int varB4A88417B3D0170D754C647C30B7216A_1179224323 = (result);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945813549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1945813549;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.450 -0400", hash_original_method = "7CF76FC4FBEA846C37B11EB5D3437F82", hash_generated_method = "99F00C4CAA626EED71D648202A98EA6F")
    public int optInt(int index) {
        addTaint(index);
        int var3FB5AE27BA7BE5FCA90324057F944DC9_1430918114 = (optInt(index, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711239757 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1711239757;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.450 -0400", hash_original_method = "5DB279774D0456981D1F7F001BBC18BA", hash_generated_method = "A3F83B8FFA0D329404B6176BB79A4B5C")
    public int optInt(int index, int fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Integer result = JSON.toInteger(object);
        int varD432CC74B2878A4B571046B2CA3AAD1D_1526003247 = (result != null ? result : fallback);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616763774 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_616763774;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.458 -0400", hash_original_method = "56F71130ADC070DD70D4CA02CA42F381", hash_generated_method = "EB2EE294396E88AC2E12A647919542F3")
    public long getLong(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        Long result = JSON.toLong(object);
    if(result == null)        
        {
            org.json.JSONException var4CB0CCACCD7D523A422A3398B869157B_972403947 = JSON.typeMismatch(index, object, "long");
            var4CB0CCACCD7D523A422A3398B869157B_972403947.addTaint(taint);
            throw var4CB0CCACCD7D523A422A3398B869157B_972403947;
        } 
        long varB4A88417B3D0170D754C647C30B7216A_353102304 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_595208878 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_595208878;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.460 -0400", hash_original_method = "2BBCBA9E354F863B816F565C8B8E92CB", hash_generated_method = "7BEF90D998FE3825D6D4EE81A3508FA0")
    public long optLong(int index) {
        addTaint(index);
        long varE9BC627F2E3C0E875E849669EBF00293_535851673 = (optLong(index, 0L));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_338216342 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_338216342;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.461 -0400", hash_original_method = "81CF1715684C5D206C6FD7331990B13E", hash_generated_method = "AB9B4A276430A68C7D62C0AE82E4255D")
    public long optLong(int index, long fallback) {
        addTaint(fallback);
        addTaint(index);
        Object object = opt(index);
        Long result = JSON.toLong(object);
        long varD432CC74B2878A4B571046B2CA3AAD1D_134355110 = (result != null ? result : fallback);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_407788009 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_407788009;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.466 -0400", hash_original_method = "7F7D1138F84D636CF19BD9329533631C", hash_generated_method = "A332A35B88464B23FFD2C330BF618A3D")
    public String getString(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
        String result = JSON.toString(object);
    if(result == null)        
        {
            org.json.JSONException var65EEA5FCFA3AB0253C68896E8D325672_909471820 = JSON.typeMismatch(index, object, "String");
            var65EEA5FCFA3AB0253C68896E8D325672_909471820.addTaint(taint);
            throw var65EEA5FCFA3AB0253C68896E8D325672_909471820;
        } 
String varDC838461EE2FA0CA4C9BBB70A15456B0_1102765619 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1102765619.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1102765619;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.467 -0400", hash_original_method = "C31202553EDC4F0A1E4B21CAD06ABEC4", hash_generated_method = "3EC9378187367131040AA63F7ECC6EEA")
    public String optString(int index) {
        addTaint(index);
String var2A75D9FFD03F8140445734C02AD94794_1071966943 =         optString(index, "");
        var2A75D9FFD03F8140445734C02AD94794_1071966943.addTaint(taint);
        return var2A75D9FFD03F8140445734C02AD94794_1071966943;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.467 -0400", hash_original_method = "97366D23F93DD4ABD9E565325F7585B9", hash_generated_method = "17B278BB5AF5B39B2C8D8F2694E189B3")
    public String optString(int index, String fallback) {
        addTaint(fallback.getTaint());
        addTaint(index);
        Object object = opt(index);
        String result = JSON.toString(object);
String varB29C31EA7BA163F0F2187995ADA1E48E_807305258 =         result != null ? result : fallback;
        varB29C31EA7BA163F0F2187995ADA1E48E_807305258.addTaint(taint);
        return varB29C31EA7BA163F0F2187995ADA1E48E_807305258;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.474 -0400", hash_original_method = "173A28EF43B750DEF6376D4E3E2F6DD2", hash_generated_method = "47F479AD94055689C580BECF8E7018E4")
    public JSONArray getJSONArray(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
    if(object instanceof JSONArray)        
        {
JSONArray varA31A6C9B348464F1BAAA1B1373E54400_1775412673 =             (JSONArray) object;
            varA31A6C9B348464F1BAAA1B1373E54400_1775412673.addTaint(taint);
            return varA31A6C9B348464F1BAAA1B1373E54400_1775412673;
        } 
        else
        {
            org.json.JSONException var9EC0179E95815E740963BC2B5DE2DDD8_1673924181 = JSON.typeMismatch(index, object, "JSONArray");
            var9EC0179E95815E740963BC2B5DE2DDD8_1673924181.addTaint(taint);
            throw var9EC0179E95815E740963BC2B5DE2DDD8_1673924181;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.475 -0400", hash_original_method = "CBF30564657B4CB07ABBCF29084A5653", hash_generated_method = "EDA3A29C3EE33F24E9D963EAB54BA6BF")
    public JSONArray optJSONArray(int index) {
        addTaint(index);
        Object object = opt(index);
JSONArray var37D15C802F10CA15BA7D983DBF1DB879_1787536748 =         object instanceof JSONArray ? (JSONArray) object : null;
        var37D15C802F10CA15BA7D983DBF1DB879_1787536748.addTaint(taint);
        return var37D15C802F10CA15BA7D983DBF1DB879_1787536748;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.485 -0400", hash_original_method = "EA5692C9D71198B472B917468564A78A", hash_generated_method = "0449064ED6114B0892C1F39EFC1CC52A")
    public JSONObject getJSONObject(int index) throws JSONException {
        addTaint(index);
        Object object = get(index);
    if(object instanceof JSONObject)        
        {
JSONObject varA963CC0194E284A145B65210ED1E5C63_1247827204 =             (JSONObject) object;
            varA963CC0194E284A145B65210ED1E5C63_1247827204.addTaint(taint);
            return varA963CC0194E284A145B65210ED1E5C63_1247827204;
        } 
        else
        {
            org.json.JSONException var007AB7E12D365874FDEC14AB90BDC16C_956872281 = JSON.typeMismatch(index, object, "JSONObject");
            var007AB7E12D365874FDEC14AB90BDC16C_956872281.addTaint(taint);
            throw var007AB7E12D365874FDEC14AB90BDC16C_956872281;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.485 -0400", hash_original_method = "871DF64EA3EF0F09C790BD6ABB0AB209", hash_generated_method = "C9AAFECA4AB6DE7CC82C4AF04241A50F")
    public JSONObject optJSONObject(int index) {
        addTaint(index);
        Object object = opt(index);
JSONObject varE8B2189D470FA34838D00114FC8343E3_432917273 =         object instanceof JSONObject ? (JSONObject) object : null;
        varE8B2189D470FA34838D00114FC8343E3_432917273.addTaint(taint);
        return varE8B2189D470FA34838D00114FC8343E3_432917273;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.486 -0400", hash_original_method = "CEEBF6D79C62E432FE9EF262922223A6", hash_generated_method = "DE160194EE64CF4C2C60DCE0BD710CE8")
    public JSONObject toJSONObject(JSONArray names) throws JSONException {
        addTaint(names.getTaint());
        JSONObject result = new JSONObject();
        int length = Math.min(names.length(), values.size());
    if(length == 0)        
        {
JSONObject var540C13E9E156B687226421B24F2DF178_383772818 =             null;
            var540C13E9E156B687226421B24F2DF178_383772818.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_383772818;
        } 
for(int i = 0;i < length;i++)
        {
            String name = JSON.toString(names.opt(i));
            result.put(name, opt(i));
        } 
JSONObject varDC838461EE2FA0CA4C9BBB70A15456B0_2067623367 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2067623367.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2067623367;
        
        
        
        
            
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.486 -0400", hash_original_method = "818E08743989593DA274993EAEC63482", hash_generated_method = "E0DF227998BFBFA8584D656B9875365D")
    public String join(String separator) throws JSONException {
        addTaint(separator.getTaint());
        JSONStringer stringer = new JSONStringer();
        stringer.open(JSONStringer.Scope.NULL, "");
for(int i = 0, size = values.size();i < size;i++)
        {
    if(i > 0)            
            {
                stringer.out.append(separator);
            } 
            stringer.value(values.get(i));
        } 
        stringer.close(JSONStringer.Scope.NULL, JSONStringer.Scope.NULL, "");
String var2127C9CDB37C196CD892BED0F39DA194_122863995 =         stringer.out.toString();
        var2127C9CDB37C196CD892BED0F39DA194_122863995.addTaint(taint);
        return var2127C9CDB37C196CD892BED0F39DA194_122863995;
        
        
        
        
            
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.487 -0400", hash_original_method = "CC6BE78472EEEAF64E530CA9F9B14BB5", hash_generated_method = "9EE2E81B9C9EA0F9FA16B3B1FA9B005B")
    @Override
    public String toString() {
        try 
        {
            JSONStringer stringer = new JSONStringer();
            writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_50161550 =             stringer.toString();
            varC93F6F7CA20C01E1D5F7833A2EB9AB40_50161550.addTaint(taint);
            return varC93F6F7CA20C01E1D5F7833A2EB9AB40_50161550;
        } 
        catch (JSONException e)
        {
String var540C13E9E156B687226421B24F2DF178_2142748471 =             null;
            var540C13E9E156B687226421B24F2DF178_2142748471.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2142748471;
        } 
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.487 -0400", hash_original_method = "161CBAA0F7E505CC65BF62A9F4C8490E", hash_generated_method = "F705FBD48E51FD5480F14A48404D929B")
    public String toString(int indentSpaces) throws JSONException {
        addTaint(indentSpaces);
        JSONStringer stringer = new JSONStringer(indentSpaces);
        writeTo(stringer);
String varC93F6F7CA20C01E1D5F7833A2EB9AB40_832265168 =         stringer.toString();
        varC93F6F7CA20C01E1D5F7833A2EB9AB40_832265168.addTaint(taint);
        return varC93F6F7CA20C01E1D5F7833A2EB9AB40_832265168;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.488 -0400", hash_original_method = "07D36EC028565C954CCF4CA47905C766", hash_generated_method = "CE2E2D3D8CA1E0494106A5B5CA37E7C6")
     void writeTo(JSONStringer stringer) throws JSONException {
        addTaint(stringer.getTaint());
        stringer.array();
for(Object value : values)
        {
            stringer.value(value);
        } 
        stringer.endArray();
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.488 -0400", hash_original_method = "BF4C72A1D6E8FA2592A6106FA9BE5FDF", hash_generated_method = "AE6704FA7D2AE31F8D5E69CA6876E9F8")
    @Override
    public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean var7207C24CA990068A1C31A05FBBC074BD_1439963962 = (o instanceof JSONArray && ((JSONArray) o).values.equals(values));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625784924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625784924;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:43.488 -0400", hash_original_method = "5391F86F0DF47CDF0FABD2AA1BAE9E60", hash_generated_method = "F021013F86C4E85085FB9B2607D893AC")
    @Override
    public int hashCode() {
        int varDF30FCF4BDECEBA23083ED6215F392A3_877440652 = (values.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901816555 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_901816555;
        
        
    }

    
}

