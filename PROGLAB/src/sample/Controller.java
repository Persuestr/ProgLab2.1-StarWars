//CONTROLLER CLASS
package sample;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import static javafx.scene.layout.GridPane.*;

public class Controller {
    //Array for walls
    private int[][] arraymap = new int[][]{
                {0	,0,	0,	0,	1	,0	,0	,0	,0,	0	,0,	0,	1,	0},
                { 0, 1,	1	,1,	1,	0	,1	,1	,1,	1	,1	,1,	1,  0},
                {0,	1	,0,	1	,1	,1,	1	,0,	1	,0,	0	,0,	1,	0},
                {0	,1	,0	,1	,1	,0	,1	,0	,1	,1	,0	,1	,1	,0},
                {0,	1,	0,	1,	0,	0,	1,	0,	1,	1,	0,	1	,1	,0},
                {1,	1,	0,	1,	1,	1,	1,	0,	1,	0,	0,	0,	1,	1},
                {0	,1	,0	,0	,1	,0	,1	,0	,1	,0	,1	,1	,1	,0},
                {0	,1	,0	,1	,1	,1	,1	,1	,1	,0	,0	,0	,1	,0},
                {0	,1	,0	,1	,0	,0	,0	,0	,1	,0	,0	,1	,1	,0},
                {0,	1,	1,	1,	1,	1,	1,	1	,1	,1	,1	,1	,1	,1},
                {0	,0	,0	,0	,1	,0	,0	,0	,0	,0	,0	,0	,0	,0}
        };

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Pane Pane;
    @FXML
    public ImageView Player1;
    @FXML
    private GridPane map;
    @FXML
    private ImageView aLongTime;
    @FXML
    private ImageView beforeStarting;
    @FXML
    private ImageView chooseLuke;
    @FXML
    private ImageView chooseYoda;
    @FXML
    public ImageView Enemy1;
    @FXML
    public ImageView Enemy2;
    @FXML
    public ImageView Enemy3;
    @FXML
    public ImageView heart1;
    @FXML
    public ImageView heart2;
    @FXML
    public ImageView heart3;

    //Creating Characters
    private Characters chars = new Characters();
    private Characters.MasterYoda Yoda1 = chars.new MasterYoda();
    private Characters.LukeSkywalker Luke1 = chars.new LukeSkywalker();
    private Characters.DarthVader Darth1 = chars.new DarthVader();
    private Characters.KyloRen Kylo1 = chars.new KyloRen();
    private Characters.Stormtrooper Storm1 = chars.new Stormtrooper();

    private boolean whichCharacter =true;

    Image youLose = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\youLose.png");
    ImageView loseYou = new ImageView(youLose);

    @FXML
    void CloseAlongTime(MouseEvent event) {
        Pane.getChildren().remove(aLongTime);
    }

    @FXML
    void CloseBeforeStarting(MouseEvent event) {
        Pane.getChildren().remove(beforeStarting);
    }

    //CHOOSING CHARACTERS
    @FXML
    void chooseLuke(MouseEvent event)
    {
        whichCharacter =true;
        Image luke = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\luke.png");
        Player1.setImage(luke);
        Luke1.setGoodevil("Good");
        Luke1.setName("Luke");
        Luke1.setHealth(3);
        Luke1.setX(GridPane.getRowIndex(Player1));
        Luke1.setY(GridPane.getColumnIndex(Player1));
        Pane.getChildren().remove(chooseLuke);
        Pane.getChildren().remove(chooseYoda);
        System.out.println(Luke1.getHealth()+Luke1.getGoodevil()+Luke1.getName()+Luke1.getX()+Luke1.getY());
    }

    @FXML
    void chooseYoda(MouseEvent event)
    {
        whichCharacter=false;
        Image yoda = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\yoda.png");
        Player1.setImage(yoda);
        Yoda1.setGoodevil("Good");
        Yoda1.setName("Yoda");
        Yoda1.setHealth(6);
        Yoda1.setX(GridPane.getRowIndex(Player1));
        Yoda1.setY(GridPane.getColumnIndex(Player1));
        Pane.getChildren().remove(chooseLuke);
        Pane.getChildren().remove(chooseYoda);
    }

