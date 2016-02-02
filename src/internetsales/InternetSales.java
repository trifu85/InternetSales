/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsales;

import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author Acer
 */
public class InternetSales extends Application {
    
    public InternetSales() {

    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("InternetSales.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("internetsales/style.css");
        stage.setScene(scene);
      
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static class ContractListEntry {
        private final SimpleIntegerProperty id;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty address;
        private final SimpleStringProperty internetSpeed;
        private final SimpleStringProperty trafficLimit;
        private final SimpleStringProperty contractLength;

        public ContractListEntry(int id, String firstName,
                String lastName,
                String address,
                String internetSpeed,
                String trafficLimit,
                String contractLength
        )
        {
            this.id = new SimpleIntegerProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
            this.lastName = new SimpleStringProperty(lastName);
            this.address = new SimpleStringProperty(address);
            this.internetSpeed = new SimpleStringProperty(internetSpeed);
            this.trafficLimit = new SimpleStringProperty(trafficLimit);
            this.contractLength = new SimpleStringProperty(contractLength);
        }

        public int getId() {
            return id.get();
        }

        public String getFirstName() {
            return firstName.get();
        }

        public void setFirstName(String firstName)
        {
            this.lastName.set(firstName);
        }

        public String getLastName() {
            return lastName.get();
        }

        public void setLastName(String lastName)
        {
            this.lastName.set(lastName);
        }

        public String getAddress() {
            return address.get();
        }

        public String getInternetSpeed() {
            return internetSpeed.get();
        }

        public String getTrafficLimit() {
            return trafficLimit.get();
        }

        public String getContractLength() {
            return contractLength.get();
        }
    }
   
}
