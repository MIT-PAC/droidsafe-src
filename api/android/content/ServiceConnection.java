package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.IBinder;

public interface ServiceConnection {
    
    public void onServiceConnected(ComponentName name, IBinder service);

    
    public void onServiceDisconnected(ComponentName name);
}
