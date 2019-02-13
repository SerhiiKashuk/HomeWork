package mate.academy.view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class SelectedListCellRenderer extends DefaultListCellRenderer {
	  public SelectedListCellRenderer() {
		JProgressBar jpb = new JProgressBar();
     jpb.setIndeterminate(true);
     add(jpb);
	}
     
 
  @Override
  public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
      Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
      if (isSelected) {
          c.setBackground(Color.CYAN);
      }
      return c;
  }
}