    //SPAWNING ENEMIES
    @FXML
    void SpawnDarthVader(ActionEvent event)
    {
        Image darth = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\vader.png");
        Enemy1.setImage(darth);
        if ((GridPane.getRowIndex(Enemy1)==null))
        {
            Darth1.setX(0);
        }
        else
        {
            Darth1.setX(GridPane.getRowIndex(Player1));
        }
        if (GridPane.getColumnIndex(Enemy1)==null)
        {
            Darth1.setY(0);
        }
        else {
            Darth1.setY(GridPane.getColumnIndex(Enemy1));
        }
        Darth1.setGoodevil("Evil");
        Darth1.setName("Darth Vader");
        System.out.println(Darth1.getX()+ Darth1.getGoodevil()+Darth1.getName());
    }

    @FXML
    void SpawnKyloRen(ActionEvent event)
    {
        Image kylo = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\kyloren.png");
        Enemy2.setImage(kylo);
        Kylo1.setGoodevil("Evil");
        Kylo1.setName("Kylo Ren");
        if (GridPane.getRowIndex(Enemy2)==null)
        {
            Kylo1.setX(0);
        }
        else {
            Kylo1.setX(GridPane.getRowIndex(Enemy2));
        }
        if (GridPane.getColumnIndex(Enemy2)==null)
        {
            Kylo1.setY(0);
        }
        else {
            Kylo1.setY(GridPane.getColumnIndex(Enemy2));
        }
    }

    @FXML
    void SpawnStormtrooper(ActionEvent event)
    {
        Image storm = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\stormtrooper.png");
        Enemy3.setImage(storm);
        Storm1.setGoodevil("Evil");
        Storm1.setName("Stormtrooper");
        if ((GridPane.getRowIndex(Enemy3)==null))
        {
            Storm1.setX(0);
        }
        else {
            Storm1.setX(GridPane.getRowIndex(Enemy3));
        }
        if (GridPane.getColumnIndex(Enemy3)==null)
        {
            Storm1.setY(0);
        }
        else {
            Storm1.setY(GridPane.getColumnIndex(Enemy3));
        }
    }

