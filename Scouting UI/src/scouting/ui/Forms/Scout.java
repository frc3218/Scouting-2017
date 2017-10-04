package scouting.ui.Forms;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.Border;
import scouting.ui.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
import java.io.File; 
import scouting.ui.JsonParsing;
import scouting.ui.JsonIO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Scout extends javax.swing.JFrame 
{
    public RoboticsHashMap teamList;
    public String curTeamNum;
    public String masterListPath;
    
    public Scout() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        MatchesComboBox.setEditable(false);

        String[] options = { "Create New List", "Open Existing List" };
        /*if(!JsonIO.listFileExists("H:\\Scouting\\masterlist.json"))
        {
            int input = JOptionPane.showOptionDialog(null, "Unable to find local masterlist in\n" + "H:\\Scouting\\masterlist.json" + "\nWould you like to create an empty one?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            
            if(input == JOptionPane.YES_OPTION)
            {
                File dir = new File("H:\\Scouting");
                dir.mkdir();
                
                JsonIO.createEmptyJsonFile("H:\\Scouting\\masterlist.json");
                try
                {
                    JsonParsing json = new JsonParsing(JsonIO.getJsonFromFile("H:\\Scouting\\masterlist.json"));
                    teamList = json.getMasterList();
                }
                catch (Exception ex)
                {
                    MessageBox box = new MessageBox();
                    box.show(ex.getMessage(), "Warning", this);
                }
            }
        }
        else
        {
            try
            {
                JsonParsing json = new JsonParsing(JsonIO.getJsonFromFile("H:\\Scouting\\masterlist.json"));
                teamList = json.getMasterList();
            }
            catch(Exception ex)
            {
                MessageBox msg = new MessageBox();
                msg.show(ex.getMessage(), "Error", this);
            }
        }*/
        
        int input = JOptionPane.showOptionDialog(null, "Would you like to create a new masterlist\nfile, or open an existing one?", "Notice", 0, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        
        if(input == 0) // Create new list
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            chooser.setMultiSelectionEnabled(false);
            
            int ret = chooser.showDialog(this, "Select Folder");
            
            if(ret == JFileChooser.APPROVE_OPTION)
            {
                String dir = chooser.getSelectedFile().getAbsolutePath();
                masterListPath = dir + "\\masterlist.json";
                System.out.println(masterListPath);
                
                if(JsonIO.listFileExists(dir + "\\masterlist.json"))
                {
                    MessageBox box = new MessageBox();
                    box.show("A masterlist file already exists in the selected folder.", "Error", this);
                    teamList = null;
                }
                else
                {
                    JsonIO.createEmptyJsonFile(dir + "\\masterlist.json");
                    teamList = null;
                }
            }
        }
        else // load existing list
        {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setMultiSelectionEnabled(false);
            chooser.setFileFilter(new FileNameExtensionFilter("JSON File", "json"));
            
            int ret = chooser.showDialog(this, "Open Masterlist");
            
            if(ret == JFileChooser.APPROVE_OPTION)
            {
                String file = chooser.getSelectedFile().getAbsolutePath();
                masterListPath = file;
                
                try
                {
                    JsonParsing parse = new JsonParsing(JsonIO.getJsonFromFile(file));
                    this.teamList = parse.getMasterList();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    MessageBox msg = new MessageBox();
                    msg.show("Error parsing local JSON file.", "Error", this);
                    teamList = null;
                }
                        
            }
        }
    }
    
    public void disableSearchUI()
    {
        GetDataButton.setEnabled(false);
        ClearButton.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        Panel = new javax.swing.JPanel();
        Strategy = new javax.swing.JScrollPane();
        StrategyTextBox = new javax.swing.JTextPane();
        AveragePanel = new javax.swing.JPanel();
        ScoreLabel = new javax.swing.JLabel();
        ScoreSpinner = new javax.swing.JSpinner();
        PenaltiesLabel = new javax.swing.JLabel();
        PenaltiesSpinner = new javax.swing.JSpinner();
        GearsDeliveredLabel = new javax.swing.JLabel();
        GearsDeliveredSpinner = new javax.swing.JSpinner();
        BoilerLabel = new javax.swing.JLabel();
        BoilerSpinner = new javax.swing.JSpinner();
        ComboBoxPanel = new javax.swing.JPanel();
        ClimabilityLabel = new javax.swing.JLabel();
        ShotAccuracyLabel = new javax.swing.JLabel();
        ShotAccuracyComboBox = new javax.swing.JComboBox<>();
        ClimbComboBox = new javax.swing.JComboBox<>();
        TeamPanel = new javax.swing.JPanel();
        TeamNumberLabel = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        GetDataButton = new javax.swing.JButton();
        MatchesComboBox = new javax.swing.JComboBox<>();
        TeamNameLabel = new javax.swing.JLabel();
        TeamNumberText = new javax.swing.JTextField();
        TeamNameText = new javax.swing.JTextField();
        StrategyLabel = new javax.swing.JLabel();
        SpecialtiesPanel = new javax.swing.JPanel();
        SpecialtiesLabel = new javax.swing.JLabel();
        DeliveringGearsCheckBox = new javax.swing.JCheckBox();
        BottomBoilerCheckBox = new javax.swing.JCheckBox();
        ClimbingCheckBox = new javax.swing.JCheckBox();
        TopBoilerCheckBox = new javax.swing.JCheckBox();
        DevMenu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        resultComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        autonomousComboBox = new javax.swing.JComboBox<>();
        MenuBar = new javax.swing.JMenuBar();
        statsMENU = new javax.swing.JMenu();
        leaderboardMENU = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        syncFromWebMENU = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(223, 230, 238));

        Panel.setBackground(new java.awt.Color(223, 230, 238));
        Panel.setMaximumSize(new java.awt.Dimension(649, 506));
        Panel.setMinimumSize(new java.awt.Dimension(649, 506));

        StrategyTextBox.setBackground(new java.awt.Color(237, 242, 255));
        StrategyTextBox.setBorder(null);
        StrategyTextBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StrategyTextBox.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        StrategyTextBox.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        Strategy.setViewportView(StrategyTextBox);

        AveragePanel.setBackground(new java.awt.Color(176, 206, 242));
        AveragePanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ScoreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ScoreLabel.setText("Score:");

        ScoreSpinner.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        PenaltiesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PenaltiesLabel.setText("Penalties:");

        PenaltiesSpinner.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GearsDeliveredLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        GearsDeliveredLabel.setText("Gears Delivered:");

        GearsDeliveredSpinner.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        BoilerLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BoilerLabel.setText("Boiler Score:");

        BoilerSpinner.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout AveragePanelLayout = new javax.swing.GroupLayout(AveragePanel);
        AveragePanel.setLayout(AveragePanelLayout);
        AveragePanelLayout.setHorizontalGroup(
            AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AveragePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AveragePanelLayout.createSequentialGroup()
                        .addComponent(ScoreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ScoreSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AveragePanelLayout.createSequentialGroup()
                        .addComponent(BoilerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BoilerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AveragePanelLayout.createSequentialGroup()
                        .addComponent(GearsDeliveredLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GearsDeliveredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AveragePanelLayout.createSequentialGroup()
                        .addComponent(PenaltiesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PenaltiesSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AveragePanelLayout.setVerticalGroup(
            AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AveragePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ScoreLabel)
                    .addComponent(ScoreSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GearsDeliveredLabel)
                    .addComponent(GearsDeliveredSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BoilerSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BoilerLabel))
                .addGap(8, 8, 8)
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PenaltiesLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PenaltiesSpinner))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ComboBoxPanel.setBackground(new java.awt.Color(176, 206, 242));
        ComboBoxPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ClimabilityLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ClimabilityLabel.setText("Climbability:");

        ShotAccuracyLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ShotAccuracyLabel.setText("Shot Accuracy:");

        ShotAccuracyComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ShotAccuracyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Shots", "Low", "Medium", "High" }));
        ShotAccuracyComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ShotAccuracyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShotAccuracyComboBoxActionPerformed(evt);
            }
        });

        ClimbComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClimbComboBox.setForeground(new java.awt.Color(30, 30, 30));
        ClimbComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Didn't Climb", "Climbed" }));
        ClimbComboBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ClimbComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClimbComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ComboBoxPanelLayout = new javax.swing.GroupLayout(ComboBoxPanel);
        ComboBoxPanel.setLayout(ComboBoxPanelLayout);
        ComboBoxPanelLayout.setHorizontalGroup(
            ComboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComboBoxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ShotAccuracyLabel)
                    .addComponent(ClimabilityLabel))
                .addGap(18, 18, 18)
                .addGroup(ComboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ClimbComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ShotAccuracyComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        ComboBoxPanelLayout.setVerticalGroup(
            ComboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComboBoxPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShotAccuracyLabel)
                    .addComponent(ShotAccuracyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(ComboBoxPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClimabilityLabel)
                    .addComponent(ClimbComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        TeamPanel.setBackground(new java.awt.Color(176, 206, 242));
        TeamPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TeamNumberLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TeamNumberLabel.setText("Team Number:");

        ClearButton.setBackground(new java.awt.Color(255, 255, 255));
        ClearButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClearButton.setText("Clear");
        ClearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        GetDataButton.setBackground(new java.awt.Color(255, 255, 255));
        GetDataButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        GetDataButton.setText("Get Data");
        GetDataButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        GetDataButton.setEnabled(false);
        GetDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetDataButtonActionPerformed(evt);
            }
        });
        GetDataButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                GetDataButtonKeyTyped(evt);
            }
        });

        MatchesComboBox.setBackground(new java.awt.Color(237, 242, 255));
        MatchesComboBox.setEditable(true);
        MatchesComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        MatchesComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatchesComboBoxActionPerformed(evt);
            }
        });

        TeamNameLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TeamNameLabel.setText("Team Name:");

        TeamNumberText.setBackground(new java.awt.Color(237, 242, 255));
        TeamNumberText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TeamNumberText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TeamNumberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TeamNumberTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TeamNumberTextKeyReleased(evt);
            }
        });

        TeamNameText.setBackground(new java.awt.Color(237, 242, 255));
        TeamNameText.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TeamNameText.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout TeamPanelLayout = new javax.swing.GroupLayout(TeamPanel);
        TeamPanel.setLayout(TeamPanelLayout);
        TeamPanelLayout.setHorizontalGroup(
            TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(TeamPanelLayout.createSequentialGroup()
                        .addComponent(TeamNumberLabel)
                        .addGap(18, 18, 18)
                        .addComponent(TeamNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TeamPanelLayout.createSequentialGroup()
                        .addComponent(TeamNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TeamNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamPanelLayout.createSequentialGroup()
                        .addComponent(GetDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamPanelLayout.createSequentialGroup()
                        .addComponent(MatchesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        TeamPanelLayout.setVerticalGroup(
            TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GetDataButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TeamNumberLabel))
                    .addComponent(TeamNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TeamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MatchesComboBox)
                    .addComponent(TeamNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TeamNameLabel))
                .addContainerGap())
        );

        StrategyLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        StrategyLabel.setText("Strategy:");

        SpecialtiesPanel.setBackground(new java.awt.Color(176, 206, 242));
        SpecialtiesPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SpecialtiesLabel.setBackground(new java.awt.Color(120, 120, 120));
        SpecialtiesLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SpecialtiesLabel.setText("Specialties:");

        DeliveringGearsCheckBox.setBackground(new java.awt.Color(176, 206, 242));
        DeliveringGearsCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DeliveringGearsCheckBox.setText("Delivering Gears");

        BottomBoilerCheckBox.setBackground(new java.awt.Color(176, 206, 242));
        BottomBoilerCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        BottomBoilerCheckBox.setText("Bottom Boiler");

        ClimbingCheckBox.setBackground(new java.awt.Color(176, 206, 242));
        ClimbingCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ClimbingCheckBox.setText("Climbing");
        ClimbingCheckBox.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        TopBoilerCheckBox.setBackground(new java.awt.Color(176, 206, 242));
        TopBoilerCheckBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TopBoilerCheckBox.setText("Top Boiler");
        TopBoilerCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopBoilerCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SpecialtiesPanelLayout = new javax.swing.GroupLayout(SpecialtiesPanel);
        SpecialtiesPanel.setLayout(SpecialtiesPanelLayout);
        SpecialtiesPanelLayout.setHorizontalGroup(
            SpecialtiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpecialtiesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SpecialtiesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeliveringGearsCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BottomBoilerCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TopBoilerCheckBox)
                .addGap(18, 18, 18)
                .addComponent(ClimbingCheckBox)
                .addGap(43, 43, 43))
        );
        SpecialtiesPanelLayout.setVerticalGroup(
            SpecialtiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpecialtiesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SpecialtiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SpecialtiesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeliveringGearsCheckBox)
                    .addComponent(BottomBoilerCheckBox)
                    .addComponent(ClimbingCheckBox)
                    .addComponent(TopBoilerCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        DevMenu.setBackground(new java.awt.Color(255, 255, 255));
        DevMenu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        DevMenu.setText("Dev Menu");
        DevMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        DevMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DevMenuActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(176, 206, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Match Result");

        resultComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resultComboBox.setForeground(new java.awt.Color(30, 30, 30));
        resultComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Win", "Lose", "Tie" }));
        resultComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Autonomous");

        autonomousComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        autonomousComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Didn't move", "Move", "Gear(s)", "Shoot Boiler", "Both Gears and Boiler" }));
        autonomousComboBox.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resultComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autonomousComboBox, 0, 180, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(resultComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(autonomousComboBox))
                .addContainerGap())
        );

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ComboBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TeamPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AveragePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(63, 63, 63)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(PanelLayout.createSequentialGroup()
                                        .addComponent(StrategyLabel)
                                        .addGap(192, 192, 192))
                                    .addComponent(Strategy)))
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(SpecialtiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DevMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TeamPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(ComboBoxPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StrategyLabel))
                    .addComponent(AveragePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Strategy, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpecialtiesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(DevMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        statsMENU.setText("Statistics");

        leaderboardMENU.setText("Leaderboard");
        leaderboardMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leaderboardMENUActionPerformed(evt);
            }
        });
        statsMENU.add(leaderboardMENU);

        MenuBar.add(statsMENU);

        jMenu1.setText("Sync");

        syncFromWebMENU.setText("Web -> Local");
        syncFromWebMENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syncFromWebMENUActionPerformed(evt);
            }
        });
        jMenu1.add(syncFromWebMENU);

        MenuBar.add(jMenu1);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TopBoilerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopBoilerCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TopBoilerCheckBoxActionPerformed

    private void leaderboardMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leaderboardMENUActionPerformed
        try
        {
            Stats stat = new Stats(teamList);
            stat.show();
        }
        catch(Exception ex)
        {
            MessageBox box = new MessageBox();
            box.show(ex.getMessage(), "", this);
        }
    }//GEN-LAST:event_leaderboardMENUActionPerformed

    private void GetDataButtonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GetDataButtonKeyTyped
        
        // TODO add your handling code here:
    }//GEN-LAST:event_GetDataButtonKeyTyped

    private void GetDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetDataButtonActionPerformed
        String teamNum = TeamNumberText.getText();
        
        if(teamNum != null && !teamNum.isEmpty())
        {
            try
            {
                curTeamNum = teamNum;

                if(MatchesComboBox.getItemCount() > 0)
                {
                    MatchesComboBox.removeAllItems();
                }

                TeamDataCollection team = new TeamDataCollection();
                team = teamList.getTeam(teamNum);

                for(int i = 0; i < team.size(); i++)
                {
                    MatchesComboBox.addItem(String.valueOf(i));
                }
                TeamNameText.setText(teamList.getTeam(teamNum).getMatch(0).getTeamName());
            }
            catch(Exception ex)
            {
                MessageBox box = new MessageBox();
                box.show("Team '" + teamNum + "' not found.", "Error", this);
            }
        }
    }//GEN-LAST:event_GetDataButtonActionPerformed

    private void DevMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevMenuActionPerformed
        Developer dev = new Developer();
        dev.setVisible(true);
    }//GEN-LAST:event_DevMenuActionPerformed

    private void MatchesComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatchesComboBoxActionPerformed
        //int matchNum = Integer.parseInt(MatchesComboBox.getSelectedItem().toString());
        if(MatchesComboBox.getItemCount() > 0)
        {
            MatchData match = teamList.getTeam(curTeamNum).getMatch(MatchesComboBox.getSelectedIndex());
            
            ScoreSpinner.setValue(match.getOverallScore());
            GearsDeliveredSpinner.setValue(match.getGearsDelivered());
            BoilerSpinner.setValue(match.getBoilerScore());
            PenaltiesSpinner.setValue(match.getPenalties());
            StrategyTextBox.setText(match.getStrategy());
            
            switch(match.getShotAccuracy())
            {
                case "noShoot": ShotAccuracyComboBox.setSelectedIndex(0); break;
                case "low": ShotAccuracyComboBox.setSelectedIndex(1); break;
                case "medium": ShotAccuracyComboBox.setSelectedIndex(2); break;
                case "high": ShotAccuracyComboBox.setSelectedIndex(3); break;
            }
            switch(match.getResult())
            {
                case "win": resultComboBox.setSelectedIndex(0); break;
                case "tie": resultComboBox.setSelectedIndex(2); break;
                case "lose": resultComboBox.setSelectedIndex(1); break;
            }
            switch(match.getAutonomous())
            {
                case "noMove": autonomousComboBox.setSelectedIndex(0); break;
                case "moved": autonomousComboBox.setSelectedIndex(1); break;
                case "deliveredGear": autonomousComboBox.setSelectedIndex(2); break;
                case "shotBoiler": autonomousComboBox.setSelectedIndex(3); break;
                case "gearAndBoiler": autonomousComboBox.setSelectedIndex(4); break;
            }
            
            ClimbComboBox.setSelectedIndex(match.getClimbed() ? 1 : 0);
            
            if(match.getSpecialty().length > 0)
            {
                DeliveringGearsCheckBox.setSelected(match.containsSpecialty("deliverGears") ? true : false);
                BottomBoilerCheckBox.setSelected(match.containsSpecialty("shootTop") ? true : false);
                TopBoilerCheckBox.setSelected(match.containsSpecialty("shootBottom") ? true : false);
                ClimbingCheckBox.setSelected(match.containsSpecialty("climbing") ? true : false);
            }
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_MatchesComboBoxActionPerformed

    private void ShotAccuracyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShotAccuracyComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShotAccuracyComboBoxActionPerformed

    private void TeamNumberTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeamNumberTextKeyPressed

    }//GEN-LAST:event_TeamNumberTextKeyPressed

    private void TeamNumberTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TeamNumberTextKeyReleased
        String teamNum = TeamNumberText.getText();
        
        try
        {
            Integer.parseInt(teamNum);
            GetDataButton.setEnabled(true);
            
        }
        catch(Exception ex)
        {
            GetDataButton.setEnabled(false);
        }
    }//GEN-LAST:event_TeamNumberTextKeyReleased

    private void syncFromWebMENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syncFromWebMENUActionPerformed
        try
        {
            JsonParsing json = new JsonParsing(Net.PostRequestOutput("http://monixgameware.com/scout/core/sync/sync.php", "key=panth3r"));

            if(teamList == null || teamList.isEmpty())
            {
                RoboticsHashMap newMap = new RoboticsHashMap();
                teamList = Sync.sync(newMap, json.getMasterList());

            }
            else
            {
                teamList = json.getMasterList();
            }
            
            JsonWriting.writeJsonToFile(teamList, masterListPath);
            
            MessageBox box = new MessageBox();
            box.show("Synced successfully.", "Success", this);
        }
        catch(Exception ex)
        {
            MessageBox box = new MessageBox();
            box.show("Error Parsing the JSON.", "Error", this);
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_syncFromWebMENUActionPerformed

    private void resultComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultComboBoxActionPerformed

    private void ClimbComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClimbComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClimbComboBoxActionPerformed
    
        /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scout().setVisible(true);
            }
        });
    }
    private void setMatchDataFromUI(){
         String teamNum = TeamNumberText.getText().trim();
         
         if(teamNum == null || teamNum.isEmpty())
         {
             MessageBox box = new MessageBox();
             box.show("Please Add TeamNumber", "Error", this);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AveragePanel;
    private javax.swing.JLabel BoilerLabel;
    private javax.swing.JSpinner BoilerSpinner;
    private javax.swing.JCheckBox BottomBoilerCheckBox;
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel ClimabilityLabel;
    private javax.swing.JComboBox<String> ClimbComboBox;
    private javax.swing.JCheckBox ClimbingCheckBox;
    private javax.swing.JPanel ComboBoxPanel;
    private javax.swing.JCheckBox DeliveringGearsCheckBox;
    private javax.swing.JButton DevMenu;
    private javax.swing.JLabel GearsDeliveredLabel;
    private javax.swing.JSpinner GearsDeliveredSpinner;
    private javax.swing.JButton GetDataButton;
    private javax.swing.JComboBox<String> MatchesComboBox;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JPanel Panel;
    private javax.swing.JLabel PenaltiesLabel;
    private javax.swing.JSpinner PenaltiesSpinner;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JSpinner ScoreSpinner;
    private javax.swing.JComboBox<String> ShotAccuracyComboBox;
    private javax.swing.JLabel ShotAccuracyLabel;
    private javax.swing.JLabel SpecialtiesLabel;
    private javax.swing.JPanel SpecialtiesPanel;
    private javax.swing.JScrollPane Strategy;
    private javax.swing.JLabel StrategyLabel;
    private javax.swing.JTextPane StrategyTextBox;
    private javax.swing.JLabel TeamNameLabel;
    private javax.swing.JTextField TeamNameText;
    private javax.swing.JLabel TeamNumberLabel;
    private javax.swing.JTextField TeamNumberText;
    private javax.swing.JPanel TeamPanel;
    private javax.swing.JCheckBox TopBoilerCheckBox;
    private javax.swing.JComboBox<String> autonomousComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JMenuItem leaderboardMENU;
    private javax.swing.JComboBox<String> resultComboBox;
    private javax.swing.JMenu statsMENU;
    private javax.swing.JMenuItem syncFromWebMENU;
    // End of variables declaration//GEN-END:variables
}
