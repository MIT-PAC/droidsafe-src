package droidsafe.annotations;

public enum DSCat {
    //Safe Categories */
    ANDROID_ANIMATION,
    ANDROID_CALLBACK,   //methods like onClick 
    OS_GENERAL,
    DATA_STRUCTURE,  
    MEM_BUFFER,
    SAFE_LIST,
    GUI,    
    GRAPHICS,
    NO_ACTION,
    DATA_GENERAL,
    SAFE_OTHERS,
    UTIL_FUNCTION,
    
    //Ban Categories
    DALVIK,
    PRIVATE_METHOD,
    REFLECTION,
    CLASS_LOADER,
    SECURITY_VIOLATION,
    BAN_OTHERS,
    
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
    
    BACKUP_SUBSYSTEM,
    BLUETOOTH,
    NFC,
    CONTACT,
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
    IPC,
    SERVICE,
    JAVA_SECURITY,
    LOGGING,
    LOCATION,    
    MEDIA_RECORDER,
    NETWORK_STATS,
    NETWORK,
    NETWORKING,
    
    OS_LOW_LEVEL,    
    PHONE_CALL,
    RESOURCE,
    RTP_CALL,
    SENSOR,
    SMS,
    SHARING,
    STORAGE,
    SYSTEM_SETTING,    
    SYSTEM_SERVICE,
    STORAGE_ACCESS,
    SYSTEM,
    SYSTEM_PREFERENCES,
    SYSTEM_SETTINGS,
    SECURITY,
    SERIALIZATION,
    TELEPHONY,
    URI_EXCHANGE,
    WIFI,
    
    SPEC_OTHERS,
    
    //Default value, not SAFE, BAN nor SPEC
    UNSPECIFIED;
}
