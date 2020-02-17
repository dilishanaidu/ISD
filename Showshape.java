package Assignment1;


import java.awt.*;       
import java.awt.event.*; 
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import static javax.swing.GroupLayout.Alignment.*;

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
   String[] fontsizeItems = new String[] {"8","10","12","14","16","18","20","22","24","26","28","30"};
   private JRadioButton rec, oval,roundrec;
   
   private JButton fgcolor, bgcolor;
   //private JButton rec,Oval,roundrec;
   private Color c = Color.BLACK;
   private Color c1 = Color.GREEN;
   private int sz = 12,X1= 300,Y1 = 300;
   private String shape = "RECT";
   public Showshape() {
	  JPanel panel = new JPanel(new FlowLayout());
	  
	  
      JPanel pn = new JPanel(new FlowLayout());
      JPanel pn1 = new JPanel();
      //BoxLayout boxLayout = new BoxLayout(pn1, BoxLayout.Y_AXIS);
      
      GroupLayout groupLayout = new GroupLayout(pn1); 
      JSeparator s = new JSeparator(); 
      s.setOrientation(SwingConstants.HORIZONTAL); 
      
      
      
	  
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
      
      JComboBox<String> fontsizeList = new JComboBox<>(fontsizeItems);
      fontsizeList.setAlignmentX(Component.LEFT_ALIGNMENT);
      pn.add(fontsizeList);
      fontsizeList.setMaximumSize( fontsizeList.getPreferredSize() );
      //shapeList.setSelectedItem("R");
      
      fontsizeList.addActionListener(new ActionListener() {
    	  
    	    @Override
    	    public void actionPerformed(ActionEvent event) {
    	        JComboBox<String> combo = (JComboBox<String>) event.getSource();
    	        String selectedfontsize = (String) combo.getSelectedItem();
    	 
    	        if (selectedfontsize.equals("8")) {
    	        	sz= 8; canvas.repaint();	
    	        }
    	        else if (selectedfontsize.equals("10")) {
    	        	sz=10; canvas.repaint();
    	        }else if (selectedfontsize.equals("12")) {
    	        	sz=12; canvas.repaint();
    	        }else if (selectedfontsize.equals("14")) {
    	        	sz=14; canvas.repaint();
    	        }else if (selectedfontsize.equals("16")) {
    	        	sz=16; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("18")) {
    	        	sz=18; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("20")) {
    	        	sz=20; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("22")) {
    	        	sz=22; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("24")) {
    	        	sz=24; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("26")) {
    	        	sz=26; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("28")) {
    	        	sz=28; canvas.repaint();
    	        }
    	        else if (selectedfontsize.equals("30")) {
    	        	sz=30; canvas.repaint();
    	        }
    	    }
    	});
      
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
    	      //pn1.add(fgcolor);
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
    	      //pn1.add(bgcolor);
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
    	      
    	      ButtonGroup group = new ButtonGroup();
    	      rec = new JRadioButton("Rectangle");
    	      group.add(rec);
    	      pn1.add(rec);
    	      rec.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            shape ="RECT"; canvas.repaint(); }
    	      });
    	      
    	      oval = new JRadioButton("Oval");
    	      pn1.add(oval);
    	      group.add(oval);
    	      oval.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            shape ="OVAL"; canvas.repaint(); }
    	      });
    	      
    	      roundrec = new JRadioButton("RoundedRectangle");
    	      pn1.add(roundrec);
    	      group.add(roundrec);
    	      roundrec.addActionListener(new ActionListener() {
    	            public void actionPerformed(ActionEvent evt) {
    	            shape = "ROUNDRECT"; canvas.repaint(); }
    	      });
      
    	      SpinnerModel spinnerModel1 = new SpinnerNumberModel(100,50,500,50);
    	      JLabel shapeWidthLabel = new JLabel("Shape Width"); 
    	      JSpinner shapeWidth = new JSpinner(spinnerModel1);
    	      shapeWidth.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					X1 = (int) spinnerModel1.getValue();
					canvas.repaint();
				}
    	      }); 
    	      
    	      //pn1.add(spinner1);
    	      
    	      SpinnerModel spinnerModel2 = new SpinnerNumberModel(100,50,500,50);
    	      JLabel shapeHeightLabel = new JLabel("Shape Height");
    	      JSpinner shapeHeight = new JSpinner(spinnerModel2);
    	      shapeHeight.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					Y1 = (int) spinnerModel2.getValue();
					canvas.repaint();
				}
    	      }); 
    	      //pn1.add(spinner2);
    	      
    	      JLabel shapeAttributes = new JLabel("Shape Attributes");
    	      JLabel textAttributes = new JLabel("Text Attributes");
    	      JLabel fontSizeLabel = new JLabel("Font Size");
    	      JLabel fontStyleLabel = new JLabel("Font Style");
    	     
    	      
    	      TitledBorder shapeBorder = BorderFactory.createTitledBorder("Shape Attributes");
    	      TitledBorder textBorder = BorderFactory.createTitledBorder("Text Attributes");
    	      
    	      
    	      groupLayout.setAutoCreateGaps(true);
    	      groupLayout.setAutoCreateContainerGaps(true); 
    	     
    	      groupLayout.setHorizontalGroup(
    	    		  groupLayout.createSequentialGroup() 
    	    		  .addGroup(groupLayout.createParallelGroup(LEADING)
    	    				  .addComponent(label)
    	    				  .addGroup(groupLayout.createParallelGroup(LEADING)
    	    						  .addGroup(groupLayout.createSequentialGroup() 
    	    								  .addComponent(shapeAttributes)
    	    								  )
    	    						  .addComponent(rec) 
    	  	        				  .addComponent(oval) 
    	  	        				  .addComponent(roundrec)
    	  	        				 
    	    						  )

    	    				  .addComponent(textAttributes)
    	    				  .addComponent(fontStyleLabel)
    	    				  .addComponent(fontSizeLabel)
    	    				  
    	    				  )
    	    		  

    	    	        .addGroup(groupLayout.createParallelGroup(LEADING)
    	    	        		.addComponent(t)
    	    	        		.addGroup(groupLayout.createSequentialGroup()
    	    	        		.addComponent(bgcolor)
    	    	        		.addComponent(fgcolor))
    	    	        		.addGroup(groupLayout.createParallelGroup(TRAILING)
    	    	        				.addGroup(groupLayout.createSequentialGroup() 
    		  	        						.addComponent(shapeHeightLabel)
    		  	        						.addComponent(shapeHeight)
    		  	        						  )
    		  	        				.addGroup(groupLayout.createSequentialGroup() 
    		  	        						.addComponent(shapeWidthLabel)
    		  	        						.addComponent(shapeWidth)
    		  	        						  )
    	    	        				)
    	    	        		
    	        				.addComponent(fontstyleList)
    	        				.addComponent(fontsizeList)
    	        				
    	    	        		)
    	    	        );
    	    	  
    	    	   
    	      
    	      groupLayout.setVerticalGroup(groupLayout.createSequentialGroup() 
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE) 
    	    	        // Adding the JButton "btn1"
    	    		  	.addComponent(label)
    	    		  	.addComponent(t))
    	    		  
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE).addGap(50)
    	    		  	.addComponent(bgcolor)
    	      			.addComponent(fgcolor))
    	    		  
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE)
    	    				  .addComponent(shapeAttributes)
    	    				  )
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE).addGap(100)
    	    				  .addGroup(groupLayout.createSequentialGroup()
    	    	    	    		  .addComponent(rec)
    	    	    	    		  .addComponent(oval) 
    	    	    	    		  .addComponent(roundrec)	  
    	    						  )
    	    				  .addGroup(groupLayout.createSequentialGroup()
    	    						  .addGroup(groupLayout.createParallelGroup(BASELINE)
    	    								  .addComponent(shapeHeightLabel)
    	    								  .addComponent(shapeHeight)
    	    								  )
    	    						  .addGroup(groupLayout.createParallelGroup(BASELINE)
    	    								  .addComponent(shapeWidthLabel)
    	    								  .addComponent(shapeWidth)
    	    								  )
    	  	    	        		)

    	    				  )
    	    		  
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE)
    	    				  .addComponent(textAttributes)
    	    				  )
    	    		 
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE)
    	    				  .addComponent(fontStyleLabel)
  	        				.addComponent(fontstyleList))
    	    		  .addGroup(groupLayout.createParallelGroup(BASELINE)
    	    				  .addComponent(fontSizeLabel)
  	        				.addComponent(fontsizeList))
    	    		  
    	      			);
    	      
    	      groupLayout.linkSize(fontsizeList, fontstyleList);
    	      //groupLayout.linkSize(shapeHeight, shapeWidth);
    	      pn1.setLayout(groupLayout);
    	      //pn1.setSize(new Dimension(width, height));
    	      panel.setSize(new Dimension(width, height));
    	      //panel.add(pn);
    	      panel.add(pn1);
    	    		  
    	    		  
    	      
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
    	  msg = "Text too long";
    	  //sz = 12;
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
