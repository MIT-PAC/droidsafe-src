package android.inputmethodservice;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.021 -0400", hash_original_field = "DBEE96406A00F429F32FF5AA58FA6E69", hash_generated_field = "9355B5F89B0311B79EB4664ED09CF53D")

    private InputMethod mInputMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.021 -0400", hash_original_field = "F8D33D2022493F8E03ABC3EF1AA04F31", hash_generated_field = "98A76EB2F504968B591CF0A5D11D8253")

    final KeyEvent.DispatcherState mDispatcherState = new KeyEvent.DispatcherState();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.021 -0400", hash_original_method = "BC18251CD7580FCA2AE30C6FE0852CCA", hash_generated_method = "BC18251CD7580FCA2AE30C6FE0852CCA")
    public AbstractInputMethodService ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.022 -0400", hash_original_method = "506AD561617E231B7466C0A7229483CE", hash_generated_method = "693C4887C1AA293F88A79ED43B45DF63")
    public KeyEvent.DispatcherState getKeyDispatcherState() {
KeyEvent.DispatcherState var020BED5B281694EFFFEB80FA04419B7B_1646955847 =         mDispatcherState;
        var020BED5B281694EFFFEB80FA04419B7B_1646955847.addTaint(taint);
        return var020BED5B281694EFFFEB80FA04419B7B_1646955847;
        // ---------- Original Method ----------
        //return mDispatcherState;
    }

    
    public abstract AbstractInputMethodImpl onCreateInputMethodInterface();

    
    public abstract AbstractInputMethodSessionImpl onCreateInputMethodSessionInterface();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.023 -0400", hash_original_method = "8E1D6FEDF1AFEDBCDCF9E63EFF23CA00", hash_generated_method = "039AF2C6A10B612A151CDC15787A6BA8")
    @Override
    protected void dump(FileDescriptor fd, PrintWriter fout, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(fout.getTaint());
        addTaint(fd.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.024 -0400", hash_original_method = "A37FBA98B4D1A366D99013E441DCBD11", hash_generated_method = "E048E7B2B3CBA73323AE3D4FAC3EBDF6")
    @Override
    final public IBinder onBind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
    if(mInputMethod == null)        
        {
            mInputMethod = onCreateInputMethodInterface();
        } //End block
IBinder var45779E42651DAA27DB670C6A138CC6D4_2119718954 =         new IInputMethodWrapper(this, mInputMethod);
        var45779E42651DAA27DB670C6A138CC6D4_2119718954.addTaint(taint);
        return var45779E42651DAA27DB670C6A138CC6D4_2119718954;
        // ---------- Original Method ----------
        //if (mInputMethod == null) {
            //mInputMethod = onCreateInputMethodInterface();
        //}
        //return new IInputMethodWrapper(this, mInputMethod);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.025 -0400", hash_original_method = "4A983FDB3FF481E2165B7D8D641CDD48", hash_generated_method = "4079F39CFD72679ADF19A10EEF7AFBFF")
    public boolean onTrackballEvent(MotionEvent event) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(event.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_941739498 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292766303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292766303;
        // ---------- Original Method ----------
        //return false;
    }

    
    public abstract class AbstractInputMethodImpl implements InputMethod {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.025 -0400", hash_original_method = "1FC06C592D7CEB663723BCE3B795B4B6", hash_generated_method = "1FC06C592D7CEB663723BCE3B795B4B6")
        public AbstractInputMethodImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.025 -0400", hash_original_method = "084F24BCF671A12F38D7783BEA9F6E08", hash_generated_method = "07C81BF4E30629B04C5F1CD8F3836B71")
        public void createSession(SessionCallback callback) {
            addTaint(callback.getTaint());
            callback.sessionCreated(onCreateInputMethodSessionInterface());
            // ---------- Original Method ----------
            //callback.sessionCreated(onCreateInputMethodSessionInterface());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.025 -0400", hash_original_method = "66C173BC408ADA3F5326213B71DD3797", hash_generated_method = "B49E7119905F074A51AF7F00DEDA0494")
        public void setSessionEnabled(InputMethodSession session, boolean enabled) {
            addTaint(enabled);
            addTaint(session.getTaint());
            ((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).setEnabled(enabled);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.026 -0400", hash_original_method = "79971C84DD1A2F851BEBA1D6EABE42F6", hash_generated_method = "7479F87AFCA01C6E1D2381D9D534649E")
        public void revokeSession(InputMethodSession session) {
            addTaint(session.getTaint());
            ((AbstractInputMethodSessionImpl)session).revokeSelf();
            // ---------- Original Method ----------
            //((AbstractInputMethodSessionImpl)session).revokeSelf();
        }

        
    }


    
    public abstract class AbstractInputMethodSessionImpl implements InputMethodSession {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.026 -0400", hash_original_field = "71AB1146E1CEE92AB74D832DEFFE135F", hash_generated_field = "35AD8B69CCAB99ED75EF706EA5E75D7E")

        boolean mEnabled = true;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.026 -0400", hash_original_field = "F1726E470958465011824E5F0EBDE84F", hash_generated_field = "5781D1C4F0DDC12DF2BB3E12406C7974")

        boolean mRevoked;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.026 -0400", hash_original_method = "732EE9B327CCA9D778A0A67756B490DA", hash_generated_method = "732EE9B327CCA9D778A0A67756B490DA")
        public AbstractInputMethodSessionImpl ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.026 -0400", hash_original_method = "B599CE9BD5CE6C0947F95A74F4693444", hash_generated_method = "02589FEEC7738CF04C4808BF1AE3C466")
        public boolean isEnabled() {
            boolean var6F84A7F10C955D3C78F44E5278F6195B_1885776883 = (mEnabled);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138476306 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_138476306;
            // ---------- Original Method ----------
            //return mEnabled;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.027 -0400", hash_original_method = "C0B4C5A0A5D7F00D5E6612F5DDAFF7B5", hash_generated_method = "73E99AD0C554A6DCD96D27AEF91128B0")
        public boolean isRevoked() {
            boolean varF1726E470958465011824E5F0EBDE84F_1691691192 = (mRevoked);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_626048362 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_626048362;
            // ---------- Original Method ----------
            //return mRevoked;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.027 -0400", hash_original_method = "BA8B8E3B4141C528807EA03970F3ED77", hash_generated_method = "D04D9CD4679D7D7E2C9DAE267ACCB74E")
        public void setEnabled(boolean enabled) {
    if(!mRevoked)            
            {
                mEnabled = enabled;
            } //End block
            // ---------- Original Method ----------
            //if (!mRevoked) {
                //mEnabled = enabled;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.028 -0400", hash_original_method = "6150597809F85496BEE526162ACEB60F", hash_generated_method = "E60B36F04B14FB96FAC9E90F23CA5FB2")
        public void revokeSelf() {
            mRevoked = true;
            mEnabled = false;
            // ---------- Original Method ----------
            //mRevoked = true;
            //mEnabled = false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.028 -0400", hash_original_method = "352A951CCD835CDBB0D749381932ADC2", hash_generated_method = "01BD208C14DF5DA2CB65D3D01FFE5C47")
        public void dispatchKeyEvent(int seq, KeyEvent event, EventCallback callback) {
            addTaint(callback.getTaint());
            addTaint(event.getTaint());
            addTaint(seq);
            boolean handled = event.dispatch(AbstractInputMethodService.this,
                    mDispatcherState, this);
    if(callback != null)            
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:22.029 -0400", hash_original_method = "D1FB978C0FC3E262298A1F84CE672B17", hash_generated_method = "0CB3207D059412BDC8273C31264D6C98")
        public void dispatchTrackballEvent(int seq, MotionEvent event, EventCallback callback) {
            addTaint(callback.getTaint());
            addTaint(event.getTaint());
            addTaint(seq);
            boolean handled = onTrackballEvent(event);
    if(callback != null)            
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

