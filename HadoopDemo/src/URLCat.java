import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * Created by Junk Chen on 2018/12/04.
 */
public class URLCat {
    public static void main(String[] args) throws IOException {
        String url = args[0];
//        String url = "hdfs://localhost:9000/demo/FlowLayout.java";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(url), conf);
        InputStream in = null;
        try {
            in = fs.open(new Path(url));
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
