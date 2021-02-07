package util;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Notification {
    public static void conformation(String text){

        Notifications notif1 = Notifications.create();
        notif1.title("Conformation");
        notif1.text(text);
        notif1.hideAfter(Duration.seconds(3));
        notif1.position(Pos.TOP_RIGHT);
        notif1.showConfirm();
    }
    public static void erro(String text){
        Notifications notif1 = Notifications.create();
        notif1.title("Erro");
        notif1.text(text);
        notif1.hideAfter(Duration.seconds(3));
        notif1.position(Pos.TOP_RIGHT);
        notif1.showError();
    }
    public static void warning(String text){
        Notifications notif1 = Notifications.create();
        notif1.title("Warning");
        notif1.text(text);
        notif1.hideAfter(Duration.seconds(3));
        notif1.position(Pos.TOP_RIGHT);
        notif1.showWarning();
    }

}
