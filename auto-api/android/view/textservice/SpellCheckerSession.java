package android.view.textservice;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import com.android.internal.textservice.ITextServicesManager;
import com.android.internal.textservice.ITextServicesSessionListener;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.SuggestionsInfo;
import android.view.textservice.TextInfo;
import java.util.LinkedList;
import java.util.Queue;

public class SpellCheckerSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "86570ADBC3157007B47DF3D9431125CE", hash_generated_field = "215C075D2F430DB54F33624A6C82B697")

    private InternalListener mInternalListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "8CEE743DC82226DD3EB73C8E69CF1A2D", hash_generated_field = "8A90A5ED4421EBC06ED5ABE0A5E545CF")

    private ITextServicesManager mTextServicesManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "39FF95092622BD6CB719CE066A7DAC80", hash_generated_field = "8BD978FCE75E98316AE251167020704C")

    private SpellCheckerInfo mSpellCheckerInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "8640C114B06EC6CB26C9CC567BCB7DB9", hash_generated_field = "176942745531278FA64A2AB945858D54")

    private SpellCheckerSessionListenerImpl mSpellCheckerSessionListenerImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "5A0767397ACD1B3D359BC84DD1623F53", hash_generated_field = "F9475A87EA4B82BC2225BE133534833A")

    private boolean mIsUsed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "FE3DA9B782403BB93B37A12C5BE57239", hash_generated_field = "35B5C20FF96DA114561FBB67E788A05C")

    private SpellCheckerSessionListener mSpellCheckerSessionListener;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_field = "F31C044CAEC6C694941601486644A901", hash_generated_field = "717D500B8155D92BDA4533EDDFF8F419")

    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.370 -0400", hash_original_method = "D344BABB0D35462B4470990692E141D9", hash_generated_method = "68AF14A458510A80CC95B3C4EF0AAC31")
        @Override
        public void handleMessage(Message msg) {
            
            handleOnGetSuggestionsMultiple((SuggestionsInfo[]) msg.obj);
            
            addTaint(msg.getTaint());
            
            
                
                    
                    
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.371 -0400", hash_original_method = "EAC7F16E5AF219F835F940B08638A4A9", hash_generated_method = "A436F7352A4B0A72DEDCAE98F0614F93")
    public  SpellCheckerSession(
            SpellCheckerInfo info, ITextServicesManager tsm, SpellCheckerSessionListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } 
        mSpellCheckerInfo = info;
        mSpellCheckerSessionListenerImpl = new SpellCheckerSessionListenerImpl(mHandler);
        mInternalListener = new InternalListener(mSpellCheckerSessionListenerImpl);
        mTextServicesManager = tsm;
        mIsUsed = true;
        mSpellCheckerSessionListener = listener;
        
        
            
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.371 -0400", hash_original_method = "682777EA87EC108D0C062651A6723A7E", hash_generated_method = "F8662276CFA16AFAB1B0A5FE9D5BE163")
    public boolean isSessionDisconnected() {
        boolean var14EF5403E45FD2FBA89DCAD21C8B8905_1527874256 = (mSpellCheckerSessionListenerImpl.isDisconnected());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435193759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_435193759;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.372 -0400", hash_original_method = "DA550B703A137477375C51611DE4E664", hash_generated_method = "11C35577E4D4D641264C70F74EA60ACB")
    public SpellCheckerInfo getSpellChecker() {
        SpellCheckerInfo varB4EAC82CA7396A68D541C85D26508E83_2016956453 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2016956453 = mSpellCheckerInfo;
        varB4EAC82CA7396A68D541C85D26508E83_2016956453.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2016956453;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.372 -0400", hash_original_method = "1E56CD8E935972828D8D1226463A945B", hash_generated_method = "6218E4D03A97D2D067BC5C2A6B63B5D3")
    public void cancel() {
        mSpellCheckerSessionListenerImpl.cancel();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.373 -0400", hash_original_method = "3C04EB6043568EF1F63B84FA07955DCB", hash_generated_method = "A95E3DBE43839B1A41210A500E18A43F")
    public void close() {
        mIsUsed = false;
        try 
        {
            mSpellCheckerSessionListenerImpl.close();
            mTextServicesManager.finishSpellCheckerService(mSpellCheckerSessionListenerImpl);
        } 
        catch (RemoteException e)
        { }
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.374 -0400", hash_original_method = "F1103B1469D8B0C12963D001E1ED8F44", hash_generated_method = "EE9248EC08EFECF7DF9B725EAA326746")
    public void getSuggestions(TextInfo textInfo, int suggestionsLimit) {
        getSuggestions(new TextInfo[] {textInfo}, suggestionsLimit, false);
        addTaint(textInfo.getTaint());
        addTaint(suggestionsLimit);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.374 -0400", hash_original_method = "748B76866E07D81600FB5AF9FEF1E977", hash_generated_method = "3EB7E0DFC4DEE221D3A355AA85DEDC07")
    public void getSuggestions(
            TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
        mSpellCheckerSessionListenerImpl.getSuggestionsMultiple(
                textInfos, suggestionsLimit, sequentialWords);
        addTaint(textInfos[0].getTaint());
        addTaint(suggestionsLimit);
        addTaint(sequentialWords);
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.374 -0400", hash_original_method = "9106E435C4B71E55E27749112B6B4B2E", hash_generated_method = "F0846F44FB8FFAFA27F7678AA335EE27")
    private void handleOnGetSuggestionsMultiple(SuggestionsInfo[] suggestionInfos) {
        mSpellCheckerSessionListener.onGetSuggestions(suggestionInfos);
        addTaint(suggestionInfos[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.375 -0400", hash_original_method = "59AD6E7808D10F8FF29E63144F2BA4F1", hash_generated_method = "8D1B5CC246C51A2C409FBDCA35933118")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        {
            close();
        } 
        
        
        
            
                    
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.375 -0400", hash_original_method = "EB5F65A578EB2CF49F3B6FAEDD6A03A1", hash_generated_method = "BDC4A6C1829BA6EFD6648A909B8F102D")
    public ITextServicesSessionListener getTextServicesSessionListener() {
        ITextServicesSessionListener varB4EAC82CA7396A68D541C85D26508E83_757177767 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_757177767 = mInternalListener;
        varB4EAC82CA7396A68D541C85D26508E83_757177767.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_757177767;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_method = "49E439EC4CF52AA024CAA5A403E07C82", hash_generated_method = "2BC5C67CFAC45F4FEE4263DD933647C7")
    public ISpellCheckerSessionListener getSpellCheckerSessionListener() {
        ISpellCheckerSessionListener varB4EAC82CA7396A68D541C85D26508E83_897231897 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_897231897 = mSpellCheckerSessionListenerImpl;
        varB4EAC82CA7396A68D541C85D26508E83_897231897.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_897231897;
        
        
    }

    
    private static class SpellCheckerSessionListenerImpl extends ISpellCheckerSessionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_field = "7D6A0A9D0A2350E3DD5674858B5F5E74", hash_generated_field = "80580ADD9DAA18B004F014E5F19E4509")

        private final Queue<SpellCheckerParams> mPendingTasks = new LinkedList<SpellCheckerParams>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_field = "F0214A3C00D73DBD06320E7A6B947430", hash_generated_field = "026997BD1DDC69199AFE6E4BEDBC44D9")

        private boolean mOpened;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_field = "2B349CEE8DE64D628AA7509FB64BA5BA", hash_generated_field = "E82EEC699A95F9ABD3944094C573C41F")

        private ISpellCheckerSession mISpellCheckerSession;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_field = "1E66AA878E170B83C94516726B34414A", hash_generated_field = "13A4D1B0812E091348BEDE1E713E2CC3")

        private HandlerThread mThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_field = "D1B24D7340F6738BAF47F74032B8981B", hash_generated_field = "CF39ABD0CA2280D07CFEF67D1D5B6BD0")

        private Handler mAsyncHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.376 -0400", hash_original_method = "45646CFDAE5B6949F64A7BA4C2829D13", hash_generated_method = "24A0ED9CB92314817C155971217375CB")
        public  SpellCheckerSessionListenerImpl(Handler handler) {
            mOpened = false;
            mHandler = handler;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.377 -0400", hash_original_method = "FF3B1A32D02DE5F870E94EBAC6E0CDD1", hash_generated_method = "BD1AB5DE97A7A172DC3221820DA8EA82")
        private void processTask(ISpellCheckerSession session, SpellCheckerParams scp,
                boolean async) {
            {
                
                try 
                {
                    session.onCancel();
                } 
                catch (RemoteException e)
                { }
                
                
                try 
                {
                    session.onGetSuggestionsMultiple(scp.mTextInfos,
                                    scp.mSuggestionsLimit, scp.mSequentialWords);
                } 
                catch (RemoteException e)
                { }
                
                
                try 
                {
                    session.onClose();
                } 
                catch (RemoteException e)
                { }
                
            } 
            {
                scp.mSession = session;
                mAsyncHandler.sendMessage(Message.obtain(mAsyncHandler, 1, scp));
            } 
            {
                {
                    mISpellCheckerSession = null;
                    mHandler = null;
                    {
                        mThread.quit();
                    } 
                    mThread = null;
                    mAsyncHandler = null;
                } 
            } 
            addTaint(session.getTaint());
            addTaint(scp.getTaint());
            addTaint(async);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.378 -0400", hash_original_method = "469ADA81CD5459833AC5296525D5CDB7", hash_generated_method = "6A2EF34EB7042949E5171A754C091CFA")
        public synchronized void onServiceConnected(ISpellCheckerSession session) {
            
            {
                mISpellCheckerSession = session;
                {
                    boolean varAD8938F523E3F11B4EEDF576B2C8DD2C_1609272648 = (session.asBinder() instanceof Binder && mThread == null);
                    {
                        mThread = new HandlerThread("SpellCheckerSession",
                            Process.THREAD_PRIORITY_BACKGROUND);
                        mThread.start();
                        mAsyncHandler = new Handler(mThread.getLooper()) {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.378 -0400", hash_original_method = "B5DD0FD72BD82B68026C922D83082837", hash_generated_method = "DD8E101330AB27E1CE1E7ADCFA486590")
                            @Override
                            public void handleMessage(Message msg) {
                                SpellCheckerParams scp = (SpellCheckerParams)msg.obj;
                                processTask(scp.mSession, scp, true);
                                addTaint(msg.getTaint());
                                
                                
                                
                            }
};
                    } 
                } 
                mOpened = true;
            } 
            Log.d(TAG, "onServiceConnected - Success");
            {
                boolean var33D248DDF5540B8F309045BDB006A7AC_683028647 = (!mPendingTasks.isEmpty());
                {
                    processTask(session, mPendingTasks.poll(), false);
                } 
            } 
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.379 -0400", hash_original_method = "BB59E0E202ED795E2DB7DAEC1471EA7A", hash_generated_method = "C4E930C13905F6F7A2A64D514C8F11C5")
        public void cancel() {
            processOrEnqueueTask(new SpellCheckerParams(TASK_CANCEL, null, 0, false));
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.379 -0400", hash_original_method = "1A7565B677D156EAC1FA51ED11F842F1", hash_generated_method = "967CEE39BE3C821ECA04BC5E9F4CE563")
        public void getSuggestionsMultiple(
                TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
            processOrEnqueueTask(
                    new SpellCheckerParams(TASK_GET_SUGGESTIONS_MULTIPLE, textInfos,
                            suggestionsLimit, sequentialWords));
            addTaint(textInfos[0].getTaint());
            addTaint(suggestionsLimit);
            addTaint(sequentialWords);
            
            
                
            
            
                    
                            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.379 -0400", hash_original_method = "09E8016792D99DD9284F914495CA50D8", hash_generated_method = "931803E97BB9F9A6C5AD300100A693F2")
        public void close() {
            processOrEnqueueTask(new SpellCheckerParams(TASK_CLOSE, null, 0, false));
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.380 -0400", hash_original_method = "C74449D517ED376786ADEE83EFA902AD", hash_generated_method = "103D445048041EE51FCCC624D3A2D834")
        public boolean isDisconnected() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1702319880 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1702319880;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.380 -0400", hash_original_method = "A1EA0918B68CB66F258D8DAFDFEA4BA7", hash_generated_method = "3D051ABA5394C0111966E3E84CDAE4FE")
        private void processOrEnqueueTask(SpellCheckerParams scp) {
            {
                Log.d(TAG, "process or enqueue task: " + mISpellCheckerSession);
            } 
            ISpellCheckerSession session;
            {
                session = mISpellCheckerSession;
                {
                    SpellCheckerParams closeTask = null;
                    {
                        {
                            boolean var55AAC515306057F86626E58A44807F5F_762946839 = (!mPendingTasks.isEmpty());
                            {
                                final SpellCheckerParams tmp = mPendingTasks.poll();
                                {
                                    closeTask = tmp;
                                } 
                            } 
                        } 
                    } 
                    mPendingTasks.offer(scp);
                    {
                        mPendingTasks.offer(closeTask);
                    } 
                } 
            } 
            processTask(session, scp, false);
            addTaint(scp.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.380 -0400", hash_original_method = "DF368CC1EE007FCF3291FF75FA752896", hash_generated_method = "9B6EADF40726938FF617FE1AAD90A6A3")
        @Override
        public void onGetSuggestions(SuggestionsInfo[] results) {
            
            {
                {
                    mHandler.sendMessage(Message.obtain(mHandler,
                            MSG_ON_GET_SUGGESTION_MULTIPLE, results));
                } 
            } 
            addTaint(results[0].getTaint());
            
            
                
                    
                            
                
            
        }

        
        private static class SpellCheckerParams {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "8DF9C1B98F3FE85ADC76D8B400B4D01B", hash_generated_field = "F09CAB29E7BAE43BF7E77A878670CC58")

            public int mWhat;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "7E516B1E896534705378D53CF9BF9CF2", hash_generated_field = "DAA029989DD6BF11DD3BC920E196ED55")

            public TextInfo[] mTextInfos;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "0CA5BC3E48B36251F8F264EA70A4DECB", hash_generated_field = "B21FF32FEA333D87A21520C6D4E3EF59")

            public int mSuggestionsLimit;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "4D65BBDDCEEF9F1BB19CD30E920514EF", hash_generated_field = "08DB8A4CE5692C4135CEE1F25739ED9F")

            public boolean mSequentialWords;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "585864B1433B33593F88424BEC9E09EF", hash_generated_field = "8B16E6760DA40F3D8F2C1AF94B738DDB")

            public ISpellCheckerSession mSession;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_method = "51C4C688A5D55FCA95337D97DFAD7FEA", hash_generated_method = "D8F47CCA6BE71DC8399AA902ECFB9936")
            public  SpellCheckerParams(int what, TextInfo[] textInfos, int suggestionsLimit,
                    boolean sequentialWords) {
                mWhat = what;
                mTextInfos = textInfos;
                mSuggestionsLimit = suggestionsLimit;
                mSequentialWords = sequentialWords;
                
                
                
                
                
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "9164A23498D5DA2BE2FE2F43F41E1099", hash_generated_field = "BE9BEF2E614EC9685F259E9E598AC103")

        private static final int TASK_CANCEL = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "0E0075303B69C4231C05D1FB9E4C88CD", hash_generated_field = "629AED697CE0562C66D82D65B1590931")

        private static final int TASK_GET_SUGGESTIONS_MULTIPLE = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "26F416BE553D6EA84F6AD974236B9C5A", hash_generated_field = "A12CF43E741DD4386EE1F2A24ECC8454")

        private static final int TASK_CLOSE = 3;
    }


    
    private static class InternalListener extends ITextServicesSessionListener.Stub {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.381 -0400", hash_original_field = "2FFB711A8F0FFE714BB32E90D46A7077", hash_generated_field = "4AF693C96983678B5C0CB0A41FA9F14D")

        private SpellCheckerSessionListenerImpl mParentSpellCheckerSessionListenerImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.382 -0400", hash_original_method = "4338D10CD0AFB882F60E57AC8CDB914E", hash_generated_method = "A8F051AD092B8DFA0B4C78897CB98223")
        public  InternalListener(SpellCheckerSessionListenerImpl spellCheckerSessionListenerImpl) {
            mParentSpellCheckerSessionListenerImpl = spellCheckerSessionListenerImpl;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.382 -0400", hash_original_method = "822E3A88968051EE65AD939CBD482992", hash_generated_method = "0BFA4B7EA232DF93314F0D03812BF48B")
        @Override
        public void onServiceConnected(ISpellCheckerSession session) {
            
            mParentSpellCheckerSessionListenerImpl.onServiceConnected(session);
            addTaint(session.getTaint());
            
            
                
            
            
        }

        
    }


    
    public interface SpellCheckerSessionListener {
        
        public void onGetSuggestions(SuggestionsInfo[] results);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.382 -0400", hash_original_field = "B002EAB02F1BA66E9105869E0E0ACAD8", hash_generated_field = "4A5080C7337BFD6CD37522D5F3819A2D")

    private static final String TAG = SpellCheckerSession.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.382 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.382 -0400", hash_original_field = "DE263946A17D09A511E31C46FC626103", hash_generated_field = "2DCFEB5D1F4AC60E1FC375E60A3273B1")

    public static final String SERVICE_META_DATA = "android.view.textservice.scs";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:03.382 -0400", hash_original_field = "AE33B60E566A7AC88EA961A4B17471A8", hash_generated_field = "9025B4E9C2670D7F8726B2FD382C594F")

    private static final int MSG_ON_GET_SUGGESTION_MULTIPLE = 1;
}

