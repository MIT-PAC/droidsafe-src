package android.location;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Iterator;
import java.util.NoSuchElementException;






public final class GpsStatus {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.817 -0500", hash_original_field = "49232C74E6665CFDA35F271FDDD12289", hash_generated_field = "9525E23D06AB56F41AB5F5DADBC87DF3")

    private static final int NUM_SATELLITES = 255;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.846 -0500", hash_original_field = "B2BD451854A858ECA6BB0CB129DBC04D", hash_generated_field = "0ACD894DFE78BC1B9FEB64A231971868")

    public static final int GPS_EVENT_STARTED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.848 -0500", hash_original_field = "DD1CE9CB6FF1321365DC21D47E2BDF38", hash_generated_field = "77513145C112B8A862D695A1610CD109")

    public static final int GPS_EVENT_STOPPED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.851 -0500", hash_original_field = "861BEC2B37F211805F39E70431188772", hash_generated_field = "1FE0287016FA42F3CFE36BF2509A2AA6")

    public static final int GPS_EVENT_FIRST_FIX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.853 -0500", hash_original_field = "F8E9C8527BCFA98F791FDF66D2E4C0E2", hash_generated_field = "39BADCF7553465D00B65E2D6552B3AC0")

    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.819 -0500", hash_original_field = "4C0225BCBFE77DADB4ACC763901DBC6E", hash_generated_field = "78EE48E2F626F172C233CA900DAE1C08")

    private int mTimeToFirstFix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.821 -0500", hash_original_field = "9A8D2F3082A54EB138A2BB032DB781D7", hash_generated_field = "EDAAB9E07CB6E2788A4305484F8C91B2")

    private GpsSatellite mSatellites[] = new GpsSatellite[NUM_SATELLITES];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.273 -0400", hash_original_field = "2DF85302EF31B22A6E1E6CB995BF0173", hash_generated_field = "4E2BE773D59F171305B1D8BC86C6191A")

