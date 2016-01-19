package controllers;


import javax.swing.ImageIcon;

public class Die implements DieIntf, Comparable<Die> {
private int value;
private ImageIcon icon=null;

	@Override
	public int compareTo(Die die) {
		if(this.value==die.getValue()){
			return 0;
		}else if(this.value>die.value){
			return 1;
		}else if(this.value<die.getValue()){
			return -1;
		}
		return 0;
	}

	@Override
	public ImageIcon getDieImage() {
		if(icon==null){
			System.out.println("Icon is null");
		}
		return icon;
	}

	@Override
	public void setImage() {
		switch(value){
		case 1:
			icon= new ImageIcon(getClass().getResource("/images/die1.png"));
			break;
		case 2:
			icon= new ImageIcon(getClass().getResource("/images/die2.png"));
			break;
		case 3:
			icon= new ImageIcon(getClass().getResource("/images/die3.png"));
			break;
		case 4:
			icon= new ImageIcon(getClass().getResource("/images/die4.png"));
			
			break;
		case 5:
			icon= new ImageIcon(getClass().getResource("/images/die5.png"));
			break;
		case 6:
			icon= new ImageIcon(getClass().getResource("/images/die6.png"));
			break;
		default:
			icon= new ImageIcon(getClass().getResource("/images/die4.png"));
			break;
		}
	}

	@Override
	public void setValue(int v) {
		this.value=v;
	}

	@Override
	public int getValue() {
		return value;
	}

}
