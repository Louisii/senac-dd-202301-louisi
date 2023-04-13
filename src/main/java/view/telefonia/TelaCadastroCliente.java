package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.telefonia.EnderecoController;
import model.vo.telefonia.Endereco;

import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastroCliente {

	private JFrame frmCadastroCliente;
	private JTextField txtNome;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JFormattedTextField txtCpf;
	private JLabel lblEndereco;
	private JComboBox cbEndereco;
	private JButton btnSalvarCliente;
	
	private MaskFormatter mascaraCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente window = new TelaCadastroCliente();
					window.frmCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroCliente = new JFrame();
		frmCadastroCliente.getContentPane().setBackground(new Color(255, 192, 203));
		frmCadastroCliente.setTitle("Cadastro Cliente");
		frmCadastroCliente.setBounds(100, 100, 477, 231);
		frmCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroCliente.getContentPane().setLayout(null);
		
		
		//Nome
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 31, 70, 14);
		frmCadastroCliente.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(90, 28, 340, 20);
		frmCadastroCliente.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		
		//CPF
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 59, 70, 14);
		frmCadastroCliente.getContentPane().add(lblCpf);
		

		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(90, 59, 340, 20);
		frmCadastroCliente.getContentPane().add(txtCpf);
		
		
		//Endereco
		lblEndereco = new JLabel("Endereço");
		lblEndereco.setBounds(10, 89, 70, 14);
		frmCadastroCliente.getContentPane().add(lblEndereco);
		
		EnderecoController endController = new EnderecoController();
		List<Endereco> todosOsEnderecos = endController.consultarTodos();
		
		cbEndereco = new JComboBox(todosOsEnderecos.toArray());
		cbEndereco.setBounds(90, 87, 340, 22);
		frmCadastroCliente.getContentPane().add(cbEndereco);
		
		
		//Salvar
		btnSalvarCliente = new JButton("Salvar");
		btnSalvarCliente.setBackground(new Color(152, 251, 152));
		btnSalvarCliente.setForeground(Color.BLACK);
		btnSalvarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvarCliente.setBounds(320, 127, 89, 23);
		frmCadastroCliente.getContentPane().add(btnSalvarCliente);
	}
}
