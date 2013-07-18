package com.android.internal.telephony.ims;

// Droidsafe Imports
import static com.android.internal.telephony.IccConstants.EF_DOMAIN;
import static com.android.internal.telephony.IccConstants.EF_IMPI;
import static com.android.internal.telephony.IccConstants.EF_IMPU;

import java.nio.charset.Charset;
import java.util.ArrayList;

import android.os.AsyncResult;
import android.os.Handler;
import android.util.Log;

import com.android.internal.telephony.IccFileHandler;
import com.android.internal.telephony.IccRecords;
import com.android.internal.telephony.gsm.SimTlv;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class IsimUiccRecords implements IsimRecords {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.044 -0400", hash_original_field = "76EADD29A38BB9020CFAA25983EC4F62", hash_generated_field = "DE30CC27BA99BC0F13199E25EE20093E")

    private String mIsimImpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.044 -0400", hash_original_field = "FAC771DD0720D0AC54A49AC5FFE7D99B", hash_generated_field = "6EA5B090D057D1F1F86B721FBB59C530")

    private String mIsimDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.045 -0400", hash_original_field = "9A219EC2141C43445EC17DD7D91AC487", hash_generated_field = "061DCA8790165CF888D655A104FB4EF7")

    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.045 -0400", hash_original_method = "A25994306BA700F1CD652F8E8E6DC6B3", hash_generated_method = "A25994306BA700F1CD652F8E8E6DC6B3")
    public IsimUiccRecords ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.046 -0400", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "352C2064251271D46236216A375AAC92")
    public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        addTaint(h.getTaint());
        addTaint(iccFh.getTaint());
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        int varECCBC87E4B5CE2FE28308FD9F2A7BAF3_204789669 = (3);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675774518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675774518;
        // ---------- Original Method ----------
        //iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                //IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        //iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                //IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        //iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                //IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        //return 3;
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.047 -0400", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "6166A4B4E5C0FBE8D8969844DBA01BDC")
     void log(String s) {
        addTaint(s.getTaint());
        if(DBG)        
        Log.d(LOG_TAG, "[ISIM] " + s);
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.047 -0400", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "81BB7FA7F08AFFBF91627F1973E1BD2A")
     void loge(String s) {
        addTaint(s.getTaint());
        if(DBG){ }
        // ---------- Original Method ----------
        //if (DBG) Log.e(LOG_TAG, "[ISIM] " + s);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.048 -0400", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "F0C421D21833DFD472DE9260B22160F8")
    public String getIsimImpi() {
String var1D9CDF2A60EDFA3FC6494E4EA3FF7172_1864345062 =         mIsimImpi;
        var1D9CDF2A60EDFA3FC6494E4EA3FF7172_1864345062.addTaint(taint);
        return var1D9CDF2A60EDFA3FC6494E4EA3FF7172_1864345062;
        // ---------- Original Method ----------
        //return mIsimImpi;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.048 -0400", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "19960B5F0B8A6EE685BF94832E9D473F")
    public String getIsimDomain() {
String varEDA38A6132AFDA573E134F78457A391B_1374473781 =         mIsimDomain;
        varEDA38A6132AFDA573E134F78457A391B_1374473781.addTaint(taint);
        return varEDA38A6132AFDA573E134F78457A391B_1374473781;
        // ---------- Original Method ----------
        //return mIsimDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.049 -0400", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "DB4398365403049CC3FD7989EBBB045E")
    public String[] getIsimImpu() {
String[] var460EEB9014B84B45A549101AD23A732D_1906269700 =         (mIsimImpu != null) ? mIsimImpu.clone() : null;
        var460EEB9014B84B45A549101AD23A732D_1906269700.addTaint(taint);
        return var460EEB9014B84B45A549101AD23A732D_1906269700;
        // ---------- Original Method ----------
        //return (mIsimImpu != null) ? mIsimImpu.clone() : null;
    }

    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.050 -0400", hash_original_method = "1648BD81357865C3A3E303A2434827DF", hash_generated_method = "1648BD81357865C3A3E303A2434827DF")
        public EfIsimImpiLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.050 -0400", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "00F732A754F17BB17070A48F510DA2A3")
        public String getEfName() {
String var8674027D88476581C69AA5BD2AB58569_1364648055 =             "EF_ISIM_IMPI";
            var8674027D88476581C69AA5BD2AB58569_1364648055.addTaint(taint);
            return var8674027D88476581C69AA5BD2AB58569_1364648055;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPI";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.051 -0400", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "979C0396888DDB124C46C1A00D64E975")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            byte[] data = (byte[]) ar.result;
            mIsimImpi = isimTlvToString(data);
            if(DUMP_RECORDS)            
            log("EF_IMPI=" + mIsimImpi);
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //mIsimImpi = isimTlvToString(data);
            //if (DUMP_RECORDS) log("EF_IMPI=" + mIsimImpi);
        }

        
    }


    
    private class EfIsimImpuLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.051 -0400", hash_original_method = "D36761040F857F140719B8DB530580FC", hash_generated_method = "D36761040F857F140719B8DB530580FC")
        public EfIsimImpuLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.052 -0400", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "C97E903A262600809669216F036C3FCE")
        public String getEfName() {
String var3AF90F29E4FFA7FDFF74D17A8F27F21D_1271903831 =             "EF_ISIM_IMPU";
            var3AF90F29E4FFA7FDFF74D17A8F27F21D_1271903831.addTaint(taint);
            return var3AF90F29E4FFA7FDFF74D17A8F27F21D_1271903831;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPU";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.053 -0400", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "1590CE539B03CC5C1780677116074ADE")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            ArrayList<byte[]> impuList = (ArrayList<byte[]>) ar.result;
            if(DBG)            
            log("EF_IMPU record count: " + impuList.size());
            mIsimImpu = new String[impuList.size()];
            int i = 0;
for(byte[] identity : impuList)
            {
                String impu = isimTlvToString(identity);
                if(DUMP_RECORDS)                
                log("EF_IMPU[" + i + "]=" + impu);
                mIsimImpu[i++] = impu;
            } //End block
            // ---------- Original Method ----------
            //ArrayList<byte[]> impuList = (ArrayList<byte[]>) ar.result;
            //if (DBG) log("EF_IMPU record count: " + impuList.size());
            //mIsimImpu = new String[impuList.size()];
            //int i = 0;
            //for (byte[] identity : impuList) {
                //String impu = isimTlvToString(identity);
                //if (DUMP_RECORDS) log("EF_IMPU[" + i + "]=" + impu);
                //mIsimImpu[i++] = impu;
            //}
        }

        
    }


    
    private class EfIsimDomainLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.053 -0400", hash_original_method = "0E7AAEB3F527509DE6629FF8F10D67B7", hash_generated_method = "0E7AAEB3F527509DE6629FF8F10D67B7")
        public EfIsimDomainLoaded ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.054 -0400", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "E3E4EFC83E973D7D431F0C599A3D594C")
        public String getEfName() {
String var1A700BEF13E1FED8405541952A0C927E_102181472 =             "EF_ISIM_DOMAIN";
            var1A700BEF13E1FED8405541952A0C927E_102181472.addTaint(taint);
            return var1A700BEF13E1FED8405541952A0C927E_102181472;
            // ---------- Original Method ----------
            //return "EF_ISIM_DOMAIN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.054 -0400", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "E8DB62EC60B6809AABAADDBE723151BE")
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(ar.getTaint());
            byte[] data = (byte[]) ar.result;
            mIsimDomain = isimTlvToString(data);
            if(DUMP_RECORDS)            
            log("EF_DOMAIN=" + mIsimDomain);
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //mIsimDomain = isimTlvToString(data);
            //if (DUMP_RECORDS) log("EF_DOMAIN=" + mIsimDomain);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.055 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "BD940BC52C3AB14198F71CB81F0E8FEB")

    protected static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.055 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.055 -0400", hash_original_field = "67335754D34F1A97E3C5D836EF1E262E", hash_generated_field = "8B06C3B6BF00D7D43F66466D5AB2B4FD")

    private static final boolean DUMP_RECORDS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.055 -0400", hash_original_field = "52F35D2F31EF37FE0F6B7B218FB7FDA4", hash_generated_field = "C529ECF6947054FFE9397A031D3E9F83")

    private static final int TAG_ISIM_VALUE = 0x80;
}

