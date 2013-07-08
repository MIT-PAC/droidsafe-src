package com.android.internal.telephony.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.AsyncResult;
import android.os.Handler;
import android.util.Log;
import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.gsm.SimTlv;
import java.nio.charset.Charset;
import java.util.ArrayList;
import static com.android.internal.telephony.IccConstants.EF_DOMAIN;
import static com.android.internal.telephony.IccConstants.EF_IMPI;
import static com.android.internal.telephony.IccConstants.EF_IMPU;

public final class IsimUiccRecords implements IsimRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.980 -0400", hash_original_field = "76EADD29A38BB9020CFAA25983EC4F62", hash_generated_field = "DE30CC27BA99BC0F13199E25EE20093E")

    private String mIsimImpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.980 -0400", hash_original_field = "FAC771DD0720D0AC54A49AC5FFE7D99B", hash_generated_field = "6EA5B090D057D1F1F86B721FBB59C530")

    private String mIsimDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.980 -0400", hash_original_field = "9A219EC2141C43445EC17DD7D91AC487", hash_generated_field = "061DCA8790165CF888D655A104FB4EF7")

    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.980 -0400", hash_original_method = "A25994306BA700F1CD652F8E8E6DC6B3", hash_generated_method = "A25994306BA700F1CD652F8E8E6DC6B3")
    public IsimUiccRecords ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.981 -0400", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "7CFBBAD4E8DCC7865E5EBB356ECD8BD0")
    public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        addTaint(iccFh.getTaint());
        addTaint(h.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839590873 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_839590873;
        
        
                
        
                
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    private static String isimTlvToString(byte[] record) {
        SimTlv tlv = new SimTlv(record, 0, record.length);
        do {
            if (tlv.getTag() == TAG_ISIM_VALUE) {
                return new String(tlv.getData(), Charset.forName("UTF-8"));
            }
        } while (tlv.nextObject());
        Log.e(LOG_TAG, "[ISIM] can't find TLV tag in ISIM record, returning null");
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.981 -0400", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "71749375D668833545085B2FF632AEC7")
     void log(String s) {
        Log.d(LOG_TAG, "[ISIM] " + s);
        addTaint(s.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.982 -0400", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "8C7FFEF49AD2265CA109C917D25E8D3D")
     void loge(String s) {
        addTaint(s.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.982 -0400", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "39C97CE94834141F066EC5B44E85555B")
    public String getIsimImpi() {
        String varB4EAC82CA7396A68D541C85D26508E83_314820319 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_314820319 = mIsimImpi;
        varB4EAC82CA7396A68D541C85D26508E83_314820319.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_314820319;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.983 -0400", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "6EB3D26A635D2E8718FEDA5F3FFA256E")
    public String getIsimDomain() {
        String varB4EAC82CA7396A68D541C85D26508E83_1932871839 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1932871839 = mIsimDomain;
        varB4EAC82CA7396A68D541C85D26508E83_1932871839.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1932871839;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.984 -0400", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "BA139C01BF97ED122E5D11ED010E3888")
    public String[] getIsimImpu() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2066471481 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2066471481 = (mIsimImpu != null) ? mIsimImpu.clone() : null;
        varB4EAC82CA7396A68D541C85D26508E83_2066471481.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2066471481;
        
        
    }

    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.984 -0400", hash_original_method = "1648BD81357865C3A3E303A2434827DF", hash_generated_method = "1648BD81357865C3A3E303A2434827DF")
        public EfIsimImpiLoaded ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.984 -0400", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "7178950E2FDE4FE01AD79B06F0E23470")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1950306373 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1950306373 = "EF_ISIM_IMPI";
            varB4EAC82CA7396A68D541C85D26508E83_1950306373.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1950306373;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.985 -0400", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "2FF6A27BB0D3A86CA06715A5D8ED73A4")
        public void onRecordLoaded(AsyncResult ar) {
            
            byte[] data = (byte[]) ar.result;
            mIsimImpi = isimTlvToString(data);
            log("EF_IMPI=" + mIsimImpi);
            addTaint(ar.getTaint());
            
            
            
            
        }

        
    }


    
    private class EfIsimImpuLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.985 -0400", hash_original_method = "D36761040F857F140719B8DB530580FC", hash_generated_method = "D36761040F857F140719B8DB530580FC")
        public EfIsimImpuLoaded ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.986 -0400", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "4381216760DA5FDA7B19C349F405C2F1")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_1668018052 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1668018052 = "EF_ISIM_IMPU";
            varB4EAC82CA7396A68D541C85D26508E83_1668018052.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1668018052;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.994 -0400", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "F87D2EEB35466391C7E9794184481DA9")
        public void onRecordLoaded(AsyncResult ar) {
            
            ArrayList<byte[]> impuList = (ArrayList<byte[]>) ar.result;
            log("EF_IMPU record count: " + impuList.size());
            mIsimImpu = new String[impuList.size()];
            int i = 0;
            {
                Iterator<byte[]> var5BCC2EE5D00C9451553D406F293D94B3_621243929 = (impuList).iterator();
                var5BCC2EE5D00C9451553D406F293D94B3_621243929.hasNext();
                byte[] identity = var5BCC2EE5D00C9451553D406F293D94B3_621243929.next();
                {
                    String impu = isimTlvToString(identity);
                    log("EF_IMPU[" + i + "]=" + impu);
                    mIsimImpu[i++] = impu;
                } 
            } 
            addTaint(ar.getTaint());
            
            
            
            
            
            
                
                
                
            
        }

        
    }


    
    private class EfIsimDomainLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.994 -0400", hash_original_method = "0E7AAEB3F527509DE6629FF8F10D67B7", hash_generated_method = "0E7AAEB3F527509DE6629FF8F10D67B7")
        public EfIsimDomainLoaded ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.995 -0400", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "0AD1B22CE87A1053F6F8FA77CD60519E")
        public String getEfName() {
            String varB4EAC82CA7396A68D541C85D26508E83_507251467 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_507251467 = "EF_ISIM_DOMAIN";
            varB4EAC82CA7396A68D541C85D26508E83_507251467.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_507251467;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.995 -0400", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "D192C690D8427E8A1C501811A198DFE7")
        public void onRecordLoaded(AsyncResult ar) {
            
            byte[] data = (byte[]) ar.result;
            mIsimDomain = isimTlvToString(data);
            log("EF_DOMAIN=" + mIsimDomain);
            addTaint(ar.getTaint());
            
            
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.995 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "BD940BC52C3AB14198F71CB81F0E8FEB")

    protected static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.995 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.995 -0400", hash_original_field = "67335754D34F1A97E3C5D836EF1E262E", hash_generated_field = "8B06C3B6BF00D7D43F66466D5AB2B4FD")

    private static final boolean DUMP_RECORDS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:31.995 -0400", hash_original_field = "52F35D2F31EF37FE0F6B7B218FB7FDA4", hash_generated_field = "C529ECF6947054FFE9397A031D3E9F83")

    private static final int TAG_ISIM_VALUE = 0x80;
}

