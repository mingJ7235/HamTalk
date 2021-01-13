package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.UserDTO;

public class Profile_friends_contoller implements Initializable{
	
	@FXML private Label profile_friends_chat_label;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		profile_friends_chat_label.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY) {
					try {
						Parent signup=FXMLLoader.load(getClass().getClassLoader().getResource("view/signup.fxml"));
						Scene scene = new Scene(signup);
						Stage primaryStage = (Stage) profile_friends_chat_label.getScene().getWindow();
						primaryStage.setTitle("Sign up");
						primaryStage.setScene(scene);
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
		});
		
		
	}
	
	
	// 말풍선 클릭시
	public void handletoChatClick (MouseEvent event, UserDTO friend) {
		try {
			//접속하는 채팅방 친구 입력
			UserDTO.withFriend = friend;

			UserDAO dao = new UserDAO();
			int room_num = dao.roomCheck(UserDTO.nowUser, UserDTO.withFriend);
			
			Chat_w_01_controller.room_num = room_num;
			
			Parent login = FXMLLoader.load(getClass().getClassLoader().getResource("view/Chat_w_01.fxml"));
			Scene scene = new Scene(login);
			Stage primaryStage = (Stage) profile_friends_chat_label.getScene().getWindow();
			primaryStage.setTitle("Chatting");
			primaryStage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
