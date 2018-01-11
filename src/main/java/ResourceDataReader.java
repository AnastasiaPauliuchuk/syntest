import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author Anastasia Pauliuchuk
 *         created:  1/11/2018.
 */
public abstract class ResourceDataReader {

    protected InputStream inputStream ;
    protected String resourceFilename;

    public ResourceDataReader()
    {

    }

    public boolean init() {

        InputStream is = null;
        Class cls;
        cls=ResourceDataReader.class;
        ClassLoader classLoader = cls.getClassLoader();
        try {

            is =classLoader.getResourceAsStream(this.resourceFilename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.inputStream = is;
        if(is==null) return false;
        return true;
    }

    public abstract Map<String, String> readData(ArrayList<String> keys) throws IOException;
}
