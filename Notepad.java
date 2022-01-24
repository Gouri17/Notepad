 import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.net.*;
import java.awt.datatransfer.*;

public class Notepad1 extends JFrame
{	
	
	MenuBar mb;
	Menu m1,m2,m3,m4,m5,m6,m7;
	MenuShortcut n,s,e,c,a,x,p;
        int f_size;
	Font f;
	String str;
	int sx,sy;
	Label l;
	public TextArea t;
	public Notepad1()
  	{
	
		

		mb=new MenuBar();
 	//menus
		 m1=new Menu("File");
		 m2=new Menu("Edit");
		 m3=new Menu("Format");
		 m4=new Menu("View");
		 m5=new Menu("Style");
		 m6=new Menu("Font");
		 m7=new Menu("Help");
		
	
	//menu items
        	MenuItem m1_1=new MenuItem("New...");
		MenuItem m1_2=new MenuItem("Open...");
		MenuItem m1_3=new MenuItem("Save...");
		MenuItem m1_4=new MenuItem("Save As...");
		MenuItem m1_5=new MenuItem("Exit...");
		MenuItem m2_1=new MenuItem("Cut");
		MenuItem m2_2=new MenuItem("Copy");
		MenuItem m2_3=new MenuItem("Copy All");
		MenuItem m2_4=new MenuItem("Paste");
		
        	MenuItem m5_1=new MenuItem("Itallic");
		MenuItem m5_2=new MenuItem("Bold");
		MenuItem m5_3=new MenuItem("Plain");
		MenuItem m7_1=new MenuItem("About Notepad");
		
	//menu shortcut
		n= new MenuShortcut(KeyEvent.VK_N);//for new
		s= new MenuShortcut(KeyEvent.VK_S);//for save
		e= new MenuShortcut(KeyEvent.VK_E);//for exit
		c= new MenuShortcut(KeyEvent.VK_C);//for copy
		a= new MenuShortcut(KeyEvent.VK_A);//for copy all
		x= new MenuShortcut(KeyEvent.VK_X);//for cut
		p= new MenuShortcut(KeyEvent.VK_P);//for paste	
	
	//setting shortcut for new
		m1_1.setShortcut(n);
	
	//setting shortcut for save
		m1_3.setShortcut(s);
	
	//setting shortcut for exit
		m1_5.setShortcut(e);
	
	//setting shortcut for cut
		m2_1.setShortcut(x);
	
	//setting shortcut for copy
		m2_2.setShortcut(c);
	
	//setting shortcut for copy all
		m2_3.setShortcut(a);
	    
	//setting shortcut for paste
		m2_4.setShortcut(p);
	
	//checkbox
		CheckboxMenuItem c1=new CheckboxMenuItem("Word Wrap",false);
		
		CheckboxMenuItem c2=new CheckboxMenuItem("Status Bar",false);
	
	//font_sizes
		CheckboxMenuItem f_c1=new CheckboxMenuItem("10");
		CheckboxMenuItem f_c2=new CheckboxMenuItem("20");
		CheckboxMenuItem f_c3=new CheckboxMenuItem("30");
		CheckboxMenuItem f_c4=new CheckboxMenuItem("40");
		CheckboxMenuItem f_c5=new CheckboxMenuItem("50");



	//menu adding
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		mb.add(m5);
		mb.add(m6);
		mb.add(m7);
		

	//menu item adding
		m1.add(m1_1);
		m1.addSeparator();
		m1.add(m1_2);
		m1.addSeparator();
		m1.add(m1_3);
		m1.addSeparator();
		m1.add(m1_4);
		m1.addSeparator();
		m1.add(m1_5);
		m2.add(m2_1);
		m2.addSeparator();
		m2.add(m2_2);
		m2.addSeparator();
		m2.add(m2_3); 
		m2.addSeparator();
		m2.add(m2_4); 
 		m3.add(c1);
		m4.add(c2);
		m5.add(m5_1);
		m5.addSeparator();
		m5.add(m5_2);
		m5.addSeparator();
		m5.add(m5_3);	
		m6.add(f_c1);
		m6.add(f_c2);
		m6.add(f_c3);
		m6.add(f_c4);
		m6.add(f_c5);
		m7.add(m7_1);
		setMenuBar(mb);
	
	


	//Jtextarea
		Container c=getContentPane();
	                  t=new TextArea("WELCOME..!! ",10,20,Scrollbar.VERTICAL);
		add(t);
		t.setEditable(true);
		t.setBackground(Color.white);
        		t.setForeground(Color.black);
		
	
	// for new
		m1_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			t.setText(" ");
		}
		});
	
	// for open
		m1_2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			JFileChooser jf=new JFileChooser(new File("D:\\"));
			jf.setDialogTitle("Open a File..");
			int result=jf.showOpenDialog(null);
			if(result==JFileChooser.APPROVE_OPTION)
			{
				try
				{
					File f=jf.getSelectedFile();
					BufferedReader br=new BufferedReader(new FileReader(f.getPath()));
					String s=" ";
					String line=" ";
					String x=" ";
					while((line=br.readLine())!=null)
					{
						s+=line;
					}
					t.setText(x);
					t.setText(s);
				}
				catch(Exception e)
				{}
			}
		}
		});		

	// for save
		m1_3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			String fname=JOptionPane.showInputDialog("Enter file name:-");
			String st=t.getText();
			Save ss=new Save(st,fname);
		}
		});

	// for save_as
		m1_4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			String fname=JOptionPane.showInputDialog("Enter file name:-");
			String st=t.getText();
			Save ss=new Save(st,fname);
		}
		});
	
	// for exit
		m1_5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
				System.exit(0);
		}
		});	


	//for cut
		m2_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			String s=t.getSelectedText();
			t.setText(t.getText().replace(s,""));
		}
		});	

	//for copy
		m2_2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
				
			 str=t.getSelectedText();
			//Copy c=new Copy();
			System.out.println(" COPY:-"+str);
			
		}
		});
	
	//for copy all
		m2_3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			String s1=t.getText();
			System.out.println(" COPY ALL :-"+s1);
		}
		});
	
	//for paste
		m2_4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			
			//String s2=t.getSelectedText();
			//if(s2.length()==0)
			//System.out.println("Please select the text and copy option");
			//String s1=t.getText();
			//Copy c1=new Copy();
			//t.setText(s1 + s2);
			String s1=t.getText();
			if(str.equals(null))	
			System.out.println("Please select the text and copy option");
			else
			t.setText(s1+str);
		}

		});	
	
	/*// for word-wrap
		c2.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent me)
		{
			if(c1.getState()==true)
			{
				t.setLineWrap(true);
				t.setWrapStyleWord(true);				
			}
			if(c1.getState()==false)
			{
				t.setLineWrap(false);
				t.setWrapStyleWord(false);	
			}
			
		}
		});*/	


	
	//
		t.addMouseMotionListener(new MouseMotionAdapter(){
		public void mouseMoved(MouseEvent me)
		{
			 sx=me.getX();
			 sy=me.getY();
		}
		});

	// for status_bar
		c2.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent me)
		{
			if(c2.getState()==true)
			{
			//Graphics g=getGraphics();
			//String z="";
			t.setText("line  " + sx + " col  " + sy);
			}
			c2.setState(false);
		}
		});	




	//for italic
		m5_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			Font f1=new Font("Courier",Font.ITALIC,20);
			String si=t.getSelectedText();
			t.setFont(f1);		
		}
		});

	
	//for Bold
		m5_2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			Font f2=new Font("Courier",Font.BOLD,20);
			String si=t.getSelectedText();
			System.out.println("selected text:-"+si);
			t.setFont(f2);		
		}
		});

	//for Plain
		m5_3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
			Font f3=new Font("Courier",Font.PLAIN,20);
			String si=t.getSelectedText();
			System.out.println("selected text:-"+si);
			t.setFont(f3);		
		}

		});
		
	// for f_c1
		f_c1.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie)
		{
			if(f_c1.getState()==true)
			{
			f_size=10;
			f=new Font("Courier",Font.PLAIN,f_size);
			t.setFont(f);
			}
			f_c1.setState(false);
		}
		});
	
	// for f_c2
		f_c2.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie)
		{
			if(f_c2.getState()==true)
			{
			f_size=20;
			f=new Font("Courier",Font.PLAIN,f_size);
			t.setFont(f);
			}
			f_c2.setState(false);
		}
		});
	
	// for f_c3
		f_c3.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie)
		{
			if(f_c3.getState()==true)
			{
			f_size=30;
			f=new Font("Courier",Font.PLAIN,f_size);
			t.setFont(f);
			}
			f_c3.setState(false);
		}
		});

	// for f_c4
		f_c4.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie)
		{
			if(f_c4.getState()==true)
			{
			f_size=40;
			f=new Font("Courier",Font.PLAIN,f_size);
			t.setFont(f);
			}
			f_c4.setState(false);
		}
		});

	// for f_c5
		f_c5.addItemListener(new ItemListener(){
		public void itemStateChanged(ItemEvent ie)
		{
			if(f_c5.getState()==true)
			{
			f_size=50;
			f=new Font("Courier",Font.PLAIN,f_size);
			t.setFont(f);
			}
			f_c5.setState(false);
		}
		});
            
               

	         }	
        


	public static void main(String args[])
	{
	        Notepad1 n1=new Notepad1();
		n1.setIconImage(new ImageIcon("Notepad_icon.png").getImage());
		n1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		n1.setVisible(true);
		n1.setTitle("My Notepad");
		n1.setSize(500,500);
         }
	
	}

	//for save	
		class Save
		{
	        	Save(String st,String f)
			{
				char ch[]=st.toCharArray();
				int i;
				try
				{
					FileOutputStream fout=new FileOutputStream(f+".txt");
					for(i=0;i<st.length();i++)
					{
						fout.write(ch[i]);
					}
					fout.close();
				}
				catch(Exception e)
				{
				}
			}
		}