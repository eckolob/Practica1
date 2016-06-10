import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JOptionPane;



public class Interfaz extends JFrame implements ActionListener
{
	
	 Proceso pr= new Proceso();
	 Lote l= new Lote();
	 String resultado="";
	 int i=1;	
	 
	 
 	public Interfaz()
 	{
 		
 		VentanaCreaProceso();
 	
 		
 	}
 	
 	
 	public void VentanaPrincipal()
 	{
 		JFrame simulador = new JFrame("Simula procesamiento por lotes");
 		simulador.setVisible(true);
 		simulador.setResizable(false);
 		simulador.setSize(600,300);
 		simulador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	}
 	
 	
 	public void VentanaCreaProceso()
 	{
 		
 	    JFrame Crearproceso = new JFrame("Crear proceso");
 	    //FlowLayout pruebafl = new FlowLayout();
 	    Crearproceso.setLayout(new GridLayout(4,2));
 	    
 	    //DECLARACION DE COMPONENTES
 	    
 	    
 	     JLabel et_programador,et_idProceso,et_tme,et_operacion,et_numeros;
 	     JButton btn_crear,btn_cancelar;
 	     JTextField txt_programador,txt_idProceso,txt_tme,txt_num1,txt_num2;
 	     
 	    // String[] lista={"Suma","Resta","Multiplicacion","Division","Residuo","Potencia"};
		 JRadioButton rbtn1;
		 JRadioButton rbtn2;
		 JRadioButton rbtn3;
		 JRadioButton rbtn4;
		 JRadioButton rbtn5;
		 JRadioButton rbtn6;
 	    
 	    //Creacion de componentes
 	     et_programador = new JLabel("Programador:");
 	     et_idProceso = new JLabel("Id Proceso:");
 	     et_tme		= new JLabel("TME:");
 	     et_operacion=new JLabel("Operacion:");
 	     et_numeros 		=new JLabel("Ingresa dos numeros");
 	      rbtn1=new JRadioButton("Suma",false);
		  rbtn2=new JRadioButton("Resta",false);
		  rbtn3=new JRadioButton("Multiplicacion",false);
		  rbtn4=new JRadioButton("Division",false);
		  rbtn5=new JRadioButton("Residuo",false);
		  rbtn6=new JRadioButton("Potencia",false);
 	     
 	 
 	     
 	     txt_programador = new JTextField(12);
 	     txt_idProceso   = new JTextField(2);
 	     txt_tme		 = new JTextField(4);
 	     txt_num1		 = new JTextField(4);
 	     txt_num2		 = new JTextField(4);
 	     
 	     
 	     
 	     
 	     btn_crear = new JButton("Crear");
 	     btn_cancelar = new JButton("Cancelar");
 	     
 	     
        //añadir componentes a la ventana
        
        	Crearproceso.add(et_programador);
        	Crearproceso.add(txt_programador);
        	
        	Crearproceso.add(et_idProceso);
        	Crearproceso.add(txt_idProceso);
        	
        	Crearproceso.add(et_tme);
        	Crearproceso.add(txt_tme);
        	
        	Crearproceso.add(et_operacion);
        	Crearproceso.add(rbtn1);
        	Crearproceso.add(rbtn1);
		 Crearproceso.add(rbtn2);
		 Crearproceso.add(rbtn3);
		 Crearproceso.add(rbtn4);
		 Crearproceso.add(rbtn5);
		 Crearproceso.add(rbtn6);
        	
        	Crearproceso.add(et_numeros);
        	Crearproceso.add(txt_num1);
        	Crearproceso.add(txt_num2);
        	
        	
        
        	Crearproceso.add(btn_crear);
        	Crearproceso.add(btn_cancelar);
        	
        	
 
        
        
			
        
 	   Crearproceso.setVisible(true);
 		Crearproceso.pack();
  		//Crearproceso.setSize(600,300);
 		Crearproceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
 			
 		
 			
 			
 		
        btn_crear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
           
            pr.programador = (txt_programador.getText());
            pr.idProceso = Integer.parseInt( txt_idProceso.getText());
           
           //Validar que no se repita el idProceso
           //validar que no truene con division entre 0
           //que no arroje exepcion cuando creo mas procesos de los que indique, o que no me deje crear mas procesos que los que indique
            boolean repetido=false;
            	for(int j=0;j<=pr.idsprocesos.length-1;j++)
            	{
            		if(repetido=(pr.idProceso==pr.idsprocesos[j]))
            		{
            			JOptionPane.showMessageDialog(Crearproceso,"Error: Ya existe ese id","Error en IdProceso",JOptionPane.ERROR_MESSAGE);
            				break;
            		}
            	
            		
            	}
            	
            	  if (repetido==false)
            	  {
            	  	 pr.idsprocesos[i-1]=pr.idProceso;
                     i++;
            	  
            	    
            	        if(i>l.procesosrecibidos)  
            	        {
            	        	btn_crear.setVisible(false);
            	        }     	   
            
            pr.tme = Integer.parseInt(txt_tme.getText());
            //Validar tme
            if(pr.tme<=0)
            {
            JOptionPane.showMessageDialog(Crearproceso,"Error: Numero menor o igual a cero en tme","Error en TME",JOptionPane.ERROR_MESSAGE);	   
            }
           
          
            	
            pr.num1 = Integer.parseInt(txt_num1.getText());
            pr.num2 = Integer.parseInt(txt_num2.getText());  
            //Obtener opcion seleccionada
            if(rbtn1.isSelected()==true)
			{
 				resultado=pr.Sumar(pr.num1,pr.num2);
			}
			if(rbtn2.isSelected()==true)
			{
 				resultado=pr.Restar(pr.num1,pr.num2);
			}
			if(rbtn3.isSelected()==true)
			{
 				resultado=pr.Multiplicar(pr.num1,pr.num2);
			}
			if(rbtn4.isSelected()==true)
			{
 				resultado=pr.Dividir(pr.num1,pr.num2);
 				if(resultado=="Error")
 				{
 					 JOptionPane.showMessageDialog(Crearproceso,"Error: Division entre 0","Error en Division",JOptionPane.ERROR_MESSAGE);
 				}
 				
			}
			if(rbtn5.isSelected()==true)
			{
 				resultado=pr.Residuo(pr.num1,pr.num2);
 		
 				if(resultado=="Error")
 				{
 					 JOptionPane.showMessageDialog(Crearproceso,"Error: Division entre 0","Error en Residuo",JOptionPane.ERROR_MESSAGE);
 				}
			}
			if(rbtn6.isSelected()==true)
			{
 				resultado=pr.Potencia(pr.num1,pr.num2);
			}
			
            
            	
            		VentanaMostrarProceso(); 
            }//fin del if(si no hay id repetido)
            	
            }
        });
        
        
          btn_cancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            System.exit(0); 
            	
            }
        });
        
 	}
 	
 	
 	
 	
 	
 	public void VentanaMostrarProceso()
 	{
 		
 		JFrame Mostrarproceso = new JFrame("Mostrar proceso");
 	
 	    //FlowLayout pruebafl = new FlowLayout();
 	    Mostrarproceso.setLayout(new GridLayout(2,4));
 	    
 	    //DECLARACION DE COMPONENTES
 	    
 	    
 	     JLabel et_programador,et_idProceso,et_tme,et_op;
 	     JButton btn_crear,btn_cancelar;
 	     JTextField txt_programador,txt_idProceso,txt_tme,txt_num1,txt_num2,txt_op;
 	   
 	    
 	    
 	    //Creacion de componentes
 	     et_programador = new JLabel("Programador:");
 	     et_idProceso = new JLabel("Id Proceso:");
 	     et_tme		= new JLabel("TME");
 	     et_op			=new JLabel("Operacion:");
 	     
 	     txt_programador = new JTextField(12);
 	     txt_idProceso   = new JTextField(12);
 	     txt_tme		 = new JTextField(12);
 	     txt_op				=new JTextField(12);
 	   
 	     
 	     String idProceso = Integer.toString(pr.idProceso);
 	     String tme = Integer.toString(pr.tme);
 	     
 	     txt_programador.setText(pr.programador);
 	     txt_idProceso.setText(idProceso);
 	     txt_tme.setText(tme);
 	     txt_op.setText(resultado);
 	   
 	     
 	     btn_crear = new JButton("Crear");
 	     btn_cancelar = new JButton("Cancelar");
        
        
        //añadir componentes a la ventana
        
        	Mostrarproceso.add(et_programador);
        	Mostrarproceso.add(txt_programador);
        	
        	Mostrarproceso.add(et_idProceso);
        	Mostrarproceso.add(txt_idProceso);
        	
            Mostrarproceso.add(et_tme);
        	Mostrarproceso.add(txt_tme);
        	
        	Mostrarproceso.add(et_op);
        	Mostrarproceso.add(txt_op);
        	
        
        	Mostrarproceso.add(btn_crear);
        	Mostrarproceso.add(btn_cancelar);
        	
 
        
        
			
        
 	    Mostrarproceso.setVisible(true);
 		Mostrarproceso.pack();
  		//Crearproceso.setSize(600,300);
 	//	Mostrarproceso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
 			 Mostrarproceso.setDefaultCloseOperation(DISPOSE_ON_CLOSE); 	
 			
 			
 		
        btn_crear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
           
            	
            }
        });
        
        
          btn_cancelar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             Mostrarproceso.setVisible(false); 
             	
            }
        });
        
 	}
 	
 	
 	
 	
 	 public void actionPerformed(ActionEvent e)
 	 {
 	 	
 	 }
	
}