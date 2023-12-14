import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compress {
    Compress(){}
    public static void method(File file) throws IOException {
//        get parent directory of file
        String fileDirectory = file.getParent();

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/compressed.gz");
        GZIPOutputStream gzip = new GZIPOutputStream(fos);

//        create buffer array to store bytes from fis
        byte[] buffer = new byte[1024];
        int len;

//        compress file using gzip writer
        while((len=fis.read(buffer))!=-1){
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }

}
