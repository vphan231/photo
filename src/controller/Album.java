package controller;

import java.io.IOException;

import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Album {
	@FXML ListView<String> albumListView;
	@FXML Button logoutButton;
	
	public void start() {
		//System.out.println("Album");
		Login.user.albumList.add("album1");
		Login.user.albumList.add("album2");
		albumListView.setItems(	Login.user.albumList );
	}
	
	public void buttonPress( ActionEvent event ) throws IOException {
		Button b = (Button)event.getSource();
		if (b == logoutButton) {
			toLogin(event);
		}
	}
	
	public void toLogin( ActionEvent e )throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/loginView.fxml"));
		AnchorPane root = (AnchorPane)loader.load();
		//Parent abc = FXMLLoader.load( getClass().getResource("/view/albumView.fxml"));
		Login controller = loader.getController();
		controller.start();
		Scene scene = new Scene(root);
		Stage mainStage = (Stage)((Node) e.getSource()).getScene().getWindow();
		//window.setScene(scene);
		//window.show();
		mainStage.setScene(scene);
		mainStage.show();
		return;
	}
}
