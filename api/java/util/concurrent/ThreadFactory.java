package java.util.concurrent;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface ThreadFactory {

    
    Thread newThread(Runnable r);
}
