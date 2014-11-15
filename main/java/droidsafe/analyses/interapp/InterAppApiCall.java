package droidsafe.analyses.interapp;

import droidsafe.android.system.AndroidComponents;

public enum InterAppApiCall {
    START_ACTIVITY, START_SERVICE, SEND_BROADCAST;
    
    public AndroidComponents getTargetComponent() {
        switch (this) {
            case START_SERVICE: return AndroidComponents.SERVICE;
            case START_ACTIVITY: return AndroidComponents.ACTIVITY;
            case SEND_BROADCAST: return AndroidComponents.BROADCAST_RECEIVER;
            default: return AndroidComponents.ACTIVITY;
        }
    }
}
