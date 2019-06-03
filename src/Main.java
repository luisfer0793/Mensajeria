import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    // Metodo Main. Aquí inicia el progama
    public static void main(String[] args) {
        // El objetivo del metodo main es llamar al metodo launch que se hereda de la clase Application
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/scenes/contacts.fxml"));

        primaryStage.setTitle("Messenger");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }
}


