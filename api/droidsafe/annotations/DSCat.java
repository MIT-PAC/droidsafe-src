package droidsafe.annotations;

public enum DSCat {
    //Safe Categories */
    ANDROID_ANIMATION,
    OS_GENERAL,
    DATA_STRUCTURE,  
    FRAMEWORK_FINAL,  //cannot override
    SAFE_LIST,
    GUI,    
    GRAPHICS,
    NO_ACTION,
    DATA_GENERAL,
    SAFE_OTHERS,
    ANDROID_CALLBACK,
    
    //Ban Categories
    DALVIK,
    PRIVATE_METHOD,
    REFLECTION,
    CLASS_LOADER,
    SECURITY_VIOLATION,
    
    //Spec Categories
    ABSTRACT_METHOD,
    ANDROID_APPLICATION,
    ANDROID_INTERNAL,
    ANDROID_INSTRUMENTATION,
    ANDROID_LOW_LEVEL,
    ANDROID_MANAGER,
    ANDROID_LOADER,
    AUDIO_CALL,
    APP_RESOURCE,
    CALLBACK_INVOKE,
    
    CONTENT,
    TO_MODEL, //once the method is modeled, it will be safe

    DATABASE,  //database changing
    DEFAULT_MODIFIER,  
    DEVICE,    
    
    MONITORING,

    GPS,
    INTERNET,
    INTENT_EXCHANGE,
    INTERGUI_ACTION,
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
    RESOURCE,
    SENSOR,
    SMS,
    SHARING,
    STORAGE,
    SYSTEM_SETTING,    
    SYSTEM_SERVICE,
    TELEPHONY,
    URI_EXCHANGE,
    WIFI,
    
    SPEC_OTHERS,
    
    //Default value, not SAFE, BAN nor SPEC
    UNSPECIFIED;
}
