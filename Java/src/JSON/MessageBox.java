package JSON;
import javax.swing.*;
import javax.swing.JOptionPane;

public class MessageBox
{
	public static void show(String message, String title, int type)
	{
		javax.swing.JOptionPane.showMessageDialog(null, message, title, type);
	}
}
