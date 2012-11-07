package Visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TelaPrincipal extends JFrame {

	private String winDir= ("c:\\frotaTJ\\imagens\\");

	private PanelInicial panelInicial = new PanelInicial();
	private PanelConteudo panelConteudo = new PanelConteudo();
	
	
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setTitle("Sistema de Manuten\u00E7\u00E3o de Frota do Tribunal de Justi\u00E7a do Estado de Santa Catarina ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50, 800, 600);
		setLocationRelativeTo(null);
		panelConteudo.setBackground(UIManager.getColor("Button.background"));
		panelConteudo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelConteudo);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	
	//-------------------------- Menu Inicio --------------------------\\
		JMenu mnInicio = new JMenu(" Inicio");
		mnInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				PanelInicial();
			}
		});
		mnInicio.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		mnInicio.setIcon(new ImageIcon(winDir+"7161_32x32.png"));
		menuBar.add(mnInicio);

	//-------------------------- Menu Arquivo --------------------------\\		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setIcon(new ImageIcon(winDir+"8366_32x32.png"));
		mnArquivo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnArquivo);
		
		
	//-------------------------- Menu Cadastrar --------------------------\\		
		JMenu mnCadastrar = new JMenu("Cadastrar");
		mnCadastrar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		mnCadastrar.setIcon(new ImageIcon(winDir+"6098_32x32.png"));
		menuBar.add(mnCadastrar);
		
		JMenuItem mntmAbastecimento = new JMenuItem("Abastecimento");
		mntmAbastecimento.setIcon(new ImageIcon(winDir+"2895_32x32.png"));
		mntmAbastecimento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroAbastecimento(0);
			}
		});
		mnCadastrar.add(mntmAbastecimento);
		
		JMenuItem mntmFornecedor = new JMenuItem("Fornecedor");
		mntmFornecedor.setIcon(new ImageIcon(winDir+"1003_32x32.png"));
		mnCadastrar.add(mntmFornecedor);
		
		JMenuItem mntmMarca = new JMenuItem("Marca");
		mntmMarca.setIcon(new ImageIcon(winDir+"3303_32x32.png"));
		mnCadastrar.add(mntmMarca);
		
		// Adiciona PanelCadastroModelo() no menu
		JMenuItem mntmModelo = new JMenuItem("Modelo");
		mntmModelo.setIcon(new ImageIcon(winDir+"1517_32x32.png"));
		mntmModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroModelo(0);
			}
		});
		mnCadastrar.add(mntmModelo);
		
		JMenuItem mntmMotorista = new JMenuItem("Motorista");
		mntmMotorista.setIcon(new ImageIcon(winDir+"7133_32x32.png"));
		mnCadastrar.add(mntmMotorista);
		
		JMenuItem mntmServio = new JMenuItem("Servi\u00E7o");
		mntmServio.setIcon(new ImageIcon(winDir+"ico-recursos-integra.png"));
		mntmServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroServi�o(0);
			}
		});
		mnCadastrar.add(mntmServio);
		
		JMenuItem mntmTipoDeServio = new JMenuItem("Tipo de Servi\u00E7o");
		mntmTipoDeServio.setIcon(new ImageIcon(winDir+"servicos-icone.png"));
		mnCadastrar.add(mntmTipoDeServio);
		
		JMenuItem mntmUnidade = new JMenuItem("Unidade");
		mntmUnidade.setIcon(new ImageIcon(winDir+"4049_32x32.png"));
		mntmUnidade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroUnidade(0);
			}
		});
		mnCadastrar.add(mntmUnidade);
		
		JMenuItem mntmUsuario = new JMenuItem("Usuario ");
		mntmUsuario.setIcon(new ImageIcon(winDir+"7818_32x32.png"));
		mntmUsuario.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroUsuario(0);
			}
		});		
		mnCadastrar.add(mntmUsuario);
		
		//Item Cadastrar Veiculo
		JMenuItem mntmCarro = new JMenuItem("Veiculo");
		mntmCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroVeiculo(0);
			}
		});
		mntmCarro.setIcon(new ImageIcon(winDir+"1519_32x32.png"));
		mnCadastrar.add(mntmCarro);
		
		JMenuItem mntmTipoServioModelo = new JMenuItem("Tipo Servi\u00E7o Modelo");
		mntmTipoServioModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroTipoServi�oModelo(0, 0);
			}
		});
		mnCadastrar.add(mntmTipoServioModelo);
		
		
	//-------------------------- Menu Listar --------------------------\\	
		JMenu mnListar = new JMenu("Listagem");
		mnListar.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		mnListar.setIcon(new ImageIcon(winDir+"6169_32x32.png"));
		menuBar.add(mnListar);
		
		JMenuItem menuItem = new JMenuItem("Abastecimento");
		mnListar.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Fornecedor");
		mnListar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("Marca");
		mnListar.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("Modelo");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemModelo();
			}
		});
		mnListar.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("Motorista");
		mnListar.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("Servi\u00E7o");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemServi�o();
			}
		});
		mnListar.add(menuItem_5);
		
		JMenuItem menuItem_6 = new JMenuItem("Tipo de Servi\u00E7o");
		mnListar.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("Unidade");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemUnidade();
			}
		});
		mnListar.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("Usuario ");
		mnListar.add(menuItem_8);
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemUsuario();
			}
		});
		
		//Menu Item Listar Veiculo
		JMenuItem menuItem_9 = new JMenuItem("Veiculo");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelListagemVeiculo();
			}
		});
		mnListar.add(menuItem_9);
		
		JMenuItem mntmTipoDeServio_1 = new JMenuItem("Tipo de Servi\u00E7o Modelo");
		mntmTipoDeServio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemTipoServi�oModelo();
			}
		});
		mnListar.add(mntmTipoDeServio_1);
		
	//-------------------------- Menu Relatorios --------------------------\\		
		JMenu mnRelatorios = new JMenu("Relatorios");
		mnRelatorios.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		mnRelatorios.setIcon(new ImageIcon(winDir+"1588_32x32.png"));
		menuBar.add(mnRelatorios);
	
	//-------------------------- Menu Trocar Usu�rio --------------------------\\	
		JMenu mnNewMenu = new JMenu("Trocar Usuario");
		mnNewMenu.setIcon(new ImageIcon(winDir+"7837_32x32.png"));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		menuBar.add(mnNewMenu);
		getContentPane().setLayout(new CardLayout(0, 0));
		panelConteudo.add(panelInicial, "panelInicial");
		
		}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//--------------------- M�todo para voltar para o Panel Inicial ----------------------\\
	public void PanelInicial(){
		PanelInicial panelInicial = new PanelInicial();
		panelConteudo.add(panelInicial, "panelInicial");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelInicial");
	}	
	
	
	//--------------------- M�todos para troca de Panel de cadastro ---------------------\\
	public void PanelCadastroAbastecimento(int j){
		PanelCadastroAbastecimento panelCadastroAbastecimento = new PanelCadastroAbastecimento( j);
		panelConteudo.add(panelCadastroAbastecimento, "panelCadastroAbastecimento");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelCadastroAbastecimento");
	}
	
	public void PanelCadastroTipoServi�oModelo(int j, int i){
		PanelCadastroTipoServi�oModelo panelCadastroTipoServi�oModelo = new PanelCadastroTipoServi�oModelo( j, i);
		panelConteudo.add(panelCadastroTipoServi�oModelo, "panelCadastroTipoServi�oModelo");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelCadastroTipoServi�oModelo");
	}
	
	public void PanelCadastroModelo(int j){
		PanelCadastroModelo panelCadastroModelo = new PanelCadastroModelo( j);
		panelConteudo.add(panelCadastroModelo, "panelCadastroModelo");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelCadastroModelo");
	}
	
	public void PanelCadastroServi�o(int i){
		PanelCadastroServi�o panelCadastroServi�o = new PanelCadastroServi�o(i);
		panelConteudo.add(panelCadastroServi�o, "panelCadastroServi�o");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelCadastroServi�o");
	}

	public void PanelCadastroVeiculo(int id){
		PanelCadastroVeiculo panelCadastroVeiculo = new PanelCadastroVeiculo(id);
		panelConteudo.add(panelCadastroVeiculo, "panelCadastroVeiculo");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelCadastroVeiculo");
	}
	
	public void PanelCadastroUnidade(int idUnidade){
		PanelCadastroUnidade panelCadastroUnidade = new PanelCadastroUnidade(idUnidade);
		panelConteudo.add(panelCadastroUnidade, "panelCadastroUnidade");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo,"panelCadastroUnidade");
	}
	
	public void PanelCadastroUsuario(int idUsuario){
		PanelCadastroUsuario panelCadastroUsuario = new PanelCadastroUsuario(idUsuario);
		panelConteudo.add(panelCadastroUsuario, "panelCadastroUsuario");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo,"panelCadastroUsuario");
	}

	
