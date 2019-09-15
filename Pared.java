package ladrillos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Pared {
	
	private int cantLadrillos;
	private Ladrillo [][] pared = new Ladrillo[10][10];
	private Ladrillo ladrilloSacar = null;
	
    public Pared(String path) throws IOException {

    	for (int i = 0 ; i < 10 ; i++)
     	   for (int j = 0 ; j < 10 ; j++)
     		  pared[i][j] = new Ladrillo(0,0);
    	try {

            File f = new File(path);

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";
            int nroLinea = 0;
            while ((readLine = b.readLine()) != null) {
            	//System.out.println(readLine);
            	if (nroLinea == 0)
            		cantLadrillos = Integer.parseInt(readLine);
            	else if (nroLinea == cantLadrillos + 1) {
                	String[] s = readLine.split(" ");
                	int idLetra = (int)s[1].charAt(0) - (int)'A';
                	int idNro = Integer.parseInt(s[2]);
                	ladrilloSacar = pared[idLetra][idNro];
                }    	
                else {
                	String[] s = readLine.split(" ");
                	int idLetra = (int)s[0].charAt(0) - (int)'A';
                	int idNro = Integer.parseInt(s[1]) - 1;
                	int largo = Integer.parseInt(s[2]);
                	int inicio = 0;
                	if (idNro != 0)
                		inicio = pared[idLetra][idNro - 1].fin + 1;
                	int fin = inicio + largo - 1;
                	pared[idLetra][idNro] = new Ladrillo(inicio,fin);
                }   
                nroLinea++;
            }


            b.close();      
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void imprimir() {
       for (int i = 0 ; i < 10 ; i++)
    	   for (int j = 0 ; j < 10 ; j++) 
    		   if (pared[i][j].inicio != 0 || pared[i][j].fin !=0)
    		   System.out.println(pared[i][j].inicio + " " + pared[i][j].fin);
    	   
    }

  /*  public void sacar() {
    	
    	for (int i = 0 ; i < cantLadrillos ; i++) {
    		
    		if (pared[i].idLetra > ladrilloSacar.idLetra) {
    			
    		}
    			
    	}
    }*/
}

