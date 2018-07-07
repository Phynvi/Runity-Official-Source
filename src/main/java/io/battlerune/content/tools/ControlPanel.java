package io.battlerune.content.tools;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import io.battlerune.content.tools.impl.characters.CharactersLoading;
import io.battlerune.game.world.entity.mob.player.PlayerRight;

public class ControlPanel extends JFrame {

	private static final long serialVersionUID = -8081182147836655863L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlPanel frame = new ControlPanel();
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
	@SuppressWarnings("unchecked")
	public ControlPanel() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 640, 371);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);

		String[] array = CharactersLoading.getPlayers().toArray(new String[CharactersLoading.getPlayers().size()]);
		JComboBox comboBox = new JComboBox(array);
		comboBox.setBounds(15, 31, 213, 26);
		panel.add(comboBox);

		JLabel lblNewLabel = new JLabel("Player");
		lblNewLabel.setBounds(15, 6, 69, 26);
		panel.add(lblNewLabel);

		JLabel lblConsole = new JLabel("Console");
		lblConsole.setBounds(427, 9, 69, 20);
		panel.add(lblConsole);

		TextArea textArea = new TextArea();
		textArea.setBounds(309, 31, 316, 296);
		panel.add(textArea);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranking / Points",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(15, 81, 268, 246);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblRank = new JLabel("Rank");
		lblRank.setBounds(15, 37, 69, 20);
		panel_1.add(lblRank);

		JComboBox comboBox_1 = new JComboBox(PlayerRight.values());
		comboBox_1.setBounds(15, 57, 220, 26);
		panel_1.add(comboBox_1);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnUpdate.setBounds(65, 99, 115, 29);
		panel_1.add(btnUpdate);
	}
}
