package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

public class PkgUsageStats implements Parcelable {
    public String packageName;
    public int launchCount;
    public long usageTime;
    public Map<String, Long> componentResumeTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.251 -0400", hash_original_method = "EF5295BC011C50A8405086A4DA12DD9D", hash_generated_method = "4C532A2903144B55059D04258506FF1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PkgUsageStats(String pkgName, int count, long time, Map<String, Long> lastResumeTimes) {
        dsTaint.addTaint(time);
        dsTaint.addTaint(pkgName);
        dsTaint.addTaint(count);
        dsTaint.addTaint(lastResumeTimes.dsTaint);
        componentResumeTimes = new HashMap<String, Long>(lastResumeTimes);
        // ---------- Original Method ----------
        //packageName = pkgName;
        //launchCount = count;
        //usageTime = time;
        //componentResumeTimes = new HashMap<String, Long>(lastResumeTimes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.252 -0400", hash_original_method = "977D0617B4C179661ACE3B4403E55D28", hash_generated_method = "EA9B263B1545ED2A6396916710136B87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PkgUsageStats(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        packageName = source.readString();
        launchCount = source.readInt();
        usageTime = source.readLong();
        int N;
        N = source.readInt();
        componentResumeTimes = new HashMap<String, Long>(N);
        {
            int i;
            i = 0;
            {
                String component;
                component = source.readString();
                long lastResumeTime;
                lastResumeTime = source.readLong();
                componentResumeTimes.put(component, lastResumeTime);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //packageName = source.readString();
        //launchCount = source.readInt();
        //usageTime = source.readLong();
        //final int N = source.readInt();
        //componentResumeTimes = new HashMap<String, Long>(N);
        //for (int i = 0; i < N; i++) {
            //String component = source.readString();
            //long lastResumeTime = source.readLong();
            //componentResumeTimes.put(component, lastResumeTime);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.252 -0400", hash_original_method = "9D74B058D8C14276F2F5A28106414DA9", hash_generated_method = "F3F9ACCDC755374BAE0C9A10673D7EC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PkgUsageStats(PkgUsageStats pStats) {
        dsTaint.addTaint(pStats.dsTaint);
        packageName = pStats.packageName;
        launchCount = pStats.launchCount;
        usageTime = pStats.usageTime;
        componentResumeTimes = new HashMap<String, Long>(pStats.componentResumeTimes);
        // ---------- Original Method ----------
        //packageName = pStats.packageName;
        //launchCount = pStats.launchCount;
        //usageTime = pStats.usageTime;
        //componentResumeTimes = new HashMap<String, Long>(pStats.componentResumeTimes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.252 -0400", hash_original_method = "5A8FDC802D15BADB218E7B9A38048A4B", hash_generated_method = "6186FF965EF1E4DE43A94FC032EDFE77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var55221E7E67FD383C7C17B7113D36DFCE_1352555089 = ("PkgUsageStats{"
        + Integer.toHexString(System.identityHashCode(this))
        + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "PkgUsageStats{"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.252 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.256 -0400", hash_original_method = "65B01222074C1BC4168423427126F9FB", hash_generated_method = "A6D0040472046AE6943FDEE490794D99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(packageName);
        dest.writeInt(launchCount);
        dest.writeLong(usageTime);
        dest.writeInt(componentResumeTimes.size());
        {
            Iterator<Map.Entry<String, Long>> var88FC42210E06D35F3FD471E41D5B26EC_628768551 = (componentResumeTimes.entrySet()).iterator();
            var88FC42210E06D35F3FD471E41D5B26EC_628768551.hasNext();
            Map.Entry<String, Long> ent = var88FC42210E06D35F3FD471E41D5B26EC_628768551.next();
            {
                dest.writeString(ent.getKey());
                dest.writeLong(ent.getValue());
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //dest.writeString(packageName);
        //dest.writeInt(launchCount);
        //dest.writeLong(usageTime);
        //dest.writeInt(componentResumeTimes.size());
        //for (Map.Entry<String, Long> ent : componentResumeTimes.entrySet()) {
            //dest.writeString(ent.getKey());
            //dest.writeLong(ent.getValue());
        //}
    }

    
    public static final Parcelable.Creator<PkgUsageStats> CREATOR = new Parcelable.Creator<PkgUsageStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.256 -0400", hash_original_method = "9DA264EB5F24BD17A24D60210BE6F57D", hash_generated_method = "1E46CDA27D4728504FFB4BAE81D9B2B5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PkgUsageStats createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            PkgUsageStats varDC39EC4DD94FD872B93ED3A77AD8B31A_390866049 = (new PkgUsageStats(in));
            return (PkgUsageStats)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PkgUsageStats(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.257 -0400", hash_original_method = "726ADDD2E7F991C21D06EB8BB5034839", hash_generated_method = "90A30D2A6EC076216D42D7E2100C3EA1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public PkgUsageStats[] newArray(int size) {
            dsTaint.addTaint(size);
            PkgUsageStats[] var6634F2C2FE6B7EDFFA73D3E96A070B61_1504284190 = (new PkgUsageStats[size]);
            return (PkgUsageStats[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PkgUsageStats[size];
        }

        
}; //Transformed anonymous class
}

