package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.FilaDao;
import entity.Fila;

public class FilaService {
	private FilaDao dao;
	
	public FilaService(){
		dao = new FilaDao();
	}
	
	public ArrayList<Fila> listarFilas() throws IOException{
		return dao.listarFilas();
	}

}
