package android.speech.tts;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public abstract class UtteranceProgressListener {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.348 -0400", hash_original_method = "5AB296C4CDF269F5BA8477476B807230", hash_generated_method = "5AB296C4CDF269F5BA8477476B807230")
        public UtteranceProgressListener ()
    {
    }


    public abstract void onStart(String utteranceId);

    
    public abstract void onDone(String utteranceId);

    
    public abstract void onError(String utteranceId);

    
        static UtteranceProgressListener from(
            final TextToSpeech.OnUtteranceCompletedListener listener) {
        return new UtteranceProgressListener() {
            @Override
            public synchronized void onDone(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }
            @Override
            public void onError(String utteranceId) {
                listener.onUtteranceCompleted(utteranceId);
            }
            @Override
            public void onStart(String utteranceId) {
            }
        };
    }

    
}

