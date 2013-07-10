package android.view.inputmethod;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.inputmethodservice.InputMethodService;
import android.os.IBinder;
import android.os.ResultReceiver;

public interface InputMethod {
    
    @SdkConstant(SdkConstantType.SERVICE_ACTION)
    public static final String SERVICE_INTERFACE = "android.view.InputMethod";
    
    
    public static final String SERVICE_META_DATA = "android.view.im";
    
    public interface SessionCallback {
        public void sessionCreated(InputMethodSession session);
    }
    
    
    public void attachToken(IBinder token);
    
    
    public void bindInput(InputBinding binding);

    
    public void unbindInput();

    
    public void startInput(InputConnection inputConnection, EditorInfo info);

    
    public void restartInput(InputConnection inputConnection, EditorInfo attribute);

    
    public void createSession(SessionCallback callback);
    
    
    public void setSessionEnabled(InputMethodSession session, boolean enabled);
    
    
    public void revokeSession(InputMethodSession session);
    
    
    public static final int SHOW_EXPLICIT = 0x00001;
    
    
    public static final int SHOW_FORCED = 0x00002;
    
    
    public void showSoftInput(int flags, ResultReceiver resultReceiver);
    
    
    public void hideSoftInput(int flags, ResultReceiver resultReceiver);

    
    public void changeInputMethodSubtype(InputMethodSubtype subtype);
}
