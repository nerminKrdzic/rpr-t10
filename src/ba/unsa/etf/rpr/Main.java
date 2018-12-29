package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {

    public static String ispisiGradove(){
        String ispis = new String("");
        ArrayList<Grad> gradovi = GeografijaDAO.getInstance().gradovi();
        for(Grad g: gradovi){
            ispis += g.toString();
        }
        return ispis;
    }

    public void stampajGradove(ActionEvent actionEvent) {
        try {
            new GradoviReport().showReport(GeografijaDAO.getInstance().getConnection());
        } catch (JRException e1) {
            e1.printStackTrace();
        }
    }


    public static void glavniGrad(){
        System.out.println("Unesite naziv drzave: ");
        Scanner scanner = new Scanner(System.in);
        GeografijaDAO dao = GeografijaDAO.getInstance();
        String naziv = scanner.nextLine().trim();
        Grad glavniGrad = dao.glavniGrad(naziv);
        if(glavniGrad == null) System.out.println("Nepostojeca drzava");
        else System.out.println("Glavni grad drzave " + naziv + " je " + glavniGrad.getNaziv());

    }

    public static void main(String[] args) {
        launch(args);
        /*Main main = new Main();
        main.stampajGradove(new ActionEvent());*/

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Geografija.fxml"));
        primaryStage.setTitle("Tutorijal 9");
        Scene scene = new Scene(root, 600, 360);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(600);
        primaryStage.setMaxWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxHeight(400);
        primaryStage.show();
    }
}
