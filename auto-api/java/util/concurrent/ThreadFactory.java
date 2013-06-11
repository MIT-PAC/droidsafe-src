package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface ThreadFactory {

    
    Thread newThread(Runnable r);
}

