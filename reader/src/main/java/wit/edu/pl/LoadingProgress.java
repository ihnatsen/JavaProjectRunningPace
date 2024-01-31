package wit.edu.pl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LoadingProgress {
    static public Object loadingProgress() throws IOException {
        try {
            ObjectInputStream is =new ObjectInputStream(new FileInputStream(PathToDir.getPathToResourcesFile("reader","save.ser")));
            return is.readObject();
        }  catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
