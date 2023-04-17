package view.telefonia;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.telefonia.EnderecoController;
import model.exception.telefonia.CampoInvalidoException;
import model.vo.telefonia.Endereco;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaCadastroEndereco {

	private JFrame frmCadastroDeEndereco;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JLabel lblRua;
	private JLabel lblBairro;
	private JLabel lblCep;
	private JLabel lblCidade;
	private JLabel lblNumero;
	private JLabel lblEstado;
	private JButton btnSalvar;
	private JComboBox cbEstado;
	
	//TODO chamar API ou backend futuramente
	private String[] estados = {"RS", "SC","PR", "SP", "RJ"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco window = new TelaCadastroEndereco();
					window.frmCadastroDeEndereco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEndereco() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDeEndereco = new JFrame();
		frmCadastroDeEndereco.getContentPane().setBackground(Color.PINK);
		frmCadastroDeEndereco.getContentPane().setForeground(Color.WHITE);
		frmCadastroDeEndereco.setTitle("Cadastro de endereço");
		frmCadastroDeEndereco.setBounds(100, 100, 447, 240);
		frmCadastroDeEndereco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeEndereco.getContentPane().setLayout(null);
		
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(15, 15, 64, 14);
		frmCadastroDeEndereco.getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setBounds(89, 11, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		lblRua = new JLabel("Rua:");
		lblRua.setBounds(15, 40, 64, 14);
		frmCadastroDeEndereco.getContentPane().add(lblRua);
		
		lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(15, 65, 64, 14);
		frmCadastroDeEndereco.getContentPane().add(lblBairro);
		
		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(15, 90, 64, 14);
		frmCadastroDeEndereco.getContentPane().add(lblCidade);
		
		lblNumero = new JLabel("Número:");
		lblNumero.setBounds(15, 115, 64, 14);
		frmCadastroDeEndereco.getContentPane().add(lblNumero);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(15, 140, 64, 14);
		frmCadastroDeEndereco.getContentPane().add(lblEstado);
		
		txtRua = new JTextField();
		txtRua.setBounds(89, 36, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtRua);
		txtRua.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(89, 61, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtBairro);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(89, 86, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtCidade);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(89, 111, 300, 20);
		frmCadastroDeEndereco.getContentPane().add(txtNumero);
		
		cbEstado = new JComboBox(estados);
		cbEstado.setToolTipText("Selecione");
		cbEstado.setSelectedIndex(-1);
		cbEstado.setBounds(89, 136, 300, 22);
		frmCadastroDeEndereco.getContentPane().add(cbEstado);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(153, 255, 153));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Endereco endereco = new Endereco();
				endereco.setCep(txtCep.getText());
				endereco.setRua(txtRua.getText());
				endereco.setBairro(txtBairro.getText());
				endereco.setNumero(txtNumero.getText());
				endereco.setCidade(txtCidade.getText());
				endereco.setEstado((String) cbEstado.getSelectedItem());
						
				EnderecoController controller = new EnderecoController();
				try {
					controller.inserir(endereco);
					JOptionPane.showMessageDialog(null, 
							"Endereço cadastrado com sucesso", 
							"Sucesso", JOptionPane.INFORMATION_MESSAGE);
				} catch (CampoInvalidoException e) {
					JOptionPane.showMessageDialog(null, 
							"Preencha os seguintes campos: \n" + e.getMessage(), 
							"Atenção", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnSalvar.setBounds(289, 167, 100, 23);
		frmCadastroDeEndereco.getContentPane().add(btnSalvar);
		

	
	}
}
