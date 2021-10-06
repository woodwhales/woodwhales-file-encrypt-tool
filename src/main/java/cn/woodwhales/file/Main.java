package cn.woodwhales.file;

import cn.woodwhales.file.view.MainView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author woodwhales on 2021-10-06 23:06
 */
@SpringBootApplication
public class Main extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(Main.class, MainView.class, args);
    }

}
