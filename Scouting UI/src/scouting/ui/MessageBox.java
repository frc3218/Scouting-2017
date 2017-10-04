package scouting.ui;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.Window;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MessageBox
{
    public void show(String message, String title, Window window)
    {
        MatchData match = new MatchData();
        JDialog messageBox = new JDialog(window, title,Dialog.ModalityType.APPLICATION_MODAL);
        JLabel messageLabel = new JLabel(message);
        Border padding = BorderFactory.createEmptyBorder(10,10,10,10);
        messageLabel.setBorder(padding);
        messageBox.add(messageLabel);
        messageBox.pack();
        Point uiLocation = window.getLocation();
        //Centers the message box in the UI
        Point messageBoxLocation = new Point ((int)((window.getWidth()/2) + uiLocation.getX() - (messageBox.getWidth()/2)),(int)((window.getHeight()/2) + uiLocation.getY() - (messageBox.getHeight()/2)));
        messageBox.setLocation(messageBoxLocation);
        messageBox.setVisible(true);
    }
}