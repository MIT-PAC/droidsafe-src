package android.speech;

// Droidsafe Imports
import android.os.Bundle;

public interface RecognitionListener {
    
    void onReadyForSpeech(Bundle params);

    
    void onBeginningOfSpeech();

    
    void onRmsChanged(float rmsdB);

    
    void onBufferReceived(byte[] buffer);

    
    void onEndOfSpeech();

    
    void onError(int error);

    
    void onResults(Bundle results);

    
    void onPartialResults(Bundle partialResults);

    
    void onEvent(int eventType, Bundle params);
}
