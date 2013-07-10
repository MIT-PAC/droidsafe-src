package android.location;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class GpsStatus {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.272 -0400", hash_original_field = "FCBDFF9CD61B42CBD11DCD3DF89F6516", hash_generated_field = "78EE48E2F626F172C233CA900DAE1C08")

    private int mTimeToFirstFix;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.272 -0400", hash_original_field = "A2BCA55A95F3D934F880D67C8D810BFE", hash_generated_field = "EDAAB9E07CB6E2788A4305484F8C91B2")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.274 -0400", hash_original_method = "8CEA7166A5DE76C7A3B19C2918198865", hash_generated_method = "0985E819AC7988FEA241FE89A7577086")
      GpsStatus() {
        {
            int i = 0;
            {
                mSatellites[i] = new GpsSatellite(i + 1);
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.275 -0400", hash_original_method = "4D31391A39726BDC955321B1E3DBD71C", hash_generated_method = "5049B51F2B6450B07DD9CBBF08DD28CF")
    synchronized void setStatus(int svCount, int[] prns, float[] snrs,
            float[] elevations, float[] azimuths, int ephemerisMask,
            int almanacMask, int usedInFixMask) {
        int i;
        {
            i = 0;
            {
                mSatellites[i].mValid = false;
            } 
        } 
        {
            i = 0;
            {
                int prn = prns[i] - 1;
                int prnShift = (1 << prn);
                {
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
        addTaint(svCount);
        addTaint(prns[0]);
        addTaint(snrs[0]);
        addTaint(elevations[0]);
        addTaint(azimuths[0]);
        addTaint(ephemerisMask);
        addTaint(almanacMask);
        addTaint(usedInFixMask);
        
        
        
            
        
        
            
            
            
                
                
                
                
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.275 -0400", hash_original_method = "C95E5E3E266CC24D44E0C8A907AC47BF", hash_generated_method = "47272AB0FCA5F0D08E4374E6644987F4")
     void setStatus(GpsStatus status) {
        mTimeToFirstFix = status.getTimeToFirstFix();
        {
            int i = 0;
            {
                mSatellites[i].setStatus(status.mSatellites[i]);
            } 
        } 
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.276 -0400", hash_original_method = "DB9D2F6104F17C34589316947F2A601E", hash_generated_method = "67EFC13BBD63DDF4ED5824FCE6033C6E")
     void setTimeToFirstFix(int ttff) {
        mTimeToFirstFix = ttff;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.276 -0400", hash_original_method = "75FBD0BC51265BCFA2480910110E8F36", hash_generated_method = "6EB4487648650506D3C666FE2C0A60C2")
    public int getTimeToFirstFix() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147016549 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_147016549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.276 -0400", hash_original_method = "8623867703A7BB23EDE8EB2AB29E2B88", hash_generated_method = "3C1C185293B8FC0F4DAF858E1FF2C4A3")
    public Iterable<GpsSatellite> getSatellites() {
        Iterable<GpsSatellite> varB4EAC82CA7396A68D541C85D26508E83_83621081 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_83621081 = mSatelliteList;
        varB4EAC82CA7396A68D541C85D26508E83_83621081.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_83621081;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.277 -0400", hash_original_method = "30B567DEF49ED207BED02E25B8D7701A", hash_generated_method = "6CC408F02BDC02A093E0305443A61760")
    public int getMaxSatellites() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652142535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652142535;
        
        
    }

    
    private final class SatelliteIterator implements Iterator<GpsSatellite> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.277 -0400", hash_original_field = "88C97CD32989A16088F0DB4AC1E50574", hash_generated_field = "A2118CDC10EB9E5F1F9C0A975C1188EF")

        private GpsSatellite[] mSatellites;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.277 -0400", hash_original_field = "7DCDB6E9F0938C4952C91E77FC09D32F", hash_generated_field = "53702B6348E11EAA55A0AB4A37AFE1D9")

        int mIndex = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.277 -0400", hash_original_method = "AEF39F6B14389CFD613D955A0F70C3EF", hash_generated_method = "28BB9F681E40E1A19CFE5F015D2B2BB4")
          SatelliteIterator(GpsSatellite[] satellites) {
            mSatellites = satellites;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.278 -0400", hash_original_method = "280A0F6C9C24DB057056B6AC4648E027", hash_generated_method = "C1708BF972B082821CD0EFD8AE5971F8")
        public boolean hasNext() {
            {
                int i = mIndex;
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_278014677 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_278014677;
            
            
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_method = "2172205C4F18481DAEA9224F778B255B", hash_generated_method = "D416D4413A134582AD6633D2AC968EA3")
        public GpsSatellite next() {
            GpsSatellite varB4EAC82CA7396A68D541C85D26508E83_963270405 = null; 
            {
                GpsSatellite satellite = mSatellites[mIndex++];
                {
                    varB4EAC82CA7396A68D541C85D26508E83_963270405 = satellite;
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new NoSuchElementException();
            varB4EAC82CA7396A68D541C85D26508E83_963270405.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_963270405;
            
            
                
                
                    
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_method = "89C642158183FED064530A14F092CD81", hash_generated_method = "BD0416D7797F4CCA5C01710103DCE99D")
        public void remove() {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
            
            
        }

        
    }


    
    public interface Listener {
        
        void onGpsStatusChanged(int event);
    }
    
    public interface NmeaListener {
        void onNmeaReceived(long timestamp, String nmea);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_field = "2E8AA964AF15D6665ED20B4D67DC09A9", hash_generated_field = "9525E23D06AB56F41AB5F5DADBC87DF3")

    private static final int NUM_SATELLITES = 255;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_field = "6383B07DD1A466DFDCEDBAB8793344CA", hash_generated_field = "0ACD894DFE78BC1B9FEB64A231971868")

    public static final int GPS_EVENT_STARTED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_field = "5D412DB8B861E276B1B98F2FA20F9062", hash_generated_field = "77513145C112B8A862D695A1610CD109")

    public static final int GPS_EVENT_STOPPED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_field = "7E53017A9B3BE35D871DD5C1A55A397E", hash_generated_field = "1FE0287016FA42F3CFE36BF2509A2AA6")

    public static final int GPS_EVENT_FIRST_FIX = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:35.279 -0400", hash_original_field = "5434F9B2BF87B95481BF5BC0BF04790B", hash_generated_field = "39BADCF7553465D00B65E2D6552B3AC0")

    public static final int GPS_EVENT_SATELLITE_STATUS = 4;
}

