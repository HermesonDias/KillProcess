package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		
		KillController kController = new KillController();
		int opc = 0;
		
		while( opc!= 4) {
	    opc = Integer.parseInt(JOptionPane.showInputDialog("1- Listar Processos \n2- Matar Processos pelo PID \n3- Matar Processos pelo Nome \n4- Finalizar"));
		
		switch(opc) {
		case 1: String process = "";
		        kController.listaProcessos(process);
		break;
		case 2: int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID"));
		        kController.mataPid(pid);
		break;
		case 3: String nome = JOptionPane.showInputDialog("Digite o nome");
		        kController.mataNome(nome);
		break;
		case 4: JOptionPane.showMessageDialog(null, "Finalizado");
		break;
		default: JOptionPane.showMessageDialog(null, "Opção Inválida");
		break;
		}
	  }
		
	}

}
