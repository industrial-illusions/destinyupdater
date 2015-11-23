package org.destiny.updater;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import org.ini4j.Ini;

public class Updater {
	private static String TITLE, UPDATER_HASH;
	private static Updater m_instance;
	private JFrame m_gui;
	private JLabel m_info;
	private JButton m_start, m_stop, m_exit;
	public static boolean DEBUG = true;
	public static String REMOTEINI, REMOTEPATH, REMOTENEWS;
	
	
	public  Updater() {
		//loadConfigs();
		if(Updater.DEBUG){System.out.print("Git Hash: "+ getUpdaterHash());}
		createGui();
		
		
	}
	
	public static void main(String [ ] args) throws FileNotFoundException, IOException {
		Updater.initUpdater();
	
	}
	
	public static void initUpdater() {
		m_instance = new Updater();
		
	}
	
	public static Updater getInstance() {
		return m_instance;
	}
	
	
	private void createGui(){
		
		m_gui = new JFrame();
		m_gui.setTitle("Pokemon Destiny Updater");
		m_gui.setSize(600, 700);
		m_gui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		m_gui.getContentPane().setLayout(null);
		m_gui.setResizable(false);
		m_gui.setLocationRelativeTo(null);
		
		m_stop = new JButton("Exit");
		m_stop.setSize(128, 24);
		m_stop.setLocation(450, 600);
		m_stop.setEnabled(true);
		m_stop.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				stop();
			}
		});
		m_gui.getContentPane().add(m_stop);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		m_gui.setVisible(true);
		
	}
	
	
	
	
	
	
	public void stop(){
		System.exit(0);
	}
	
	
	
//	public void loadConfigs() throws FileNotFoundException, IOException
//	{
//		Ini configIni = new Ini(new FileInputStream("conf/settings.ini"));
//		Ini.Section s = configIni.get("RATES");
//		RATE_GOLD = Double.parseDouble(s.get("GOLD"));
//	}
	
	private static String getUpdaterHash()
	{
		String hash = UPDATER_HASH;
		File file = new File(".git/refs/heads/master");
		try(Scanner sc = new Scanner(file))
		{
			hash = sc.nextLine();
		}
		catch(FileNotFoundException fnfe)
		{
			fnfe.printStackTrace();
		}
		
		return hash;
	}
}