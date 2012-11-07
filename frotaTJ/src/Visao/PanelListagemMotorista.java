package Visao;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import mb.MBServico;

import dao.Servico;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PanelListagemMotorista extends PanelExemplo {
	private JTable table;
	private int idServicoSelecionado;

	/**
	 * Create the panel.
	 */
	public PanelListagemMotorista() {
		
		JLabel lblListagemMotoristas = new JLabel("Listagem Motoristas");
		lblListagemMotoristas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelCadastroServi�o();
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		final JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				MBServico mbServico = MBServico.getInstance();
				try {
					Servico s = mbServico.retornarServico(idServicoSelecionado);
					int op = JOptionPane.showConfirmDialog(null,"Deseja realmente apagar o Servi�o selecionado ?");
					if (op==JOptionPane.YES_OPTION ) {
						
						
						JOptionPane.showMessageDialog(null,mbServico.apagar(s));
						atualizarTabela();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"erro - "+e);
					// TODO: handle exception
				}
			
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		final JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanelEditarServico();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNovo)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnApagar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnVoltar))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblListagemMotoristas)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblListagemMotoristas)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar)
						.addComponent(btnApagar)
						.addComponent(btnNovo)
						.addComponent(btnEditar))
					.addContainerGap())
		);
		btnEditar.setVisible(false);
		btnApagar.setVisible(false);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				idServicoSelecionado = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 1)+"");
				btnEditar.setVisible(true);
				btnApagar.setVisible(true);
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Matr�cula", "Nome"
			}
		));
		scrollPane.setViewportView(table);
		try {
			atualizarTabela();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(groupLayout);
	}
	public void PanelCadastroServi�o(){
		try {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent();
			parent.PanelCadastroServi�o(0);
		} catch (Exception e) {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
			parent.PanelCadastroServi�o(0);
		}
	}
	public void PanelEditarServico(){
		try {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent();
			parent.PanelCadastroServi�o(idServicoSelecionado);
		} catch (Exception e) {
			TelaPrincipal	parent = (TelaPrincipal)getParent().getParent().getParent().getParent();
			parent.PanelCadastroServi�o(idServicoSelecionado);
		}
	}
	public void atualizarTabela() throws ClassNotFoundException, SQLException{
		((DefaultTableModel)table.getModel()).setRowCount(0);
		MBServico mbServico= MBServico.getInstance();
		List<Servico> listaServico = mbServico.listarServicos();
		for (int i=0;i<listaServico.size();i++){
			((DefaultTableModel)table.getModel()).addRow(new String[]{
					listaServico.get(i).getData2().toString().substring(8, 10)+"/"+listaServico.get(i).getData2().toString().substring(5, 7)+
					"/"+listaServico.get(i).getData2().toString().substring(0, 4), listaServico.get(i).getIdServico()+"", 
					listaServico.get(i).getValor()+"", listaServico.get(i).getNroOrcamento(), listaServico.get(i).getNfTicket()+"",
					listaServico.get(i).getDescricao(), listaServico.get(i).getKm()+"", listaServico.get(i).getMotorista().getNome(),
					listaServico.get(i).getTipoServico().getNome(),	listaServico.get(i).getVeiculo().getPlaca()+"", 
					listaServico.get(i).getFornecedor().getNome()});
		}
	}
}