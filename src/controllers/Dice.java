package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

public class Dice {

	private Die d1;
	private Die d2;
	private Die d3;
	private Die d4;
	private Die d5;
	private Die d6;
	private Die[] diceArr = new Die[7];
	
	int wins;
	int losses;

	public Dice() {
		d1 = new Die();
		d1.setValue(1);
		d1.setImage();
		d2 = new Die();
		d2.setValue(2);
		d2.setImage();

		d3 = new Die();
		d3.setValue(3);
		d3.setImage();

		d4 = new Die();
		d4.setValue(4);
		d4.setImage();

		d5 = new Die();
		d5.setValue(5);
		d5.setImage();

		d6 = new Die();
		d6.setValue(6);
		d6.setImage();

		diceArr[0] = null;
		diceArr[1] = d1;
		diceArr[2] = d2;
		diceArr[3] = d3;
		diceArr[4] = d4;
		diceArr[5] = d5;
		diceArr[6] = d6;
	}

	public synchronized Die[] roll() {
		Die[] tempArr = new Die[5];
		Random rand = new Random();
		for (int y = 0; y <= tempArr.length - 1; y++) {
			tempArr[y] = diceArr[rand.nextInt(6 - 1 + 1) + 1];
		}
		return tempArr;

	}
	
	public void writeToFile(int []arr){
		try {
            File path = new File("C:\\Users\\Shayne\\Documents\\DiceStats.txt");
            FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter outputWriter = new OutputStreamWriter(fos);    
            Writer writer = new BufferedWriter(outputWriter);
            writer.write(arr[0] +":"+arr[1]);
            writer.close();
            System.out.println("Done");
            readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public int[] readFromFile(){
		int[] temp=new int [2];
		String line;
		String [] z={"78","152"};
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Shayne\\Documents\\DiceStats.txt")))
		{

			
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				z=line.split(":");
			}
			
			
			
//			String[] parts =new String[2];
//			parts= line.split(":");
			String part1 = z[0]; 
			String part2 = z[1]; 
		
			temp[0]=Integer.parseInt(part1);
			temp[1]=Integer.parseInt(part2);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return temp;
	}

	/**
	 * If total score/roll < 15
	 * then reroll all dice below 4
	 * if any dice is 1 0r 3 reroll 
	 * if all dice 4 or greaater do not reroll
	 * **/
	public int getTotal(Die[] arr){
		int total=0;
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].getValue());
			total += arr[i].getValue();
		}
		return total;
	}
	public Die[] computerRollLogic(Die[] temp) {
		Random rand=new Random();
		Die[] finalArr;
		int[] indexesToChange=new int[5]; //array to store indexes of dice which need ot be changed
		int total=getTotal(temp); //the total score for the array
		
		if(total>=24){
			finalArr=temp; //if total is more then 24 no changes are made
		}
		if(total<16){
			for (int i = 0; i < temp.length; i++) {
				if(temp[i].getValue()<4){
					temp[i].setValue(rand.nextInt(6 - 1 + 1) + 1);
				}
				
			}
		}
		
		return null;
	}

}
