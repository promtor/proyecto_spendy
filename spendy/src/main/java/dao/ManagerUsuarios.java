package dao;

import java.util.LinkedList;
import java.util.List;

import classes.Usuario;
import classes.UsuarioImpl;

public class ManagerUsuarios {
	
	static List<Usuario> lista = new LinkedList<Usuario>();
	public static List<Usuario> getUsuarios(){
		
		Usuario u1 = new UsuarioImpl("Pablo", "Barcelo", "pabbar@gmail.com", "p3dR0B");
		Usuario u2 = new UsuarioImpl("Francisco", "Bustos", "franbus@gmail.com", "j@H123");
		Usuario u3 = new UsuarioImpl("Alejandro", "Cañadas", "alecan@gmail.com", "8If&H@2");
		Usuario u4 = new UsuarioImpl("Salvador", "Cascon", "salcas@gmail.com", "hh6@t5AsG");
		Usuario u5 = new UsuarioImpl("Guillermo", "Danez", "guidan@gmail.com", "25$5Y6/9");
		Usuario u6 = new UsuarioImpl("Carlos", "Galeano", "cargal29@gmail.com", "1@3$t&io");
		Usuario u7 = new UsuarioImpl("Jose", "Garcia", "josgar16@gmail.com", "I2#4&gtY");
		Usuario u8 = new UsuarioImpl("Maria Jose", "Gonzalez", "mjgonz@gmail.com", "mu5hoB37iS");
		Usuario u9 = new UsuarioImpl("Miguel", "Jimenez", "migjim@gmail.com", "1$&y/uoj");
		Usuario u10 = new UsuarioImpl("Carlos", "Marin", "carmar25@gmail.com", "gh&jj(oiy");
		Usuario u11 = new UsuarioImpl("Pablo", "Montero", "pabmon43@gmail.com", "@#ftd1234HT");
		
		
		lista.add(u2);
		lista.add(u1);
		lista.add(u3);
		lista.add(u4);
		lista.add(u5);
		lista.add(u6);
		lista.add(u7);
		lista.add(u8);
		lista.add(u9);
		lista.add(u10);
		lista.add(u11);
		
		return lista;
	}
	public void addUsuario(Usuario u){
		lista.add(u);
		
	}
}
