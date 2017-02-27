import com.sleepycat.je.Environment;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.DatabaseConfig;

import java.io.File;


/**
 * Created by RPivanov on 27.02.2017.
 */
public class Berkeley {

    private Environment env = null;
    private Database db = null;
    private File fil = null;

    public void open() {
        try {
            EnvironmentConfig conf = new EnvironmentConfig();
            conf.setAllowCreate(true);

            fil = new File("/export/env");
            if (fil.exists()){
                fil.mkdir();
            }

            env = new Environment(fil, conf);
        }
        catch (DatabaseException ex) {
            System.out.println(ex.getMessage());
        }

        DatabaseConfig conf = new DatabaseConfig();
        conf.setAllowCreate(true);
        db = env.openDatabase(null,"sample",conf);

        //

        //
        db.sync();
    }

    public void close() {
        try {
            if (db != null) {
                db.close();
            }
            if (env != null) {
                env.close();
            }
        } catch (DatabaseException dbe) {
        // Exception handling goes here
            // git test
        }

    }


}
