package bsu.comp152;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class for creating a window (Stage)
 * in a different way from previously
 *
 * The new way is to create the view of the contents of the window
 * in FXML instead of in this Java class as we did before.
 *
 * The ML stands for markup language.  HTML is for web pages,
 * and FXML is for JavaFX.
 *
 * The approach we are about to use will allow us (the programmers)
 * to create the elements of the GUI by dragging and dropping
 * instead of writing FXML code directly. (The contents of
 * web pages can also be created by dragging and dropping instead
 * of writing code.)
 *
 * We will need to create an .fxml file as a resource in
 * the appropriate part of the project structure.
 *
 * To do so, first right click on resources in the project directory.
 * Add a new -> directory called bsu.
 * Right click on the new directory bsu (resources/bsu).
 * Add a new -> directory called comp152.
 * Right click on the new directory comp152 (resources/bsu/comp152).
 * Add a new -> FXML file.
 * Name it anything you like, such as Main.
 * Now you've created Main.fxml.
 * It is in the right place because the path
 * main/resources/bsu/comp152 for the FXML resource
 * mirrors the path main/java/bsu/comp152
 * for the Java classes
 * as IDEA expects/requires.
 *
 */
public class Main extends Application {

    Label myLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        /* We start by declaring and initializing a root node
         * for a Scene graph.
         */
        Parent root = null;
        /*
         * Think of it as an object to
         * hold all the different parts of a Scene.
         * Parent is the superclass of all the components in a Scene.
         * It is the superclass of all the nodes in a Scene graph.
         */

        // Next we want to load the FXML file from location loc.

        /* We connect the location loc to the file Main.fxml
         * using a "factory constructor" rather than the
         * keyword new:
         */
        var loc = getClass().getResource("Main.fxml");
        try {
            /* Overwrite the value of the reference variable
             * root with the value returned
             * by the load method when the location loc is passed as
             * a parameter.
             */
            root = FXMLLoader.load(loc);
            /* Now we call a Scene constructor that takes root
             * as a parameter, so that we can create a Scene
             * consisting of a beautiful display that we create
             * in Main.fxml.
             */
            Scene windowContents = new Scene(root);
            primaryStage.setScene(windowContents);
            primaryStage.setTitle("Kilometer Converter");
            primaryStage.show();
        } catch (IOException e) {
            System.out.println("Can't find FXML file!");
        }
    }

    /*
     * And just how will we create this beautiful display in Main.fxml?
     *
     * Double click on Main.fxml in the project directory to open it.
     * Toggle to Scene Builder.
     * Build the contents of the window by dragging and dropping a container,
     * followed by other containers and controls as needed.
     *
     * It may with visibility and scaling in the drag-and-drop environment
     * to collapse the project directory (on the left) and the Gradle buffer
     * (on the right).
     *
     * You will be able to see the elements you add as a graph
     * (! Take MATH 130!) at the
     * bottom of the left edge of Scene Builder.
     *
     * Modify the elements you drop onto the palette by clicking on them in
     * the graph at the bottom of the left edge of Scene Builder and then
     * modifying the Properties and Layout in the menus at the right edge
     * of Scene Builder. Notice these menus (Properties, Layout) are labeled
     * with the element to which they apply, such as a "Button" or a "VBox".
     *
     * (If you get some spurious yellow shapes or shadows for no apparent
     * reason, then close your project, and reopen it.)
     *
     * Do you agree that Scene Builder is a convenient way to create a display
     * (a view)? To see what the corresponding .fxml code looks like, which you
     * have "written" by manipulating Scene Builder, toggle from Scene Builder
     * over to Text.
     *
     * If you want your program to respond to user events, such as button clicks,
     * you need a "controller". The controller is separate from the view that is
     * defined in Main.fxml.
     *
     * How will you proceed?
     * You can write the bodies of event handlers, which we previously
     * wrote in inner classes in Main.java, and write them appropriately
     * in a Controller, for example as follows (uncommenting the lines below):
     */

    /*
    @FXML
    public void pressButton (ActionEvent event){
        // System.out.println("Hello World!");
        myLabel.setText("Thanks for clicking the button!");
    }
    */

    /* However, a catch is for the .fxml file to be able to direct the view
     * to the controller. (Java has to be able to find the controller when
     * the user clicks the button.)
     *
     * Look at the text file for Main.fxml. Enter
     * fx:controller="bsu.comp152.Main">
     *
     * so that you see something like
     *
     * <BorderPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity"
            minWidth="-Infinity" prefHeight="300.0" prefWidth="300.0"
            xmlns="http://javafx.com/javafx/10.0.2-internal"
            xmlns:fx="http://javafx.com/fxml/1" fx:controller="bsu.comp152.Main">
     *
     * . Then in the Scene Builder, select the Button from the graph at the bottom
     * right edge of the window. In the right edge of the window, open
     * the menu Code for the Button.
     *
     * Enter an fx-id, such as button_message .
     * Select the appropriate option for On Action (like pressButton).
     */

    /* Alternatively, you can omit the @FXML and pressButton method from this
     * file Main.java, and create a new Java file in main/java/bsu/comp152
     * instead, called for example Controller. In this case, you would need to
     * look at the text file for Main.fxml and enter
     * fx:controller="bsu.comp152.Controller">
     *
     * so that you see something like
     *
     * <BorderPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity"
            minWidth="-Infinity" prefHeight="300.0" prefWidth="300.0"
            xmlns="http://javafx.com/javafx/10.0.2-internal"
            xmlns:fx="http://javafx.com/fxml/1" fx:controller="bsu.comp152.Controller">
      *
      * See the file Controller.java for the needed contents!
      *
      * Using a separate file Controller.java as the controller is preferred
      * because we'd like to reserve Main for opening windows if multiple
      * windows will potentially be opened in this program.
      */

    /*
     * Note we are using the the view/contoller organization in the
     * MVC architcture pattern: model-view-contoller.
     * The view shows you a display.
     * The controller accepts input and converts it to commands.
     * Later we will see that the model manages and manipulates data.
     */
}