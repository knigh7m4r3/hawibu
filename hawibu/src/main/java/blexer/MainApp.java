package blexer;

import blexer.controller.MainController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("thePersistenceUnit");
        final EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        MainController controller = new MainController(stage, em);
        loader.setController(controller);
        Parent root = loader.load();



        Scene scene = new Scene(root);
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                em.getTransaction().commit();
            }
        });

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Application.launch(args);
    }

}
