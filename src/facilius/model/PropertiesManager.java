package facilius.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Danilo Graciano
 */
public class PropertiesManager {

    private Properties props = null;
    private String path;

    public PropertiesManager(String path) throws IOException {
        this.path = path;
        File file = new File(this.getPath());
        this.props = new Properties();
        FileInputStream fis = null;
        fis = new FileInputStream(file);
        props.load(fis);
        fis.close();

    }

    public String getProperty(String key) {
        return props.getProperty(key);
    }

    public void setProperty(String key, String value) {
        props.setProperty(key, value);
    }

    public void write() throws Exception {
        File file = new File(this.getPath());
        FileOutputStream fos = null;
	fos = new FileOutputStream(file);
        props.store(fos, "Configurações no arquivo " + this.getPath());
	fos.close();
    }

    public String getPath() {
        return path;
    }

}
