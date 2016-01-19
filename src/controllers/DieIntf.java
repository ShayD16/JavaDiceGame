package controllers;


import javax.swing.ImageIcon;

public interface DieIntf {
	ImageIcon getDieImage();// (returning an ImageIcon)

	void setImage();// (which sets the image associated with the face of a die
					// for a die class implementing the interface)

	void setValue(int v); // which sets the value of the face of a die (which
							// number is displayed on the top of a die)

	int getValue();// (which returns the value of the face of a die, i.e. which
					// number is displayed on the top of a die).
}
