/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import entitys.ItemReceita;

/**
 *
 * @author guest-nhdk5d
 */
public class ControleItemReceita {

    public ItemReceita buscarItem(String IdItem){
		
		ItemReceita itemProcurado = new ItemReceita();
		
		try {
			String singleLine = null;
			BufferedReader br = new BufferedReader(new FileReader("medicamentos.txt"));
			try {	
				while((singleLine = br.readLine()) != null) {
					String [] trans = singleLine.split(";");
					if(trans[1].equals("IdItem")) {
						singleLine = br.readLine();
						trans = singleLine.split(";");
						itemProcurado.setNome(trans[1]);
						return itemProcurado;
					}
				}
			br.close();
				}catch(IOException e) {}
			}catch(IOException e) {}
		return itemProcurado;
    }
}