    private Iterable<GpsSatellite> mSatelliteList = new Iterable<GpsSatellite>() {        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.273 -0400", hash_original_method = "9983CD5442E4C518DD699220FBA30311", hash_generated_method = "D802BB52D632FD31E6502E4338BAE5D2")
        public Iterator<GpsSatellite> iterator() {
            Iterator<GpsSatellite> varB4EAC82CA7396A68D541C85D26508E83_399552892 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_399552892 = new SatelliteIterator(mSatellites);
            varB4EAC82CA7396A68D541C85D26508E83_399552892.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_399552892;
            
            
        }

        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.860 -0500", hash_original_method = "8CEA7166A5DE76C7A3B19C2918198865", hash_generated_method = "8CEA7166A5DE76C7A3B19C2918198865")
    
GpsStatus() {
        for (int i = 0; i < mSatellites.length; i++) {
            mSatellites[i] = new GpsSatellite(i + 1);
        }
    }

    /**
     * Used internally within {@link LocationManager} to copy GPS status
     * data from the Location Manager Service to its cached GpsStatus instance.
     * Is synchronized to ensure that GPS status updates are atomic.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.862 -0500", hash_original_method = "4D31391A39726BDC955321B1E3DBD71C", hash_generated_method = "939345E9FE09508EB9CD8225B2B6722A")
    
synchronized void setStatus(int svCount, int[] prns, float[] snrs,
            float[] elevations, float[] azimuths, int ephemerisMask,
            int almanacMask, int usedInFixMask) {
        int i;

        for (i = 0; i < mSatellites.length; i++) {
            mSatellites[i].mValid = false;
        }
        
        for (i = 0; i < svCount; i++) {
            int prn = prns[i] - 1;
            int prnShift = (1 << prn);
            if (prn >= 0 && prn < mSatellites.length) {
                GpsSatellite satellite = mSatellites[prn];
    
                satellite.mValid = true;
                satellite.mSnr = snrs[i];
                satellite.mElevation = elevations[i];
                satellite.mAzimuth = azimuths[i];
                satellite.mHasEphemeris = ((ephemerisMask & prnShift) != 0);
                satellite.mHasAlmanac = ((almanacMask & prnShift) != 0);
                satellite.mUsedInFix = ((usedInFixMask & prnShift) != 0);
            }
        }
    }

    
    private final class SatelliteIterator implements Iterator<GpsSatellite> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.824 -0500", hash_original_field = "6B49F34EB8B8F48FA910BB6FA923837E", hash_generated_field = "A2118CDC10EB9E5F1F9C0A975C1188EF")


        private GpsSatellite[] mSatellites;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.827 -0500", hash_original_field = "53702B6348E11EAA55A0AB4A37AFE1D9", hash_generated_field = "53702B6348E11EAA55A0AB4A37AFE1D9")

        int mIndex = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.829 -0500", hash_original_method = "AEF39F6B14389CFD613D955A0F70C3EF", hash_generated_method = "AEF39F6B14389CFD613D955A0F70C3EF")
        
SatelliteIterator(GpsSatellite[] satellites) {
            mSatellites = satellites;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.831 -0500", hash_original_method = "280A0F6C9C24DB057056B6AC4648E027", hash_generated_method = "811B00FC3009841CCEA0A6635DB73856")
        
public boolean hasNext() {
            for (int i = mIndex; i < mSatellites.length; i++) {
                if (mSatellites[i].mValid) {
                    return true;
                }
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.833 -0500", hash_original_method = "2172205C4F18481DAEA9224F778B255B", hash_generated_method = "2C1DF6EA0F9B5DEC0C764AC4E9064B18")
        
public GpsSatellite next() {
            while (mIndex < mSatellites.length) {
                GpsSatellite satellite = mSatellites[mIndex++];
                if (satellite.mValid) {
                    return satellite;
                }
            }
            throw new NoSuchElementException();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.836 -0500", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "5B2A4852FF2684177E07742561C615C2")
        
public void remove() {
            throw new UnsupportedOperationException();
        }

        
    }


    
    public interface Listener {
        
        void onGpsStatusChanged(int event);
    }
    
    public interface NmeaListener {
        void onNmeaReceived(long timestamp, String nmea);
    }

    /**
     * Used by {@link LocationManager#getGpsStatus} to copy LocationManager's
     * cached GpsStatus instance to the client's copy.
     * Since this method is only used within {@link LocationManager#getGpsStatus},
     * it does not need to be synchronized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.865 -0500", hash_original_method = "C95E5E3E266CC24D44E0C8A907AC47BF", hash_generated_method = "C95E5E3E266CC24D44E0C8A907AC47BF")
    
void setStatus(GpsStatus status) {
        mTimeToFirstFix = status.getTimeToFirstFix();

        for (int i = 0; i < mSatellites.length; i++) {
            mSatellites[i].setStatus(status.mSatellites[i]);
        } 
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.867 -0500", hash_original_method = "DB9D2F6104F17C34589316947F2A601E", hash_generated_method = "DB9D2F6104F17C34589316947F2A601E")
    
void setTimeToFirstFix(int ttff) {
        mTimeToFirstFix = ttff;
    }

    /**
     * Returns the time required to receive the first fix since the most recent 
     * restart of the GPS engine.
     *
     * @return time to first fix in milliseconds
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.869 -0500", hash_original_method = "75FBD0BC51265BCFA2480910110E8F36", hash_generated_method = "30B430B55C77B02A9FBB5B23D6213947")
    
public int getTimeToFirstFix() {
        return mTimeToFirstFix;
    }

    /**
     * Returns an array of {@link GpsSatellite} objects, which represent the
     * current state of the GPS engine.
     *
     * @return the list of satellites
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.871 -0500", hash_original_method = "8623867703A7BB23EDE8EB2AB29E2B88", hash_generated_method = "C088CB919884494187C652A2575B61CC")
    
public Iterable<GpsSatellite> getSatellites() {
        return mSatelliteList;
    }

    /**
     * Returns the maximum number of satellites that can be in the satellite
     * list that can be returned by {@link #getSatellites()}.
     *
     * @return the maximum number of satellites
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:02.873 -0500", hash_original_method = "30B567DEF49ED207BED02E25B8D7701A", hash_generated_method = "0F1BF08BACC5EBC7335C7957322E860B")
    
public int getMaxSatellites() {
        return NUM_SATELLITES;
    }
}

