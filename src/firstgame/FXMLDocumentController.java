
package firstgame;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FXMLDocumentController implements Initializable {
    //<editor-fold defaultstate="collapsed" desc="Class Variables">
    private int selNum1;
    private int genszam=getRandomNumber();
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="FXML items import">
    @FXML
    private Pane  allertpane;
    @FXML
    private Button button;
    @FXML        
    private Pane basePane;
    @FXML
    private Label allertlabel;
     @FXML
    private Button allert;
    @FXML
    private Label label1;
    @FXML
    private TextField input1;
//</editor-fold>
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //We are generating numbers
        calculate();
    }
    private void hiba(String hibaüzi){
        allertpane.setVisible(true);
        allertlabel.setText(hibaüzi);
        basePane.setDisable(false);
        basePane.setOpacity(0.3);
        
    }
    @FXML
    private void hibagomb(ActionEvent event) {
        allertpane.setVisible(false);
        allertlabel.setText("");
        basePane.setDisable(false);
        basePane.setOpacity(1);
        input1.setText("");
        
    }
    private void calculate(){
        
        try{
         selNum1 = Integer.parseInt(input1.getText());
            System.out.println("a beadott érték: "+selNum1);
        }catch(Exception e){
            hiba("Nem jó számot adtál meg!");
            return;
        }
       if(selNum1>genszam) {
           hiba("Adj meg kisebb értéket");
       } else if (selNum1<genszam) {
           hiba("Adj meg nagyobb értéket");
       }
       else {
            hiba("Kitaláltad, új játék kezdődött");
            genszam=getRandomNumber();
            System.out.println(genszam);
       }
    }
    
    private int getRandomNumber(){
      int random = (int) (Math.random() * 100) + 0; 
      return random;      
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      System.out.println("A generalt szam!"+genszam);  
    }    
    
}
