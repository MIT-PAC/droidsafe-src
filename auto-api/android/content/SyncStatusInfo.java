package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;

public class SyncStatusInfo implements Parcelable {
    public int authorityId;
    public long totalElapsedTime;
    public int numSyncs;
    public int numSourcePoll;
    public int numSourceServer;
    public int numSourceLocal;
    public int numSourceUser;
    public int numSourcePeriodic;
    public long lastSuccessTime;
    public int lastSuccessSource;
    public long lastFailureTime;
    public int lastFailureSource;
    public String lastFailureMesg;
    public long initialFailureTime;
    public boolean pending;
    public boolean initialize;
    public ArrayList<Long> periodicSyncTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.119 -0400", hash_original_method = "A601236BC9972CD1DA6DEFC9BDCCDDF9", hash_generated_method = "DC6DC2174D8D158E4751E0A508F94D18")
    @DSModeled(DSC.SAFE)
     SyncStatusInfo(int authorityId) {
        dsTaint.addTaint(authorityId);
        // ---------- Original Method ----------
        //this.authorityId = authorityId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.120 -0400", hash_original_method = "48BE1C9789126DF2BDCDE38D758F27DD", hash_generated_method = "256666C5EB1C4CC867AD41DB4322B0CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     SyncStatusInfo(Parcel parcel) {
        dsTaint.addTaint(parcel.dsTaint);
        int version;
        version = parcel.readInt();
        authorityId = parcel.readInt();
        totalElapsedTime = parcel.readLong();
        numSyncs = parcel.readInt();
        numSourcePoll = parcel.readInt();
        numSourceServer = parcel.readInt();
        numSourceLocal = parcel.readInt();
        numSourceUser = parcel.readInt();
        lastSuccessTime = parcel.readLong();
        lastSuccessSource = parcel.readInt();
        lastFailureTime = parcel.readLong();
        lastFailureSource = parcel.readInt();
        lastFailureMesg = parcel.readString();
        initialFailureTime = parcel.readLong();
        pending = parcel.readInt() != 0;
        initialize = parcel.readInt() != 0;
        {
            periodicSyncTimes = null;
        } //End block
        {
            int N;
            N = parcel.readInt();
            {
                periodicSyncTimes = null;
            } //End block
            {
                periodicSyncTimes = new ArrayList<Long>();
                {
                    int i;
                    i = 0;
                    {
                        periodicSyncTimes.add(parcel.readLong());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.121 -0400", hash_original_method = "7E33E8226B73A02621B31754517607B3", hash_generated_method = "AEAF0D6B312FB55EDBA45180F2096BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLastFailureMesgAsInt(int def) {
        dsTaint.addTaint(def);
        try 
        {
            {
                int var561DC7C18702C0DB19E8BC0A90987BBD_1782868205 = (Integer.parseInt(lastFailureMesg));
            } //End block
        } //End block
        catch (NumberFormatException e)
        {
            Log.d(TAG, "error parsing lastFailureMesg of " + lastFailureMesg, e);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //if (lastFailureMesg != null) {
                //return Integer.parseInt(lastFailureMesg);
            //}
        //} catch (NumberFormatException e) {
            //Log.d(TAG, "error parsing lastFailureMesg of " + lastFailureMesg, e);
        //}
        //return def;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.121 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.129 -0400", hash_original_method = "9461760C81A4DFF607A36CA2D6370E1C", hash_generated_method = "CAAC7F83BD66E57DA0C8616BABE6843E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel parcel, int flags) {
        dsTaint.addTaint(parcel.dsTaint);
        dsTaint.addTaint(flags);
        parcel.writeInt(VERSION);
        parcel.writeInt(authorityId);
        parcel.writeLong(totalElapsedTime);
        parcel.writeInt(numSyncs);
        parcel.writeInt(numSourcePoll);
        parcel.writeInt(numSourceServer);
        parcel.writeInt(numSourceLocal);
        parcel.writeInt(numSourceUser);
        parcel.writeLong(lastSuccessTime);
        parcel.writeInt(lastSuccessSource);
        parcel.writeLong(lastFailureTime);
        parcel.writeInt(lastFailureSource);
        parcel.writeString(lastFailureMesg);
        parcel.writeLong(initialFailureTime);
        parcel.writeInt(pending ? 1 : 0);
        parcel.writeInt(initialize ? 1 : 0);
        {
            parcel.writeInt(periodicSyncTimes.size());
            {
                Iterator<Long> var137A3BFEF4662131991E3E9E8AB91E39_505485525 = (periodicSyncTimes).iterator();
                var137A3BFEF4662131991E3E9E8AB91E39_505485525.hasNext();
                long periodicSyncTime = var137A3BFEF4662131991E3E9E8AB91E39_505485525.next();
                {
                    parcel.writeLong(periodicSyncTime);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            parcel.writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.137 -0400", hash_original_method = "BB3C22BCE01837AA4BAC40A0B35F8BC2", hash_generated_method = "E9513F79FB2856FA5293004FE6460AF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setPeriodicSyncTime(int index, long when) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(when);
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.set(index, when);
        // ---------- Original Method ----------
        //ensurePeriodicSyncTimeSize(index);
        //periodicSyncTimes.set(index, when);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.137 -0400", hash_original_method = "CB3B6F2BD6B69A04BBE5B4B8321ED55E", hash_generated_method = "F3184F18F181A763455911F77B5A5849")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void ensurePeriodicSyncTimeSize(int index) {
        dsTaint.addTaint(index);
        {
            periodicSyncTimes = new ArrayList<Long>(0);
        } //End block
        int requiredSize;
        requiredSize = index + 1;
        {
            boolean varDA8A1799F2E947514B7F61D918481AF0_1289940361 = (periodicSyncTimes.size() < requiredSize);
            {
                {
                    int i;
                    i = periodicSyncTimes.size();
                    {
                        periodicSyncTimes.add((long) 0);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (periodicSyncTimes == null) {
            //periodicSyncTimes = new ArrayList<Long>(0);
        //}
        //final int requiredSize = index + 1;
        //if (periodicSyncTimes.size() < requiredSize) {
            //for (int i = periodicSyncTimes.size(); i < requiredSize; i++) {
                //periodicSyncTimes.add((long) 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.138 -0400", hash_original_method = "E0266DD4F289B692F6E7B79E10E75B20", hash_generated_method = "A6EF9A02663458EFA25A1BC4093779CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getPeriodicSyncTime(int index) {
        dsTaint.addTaint(index);
        {
            boolean varB9564E21A396D957116506C1AEF43D3C_1658190970 = (periodicSyncTimes == null || periodicSyncTimes.size() < (index + 1));
        } //End collapsed parenthetic
        long varE430967A1E3A0EE477B628D1A0973895_715315283 = (periodicSyncTimes.get(index));
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (periodicSyncTimes == null || periodicSyncTimes.size() < (index + 1)) {
            //return 0;
        //}
        //return periodicSyncTimes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.138 -0400", hash_original_method = "5D5F49D9C483CE201F8BB2B6D37F0FB1", hash_generated_method = "A45A1B5645DEB82B448C5EEB3DBA0DAE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removePeriodicSyncTime(int index) {
        dsTaint.addTaint(index);
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.remove(index);
        // ---------- Original Method ----------
        //ensurePeriodicSyncTimeSize(index);
        //periodicSyncTimes.remove(index);
    }

    
    static final int VERSION = 2;
    private static final String TAG = "Sync";
    public static final Creator<SyncStatusInfo> CREATOR = new Creator<SyncStatusInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.138 -0400", hash_original_method = "7000403894FD3D88AA5C75270F571170", hash_generated_method = "430403E50696C483E095A9CDDDDDFCD0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncStatusInfo createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            SyncStatusInfo var355B45213B5FFB35BC4E05A34B513152_103001228 = (new SyncStatusInfo(in));
            return (SyncStatusInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncStatusInfo(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.139 -0400", hash_original_method = "59BC53FE0FEC79565943AAF0BCFA71FD", hash_generated_method = "0F5E01099533D646B63149EB3AE724B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncStatusInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            SyncStatusInfo[] varD4EE101A3772BE8DB8CE6742C1645B8A_385901888 = (new SyncStatusInfo[size]);
            return (SyncStatusInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncStatusInfo[size];
        }

        
}; //Transformed anonymous class
}

