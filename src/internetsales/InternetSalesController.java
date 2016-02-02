/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetsales;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Lenovo
 */
public class InternetSalesController implements Initializable {
    
    private final ContractModel contractModel = new ContractModel();
    private ObservableList<InternetSales.ContractListEntry> dataSet = null;

    @FXML
    private TextField lastNameInputField;
    
    @FXML
    private TextField firstNameInputField;
    
    @FXML
    private TextArea addressInputField;
    
    @FXML
    private ChoiceBox internetSpeedChoiceBox;
    
    @FXML
    private ChoiceBox dataTrafficChoiceBox;
    
    @FXML
    private ChoiceBox contractLengthChoiceBox;
    
    @FXML
    private TableView contractsTableView;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<InternetSales.ContractListEntry> data = new ArrayList<>();
        dataSet = FXCollections.observableList(data);
        
        internetSpeedChoiceBox.setItems(FXCollections.observableArrayList("2", "5", "10", "20", "50", "100"));
        dataTrafficChoiceBox.setItems(FXCollections.observableArrayList("1", "5", "10", "100", "Unlimited"));
        contractLengthChoiceBox.setItems(FXCollections.observableArrayList("1", "2"));
        
        TableColumn IDTableColumn = new TableColumn("ID");
        TableColumn firstNameTableColumn = new TableColumn("First Name");
        TableColumn lastNameTableColumn = new TableColumn("Last Name");
        TableColumn addressTableColumn = new TableColumn("Address");
        TableColumn internetSpeedTableColumn = new TableColumn("Speed");
        TableColumn trafficLimitTableColumn = new TableColumn("Traffic");
        TableColumn contractLengthTableColumn = new TableColumn("Contract Length");

        contractsTableView.getColumns().clear();
        contractsTableView.getColumns().addAll(IDTableColumn, firstNameTableColumn, lastNameTableColumn, addressTableColumn, internetSpeedTableColumn, trafficLimitTableColumn, contractLengthTableColumn);
        contractsTableView.getSelectionModel().getSelectedItems().addListener(
                new ListChangeListener<InternetSales.ContractListEntry>()
                {
                    @Override
                    public void onChanged(Change <? extends InternetSales.ContractListEntry> change)
                    {
                        if (change.getList().size() > 0)
                        {
                            InternetSales.ContractListEntry selection = change.getList().get(0);
                            firstNameInputField.setText(selection.getFirstName());
                            lastNameInputField.setText(selection.getLastName());
                            addressInputField.setText(selection.getAddress());
                            internetSpeedChoiceBox.setValue(selection.getInternetSpeed());
                            dataTrafficChoiceBox.setValue(selection.getTrafficLimit());
                            contractLengthChoiceBox.setValue(selection.getContractLength());
                        }
                    }
                }
        );
        
        IDTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("id"));
        firstNameTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("firstName"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("lastName"));
        addressTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("address"));
        internetSpeedTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("internetSpeed"));
        trafficLimitTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("trafficLimit"));
        contractLengthTableColumn.setCellValueFactory(new PropertyValueFactory<Contract, String>("contractLenght"));
        
        refreshGrid();
    }
    
    @FXML
    public void addRow()
    {
        Contract temp = new Contract(
                firstNameInputField.getText(),
                lastNameInputField.getText(),
                addressInputField.getText(),
                internetSpeedChoiceBox.getValue().toString(),
                dataTrafficChoiceBox.getValue().toString(),
                contractLengthChoiceBox.getValue().toString(),
                null
            );
        contractModel.create(temp);
        
        refreshGrid();
    }
    
    @FXML
    public void delRow()
    {
        if(!contractsTableView.getSelectionModel().isEmpty())
        {
           InternetSales.ContractListEntry selection = (InternetSales.ContractListEntry)contractsTableView.getSelectionModel().getSelectedItem();
           contractModel.delete(contractModel.find(selection.getId()));
        }
        
        refreshGrid();
    }
    
    @FXML
    public void updateRow()
    {
        InternetSales.ContractListEntry selection = (InternetSales.ContractListEntry)contractsTableView.getSelectionModel().getSelectedItem();
        
        Contract contract = contractModel.find(selection.getId());
        contract.setFirstName(firstNameInputField.getText());
        contract.setLastName(lastNameInputField.getText());
        contract.setAddress(addressInputField.getText());
        contract.setInternetSpeed(internetSpeedChoiceBox.getValue().toString());
        contract.setTrafficLimit(dataTrafficChoiceBox.getValue().toString());
        contract.setContractLenght(contractLengthChoiceBox.getValue().toString());
        
        refreshGrid();
    }
    
    private void refreshGrid()
    {
        dataSet.clear();
        
        List<Contract> dbdata = contractModel.findAll();
        
        for(Contract contract: dbdata)
        {
            try{
                InternetSales.ContractListEntry temp = new InternetSales.ContractListEntry(contract.getId(), contract.getFirstName(), contract.getLastName(), contract.getAddress(), contract.getInternetSpeed(), contract.getTrafficLimit(), contract.getContractLenght());
                dataSet.add(temp);
            }
            catch (NullPointerException ex)
            {
                System.out.println("null on Contract");
            }
        }
        
        contractsTableView.setItems(dataSet);
    }
}
