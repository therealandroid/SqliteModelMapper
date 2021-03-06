package br.com.diogojayme.databasemanager.sample;

import android.app.Application;

import br.com.diogojayme.sqlitemodelmapper.database.SchemeConfiguration;
import diogo.tablegenerator.processor.TableGenerator;
import querybuilder.configurations.Configuration;
import querybuilder.configurations.Database;


/**
 * Created by diogojayme on 9/26/16.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Configuration.setDatabase(Database.SQLITE);

        SchemeConfiguration.initialize(new String[]{
                TableGenerator.from(University.class),
                TableGenerator.from(Course.class),
                TableGenerator.from(User.class)
        }, new String[]{
                "DROP TABLE IF EXISTS " + TableGenerator.getTableName(University.class),
                "DROP TABLE IF EXISTS "+ TableGenerator.getTableName(Course.class),
                "DROP TABLE IF EXISTS "+ TableGenerator.getTableName(User.class),
        }, "sample.db", 1);
    }
}
