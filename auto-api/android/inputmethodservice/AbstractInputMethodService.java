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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.018 -0400", hash_original_method = "506AD561617E231B7466C0A7229483CE", hash_generated_method = "FF71C853F6FE0A125B8AF48B97FBFBEC")
    @DSModeled(DSC.SAFE)
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        return (KeyEvent.DispatcherState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mDispatcherState;
    }

    
    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    
    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.028 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "F9CCE3223ABC8209871F2DA81F987463")
    @DSModeled(DSC.SAFE)
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        dsTaint.addTaint(fout.dsTaint);
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.038 -0400", hash_original_method = "A37FBA98B4D1A366D99013E441DCBD11", hash_generated_method = "5F00D1AC5E874F0104DE87E5283D772F")
    @DSModeled(DSC.SPEC)
    @Override
    final public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        {
            mInputMethod = onCreateInputMethodInterface();
        } //End block
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mInputMethod == null) {
            //mInputMethod = onCreateInputMethodInterface();
        //}
        //return new IInputMethodWrapper(this, mInputMethod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.052 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "B408743212A32554110D224D6DDF0567")
    @DSModeled(DSC.SAFE)
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(event.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract class AbstractInputMethodImpl implements InputMethod {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.062 -0400", hash_original_method = "084F24BCF671A12F38D7783BEA9F6E08", hash_generated_method = "A316A38073C6339C147ACCD544F67348")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void createSession(SessionCallback callback) {
            dsTaint.addTaint(callback.dsTaint);
            callback.sessionCreated(onCreateInputMethodSessionInterface());
            // ---------- Original Method ----------
            //callback.sessionCreated(onCreateInputMethodSessionInterface());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.076 -0400", hash_original_method = "66C173BC408ADA3F5326213B71DD3797", hash_generated_method = "2588C88037A3148417B449B00D15069F")
        @DSModeled(DSC.SAFE)
        public void setSessionEnabled(InputMethodSession session, boolean enabled) {
            dsTaint.addTaint(enabled);
            dsTaint.addTaint(session.dsTaint);
            ((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.087 -0400", hash_original_method = "79971C84DD1A2F851BEBA1D6EABE42F6", hash_generated_method = "68477BD54BDFB0CAE774710916E597EA")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.096 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "D3221B9EBF9B45829BBBD9E6EE8A9205")
        @DSModeled(DSC.SAFE)
        public boolean isEnabled() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.101 -0400", hash_original_method = "C0B4C5A0A5D7F00D5E6612F5DDAFF7B5", hash_generated_method = "B254DD67E77D50A8D186C37BFCDD6893")
        @DSModeled(DSC.SAFE)
        public boolean isRevoked() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mRevoked;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.114 -0400", hash_original_method = "BA8B8E3B4141C528807EA03970F3ED77", hash_generated_method = "B2D4E80140934850743286E003FA8DF9")
        @DSModeled(DSC.SAFE)
        public void setEnabled(boolean enabled) {
            dsTaint.addTaint(enabled);
            // ---------- Original Method ----------
            //if (!mRevoked) {
                //mEnabled = enabled;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.121 -0400", hash_original_method = "6150597809F85496BEE526162ACEB60F", hash_generated_method = "0D26C303491329A4014A68E0F40E1D13")
        @DSModeled(DSC.SAFE)
        public void revokeSelf() {
            mRevoked = true;
            mEnabled = false;
            // ---------- Original Method ----------
            //mRevoked = true;
            //mEnabled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.132 -0400", hash_original_method = "352A951CCD835CDBB0D749381932ADC2", hash_generated_method = "2BE4461651F36E4BCD508283D9F966AB")
        @DSModeled(DSC.SAFE)
        public void dispatchKeyEvent(int seq, KeyEvent event, EventCallback callback) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(seq);
            dsTaint.addTaint(callback.dsTaint);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 16:56:34.143 -0400", hash_original_method = "D1FB978C0FC3E262298A1F84CE672B17", hash_generated_method = "1DD32B33D8E3FFDF3CBACF5AE8EFF672")
        @DSModeled(DSC.SAFE)
        public void dispatchTrackballEvent(int seq, MotionEvent event, EventCallback callback) {
            dsTaint.addTaint(event.dsTaint);
            dsTaint.addTaint(seq);
            dsTaint.addTaint(callback.dsTaint);
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


