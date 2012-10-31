package Visao;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.SwingConstants;

import org.hibernate.ejb.criteria.expression.function.CurrentDateFunction;

import com.sun.jmx.snmp.Timestamp;

import mb.MBFornecedor;
import mb.MBMotorista;
import mb.MBServico;
import mb.MBTipoServico;
import mb.MBVeiculo;

import dao.Fornecedor;
import dao.Motorista;
import dao.Servico;
import dao.TipoServico;
import dao.Veiculo;


public class PanelCadastroServišo extends PanelExemplo {
	private JTextField textFieldData;
	private JTextField textFieldValor;
	private JTextField textFieldOršamento;
	private JTextField textFieldCupomFiscal;
	private JTextField textFieldDescrišŃo;
	private JTextField textFieldKm;
	private	JComboBox<TipoServico> comboBoxTipoServišo;
	private JComboBox<Motorista> comboBoxMotorista;
	private JComboBox<Fornecedor> comboBoxFornecedor;
	private JComboBox<Veiculo> comboBoxVeiculo;


	/**
	 * Create the panel.
	 */
	public PanelCadastroServišo(final int idServicoSelecionado) {
		
		JLabel lblCadastroServio = new JLabel("Cadastro Servi\u00E7o");
		lblCadastroServio.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setHorizontalAlignment(SwingConstants.LEFT);
		
		textFieldData = new JTextField();
		textFieldData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldData.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblOramento = new JLabel("Or\u00E7amento");
		lblOramento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOramento.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblCupomFiscal = new JLabel("Cupom Fiscal");
		lblCupomFiscal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCupomFiscal.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescrio.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblKm = new JLabel("Km");
		lblKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblTipodeServio = new JLabel("Tipo de Servi\u00E7o");
		lblTipodeServio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblMotorista = new JLabel("Motorista");
		lblMotorista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblVeiculo = new JLabel("Veiculo");
		lblVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldValor = new JTextField();
		textFieldValor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldValor.setColumns(10);
		
		textFieldOršamento = new JTextField();
		textFieldOršamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldOršamento.setColumns(10);
		
		textFieldCupomFiscal = new JTextField();
		textFieldCupomFiscal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCupomFiscal.setColumns(10);
		
		textFieldDescrišŃo = new JTextField();
		textFieldDescrišŃo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldDescrišŃo.setColumns(10);
		
		MBTipoServico mbTipoServico= MBTipoServico.getInstance();
		comboBoxTipoServišo = new JComboBox<TipoServico>();
		DefaultComboBoxModel<TipoServico> modeloComboBoxTipoServico;
		try {
			modeloComboBoxTipoServico = new DefaultComboBoxModel<TipoServico>(new Vector(mbTipoServico.listarTipoServicos()));
			comboBoxTipoServišo.setModel(modeloComboBoxTipoServico);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		comboBoxTipoServišo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MBMotorista mbMotorista= MBMotorista.getInstance();
		comboBoxMotorista = new JComboBox<Motorista>();
		DefaultComboBoxModel<Motorista> modeloComboBoxMotorista;
		try {
			modeloComboBoxMotorista = new DefaultComboBoxModel<Motorista>(new Vector(mbMotorista.listarMotoristas()));
			comboBoxMotorista.setModel(modeloComboBoxMotorista);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		comboBoxMotorista.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MBFornecedor mbFornecedor= MBFornecedor.getInstance();
		comboBoxFornecedor = new JComboBox<Fornecedor>();
		DefaultComboBoxModel<Fornecedor> modeloComboBoxFornecedor;
		try {
			modeloComboBoxFornecedor = new DefaultComboBoxModel<Fornecedor>(new Vector(mbFornecedor.listarFornecedores()));
			comboBoxFornecedor.setModel(modeloComboBoxFornecedor);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		comboBoxFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		MBVeiculo mbVeiculo= MBVeiculo.getInstance();
		comboBoxVeiculo = new JComboBox<Veiculo>();
		DefaultComboBoxModel<Veiculo> modeloComboBoxVeiculo;
		try {
			modeloComboBoxVeiculo = new DefaultComboBoxModel<Veiculo>(new Vector(mbVeiculo.listarVeiculos()));
			comboBoxVeiculo.setModel(modeloComboBoxVeiculo);
		} catch (Exception e) {
			// TODO: handle exception
		}	
		
		comboBoxVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldKm = new JTextField();
		textFieldKm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldKm.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemServišo();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MBServico mbServico = MBServico.getInstance();
				MBTipoServico mbTipoServico = MBTipoServico.getInstance();
				MBMotorista mbMotorista = MBMotorista.getInstance();
				MBVeiculo  mbVeiculo= MBVeiculo.getInstance();
				MBFornecedor mbFornecedor= MBFornecedor.getInstance();
				java.sql.Timestamp data = new java.sql.Timestamp(System.currentTimeMillis());
				Servico s =  new Servico(new Integer(idServicoSelecionado), 
						mbMotorista.retornarMotorista(comboBoxMotorista.getItemAt(comboBoxMotorista.getSelectedIndex()).getIdmotorista()),
						mbVeiculo.retornarVeiculo(comboBoxVeiculo.getItemAt(comboBoxVeiculo.getSelectedIndex()).getIdveiculo()),
						mbFornecedor.retornarFornecedor((comboBoxFornecedor.getItemAt(comboBoxFornecedor.getSelectedIndex()).getIdfornecedor())),
						mbTipoServico.retornarTipoServico((comboBoxTipoServišo.getItemAt(comboBoxTipoServišo.getSelectedIndex()).getIdtipoServico())),
						data, Double.parseDouble(textFieldValor.getText()), textFieldOršamento.getText(), 
						Integer.parseInt(textFieldCupomFiscal.getText()), textFieldDescrišŃo.getText(), Integer.parseInt(textFieldKm.getText()));

					try {
						if (idServicoSelecionado==0){
							if (s.getIdServico()==0){
								s.setIdServico(null);
							}
							String retorno = mbServico.inserir(s);
							if (retorno.equals("ok")){
								
								JOptionPane.showMessageDialog(null,"Servišo inserido!");
								PanelListagemServišo();
							}else{
								JOptionPane.showMessageDialog(null,retorno);
							}
						}else{
							
							String retorno =  mbServico.editar(s);
							if (retorno.equals("ok")){
								JOptionPane.showMessageDialog(null,"Servišo alterado!");
								PanelListagemServišo();
							}else{
								JOptionPane.showMessageDialog(null,retorno);
							}
					}
						} catch (Exception e) {
						// TODO: handle exception
					}
				PanelListagemServišo();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblKm)
										.addComponent(lblDescrio)
										.addComponent(lblCupomFiscal)
										.addComponent(lblOramento)
										.addComponent(lblVeiculo, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblValor)
										.addComponent(lblData)
										.addComponent(lblFornecedor)
										.addComponent(lblTipodeServio)
										.addComponent(lblMotorista, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textFieldData, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addComponent(textFieldValor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addComponent(comboBoxVeiculo, 0, 685, Short.MAX_VALUE)
										.addComponent(comboBoxTipoServišo, 0, 685, Short.MAX_VALUE)
										.addComponent(textFieldOršamento, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addComponent(textFieldCupomFiscal, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addComponent(textFieldDescrišŃo, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addComponent(textFieldKm, GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
										.addComponent(comboBoxMotorista, 0, 0, Short.MAX_VALUE)
										.addComponent(comboBoxFornecedor, Alignment.TRAILING, 0, 685, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblCadastroServio))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroServio)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblData)
						.addComponent(textFieldData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValor)
						.addComponent(textFieldValor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOramento)
						.addComponent(textFieldOršamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCupomFiscal)
						.addComponent(textFieldCupomFiscal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDescrio)
						.addComponent(textFieldDescrišŃo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKm)
						.addComponent(textFieldKm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxMotorista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMotorista, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxTipoServišo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipodeServio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVeiculo)
						.addComponent(comboBoxVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxFornecedor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFornecedor))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addGap(83))
		);
		setLayout(groupLayout);
		if (idServicoSelecionado>0){
			MBServico mbServico = MBServico.getInstance();
			
			try {
				Servico s = mbServico.retornarServico(idServicoSelecionado);
				textFieldCupomFiscal.setText(s.getNfTicket().toString());
				textFieldDescrišŃo.setText(s.getDescricao());
				textFieldKm.setText(s.getKm().toString());
				textFieldValor.setText(s.getValor().toString());
				textFieldData.setText(System.currentTimeMillis()+"");
					
				boolean aux = false ;
				int  i=0; 
					
				while(aux==false){
						aux= mbFornecedor.listarFornecedores().get(i).getIdfornecedor()==s.getFornecedor().getIdfornecedor();
				   		if (aux==true) break; 
				   		i++;
						
					}
					comboBoxFornecedor.setSelectedIndex(i);} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						
					}}

	}
	public void PanelListagemServišo(){
		try {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent();
			parent.PanelListagemServišo();
		} catch (Exception e) {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
			parent.PanelListagemServišo();
		}
		
	}
}
