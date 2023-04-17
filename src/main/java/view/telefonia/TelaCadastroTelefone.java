package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

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
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class TelaCadastroTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField txtDdd;
	private JTextField txtNumero;
	private JLabel lblDdd;
	private JLabel lblNumero;
	private JLabel lblDono;
	private JComboBox cbCliente;
	private JLabel lblTipo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMovel;
	private JRadioButton rdbtnFixo;
	
	

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
		setBounds(100, 100, 325, 262);
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
		
		
		//DONO
		lblDono = new JLabel("Dono:");
		lblDono.setBounds(26, 88, 56, 14);
		contentPane.add(lblDono);
		
		ClienteController clienteController = new ClienteController();
		List<Cliente> todosOsClientes = clienteController.consultarTodos();
		
		cbCliente = new JComboBox(todosOsClientes.toArray());
		cbCliente.setBounds(89, 84, 172, 22);
		contentPane.add(cbCliente);
		
		//TIPO
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(26, 123, 46, 14);
		contentPane.add(lblTipo);
		
		rdbtnMovel = new JRadioButton("Móvel");
		buttonGroup.add(rdbtnMovel);
		rdbtnMovel.setBackground(Color.PINK);
		rdbtnMovel.setBounds(89, 119, 78, 23);
		contentPane.add(rdbtnMovel);
		
		rdbtnFixo = new JRadioButton("Fixo");
		buttonGroup.add(rdbtnFixo);
		rdbtnFixo.setBackground(Color.PINK);
		rdbtnFixo.setBounds(183, 119, 78, 23);
		contentPane.add(rdbtnFixo);
		
		
		//SALVAR
		JButton btnSalvarTelefone = new JButton("Salvar");
		btnSalvarTelefone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Telefone novoTelefone = new Telefone();
				novoTelefone.setDdd(txtDdd.getText());
				novoTelefone.setNumero(txtNumero.getText());
				novoTelefone.setIdCliente(((Cliente)cbCliente.getSelectedItem()).getId());
				novoTelefone.setNumero(txtNumero.getText());
				novoTelefone.setMovel(rdbtnMovel.isSelected());
				
				TelefoneController controller =  new TelefoneController();
				try {
					controller.inserir(novoTelefone);
					JOptionPane.showMessageDialog(null,  "Telefone salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CampoInvalidoException e1) {
					JOptionPane.showMessageDialog(null,  e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnSalvarTelefone.setBounds(172, 177, 89, 23);
		contentPane.add(btnSalvarTelefone);
		
	}
	
}
