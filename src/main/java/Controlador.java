
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Controlador implements Initializable {

		
		
		@FXML
		private HBox vista;
		
		@FXML
		private TextField asunto;
		
		@FXML
		private TextField servidor;
		
		@FXML
		private TextField puerto;
		
		@FXML
		private TextField email1;
		
		@FXML
		private TextField email2;
		
		@FXML
		private TextField destino;
		
		@FXML
		private TextArea mensaje;
		
		@FXML
		private Button vaciar;
		
		@FXML
		private Button enviar;
		
		@FXML
		private Button cerrar;
		
		@FXML
		private CheckBox check;
		
		private Modelo modelo = new Modelo ();;
	
		
		
		public HBox getView() {
			return vista;
		}
		
		
		public Controlador() throws IOException {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista.fxml"));
		   loader.setController(this);
			
			loader.load();
			
			}


		public void initialize(URL location, ResourceBundle resources) {
			
			enviar.setOnAction(e -> Fenviar(e));
			cerrar.setOnAction(e -> Fcerrar(e));
			vaciar.setOnAction(e -> Fvaciar(e));
			
		}


		private void Fvaciar(ActionEvent e) {
		
	
	servidor.setText("");	
	destino.setText("");	
	asunto.setText("");	
	email1.setText("");
	email2.setText("");	
	mensaje.setText("");	
	puerto.setText("");	
	
		}


		private void Fcerrar(ActionEvent e) {
			 Node  source = (Node)  e.getSource(); 
			    Stage stage  = (Stage) source.getScene().getWindow();
			    stage.close();
			
		}


		private void Fenviar(ActionEvent e) {
			boolean mandado =true;
			
			modelo.setServidor(servidor.getText());
			modelo.setDestino(destino.getText());
			modelo.setAsunto(asunto.getText());
			modelo.setEmail1(email1.getText());
			modelo.setEmail2(email2.getText());
			modelo.setMensaje(mensaje.getText());
			modelo.setPuerto(puerto.getText());
			if(check.isSelected()){
				modelo.setCheck(true);
				} else {
					modelo.setCheck(false);
				}
			
			
			
			Email email = new SimpleEmail();
			email.setHostName(modelo.getServidor());
			email.setSmtpPort(Integer.parseInt(modelo.getPuerto()));
			email.setAuthenticator(new DefaultAuthenticator(modelo.getEmail1(), modelo.getEmail2()));
			email.setSSLOnConnect(modelo.getCheck());
			try {
				email.setFrom(modelo.getEmail1());
				email.setSubject(modelo.getAsunto());
				email.setMsg(modelo.getMensaje());
				email.addTo(modelo.getDestino());
				email.send();
				
			} catch (EmailException err) {
				mandado=false;
				err.printStackTrace();
			}
			if (mandado==true) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Mandar Correo");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText(modelo.getAsunto() +"  "+modelo.getMensaje());
				alert.showAndWait();
				
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Mandar Correo");
				alert.setHeaderText("Acceso permitido");
				alert.setContentText("ERRORR");
				alert.showAndWait();
			}
		}
		
}