//--------------------- M�todos para troca de Panel de Listagem ---------------------\\	
	public void PanelListagemModelo(){
		PanelListagemModelo panelListagemModelo = new PanelListagemModelo();
		panelConteudo.add(panelListagemModelo, "panelListagemModelo");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelListagemModelo");
	}
	
	public void PanelListagemTipoServi�oModelo(){
		PanelListagemTipoServi�oModelo panelListagemTipoServi�oModelo = new PanelListagemTipoServi�oModelo();
		panelConteudo.add(panelListagemTipoServi�oModelo, "panelListagemTipoServi�oModelo");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelListagemTipoServi�oModelo");
	}
	
	public void PanelListagemServi�o(){
		PanelListagemServi�o panelListagemServi�o = new PanelListagemServi�o();
		panelConteudo.add(panelListagemServi�o, "panelListagemServi�o");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelListagemServi�o");
	}

	public void PanelListagemUnidade(){
		PanelListagemUnidade panelListagemUnidade = new PanelListagemUnidade();
		panelConteudo.add(panelListagemUnidade, "panelListagemUnidade");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo,"panelListagemUnidade");
	}
	
	public void PanelListagemUsuario(){
		PanelListagemUsuario panelListagemUsuario = new PanelListagemUsuario();
		panelConteudo.add(panelListagemUsuario, "panelListagemUsuario");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo,"panelListagemUsuario");
	}
	
	public void PanelListagemVeiculo(){
		PanelListagemVeiculo panelListagemVeiculo = new PanelListagemVeiculo();
		panelConteudo.add(panelListagemVeiculo, "panelListagemVeiculo");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelListagemVeiculo");
	}
	
	public void PanelListagemAbastecimento(){
		PanelListagemAbastecimento panelListagemAbastecimento = new PanelListagemAbastecimento();
		panelConteudo.add(panelListagemAbastecimento, "panelListagemAbastecimento");
		CardLayout cardLayout = (CardLayout)panelConteudo.getLayout();
		cardLayout.show(panelConteudo, "panelListagemAbastecimento");
	}
}

