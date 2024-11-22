package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {

    private ArrayList<Person> personList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        Label bannerLabel = new Label("BANNER");
        bannerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: navy ;");
        HBox bannerBox = new HBox(bannerLabel);
        bannerBox.setAlignment(Pos.CENTER);
        bannerBox.setPadding(new Insets(30));
        bannerBox.setStyle("-fx-background-color: lightblue;");


        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC:");
        TextField cnicField = new TextField();

        Label dateLabel = new Label("Date (Picker):");
        DatePicker datePicker = new DatePicker();

        Label genderLabel = new Label("Gender:");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();

        Label imageLabel = new Label("Image:");
        Button imageButton = new Button("Upload Image");


        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String date = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
            String gender = genderComboBox.getValue();
            String city = cityField.getText();

            Person person = new Person(name, fatherName, cnic, date, gender, city);
            personList.add(person);

            nameField.clear();
            fatherNameField.clear();
            cnicField.clear();
            datePicker.setValue(null);
            genderComboBox.setValue(null);
            cityField.clear();

            System.out.println("Person added: " + person);
        });

        GridPane formLayout = new GridPane();
        formLayout.setHgap(10);
        formLayout.setVgap(10);
        formLayout.setPadding(new Insets(10));

        formLayout.add(nameLabel, 0, 0);
        formLayout.add(nameField, 1, 0);

        formLayout.add(fatherNameLabel, 0, 1);
        formLayout.add(fatherNameField, 1, 1);

        formLayout.add(cnicLabel, 0, 2);
        formLayout.add(cnicField, 1, 2);

        formLayout.add(dateLabel, 0, 3);
        formLayout.add(datePicker, 1, 3);

        formLayout.add(genderLabel, 0, 4);
        formLayout.add(genderComboBox, 1, 4);

        formLayout.add(cityLabel, 0, 5);
        formLayout.add(cityField, 1, 5);

        formLayout.add(imageLabel, 0, 6);
        formLayout.add(imageButton, 1, 6);

        formLayout.add(saveButton, 1, 7);

        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(bannerBox, formLayout);
        mainLayout.setPadding(new Insets(10));

        Scene scene = new Scene(mainLayout, 500, 600);
        primaryStage.setTitle("Person Form with Banner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Person {
        private String name;
        private String fatherName;
        private String cnic;
        private String date;
        private String gender;
        private String city;

        public Person(String name, String fatherName, String cnic, String date, String gender, String city) {
            this.name = name;
            this.fatherName = fatherName;
            this.cnic = cnic;
            this.date = date;
            this.gender = gender;
            this.city = city;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + '\'' +
                    ", fatherName='" + fatherName + '\'' +
                    ", cnic='" + cnic + '\'' +
                    ", date='" + date + '\'' +
                    ", gender='" + gender + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
