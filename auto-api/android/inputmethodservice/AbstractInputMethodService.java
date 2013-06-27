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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.488 -0400", hash_original_field = "DBEE96406A00F429F32FF5AA58FA6E69", hash_generated_field = "9355B5F89B0311B79EB4664ED09CF53D")

    private InputMethod mInputMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.488 -0400", hash_original_field = "F8D33D2022493F8E03ABC3EF1AA04F31", hash_generated_field = "072D100A7BFFF1A5663A0C0EDC099F15")

    KeyEvent.DispatcherState mDispatcherState = new KeyEvent.DispatcherState();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.492 -0400", hash_original_method = "BC18251CD7580FCA2AE30C6FE0852CCA", hash_generated_method = "BC18251CD7580FCA2AE30C6FE0852CCA")
    public AbstractInputMethodService ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.493 -0400", hash_original_method = "506AD561617E231B7466C0A7229483CE", hash_generated_method = "6F6D1398E6A580FF6BDBBF5283EE1948")
    public KeyEvent.DispatcherState getKeyDispatcherState() {
        KeyEvent.DispatcherState varB4EAC82CA7396A68D541C85D26508E83_846374278 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_846374278 = mDispatcherState;
        varB4EAC82CA7396A68D541C85D26508E83_846374278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_846374278;
        // ---------- Original Method ----------
        //return mDispatcherState;
    }

    
    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    
    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.494 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "1D10734FE092C816735A266BA81DD94D")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(fd.getTaint());
        addTaint(fout.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.496 -0400", hash_original_method = "A37FBA98B4D1A366D99013E441DCBD11", hash_generated_method = "4E7FB1C2A28D5D689EAD52EF71493C57")
    @Override
    final public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        IBinder varB4EAC82CA7396A68D541C85D26508E83_617763437 = null; //Variable for return #1
        {
            mInputMethod = onCreateInputMethodInterface();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_617763437 = new IInputMethodWrapper(this, mInputMethod);
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_617763437.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_617763437;
        // ---------- Original Method ----------
        //if (mInputMethod == null) {
            //mInputMethod = onCreateInputMethodInterface();
        //}
        //return new IInputMethodWrapper(this, mInputMethod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.496 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "282FCD396EE5207124A1754A7A4A8335")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_695250684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_695250684;
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract class AbstractInputMethodImpl implements InputMethod {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.515 -0400", hash_original_method = "1FC06C592D7CEB663723BCE3B795B4B6", hash_generated_method = "1FC06C592D7CEB663723BCE3B795B4B6")
        public AbstractInputMethodImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.516 -0400", hash_original_method = "084F24BCF671A12F38D7783BEA9F6E08", hash_generated_method = "5F37275F9AC7E62EA34903454AB3423C")
        public void createSession(SessionCallback callback) {
            callback.sessionCreated(onCreateInputMethodSessionInterface());
            addTaint(callback.getTaint());
            // ---------- Original Method ----------
            //callback.sessionCreated(onCreateInputMethodSessionInterface());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.517 -0400", hash_original_method = "66C173BC408ADA3F5326213B71DD3797", hash_generated_method = "7DCA70B1E0F9272FCB114314AD9ECF4B")
        public void setSessionEnabled(InputMethodSession session, boolean enabled) {
            ((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
            addTaint(session.getTaint());
            addTaint(enabled);
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.517 -0400", hash_original_method = "79971C84DD1A2F851BEBA1D6EABE42F6", hash_generated_method = "045F99F26A88201FEF0645DFA479691E")
        public void revokeSession(InputMethodSession session) {
            ((AbstractInputMethodSessionImpl)session).revokeSelf();
            addTaint(session.getTaint());
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).revokeSelf();
        }

        
    }


    
    public abstract class AbstractInputMethodSessionImpl implements InputMethodSession {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.518 -0400", hash_original_field = "71AB1146E1CEE92AB74D832DEFFE135F", hash_generated_field = "35AD8B69CCAB99ED75EF706EA5E75D7E")

        boolean mEnabled = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.518 -0400", hash_original_field = "F1726E470958465011824E5F0EBDE84F", hash_generated_field = "5781D1C4F0DDC12DF2BB3E12406C7974")

        boolean mRevoked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.519 -0400", hash_original_method = "732EE9B327CCA9D778A0A67756B490DA", hash_generated_method = "732EE9B327CCA9D778A0A67756B490DA")
        public AbstractInputMethodSessionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.519 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "68A68991CA237C33FBDFD119DA63F32F")
        public boolean isEnabled() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1257346552 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1257346552;
            // ---------- Original Method ----------
            //return mEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.525 -0400", hash_original_method = "C0B4C5A0A5D7F00D5E6612F5DDAFF7B5", hash_generated_method = "561F9533581BB47C732BACF6B51E27A0")
        public boolean isRevoked() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340138351 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_340138351;
            // ---------- Original Method ----------
            //return mRevoked;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.538 -0400", hash_original_method = "BA8B8E3B4141C528807EA03970F3ED77", hash_generated_method = "94A2A90AC6C5A052E1295DDC3118E60A")
        public void setEnabled(boolean enabled) {
            {
                mEnabled = enabled;
            } //End block
            // ---------- Original Method ----------
            //if (!mRevoked) {
                //mEnabled = enabled;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.539 -0400", hash_original_method = "6150597809F85496BEE526162ACEB60F", hash_generated_method = "E60B36F04B14FB96FAC9E90F23CA5FB2")
        public void revokeSelf() {
            mRevoked = true;
            mEnabled = false;
            // ---------- Original Method ----------
            //mRevoked = true;
            //mEnabled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.539 -0400", hash_original_method = "352A951CCD835CDBB0D749381932ADC2", hash_generated_method = "D0093A172A16DF0A8922E953D75A1FB2")
        public void dispatchKeyEvent(int seq, KeyEvent event, EventCallback callback) {
            boolean handled;
            handled = event.dispatch(AbstractInputMethodService.this,
                    mDispatcherState, this);
            {
                callback.finishedEvent(seq, handled);
            } //End block
            addTaint(seq);
            addTaint(event.getTaint());
            addTaint(callback.getTaint());
            // ---------- Original Method ----------
            //boolean handled = event.dispatch(AbstractInputMethodService.this,
                    //mDispatcherState, this);
            //if (callback != null) {
                //callback.finishedEvent(seq, handled);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:15.543 -0400", hash_original_method = "D1FB978C0FC3E262298A1F84CE672B17", hash_generated_method = "D41E62350CCC3001AB5965E41F4AC16D")
        public void dispatchTrackballEvent(int seq, MotionEvent event, EventCallback callback) {
            boolean handled;
            handled = onTrackballEvent(event);
            {
                callback.finishedEvent(seq, handled);
            } //End block
            addTaint(seq);
            addTaint(event.getTaint());
            addTaint(callback.getTaint());
            // ---------- Original Method ----------
            //boolean handled = onTrackballEvent(event);
            //if (callback != null) {
                //callback.finishedEvent(seq, handled);
            //}
        }

        
    }


    
}

