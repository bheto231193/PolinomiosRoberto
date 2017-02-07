package Polinomios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPolinomios extends JFrame {

	public JPanel contentPane;
	public static JTextField txtCoeficiente1;
	public static JTextField txtExponente1;
	public static JTextField txtCoeficiente2;
	public static  JTextField txtExponente2;
	public static JTextField txtResultado;
	public static JTextField txtMostrar2;
	public static JTextField txtMostar1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPolinomios frame = new PantallaPolinomios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public PantallaPolinomios() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Controller lista1 = new Controller();
		Controller lista2 = new Controller();
		
		JButton btnMultiplicacion = new JButton("Multiplicar");
		btnMultiplicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lista1.multiplicarPolinomio(lista2);
					lista1.imprimirPolinomioPantalla(3);
				} catch (ListaVaciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnMultiplicacion.setBounds(231, 100, 89, 23);
		contentPane.add(btnMultiplicacion);
		
		JButton btnResta = new JButton("Restar");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				try {
					lista1.restarPolinomio(lista2);
					lista1.imprimirPolinomioPantalla(3);
				} catch (ListaVaciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnResta.setBounds(231, 66, 89, 23);
		contentPane.add(btnResta);
		
		JButton btnSuma = new JButton("Sumar");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lista1.suma(lista2);
					lista1.imprimirPolinomioPantalla(3);
				} catch (ListaVaciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSuma.setBounds(231, 32, 89, 23);
		contentPane.add(btnSuma);
		
		
		
		JButton btnAgregarNodo1 = new JButton("Agregar Nodo");
		btnAgregarNodo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				 int coeficiente =Integer.parseInt(txtCoeficiente1.getText());
		         int exponente= Integer.parseInt(txtExponente1.getText());
		 		 lista1.insertar(coeficiente,exponente);
		 		 JOptionPane.showMessageDialog(null,"registro agregado con exito a la lista 1"); 
	
			}
		});
		btnAgregarNodo1.setBounds(56, 83, 100, 32);
		contentPane.add(btnAgregarNodo1);
		
		
		
		JButton btnAgregarNodo2 = new JButton("Agregar Nodo");
		btnAgregarNodo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 int coeficiente =Integer.parseInt(txtCoeficiente2.getText());
		         int exponente= Integer.parseInt(txtExponente2.getText());
		 		 lista2.insertar(coeficiente,exponente);
		 		 JOptionPane.showMessageDialog(null,"registro agregado con exito a la lista 2");    
	
			}
		});
		btnAgregarNodo2.setBounds(399, 83, 100, 32);
		contentPane.add(btnAgregarNodo2);
		

		JButton btnSimplificar1 = new JButton("SIMPLIFICAR");
		btnSimplificar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lista1.simplificar();
					lista1.imprimirPolinomioPantalla(1);
				} catch (ListaVaciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSimplificar1.setBounds(345, 219, 113, 23);
		contentPane.add(btnSimplificar1);
		
		JButton btnSimplificar2 = new JButton("SIMPLIFICAR");
		btnSimplificar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					lista2.simplificar();
					lista2.imprimirPolinomioPantalla(2);
				} catch (ListaVaciaException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSimplificar2.setBounds(345, 329, 113, 23);
		contentPane.add(btnSimplificar2);
		
		JButton btnMostrar1 = new JButton("MOSTRAR LISTA");
		btnMostrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista1.imprimirPolinomioPantalla(1);
				
			}
		});
		btnMostrar1.setBounds(56, 219, 116, 23);
		contentPane.add(btnMostrar1);
		
		JButton btnMostrar2 = new JButton("MOSTRAR LISTA");
		btnMostrar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lista2.imprimirPolinomioPantalla(2);
			}
		});
		btnMostrar2.setBounds(56, 329, 116, 23);
		contentPane.add(btnMostrar2);
		
		
		
		
		
		txtCoeficiente1 = new JTextField();
		txtCoeficiente1.setBounds(28, 52, 60, 20);
		contentPane.add(txtCoeficiente1);
		txtCoeficiente1.setColumns(10);
		
		txtExponente1 = new JTextField();
		txtExponente1.setBounds(112, 52, 60, 20);
		contentPane.add(txtExponente1);
		txtExponente1.setColumns(10);
		
		txtCoeficiente2 = new JTextField();
		txtCoeficiente2.setBounds(374, 52, 60, 20);
		contentPane.add(txtCoeficiente2);
		txtCoeficiente2.setColumns(10);
		
		txtExponente2 = new JTextField();
		txtExponente2.setBounds(459, 52, 60, 20);
		contentPane.add(txtExponente2);
		txtExponente2.setColumns(10);
		
		txtResultado = new JTextField();
		txtResultado.setBounds(28, 419, 472, 20);
		contentPane.add(txtResultado);
		txtResultado.setColumns(10);
		
		txtMostrar2 = new JTextField();
		txtMostrar2.setBounds(28, 298, 472, 20);
		contentPane.add(txtMostrar2);
		txtMostrar2.setColumns(10);
		
		txtMostar1 = new JTextField();
		txtMostar1.setBounds(28, 188, 472, 20);
		contentPane.add(txtMostar1);
		txtMostar1.setColumns(10);
		
		
	
		JLabel lblLista = new JLabel("Agregar a lista 1");
		lblLista.setBounds(56, 11, 81, 14);
		contentPane.add(lblLista);
		
		JLabel lblLista_1 = new JLabel("Agregar a lista 2");
		lblLista_1.setBounds(413, 11, 81, 14);
		contentPane.add(lblLista_1);		
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(28, 394, 83, 14);
		contentPane.add(lblResultado);
		
		JLabel lblListaNumero = new JLabel("Lista numero 2");
		lblListaNumero.setBounds(28, 273, 83, 14);
		contentPane.add(lblListaNumero);
		
		JLabel lblListaNumero_1 = new JLabel("Lista numero 1");
		lblListaNumero_1.setBounds(28, 163, 83, 14);
		contentPane.add(lblListaNumero_1);
		
		JLabel lblCoeficiente = new JLabel("Coeficiente");
		lblCoeficiente.setBounds(30, 36, 58, 14);
		contentPane.add(lblCoeficiente);
		
		JLabel lblExponente = new JLabel("Exponente");
		lblExponente.setBounds(112, 36, 60, 14);
		contentPane.add(lblExponente);
		
		JLabel lblCoeficiente_1 = new JLabel("Coeficiente");
		lblCoeficiente_1.setBounds(374, 36, 60, 14);
		contentPane.add(lblCoeficiente_1);
		
		JLabel lblExponente_1 = new JLabel("Exponente");
		lblExponente_1.setBounds(459, 36, 60, 14);
		contentPane.add(lblExponente_1);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(65, 219, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
