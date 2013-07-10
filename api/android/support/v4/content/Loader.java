package android.support.v4.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.302 -0400", hash_original_field = "6AC7F06B6413A1BE9C136DC7DF0D2B60", hash_generated_field = "9F66E723E60E4F10157FDA7C23C67293")

    int mId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "3E73DDB57866D56D9C2443D15644A1EA")

    OnLoadCompleteListener<D> mListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "B997E37019471EC8FC5B98148C7A8AD7")

    Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_field = "465FED330AF0BFBBF47872297AAF1201", hash_generated_field = "5D947BF952E8653BAADEA609028A78F9")

    boolean mStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_field = "ABE4A91442550765184891509AE186B4", hash_generated_field = "688AFAAD56F5DDB79630BAB635796C3C")

    boolean mAbandoned = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_field = "7526711121E203119F760774B12B9149", hash_generated_field = "359194BB54288CCCE4CAFE12392EC644")

    boolean mReset = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_field = "4B766AA38AE5F88895883737455DF7E7", hash_generated_field = "799325477E4C0AD32C3DFCC8D4F71211")

    boolean mContentChanged = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_method = "6088A27F132FBE0E650A99C21779299A", hash_generated_method = "E534B79FD11218DC330A0BC7A9E63568")
    public  Loader(Context context) {
        mContext = context.getApplicationContext();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.303 -0400", hash_original_method = "7AF94F59AC743CB047D54940F8BB69AC", hash_generated_method = "BE43F741D7B3D91AE06AD563B0A09C24")
    public void deliverResult(D data) {
        {
            mListener.onLoadComplete(this, data);
        } 
        addTaint(data.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.304 -0400", hash_original_method = "4F4EBC54D108D66F416C93B46580E117", hash_generated_method = "8EE4BD0729DD5588BA1D515F434C01BF")
    public Context getContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_257793967 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_257793967 = mContext;
        varB4EAC82CA7396A68D541C85D26508E83_257793967.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_257793967;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.304 -0400", hash_original_method = "849E83C6BA01C72387E236CA4FAA38B9", hash_generated_method = "2D9111499B4FF14F0EB8FAB7DF19BF55")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1497938 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1497938;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.305 -0400", hash_original_method = "F7FC6EAD1080F4315E95C53063FFE31D", hash_generated_method = "E15B0E0C0CC319E82FBDE6A7AFE41F19")
    public void registerListener(int id, OnLoadCompleteListener<D> listener) {
        
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("There is already a listener registered");
        } 
        mListener = listener;
        mId = id;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.305 -0400", hash_original_method = "F0B8962C538754B5FF8377ACC78D9441", hash_generated_method = "479EF29DB7B01ADC095FD7EBACBDC2D1")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.306 -0400", hash_original_method = "4FF549E03853BC8FE3FDFAEBF99B8097", hash_generated_method = "F3DD9F62B94FE0B010200B7F3ACD25BD")
    public boolean isStarted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_894356569 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_894356569;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.306 -0400", hash_original_method = "A2FBF2FF6E2191DA1A91C50D7F722DEF", hash_generated_method = "0EFDB0A4067D7281FB740F04CFB0683D")
    public boolean isAbandoned() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2072803627 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2072803627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.306 -0400", hash_original_method = "6F78AC76FABAE5B00729D2DF0B0C81EB", hash_generated_method = "F63C24DE77852AE37C589BD4EC3D8C77")
    public boolean isReset() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1203885858 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1203885858;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.307 -0400", hash_original_method = "8E7A6B4B56209ADF45890FC32754A367", hash_generated_method = "95BCA04E04752C1974CE09D899F4BF59")
    public final void startLoading() {
        mStarted = true;
        mReset = false;
        mAbandoned = false;
        onStartLoading();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.307 -0400", hash_original_method = "DA06EE0B2F861EB56F065785FCE355AD", hash_generated_method = "0909BE96C0F99143CB2CE82AF27A625E")
    protected void onStartLoading() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.308 -0400", hash_original_method = "E102AD0C3BB2F8D5B106A9E25CAC340A", hash_generated_method = "4C3F61B2263048390C3B94C62E4D7FA4")
    public void forceLoad() {
        onForceLoad();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.308 -0400", hash_original_method = "FE3F333F9E40E18C50A63599879C8FC2", hash_generated_method = "488FAE86043081AFB0979733155F08FD")
    protected void onForceLoad() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.309 -0400", hash_original_method = "98899B741F509D9E0CD920B3A41ABA16", hash_generated_method = "FAF990D8796E5B8D7259E6E7F044F4A1")
    public void stopLoading() {
        mStarted = false;
        onStopLoading();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.309 -0400", hash_original_method = "61C04D3A0F64307AA142FA0229BCD9C9", hash_generated_method = "716B7303C3FA40378FDE0D93ABB3AD37")
    protected void onStopLoading() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.310 -0400", hash_original_method = "ACB324D8F1768E7142E127CF7A1A7031", hash_generated_method = "D32BD59EA06FDBFB1E283FB692CB3472")
    public void abandon() {
        mAbandoned = true;
        onAbandon();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.310 -0400", hash_original_method = "A161936916B264DFAEE5DB9D8DEA7F5D", hash_generated_method = "2DF6972E38BFCEC8C4E59AA3458EA32B")
    protected void onAbandon() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.311 -0400", hash_original_method = "1D7BF800397B2CC75C7600D5EBC7C29A", hash_generated_method = "C04E123B29896F1733D54910546A4956")
    public void reset() {
        onReset();
        mReset = true;
        mStarted = false;
        mAbandoned = false;
        mContentChanged = false;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.311 -0400", hash_original_method = "16611E3F48156A317644CA113F750BCD", hash_generated_method = "506FAD418C46C1799155951AA1376B27")
    protected void onReset() {
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.312 -0400", hash_original_method = "C55C1C662CB28045D31932504C1021C3", hash_generated_method = "732D67F7CD50E9F561E8EF8459788A0B")
    public boolean takeContentChanged() {
        boolean res = mContentChanged;
        mContentChanged = false;
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246589941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246589941;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.312 -0400", hash_original_method = "9CACF0CE278273BE0AB1B5F570D8CB20", hash_generated_method = "122FA5CE2B671883A6961E2423E1FA55")
    public void onContentChanged() {
        
        {
            forceLoad();
        } 
        {
            mContentChanged = true;
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.313 -0400", hash_original_method = "F5B015CDDEBA6C005C6DD563385EE3D7", hash_generated_method = "4286DA5510E2FD53FF9BCF90A7AC624F")
    public String dataToString(D data) {
        String varB4EAC82CA7396A68D541C85D26508E83_483969199 = null; 
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(data, sb);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_483969199 = sb.toString();
        addTaint(data.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_483969199.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_483969199;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.313 -0400", hash_original_method = "7AA2EFEA4BBA4CB5078AB2979053EAD3", hash_generated_method = "CDFD717BB204982BC99162D31038FF67")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1548529543 = null; 
        StringBuilder sb = new StringBuilder(64);
        DebugUtils.buildShortClassTag(this, sb);
        sb.append(" id=");
        sb.append(mId);
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1548529543 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1548529543.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1548529543;
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.314 -0400", hash_original_method = "DC77AF55A2A9006E9EA4E79F1D0E0673", hash_generated_method = "8F2E7BAA6C982974CC5C6C69AAE41095")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.314 -0400", hash_original_method = "B9E73A5B4B60A8E0702AD317D1848844", hash_generated_method = "375A9A73C550620BE446824414E32EEE")
        public  ForceLoadContentObserver() {
            super(new Handler());
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.315 -0400", hash_original_method = "0AAB5F0B0973D030DF154EF2BA0EE06F", hash_generated_method = "D4A00DA03A05A934F4CAD398C0A89B5D")
        @Override
        public boolean deliverSelfNotifications() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_753320501 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_753320501;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:46.315 -0400", hash_original_method = "E96460F373279AF9AB8806E159ABA424", hash_generated_method = "14BD20B741BA4562A3870DA491571B1B")
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

