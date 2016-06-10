import javax.swing.JOptionPane;
public class Lote{
	
	int idLote,capacidad=5,procesosrecibidos;
	int lotesRequeridos;
	
	
	public Lote()
	{
    	IngresarDatos();
    	
	}
	
	public void IngresarDatos()
	{
		String	pr=JOptionPane.showInputDialog(null,"Ingresa el numero de procesos:");
    	procesosrecibidos=Integer.parseInt(pr);
    	CalcularLotes(procesosrecibidos);
    	
	}
	
	public void CalcularLotes(int procesosrecibidos)
	{
		int residuo=0;
		//En este metodo le asignare el id al lote 
		idLote =0;
	    if(procesosrecibidos>=0) //Si son mas de 5 procesos necesito calcular cuantos lotes necesito
	    {
	    	lotesRequeridos=procesosrecibidos/capacidad;
	    	residuo=procesosrecibidos%capacidad;
	    	if(residuo>0)
	    	{
	    		lotesRequeridos++;
	    	}
	    }
	    
	}
}