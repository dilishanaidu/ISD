import java.awt.*;       
import java.awt.event.*; 
import javax.swing.*;    
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class Showshape extends JFrame {
 
   public static final int width = 350;
   public static final int height = 350;
 
   
   private JTextField t;
   private Font f;
   private int fntstyle = Font.PLAIN;
   private DrawCanvas canvas; 
   private String msg ="Hello World";
   String[] fontstyleItems = new String[] {"Regular","Italic", "Bold","Bold&Italic"};
   private JButton fgcolor, bgcolor;
   private JButton rec,Oval,roundrec;
   private Color c = Color.BLACK;
   private Color c1 = Color.GREEN;
   private int sz = 20,X1= 300,Y1 = 300;
   private String shape = "RECT";
   public Showshape() {
	  JPanel panel = new JPanel(new FlowLayout());
	  
	  
      JPanel pn = new JPanel(new FlowLayout());
      JPanel pn1 = new JPanel();
      BoxLayout boxLayout = new BoxLayout(pn1, BoxLayout.Y_AXIS);
      pn1.setLayout(boxLayout);
      panel.add(pn1);
	  panel.add(pn);
      DocumentListener dl = new DocumentListener() {

		@Override	
		public void insertUpdate(DocumentEvent e) {
			
			msg = t.getText();
			canvas.repaint();
			
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			
			msg = t.getText();
			canvas.repaint();
		
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			
			msg = t.getText();
			canvas.repaint();
			
		}
      };
      JLabel label = new JLabel("Message"); 
      pn.add(label);
      t =new JTextField(15);
      pn.add(t);
      t.getDocument().addDocumentListener(dl); 	 
      
      SpinnerModel spinnerModel = new SpinnerNumberModel(sz,10,30,1);
      JSpinner spinner = new JSpinner(spinnerModel);
      spinner.addChangeListener(new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			sz = (int) spinnerModel.getValue();
			canvas.repaint();
		}
      }); 
      pn.add(spinner);
      
      JComboBox<String> fontstyleList = new JComboBox<>(fontstyleItems);
      fontstyleList.setAlignmentX(Component.LEFT_ALIGNMENT);
      pn.add(fontstyleList);
      fontstyleList.setMaximumSize( fontstyleList.getPreferredSize() );
      //shapeList.setSelectedItem("R");
      
      fontstyleList.addActionListener(new ActionListener() {
    	  
    	    @Override
    	    public void actionPerformed(ActionEvent event) {
    	        JComboBox<String> combo = (JComboBox<String>) event.getSource();
    	        String selectedfontstyle = (String) combo.getSelectedItem();
    	 
    	        if (selectedfontstyle.equals("Regular")) {
    	        	fntstyle =Font.PLAIN; canvas.repaint();
    	        } else if (selectedfontstyle.equals("Italic")) {
    	            //System.out.println("Nice pick, too!");
    	        	fntstyle =Font.ITALIC; canvas.repaint();
    	        }
    	        else if(selectedfontstyle.equals("Bold"))
    	        {fntstyle =Font.BOLD; canvas.repaint(); }
    	        else if(selectedfontstyle.equals("Bold&Italic"))
    	        {fntstyle =Font.BOLD+Font.ITALIC; canvas.repaint(); }
    	    }
    	});

    	      fgcolor = new JButton("foregroundcolor");
    	      pn1.add(fgcolor);
    	      fgcolor.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            c = JColorChooser.showDialog(Showshape.this,"Please choose a color",c);
    	             if(c == null)
    	             {
    	            	 c = c.BLACK;
    	             }
    	             canvas.repaint();
    	          }
    	      });
    	      
    	      bgcolor = new JButton("backgroundcolor");
    	      pn1.add(bgcolor);
    	      bgcolor.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            c1 = JColorChooser.showDialog(Showshape.this,"Please choose a color",c1);
    	             if(c1 == null)
    	             {
    	            	 c1 = c.RED;
    	             }
    	             canvas.repaint();
    	          }
    	      });
    	      
    	      rec = new JButton("Rectangle");
    	      pn1.add(rec);
    	      rec.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            shape ="RECT"; canvas.repaint(); }
    	      });
    	      
    	      Oval = new JButton("Oval");
    	      pn1.add(Oval);
    	      Oval.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            shape ="OVAL"; canvas.repaint(); }
    	      });
    	      
    	      roundrec = new JButton("RoundedRectangle");
    	      pn1.add(roundrec);
    	      roundrec.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            shape = "ROUNDRECT"; canvas.repaint(); }
    	      });
      
    	      SpinnerModel spinnerModel1 = new SpinnerNumberModel(100,50,300,1);
    	      JSpinner spinner1 = new JSpinner(spinnerModel1);
    	      spinner1.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					X1 = (int) spinnerModel1.getValue();
					canvas.repaint();
				}
    	      }); 
    	      
    	      pn1.add(spinner1);
    	      
    	      SpinnerModel spinnerModel2 = new SpinnerNumberModel(100,50,300,1);
    	      JSpinner spinner2 = new JSpinner(spinnerModel2);
    	      spinner2.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					Y1 = (int) spinnerModel2.getValue();
					canvas.repaint();
				}
    	      }); 
    	      pn1.add(spinner2);
    	      
      // Set up a custom drawing JPanel
      canvas = new DrawCanvas();
      canvas.setPreferredSize(new Dimension(width, height));
 
     
      Container cp = getContentPane();
		/*
		 * cp.setLayout(new BorderLayout()); cp.add(canvas, BorderLayout.CENTER);
		 * cp.add(pn, BorderLayout.NORTH); cp.add(pn1, BorderLayout.SOUTH);
		 */
      
      cp.setLayout(new GridLayout(0,2));
      cp.add(panel);
      cp.add(canvas);
    
      
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      setTitle("ShowShape");
      pack();           
      setVisible(true); 
      requestFocus();   
   }
 
   class DrawCanvas extends JPanel {
      @Override
      public void paintComponent(Graphics g) {
         super.paintComponent(g);
         f = new Font("TimesRoman",fntstyle,sz);
         setFont(f);
         setBackground(c1);
         g.setColor(c);
         FontMetrics fm = g.getFontMetrics();
		    int x = (getWidth() - fm.stringWidth(msg))/2;
		    int y = (getHeight()/2)+ fm.getDescent();
         
         if(shape.equals("OVAL"))
			{
				g.drawOval((getWidth()-X1)/2,(getHeight()-Y1)/2,X1,Y1);
				g.drawString(msg, x,y);
			}
			else if(shape.equals("RECT"))
			{
				g.drawRect((getWidth()-X1)/2,(getHeight()-Y1)/2,X1,Y1);
				g.drawString(msg, x,y);
			}
			else if(shape.equals("ROUNDRECT"))
			{
				g.drawRoundRect((getWidth()-X1)/2,(getHeight()-Y1)/2,X1,Y1,40,40);
				g.drawString(msg, x,y);
			}
			else
			{
				g.drawRect((getWidth()-X1)/2,(getHeight()-Y1)/2,X1,Y1);
				g.drawString(msg, x,y);
			}
      if(fm.stringWidth(msg) > Y1)
      {
    	  sz = 10;
    	  f = new Font("TimesRoman",fntstyle,sz);
          setFont(f);
      }
      
      }
   }
 
   public static void main(String[] args) {
     
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            new Showshape();
            }
      });
   }
}

 

