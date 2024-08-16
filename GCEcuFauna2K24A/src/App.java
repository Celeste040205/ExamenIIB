import DataAccess.DAO.GCDAOHormiga;
import DataAccess.DTO.GCDTOHormiga;
import Interfaz.Form.GCMainForm;
//import Interfaz.Form.cambiodepanel;
public class App {

    public static void main(String[] args) throws Exception {

        try {
            GCDAOHormiga uDao = new GCDAOHormiga();
            for (GCDTOHormiga s: uDao.readAll())
                System.out.println(s.toString());
        } catch (Exception e) {
                System.out.println(e.toString());
        }

        //cambiodepanel.show();
        //GCMainForm GCfrmMain = new GCMainForm("GCEcuFauna");
        //GCfrmMain.setVisible(true);
    }


    }
 
