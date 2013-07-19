package android.drm.mobile1;

// Droidsafe Imports
import java.util.Date;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class DrmConstraintInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.325 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.325 -0400", hash_original_field = "E4DFB3F5DD911DC868EB4F2C2A836D64", hash_generated_field = "06B1C308557811937D11804124198C4C")

    private long startDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.325 -0400", hash_original_field = "813E94378D42501D835B2ED6253DC463", hash_generated_field = "007E58F684D95FF371B0E147049B4F3F")

    private long endDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.326 -0400", hash_original_field = "D2E16D3F793E62737A6CDF2D54B0D9C1", hash_generated_field = "A187678ED22D20A3185A905AC22BB781")

    private long interval;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.327 -0400", hash_original_method = "9EDFB4E9C7052BBC86DC69FD90E3B91B", hash_generated_method = "6868DD6A933BD4B25D0381AE441C3DEC")
      DrmConstraintInfo() {
        count = -1;
        startDate = -1;
        endDate = -1;
        interval = -1;
        // ---------- Original Method ----------
        //count = -1;
        //startDate = -1;
        //endDate = -1;
        //interval = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.328 -0400", hash_original_method = "992035D2E84A01D01ECB6C67BA762BA7", hash_generated_method = "8ED38119F6F18AD4B0A234C2E9CFA713")
    public int getCount() {
        int varE2942A04780E223B215EB8B663CF5353_857934441 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25650337 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_25650337;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.328 -0400", hash_original_method = "EF2100393B586A67476383923E9A11D6", hash_generated_method = "E98C35B1AD656EB6EA3D94D83EA94509")
    public Date getStartDate() {
        if(startDate == -1)        
        {
Date var540C13E9E156B687226421B24F2DF178_1738388830 =         null;
        var540C13E9E156B687226421B24F2DF178_1738388830.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1738388830;
        }
Date var4DFAA868C3B58DBB3005236311862DD3_816341790 =         new Date(startDate);
        var4DFAA868C3B58DBB3005236311862DD3_816341790.addTaint(taint);
        return var4DFAA868C3B58DBB3005236311862DD3_816341790;
        // ---------- Original Method ----------
        //if (startDate == -1)
            //return null;
        //return new Date(startDate);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.329 -0400", hash_original_method = "53A3C4742E83A3AEE0A9A0D2D307AB00", hash_generated_method = "8F76CA92688F964795959B5E9E6E4CFC")
    public Date getEndDate() {
        if(endDate == -1)        
        {
Date var540C13E9E156B687226421B24F2DF178_124607338 =         null;
        var540C13E9E156B687226421B24F2DF178_124607338.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_124607338;
        }
Date var7215B60234B3CCBF0078435EEB4FD34F_918666463 =         new Date(endDate);
        var7215B60234B3CCBF0078435EEB4FD34F_918666463.addTaint(taint);
        return var7215B60234B3CCBF0078435EEB4FD34F_918666463;
        // ---------- Original Method ----------
        //if (endDate == -1)
            //return null;
        //return new Date(endDate);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:09.330 -0400", hash_original_method = "8CAC42DB459590AAD476B56FC6D4D691", hash_generated_method = "E43A2AB3448DA1DC37335DB42B0BCFBB")
    public long getInterval() {
        long varD2E16D3F793E62737A6CDF2D54B0D9C1_2146137057 = (interval);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1158636096 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1158636096;
        // ---------- Original Method ----------
        //return interval;
    }

    
}

