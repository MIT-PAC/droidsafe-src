package android.speech.tts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

abstract class AbstractSynthesisCallback implements SynthesisCallback {
    
    abstract boolean isDone();

    
    abstract void stop();

    
}


