package GUI;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;
import javax.swing.border.MatteBorder;

import controllers.DiceGameFormController;
import controllers.Die;

public class DiceGameForm extends JFrame {
	DiceGameFormController controller = new DiceGameFormController();
	private JPanel mainPanel;
	private JPanel landingPanel;
	private JPanel gamePanel;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuItem;
	/** Components for landing panel **/
	private JLabel label1; // Dice Game
	private JScrollPane instructionsTxtScroll; // Game Instructions text
	private JTextArea instructionsTxt; // Game Instructions text
	private JLabel label2; // Prompt for name
	private JTextField nameInput; // Input for the name
	private JLabel label3; // Prompt for winning score
	private JTextField scoreInput = new JTextField(); // Input for the target
														// score
	private JButton continueButton; // button to start the game
	/** Components for game panel **/
	private JPanel computerDetailsPanel;
	private JPanel playerDetailsPanel;
	private JLabel label4;// above computer panel
	private JLabel label5; // players name
	private JButton throwButton;
	private JButton scoreButton;
	private JButton newGameButton;
	private JButton rethrowButton;

	private JLabel dice1_P;
	private JLabel dice2_P;
	private JLabel dice3_P;
	private JLabel dice4_P;
	private JLabel dice5_P;
	private JLabel scoreDisp;
	private JLabel scoreLabel;
	private JLabel throwsAttemptLabel;
	private JLabel throwsDisp;
	private JLabel totalScoreDisp;
	private JLabel totalScoreLabel;
	private JLabel attemptsDisp;
	private JLabel attemptsLabel;

	private JRadioButton d1Radio;
	private JRadioButton d2Radio;
	private JRadioButton d3Radio;
	private JRadioButton d4Radio;
	private JRadioButton d5Radio;

	private JLabel dice1_C;
	private JLabel dice2_C;
	private JLabel dice3_C;
	private JLabel dice4_C;
	private JLabel dice5_C;

	private JLabel compScoreDisp;
	private JLabel compScoreLabel;
	private JLabel compTotalScoreDisp;
	private JLabel compTotalScoreLabel;
	private JLabel[] diceLabelArr_P = new JLabel[5];
	private JLabel[] diceLabelArr_C = new JLabel[5];

	ImageIcon rollingIcon;

	public DiceGameForm() {
		initForm();

	}

