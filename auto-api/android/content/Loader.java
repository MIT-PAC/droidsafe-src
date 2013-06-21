package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    int mId;
    OnLoadCompleteListener<D> mListener;
    Context mContext;
    boolean mStarted = false;
    boolean mAbandoned = false;
    boolean mReset = true;
    boolean mContentChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.038 -0400", hash_original_method = "6088A27F132FBE0E650A99C21779299A", hash_generated_method = "F3A22896ADACCD9297B613CB38753654")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Loader(Context context) {
        dsTaint.addTaint(context.dsTaint);
        mContext = context.getApplicationContext();
        // ---------- Original Method ----------
        //mContext = context.getApplicationContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.038 -0400", hash_original_method = "7AF94F59AC743CB047D54940F8BB69AC", hash_generated_method = "640DA08A3C89F37A10B59676B356A083")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deliverResult(D data) {
        dsTaint.addTaint(data.dsTaint);
        {
            mListener.onLoadComplete(this, data);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onLoadComplete(this, data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.038 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "DFA42A6C39C27C217BA4B1F8A6817BD5")
    @DSModeled(DSC.SAFE)
    public Context getContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.046 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "8621FE03FADC0A3000742A4E8AF6A961")
    @DSModeled(DSC.SAFE)
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.048 -0400", hash_original_method = "F7FC6EAD1080F4315E95C53063FFE31D", hash_generated_method = "4A32E6BEDEEBB8AE857415454846C6C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerListener(int id, OnLoadCompleteListener<D> listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(id);
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("There is already a listener registered");
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //throw new IllegalStateException("There is already a listener registered");
        //}
        //mListener = listener;
        //mId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.049 -0400", hash_original_method = "F0B8962C538754B5FF8377ACC78D9441", hash_generated_method = "2FF749FD8AE8365464E2C27415261CF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterListener(OnLoadCompleteListener<D> listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No listener register");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } //End block
        mListener = null;
        // ---------- Original Method ----------
        //if (mListener == null) {
            //throw new IllegalStateException("No listener register");
        //}
        //if (mListener != listener) {
            //throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        //}
        //mListener = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.050 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "14F63EDB6346231A8C9F19121327F9E5")
    @DSModeled(DSC.SAFE)
    public boolean isStarted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStarted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.050 -0400", hash_original_method = "A2FBF2FF6E2191DA1A91C50D7F722DEF", hash_generated_method = "CBD308E3EFC274FA1E1C2D95CA307B48")
    @DSModeled(DSC.SAFE)
    public boolean isAbandoned() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAbandoned;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.050 -0400", hash_original_method = "6F78AC76FABAE5B00729D2DF0B0C81EB", hash_generated_method = "068851D267E1F4ACC97A11EB65DB9A75")
    @DSModeled(DSC.SAFE)
    public boolean isReset() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mReset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.051 -0400", hash_original_method = "8E7A6B4B56209ADF45890FC32754A367", hash_generated_method = "95BCA04E04752C1974CE09D899F4BF59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void startLoading() {
        mStarted = true;
        mReset = false;
        mAbandoned = false;
        onStartLoading();
        // ---------- Original Method ----------
        //mStarted = true;
        //mReset = false;
        //mAbandoned = false;
        //onStartLoading();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.051 -0400", hash_original_method = "DA06EE0B2F861EB56F065785FCE355AD", hash_generated_method = "0909BE96C0F99143CB2CE82AF27A625E")
    @DSModeled(DSC.SAFE)
    protected void onStartLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.051 -0400", hash_original_method = "E102AD0C3BB2F8D5B106A9E25CAC340A", hash_generated_method = "4C3F61B2263048390C3B94C62E4D7FA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void forceLoad() {
        onForceLoad();
        // ---------- Original Method ----------
        //onForceLoad();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.051 -0400", hash_original_method = "FE3F333F9E40E18C50A63599879C8FC2", hash_generated_method = "488FAE86043081AFB0979733155F08FD")
    @DSModeled(DSC.SAFE)
    protected void onForceLoad() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.052 -0400", hash_original_method = "98899B741F509D9E0CD920B3A41ABA16", hash_generated_method = "FAF990D8796E5B8D7259E6E7F044F4A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void stopLoading() {
        mStarted = false;
        onStopLoading();
        // ---------- Original Method ----------
        //mStarted = false;
        //onStopLoading();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.052 -0400", hash_original_method = "61C04D3A0F64307AA142FA0229BCD9C9", hash_generated_method = "716B7303C3FA40378FDE0D93ABB3AD37")
    @DSModeled(DSC.SAFE)
    protected void onStopLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.052 -0400", hash_original_method = "ACB324D8F1768E7142E127CF7A1A7031", hash_generated_method = "D32BD59EA06FDBFB1E283FB692CB3472")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void abandon() {
        mAbandoned = true;
        onAbandon();
        // ---------- Original Method ----------
        //mAbandoned = true;
        //onAbandon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.053 -0400", hash_original_method = "A161936916B264DFAEE5DB9D8DEA7F5D", hash_generated_method = "2DF6972E38BFCEC8C4E59AA3458EA32B")
    @DSModeled(DSC.SAFE)
    protected void onAbandon() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.053 -0400", hash_original_method = "1D7BF800397B2CC75C7600D5EBC7C29A", hash_generated_method = "C04E123B29896F1733D54910546A4956")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reset() {
        onReset();
        mReset = true;
        mStarted = false;
        mAbandoned = false;
        mContentChanged = false;
        // ---------- Original Method ----------
        //onReset();
        //mReset = true;
        //mStarted = false;
        //mAbandoned = false;
        //mContentChanged = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.055 -0400", hash_original_method = "16611E3F48156A317644CA113F750BCD", hash_generated_method = "506FAD418C46C1799155951AA1376B27")
    @DSModeled(DSC.SAFE)
    protected void onReset() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.056 -0400", hash_original_method = "C55C1C662CB28045D31932504C1021C3", hash_generated_method = "2ADE74FA941D7F13CFE5821BD0BBD20D")
    @DSModeled(DSC.SAFE)
    public boolean takeContentChanged() {
        boolean res;
        res = mContentChanged;
        mContentChanged = false;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean res = mContentChanged;
        //mContentChanged = false;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.056 -0400", hash_original_method = "9CACF0CE278273BE0AB1B5F570D8CB20", hash_generated_method = "122FA5CE2B671883A6961E2423E1FA55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            forceLoad();
        } //End block
        {
            mContentChanged = true;
        } //End block
        // ---------- Original Method ----------
        //if (mStarted) {
            //forceLoad();
        //} else {
            //mContentChanged = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.057 -0400", hash_original_method = "F5B015CDDEBA6C005C6DD563385EE3D7", hash_generated_method = "B5952D891E80B5752ED61871B2A84864")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String dataToString(D data) {
        dsTaint.addTaint(data.dsTaint);
        StringBuilder sb;
        sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(data, sb);
        sb.append("}");
        String var806458D832AB974D230FEE4CBBDBD390_1117331150 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //DebugUtils.buildShortClassTag(data, sb);
        //sb.append("}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.057 -0400", hash_original_method = "7AA2EFEA4BBA4CB5078AB2979053EAD3", hash_generated_method = "2E8A7DC17C99EA1708BBED35747373BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(mId);
        sb.append("}");
        String var806458D832AB974D230FEE4CBBDBD390_594455114 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //DebugUtils.buildShortClassTag(this, sb);
        //sb.append(" id=");
        //sb.append(mId);
        //sb.append("}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.057 -0400", hash_original_method = "DC77AF55A2A9006E9EA4E79F1D0E0673", hash_generated_method = "8D829D48F54D575B6B0146FCE34F73AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        writer.print(prefix);
        writer.print("mId=");
        writer.print(mId);
        writer.print(" mListener=");
        writer.println(mListener);
        writer.print(prefix);
        writer.print("mStarted=");
        writer.print(mStarted);
        writer.print(" mContentChanged=");
        writer.print(mContentChanged);
        writer.print(" mAbandoned=");
        writer.print(mAbandoned);
        writer.print(" mReset=");
        writer.println(mReset);
        // ---------- Original Method ----------
        //writer.print(prefix);
        //writer.print("mId=");
        //writer.print(mId);
        //writer.print(" mListener=");
        //writer.println(mListener);
        //writer.print(prefix);
        //writer.print("mStarted=");
        //writer.print(mStarted);
        //writer.print(" mContentChanged=");
        //writer.print(mContentChanged);
        //writer.print(" mAbandoned=");
        //writer.print(mAbandoned);
        //writer.print(" mReset=");
        //writer.println(mReset);
    }

    
    public final class ForceLoadContentObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.058 -0400", hash_original_method = "B9E73A5B4B60A8E0702AD317D1848844", hash_generated_method = "375A9A73C550620BE446824414E32EEE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ForceLoadContentObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.058 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "734EC4B846BD9CD4571F46A7ABF54491")
        @DSModeled(DSC.SAFE)
        @Override
        public boolean deliverSelfNotifications() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.058 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "4DBE673DE1D01CE6347E62E9EA26C6D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(selfChange);
            onContentChanged();
            // ---------- Original Method ----------
            //onContentChanged();
        }

        
    }


    
    public interface OnLoadCompleteListener<D> {
        
        public void onLoadComplete(Loader<D> loader, D data);
    }
    
}

