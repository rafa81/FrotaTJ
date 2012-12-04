package Visao;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import dao.Fornecedor;
import dao.Modelo;
import mb.MBFornecedor;
import mb.MBMarca;
import mb.MBModelo;
import javax.swing.ImageIcon;

public class PanelCadastroFornecedor extends PanelExemplo {
	private JTextField textFieldNome;
	private JTextField textFieldCNPJ;
	private JTextField textFieldEmailUm;
	private JTextField textFieldFoneUm;
	private JTextField textFieldFoneDois;

	/**
	 * Create the panel.
	 */
	public PanelCadastroFornecedor(final int idFornecedorSelecionado) {
		
		JLabel lblCadastroFornecedor = new JLabel("Cadastro Fornecedor");
		lblCadastroFornecedor.setIcon(new ImageIcon("imagens\\1003_32x32.png"));
		lblCadastroFornecedor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("imagens\\7464_32x32.png"));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemFornecedor();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("imagens\\7484_16x16.png"));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MBFornecedor mbFornecedor = MBFornecedor.getInstance();

				Fornecedor f =  new Fornecedor(idFornecedorSelecionado,textFieldNome.getText(), textFieldCNPJ.getText(), textFieldEmailUm.getText(),
						textFieldFoneUm.getText(), textFieldFoneDois.getText());
						

					try {
						if (idFornecedorSelecionado==0){
							if (f.getIdfornecedor()==0){
								f.setIdfornecedor(null);
							}
							String retorno = mbFornecedor.inserir(f);
							if (retorno.equals("ok")){
								
								JOptionPane.showMessageDialog(null,"Cadastro inserido!");
								PanelListagemFornecedor();
							}else{
								JOptionPane.showMessageDialog(null,retorno);
							}
						}else{
							
							String retorno =  mbFornecedor.editar(f);
							if (retorno.equals("ok")){
								JOptionPane.showMessageDialog(null,"Cadastro alterado!");
								PanelListagemFornecedor();
							}else{
								JOptionPane.showMessageDialog(null,retorno);
							}
					}
						} catch (Exception e) {
						// TODO: handle exception
					}
					
					
					
		
				}
				
				}
				
			
		);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldNome.setColumns(10);
		
		JLabel lblMarca = new JLabel("CNPJ");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		MaskFormatter cnpj = null;
		try {
			cnpj = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		textFieldCNPJ = new JFormattedTextField(cnpj);
		textFieldCNPJ.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblFone = new JLabel("Fone 1");
		lblFone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblFone_1 = new JLabel("Fone 2");
		lblFone_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textFieldEmailUm = new JTextField();
		textFieldEmailUm.setColumns(10);
		
		textFieldFoneUm = new JTextField();
		textFieldFoneUm.setColumns(10);
		
		textFieldFoneDois = new JTextField();
		textFieldFoneDois.setColumns(10);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblMarca)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldCNPJ, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textFieldEmailUm, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblFone_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblFone, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldFoneDois, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
								.addComponent(textFieldFoneUm, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)))
						.addComponent(lblCadastroFornecedor))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCadastroFornecedor)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarca)
						.addComponent(textFieldCNPJ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmailUm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFone, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFoneUm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFone_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldFoneDois, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		if (idFornecedorSelecionado>0){
			MBFornecedor mbFornecedor = MBFornecedor.getInstance();
			
			try {
				Fornecedor f = mbFornecedor.retornarFornecedor(idFornecedorSelecionado);
				textFieldNome.setText(f.getNome());
				textFieldCNPJ.setText(f.getCnpj());
				textFieldEmailUm.setText(f.getEmail());
				textFieldFoneUm.setText(f.getFone1());
				textFieldFoneDois.setText(f.getFone2());
													
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"erro - "+e);
				// TODO: handle exception
			}
			
		}

	}
	public void PanelListagemFornecedor(){
		try {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent();
			parent.PanelListagemFornecedor();
		} catch (Exception e) {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
			parent.PanelListagemFornecedor();
		}
	}
}
