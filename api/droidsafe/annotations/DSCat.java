package droidsafe.annotations;

public enum DSCat {
    //Safe Categories */
    ANDROID_ANIMATION,
    ANDROID_CALLBACK,   //methods like onClick 
    OS_GENERAL,
    DATA_STRUCTURE,  
    MEM_BUFFER,
    SAFE_LIST,
    SAFE_OTHERS,
    UTIL_FUNCTION,
    
    //Ban Categories
    DALVIK,
    PRIVATE_METHOD,
    REFLECTION,
    BAN_OTHERS,
    
    //Spec Categories
    ABSTRACT_METHOD,
    ANDROID_APPLICATION,
    ANDROID_INTERNAL,
    ANDROID_INSTRUMENTATION,
    ANDROID_MANAGER,
    AUDIO_CALL,
    ANDROID_LOADER,
    APP_RESOURCE,
    BACKUP_SUBSYSTEM,
    BLUETOOTH,
    NFC,
    CONTACT,
    CALLBACK_INVOKE,  //method to trigger callback (user requests)
    CONTENT,
    TO_MODEL, //once the method is modeled, it will be safe

    DATABASE,  //database changing
    DEFAULT_MODIFIER,  
    DEVICE,    

    GPS,
    GRAPHICS,
    GUI,    
    INTERNET,
    INTENT_EXCHANGE,
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
