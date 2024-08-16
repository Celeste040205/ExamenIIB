import Interfaz.Form.GCMainForm;
import Interfaz.Form.GCSplash;
//import Interfaz.Form.cambiodepanel;
public class App {

    public static void main(String[] args) throws Exception {
        GCSplash.show();
        GCMainForm GCfrmMain = new GCMainForm("GCEcuFauna");
        GCfrmMain.setVisible(true);
    }


    }
 
