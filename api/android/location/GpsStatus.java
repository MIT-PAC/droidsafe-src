package android.location;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class GpsStatus {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.139 -0400", hash_original_field = "FCBDFF9CD61B42CBD11DCD3DF89F6516", hash_generated_field = "78EE48E2F626F172C233CA900DAE1C08")

    private int mTimeToFirstFix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.139 -0400", hash_original_field = "A2BCA55A95F3D934F880D67C8D810BFE", hash_generated_field = "EDAAB9E07CB6E2788A4305484F8C91B2")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.139 -0400", hash_original_method = "8CEA7166A5DE76C7A3B19C2918198865", hash_generated_method = "22DF5116963BA369B5154DD021E43B3F")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.142 -0400", hash_original_method = "4D31391A39726BDC955321B1E3DBD71C", hash_generated_method = "A28F53ECC274DFA52ECD3C33E343ED71")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.143 -0400", hash_original_method = "C95E5E3E266CC24D44E0C8A907AC47BF", hash_generated_method = "215377E14F11A9BF427F6FF70BAF10D6")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.144 -0400", hash_original_method = "DB9D2F6104F17C34589316947F2A601E", hash_generated_method = "67EFC13BBD63DDF4ED5824FCE6033C6E")
     void setTimeToFirstFix(int ttff) {
        mTimeToFirstFix = ttff;
        // ---------- Original Method ----------
        //mTimeToFirstFix = ttff;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.145 -0400", hash_original_method = "75FBD0BC51265BCFA2480910110E8F36", hash_generated_method = "83A9A11FE7E64F2B81B1FB2E8664977F")
    public int getTimeToFirstFix() {
        int varFCBDFF9CD61B42CBD11DCD3DF89F6516_279394931 = (mTimeToFirstFix);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400137868 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_400137868;
        // ---------- Original Method ----------
        //return mTimeToFirstFix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.145 -0400", hash_original_method = "8623867703A7BB23EDE8EB2AB29E2B88", hash_generated_method = "8894DDB6A8736A3475E4044E6EB183B5")
    public Iterable<GpsSatellite> getSatellites() {
Iterable<GpsSatellite> varE7F4188585FE55A58108466B6F8F81B3_1596348753 =         mSatelliteList;
        varE7F4188585FE55A58108466B6F8F81B3_1596348753.addTaint(taint);
        return varE7F4188585FE55A58108466B6F8F81B3_1596348753;
        // ---------- Original Method ----------
        //return mSatelliteList;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.146 -0400", hash_original_method = "30B567DEF49ED207BED02E25B8D7701A", hash_generated_method = "6531A05D8C87FE32D172910D5BE453B2")
    public int getMaxSatellites() {
        int varE993D75990E944E225140A81B1DBF272_247134050 = (NUM_SATELLITES);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894938944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1894938944;
        // ---------- Original Method ----------
        //return NUM_SATELLITES;
    }

    
    private final class SatelliteIterator implements Iterator<GpsSatellite> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.146 -0400", hash_original_field = "88C97CD32989A16088F0DB4AC1E50574", hash_generated_field = "A2118CDC10EB9E5F1F9C0A975C1188EF")

        private GpsSatellite[] mSatellites;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.146 -0400", hash_original_field = "7DCDB6E9F0938C4952C91E77FC09D32F", hash_generated_field = "53702B6348E11EAA55A0AB4A37AFE1D9")

        int mIndex = 0;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.146 -0400", hash_original_method = "AEF39F6B14389CFD613D955A0F70C3EF", hash_generated_method = "28BB9F681E40E1A19CFE5F015D2B2BB4")
          SatelliteIterator(GpsSatellite[] satellites) {
            mSatellites = satellites;
            // ---------- Original Method ----------
            //mSatellites = satellites;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.148 -0400", hash_original_method = "280A0F6C9C24DB057056B6AC4648E027", hash_generated_method = "DDFDB7794779DFEA8ABBFB14BD36EEB3")
        public boolean hasNext() {
for(int i = mIndex;i < mSatellites.length;i++)
            {
                if(mSatellites[i].mValid)                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1658654105 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523772193 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523772193;
                } //End block
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_1183072871 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659918271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_659918271;
            // ---------- Original Method ----------
            //for (int i = mIndex; i < mSatellites.length; i++) {
                //if (mSatellites[i].mValid) {
                    //return true;
                //}
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.150 -0400", hash_original_method = "2172205C4F18481DAEA9224F778B255B", hash_generated_method = "CE86E1477FE66DEAEB111AABD1FDFAD7")
        public GpsSatellite next() {
            while
(mIndex < mSatellites.length)            
            {
                GpsSatellite satellite = mSatellites[mIndex++];
                if(satellite.mValid)                
                {
GpsSatellite var8CA29B14779F45CBE6C9A07E84A36A9D_112372875 =                     satellite;
                    var8CA29B14779F45CBE6C9A07E84A36A9D_112372875.addTaint(taint);
                    return var8CA29B14779F45CBE6C9A07E84A36A9D_112372875;
                } //End block
            } //End block
            NoSuchElementException var28D00AB599969908D71F102AF992D49A_991324612 = new NoSuchElementException();
            var28D00AB599969908D71F102AF992D49A_991324612.addTaint(taint);
            throw var28D00AB599969908D71F102AF992D49A_991324612;
            // ---------- Original Method ----------
            //while (mIndex < mSatellites.length) {
                //GpsSatellite satellite = mSatellites[mIndex++];
                //if (satellite.mValid) {
                    //return satellite;
                //}
            //}
            //throw new NoSuchElementException();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.151 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "CA5F1F4803F67020FF6133F9DACD5199")
        public void remove() {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2000569704 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_2000569704.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_2000569704;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.151 -0400", hash_original_field = "2E8AA964AF15D6665ED20B4D67DC09A9", hash_generated_field = "9525E23D06AB56F41AB5F5DADBC87DF3")

    private static final int NUM_SATELLITES = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.151 -0400", hash_original_field = "6383B07DD1A466DFDCEDBAB8793344CA", hash_generated_field = "0ACD894DFE78BC1B9FEB64A231971868")

    public static final int GPS_EVENT_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.151 -0400", hash_original_field = "5D412DB8B861E276B1B98F2FA20F9062", hash_generated_field = "77513145C112B8A862D695A1610CD109")

    public static final int GPS_EVENT_STOPPED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.151 -0400", hash_original_field = "7E53017A9B3BE35D871DD5C1A55A397E", hash_generated_field = "1FE0287016FA42F3CFE36BF2509A2AA6")

    public static final int GPS_EVENT_FIRST_FIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:15.152 -0400", hash_original_field = "5434F9B2BF87B95481BF5BC0BF04790B", hash_generated_field = "39BADCF7553465D00B65E2D6552B3AC0")

    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
}

