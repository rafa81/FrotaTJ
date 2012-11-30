package Visao;
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

import dao.Marca;
import mb.MBMarca;

public class PanelCadastroMarca extends PanelExemplo {
	private JTextField textFieldNome;

	/**
	 * Create the panel.
	 */
	public PanelCadastroMarca(final int idMarcaSelecionado) {
		
		JLabel lblCadastroMarca = new JLabel("Cadastro Marca");
		lblCadastroMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelListagemMarca();
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MBMarca mbMarca = MBMarca.getInstance();

				Marca m =  new Marca(idMarcaSelecionado, textFieldNome.getText());
						

					try {
						if (idMarcaSelecionado==0){
							if (m.getIdmarca()==0){
								m.setIdmarca(null);
							}
							String retorno = mbMarca.inserir(m);
							if (retorno.equals("ok")){
								
								JOptionPane.showMessageDialog(null,"Marca inserido!");
								PanelListagemMarca();
							}else{
								JOptionPane.showMessageDialog(null,retorno);
							}
						}else{
							
							String retorno =  mbMarca.editar(m);
							if (retorno.equals("ok")){
								JOptionPane.showMessageDialog(null,"Marca alterado!");
								PanelListagemMarca();
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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblCadastroMarca)
							.addGap(281))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNome)
							.addGap(6)
							.addComponent(textFieldNome, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(lblCadastroMarca)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNome)
						.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(111)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnSalvar))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		if (idMarcaSelecionado>0){
			MBMarca mbMarca = MBMarca.getInstance();
			
			try {
				Marca m = mbMarca.retornarMarca(idMarcaSelecionado);
				textFieldNome.setText(m.getNome());
													
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"erro - "+e);
				// TODO: handle exception
			}
			
		}

	}
	public void PanelListagemMarca(){
		try {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent();
			parent.PanelListagemMarca();
		} catch (Exception e) {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
			parent.PanelListagemMarca();
		}
	}
}
