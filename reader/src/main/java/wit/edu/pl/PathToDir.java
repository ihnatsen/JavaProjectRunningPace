package wit.edu.pl;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathToDir {

    static String rootProject = System.getProperty("user.dir");
    static String separator = File.separator;
    static String nameApp = "RunningPace";

    static String nameConfog = "config.properties";
    
    public static String getPathToModuleFile(String module, String nameFile){
        Path pathModule = Paths.get(
                    rootProject  + separator +
                        nameApp      + separator +
                        module       + separator +
                        nameFile     + separator);


        return pathModule.toString();
    }
    public static String getPathToResourcesFile(String module, String nameFile){
        Path pathModule = Paths.get(
                rootProject     + separator +
                        nameApp     + separator +
                        module      + separator +
                        "src"       + separator +
                        "main"      + separator +
                        "resources" + separator +
                        nameFile    + separator );
        return pathModule.toString();
    }

    public static String getPathToGlobalConfig(){
        Path pathModule = Paths.get(
                rootProject     + separator +
                        nameApp     + separator +
                        nameConfog
                       );
        return pathModule.toString();
    }
    
}