    //CHARACTER MOVEMENTS
    @FXML
    void PlayerUp(MouseEvent event){

        if(arraymap[getRowIndex(Player1)-1][getColumnIndex(Player1)] == 0)
        {
            GridPane.setRowIndex(Player1, getRowIndex(Player1)+1);
            System.out.println("YOU CANT GO INSIDE THE WALLS");
        }
        if (whichCharacter)
        {

            if((Darth1.getX() == GridPane.getRowIndex(Player1)-1 && Darth1.getY() == GridPane.getColumnIndex(Player1)) ||(Kylo1.getX() == GridPane.getRowIndex(Player1)-1 && Kylo1.getY() == GridPane.getColumnIndex(Player1))||(Storm1.getX() == GridPane.getRowIndex(Player1)-1 && Storm1.getY() == GridPane.getColumnIndex(Player1)))
                {
                    if (Luke1.getHealth()==0)
                    {
                        Pane.getChildren().add(14,loseYou);
                    }

                    if (Luke1.getHealth()==3)
                    {
                        Pane.getChildren().remove(heart3);
                    }
                    if (Luke1.getHealth()==2)
                    {
                        Pane.getChildren().remove(heart2);
                    }
                    if (Luke1.getHealth()==1)
                    {
                        Pane.getChildren().remove(heart1);
                    }
                    if (Luke1.getHealth()==1)
                    {
                        Luke1.setHealth(0);
                    }
                    if (Luke1.getHealth()==2)
                    {
                        Luke1.setHealth(1);
                    }
                    if (Luke1.getHealth()==3)
                    {
                        Luke1.setHealth(2);
                    }
                    GridPane.setRowIndex(Player1,6);
                    GridPane.setColumnIndex(Player1,6);
                    Luke1.setX(GridPane.getRowIndex(Player1));
                    Luke1.setY(GridPane.getColumnIndex(Player1));
                    GridPane.setRowIndex(Enemy1,0);
                    GridPane.setColumnIndex(Enemy1,12);
                    Darth1.setX(0);
                    Darth1.setY(12);
                    GridPane.setRowIndex(Enemy2,0);
                    GridPane.setColumnIndex(Enemy2,4);
                    Kylo1.setX(0);
                    Kylo1.setY(4);
                    GridPane.setRowIndex(Enemy3,5);
                    GridPane.setColumnIndex(Enemy3,0);
                    Storm1.setX(5);
                    Storm1.setY(0);
                }
            if (Luke1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
        }
        else{
            if (Yoda1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1)-1 && Darth1.getY() == GridPane.getColumnIndex(Player1)) ||(Kylo1.getX() == GridPane.getRowIndex(Player1)-1 && Kylo1.getY() == GridPane.getColumnIndex(Player1))||(Storm1.getX() == GridPane.getRowIndex(Player1)-1 && Storm1.getY() == GridPane.getColumnIndex(Player1)))
            {

                if (Yoda1.getHealth()==6)
                {
                    Image halfheart3 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart3.setImage(halfheart3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Pane.getChildren().remove(heart3);
                }
                if(Yoda1.getHealth()==4)
                {
                    Image halfheart2 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart2.setImage(halfheart2);
                }
                if (Yoda1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Yoda1.getHealth()==2)
                {
                    Image halfheart1 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart1.setImage(halfheart1);
                }
                if(Yoda1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Yoda1.getHealth()==1)
                {
                    Yoda1.setHealth(0);
                }
                if (Yoda1.getHealth()==2)
                {
                    Yoda1.setHealth(1);
                }
                if (Yoda1.getHealth()==3)
                {
                    Yoda1.setHealth(2);
                }
                if (Yoda1.getHealth()==4)
                {
                    Yoda1.setHealth(3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Yoda1.setHealth(4);
                }
                if (Yoda1.getHealth()==6)
                {
                    Yoda1.setHealth(5);
                }
                GridPane.setRowIndex(Player1,6);
                GridPane.setColumnIndex(Player1,6);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }

        }
        if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==8))
        {
            Darth1.setX(Darth1.getX()+1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==2))
        {
            Darth1.setX(Darth1.getX()-1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==4))
        {
            Darth1.setY(Darth1.getY()+1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==6))
        {
            Darth1.setY(Darth1.getY()-1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        if (GridPane.getColumnIndex(Player1)==13&&GridPane.getRowIndex(Player1)-1==9)
        {
            System.out.println("YOU WIN");
        }
        System.out.println("Character position"+" ROW: "+GridPane.getRowIndex(Player1)+" COLUMN: "+GridPane.getColumnIndex(Player1));

        GridPane.setRowIndex(Player1, getRowIndex(Player1)-1);
        if (GridPane.getColumnIndex(Player1)==13&&GridPane.getRowIndex(Player1)-1==9)
        {
            System.out.println("YOU WIN");
        }
    }

    @FXML
    void PlayerDown(MouseEvent event) {
        if(arraymap[getRowIndex(Player1)+1][getColumnIndex(Player1)] == 0)
        {
            GridPane.setRowIndex(Player1, getRowIndex(Player1)-1);
            System.out.println("YOU CANT GO INSIDE THE WALLS");
        }

        if (whichCharacter)
        {
            if (Luke1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1)+1 && Darth1.getY() == GridPane.getColumnIndex(Player1)) ||(Kylo1.getX() == GridPane.getRowIndex(Player1)+1 && Kylo1.getY() == GridPane.getColumnIndex(Player1))||(Storm1.getX() == GridPane.getRowIndex(Player1)+1 && Storm1.getY() == GridPane.getColumnIndex(Player1)))
            {

                if (Luke1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart3);
                }
                if (Luke1.getHealth()==2)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Luke1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Luke1.getHealth()==1)
                {
                    Luke1.setHealth(0);
                }
                if (Luke1.getHealth()==2)
                {
                    Luke1.setHealth(1);
                }
                if (Luke1.getHealth()==3)
                {
                    Luke1.setHealth(2);
                }
                GridPane.setRowIndex(Player1,4);
                GridPane.setColumnIndex(Player1,6);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }
        }
        else{
            if (Yoda1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1)+1 && Darth1.getY() == GridPane.getColumnIndex(Player1)) ||(Kylo1.getX() == GridPane.getRowIndex(Player1)+1 && Kylo1.getY() == GridPane.getColumnIndex(Player1))||(Storm1.getX() == GridPane.getRowIndex(Player1)+1 && Storm1.getY() == GridPane.getColumnIndex(Player1)))
            {

                if (Yoda1.getHealth()==6)
                {
                    Image halfheart3 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart3.setImage(halfheart3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Pane.getChildren().remove(heart3);
                }
                if(Yoda1.getHealth()==4)
                {
                    Image halfheart2 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart2.setImage(halfheart2);
                }
                if (Yoda1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Yoda1.getHealth()==2)
                {
                    Image halfheart1 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart1.setImage(halfheart1);
                }
                if(Yoda1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Yoda1.getHealth()==1)
                {
                    Yoda1.setHealth(0);
                }
                if (Yoda1.getHealth()==2)
                {
                    Yoda1.setHealth(1);
                }
                if (Yoda1.getHealth()==3)
                {
                    Yoda1.setHealth(2);
                }
                if (Yoda1.getHealth()==4)
                {
                    Yoda1.setHealth(3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Yoda1.setHealth(4);
                }
                if (Yoda1.getHealth()==6)
                {
                    Yoda1.setHealth(5);
                }
                GridPane.setRowIndex(Player1,4);
                GridPane.setColumnIndex(Player1,6);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }
        }

        if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==8))
        {
            Darth1.setX(Darth1.getX()+1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==2))
        {
            Darth1.setX(Darth1.getX()-1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==4))
        {
            Darth1.setY(Darth1.getY()+1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==6))
        {
            Darth1.setY(Darth1.getY()-1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        if (GridPane.getColumnIndex(Player1)==13&&GridPane.getRowIndex(Player1)+1==9)
        {
            System.out.println("YOU WIN");
        }
        GridPane.setRowIndex(Player1, getRowIndex(Player1)+1);
        System.out.println("Character position"+" ROW: "+GridPane.getRowIndex(Player1)+" COLUMN: "+GridPane.getColumnIndex(Player1));
    }

    @FXML
    void PlayerLeft(MouseEvent event) {
        if(arraymap[getRowIndex(Player1)][getColumnIndex(Player1)-1] == 0)
        {
            GridPane.setColumnIndex(Player1, getColumnIndex(Player1)+1);
            System.out.println("YOU CANT GO INSIDE THE WALLS");
        }

        if (whichCharacter)
        {
            if (Luke1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1) && Darth1.getY() == GridPane.getColumnIndex(Player1)-1) ||(Kylo1.getX() == GridPane.getRowIndex(Player1) && Kylo1.getY() == GridPane.getColumnIndex(Player1)-1)||(Storm1.getX() == GridPane.getRowIndex(Player1) && Storm1.getY() == GridPane.getColumnIndex(Player1)-1))
            {

                if (Luke1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart3);
                }
                if (Luke1.getHealth()==2)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Luke1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Luke1.getHealth()==1)
                {
                    Luke1.setHealth(0);
                }
                if (Luke1.getHealth()==2)
                {
                    Luke1.setHealth(1);
                }
                if (Luke1.getHealth()==3)
                {
                    Luke1.setHealth(2);
                }
                GridPane.setRowIndex(Player1,5);
                GridPane.setColumnIndex(Player1,7);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }
        }
        else{
            if (Yoda1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1) && Darth1.getY() == GridPane.getColumnIndex(Player1)-1) ||(Kylo1.getX() == GridPane.getRowIndex(Player1) && Kylo1.getY() == GridPane.getColumnIndex(Player1)-1)||(Storm1.getX() == GridPane.getRowIndex(Player1) && Storm1.getY() == GridPane.getColumnIndex(Player1)-1))
            {

                if (Yoda1.getHealth()==6)
                {
                    Image halfheart3 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart3.setImage(halfheart3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Pane.getChildren().remove(heart3);
                }
                if(Yoda1.getHealth()==4)
                {
                    Image halfheart2 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart2.setImage(halfheart2);
                }
                if (Yoda1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Yoda1.getHealth()==2)
                {
                    Image halfheart1 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart1.setImage(halfheart1);
                }
                if(Yoda1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Yoda1.getHealth()==1)
                {
                    Yoda1.setHealth(0);
                }
                if (Yoda1.getHealth()==2)
                {
                    Yoda1.setHealth(1);
                }
                if (Yoda1.getHealth()==3)
                {
                    Yoda1.setHealth(2);
                }
                if (Yoda1.getHealth()==4)
                {
                    Yoda1.setHealth(3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Yoda1.setHealth(4);
                }
                if (Yoda1.getHealth()==6)
                {
                    Yoda1.setHealth(5);
                }
                GridPane.setRowIndex(Player1,5);
                GridPane.setColumnIndex(Player1,7);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }
        }
        if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==8))
        {
            Darth1.setX(Darth1.getX()+1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==2))
        {
            Darth1.setX(Darth1.getX()-1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==4))
        {
            Darth1.setY(Darth1.getY()+1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==6))
        {
            Darth1.setY(Darth1.getY()-1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        if (GridPane.getColumnIndex(Player1)-1==13&&GridPane.getRowIndex(Player1)==9)
        {
            System.out.println("YOU WIN");
        }
        GridPane.setColumnIndex(Player1,GridPane.getColumnIndex(Player1)-1);
        System.out.println("Character position"+" ROW: "+GridPane.getRowIndex(Player1)+" COLUMN: "+GridPane.getColumnIndex(Player1));
    }

    @FXML
    void PlayerRight(MouseEvent event) {
        if(arraymap[getRowIndex(Player1)][getColumnIndex(Player1)+1] == 0)
        {
            GridPane.setColumnIndex(Player1, getColumnIndex(Player1)-1);
            System.out.println("YOU CANT GO INSIDE THE WALLS");
        }

        if (whichCharacter)
        {
            if (Luke1.getHealth()==0)
            {
                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1) && Darth1.getY() == GridPane.getColumnIndex(Player1)+1) ||(Kylo1.getX() == GridPane.getRowIndex(Player1) && Kylo1.getY() == GridPane.getColumnIndex(Player1)+1)||(Storm1.getX() == GridPane.getRowIndex(Player1) && Storm1.getY() == GridPane.getColumnIndex(Player1)+1))
            {

                if (Luke1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart3);
                }
                if (Luke1.getHealth()==2)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Luke1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Luke1.getHealth()==1)
                {
                    Luke1.setHealth(0);
                }
                if (Luke1.getHealth()==2)
                {
                    Luke1.setHealth(1);
                }
                if (Luke1.getHealth()==3)
                {
                    Luke1.setHealth(2);
                }
                GridPane.setRowIndex(Player1,5);
                GridPane.setColumnIndex(Player1,5);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }
        }
        else{
            if (Yoda1.getHealth()==0)
            {

                Pane.getChildren().add(14,loseYou);
            }
            if((Darth1.getX() == GridPane.getRowIndex(Player1) && Darth1.getY() == GridPane.getColumnIndex(Player1)+1) ||(Kylo1.getX() == GridPane.getRowIndex(Player1) && Kylo1.getY() == GridPane.getColumnIndex(Player1)+1)||(Storm1.getX() == GridPane.getRowIndex(Player1) && Storm1.getY() == GridPane.getColumnIndex(Player1)+1))
            {

                if (Yoda1.getHealth()==6)
                {
                    Image halfheart3 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart3.setImage(halfheart3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Pane.getChildren().remove(heart3);
                }
                if(Yoda1.getHealth()==4)
                {
                    Image halfheart2 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart2.setImage(halfheart2);
                }
                if (Yoda1.getHealth()==3)
                {
                    Pane.getChildren().remove(heart2);
                }
                if (Yoda1.getHealth()==2)
                {
                    Image halfheart1 = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\halfheart.png");
                    heart1.setImage(halfheart1);
                }
                if(Yoda1.getHealth()==1)
                {
                    Pane.getChildren().remove(heart1);
                }
                if (Yoda1.getHealth()==1)
                {
                    Yoda1.setHealth(0);
                }
                if (Yoda1.getHealth()==2)
                {
                    Yoda1.setHealth(1);
                }
                if (Yoda1.getHealth()==3)
                {
                    Yoda1.setHealth(2);
                }
                if (Yoda1.getHealth()==4)
                {
                    Yoda1.setHealth(3);
                }
                if (Yoda1.getHealth()==5)
                {
                    Yoda1.setHealth(4);
                }
                if (Yoda1.getHealth()==6)
                {
                    Yoda1.setHealth(5);
                }
                GridPane.setRowIndex(Player1,5);
                GridPane.setColumnIndex(Player1,5);
                Luke1.setX(GridPane.getRowIndex(Player1));
                Luke1.setY(GridPane.getColumnIndex(Player1));
                GridPane.setRowIndex(Enemy1,0);
                GridPane.setColumnIndex(Enemy1,12);
                Darth1.setX(0);
                Darth1.setY(12);
                GridPane.setRowIndex(Enemy2,0);
                GridPane.setColumnIndex(Enemy2,4);
                Kylo1.setX(0);
                Kylo1.setY(4);
                GridPane.setRowIndex(Enemy3,5);
                GridPane.setColumnIndex(Enemy3,0);
                Storm1.setX(5);
                Storm1.setY(0);
            }
        }
        if (GridPane.getColumnIndex(Player1)+1==13&&GridPane.getRowIndex(Player1)==9)
        {
            Image youWin = new Image("file:C:\\Users\\oguzh\\Desktop\\PROGLAB\\src\\sample\\Images\\youwin.png");
            ImageView winYou = new ImageView(youWin);
            Pane.getChildren().add(14,winYou);

            System.out.println("YOU WIN");
        }
        if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==8))
        {
            Darth1.setX(Darth1.getX()+1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==2))
        {
            Darth1.setX(Darth1.getX()-1);
            GridPane.setRowIndex(Enemy1,Darth1.getX());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==4))
        {
            Darth1.setY(Darth1.getY()+1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        else if ((Darth1.shortestWay((GridPane.getRowIndex(Player1)),GridPane.getColumnIndex(Player1))==6))
        {
            Darth1.setY(Darth1.getY()-1);
            GridPane.setColumnIndex(Enemy1,Darth1.getY());
        }
        GridPane.setColumnIndex(Player1,GridPane.getColumnIndex(Player1)+1);
        System.out.println("Character position"+" ROW: "+GridPane.getRowIndex(Player1)+" COLUMN: "+GridPane.getColumnIndex(Player1));
    }

    //EXIT PROGRAM
    @FXML
    void ExitProgram(MouseEvent event) {
        System.exit(0);

    }

    @FXML
    void initialize() {


    }
}
//END OF CONTROLLER CLASS