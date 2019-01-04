
package wjpgra;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


 public class PanelGry extends JPanel{
     OknoDialogowe dialog = new OknoDialogowe();
    public JButton opcje;
    public JButton rozpoczecie;
    public  JLabel czas;
    public JPanel panel1;
    public JLabel podpis;
    public JLabel poziom;
    public JPanel panel3;
    public JLabel lustra;
    public JLabel punkty;
    GStatus g;
     public static int time;
     public static boolean init;
    public PanelGry(){
      
        g = new GStatus();
        g.resetujpoziom();
        animationloop1(this);
         dodajpanelgry();
        setLayout(null);
       
      
       
       
    }
           public void animationloop1(PanelGry p){
        Timer t = new Timer();
        
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               if(init==true){
                PanelGry.time--;
               }
                p.revalidate();
               
                p.dodajpanelmenu(g);
              p.dodajpanelinfo(g,p);
              
                if(PanelGry.time==0){
                    
                
                }
            }
        }, 1000, 1000);
    }
    public void dodajpanelinfo(GStatus g,PanelGry p){
      
        panel1 = new JPanel();
       panel1.setLayout(new FlowLayout(FlowLayout.LEADING,50,5));
        panel1.setBackground(Color.cyan);
        panel1.setBounds(0, 0, 1024, 60);
        add(panel1);
   
        podpis = new JLabel("Gra Światłem do Celu®");
        podpis.setFont(new Font ("Noteworthy",Font.BOLD,30));
         podpis.setBounds(10, 0, 400, 60);
        panel1.add(podpis);
       
        czas = new JLabel("Pozostały czas: "+p.time+"/180");
        czas.setFont(new Font ("Noteworthy",Font.BOLD,30));
         czas.setBounds(410, 0, 300, 60);
        panel1.add(czas);
        
        poziom = new JLabel("Poziom: "+g.lvl);
        poziom.setFont(new Font ("Noteworthy",Font.BOLD,30));
        poziom.setBounds(720, 0, 300, 60);
        panel1.add(poziom);
      }   
        
    
    public void dodajpanelgry(){
       PanelwGrze pwg = new PanelwGrze();
        pwg.setBounds(0, 60,1024,643);
        add(pwg);
    }
       
    
    public void dodajpanelmenu(GStatus g){
         panel3 = new JPanel();
        panel3.setBackground(Color.cyan);
        panel3.setLayout(null);
        panel3.setBounds(0, 703, 1024, 65);
       
        lustra = new JLabel("Liczba luster: "+g.lustr);
        lustra.setFont(new Font ("Noteworthy",Font.BOLD,30));
        lustra.setBounds(50,5,250,55);
        panel3.add(lustra);
        
        punkty = new JLabel("Punkty: "+g.points);
        punkty.setFont(new Font ("Noteworthy",Font.BOLD,30));
        punkty.setBounds(300,5,150,55);
        panel3.add(punkty);

        opcje = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/menu.png"));
        opcje.setBounds(800,10,185,45);
        
        opcje.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                init=false;
         
         dialog.setVisible(true);
             
            }
        });
           
        panel3.add(opcje);
         rozpoczecie = new JButton(new ImageIcon("/Users/adamartemiuk/Desktop/start.png"));
        rozpoczecie.setBounds(600,10,185,45);
        panel3.add(rozpoczecie);
        add(panel3);
    }    
    

  }   

