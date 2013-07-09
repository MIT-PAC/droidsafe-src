package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

    int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "3E73DDB57866D56D9C2443D15644A1EA")

    OnLoadCompleteListener<D> mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "5D947BF952E8653BAADEA609028A78F9")

    boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "ABE4A91442550765184891509AE186B4", hash_generated_field = "688AFAAD56F5DDB79630BAB635796C3C")

    boolean mAbandoned = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "7526711121E203119F760774B12B9149", hash_generated_field = "359194BB54288CCCE4CAFE12392EC644")

    boolean mReset = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.410 -0400", hash_original_field = "4B766AA38AE5F88895883737455DF7E7", hash_generated_field = "799325477E4C0AD32C3DFCC8D4F71211")

    boolean mContentChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.411 -0400", hash_original_method = "6088A27F132FBE0E650A99C21779299A", hash_generated_method = "E534B79FD11218DC330A0BC7A9E63568")
    public  Loader(Context context) {
        mContext = context.getApplicationContext();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.411 -0400", hash_original_method = "7AF94F59AC743CB047D54940F8BB69AC", hash_generated_method = "BE43F741D7B3D91AE06AD563B0A09C24")
    public void deliverResult(D data) {
        {
            mListener.onLoadComplete(this, data);
        } 
        addTaint(data.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.412 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "072BBBD3784274849EC8ECF6C2405117")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_88931971 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_88931971 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_88931971.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_88931971;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.412 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "854B457B7520AD5A10143D2BD4C1A542")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988589053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988589053;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.413 -0400", hash_original_method = "F7FC6EAD1080F4315E95C53063FFE31D", hash_generated_method = "E15B0E0C0CC319E82FBDE6A7AFE41F19")
    public void registerListener(int id, OnLoadCompleteListener<D> listener) {
        
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("There is already a listener registered");
        } 
        mListener = listener;
        mId = id;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.415 -0400", hash_original_method = "F0B8962C538754B5FF8377ACC78D9441", hash_generated_method = "479EF29DB7B01ADC095FD7EBACBDC2D1")
    public void unregisterListener(OnLoadCompleteListener<D> listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No listener register");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } 
        mListener = null;
        addTaint(listener.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.415 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "F8F21B1897999F6861EEA1E2C7F6E5E7")
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472531593 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472531593;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.416 -0400", hash_original_method = "A2FBF2FF6E2191DA1A91C50D7F722DEF", hash_generated_method = "78AF32450DFD695FDA11DAF8B1510A65")
    public boolean isAbandoned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_594726574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_594726574;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.416 -0400", hash_original_method = "6F78AC76FABAE5B00729D2DF0B0C81EB", hash_generated_method = "4933A334B15832EF36D9F3B62AEF1710")
    public boolean isReset() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1489705586 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1489705586;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.416 -0400", hash_original_method = "8E7A6B4B56209ADF45890FC32754A367", hash_generated_method = "95BCA04E04752C1974CE09D899F4BF59")
    public final void startLoading() {
        mStarted = true;
        mReset = false;
        mAbandoned = false;
        onStartLoading();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.417 -0400", hash_original_method = "DA06EE0B2F861EB56F065785FCE355AD", hash_generated_method = "0909BE96C0F99143CB2CE82AF27A625E")
    protected void onStartLoading() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.417 -0400", hash_original_method = "E102AD0C3BB2F8D5B106A9E25CAC340A", hash_generated_method = "4C3F61B2263048390C3B94C62E4D7FA4")
    public void forceLoad() {
        onForceLoad();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.418 -0400", hash_original_method = "FE3F333F9E40E18C50A63599879C8FC2", hash_generated_method = "488FAE86043081AFB0979733155F08FD")
    protected void onForceLoad() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.418 -0400", hash_original_method = "98899B741F509D9E0CD920B3A41ABA16", hash_generated_method = "FAF990D8796E5B8D7259E6E7F044F4A1")
    public void stopLoading() {
        mStarted = false;
        onStopLoading();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.418 -0400", hash_original_method = "61C04D3A0F64307AA142FA0229BCD9C9", hash_generated_method = "716B7303C3FA40378FDE0D93ABB3AD37")
    protected void onStopLoading() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.419 -0400", hash_original_method = "ACB324D8F1768E7142E127CF7A1A7031", hash_generated_method = "D32BD59EA06FDBFB1E283FB692CB3472")
    public void abandon() {
        mAbandoned = true;
        onAbandon();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.419 -0400", hash_original_method = "A161936916B264DFAEE5DB9D8DEA7F5D", hash_generated_method = "2DF6972E38BFCEC8C4E59AA3458EA32B")
    protected void onAbandon() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.420 -0400", hash_original_method = "1D7BF800397B2CC75C7600D5EBC7C29A", hash_generated_method = "C04E123B29896F1733D54910546A4956")
    public void reset() {
        onReset();
        mReset = true;
        mStarted = false;
        mAbandoned = false;
        mContentChanged = false;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.420 -0400", hash_original_method = "16611E3F48156A317644CA113F750BCD", hash_generated_method = "506FAD418C46C1799155951AA1376B27")
    protected void onReset() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.421 -0400", hash_original_method = "C55C1C662CB28045D31932504C1021C3", hash_generated_method = "8818390A43E147CB4192B5233D898040")
    public boolean takeContentChanged() {
        boolean res = mContentChanged;
        mContentChanged = false;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1078877236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1078877236;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.421 -0400", hash_original_method = "9CACF0CE278273BE0AB1B5F570D8CB20", hash_generated_method = "122FA5CE2B671883A6961E2423E1FA55")
    public void onContentChanged() {
        
        {
            forceLoad();
        } 
        {
            mContentChanged = true;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.422 -0400", hash_original_method = "F5B015CDDEBA6C005C6DD563385EE3D7", hash_generated_method = "9A82AD68D4F75DFC382C4F4E874C8315")
    public String dataToString(D data) {
        String varB4EAC82CA7396A68D541C85D26508E83_2003736675 = null; 
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(data, sb);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_2003736675 = sb.toString();
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2003736675.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2003736675;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.423 -0400", hash_original_method = "7AA2EFEA4BBA4CB5078AB2979053EAD3", hash_generated_method = "A999285B64AD8D2E80B2382E0F332A7E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1738533765 = null; 
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(mId);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1738533765 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1738533765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1738533765;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.425 -0400", hash_original_method = "DC77AF55A2A9006E9EA4E79F1D0E0673", hash_generated_method = "8F2E7BAA6C982974CC5C6C69AAE41095")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    public final class ForceLoadContentObserver extends ContentObserver {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.426 -0400", hash_original_method = "B9E73A5B4B60A8E0702AD317D1848844", hash_generated_method = "375A9A73C550620BE446824414E32EEE")
        public  ForceLoadContentObserver() {
            super(new Handler());
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.427 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "3EB3BC65C979C3D221E431EA3953C620")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1819353271 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1819353271;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:24.429 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "14BD20B741BA4562A3870DA491571B1B")
        @Override
        public void onChange(boolean selfChange) {
            
            onContentChanged();
            addTaint(selfChange);
            
            
        }

        
    }


    
    public interface OnLoadCompleteListener<D> {
        
        public void onLoadComplete(Loader<D> loader, D data);
    }
    
}

