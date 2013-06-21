package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class AbstractInputMethodService extends Service implements KeyEvent.Callback {
    private InputMethod mInputMethod;
    KeyEvent.DispatcherState mDispatcherState
            = new KeyEvent.DispatcherState();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.194 -0400", hash_original_method = "3C5E619BFA60E4549A53A0C5EF34E44D", hash_generated_method = "3C5E619BFA60E4549A53A0C5EF34E44D")
        public AbstractInputMethodService ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.194 -0400", hash_original_method = "506AD561617E231B7466C0A7229483CE", hash_generated_method = "34F08E104AE59CBEF9B42FFA1AFC518E")
    @DSModeled(DSC.SAFE)
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return (KeyEvent.DispatcherState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDispatcherState;
    }

    
    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    
    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.195 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "6CF40A5AD6EAB3A3D61C7A8F6965C7F4")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.195 -0400", hash_original_method = "A37FBA98B4D1A366D99013E441DCBD11", hash_generated_method = "D1F70C9B5C06ADD72BE26EF9689EC64D")
    @DSModeled(DSC.SPEC)
    @Override
    final public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        {
            mInputMethod = onCreateInputMethodInterface();
        } //End block
        IBinder var4BB6BE0A070CD15BEEC6523C61F84E3B_229183023 = (new IInputMethodWrapper(this, mInputMethod));
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mInputMethod == null) {
            //mInputMethod = onCreateInputMethodInterface();
        //}
        //return new IInputMethodWrapper(this, mInputMethod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.195 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "833D77A11226C846CBB638957F249990")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract class AbstractInputMethodImpl implements InputMethod {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.196 -0400", hash_original_method = "D6C4AD7630EA63217AB7FFD645D89AF9", hash_generated_method = "D6C4AD7630EA63217AB7FFD645D89AF9")
                public AbstractInputMethodImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.196 -0400", hash_original_method = "084F24BCF671A12F38D7783BEA9F6E08", hash_generated_method = "7DD629B2406FD2D1F252C59CAB57DCEC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void createSession(SessionCallback callback) {
            dsTaint.addTaint(callback.dsTaint);
            callback.sessionCreated(onCreateInputMethodSessionInterface());
            // ---------- Original Method ----------
            //callback.sessionCreated(onCreateInputMethodSessionInterface());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.196 -0400", hash_original_method = "66C173BC408ADA3F5326213B71DD3797", hash_generated_method = "2FBB8905CA70C0BDA4B98B6FAB9DEFF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setSessionEnabled(InputMethodSession session, boolean enabled) {
            dsTaint.addTaint(enabled);
            dsTaint.addTaint(session.dsTaint);
            ((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.196 -0400", hash_original_method = "79971C84DD1A2F851BEBA1D6EABE42F6", hash_generated_method = "91A4E5D9554C520C0612BEB42B48D40F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void revokeSession(InputMethodSession session) {
            dsTaint.addTaint(session.dsTaint);
            ((AbstractInputMethodSessionImpl)session).revokeSelf();
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).revokeSelf();
        }

        
    }


    
    public abstract class AbstractInputMethodSessionImpl implements InputMethodSession {
        boolean mEnabled = true;
        boolean mRevoked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.196 -0400", hash_original_method = "14FE0FF293F499EEE7EE8AB557DFCDA2", hash_generated_method = "14FE0FF293F499EEE7EE8AB557DFCDA2")
                public AbstractInputMethodSessionImpl ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.197 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "1942C8160CC405585840489895F59E2E")
        @DSModeled(DSC.SAFE)
        public boolean isEnabled() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.197 -0400", hash_original_method = "C0B4C5A0A5D7F00D5E6612F5DDAFF7B5", hash_generated_method = "E8BAD024660C8E4579ECC72397316F55")
        @DSModeled(DSC.SAFE)
        public boolean isRevoked() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRevoked;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.197 -0400", hash_original_method = "BA8B8E3B4141C528807EA03970F3ED77", hash_generated_method = "6B93B969A6AFCB541DBAFEF1060C2EEF")
        @DSModeled(DSC.SAFE)
        public void setEnabled(boolean enabled) {
            dsTaint.addTaint(enabled);
            // ---------- Original Method ----------
            //if (!mRevoked) {
                //mEnabled = enabled;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.197 -0400", hash_original_method = "6150597809F85496BEE526162ACEB60F", hash_generated_method = "E60B36F04B14FB96FAC9E90F23CA5FB2")
        @DSModeled(DSC.SAFE)
        public void revokeSelf() {
            mRevoked = true;
            mEnabled = false;
            // ---------- Original Method ----------
            //mRevoked = true;
            //mEnabled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.198 -0400", hash_original_method = "352A951CCD835CDBB0D749381932ADC2", hash_generated_method = "0067E241230AB90CD31CF7C81B4B64F2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchKeyEvent(int seq, KeyEvent event, EventCallback callback) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(seq);
            boolean handled;
            handled = event.dispatch(AbstractInputMethodService.this,
                    mDispatcherState, this);
            {
                callback.finishedEvent(seq, handled);
            } //End block
            // ---------- Original Method ----------
            //boolean handled = event.dispatch(AbstractInputMethodService.this,
                    //mDispatcherState, this);
            //if (callback != null) {
                //callback.finishedEvent(seq, handled);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:49.198 -0400", hash_original_method = "D1FB978C0FC3E262298A1F84CE672B17", hash_generated_method = "AFDF3B7635BC91B3A0D7D1016A3E00A7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchTrackballEvent(int seq, MotionEvent event, EventCallback callback) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(callback.dsTaint);
            dsTaint.addTaint(seq);
            boolean handled;
            handled = onTrackballEvent(event);
            {
                callback.finishedEvent(seq, handled);
            } //End block
            // ---------- Original Method ----------
            //boolean handled = onTrackballEvent(event);
            //if (callback != null) {
                //callback.finishedEvent(seq, handled);
            //}
        }

        
    }


    
}

