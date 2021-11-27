import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RobotViewer {
    private JFrame frame;
    private Robot robot;
    private JLabel hungerLabel;
    private JLabel healthLabel;
    private JLabel happinessLabel;
    private JLabel robotFace;
    private JLabel nameLabel;

    private Food selectedFood;
    private JLabel selectedFoodLabel;



    public RobotViewer(Robot robot)
    {
        this.robot = robot;
        hungerLabel = new JLabel("hunger: " + robot.getHunger());
        healthLabel = new JLabel("health: " + robot.getHealth());
        happinessLabel = new JLabel("happiness: " + robot.getHappiness());
        robotFace = new JLabel("^_^", SwingConstants.CENTER);
        nameLabel = new JLabel(robot.getName(), SwingConstants.CENTER);
        selectBanana();
        selectedFoodLabel = new JLabel("Feeding: " + selectedFood.getName());
        makeFrame();
        makeMenuBar();


    }


    private void makeFrame()
    {
        frame = new JFrame("Robot Viewer");

        //Layout Setup
        JPanel mainPanel = new JPanel(new BorderLayout());
        frame.add(mainPanel);
        JPanel NPanel = new JPanel(new FlowLayout());
        mainPanel.add(NPanel, BorderLayout.NORTH);
        JPanel SPanel = new JPanel(new GridLayout());
        mainPanel.add(SPanel, BorderLayout.SOUTH);
        JPanel CPanel = new JPanel(new BorderLayout());
        mainPanel.add(CPanel, BorderLayout.CENTER);



        //C Setup

        CPanel.add(robotFace, BorderLayout.CENTER);
        CPanel.add(nameLabel, BorderLayout.NORTH);
        

        //N Setup
        
        NPanel.add(hungerLabel);
        NPanel.add(healthLabel);
        NPanel.add(happinessLabel);
        NPanel.add(selectedFoodLabel);

        //S Setup

        JButton feedButton = new JButton("FEED");
        SPanel.add(feedButton);
        feedButton.addActionListener(ev -> {feed(); update();});

        JButton playButton = new JButton("PLAY");
        SPanel.add(playButton); 
        playButton.addActionListener(ev -> {play(); update();});

        frame.pack();
        frame.setVisible(true);



    }

    private void makeMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu foodMenu = new JMenu("Food");
        menubar.add(foodMenu);

        JMenuItem Banana = new JMenuItem("Banana");
        foodMenu.add(Banana);
        Banana.addActionListener(ev -> {selectBanana(); update();});

        JMenuItem Broccoli = new JMenuItem("Broccoli");
        foodMenu.add(Broccoli);
        Broccoli.addActionListener(ev -> {selectBroccoli(); update();});

        JMenuItem ChocolateBar = new JMenuItem("Chocolate Bar");
        foodMenu.add(ChocolateBar);
        ChocolateBar.addActionListener(ev -> {selectChocolate(); update();});






    }

    private void update()
    {
        //Robot Updates





        //Layout Updates
        hungerLabel.setText("hunger: " + robot.getHunger());
        healthLabel.setText("health: " + robot.getHealth());
        happinessLabel.setText("happiness: " + robot.getHappiness());
        if(selectedFoodLabel != null) selectedFoodLabel.setText("Feeding: " + selectedFood.getName());
        

        if(robot.isDead()) {robotFace.setText("x_x");}

    }
    
    private void feed()
    {
        robot.feed(selectedFood);
        update();
    }

    private void selectBanana()
    {
        selectedFood = new Food("Banana", 2, 0, 1);
        update();
    }

    private void selectBroccoli()
    {
        selectedFood = new Food("Broccoli", 3, -1, 1);
        update();
    }

    private void selectChocolate()
    {
        selectedFood = new Food("Chocolate Bar", -1, 2, 1);
        update();
    }

    private void play() 
    {
        robot.play(3);
        update();
    }


}
