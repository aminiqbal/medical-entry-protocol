package com.am1n.mep;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

// AM1N
public class MEPMain
{
	private String mepid;
	private MEPDBInterface dbinterface;

	public MEPMain(String id) throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		mepid = id;
		new File(System.getProperty("user.home") + "/mep/" + mepid + "/mepdb").mkdirs();
		Font appFont = new Font(Font.MONOSPACED, Font.PLAIN, 14);
		GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(appFont);
		JFrame mainwin = new JFrame();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int dwidth = (int)d.getWidth();
		int dheight = (int)d.getHeight();
		int w = (int)(dwidth / 2);
		int h = (int)(dheight / 2);
		mainwin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		mainwin.setSize(w, h);
		mainwin.setLayout(new GridBagLayout());
		mainwin.setResizable(false);
		mainwin.setLocationRelativeTo(null);
		mainwin.setTitle("Medical Entry Protocol");

		dbinterface = new MEPDBInterface(mepid);

		mainwin.setVisible(true);
	}

	public void end()
	{
		dbinterface.terminate();
	}
}
