package android.view.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.LinkedList;
import java.util.Queue;

import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;

import com.android.internal.textservice.ISpellCheckerSession;
import com.android.internal.textservice.ISpellCheckerSessionListener;
import com.android.internal.textservice.ITextServicesManager;
import com.android.internal.textservice.ITextServicesSessionListener;

public class SpellCheckerSession {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.624 -0500", hash_original_field = "B854932C3FAA74BA50573D25BC233557", hash_generated_field = "4A5080C7337BFD6CD37522D5F3819A2D")

    private static final String TAG = SpellCheckerSession.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.627 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.629 -0500", hash_original_field = "04492A98CA59729EC8D526BB2A6462FD", hash_generated_field = "2DCFEB5D1F4AC60E1FC375E60A3273B1")

    public static final String SERVICE_META_DATA = "android.view.textservice.scs";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.632 -0500", hash_original_field = "C87712169D13F0899ECA905C6290F0FD", hash_generated_field = "9025B4E9C2670D7F8726B2FD382C594F")

    private static final int MSG_ON_GET_SUGGESTION_MULTIPLE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.634 -0500", hash_original_field = "5EC361295D4DE6E08C73E803C0C8071F", hash_generated_field = "215C075D2F430DB54F33624A6C82B697")

    private  InternalListener mInternalListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.636 -0500", hash_original_field = "9F0D574F42B1A66ED917A76D81B45C2B", hash_generated_field = "8A90A5ED4421EBC06ED5ABE0A5E545CF")

    private  ITextServicesManager mTextServicesManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.638 -0500", hash_original_field = "2658149484789A164A58FD6827285586", hash_generated_field = "8BD978FCE75E98316AE251167020704C")

    private  SpellCheckerInfo mSpellCheckerInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.641 -0500", hash_original_field = "8FD280405F8D2175E0412EF3F6D78006", hash_generated_field = "176942745531278FA64A2AB945858D54")

    private  SpellCheckerSessionListenerImpl mSpellCheckerSessionListenerImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.643 -0500", hash_original_field = "03EC8BA9EB3BC10900413E5A37BB226E", hash_generated_field = "F9475A87EA4B82BC2225BE133534833A")

    private boolean mIsUsed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.646 -0500", hash_original_field = "AB59BA8F975581732C2E1BE9C85F7479", hash_generated_field = "35B5C20FF96DA114561FBB67E788A05C")

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

