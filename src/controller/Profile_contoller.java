package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Profile_contoller implements Initializable{
	
	@FXML private ImageView profile_set_label;
	@FXML private ImageView profile_exit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		profile_set_label.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY) {
					try {
						Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/Profile_edit.fxml"));
						Scene scene = new Scene(signup);
						Stage primaryStage = (Stage) profile_set_label.getScene().getWindow();
						primaryStage.setTitle("Sign up");
						primaryStage.setScene(scene);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		});
		profile_exit.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY) {
					try {
						Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/Friends.fxml"));
						Scene scene = new Scene(signup);
						Stage primaryStage = (Stage) profile_exit.getScene().getWindow();
						primaryStage.setTitle("Sign up");
						primaryStage.setScene(scene);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		});
		
		
	}
}
