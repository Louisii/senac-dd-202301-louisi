package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.telefonia.ClienteController;
import controller.telefonia.EnderecoController;
import controller.telefonia.TelefoneController;
import model.exception.telefonia.CampoInvalidoException;
import model.exception.telefonia.CpfJaUtilizadoException;
import model.exception.telefonia.EnderecoInvalidoException;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JLabel lblDdd;
	private JLabel lblNumero;
	private JCheckBox chkMovel;
	private JLabel lblDono;
	private JComboBox cbCliente;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefone frame = new TelaCadastroTelefone();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroTelefone() {
		setTitle("Cadastro Telefone");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 325, 218);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		///DDD
		lblDdd = new JLabel("DDD:");
		lblDdd.setBounds(26, 31, 56, 14);
		contentPane.add(lblDdd);
		
		txtDdd = new JTextField();
		txtDdd.setBounds(89, 28, 172, 20);
		contentPane.add(txtDdd);
		txtDdd.setColumns(10);
		
		//NUMERO
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(26, 59, 56, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(89, 56, 172, 20);
		contentPane.add(txtNumero);
		
		//MOVEL
		chkMovel = new JCheckBox("Móvel");
		chkMovel.setBackground(Color.PINK);
		chkMovel.setBounds(26, 120, 97, 23);
		contentPane.add(chkMovel);
		
		
		//DONO
		lblDono = new JLabel("Dono:");
		lblDono.setBounds(26, 87, 56, 14);
		contentPane.add(lblDono);
		
		ClienteController clienteController = new ClienteController();
		List<Cliente> todosOsClientes = clienteController.consultarTodos();
		
		cbCliente = new JComboBox(todosOsClientes.toArray());
		cbCliente.setBounds(89, 84, 172, 22);
		contentPane.add(cbCliente);
		
		//SALVAR
		JButton btnSalvarTelefone = new JButton("Salvar");
		btnSalvarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Telefone novoTelefone = new Telefone();
				novoTelefone.setDdd(txtDdd.getText());
				novoTelefone.setNumero(txtNumero.getText());
				novoTelefone.setIdCliente(((Cliente)cbCliente.getSelectedItem()).getId());
				novoTelefone.setNumero(txtNumero.getText());
				novoTelefone.setMovel(chkMovel.isSelected());
				novoTelefone.setAtivo(false);
				
				TelefoneController controller =  new TelefoneController();
				controller.inserir(novoTelefone);
				JOptionPane.showMessageDialog(null,  "Telefone salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnSalvarTelefone.setBounds(172, 120, 89, 23);
		contentPane.add(btnSalvarTelefone);
	}
}
