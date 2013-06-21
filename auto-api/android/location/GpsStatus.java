package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class GpsStatus {
    private int mTimeToFirstFix;
    private GpsSatellite mSatellites[] = new GpsSatellite[NUM_SATELLITES];
    private Iterable<GpsSatellite> mSatelliteList = new Iterable<GpsSatellite>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.588 -0400", hash_original_method = "9983CD5442E4C518DD699220FBA30311", hash_generated_method = "8AC811BB5CBC1F7D9B34B1A260D2BD02")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Iterator<GpsSatellite> iterator() {
            Iterator<GpsSatellite> var67200ACBDB6A72D3B14FA9F5B80F4E28_1474957279 = (new SatelliteIterator(mSatellites));
            return (Iterator<GpsSatellite>)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SatelliteIterator(mSatellites);
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.588 -0400", hash_original_method = "8CEA7166A5DE76C7A3B19C2918198865", hash_generated_method = "2B733D9B6CF01BD92D315919CBD8E943")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     GpsStatus() {
        {
            int i;
            i = 0;
            {
                mSatellites[i] = new GpsSatellite(i + 1);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //for (int i = 0; i < mSatellites.length; i++) {
            //mSatellites[i] = new GpsSatellite(i + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.589 -0400", hash_original_method = "4D31391A39726BDC955321B1E3DBD71C", hash_generated_method = "68F92A3B73DEE1DAA49FC5204ADDE4A9")
    @DSModeled(DSC.SAFE)
    synchronized void setStatus(int svCount, int[] prns, float[] snrs,
            float[] elevations, float[] azimuths, int ephemerisMask,
            int almanacMask, int usedInFixMask) {
        dsTaint.addTaint(svCount);
        dsTaint.addTaint(almanacMask);
        dsTaint.addTaint(azimuths[0]);
        dsTaint.addTaint(ephemerisMask);
        dsTaint.addTaint(elevations[0]);
        dsTaint.addTaint(snrs[0]);
        dsTaint.addTaint(prns[0]);
        dsTaint.addTaint(usedInFixMask);
        int i;
        {
            i = 0;
            {
                mSatellites[i].mValid = false;
            } //End block
        } //End collapsed parenthetic
        {
            i = 0;
            {
                int prn;
                prn = prns[i] - 1;
                int prnShift;
                prnShift = (1 << prn);
                {
                    GpsSatellite satellite;
                    satellite = mSatellites[prn];
                    satellite.mValid = true;
                    satellite.mSnr = snrs[i];
                    satellite.mElevation = elevations[i];
                    satellite.mAzimuth = azimuths[i];
                    satellite.mHasEphemeris = ((ephemerisMask & prnShift) != 0);
                    satellite.mHasAlmanac = ((almanacMask & prnShift) != 0);
                    satellite.mUsedInFix = ((usedInFixMask & prnShift) != 0);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //int i;
        //for (i = 0; i < mSatellites.length; i++) {
            //mSatellites[i].mValid = false;
        //}
        //for (i = 0; i < svCount; i++) {
            //int prn = prns[i] - 1;
            //int prnShift = (1 << prn);
            //if (prn >= 0 && prn < mSatellites.length) {
                //GpsSatellite satellite = mSatellites[prn];
                //satellite.mValid = true;
                //satellite.mSnr = snrs[i];
                //satellite.mElevation = elevations[i];
                //satellite.mAzimuth = azimuths[i];
                //satellite.mHasEphemeris = ((ephemerisMask & prnShift) != 0);
                //satellite.mHasAlmanac = ((almanacMask & prnShift) != 0);
                //satellite.mUsedInFix = ((usedInFixMask & prnShift) != 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.589 -0400", hash_original_method = "C95E5E3E266CC24D44E0C8A907AC47BF", hash_generated_method = "08F25DA0E7C7FE0333616714FB629956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void setStatus(GpsStatus status) {
        dsTaint.addTaint(status.dsTaint);
        mTimeToFirstFix = status.getTimeToFirstFix();
        {
            int i;
            i = 0;
            {
                mSatellites[i].setStatus(status.mSatellites[i]);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mTimeToFirstFix = status.getTimeToFirstFix();
        //for (int i = 0; i < mSatellites.length; i++) {
            //mSatellites[i].setStatus(status.mSatellites[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.590 -0400", hash_original_method = "DB9D2F6104F17C34589316947F2A601E", hash_generated_method = "5E340A5E32F391BF196B7BE835BA4924")
    @DSModeled(DSC.SAFE)
     void setTimeToFirstFix(int ttff) {
        dsTaint.addTaint(ttff);
        // ---------- Original Method ----------
        //mTimeToFirstFix = ttff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.590 -0400", hash_original_method = "75FBD0BC51265BCFA2480910110E8F36", hash_generated_method = "4CB49EC48651225C009D778AD12383E1")
    @DSModeled(DSC.SAFE)
    public int getTimeToFirstFix() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTimeToFirstFix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.590 -0400", hash_original_method = "8623867703A7BB23EDE8EB2AB29E2B88", hash_generated_method = "6127BE97275E113AC94AC708C4A51AD8")
    @DSModeled(DSC.SAFE)
    public Iterable<GpsSatellite> getSatellites() {
        return (Iterable<GpsSatellite>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSatelliteList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.591 -0400", hash_original_method = "30B567DEF49ED207BED02E25B8D7701A", hash_generated_method = "2719D35E58F040950D5975DC6CC320FB")
    @DSModeled(DSC.SAFE)
    public int getMaxSatellites() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return NUM_SATELLITES;
    }

    
    private final class SatelliteIterator implements Iterator<GpsSatellite> {
        private GpsSatellite[] mSatellites;
        int mIndex = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.591 -0400", hash_original_method = "AEF39F6B14389CFD613D955A0F70C3EF", hash_generated_method = "AAB651E32F2A10EC3BF369E33C6B67C1")
        @DSModeled(DSC.SAFE)
         SatelliteIterator(GpsSatellite[] satellites) {
            dsTaint.addTaint(satellites[0].dsTaint);
            // ---------- Original Method ----------
            //mSatellites = satellites;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.592 -0400", hash_original_method = "280A0F6C9C24DB057056B6AC4648E027", hash_generated_method = "60386CF287297E055ECD99EB8E99D737")
        @DSModeled(DSC.SAFE)
        public boolean hasNext() {
            {
                int i;
                i = mIndex;
            } //End collapsed parenthetic
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //for (int i = mIndex; i < mSatellites.length; i++) {
                //if (mSatellites[i].mValid) {
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.592 -0400", hash_original_method = "2172205C4F18481DAEA9224F778B255B", hash_generated_method = "A66BDA61BFE71AB7F5C75BFC3C5B5312")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public GpsSatellite next() {
            {
                GpsSatellite satellite;
                satellite = mSatellites[mIndex++];
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            return (GpsSatellite)dsTaint.getTaint();
            // ---------- Original Method ----------
            //while (mIndex < mSatellites.length) {
                //GpsSatellite satellite = mSatellites[mIndex++];
                //if (satellite.mValid) {
                    //return satellite;
                //}
            //}
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.593 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            // ---------- Original Method ----------
            //throw new UnsupportedOperationException();
        }

        
    }


    
    public interface Listener {
        
        void onGpsStatusChanged(int event);
    }
    
    public interface NmeaListener {
        void onNmeaReceived(long timestamp, String nmea);
    }
    
    private static final int NUM_SATELLITES = 255;
    public static final int GPS_EVENT_STARTED = 1;
    public static final int GPS_EVENT_STOPPED = 2;
    public static final int GPS_EVENT_FIRST_FIX = 3;
    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
}

