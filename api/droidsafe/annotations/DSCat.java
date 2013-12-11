package droidsafe.annotations;

public enum DSCat {
    //Safe Categories */
    ANDROID_ANIMATION,
    OS_GENERAL,
    CONTAINER_CLASS,
    DATA_STRUCTURE,  
    FRAMEWORK_FINAL,  //cannot override
    SAFE_LIST,
    SAFE_OTHERS,
    
    //Ban Categories
    DALVIK,
    PRIVATE_METHOD,
    REFLECTION,
    
    //Spec Categories
    ANDROID_APPLICATION,
    ANDROID_INTERNAL,
    ANDROID_INSTRUMENTATION,
    ANDROID_MANAGER,
    CONTENT,
    TO_MODEL, //once the method is modeled, it will be safe

    DEFAULT_MODIFIER,  
    DEVICE,

    GPS,
    GRAPHICS,
    GUI,    
    INTERNET,
    INTENT_EXCHANGE,
    IO,
    IO_ACTION_METHOD,
    JAVA_SECURITY,
    LOGGING,
    LOCATION,    
    MEDIA_RECORDER,
    NETWORK_STATS,
    NETWORKING,
    
    OS_LOW_LEVEL,    
    PHONE_CALL,
    SMS,
    SHARING,
    STORAGE,
    SYSTEM_SETTING,
    TELEPHONY,
    URI_EXCHANGE,
    WIFI,
    
    SPEC_OTHERS,
    
    //Default value, not SAFE, BAN nor SPEC
    UNSPECIFIED;
}
