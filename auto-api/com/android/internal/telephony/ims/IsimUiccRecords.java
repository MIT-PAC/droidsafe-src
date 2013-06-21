package com.android.internal.telephony.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private String mIsimImpi;
    private String mIsimDomain;
    private String[] mIsimImpu;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.084 -0400", hash_original_method = "8C3400FD2616B9437C644753B0D42605", hash_generated_method = "8C3400FD2616B9437C644753B0D42605")
        public IsimUiccRecords ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.094 -0400", hash_original_method = "65EA4CC7473CC6604A3DE8B9A82FCC11", hash_generated_method = "E36CB7B0F5DA6321071A04BD035610CC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int fetchIsimRecords(IccFileHandler iccFh, Handler h) {
        dsTaint.addTaint(iccFh.dsTaint);
        dsTaint.addTaint(h.dsTaint);
        iccFh.loadEFTransparent(EF_IMPI, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpiLoaded()));
        iccFh.loadEFLinearFixedAll(EF_IMPU, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimImpuLoaded()));
        iccFh.loadEFTransparent(EF_DOMAIN, h.obtainMessage(
                IccRecords.EVENT_GET_ICC_RECORD_DONE, new EfIsimDomainLoaded()));
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.095 -0400", hash_original_method = "6D2B5E713513F7C05BF0126DA069258E", hash_generated_method = "7A1AADB0847C17D526AFE6420D76E62A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void log(String s) {
        dsTaint.addTaint(s);
        Log.d(LOG_TAG, "[ISIM] " + s);
        // ---------- Original Method ----------
        //if (DBG) Log.d(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.095 -0400", hash_original_method = "D22606291D00D3FF31B88F1A658749A5", hash_generated_method = "06AADD06FD1208CDA0BC3AD7FB90F74F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void loge(String s) {
        dsTaint.addTaint(s);
        // ---------- Original Method ----------
        //if (DBG) Log.e(LOG_TAG, "[ISIM] " + s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.096 -0400", hash_original_method = "0C48887FF3A7960AF9ADE0B3DADCC487", hash_generated_method = "02AB84D7B50CF33F3B1CBCDB063D8CCE")
    @DSModeled(DSC.SAFE)
    public String getIsimImpi() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIsimImpi;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.097 -0400", hash_original_method = "4243CC1C17FF1186628D392C9E7E1EB1", hash_generated_method = "A6548343BFF83AEB4C56BB1B1A36C6E4")
    @DSModeled(DSC.SAFE)
    public String getIsimDomain() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mIsimDomain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.098 -0400", hash_original_method = "9090A8F6ED42A9AE952A72E5A0840C23", hash_generated_method = "73B1A6D3E604B63196B4AF86139BF888")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getIsimImpu() {
        {
            Object var2E98FC26DB0187F40205E953A324ADA8_442868323 = (mIsimImpu.clone());
        } //End flattened ternary
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return (mIsimImpu != null) ? mIsimImpu.clone() : null;
    }

    
    private class EfIsimImpiLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.098 -0400", hash_original_method = "1E3D89543EFC05A731E34F4DC346D6FC", hash_generated_method = "1E3D89543EFC05A731E34F4DC346D6FC")
                public EfIsimImpiLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.099 -0400", hash_original_method = "81740E578FCC01A298E59A120ACB7A20", hash_generated_method = "61364635668D4581F52977AFBD8A4B37")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPI";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.099 -0400", hash_original_method = "90A14C4AAFF433EE7EAC0700F3BB549F", hash_generated_method = "62D41805120577118B5C978B4190A5B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            byte[] data;
            data = (byte[]) ar.result;
            mIsimImpi = isimTlvToString(data);
            log("EF_IMPI=" + mIsimImpi);
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //mIsimImpi = isimTlvToString(data);
            //if (DUMP_RECORDS) log("EF_IMPI=" + mIsimImpi);
        }

        
    }


    
    private class EfIsimImpuLoaded implements IccRecords.IccRecordLoaded {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.099 -0400", hash_original_method = "ED1ACD8D8DEA79B2608E88494946BB0F", hash_generated_method = "ED1ACD8D8DEA79B2608E88494946BB0F")
                public EfIsimImpuLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.099 -0400", hash_original_method = "6ACADD4D30DF15849A74BDE374634092", hash_generated_method = "C4C90349ACAC783BBDC2664C87216EB1")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_ISIM_IMPU";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.106 -0400", hash_original_method = "6EEA897801EC1809D035B3B23B9DD12A", hash_generated_method = "14ED8D2113F81284A9086CD2EC26EE91")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            ArrayList<byte[]> impuList;
            impuList = (ArrayList<byte[]>) ar.result;
            log("EF_IMPU record count: " + impuList.size());
            mIsimImpu = new String[impuList.size()];
            int i;
            i = 0;
            {
                Iterator<byte[]> var5BCC2EE5D00C9451553D406F293D94B3_1634624405 = (impuList).iterator();
                var5BCC2EE5D00C9451553D406F293D94B3_1634624405.hasNext();
                byte[] identity = var5BCC2EE5D00C9451553D406F293D94B3_1634624405.next();
                {
                    String impu;
                    impu = isimTlvToString(identity);
                    log("EF_IMPU[" + i + "]=" + impu);
                    mIsimImpu[i++] = impu;
                } //End block
            } //End collapsed parenthetic
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.107 -0400", hash_original_method = "A9599EA5FCFCCD8A28138DB3B0165B02", hash_generated_method = "A9599EA5FCFCCD8A28138DB3B0165B02")
                public EfIsimDomainLoaded ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.107 -0400", hash_original_method = "42CE7E28C1D31526FC06B2AB64B01116", hash_generated_method = "06EDF0ED59DD7AA4771BCFC0CA165EBF")
        @DSModeled(DSC.SAFE)
        public String getEfName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "EF_ISIM_DOMAIN";
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.107 -0400", hash_original_method = "7C79F77549AD4915107C48F1E050653A", hash_generated_method = "17C86C7C2E6279FEBFBC03F8AE68FE27")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onRecordLoaded(AsyncResult ar) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(ar.dsTaint);
            byte[] data;
            data = (byte[]) ar.result;
            mIsimDomain = isimTlvToString(data);
            log("EF_DOMAIN=" + mIsimDomain);
            // ---------- Original Method ----------
            //byte[] data = (byte[]) ar.result;
            //mIsimDomain = isimTlvToString(data);
            //if (DUMP_RECORDS) log("EF_DOMAIN=" + mIsimDomain);
        }

        
    }


    
    protected static final String LOG_TAG = "GSM";
    private static final boolean DBG = true;
    private static final boolean DUMP_RECORDS = false;
    private static final int TAG_ISIM_VALUE = 0x80;
}