    /**
     * Constructor
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.655 -0500", hash_original_method = "EAC7F16E5AF219F835F940B08638A4A9", hash_generated_method = "60BEBB5BBD2F2CA2BCC48D8D8F99222A")
    
public SpellCheckerSession(
            SpellCheckerInfo info, ITextServicesManager tsm, SpellCheckerSessionListener listener) {
        if (info == null || listener == null || tsm == null) {
            throw new NullPointerException();
        }
        mSpellCheckerInfo = info;
        mSpellCheckerSessionListenerImpl = new SpellCheckerSessionListenerImpl(mHandler);
        mInternalListener = new InternalListener(mSpellCheckerSessionListenerImpl);
        mTextServicesManager = tsm;
        mIsUsed = true;
        mSpellCheckerSessionListener = listener;
    }

    /**
     * @return true if the connection to a text service of this session is disconnected and not
     * alive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.658 -0500", hash_original_method = "682777EA87EC108D0C062651A6723A7E", hash_generated_method = "DEC3C2D903E5175E5D92A04CDD32326E")
    
public boolean isSessionDisconnected() {
        return mSpellCheckerSessionListenerImpl.isDisconnected();
    }

    /**
     * Get the spell checker service info this spell checker session has.
     * @return SpellCheckerInfo for the specified locale.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.660 -0500", hash_original_method = "DA550B703A137477375C51611DE4E664", hash_generated_method = "AD892B14616F1FA3808075B163F413AB")
    
public SpellCheckerInfo getSpellChecker() {
        return mSpellCheckerInfo;
    }

    /**
     * Cancel pending and running spell check tasks
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.662 -0500", hash_original_method = "1E56CD8E935972828D8D1226463A945B", hash_generated_method = "9754DC6A4D0B0898367A1FDE63DD6915")
    
public void cancel() {
        mSpellCheckerSessionListenerImpl.cancel();
    }

    /**
     * Finish this session and allow TextServicesManagerService to disconnect the bound spell
     * checker.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.665 -0500", hash_original_method = "3C04EB6043568EF1F63B84FA07955DCB", hash_generated_method = "1454203CB477A854970972E8C41D8CF2")
    
public void close() {
        mIsUsed = false;
        try {
            mSpellCheckerSessionListenerImpl.close();
            mTextServicesManager.finishSpellCheckerService(mSpellCheckerSessionListenerImpl);
        } catch (RemoteException e) {
            // do nothing
        }
    }

    /**
     * Get candidate strings for a substring of the specified text.
     * @param textInfo text metadata for a spell checker
     * @param suggestionsLimit the number of limit of suggestions returned
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.667 -0500", hash_original_method = "F1103B1469D8B0C12963D001E1ED8F44", hash_generated_method = "6639A803142C281DED979EBFF38E9636")
    
public void getSuggestions(TextInfo textInfo, int suggestionsLimit) {
        getSuggestions(new TextInfo[] {textInfo}, suggestionsLimit, false);
    }

    /**
     * A batch process of getSuggestions
     * @param textInfos an array of text metadata for a spell checker
     * @param suggestionsLimit the number of limit of suggestions returned
     * @param sequentialWords true if textInfos can be treated as sequential words.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.669 -0500", hash_original_method = "748B76866E07D81600FB5AF9FEF1E977", hash_generated_method = "2403F30C4E582B8A87DF4517A57CAAA6")
    
public void getSuggestions(
            TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
        if (DBG) {
            Log.w(TAG, "getSuggestions from " + mSpellCheckerInfo.getId());
        }
        // TODO: Handle multiple words suggestions by using WordBreakIterator
        mSpellCheckerSessionListenerImpl.getSuggestionsMultiple(
                textInfos, suggestionsLimit, sequentialWords);
    }
    
    private static class SpellCheckerSessionListenerImpl extends ISpellCheckerSessionListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.675 -0500", hash_original_field = "AFA38DCC0A886D6BCF188E88DFC449A7", hash_generated_field = "BE9BEF2E614EC9685F259E9E598AC103")

        private static final int TASK_CANCEL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.678 -0500", hash_original_field = "7F9CEC7ED244DCE735306FBB8E14A372", hash_generated_field = "629AED697CE0562C66D82D65B1590931")

        private static final int TASK_GET_SUGGESTIONS_MULTIPLE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.680 -0500", hash_original_field = "D432DF6140F005EA00948DFA0B63B875", hash_generated_field = "A12CF43E741DD4386EE1F2A24ECC8454")

        private static final int TASK_CLOSE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.683 -0500", hash_original_field = "0CC05A2EA1CFAFE87A4F00BBC211442D", hash_generated_field = "80580ADD9DAA18B004F014E5F19E4509")

        private final Queue<SpellCheckerParams> mPendingTasks =
                new LinkedList<SpellCheckerParams>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.685 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

        private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.687 -0500", hash_original_field = "52FE620C9038F34E9FF4A05B2EF3C4AA", hash_generated_field = "026997BD1DDC69199AFE6E4BEDBC44D9")

        private boolean mOpened;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.689 -0500", hash_original_field = "898B4AAF824B85CC3D632A615E2DF227", hash_generated_field = "E82EEC699A95F9ABD3944094C573C41F")

        private ISpellCheckerSession mISpellCheckerSession;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.692 -0500", hash_original_field = "F61C42BD5FC0533628F1C88D45386334", hash_generated_field = "13A4D1B0812E091348BEDE1E713E2CC3")

        private HandlerThread mThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.694 -0500", hash_original_field = "AA0225CC1E91BEEF359F1B4984D73E62", hash_generated_field = "CF39ABD0CA2280D07CFEF67D1D5B6BD0")

        private Handler mAsyncHandler;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.697 -0500", hash_original_method = "45646CFDAE5B6949F64A7BA4C2829D13", hash_generated_method = "DA92413FC5CCD0F953CB19CE4E6FCAE1")
        
public SpellCheckerSessionListenerImpl(Handler handler) {
            mOpened = false;
            mHandler = handler;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.721 -0500", hash_original_method = "FF3B1A32D02DE5F870E94EBAC6E0CDD1", hash_generated_method = "DB9339400AA7A57A68F2708417676130")
        
private void processTask(ISpellCheckerSession session, SpellCheckerParams scp,
                boolean async) {
            if (async || mAsyncHandler == null) {
                switch (scp.mWhat) {
                    case TASK_CANCEL:
                        if (DBG) {
                            Log.w(TAG, "Cancel spell checker tasks.");
                        }
                        try {
                            session.onCancel();
                        } catch (RemoteException e) {
                            Log.e(TAG, "Failed to cancel " + e);
                        }
                        break;
                    case TASK_GET_SUGGESTIONS_MULTIPLE:
                        if (DBG) {
                            Log.w(TAG, "Get suggestions from the spell checker.");
                        }
                        try {
                            session.onGetSuggestionsMultiple(scp.mTextInfos,
                                    scp.mSuggestionsLimit, scp.mSequentialWords);
                        } catch (RemoteException e) {
                            Log.e(TAG, "Failed to get suggestions " + e);
                        }
                        break;
                    case TASK_CLOSE:
                        if (DBG) {
                            Log.w(TAG, "Close spell checker tasks.");
                        }
                        try {
                            session.onClose();
                        } catch (RemoteException e) {
                            Log.e(TAG, "Failed to close " + e);
                        }
                        break;
                }
            } else {
                // The interface is to a local object, so need to execute it
                // asynchronously.
                scp.mSession = session;
                mAsyncHandler.sendMessage(Message.obtain(mAsyncHandler, 1, scp));
            }

            if (scp.mWhat == TASK_CLOSE) {
                // If we are closing, we want to clean up our state now even
                // if it is pending as an async operation.
                synchronized (this) {
                    mISpellCheckerSession = null;
                    mHandler = null;
                    if (mThread != null) {
                        mThread.quit();
                    }
                    mThread = null;
                    mAsyncHandler = null;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.727 -0500", hash_original_method = "469ADA81CD5459833AC5296525D5CDB7", hash_generated_method = "7586A810A89935EF3CAE9DF999CBD109")
        
public synchronized void onServiceConnected(ISpellCheckerSession session) {
            synchronized (this) {
                mISpellCheckerSession = session;
                if (session.asBinder() instanceof Binder && mThread == null) {
                    // If this is a local object, we need to do our own threading
                    // to make sure we handle it asynchronously.
                    mThread = new HandlerThread("SpellCheckerSession",
                            Process.THREAD_PRIORITY_BACKGROUND);
                    mThread.start();
                    mAsyncHandler = new Handler(mThread.getLooper()) {
                        @Override public void handleMessage(Message msg) {
                            SpellCheckerParams scp = (SpellCheckerParams)msg.obj;
                            processTask(scp.mSession, scp, true);
                        }
                    };
                }
                mOpened = true;
            }
            if (DBG)
                Log.d(TAG, "onServiceConnected - Success");
            while (!mPendingTasks.isEmpty()) {
                processTask(session, mPendingTasks.poll(), false);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.729 -0500", hash_original_method = "BB59E0E202ED795E2DB7DAEC1471EA7A", hash_generated_method = "C626559F46C246A3B686F07B638B952B")
        
public void cancel() {
            if (DBG) {
                Log.w(TAG, "cancel");
            }
            processOrEnqueueTask(new SpellCheckerParams(TASK_CANCEL, null, 0, false));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.732 -0500", hash_original_method = "1A7565B677D156EAC1FA51ED11F842F1", hash_generated_method = "FE9A61CB8472D3BE8B988023B583EEB6")
        
public void getSuggestionsMultiple(
                TextInfo[] textInfos, int suggestionsLimit, boolean sequentialWords) {
            if (DBG) {
                Log.w(TAG, "getSuggestionsMultiple");
            }
            processOrEnqueueTask(
                    new SpellCheckerParams(TASK_GET_SUGGESTIONS_MULTIPLE, textInfos,
                            suggestionsLimit, sequentialWords));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.734 -0500", hash_original_method = "09E8016792D99DD9284F914495CA50D8", hash_generated_method = "5CDC9B384B823ACE8263319E52FE5B2B")
        
public void close() {
            if (DBG) {
                Log.w(TAG, "close");
            }
            processOrEnqueueTask(new SpellCheckerParams(TASK_CLOSE, null, 0, false));
        }
        
        private static class SpellCheckerParams {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.701 -0500", hash_original_field = "AD192258EC939820B26091D9420D7F0C", hash_generated_field = "F09CAB29E7BAE43BF7E77A878670CC58")

            public  int mWhat;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.705 -0500", hash_original_field = "1457B25D1B892F781C0845FA914FDE3A", hash_generated_field = "DAA029989DD6BF11DD3BC920E196ED55")

            public  TextInfo[] mTextInfos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.707 -0500", hash_original_field = "181F4F2A7553873D2C3ED26DD3EAE5D7", hash_generated_field = "B21FF32FEA333D87A21520C6D4E3EF59")

            public  int mSuggestionsLimit;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.710 -0500", hash_original_field = "99BEB89FF03C385899E96F08BA10774B", hash_generated_field = "08DB8A4CE5692C4135CEE1F25739ED9F")

            public  boolean mSequentialWords;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.712 -0500", hash_original_field = "A1DB09756C57FA801F8665AB07FE49D7", hash_generated_field = "8B16E6760DA40F3D8F2C1AF94B738DDB")

            public ISpellCheckerSession mSession;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.715 -0500", hash_original_method = "51C4C688A5D55FCA95337D97DFAD7FEA", hash_generated_method = "69B0E48B0A0EA24A15C19ADBFE5544C8")
            
public SpellCheckerParams(int what, TextInfo[] textInfos, int suggestionsLimit,
                    boolean sequentialWords) {
                mWhat = what;
                mTextInfos = textInfos;
                mSuggestionsLimit = suggestionsLimit;
                mSequentialWords = sequentialWords;
            }
            
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.737 -0500", hash_original_method = "C74449D517ED376786ADEE83EFA902AD", hash_generated_method = "5287B938B121702C6C0D0BE7D2E495C2")
        
public boolean isDisconnected() {
            return mOpened && mISpellCheckerSession == null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.740 -0500", hash_original_method = "A1EA0918B68CB66F258D8DAFDFEA4BA7", hash_generated_method = "5726A5CB75281C19A4BAC582BBDE3CDC")
        
private void processOrEnqueueTask(SpellCheckerParams scp) {
            if (DBG) {
                Log.d(TAG, "process or enqueue task: " + mISpellCheckerSession);
            }
            ISpellCheckerSession session;
            synchronized (this) {
                session = mISpellCheckerSession;
                if (session == null) {
                    SpellCheckerParams closeTask = null;
                    if (scp.mWhat == TASK_CANCEL) {
                        while (!mPendingTasks.isEmpty()) {
                            final SpellCheckerParams tmp = mPendingTasks.poll();
                            if (tmp.mWhat == TASK_CLOSE) {
                                // Only one close task should be processed, while we need to remove all
                                // close tasks from the queue
                                closeTask = tmp;
                            }
                        }
                    }
                    mPendingTasks.offer(scp);
                    if (closeTask != null) {
                        mPendingTasks.offer(closeTask);
                    }
                    return;
                }
            }
            processTask(session, scp, false);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.743 -0500", hash_original_method = "DF368CC1EE007FCF3291FF75FA752896", hash_generated_method = "4F6FFE216588456B2B09F1553A03F3A6")
        
@Override
        public void onGetSuggestions(SuggestionsInfo[] results) {
            synchronized (this) {
                if (mHandler != null) {
                    mHandler.sendMessage(Message.obtain(mHandler,
                            MSG_ON_GET_SUGGESTION_MULTIPLE, results));
                }
            }
        }
    }
    
    private static class InternalListener extends ITextServicesSessionListener.Stub {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.753 -0500", hash_original_field = "44A013E22F3C86FE53736C73370D7032", hash_generated_field = "4AF693C96983678B5C0CB0A41FA9F14D")

        private  SpellCheckerSessionListenerImpl mParentSpellCheckerSessionListenerImpl;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.755 -0500", hash_original_method = "4338D10CD0AFB882F60E57AC8CDB914E", hash_generated_method = "2CB2C447C7F9F4FCEC1A8478A322A9AE")
        
public InternalListener(SpellCheckerSessionListenerImpl spellCheckerSessionListenerImpl) {
            mParentSpellCheckerSessionListenerImpl = spellCheckerSessionListenerImpl;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.758 -0500", hash_original_method = "822E3A88968051EE65AD939CBD482992", hash_generated_method = "222516EEC96C56971F516B2C8E8A5E02")
        
@Override
        public void onServiceConnected(ISpellCheckerSession session) {
            if (DBG) {
                Log.w(TAG, "SpellCheckerSession connected.");
            }
            mParentSpellCheckerSessionListenerImpl.onServiceConnected(session);
        }
        
    }
    
    public interface SpellCheckerSessionListener {
        
        public void onGetSuggestions(SuggestionsInfo[] results);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.672 -0500", hash_original_method = "9106E435C4B71E55E27749112B6B4B2E", hash_generated_method = "E94AB98A454534A8F5CA1B9E29D66662")
    
private void handleOnGetSuggestionsMultiple(SuggestionsInfo[] suggestionInfos) {
        mSpellCheckerSessionListener.onGetSuggestions(suggestionInfos);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.762 -0500", hash_original_method = "59AD6E7808D10F8FF29E63144F2BA4F1", hash_generated_method = "E583ED320811052FAB02D57D16D594BF")
    
@Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (mIsUsed) {
            Log.e(TAG, "SpellCheckerSession was not finished properly." +
                    "You should call finishShession() when you finished to use a spell checker.");
            close();
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.764 -0500", hash_original_method = "EB5F65A578EB2CF49F3B6FAEDD6A03A1", hash_generated_method = "D8602A56238F43257D3C114807D82BC9")
    
public ITextServicesSessionListener getTextServicesSessionListener() {
        return mInternalListener;
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.767 -0500", hash_original_method = "49E439EC4CF52AA024CAA5A403E07C82", hash_generated_method = "BCF3460FB9CFA65F48B614AF05CB3502")
    
public ISpellCheckerSessionListener getSpellCheckerSessionListener() {
        return mSpellCheckerSessionListenerImpl;
    }
}

