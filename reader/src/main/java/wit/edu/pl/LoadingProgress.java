package wit.edu.pl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadingProgress {
    static public Object loadingProgress() {
        try {
            ObjectInputStream is =new ObjectInputStream(new FileInputStream(PathTorDir.getPathToResourcesFile("reader","save.ser")));
            return is.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
