package com.android.internal.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.Map;

import android.os.Parcel;
import android.os.Parcelable;





public class PkgUsageStats implements Parcelable {

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.623 -0400", hash_original_field = "A6B7AD8516005FC7EA17662B9B408CF5", hash_generated_field = "65B1A44C53F3FF61EDA70C7F983455D7")

    public static final Parcelable.Creator<PkgUsageStats> CREATOR
    = new Parcelable.Creator<PkgUsageStats>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.001 -0500", hash_original_method = "9DA264EB5F24BD17A24D60210BE6F57D", hash_generated_method = "9365278431C65FB576B7576BBF93445D")
        public PkgUsageStats createFromParcel(Parcel in) {
            return new PkgUsageStats(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.002 -0500", hash_original_method = "726ADDD2E7F991C21D06EB8BB5034839", hash_generated_method = "F5848ED5FB63FA36621700C81F40CCA0")
        public PkgUsageStats[] newArray(int size) {
            return new PkgUsageStats[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.997 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.998 -0500", hash_original_field = "847BD8001EAA339AA9EC54B67BDF0731", hash_generated_field = "21C854B78D53D6B68A5B48894136FE57")

    public int launchCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:41.999 -0500", hash_original_field = "3178567983019C37A2DA633D216D658D", hash_generated_field = "BFFCAFFF5EF37FB71EBEED00E2451831")

    public long usageTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.000 -0500", hash_original_field = "6642E70FC5A4820F06CCFC64E0090BCE", hash_generated_field = "DD071BE2371A95289920DCB4558946CA")

    public Map<String, Long> componentResumeTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.004 -0500", hash_original_method = "EF5295BC011C50A8405086A4DA12DD9D", hash_generated_method = "65AC61007C843743336F84E5C57542B5")
    public PkgUsageStats(String pkgName, int count, long time, Map<String, Long> lastResumeTimes) {
        packageName = pkgName;
        launchCount = count;
        usageTime = time;
        componentResumeTimes = new HashMap<String, Long>(lastResumeTimes);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.005 -0500", hash_original_method = "977D0617B4C179661ACE3B4403E55D28", hash_generated_method = "94C4A350321CBDB0123361695E6F08CC")
    public PkgUsageStats(Parcel source) {
        packageName = source.readString();
        launchCount = source.readInt();
        usageTime = source.readLong();
        final int N = source.readInt();
        componentResumeTimes = new HashMap<String, Long>(N);
        for (int i = 0; i < N; i++) {
            String component = source.readString();
            long lastResumeTime = source.readLong();
            componentResumeTimes.put(component, lastResumeTime);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.006 -0500", hash_original_method = "9D74B058D8C14276F2F5A28106414DA9", hash_generated_method = "6DC9CA45885B49CE4EA8D39A370F4C21")
    public PkgUsageStats(PkgUsageStats pStats) {
        packageName = pStats.packageName;
        launchCount = pStats.launchCount;
        usageTime = pStats.usageTime;
        componentResumeTimes = new HashMap<String, Long>(pStats.componentResumeTimes);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.003 -0500", hash_original_method = "5A8FDC802D15BADB218E7B9A38048A4B", hash_generated_method = "A59216B1FA5FC6E108B22AE23CA9977A")
    public String toString() {
        return "PkgUsageStats{"
        + Integer.toHexString(System.identityHashCode(this))
        + " " + packageName + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.007 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:42.008 -0500", hash_original_method = "65B01222074C1BC4168423427126F9FB", hash_generated_method = "296141E1B9BCF038DD997FEB9D49CDCF")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(packageName);
        dest.writeInt(launchCount);
        dest.writeLong(usageTime);
        dest.writeInt(componentResumeTimes.size());
        for (Map.Entry<String, Long> ent : componentResumeTimes.entrySet()) {
            dest.writeString(ent.getKey());
            dest.writeLong(ent.getValue());
        }
    }
    // orphaned legacy method
    public PkgUsageStats createFromParcel(Parcel in) {
            return new PkgUsageStats(in);
        }
    
    // orphaned legacy method
    public PkgUsageStats[] newArray(int size) {
            return new PkgUsageStats[size];
        }
    
}

