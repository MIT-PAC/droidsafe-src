package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.IBinder;

public interface ServiceConnection {
    
    public void onServiceConnected(ComponentName name, IBinder service);

    
    public void onServiceDisconnected(ComponentName name);
}
