package wit.edu.pl;

import java.io.*;

public class SaveProgress {

    public static void save(Object goal){
        try(FileOutputStream fileOutputStream = new FileOutputStream(PathToDir.getPathToResourcesFile("reader","save.ser"));
            ObjectOutputStream os = new ObjectOutputStream(fileOutputStream)) {
            os.writeObject(goal);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save(Integer flag){

        File file = new File(PathToDir.getPathToResourcesFile("reader","flag.txt"));
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            writer.println(flag);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
        }writer.close();


    }


}
