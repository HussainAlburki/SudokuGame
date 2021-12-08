package MySudokuGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MySudokuGame extends Application {
    
    TextField[][] txt = new TextField[4][4];
    
    Button bCheck = new Button("CHECK");
    Label lbl = new Label("Check Below");
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(5);
        grid.setHgap(5);
        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                txt[i][j] = new TextField();
                txt[i][j].setMaxSize(40,30);
                grid.add(txt[i][j], i, j);
             

            }
        }
           for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
           txt[i][j].setStyle("-fx-background-color: rgb(130 ,190, 610);");}
           }
   
               for(int i = 2; i < 4 ; i++){
            for(int j = 2 ; j < 4 ; j++){
           txt[i][j].setStyle("-fx-background-color: rgb(130 ,190, 610);");}
           }
               
               
               
        bCheck.setOnAction(new EventHandler <ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(boardFull() == true){
                    if(checkResult() == true){
                        lbl.setText("Correct Solution");
                    }else{
                        lbl.setText("Incorrect solution");
                    }
                }else{
                    lbl.setText("please Fill the cells");
                }
            }
        
        });
        

        VBox root = new VBox();
//        root.setPadding(new Insets(10,10,10,10));
        root.getChildren().addAll(grid, lbl, bCheck);
        
        Scene scene = new Scene(root, 300, 300);
        
        primaryStage.setTitle("Sudoku");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    
    public boolean boardFull(){
        for(int i = 0; i< 4; i++){
            for(int j = 0; j<4; j++){
                if(txt[i][j].getText().isEmpty() == true){
                    return false;
                }
            }
        }
        return true;
    }

    
    public boolean checkResult(){
        
   
        int num=0;
        boolean flag1=true;
        
        ///Checking the rows and columns if any text fields have same numbers. If yes i will return false directly without checking other things
        for(int k = 0; k < 4 ; k++){
            if(    txt[0][k].getText().equals(txt[1][k].getText()) && txt[1][k].getText().equals(txt[2][k].getText()) && txt[2][k].getText().equals(txt[3][k].getText()) && txt[3][k].getText().equals(txt[4][k].getText()) ){
                return false;
            }
        }

    
        
        for(int k = 0; k < 4 ; k++){
            if(     txt[k][0].getText().equals(txt[k][1].getText()) && txt[k][1].getText().equals(txt[k][2].getText()) && txt[k][2].getText().equals(txt[k][3].getText()) && txt[k][3].getText().equals(txt[k][4].getText())   ){
                return false;
            }
        } 
        
        
        
        //Checking  the rows and columns if their sum is '10' so considering the first condtinos if the boxes are not equal so we have to check if they are equal to 10.
         for(int i = 0; i< 4; i++){ 
            for(int j = 0; j<4; j++){
             num+= Integer.parseInt(txt[i][j].getText());
            }
            if(num!=10)
            {
                flag1= false;// if not, changing the flag so we will leave the function by 'false'
            }
             num=0;
            }
         
         //Checking same things but in the small sqaures
         ///-First Square
         
         num=0;
           for(int i = 0; i< 2; i++){
         
            for(int j = 0; j<2; j++){
             num+= Integer.parseInt(txt[i][j].getText());}
            
           }//end of for
             
            if(num!=10)
            {
                flag1= false;
            }

            num=0;
            ///Second Square
            for(int i = 0 ; i < 2 ; i++){
            for(int j = 2 ; j < 4 ; j++){
               num+= Integer.parseInt(txt[i][j].getText());
            }
            }
            if(num!=10)
            {
                flag1= false;
            }

             
             num=0;
            //Third Square
               for(int i = 2 ; i < 4 ; i++){
            for(int j = 0 ; j < 2 ; j++){
              num+= Integer.parseInt(txt[i][j].getText());
            }
               }
            if(num!=10)
            {
                flag1= false;
            }
          
            
            
           
             ///-Fourth Square
             num=0;
            for(int i = 2; i < 4 ; i++){
            for(int j = 2 ; j < 4 ; j++){
             num+= Integer.parseInt(txt[i][j].getText());
            }
            }
            if(num!=10)
            {
                flag1= false;
            }

            
            
            //After Checking all rows,columns, and every Square which has 4 text fields
            //we check if the flag is still true, so we are safe and we have correct solution, otherwise we have something wrong and we return false.
            if(flag1)  
                return true;
        
     
            return false;
    }//End of Check Result


    }

    
