package android.view.textservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private InternalListener mInternalListener;
    private ITextServicesManager mTextServicesManager;
    private SpellCheckerInfo mSpellCheckerInfo;
    private SpellCheckerSessionListenerImpl mSpellCheckerSessionListenerImpl;
    private boolean mIsUsed;
    private SpellCheckerSessionListener mSpellCheckerSessionListener;
    private final Handler mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.454 -0400", hash_original_method = "D344BABB0D35462B4470990692E141D9", hash_generated_method = "85F5D12A311923B5B17858FD16359734")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case MSG_ON_GET_SUGGESTION_MULTIPLE 
            handleOnGetSuggestionsMultiple((SuggestionsInfo[]) msg.obj);
            //End case MSG_ON_GET_SUGGESTION_MULTIPLE 
            // ---------- Original Method ----------
            //switch (msg.what) {
                //case MSG_ON_GET_SUGGESTION_MULTIPLE:
                    //handleOnGetSuggestionsMultiple((SuggestionsInfo[]) msg.obj);
                    //break;
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.454 -0400", hash_original_method = "EAC7F16E5AF219F835F940B08638A4A9", hash_generated_method = "55F78915FB1D9455E83C68E1CD0B5015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SpellCheckerSession(
            SpellCheckerInfo info, ITextServicesManager tsm, SpellCheckerSessionListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(tsm.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
        } //End block
        mSpellCheckerSessionListenerImpl = new SpellCheckerSessionListenerImpl(mHandler);
        mInternalListener = new InternalListener(mSpellCheckerSessionListenerImpl);
        mIsUsed = true;
        // ---------- Original Method ----------
        //if (info == null || listener == null || tsm == null) {
            //throw new NullPointerException();
        //}
        //mSpellCheckerInfo = info;
        //mSpellCheckerSessionListenerImpl = new SpellCheckerSessionListenerImpl(mHandler);
        //mInternalListener = new InternalListener(mSpellCheckerSessionListenerImpl);
        //mTextServicesManager = tsm;
        //mIsUsed = true;
        //mSpellCheckerSessionListener = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.454 -0400", hash_original_method = "682777EA87EC108D0C062651A6723A7E", hash_generated_method = "5A1EE62FBE64E862511EFFDE13C01D09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isSessionDisconnected() {
        boolean var14EF5403E45FD2FBA89DCAD21C8B8905_212793718 = (mSpellCheckerSessionListenerImpl.isDisconnected());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mSpellCheckerSessionListenerImpl.isDisconnected();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.454 -0400", hash_original_method = "DA550B703A137477375C51611DE4E664", hash_generated_method = "9BCBD1D3D8F39CDEFE40BE775D52BEB3")
    @DSModeled(DSC.SAFE)
    public SpellCheckerInfo getSpellChecker() {
        return (SpellCheckerInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSpellCheckerInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.454 -0400", hash_original_method = "1E56CD8E935972828D8D1226463A945B", hash_generated_method = "6218E4D03A97D2D067BC5C2A6B63B5D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        mSpellCheckerSessionListenerImpl.cancel();
        // ---------- Original Method ----------
        //mSpellCheckerSessionListenerImpl.cancel();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.455 -0400", hash_original_method = "3C04EB6043568EF1F63B84FA07955DCB", hash_generated_method = "A95E3DBE43839B1A41210A500E18A43F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() {
        mIsUsed = false;
        try 
        {
            mSpellCheckerSessionListenerImpl.close();
            mTextServicesManager.finishSpellCheckerService(mSpellCheckerSessionListenerImpl);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //mIsUsed = false;
        //try {
            //mSpellCheckerSessionListenerImpl.close();
            //mTextServicesManager.finishSpellCheckerService(mSpellCheckerSessionListenerImpl);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.455 -0400", hash_original_method = "F1103B1469D8B0C12963D001E1ED8F44", hash_generated_method = "407594C265C968CA02AA803C02DFF92E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSuggestions(TextInfo textInfo, int suggestionsLimit) {
        dsTaint.addTaint(suggestionsLimit);
        dsTaint.addTaint(textInfo.dsTaint);
        getSuggestions(new TextInfo[] {textInfo}, suggestionsLimit, false);
        // ---------- Original Method ----------
        //getSuggestions(new TextInfo[] {textInfo}, suggestionsLimit, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.455 -0400", hash_original_method = "748B76866E07D81600FB5AF9FEF1E977", hash_generated_method = "5345E01AB509ED0190405A6AFE92309D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getSuggestions(
            TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
        dsTaint.addTaint(suggestionsLimit);
        dsTaint.addTaint(sequentialWords);
        dsTaint.addTaint(textInfos[0].dsTaint);
        mSpellCheckerSessionListenerImpl.getSuggestionsMultiple(
                textInfos, suggestionsLimit, sequentialWords);
        // ---------- Original Method ----------
        //if (DBG) {
            //Log.w(TAG, "getSuggestions from " + mSpellCheckerInfo.getId());
        //}
        //mSpellCheckerSessionListenerImpl.getSuggestionsMultiple(
                //textInfos, suggestionsLimit, sequentialWords);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.455 -0400", hash_original_method = "9106E435C4B71E55E27749112B6B4B2E", hash_generated_method = "520E98BD30FCF80B3B2C330AF46AA4BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleOnGetSuggestionsMultiple(SuggestionsInfo[] suggestionInfos) {
        dsTaint.addTaint(suggestionInfos[0].dsTaint);
        mSpellCheckerSessionListener.onGetSuggestions(suggestionInfos);
        // ---------- Original Method ----------
        //mSpellCheckerSessionListener.onGetSuggestions(suggestionInfos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.455 -0400", hash_original_method = "59AD6E7808D10F8FF29E63144F2BA4F1", hash_generated_method = "8D1B5CC246C51A2C409FBDCA35933118")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        {
            close();
        } //End block
        // ---------- Original Method ----------
        //super.finalize();
        //if (mIsUsed) {
            //Log.e(TAG, "SpellCheckerSession was not finished properly." +
                    //"You should call finishShession() when you finished to use a spell checker.");
            //close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.456 -0400", hash_original_method = "EB5F65A578EB2CF49F3B6FAEDD6A03A1", hash_generated_method = "3EBB07353B62CC135B6DA0567EC59D0A")
    @DSModeled(DSC.SAFE)
    public ITextServicesSessionListener getTextServicesSessionListener() {
        return (ITextServicesSessionListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInternalListener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.456 -0400", hash_original_method = "49E439EC4CF52AA024CAA5A403E07C82", hash_generated_method = "C854B8CC72974236822B069F27920A3B")
    @DSModeled(DSC.SAFE)
    public ISpellCheckerSessionListener getSpellCheckerSessionListener() {
        return (ISpellCheckerSessionListener)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mSpellCheckerSessionListenerImpl;
    }

    
    private static class SpellCheckerSessionListenerImpl extends ISpellCheckerSessionListener.Stub {
        private Queue<SpellCheckerParams> mPendingTasks =
                new LinkedList<SpellCheckerParams>();
        private Handler mHandler;
        private boolean mOpened;
        private ISpellCheckerSession mISpellCheckerSession;
        private HandlerThread mThread;
        private Handler mAsyncHandler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.456 -0400", hash_original_method = "45646CFDAE5B6949F64A7BA4C2829D13", hash_generated_method = "E789973C1DF9C2C22C5E0FC4320CE0EB")
        @DSModeled(DSC.SAFE)
        public SpellCheckerSessionListenerImpl(Handler handler) {
            dsTaint.addTaint(handler.dsTaint);
            mOpened = false;
            // ---------- Original Method ----------
            //mOpened = false;
            //mHandler = handler;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.456 -0400", hash_original_method = "FF3B1A32D02DE5F870E94EBAC6E0CDD1", hash_generated_method = "88F85E6E8332F3308DE1428C07F6EB8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void processTask(ISpellCheckerSession session, SpellCheckerParams scp,
                boolean async) {
            dsTaint.addTaint(scp.dsTaint);
            dsTaint.addTaint(session.dsTaint);
            dsTaint.addTaint(async);
            {
                //Begin case TASK_CANCEL 
                try 
                {
                    session.onCancel();
                } //End block
                catch (RemoteException e)
                { }
                //End case TASK_CANCEL 
                //Begin case TASK_GET_SUGGESTIONS_MULTIPLE 
                try 
                {
                    session.onGetSuggestionsMultiple(scp.mTextInfos,
                                    scp.mSuggestionsLimit, scp.mSequentialWords);
                } //End block
                catch (RemoteException e)
                { }
                //End case TASK_GET_SUGGESTIONS_MULTIPLE 
                //Begin case TASK_CLOSE 
                try 
                {
                    session.onClose();
                } //End block
                catch (RemoteException e)
                { }
                //End case TASK_CLOSE 
            } //End block
            {
                scp.mSession = session;
                mAsyncHandler.sendMessage(Message.obtain(mAsyncHandler, 1, scp));
            } //End block
            {
                {
                    mISpellCheckerSession = null;
                    mHandler = null;
                    {
                        mThread.quit();
                    } //End block
                    mThread = null;
                    mAsyncHandler = null;
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.457 -0400", hash_original_method = "469ADA81CD5459833AC5296525D5CDB7", hash_generated_method = "5890E7A4BE316D019B09628B3324633F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public synchronized void onServiceConnected(ISpellCheckerSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            {
                {
                    boolean varAD8938F523E3F11B4EEDF576B2C8DD2C_490734166 = (session.asBinder() instanceof Binder && mThread == null);
                    {
                        mThread = new HandlerThread("SpellCheckerSession",
                            Process.THREAD_PRIORITY_BACKGROUND);
                        mThread.start();
                        mAsyncHandler = new Handler(mThread.getLooper()) {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.457 -0400", hash_original_method = "B5DD0FD72BD82B68026C922D83082837", hash_generated_method = "CAE96561B155C5FB692C92AC4DEE1F91")
                            //DSFIXME:  CODE0002: Requires DSC value to be set
                            @Override
                            public void handleMessage(Message msg) {
                                dsTaint.addTaint(msg.dsTaint);
                                SpellCheckerParams scp;
                                scp = (SpellCheckerParams)msg.obj;
                                processTask(scp.mSession, scp, true);
                                // ---------- Original Method ----------
                                //SpellCheckerParams scp = (SpellCheckerParams)msg.obj;
                                //processTask(scp.mSession, scp, true);
                            }
};
                    } //End block
                } //End collapsed parenthetic
                mOpened = true;
            } //End block
            Log.d(TAG, "onServiceConnected - Success");
            {
                boolean var33D248DDF5540B8F309045BDB006A7AC_1052301001 = (!mPendingTasks.isEmpty());
                {
                    processTask(session, mPendingTasks.poll(), false);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.457 -0400", hash_original_method = "BB59E0E202ED795E2DB7DAEC1471EA7A", hash_generated_method = "C4E930C13905F6F7A2A64D514C8F11C5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void cancel() {
            processOrEnqueueTask(new SpellCheckerParams(TASK_CANCEL, null, 0, false));
            // ---------- Original Method ----------
            //if (DBG) {
                //Log.w(TAG, "cancel");
            //}
            //processOrEnqueueTask(new SpellCheckerParams(TASK_CANCEL, null, 0, false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.458 -0400", hash_original_method = "1A7565B677D156EAC1FA51ED11F842F1", hash_generated_method = "3B984E9683227FFD9FAF4578753E7A0F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getSuggestionsMultiple(
                TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
            dsTaint.addTaint(suggestionsLimit);
            dsTaint.addTaint(sequentialWords);
            dsTaint.addTaint(textInfos[0].dsTaint);
            processOrEnqueueTask(
                    new SpellCheckerParams(TASK_GET_SUGGESTIONS_MULTIPLE, textInfos,
                            suggestionsLimit, sequentialWords));
            // ---------- Original Method ----------
            //if (DBG) {
                //Log.w(TAG, "getSuggestionsMultiple");
            //}
            //processOrEnqueueTask(
                    //new SpellCheckerParams(TASK_GET_SUGGESTIONS_MULTIPLE, textInfos,
                            //suggestionsLimit, sequentialWords));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.458 -0400", hash_original_method = "09E8016792D99DD9284F914495CA50D8", hash_generated_method = "931803E97BB9F9A6C5AD300100A693F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void close() {
            processOrEnqueueTask(new SpellCheckerParams(TASK_CLOSE, null, 0, false));
            // ---------- Original Method ----------
            //if (DBG) {
                //Log.w(TAG, "close");
            //}
            //processOrEnqueueTask(new SpellCheckerParams(TASK_CLOSE, null, 0, false));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.458 -0400", hash_original_method = "C74449D517ED376786ADEE83EFA902AD", hash_generated_method = "38E07FB5306B2B37450E2BF9A4B01BF4")
        @DSModeled(DSC.SAFE)
        public boolean isDisconnected() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mOpened && mISpellCheckerSession == null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.458 -0400", hash_original_method = "A1EA0918B68CB66F258D8DAFDFEA4BA7", hash_generated_method = "EF1EBA1DD1CE9776CDDA3336CB452022")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void processOrEnqueueTask(SpellCheckerParams scp) {
            dsTaint.addTaint(scp.dsTaint);
            {
                Log.d(TAG, "process or enqueue task: " + mISpellCheckerSession);
            } //End block
            ISpellCheckerSession session;
            {
                session = mISpellCheckerSession;
                {
                    SpellCheckerParams closeTask;
                    closeTask = null;
                    {
                        {
                            boolean var55AAC515306057F86626E58A44807F5F_22130257 = (!mPendingTasks.isEmpty());
                            {
                                SpellCheckerParams tmp;
                                tmp = mPendingTasks.poll();
                                {
                                    closeTask = tmp;
                                } //End block
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mPendingTasks.offer(scp);
                    {
                        mPendingTasks.offer(closeTask);
                    } //End block
                } //End block
            } //End block
            processTask(session, scp, false);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.458 -0400", hash_original_method = "DF368CC1EE007FCF3291FF75FA752896", hash_generated_method = "220D58EE056F02D56F7CA496A9D0E63C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onGetSuggestions(SuggestionsInfo[] results) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(results[0].dsTaint);
            {
                {
                    mHandler.sendMessage(Message.obtain(mHandler,
                            MSG_ON_GET_SUGGESTION_MULTIPLE, results));
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (this) {
                //if (mHandler != null) {
                    //mHandler.sendMessage(Message.obtain(mHandler,
                            //MSG_ON_GET_SUGGESTION_MULTIPLE, results));
                //}
            //}
        }

        
        private static class SpellCheckerParams {
            public int mWhat;
            public TextInfo[] mTextInfos;
            public int mSuggestionsLimit;
            public boolean mSequentialWords;
            public ISpellCheckerSession mSession;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.459 -0400", hash_original_method = "51C4C688A5D55FCA95337D97DFAD7FEA", hash_generated_method = "3A49FB0D2B800988EACA954BA2C8E81B")
            @DSModeled(DSC.SAFE)
            public SpellCheckerParams(int what, TextInfo[] textInfos, int suggestionsLimit,
                    boolean sequentialWords) {
                dsTaint.addTaint(suggestionsLimit);
                dsTaint.addTaint(sequentialWords);
                dsTaint.addTaint(what);
                dsTaint.addTaint(textInfos[0].dsTaint);
                // ---------- Original Method ----------
                //mWhat = what;
                //mTextInfos = textInfos;
                //mSuggestionsLimit = suggestionsLimit;
                //mSequentialWords = sequentialWords;
            }

            
        }


        
        private static final int TASK_CANCEL = 1;
        private static final int TASK_GET_SUGGESTIONS_MULTIPLE = 2;
        private static final int TASK_CLOSE = 3;
    }


    
    private static class InternalListener extends ITextServicesSessionListener.Stub {
        private SpellCheckerSessionListenerImpl mParentSpellCheckerSessionListenerImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.459 -0400", hash_original_method = "4338D10CD0AFB882F60E57AC8CDB914E", hash_generated_method = "64A22028232EF15B7343551A0320D25C")
        @DSModeled(DSC.SAFE)
        public InternalListener(SpellCheckerSessionListenerImpl spellCheckerSessionListenerImpl) {
            dsTaint.addTaint(spellCheckerSessionListenerImpl.dsTaint);
            // ---------- Original Method ----------
            //mParentSpellCheckerSessionListenerImpl = spellCheckerSessionListenerImpl;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.459 -0400", hash_original_method = "822E3A88968051EE65AD939CBD482992", hash_generated_method = "D033EC0CDA2AA0CFEA412B62261AA217")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onServiceConnected(ISpellCheckerSession session) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(session.dsTaint);
            mParentSpellCheckerSessionListenerImpl.onServiceConnected(session);
            // ---------- Original Method ----------
            //if (DBG) {
                //Log.w(TAG, "SpellCheckerSession connected.");
            //}
            //mParentSpellCheckerSessionListenerImpl.onServiceConnected(session);
        }

        
    }


    
    public interface SpellCheckerSessionListener {
        
        public void onGetSuggestions(SuggestionsInfo[] results);
    }
    
    private static final String TAG = SpellCheckerSession.class.getSimpleName();
    private static final boolean DBG = false;
    public static final String SERVICE_META_DATA = "android.view.textservice.scs";
    private static final int MSG_ON_GET_SUGGESTION_MULTIPLE = 1;
}

