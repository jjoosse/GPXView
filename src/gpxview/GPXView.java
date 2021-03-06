/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gpxview;

import gpx.GpxFile;
import gpxview.gui.GuiFrame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author Routz-15032012
 */
public class GPXView {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		try {
			GpxFile gpx = GpxFile.ReadGPXFile(new File(args[0]));
			System.out.println(gpx.toString());
		} catch (FileNotFoundException ex) {
			Logger.getLogger(GPXView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (XMLStreamException ex) {
			Logger.getLogger(GPXView.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(GPXView.class.getName()).log(Level.SEVERE, null, ex);
		}
		
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
			java.util.logging.Logger.getLogger(GuiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GuiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GuiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GuiFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
	/* Open main Guiframe */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GuiFrame().setVisible(true);
			}
		});
	}
	
}
