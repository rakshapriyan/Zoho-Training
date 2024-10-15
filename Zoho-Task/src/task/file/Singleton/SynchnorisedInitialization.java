	//$Id$
package task.file.Singleton;

public class SynchnorisedInitialization {
	private static SynchnorisedInitialization instance;

    private SynchnorisedInitialization() {
    }

    public static synchronized SynchnorisedInitialization getInstance() {
        if (instance == null) {
            instance = new SynchnorisedInitialization();
        }
        return instance;
    }
    
    
}
