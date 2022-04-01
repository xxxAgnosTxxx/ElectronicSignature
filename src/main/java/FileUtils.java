import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class FileUtils {
    private FileUtils(){}

    public static File getFile(String path){
        return new File(path);
    }

    public static byte[] getBytesFromFile(File file){
        String s = "";
        try(FileReader reader = new FileReader(file))
        {
            int c;
            while((c=reader.read())!=-1){
                s+=(char) c;
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return s.getBytes(StandardCharsets.UTF_8);
    }

    public static void printBytesToFile(byte[] b, File f){
        try(FileWriter writer = new FileWriter(f, false))
        {
            writer.write(Arrays.toString(b));
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
