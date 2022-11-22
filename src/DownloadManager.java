import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;

public class DownloadManager {
    public static void main(String[] args) throws IOException {
        new DownloadManager().download(
                "https://dls.loudmusic.ir/Music/1401/01/Baraye%20-Shervin%20Hajipour%20[loudmusic.ir]-320.mp3?_gl=1*lhra1x*_ga*MjA1NzU0NDcyMC4xNjY5MDU1MjA3*_ga_Q9P8G2P6L4*MTY2OTA1NTIwNy4xLjEuMTY2OTA1NjA5NS4wLjAuMA.."
                , "C:\\Users\\elahe\\Downloads\\baraye\\");
    }

    public void download(String downloadUrl, String filePath) throws IOException {
        var url = new URL(downloadUrl);
        var path = new File(filePath);
        if (path.exists() || path.isDirectory()){
                throw new IllegalStateException("The file or directory is already exists in path %s".formatted(filePath));
        }

         var readableByteChannel = Channels.newChannel(url.openStream());
            var fileOutputStream = new FileOutputStream(filePath);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
    }
}