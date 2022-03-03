package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos(String process) {
		String sistema = os();
		if(sistema.contains("Windows")){
			process = "tasklist /fo table";
		}
		else {
			process = "ps -ef";
		}
		
		try {
			Process p = Runtime.getRuntime().exec(process);
			InputStream fluxo = p.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while(linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} catch (IOException e) {
			String erro = e.getMessage();
			System.err.println(erro);
		}
		
	}
	
	public void mataPid(int pid) {
		String sistema = os();
		String process;
		
		if(sistema.contains("Windows")){
			process = "taskkill /pid ";
		}
		else {
			process = "kill -9 ";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(process);
		buffer.append(pid);
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			String erro = e.getMessage();
			System.err.println(erro);
		}
		
	}
	
	public void mataNome(String nome) {
		String sistema = os();
		String process;
		
		if(sistema.contains("Windows")){
			process = "taskkill /im ";
		}
		else {
			process = "kill -f ";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append(process);
		buffer.append(nome);
		try {
			Runtime.getRuntime().exec(buffer.toString());
		} catch (IOException e) {
			String erro = e.getMessage();
			System.err.println(erro);
		}
		
	}

}
