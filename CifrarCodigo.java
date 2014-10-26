/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradovigenere;
import javax.swing.*;
/**
 *
 * @author Marlon
 */
class CifrarCodigo {
    
    
    char[] palabra; //arreglo para guardar la palabra
	char[] clave;//arreglo para guardar la clave
	char[] respuesta; //arreglo para guardar la respuesta
	char matriz[][]; //matriz para hacer la operación

	public CifrarCodigo(String mensaje,String clave)
	{
		this.palabra = mensaje.toCharArray();
		char[] claveTemp = clave.toCharArray();
		this.clave = new char[palabra.length];
		int cont =0;
		for(int i=0;i<palabra.length;i++)//este for mete la clave cuantas veces sea necesario para que quede igual a la palabra
		{
			this.clave[i]=claveTemp[cont];
			cont++;
			if(cont==claveTemp.length)
				cont=0;
		}
		//la clave ya se guardo en un arreglo de igual tamaño que del mensaje

		this.matriz = generarMatrizABC();//Generamos matriz del abecedario
		cifrar(); //ciframos el texto
	}

	public void cifrar() //Genera cifrado
	{
		char[] cifrado = new char[palabra.length];
		int i;
		int j;
		for(int cont=0;cont<palabra.length;cont++)
		{
			//Primero calculamos el indice de cada matriz "i" y "j"
			//el indice "i" correspondera al arreglo del mensaje
			//el indice "j" correspondera al arreglo de la clave 
			//luego ejecutaremos el calculo para cifrar utilizando "i" y "j" como cordenadas de la matriz
			i=(int)this.palabra[cont]-97; //restamos 97 para pasar de codigo ascii a un numero entero
			j=(int)this.clave[cont]-97;
			cifrado[cont]=this.matriz[i][j];

		}

		this.respuesta = cifrado;
		for(int k = 0;k<26;k++)
		System.out.println(this.matriz[k]);
                System.out.println();    
		System.out.println(this.palabra);
		System.out.println(this.clave);
		System.out.println(cifrado);
	}

	public String getpalabraCifrado()
	{
		String resultado="";
		for(int i=0;i<respuesta.length;++i)
			resultado=resultado+this.respuesta[i];
		return resultado;
	}

	private char[][] generarMatrizABC()
	{
		int contador;
		char abcTemp[] = this.generarAbecedario();
		char abc[] = new char[abcTemp.length*2];
		for(int c=0;c<26;c++) {
			abc[c]=abcTemp[c];
			abc[c+26]=abcTemp[c];
		}
		char[][] matriz = new char[26][26];
		for(int i=0;i<26;i++)
		{
			contador=0;
			for(int j=0;j<26;j++)
			{
				matriz[i][j]=abc[contador+i];
				contador++;
			}
		}
		return matriz;
	}

	private char[] generarAbecedario()
	{
		char[] abc = new char[26];

		for(int i= 97; i<= 122;i++)
		{
			abc[i-97]=(char)i;

		}
		return abc;
	}
    
    
    
    
}
