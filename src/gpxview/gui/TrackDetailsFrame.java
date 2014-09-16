/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpxview.gui;

import gpx.Track;
import gpx.TrackPoint;
import gpx.TrackSegment;
import java.text.DateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Routz-15032012
 */
@SuppressWarnings("serial")
public class TrackDetailsFrame extends javax.swing.JFrame {

	/**
	 * Creates new form TrackDetailsFrame
	 */
	public TrackDetailsFrame() {
		this.track1 = null;
		this.df = DateFormat.getDateTimeInstance();
		initComponents();
	}
	
	public TrackDetailsFrame(gpx.Track t) {
		this.df = DateFormat.getDateTimeInstance();
		this.track1 = t;
		initComponents();
		fillTable();
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jTextField2 = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTable1 = new javax.swing.JTable();
                jButton1 = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jLabel1.setText("Track Name:");

                jTextField1.setEditable(false);
                jTextField1.setText(track1.getName());

                jTextField2.setEditable(false);
                jTextField2.setText(df.format(track1.getStartTime()));

                jLabel2.setText("Start Time:");

                jTable1.setModel(new TrackTableModel());
                jScrollPane1.setViewportView(jTable1);

                jButton1.setText("Close");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jButton1)))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		this.setVisible(false);
		this.dispose();                // TODO add your handling code here:
        }//GEN-LAST:event_jButton1ActionPerformed

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTable1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField jTextField2;
        // End of variables declaration//GEN-END:variables

	private final DateFormat df;
	private final Track track1;
	
	private void fillTable() {
		ArrayList<ArrayList<String>> d = new ArrayList<ArrayList<String>>();
		for (TrackSegment g : track1.getTrackSegmentList()) {
			for (TrackPoint tp : g.getTrackPointList()) {
				ArrayList<String> row = new ArrayList<String>(jTable1.getColumnCount());
				row.add(Double.toString(tp.getLat()));
				row.add(Double.toString(tp.getLon()));
				row.add(Double.toString(tp.getElevation()));
				row.add(df.format(tp.getTime()));
				d.add(row);
			}
		}
		((TrackTableModel) jTable1.getModel()).setTableData(d);
	}
	
	class TrackTableModel extends AbstractTableModel {

		ArrayList<ArrayList<String>> tableData;
		String[] columnNames = {"Latitude", "Longitude", "Elevation", "Time"};
		public Class<?>[] colTypes = {String.class,
			String.class,
			String.class,
			String.class};

		@Override
		public int getRowCount() {
			if (tableData != null) {
				return tableData.size();
			} else {
				return 0;
			}
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			return tableData.get(rowIndex).get(columnIndex);
		}
		
		public void setTableData(ArrayList<ArrayList<String>> data) {
			this.tableData = data;
			fireTableDataChanged();
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return colTypes[columnIndex];
			
		}
		
		@Override
		public String getColumnName(int column) {
			return columnNames[column];
		}
		
	}
}
