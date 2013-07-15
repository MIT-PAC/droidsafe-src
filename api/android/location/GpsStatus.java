package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class GpsStatus {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.805 -0400", hash_original_field = "FCBDFF9CD61B42CBD11DCD3DF89F6516", hash_generated_field = "78EE48E2F626F172C233CA900DAE1C08")

    private int mTimeToFirstFix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.805 -0400", hash_original_field = "A2BCA55A95F3D934F880D67C8D810BFE", hash_generated_field = "EDAAB9E07CB6E2788A4305484F8C91B2")

    private GpsSatellite mSatellites[] = new GpsSatellite[NUM_SATELLITES];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.273 -0400", hash_original_field = "2DF85302EF31B22A6E1E6CB995BF0173", hash_generated_field = "4E2BE773D59F171305B1D8BC86C6191A")

    private Iterable<GpsSatellite> mSatelliteList = new Iterable<GpsSatellite>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.273 -0400", hash_original_method = "9983CD5442E4C518DD699220FBA30311", hash_generated_method = "D802BB52D632FD31E6502E4338BAE5D2")
        public Iterator<GpsSatellite> iterator() {
            Iterator<GpsSatellite> varB4EAC82CA7396A68D541C85D26508E83_399552892 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_399552892 = new SatelliteIterator(mSatellites);
            varB4EAC82CA7396A68D541C85D26508E83_399552892.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_399552892;
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.806 -0400", hash_original_method = "8CEA7166A5DE76C7A3B19C2918198865", hash_generated_method = "22DF5116963BA369B5154DD021E43B3F")
      GpsStatus() {
for(int i = 0;i < mSatellites.length;i++)
        {
            mSatellites[i] = new GpsSatellite(i + 1);
        } //End block
        // ---------- Original Method ----------
        //for (int i = 0; i < mSatellites.length; i++) {
            //mSatellites[i] = new GpsSatellite(i + 1);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.808 -0400", hash_original_method = "4D31391A39726BDC955321B1E3DBD71C", hash_generated_method = "A28F53ECC274DFA52ECD3C33E343ED71")
    synchronized void setStatus(int svCount, int[] prns, float[] snrs,
            float[] elevations, float[] azimuths, int ephemerisMask,
            int almanacMask, int usedInFixMask) {
        addTaint(usedInFixMask);
        addTaint(almanacMask);
        addTaint(ephemerisMask);
        addTaint(azimuths[0]);
        addTaint(elevations[0]);
        addTaint(snrs[0]);
        addTaint(prns[0]);
        addTaint(svCount);
        int i;
for(i = 0;i < mSatellites.length;i++)
        {
            mSatellites[i].mValid = false;
        } //End block
for(i = 0;i < svCount;i++)
        {
            int prn = prns[i] - 1;
            int prnShift = (1 << prn);
    if(prn >= 0 && prn < mSatellites.length)            
            {
                GpsSatellite satellite = mSatellites[prn];
                satellite.mValid = true;
                satellite.mSnr = snrs[i];
                satellite.mElevation = elevations[i];
                satellite.mAzimuth = azimuths[i];
                satellite.mHasEphemeris = ((ephemerisMask & prnShift) != 0);
                satellite.mHasAlmanac = ((almanacMask & prnShift) != 0);
                satellite.mUsedInFix = ((usedInFixMask & prnShift) != 0);
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.809 -0400", hash_original_method = "C95E5E3E266CC24D44E0C8A907AC47BF", hash_generated_method = "215377E14F11A9BF427F6FF70BAF10D6")
     void setStatus(GpsStatus status) {
        mTimeToFirstFix = status.getTimeToFirstFix();
for(int i = 0;i < mSatellites.length;i++)
        {
            mSatellites[i].setStatus(status.mSatellites[i]);
        } //End block
        // ---------- Original Method ----------
        //mTimeToFirstFix = status.getTimeToFirstFix();
        //for (int i = 0; i < mSatellites.length; i++) {
            //mSatellites[i].setStatus(status.mSatellites[i]);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.810 -0400", hash_original_method = "DB9D2F6104F17C34589316947F2A601E", hash_generated_method = "67EFC13BBD63DDF4ED5824FCE6033C6E")
     void setTimeToFirstFix(int ttff) {
        mTimeToFirstFix = ttff;
        // ---------- Original Method ----------
        //mTimeToFirstFix = ttff;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.810 -0400", hash_original_method = "75FBD0BC51265BCFA2480910110E8F36", hash_generated_method = "379A11AA44D1E96B6F26DAF3707CD9A6")
    public int getTimeToFirstFix() {
        int varFCBDFF9CD61B42CBD11DCD3DF89F6516_1346574244 = (mTimeToFirstFix);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079444257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2079444257;
        // ---------- Original Method ----------
        //return mTimeToFirstFix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.811 -0400", hash_original_method = "8623867703A7BB23EDE8EB2AB29E2B88", hash_generated_method = "BA4B0F6892FD5AA64B348FE1BF63CB74")
    public Iterable<GpsSatellite> getSatellites() {
Iterable<GpsSatellite> varE7F4188585FE55A58108466B6F8F81B3_48896212 =         mSatelliteList;
        varE7F4188585FE55A58108466B6F8F81B3_48896212.addTaint(taint);
        return varE7F4188585FE55A58108466B6F8F81B3_48896212;
        // ---------- Original Method ----------
        //return mSatelliteList;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.811 -0400", hash_original_method = "30B567DEF49ED207BED02E25B8D7701A", hash_generated_method = "FA2CB0BD9896F06CB766714528EFF524")
    public int getMaxSatellites() {
        int varE993D75990E944E225140A81B1DBF272_1440028154 = (NUM_SATELLITES);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821017959 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_821017959;
        // ---------- Original Method ----------
        //return NUM_SATELLITES;
    }

    
    private final class SatelliteIterator implements Iterator<GpsSatellite> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.811 -0400", hash_original_field = "88C97CD32989A16088F0DB4AC1E50574", hash_generated_field = "A2118CDC10EB9E5F1F9C0A975C1188EF")

        private GpsSatellite[] mSatellites;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.812 -0400", hash_original_field = "7DCDB6E9F0938C4952C91E77FC09D32F", hash_generated_field = "53702B6348E11EAA55A0AB4A37AFE1D9")

        int mIndex = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.812 -0400", hash_original_method = "AEF39F6B14389CFD613D955A0F70C3EF", hash_generated_method = "28BB9F681E40E1A19CFE5F015D2B2BB4")
          SatelliteIterator(GpsSatellite[] satellites) {
            mSatellites = satellites;
            // ---------- Original Method ----------
            //mSatellites = satellites;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.812 -0400", hash_original_method = "280A0F6C9C24DB057056B6AC4648E027", hash_generated_method = "02C7DC5A50DCE29E5C93549882488EA6")
        public boolean hasNext() {
for(int i = mIndex;i < mSatellites.length;i++)
            {
    if(mSatellites[i].mValid)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1571619584 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590453888 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_590453888;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_2084593858 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1579449602 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1579449602;
            // ---------- Original Method ----------
            //for (int i = mIndex; i < mSatellites.length; i++) {
                //if (mSatellites[i].mValid) {
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.813 -0400", hash_original_method = "2172205C4F18481DAEA9224F778B255B", hash_generated_method = "26577F79DEB0A008B735488A72A22A36")
        public GpsSatellite next() {
            while
(mIndex < mSatellites.length)            
            {
                GpsSatellite satellite = mSatellites[mIndex++];
    if(satellite.mValid)                
                {
GpsSatellite var8CA29B14779F45CBE6C9A07E84A36A9D_1066476492 =                     satellite;
                    var8CA29B14779F45CBE6C9A07E84A36A9D_1066476492.addTaint(taint);
                    return var8CA29B14779F45CBE6C9A07E84A36A9D_1066476492;
                } //End block
            } //End block
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_382611732 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_382611732.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_382611732;
            // ---------- Original Method ----------
            //while (mIndex < mSatellites.length) {
                //GpsSatellite satellite = mSatellites[mIndex++];
                //if (satellite.mValid) {
                    //return satellite;
                //}
            //}
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.815 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "9C07EA8AEC2969B4E7FA986820FCA220")
        public void remove() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1301689122 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_1301689122.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_1301689122;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.816 -0400", hash_original_field = "2E8AA964AF15D6665ED20B4D67DC09A9", hash_generated_field = "9525E23D06AB56F41AB5F5DADBC87DF3")

    private static final int NUM_SATELLITES = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.816 -0400", hash_original_field = "6383B07DD1A466DFDCEDBAB8793344CA", hash_generated_field = "0ACD894DFE78BC1B9FEB64A231971868")

    public static final int GPS_EVENT_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.816 -0400", hash_original_field = "5D412DB8B861E276B1B98F2FA20F9062", hash_generated_field = "77513145C112B8A862D695A1610CD109")

    public static final int GPS_EVENT_STOPPED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.816 -0400", hash_original_field = "7E53017A9B3BE35D871DD5C1A55A397E", hash_generated_field = "1FE0287016FA42F3CFE36BF2509A2AA6")

    public static final int GPS_EVENT_FIRST_FIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.816 -0400", hash_original_field = "5434F9B2BF87B95481BF5BC0BF04790B", hash_generated_field = "39BADCF7553465D00B65E2D6552B3AC0")

    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
}

