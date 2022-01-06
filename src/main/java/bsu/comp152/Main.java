package bsu.comp152;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class for creating a scene for a GUI
 * in a different way from previously
 *
 * The idea is to use drag and drop to put layout containers and controls
 * in the scene instead of using Java statements.
 *
 * The tool we use is called Scene Builder. (It is a GUI for creating GUIs!)
 * It's available within IDEA. It is not well-integrated into IDEA on Macs. Mac users
 * should download the standalone Scene Builder for free at
 * https://gluonhq.com/products/scene-builder/ .
 *
 * When we drag and drop to create a scene visually, Scene Builder
 * creates a code version of the scene.
 * The code is in fxml instead of the Java that we wrote before.
 * The ML in fxml stands for markup language. FXML is for JavaFX.
 * (HTML is for web pages.)
 * (The contents of web pages can also be created by dragging and dropping
 * instead of writing html code directly.)
 *
 * We need to put the .fxml file that contains the scene as a resource in
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
 * for the Java classes as IDEA expects/requires.
 *
 */
public class Main extends Application {

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

        /* We instantiate a location that connects to the file Main.fxml
         * using a "factory constructor" rather than the
         * keyword new:
         */
        // var loc = getClass().getResource("Main.fxml");
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
     * On a Windows machine, double click on Main.fxml in the project directory
     * to open it.
     * Toggle to Scene Builder.
     * Build the contents of the window by dragging and dropping a container,
     * followed by other containers and controls as needed.
     * It may help with visibility and scaling in the drag-and-drop environment
     * to collapse the project directory (on the left) and the Gradle buffer
     * (on the right).
     *
     * On a Mac, create the GUI in the standalone Scene Builder.
     * (Download it for free at https://gluonhq.com/products/scene-builder/ .) In the
     * File Menu, choose Open and open *your fxml file*. Perhaps it is
     * IdeaProjects/main/resources/bsu/comp152/Main.fxml .
     *
     * You can see the elements you add in a hierarchy at the bottom of the
     * left edge of Scene Builder.
     *
     * Modify the elements you drop onto the palette by clicking on them in
     * the graph at the bottom of the left edge of Scene Builder and then
     * modifying the Properties and Layout in the menus at the right edge
     * of Scene Builder. Notice these menus (Properties, Layout) are labeled
     * with the element to which they apply, such as a "Button" or a "VBox".
     *
     * (If you get some spurious yellow shapes or shadows for no apparent
     * reason, or if the interface doesn't respond, then close your project
     * and reopen it.)
     *
     * Do you agree that Scene Builder is a convenient way to create a display
     * (a view)? To see what the corresponding .fxml code looks like, which you
     * have generated by manipulating Scene Builder, toggle from Scene Builder
     * over to Text.
     *
     * If you want your program to respond to user events, such as button clicks,
     * you need a "controller". The controller is separate from the view that is
     * defined in Main.fxml.
     *
     * How will you proceed?
     * You can write the bodies of event handlers, which we previously
     * wrote in inner classes in Main.java, and write them appropriately
     * in a Controller. For example, you could create a Controller class in
     * a file Controller.java alongside Main.java. It could contain:
     */

    /*
    @FXML
    public void pressButton (ActionEvent event){
        // System.out.println("Hello World!");
        myLabel.setText("Thanks for clicking the button!");
    }
    */

    /* For the pressButton method above, you need a class variable
    in the Controller class:

    @FXML
    private Label myLabel;
     */

    /* For the controller to work, the .fxml file must identify the
     * file containing the controller.
     * (Java has to be able to find the controller when the user clicks the button.)
     *
     * Use the Controller drop-down in the lower left corner of Scene Builder
     * under the hierarchy. Enter the file name for the controller in the
     * Controller-class textfield. Omit the .fxml extension, for example,
     * bsu.comp152.Controller .
     *
     *
     * Alternatively, connect the view to the controller in the text of the
     * .fxml file: Look at the text file for Main.fxml. For example, enter
     * fx:controller="bsu.comp152.Controller"> ,
     *
     * so that you see something like
     *
     * <BorderPane maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity"
            minWidth="-Infinity" prefHeight="300.0" prefWidth="300.0"
            xmlns="http://javafx.com/javafx/10.0.2-internal"
            xmlns:fx="http://javafx.com/fxml/1" fx:controller="bsu.comp152.Controller">
     *
     * . Then in the Scene Builder, select the Button. In the right edge of the window, open
     * the menu Code for the Button.
     *
     * Type the method name for the handler in the On Action textfield (here pressButton since
     * the handler method in the controller is called pressButton).
     *
     * In the Code menu for the label, in the fx:id textfield,
     * enter the reference variable (for example myLabel).
     */

    /*
      * The controller code could be included here in Main.java.
      * Using a separate file Controller.java as the controller is preferred,
      * however, because we'd like to reserve Main for opening windows if multiple
      * windows will potentially be opened in this program.
      */

    /*
     * Note we are using the view/contoller organization in the
     * MVC architcture pattern: model-view-contoller.
     * The view shows you a display.
     * The controller accepts input and converts it to commands.
     * Later we will see that the model manages and manipulates data.
     */
}