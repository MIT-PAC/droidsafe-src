package com.android.internal.telephony.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.049 -0400", hash_original_field = "76EADD29A38BB9020CFAA25983EC4F62", hash_generated_field = "DE30CC27BA99BC0F13199E25EE20093E")

    private String mIsimImpi;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.050 -0400", hash_original_field = "FAC771DD0720D0AC54A49AC5FFE7D99B", hash_generated_field = "6EA5B090D057D1F1F86B721FBB59C530")

    private String mIsimDomain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.050 -0400", hash_original_field = "9A219EC2141C43445EC17DD7D91AC487", hash_generated_field = "061DCA8790165CF888D655A104FB4EF7")

    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.050 -0400", hash_original_method = "A25994306BA700F1CD652F8E8E6DC6B3", hash_generated_method = "A25994306BA700F1CD652F8E8E6DC6B3")
    public IsimUiccRecords ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.051 -0400", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "0C9B5093D518CAF02E6500CCAD25A353")
    public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        addTaint(h.getTaint());
        addTaint(iccFh.getTaint());
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        int varECCBC87E4B5CE2FE28308FD9F2A7BAF3_972946619 = (3);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121813573 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2121813573;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.052 -0400", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "6166A4B4E5C0FBE8D8969844DBA01BDC")
     void log(String s) {
        addTaint(s.getTaint());
    if(DBG)        
        Log.d(LOG_TAG, "[ISIM] " + s);
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.052 -0400", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "81BB7FA7F08AFFBF91627F1973E1BD2A")
     void loge(String s) {
        addTaint(s.getTaint());
    if(DBG){ }
        // ---------- Original Method ----------
        //if (DBG) Log.e(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.052 -0400", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "7BAE19A7B5C9282DD30F2254911B05C2")
    public String getIsimImpi() {
String var1D9CDF2A60EDFA3FC6494E4EA3FF7172_282363113 =         mIsimImpi;
        var1D9CDF2A60EDFA3FC6494E4EA3FF7172_282363113.addTaint(taint);
        return var1D9CDF2A60EDFA3FC6494E4EA3FF7172_282363113;
        // ---------- Original Method ----------
        //return mIsimImpi;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.053 -0400", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "B873DDB483099297198FBA4164C392C5")
    public String getIsimDomain() {
String varEDA38A6132AFDA573E134F78457A391B_1509429578 =         mIsimDomain;
        varEDA38A6132AFDA573E134F78457A391B_1509429578.addTaint(taint);
        return varEDA38A6132AFDA573E134F78457A391B_1509429578;
        // ---------- Original Method ----------
        //return mIsimDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.053 -0400", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "BD17C64A311C208FCDC45BB6F3BE5844")
    public String[] getIsimImpu() {
String[] var460EEB9014B84B45A549101AD23A732D_1716388841 =         (mIsimImpu != null) ? mIsimImpu.clone() : null;
        var460EEB9014B84B45A549101AD23A732D_1716388841.addTaint(taint);
        return var460EEB9014B84B45A549101AD23A732D_1716388841;
        // ---------- Original Method ----------
        //return (mIsimImpu != null) ? mIsimImpu.clone() : null;
    }

    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.053 -0400", hash_original_method = "1648BD81357865C3A3E303A2434827DF", hash_generated_method = "1648BD81357865C3A3E303A2434827DF")
        public EfIsimImpiLoaded ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.053 -0400", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "5506792D7C2A099DF443E9320AC18E23")
        public String getEfName() {
String var8674027D88476581C69AA5BD2AB58569_54095941 =             "EF_ISIM_IMPI";
            var8674027D88476581C69AA5BD2AB58569_54095941.addTaint(taint);
            return var8674027D88476581C69AA5BD2AB58569_54095941;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPI";
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.054 -0400", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "979C0396888DDB124C46C1A00D64E975")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.054 -0400", hash_original_method = "D36761040F857F140719B8DB530580FC", hash_generated_method = "D36761040F857F140719B8DB530580FC")
        public EfIsimImpuLoaded ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.054 -0400", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "87C222A3AD237C502B656FA02036B5CC")
        public String getEfName() {
String var3AF90F29E4FFA7FDFF74D17A8F27F21D_576138235 =             "EF_ISIM_IMPU";
            var3AF90F29E4FFA7FDFF74D17A8F27F21D_576138235.addTaint(taint);
            return var3AF90F29E4FFA7FDFF74D17A8F27F21D_576138235;
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPU";
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.055 -0400", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "1590CE539B03CC5C1780677116074ADE")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.055 -0400", hash_original_method = "0E7AAEB3F527509DE6629FF8F10D67B7", hash_generated_method = "0E7AAEB3F527509DE6629FF8F10D67B7")
        public EfIsimDomainLoaded ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.055 -0400", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "2D433EF26BF30FDE5554EC64240E1677")
        public String getEfName() {
String var1A700BEF13E1FED8405541952A0C927E_1689499531 =             "EF_ISIM_DOMAIN";
            var1A700BEF13E1FED8405541952A0C927E_1689499531.addTaint(taint);
            return var1A700BEF13E1FED8405541952A0C927E_1689499531;
            // ---------- Original Method ----------
            //return "EF_ISIM_DOMAIN";
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.056 -0400", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "E8DB62EC60B6809AABAADDBE723151BE")
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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.056 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "BD940BC52C3AB14198F71CB81F0E8FEB")

    protected static final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.057 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "B7707D757F0604821CCAF673B2122320")

    private static final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.057 -0400", hash_original_field = "67335754D34F1A97E3C5D836EF1E262E", hash_generated_field = "8B06C3B6BF00D7D43F66466D5AB2B4FD")

    private static final boolean DUMP_RECORDS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.057 -0400", hash_original_field = "52F35D2F31EF37FE0F6B7B218FB7FDA4", hash_generated_field = "C529ECF6947054FFE9397A031D3E9F83")

    private static final int TAG_ISIM_VALUE = 0x80;
}

