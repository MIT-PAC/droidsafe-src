package com.android.internal.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    public static final Parcelable.Creator<PkgUsageStats> CREATOR = new Parcelable.Creator<PkgUsageStats>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.500 -0400", hash_original_method = "9DA264EB5F24BD17A24D60210BE6F57D", hash_generated_method = "B3EE134341CB42B3A1643B0D9C395EE7")
        @DSModeled(DSC.SAFE)
        public PkgUsageStats createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (PkgUsageStats)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PkgUsageStats(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.500 -0400", hash_original_method = "726ADDD2E7F991C21D06EB8BB5034839", hash_generated_method = "11912B4EE7C03DDC1C7D4F412269DCBC")
        @DSModeled(DSC.SAFE)
        public PkgUsageStats[] newArray(int size) {
            dsTaint.addTaint(size);
            return (PkgUsageStats[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new PkgUsageStats[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.500 -0400", hash_original_method = "EF5295BC011C50A8405086A4DA12DD9D", hash_generated_method = "1BF49BAFE1A0D094C1562BD88040D02E")
    @DSModeled(DSC.SAFE)
    public PkgUsageStats(String pkgName, int count, long time, Map<String, Long> lastResumeTimes) {
        dsTaint.addTaint(pkgName);
        dsTaint.addTaint(time);
        dsTaint.addTaint(count);
        dsTaint.addTaint(lastResumeTimes.dsTaint);
        componentResumeTimes = new HashMap<String, Long>(lastResumeTimes);
        // ---------- Original Method ----------
        //packageName = pkgName;
        //launchCount = count;
        //usageTime = time;
        //componentResumeTimes = new HashMap<String, Long>(lastResumeTimes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.500 -0400", hash_original_method = "977D0617B4C179661ACE3B4403E55D28", hash_generated_method = "52A3622555BB4980BCB354DD59697EE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PkgUsageStats(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        packageName = source.readString();
        launchCount = source.readInt();
        usageTime = source.readLong();
        final int N;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.500 -0400", hash_original_method = "9D74B058D8C14276F2F5A28106414DA9", hash_generated_method = "93235EC2039C8F53915EE6868326B4F0")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.501 -0400", hash_original_method = "5A8FDC802D15BADB218E7B9A38048A4B", hash_generated_method = "CE6EA88AF3353AFAEA82C5FD9045851C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var55221E7E67FD383C7C17B7113D36DFCE_707336278 = ("PkgUsageStats{"
        + Integer.toHexString(System.identityHashCode(this))
        + " " + packageName + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "PkgUsageStats{"
        //+ Integer.toHexString(System.identityHashCode(this))
        //+ " " + packageName + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.501 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:09.501 -0400", hash_original_method = "65B01222074C1BC4168423427126F9FB", hash_generated_method = "6FB3E485E44EB2A93A5C64FE9D46B20B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(packageName);
        dest.writeInt(launchCount);
        dest.writeLong(usageTime);
        dest.writeInt(componentResumeTimes.size());
        {
            Iterator<Map.Entry<String, Long>> seatecAstronomy42 = componentResumeTimes.entrySet().iterator();
            seatecAstronomy42.hasNext();
            Map.Entry<String, Long> ent = seatecAstronomy42.next();
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

    
}


