
public class Proceso{
	Lote l= new Lote();
	String programador;
	int idProceso,tme,num1,num2;
	int[] idsprocesos = new int[l.procesosrecibidos];
	String operacion="";
	
	
	
	public Proceso()
	{	
	 	for(int j=0;j<=idsprocesos.length-1;j++)
            	{
            	  idsprocesos[j]=0;
            	}
	}
	
	
	public void crearProceso()
	{
		
	}
	
	public String Sumar(int n1,int n2)
	{
		int suma= n1+n2;
		operacion=""+n1+" + "+n2+" = "+suma;
		return  operacion;
	}
	
	public String Restar(int n1,int n2)
	{
		int resta= n1-n2;
		operacion=""+n1+" - "+n2+" = "+resta;
		return  operacion;
	}
	
	public String Multiplicar(int n1,int n2)
	{
		int mult= n1*n2;
		operacion=""+n1+" * "+n2+" = "+mult;
		
		return  operacion;
	}
	
	public String Dividir(int n1,int n2)
	{
		if(n2<=0)
		{
		 	operacion="Error";	
		}
		else
		{
		 int div= n1/n2;
		 operacion=""+n1+" / "+n2+" = "+div;	
		}
	
		
		return  operacion;
	}
	
	public String Residuo(int n1,int n2)
	{
		if(n2<=0)
		{
		 	operacion="Error";	
		}
		else
		{
		 int residuo= n1/n2;
		 operacion=""+n1+" / "+n2+" = "+residuo;	
		}
		return  operacion;
	}
	
	public String Potencia(int n1,int n2)
	{
	 int potencia=(int) Math.pow(n1, n2);;
		operacion=""+n1+" ^ "+n2+" = "+potencia;
		return  operacion;	
	}
	
}