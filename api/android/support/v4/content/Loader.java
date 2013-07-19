package android.support.v4.content;

// Droidsafe Imports
import java.io.FileDescriptor;
import java.io.PrintWriter;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Loader<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.873 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

    int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.874 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "3E73DDB57866D56D9C2443D15644A1EA")

    OnLoadCompleteListener<D> mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.874 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.874 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "5D947BF952E8653BAADEA609028A78F9")

    boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.874 -0400", hash_original_field = "ABE4A91442550765184891509AE186B4", hash_generated_field = "688AFAAD56F5DDB79630BAB635796C3C")

    boolean mAbandoned = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.874 -0400", hash_original_field = "7526711121E203119F760774B12B9149", hash_generated_field = "359194BB54288CCCE4CAFE12392EC644")

    boolean mReset = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.874 -0400", hash_original_field = "4B766AA38AE5F88895883737455DF7E7", hash_generated_field = "799325477E4C0AD32C3DFCC8D4F71211")

    boolean mContentChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.875 -0400", hash_original_method = "6088A27F132FBE0E650A99C21779299A", hash_generated_method = "E534B79FD11218DC330A0BC7A9E63568")
    public  Loader(Context context) {
        mContext = context.getApplicationContext();
        // ---------- Original Method ----------
        //mContext = context.getApplicationContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.875 -0400", hash_original_method = "7AF94F59AC743CB047D54940F8BB69AC", hash_generated_method = "5A9A72CD373B3BF9B115CD8586685979")
    public void deliverResult(D data) {
        addTaint(data.getTaint());
        if(mListener != null)        
        {
            mListener.onLoadComplete(this, data);
        } //End block
        // ---------- Original Method ----------
        //if (mListener != null) {
            //mListener.onLoadComplete(this, data);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.876 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "0CAC0E477FACAB388637FCCF3EAD6F55")
    public Context getContext() {
Context var178E2AD52D6FBBB503F908168856B574_1650459837 =         mContext;
        var178E2AD52D6FBBB503F908168856B574_1650459837.addTaint(taint);
        return var178E2AD52D6FBBB503F908168856B574_1650459837;
        // ---------- Original Method ----------
        //return mContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.876 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "960FC9812D35E132C52CF6EB0F8C4132")
    public int getId() {
        int var6AC7F06B6413A1BE9C136DC7DF0D2B60_2119180028 = (mId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887566176 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_887566176;
        // ---------- Original Method ----------
        //return mId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.877 -0400", hash_original_method = "F7FC6EAD1080F4315E95C53063FFE31D", hash_generated_method = "0ADDAEF7A99950B03E9C667EFC208126")
    public void registerListener(int id, OnLoadCompleteListener<D> listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        if(mListener != null)        
        {
            IllegalStateException var688226E09927420D83E41E1F3C3F0400_1028663404 = new IllegalStateException("There is already a listener registered");
            var688226E09927420D83E41E1F3C3F0400_1028663404.addTaint(taint);
            throw var688226E09927420D83E41E1F3C3F0400_1028663404;
        } //End block
        mListener = listener;
        mId = id;
        // ---------- Original Method ----------
        //if (mListener != null) {
            //throw new IllegalStateException("There is already a listener registered");
        //}
        //mListener = listener;
        //mId = id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.878 -0400", hash_original_method = "F0B8962C538754B5FF8377ACC78D9441", hash_generated_method = "6A2182F7BB89FC7E3FCA6A4722C381B0")
    public void unregisterListener(OnLoadCompleteListener<D> listener) {
        addTaint(listener.getTaint());
        if(mListener == null)        
        {
            IllegalStateException var2C605659516080DF75CFD33A44EAECBF_312445236 = new IllegalStateException("No listener register");
            var2C605659516080DF75CFD33A44EAECBF_312445236.addTaint(taint);
            throw var2C605659516080DF75CFD33A44EAECBF_312445236;
        } //End block
        if(mListener != listener)        
        {
            IllegalArgumentException varDEC44156D7AD79DFD8241E9210F2160B_1483936631 = new IllegalArgumentException("Attempting to unregister the wrong listener");
            varDEC44156D7AD79DFD8241E9210F2160B_1483936631.addTaint(taint);
            throw varDEC44156D7AD79DFD8241E9210F2160B_1483936631;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.878 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "0299AE71D77ECE75B249F957899EF68F")
    public boolean isStarted() {
        boolean var7103AE9E2C0D3B676C4EDC763D39DFCF_1096242176 = (mStarted);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1300141697 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1300141697;
        // ---------- Original Method ----------
        //return mStarted;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.879 -0400", hash_original_method = "A2FBF2FF6E2191DA1A91C50D7F722DEF", hash_generated_method = "C36C168D149C660886F45C7EC3138723")
    public boolean isAbandoned() {
        boolean varFC0F60C193A6F1541721C0462C4DD928_619326601 = (mAbandoned);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809860314 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809860314;
        // ---------- Original Method ----------
        //return mAbandoned;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.879 -0400", hash_original_method = "6F78AC76FABAE5B00729D2DF0B0C81EB", hash_generated_method = "C03CBF96CA13A091F6360C7428294E33")
    public boolean isReset() {
        boolean var454F5FCEC5E7A4DDE627E87D560D9461_34913863 = (mReset);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_815897299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_815897299;
        // ---------- Original Method ----------
        //return mReset;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.879 -0400", hash_original_method = "8E7A6B4B56209ADF45890FC32754A367", hash_generated_method = "95BCA04E04752C1974CE09D899F4BF59")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.880 -0400", hash_original_method = "DA06EE0B2F861EB56F065785FCE355AD", hash_generated_method = "0909BE96C0F99143CB2CE82AF27A625E")
    protected void onStartLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.880 -0400", hash_original_method = "E102AD0C3BB2F8D5B106A9E25CAC340A", hash_generated_method = "4C3F61B2263048390C3B94C62E4D7FA4")
    public void forceLoad() {
        onForceLoad();
        // ---------- Original Method ----------
        //onForceLoad();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.880 -0400", hash_original_method = "FE3F333F9E40E18C50A63599879C8FC2", hash_generated_method = "488FAE86043081AFB0979733155F08FD")
    protected void onForceLoad() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.881 -0400", hash_original_method = "98899B741F509D9E0CD920B3A41ABA16", hash_generated_method = "FAF990D8796E5B8D7259E6E7F044F4A1")
    public void stopLoading() {
        mStarted = false;
        onStopLoading();
        // ---------- Original Method ----------
        //mStarted = false;
        //onStopLoading();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.881 -0400", hash_original_method = "61C04D3A0F64307AA142FA0229BCD9C9", hash_generated_method = "716B7303C3FA40378FDE0D93ABB3AD37")
    protected void onStopLoading() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.881 -0400", hash_original_method = "ACB324D8F1768E7142E127CF7A1A7031", hash_generated_method = "D32BD59EA06FDBFB1E283FB692CB3472")
    public void abandon() {
        mAbandoned = true;
        onAbandon();
        // ---------- Original Method ----------
        //mAbandoned = true;
        //onAbandon();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.881 -0400", hash_original_method = "A161936916B264DFAEE5DB9D8DEA7F5D", hash_generated_method = "2DF6972E38BFCEC8C4E59AA3458EA32B")
    protected void onAbandon() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.882 -0400", hash_original_method = "1D7BF800397B2CC75C7600D5EBC7C29A", hash_generated_method = "C04E123B29896F1733D54910546A4956")
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.882 -0400", hash_original_method = "16611E3F48156A317644CA113F750BCD", hash_generated_method = "506FAD418C46C1799155951AA1376B27")
    protected void onReset() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.883 -0400", hash_original_method = "C55C1C662CB28045D31932504C1021C3", hash_generated_method = "CDF401C70BE071AC120A6357495C1956")
    public boolean takeContentChanged() {
        boolean res = mContentChanged;
        mContentChanged = false;
        boolean var9B207167E5381C47682C6B4F58A623FB_606816093 = (res);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71409824 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_71409824;
        // ---------- Original Method ----------
        //boolean res = mContentChanged;
        //mContentChanged = false;
        //return res;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.883 -0400", hash_original_method = "9CACF0CE278273BE0AB1B5F570D8CB20", hash_generated_method = "4AD0AC5A66695D240ED3F18002BD5EE8")
    public void onContentChanged() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        if(mStarted)        
        {
            forceLoad();
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.885 -0400", hash_original_method = "F5B015CDDEBA6C005C6DD563385EE3D7", hash_generated_method = "31078661043D0089008B2424FF0BCF2E")
    public String dataToString(D data) {
        addTaint(data.getTaint());
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(data, sb);
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_977923370 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_977923370.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_977923370;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //DebugUtils.buildShortClassTag(data, sb);
        //sb.append("}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.885 -0400", hash_original_method = "7AA2EFEA4BBA4CB5078AB2979053EAD3", hash_generated_method = "4AEFC443E94E42384545D83AC48090A7")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(mId);
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_642385902 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_642385902.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_642385902;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(64);
        //DebugUtils.buildShortClassTag(this, sb);
        //sb.append(" id=");
        //sb.append(mId);
        //sb.append("}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.886 -0400", hash_original_method = "DC77AF55A2A9006E9EA4E79F1D0E0673", hash_generated_method = "C3F9476A42C6F3435D4B8EACB7EB20FC")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.886 -0400", hash_original_method = "B9E73A5B4B60A8E0702AD317D1848844", hash_generated_method = "375A9A73C550620BE446824414E32EEE")
        public  ForceLoadContentObserver() {
            super(new Handler());
            // ---------- Original Method ----------
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.887 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "AD277DA24AC78F9DA7D52472295C36D3")
        @Override
        public boolean deliverSelfNotifications() {
            boolean varB326B5062B2F0E69046810717534CB09_331250569 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539676424 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_539676424;
            // ---------- Original Method ----------
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.887 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "ED8F5A11A8054BF0A3976D4C48B0275E")
        @Override
        public void onChange(boolean selfChange) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(selfChange);
            onContentChanged();
            // ---------- Original Method ----------
            //onContentChanged();
        }

        
    }


    
    public interface OnLoadCompleteListener<D> {
        
        public void onLoadComplete(Loader<D> loader, D data);
    }
    
}

