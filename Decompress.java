import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Decompress{
    Decompress(){};
public static void method(File file) throws IOException {
//    get parent directory of file
    String fileDirectory = file.getParent();

    FileInputStream fis = new FileInputStream(file);
    GZIPInputStream gzip = new GZIPInputStream(fis);
    FileOutputStream fos = new FileOutputStream(fileDirectory + ("/DecompressedFile"));

//   create buffer array to store bytes from fis
    byte[] buffer = new byte[1024];
    int len;

//    decompress file using gzip reader
    while ((len=gzip.read(buffer))!=-1){
        fos.write(buffer,0,len);
    }
    gzip.close();
    fis.close();
    fos.close();

}
}