	private void initLandingPanel() {
		// Landing Page
		label1 = new JLabel(); // Dice Game
		instructionsTxt = new JTextArea(); // Game Instructions text
		instructionsTxtScroll = new JScrollPane();
		label2 = new JLabel(); // Prompt for name
		nameInput = new JTextField(); // Input for the name
		label3 = new JLabel(); // Prompt for winning score
		// scoreInput = new JTextField(); // Input for the target score
		continueButton = new JButton(); // button to start the game

		label1.setFont(new Font("Tahoma", 1, 24));
		label1.setText("Dice Game");

		instructionsTxt.setColumns(20);
		instructionsTxt.setRows(5);
		instructionsTxt.setText(
				"The objective of the game is to reach the target score within 5 rolls. \nEach Player gets 5 dice and 5 rolls. \nIn each roll the player is entitled to no more than 2 optional re-rolls.\nDuring a re-roll a player can change all the dice or some of the dice(select dice you do not want to change.)\nPress throw to roll.\nPress ReThrow after selecting the dice you wish to keep.\n Press score if you are satisfied with the rolls.");
		instructionsTxtScroll.setViewportView(instructionsTxt);

		label2.setText("Enter your Name:");
		nameInput.setText("Player 1");

		label3.setText("Enter Desired Score(Default 101):");
		scoreInput.setText("101");

		continueButton.setText("Continue");
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				continueButtonAction(evt);
			}
		});

		/** Configuring the first panel with all of its components **/
		GroupLayout landingPanelLayout = new GroupLayout(landingPanel);
		landingPanel.setLayout(landingPanelLayout);
		landingPanelLayout.setHorizontalGroup(landingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(landingPanelLayout.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(label1)
						.addGap(108, 108, 108))
				.addGroup(GroupLayout.Alignment.TRAILING, landingPanelLayout.createSequentialGroup()
						.addGroup(landingPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(GroupLayout.Alignment.LEADING,
										landingPanelLayout.createSequentialGroup().addContainerGap().addComponent(
												instructionsTxtScroll))
								.addGroup(GroupLayout.Alignment.LEADING,
										landingPanelLayout.createSequentialGroup().addGap(18, 18, 18)
												.addGroup(landingPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING, false)
														.addGroup(landingPanelLayout.createSequentialGroup()
																.addComponent(label2)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(nameInput))
														.addGroup(landingPanelLayout.createSequentialGroup()
																.addComponent(label3)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
																.addComponent(scoreInput, GroupLayout.PREFERRED_SIZE,
																		GroupLayout.DEFAULT_SIZE,
																		GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 196,
														Short.MAX_VALUE)
												.addComponent(continueButton)))
						.addGap(31, 31, 31)));
		landingPanelLayout.setVerticalGroup(landingPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(landingPanelLayout.createSequentialGroup().addContainerGap().addComponent(label1)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(instructionsTxtScroll, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
						.addGroup(landingPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(label2).addComponent(nameInput, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(landingPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(continueButton).addComponent(label3).addComponent(scoreInput,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(23, 23, 23)));

		mainPanel.add(landingPanel, "landingCard");
	}

	private void initGamePanel() {
		// Game Page
		computerDetailsPanel = new JPanel();
		playerDetailsPanel = new JPanel();
		label4 = new JLabel();// above computer panel
		label5 = new JLabel(); // players name
		throwButton = new JButton();
		scoreButton = new JButton();
		newGameButton = new JButton();
		rethrowButton = new JButton();
		rollingIcon = new ImageIcon(getClass().getResource("/images/rolling.png"));

		d1Radio = new JRadioButton();
		d2Radio = new JRadioButton();
		d3Radio = new JRadioButton();
		d4Radio = new JRadioButton();
		d5Radio = new JRadioButton();

		dice1_P = new JLabel();
		dice1_P.setIcon(rollingIcon);
		diceLabelArr_P[0] = dice1_P;
		dice2_P = new JLabel();
		dice2_P.setIcon(rollingIcon);
		diceLabelArr_P[1] = dice2_P;
		dice3_P = new JLabel();
		dice3_P.setIcon(rollingIcon);
		diceLabelArr_P[2] = dice3_P;
		dice4_P = new JLabel();
		dice4_P.setIcon(rollingIcon);
		diceLabelArr_P[3] = dice4_P;
		dice5_P = new JLabel();
		dice5_P.setIcon(rollingIcon);
		diceLabelArr_P[4] = dice5_P;

		scoreLabel = new JLabel();
		scoreLabel.setText("Score:");
		scoreDisp = new JLabel();
		scoreDisp.setText(Integer.toString(score));
		totalScoreLabel = new JLabel();
		totalScoreLabel.setText("Total Score:");
		totalScoreDisp = new JLabel();
		totalScoreDisp.setText(Integer.toString(totalScore));
		attemptsLabel = new JLabel();
		attemptsLabel.setText("Attempts:");
		attemptsDisp = new JLabel();
		attemptsDisp.setText(Integer.toString(throwCounter));
		throwsAttemptLabel = new JLabel();
		throwsAttemptLabel.setText("Throws this Attempt:");
		throwsDisp = new JLabel();
		throwsDisp.setText(Integer.toString(rethrowCounter));

		dice1_C = new JLabel();
		dice1_C.setIcon(rollingIcon);
		diceLabelArr_C[0] = dice1_C;
		dice2_C = new JLabel();
		dice2_C.setIcon(rollingIcon);
		diceLabelArr_C[1] = dice2_C;
		dice3_C = new JLabel();
		dice3_C.setIcon(rollingIcon);
		diceLabelArr_C[2] = dice3_C;
		dice4_C = new JLabel();
		dice4_C.setIcon(rollingIcon);
		diceLabelArr_C[3] = dice4_C;
		dice5_C = new JLabel();
		dice5_C.setIcon(rollingIcon);
		diceLabelArr_C[4] = dice5_C;

		compScoreLabel = new JLabel();
		compScoreLabel.setText("Score");
		compScoreDisp = new JLabel();
		compScoreDisp.setText("00");

		compTotalScoreLabel = new JLabel();
		compTotalScoreLabel.setText("Total Score");
		compTotalScoreDisp = new JLabel();
		compTotalScoreDisp.setText("00");

		label4.setText("Computer");
		label5.setText("Player");

		playerDetailsPanel.setBorder(new MatteBorder(null));
		GroupLayout playerPanelLayout = new GroupLayout(playerDetailsPanel);
		playerDetailsPanel.setLayout(playerPanelLayout);
		playerPanelLayout
				.setHorizontalGroup(
						playerPanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(
										playerPanelLayout.createSequentialGroup().addGap(19, 19, 19)
												.addGroup(
														playerPanelLayout
																.createParallelGroup(
																		GroupLayout.Alignment.LEADING)
																.addGroup(playerPanelLayout.createSequentialGroup()
																		.addComponent(scoreLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(scoreDisp)
																.addPreferredGap(
																		LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(totalScoreLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(totalScoreDisp).addGap(18, 18, 18).addComponent(attemptsLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(attemptsDisp)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(throwsAttemptLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(throwsDisp))
						.addGroup(playerPanelLayout.createSequentialGroup().addGroup(playerPanelLayout
								.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(playerPanelLayout.createSequentialGroup().addComponent(dice1_P)
										.addGap(18, 18, 18).addComponent(dice2_P)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(dice3_P)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(dice4_P))
								.addGroup(playerPanelLayout.createSequentialGroup().addGap(21, 21, 21)
										.addComponent(d1Radio).addGap(53, 53, 53).addComponent(d2Radio)
										.addGap(48, 48, 48).addComponent(d3Radio).addGap(51, 51, 51)
										.addComponent(d4Radio)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(playerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(playerPanelLayout.createSequentialGroup().addComponent(dice5_P)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(rethrowButton))
										.addGroup(playerPanelLayout.createSequentialGroup().addGap(16, 16, 16)
												.addComponent(d5Radio)))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		playerPanelLayout
				.setVerticalGroup(playerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING,
								playerPanelLayout.createSequentialGroup()
										.addGroup(playerPanelLayout
												.createParallelGroup(
														GroupLayout.Alignment.LEADING)
												.addGroup(playerPanelLayout
														.createParallelGroup(GroupLayout.Alignment.LEADING)
														.addComponent(d1Radio).addComponent(d2Radio)
														.addComponent(d3Radio)
														.addComponent(d4Radio, GroupLayout.Alignment.TRAILING))
								.addComponent(d5Radio, GroupLayout.Alignment.TRAILING))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
						.addGroup(playerPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(dice1_P)
								.addGroup(playerPanelLayout.createSequentialGroup().addGap(17, 17, 17)
										.addComponent(rethrowButton))
								.addGroup(playerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(dice2_P).addComponent(dice3_P).addComponent(dice4_P).addComponent(
												dice5_P)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(playerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(scoreLabel).addComponent(scoreDisp)
												.addComponent(totalScoreLabel).addComponent(totalScoreDisp)
												.addComponent(attemptsLabel).addComponent(attemptsDisp)
												.addComponent(throwsAttemptLabel).addComponent(throwsDisp))
						.addGap(6, 6, 6)));

		computerDetailsPanel.setBorder(new MatteBorder(null));
		GroupLayout computerPanelLayout = new GroupLayout(computerDetailsPanel);
		computerDetailsPanel.setLayout(computerPanelLayout);
		computerPanelLayout
				.setHorizontalGroup(
						computerPanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(
										computerPanelLayout.createSequentialGroup().addGap(24, 24, 24)
												.addGroup(
														computerPanelLayout
																.createParallelGroup(GroupLayout.Alignment.LEADING)
																.addGroup(computerPanelLayout.createSequentialGroup()
																		.addComponent(compScoreLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(compScoreDisp).addGap(18, 18, 18)
																.addComponent(compTotalScoreLabel)
																.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(compTotalScoreDisp)).addGroup(
																		computerPanelLayout.createSequentialGroup()
																				.addComponent(dice1_C)
																				.addPreferredGap(
																						LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(dice2_C)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(dice3_C)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(dice4_C).addGap(18, 18, 18)
																		.addComponent(dice5_C)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		computerPanelLayout
				.setVerticalGroup(
						computerPanelLayout
								.createParallelGroup(
										GroupLayout.Alignment.LEADING)
								.addGroup(
										computerPanelLayout.createSequentialGroup()
												.addGap(25, 25,
														25)
												.addGroup(computerPanelLayout
														.createParallelGroup(GroupLayout.Alignment.TRAILING)
														.addComponent(dice5_C).addComponent(dice4_C)
														.addComponent(dice3_C).addComponent(dice2_C)
														.addComponent(dice1_C))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(computerPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(compScoreLabel).addComponent(compScoreDisp)
										.addComponent(compTotalScoreLabel).addComponent(compTotalScoreDisp))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		throwButton.setText("Throw");
		throwButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				throwButtonActionPerformed(evt);
			}
		});

		rethrowButton.setText("Rethrow");
		rethrowButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				reThrowButtonActionPerformed(evt);
			}
		});

		scoreButton.setText("Score");
		scoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				scoreButtonActionPerformed(evt);
			}
		});

		newGameButton.setText("New Game");
		newGameButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				newGameButtonActionPerformed(evt);
			}
		});

		/** Configuring the second panel with all of its components **/
		GroupLayout gamePanelLayout = new GroupLayout(gamePanel);
		gamePanel.setLayout(gamePanelLayout);
		gamePanelLayout.setHorizontalGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(gamePanelLayout.createSequentialGroup().addGap(22, 22, 22).addGroup(gamePanelLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(label5)
						.addGroup(gamePanelLayout.createSequentialGroup()
								.addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(gamePanelLayout.createSequentialGroup().addComponent(throwButton)
												.addGap(27, 27, 27).addComponent(scoreButton).addGap(89, 89, 89))
										.addComponent(label4, GroupLayout.Alignment.LEADING))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(newGameButton))
						.addComponent(computerDetailsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(playerDetailsPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE))
						.addContainerGap(35, Short.MAX_VALUE)));
		gamePanelLayout.setVerticalGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				gamePanelLayout.createSequentialGroup().addGap(5, 5, 5).addComponent(label4)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(computerDetailsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(label5).addGap(5, 5, 5)
						.addComponent(playerDetailsPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
						.addGroup(gamePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(newGameButton).addComponent(throwButton).addComponent(scoreButton))
						.addContainerGap()));

		mainPanel.add(gamePanel, "gameCard");
	}

	private void initForm() {

		mainPanel = new JPanel();
		landingPanel = new JPanel();
		gamePanel = new JPanel();
		menuBar = new JMenuBar();
		menu = new JMenu();
		menuItem = new JMenuItem();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.FlowLayout());
		setTitle("Dice Game");

		mainPanel.setLayout(new CardLayout());
		initLandingPanel();
		initGamePanel();

		getContentPane().add(mainPanel);
		
		int z[]=controller.getStatistics();
		menu.setText("Wins: "+z[0]+"\t Losses: "+z[1]);

		menuBar.add(menu);

		setJMenuBar(menuBar);

		pack();
	}

	private int throwCounter = 0;
	private int rethrowCounter = 0;
	private Die[] arr; // array for players dice
	private Die[] arr_C;
	private int score = 0;
	private int score_C = 0;
	private int totalScore = 0;
	private int totalScore_C = 0;
	private int scoreCounter = 0;

	private void menuItemActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "Get statistics", "Statistics", JOptionPane.PLAIN_MESSAGE);
	}

	protected void reThrowButtonActionPerformed(ActionEvent evt) {
		if (rethrowCounter < 2) {
			Die[] arr = controller.getReroll();

			if (!d1Radio.isSelected()) {
				diceLabelArr_P[0].setIcon(arr[0].getDieImage());
				this.arr[0] = arr[0];
			}
			if (!d2Radio.isSelected()) {
				diceLabelArr_P[1].setIcon(arr[1].getDieImage());
				this.arr[1] = arr[1];
			}
			if (!d3Radio.isSelected()) {
				diceLabelArr_P[2].setIcon(arr[2].getDieImage());
				this.arr[2] = arr[2];
			}
			if (!d4Radio.isSelected()) {
				diceLabelArr_P[3].setIcon(arr[3].getDieImage());
				this.arr[3] = arr[3];
			}
			if (!d5Radio.isSelected()) {
				diceLabelArr_P[4].setIcon(arr[4].getDieImage());
				this.arr[4] = arr[4];
			}
			if (!(d1Radio.isSelected() || d2Radio.isSelected() || d3Radio.isSelected() || d4Radio.isSelected()
					|| d5Radio.isSelected())) {
				this.arr = arr;
				setDiceImages(arr);
			}
			rethrowCounter++;
			throwsDisp.setText(Integer.toString(rethrowCounter));
			unselectEverything();
		} else {
			JOptionPane.showMessageDialog(null, "Only 2 Rethrows per attempt", "Warning", JOptionPane.PLAIN_MESSAGE);

		}

	}

	private void continueButtonAction(ActionEvent evt) {
		if (!nameInput.getText().toString().isEmpty()) {
			label5.setText(nameInput.getText().toString());
		}
		CardLayout card = (CardLayout) mainPanel.getLayout();
		card.show(mainPanel, "gameCard");

	}

	private void newGameButtonActionPerformed(ActionEvent evt) {
		reinitGame();
		CardLayout card = (CardLayout) mainPanel.getLayout();
		card.show(mainPanel, "landingCard");

	}

	private void scoreButtonActionPerformed(ActionEvent evt) {
		scoreAction();
	}

	private void scoreAction() {
		if (scoreCounter == 0) {
			int total = 0;
			int total_C = 0;
			for (int i = 0; i < arr.length; i++) {
				System.out.println(this.arr[i].getValue());
				total += this.arr[i].getValue();
			}
			for (int i = 0; i < arr_C.length; i++) {
				System.out.println(this.arr_C[i].getValue());
				total_C += this.arr_C[i].getValue();
			}
			score = total;
			score_C = total_C;
			System.out.println(score);
			scoreDisp.setText(Integer.toString(score));
			compScoreDisp.setText(Integer.toString(score_C));
			checkWinner();
		}

	}

	private void checkWinner() {
		int target = 101;
		if (totalScore > target && totalScore > totalScore_C) {
			controller.setStatistics(0);
			JOptionPane.showMessageDialog(null, "You Win!!", "Game Over!", JOptionPane.PLAIN_MESSAGE);
		} else if (totalScore_C > target) {
			controller.setStatistics(1);
			JOptionPane.showMessageDialog(null, "You Lose", "Game Over!", JOptionPane.PLAIN_MESSAGE);
		} else if (throwCounter == 5 && totalScore < target) {
			controller.setStatistics(1);
			JOptionPane.showMessageDialog(null, "You Lose", "Game Over!", JOptionPane.PLAIN_MESSAGE);
		}

	}

	private void throwButtonActionPerformed(ActionEvent evt) {
		if (throwCounter < 5) {
			rethrowCounter = 0;
			totalScore = totalScore + score;
			totalScore_C = totalScore_C + score_C;
			score = 0;
			score_C = 0;
			scoreDisp.setText(Integer.toString(0));
			compScoreDisp.setText(Integer.toString(0));
			compTotalScoreDisp.setText(Integer.toString(totalScore_C));
			totalScoreDisp.setText(Integer.toString(totalScore));
			Die[] arr = controller.getRoll();
			this.arr = arr;
			setDiceImages(this.arr);
			throwCounter++;
			scoreCounter = 0;
			attemptsDisp.setText(Integer.toString(throwCounter));
			unselectEverything();
			computerThrow();
			scoreAction();
		}

	}

	private void computerThrow() {
		Die[] arr = controller.getCompRoll();
		this.arr_C = arr;
		setCompDice(arr);

	}

	private void setCompDice(Die[] arr) {
		for (int i = 0; i < arr.length; i++) {
			diceLabelArr_C[i].setIcon(arr[i].getDieImage());
		}
	}

	private void unselectEverything() {
		d1Radio.setSelected(false);
		d2Radio.setSelected(false);
		d3Radio.setSelected(false);
		d4Radio.setSelected(false);
		d5Radio.setSelected(false);

	}

	private void reinitGame() {
		throwCounter = 0;
		rethrowCounter = 0;
		scoreCounter = 0;
		score = 0;
		totalScore = 0;
		totalScore_C = 0;
		unselectEverything();
		int z[]=controller.getStatistics();
		menu.setText("Wins: "+z[0]+"\t Losses: "+z[1]);

		menuBar.add(menu);

		setJMenuBar(menuBar);
		scoreDisp.setText(Integer.toString(0));
		totalScoreDisp.setText(Integer.toString(0));
		attemptsDisp.setText(Integer.toString(0));
		throwsDisp.setText(Integer.toString(0));
		compScoreDisp.setText(Integer.toString(0));
		compTotalScoreDisp.setText(Integer.toString(0));
		for (int i = 0; i < diceLabelArr_P.length; i++) {
			diceLabelArr_P[i].setIcon(rollingIcon);
		}
		for (int i = 0; i < diceLabelArr_C.length; i++) {
			diceLabelArr_C[i].setIcon(rollingIcon);
		}
	}

	private void setDiceImages(Die[] diceArr) {
		for (int i = 0; i < diceArr.length; i++) {
			diceLabelArr_P[i].setIcon(diceArr[i].getDieImage());
		}

	}
}