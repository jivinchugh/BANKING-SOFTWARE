/**
 * 
 */
package JavaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

//import jdk.internal.misc.FileSystemOption;

public class JavaProject {
	

	// Variables used for transfering money between accounts
	int Saving,Checking,saveacc,checkacc;
	// Variables used here are used in the methods defined below
	int Current_Balance,deposit_money,withdraw_money,transaction,fee = 5;
	//Create Account Variables
	String Customer_Name, Customer_Mail, Country, Postal,phone,DOB;
	//Random class is created and will generate Random numbers for the Account types Savings and Checking
	Random rand = new Random();
	
	//Create Account Method gives option to user to either create Savings or Checking Account
	public void Create_Acc()
	{
	 System.out.println("Enter the Account to be Created");
	 System.out.println("1. Press '1' to create Savings Account\n"+"2. Press '2' to create Checking Account");
	 Scanner scanner = new Scanner(System.in);
	 int input;
	 input=scanner.nextInt();
	 if(input==1)
	 {
		 //JOptionPane shows the welcome message.
		 JOptionPane.showMessageDialog(null, "Welcome to Savings Account");
		 //Enter Customer Name
		 Customer_Name=JOptionPane.showInputDialog("Customer Name");
		 //Dialog box shows entered name
		 JOptionPane.showMessageDialog(null,"Customer Name is "+Customer_Name);
		 
		 //Enter Mail Address
		 Customer_Mail = JOptionPane.showInputDialog("Enter Mail Address");
		 //Dialog box shows entered Mail Address
		 JOptionPane.showMessageDialog(null,"Mail Id is "+Customer_Mail);
		 
		 //Enter Phone Number
		 phone=JOptionPane.showInputDialog("Enter your phone number");
		 //Dialog box shows entered Phone Number
		 JOptionPane.showMessageDialog(null,"Phone number is"+phone);
		 
		 //Enter Date of Birth
		 DOB=JOptionPane.showInputDialog("Date of Birth");
		 //Dialog box shows entered date of birth
		 JOptionPane.showMessageDialog(null,"Date of Birth is "+DOB);
		 
		 //Enter Country
		 Country=JOptionPane.showInputDialog("Enter Country");
		 //Dialog box shows entered Country name
		 JOptionPane.showMessageDialog(null,"Country is "+Country);

		 //Enter Postal Code
		 Postal=JOptionPane.showInputDialog("Enter Postal Code");
		 //Dialog box shows entered Postal Code
		 JOptionPane.showMessageDialog(null,"Postal Code is "+Postal);
		 
		//JOptionPane shows the success message.
		 JOptionPane.showMessageDialog(null, "Successfully Saved the Saving Account Details in File.");
		
		 try{
			 File file = new File("Save.txt"); 
			 PrintWriter writer = new PrintWriter(file);
			 writer.write("Customer name: "+ Customer_Name +"\n" + "Mail Address: " + Customer_Mail+"\n"+ "Contact Info: "+ phone+"\n"+"Date of Birth: "+ DOB +"\n"+"Country: "+Country+"\n"+"Postal Code: "+Postal);
			 writer.close();
		 	} 
		 catch(IOException e)
		 {
			 e.printStackTrace();
         }
		 System.out.println("Saving account created successfully");
	 }
	 else
	 {
		 if(input==2)
		 //JOptionPane shows the welcome message.
		 JOptionPane.showMessageDialog(null, "Welcome to Checking Account");
		 //Enter Customer Name
		 Customer_Name=JOptionPane.showInputDialog("Customer Name");
		 //Dialog box shows entered name
		 JOptionPane.showMessageDialog(null,"Customer Name is "+Customer_Name);
		 
		 //Enter Mail Address
		 Customer_Mail = JOptionPane.showInputDialog("Enter Mail Address");
		 //Dialog box shows entered Mail Address
		 JOptionPane.showMessageDialog(null,"Mail Id is "+Customer_Mail);
		 
		 //Enter Phone Number
		 phone=JOptionPane.showInputDialog("Enter your phone number");
		 //Dialog box shows entered Phone Number
		 JOptionPane.showMessageDialog(null,"Phone number is"+phone);
		 
		 //Enter Date of Birth
		 DOB=JOptionPane.showInputDialog("Date of Birth");
		 //Dialog box shows entered date of birth
		 JOptionPane.showMessageDialog(null,"Date of Birth is "+DOB);
		 
		 //Enter Country
		 Country=JOptionPane.showInputDialog("Enter Country");
		 //Dialog box shows entered Country name
		 JOptionPane.showMessageDialog(null,"Country is "+Country);

		 //Enter Postal Code
		 Postal=JOptionPane.showInputDialog("Enter Postal Code");
		 //Dialog box shows entered Postal Code
		 JOptionPane.showMessageDialog(null,"Postal Code is "+Postal);
		 
		//JOptionPane shows the success message.
		 JOptionPane.showMessageDialog(null, "Successfully Saved Checking Account Details in File.");
		 
	     try{
	         File file = new File("Checking.txt"); 
	         PrintWriter writer = new PrintWriter(file);
	         writer.write("Customer name: "+ Customer_Name +"\n" + "Mail Address: " + Customer_Mail+"\n"+ "Contact Info: "+ phone+"\n"+"Date of Birth: "+ DOB +"\n"+"Country: "+Country+"\n"+"Postal Code: "+Postal);
	         writer.close();
	     	} 
	     catch(IOException e)
	     {
	         e.printStackTrace();
	     }
	 }
  }
	
	
	 /*Methods are created below
	   1. Deposit_Money()
	   2. Withdraw_Money()
	   3. Transaction()
	   4. transfer()
	   5. Utilty_Bills()
	   6. Update_Details()*/
	
	 //Deposit_Money method to deposit money
	 public int Deposit_Money (int deposit_money)
	 {
		 if(deposit_money !=0 )
		 {
			Current_Balance = Current_Balance+ deposit_money;
			transaction = deposit_money;
		 }
	     return transaction;
	  }
	    
	  // Validates the transaction, then withdraws the specified amount from the account and $10 fee is charged.
	  public int Withdraw_Money (int withdraw_money)
	  {
	   	if(withdraw_money !=0 )
		{
			Current_Balance = Current_Balance-withdraw_money - fee ;
			transaction = - withdraw_money;
		}
	    return transaction;
	  }
	  
	  //Returns Previous Transaction
	  public void Transaction()
	  {
		if(transaction > 0)
		{
			System.out.println("Deposited: " + transaction);
		}
		else if(transaction < 0)
		{
			System.out.println("Withdraw: " +Math.abs(transaction));
		}
		else
		{
			System.out.println("No Transaction");
		}
	  }
	  
	  //Transfers money from one bank to another and vice-versa
	  public void transfer(int withdraw_money) 
	  { 
	      saveacc=rand.nextInt(90000000);
	      checkacc=rand.nextInt(90000000);
	      System.out.println("Select the account to transfer money");
	      Scanner scanner = new Scanner(System.in);
	      String c =scanner.next();
	      if("saving"==c)
	      {
	    	  if(deposit_money >= withdraw_money)
	    	  {
	            Saving  =  deposit_money-withdraw_money;
	            Checking =  Checking + withdraw_money;
	            System.out.println("FundS Withdrawed from Saving Acccount "+saveacc+" balance is " +Saving);
	            System.out.println("FundS deposited in the Checking Account "+checkacc+" balance is "+Checking);
	            System.out.println("Funds successfully transfered.");
	    	  } 
	    	  else 
	    	  {
	    		System.out.println("Insufficient funds");
	    	  }
	       }
	       else
	       {
	    	  if(deposit_money >= withdraw_money)
	    	  {
	            Checking  =  deposit_money-withdraw_money;
		        Saving =  Checking + withdraw_money;
		        System.out.println("FundS Withdrawed from Checking Acccount "+saveacc+" balance is " +Checking);
		        System.out.println("FundS deposited in the Saving Account "+checkacc+" balance is "+Saving);
	            System.out.println("Funds successfully transfered.");
		       } 
	    	   else 
	    	   {
		         System.out.println("Insufficient funds");
		       }
	       }
	    }
	    
	  //Pays utilty bills from the account
	  public void Utility_Bills()
	  {
		int num = 0;
		//Variables for bills
		int Electricity_Bill, Hydro_Bill, Gas_Bill, Maintenence_Bill = 0;
		//Welcome message
		System.out.println("Welcome to the bill payment window!!");
		Scanner sc = new Scanner(System.in);
		//Menu to select the type of the bill for payment
		System.out.println("Select the bill type:");
		System.out.println("1. Electric bill.");
		System.out.println("2. Hydro bill.");
		System.out.println("3. Gas bill.");
		System.out.println("4. Maintenance bill.");
		num = sc.nextInt();
		switch(num)
		{
		case 1:
			System.out.println("Enter the electric bill amount:");
			Electricity_Bill = sc.nextInt();
			if(Current_Balance>=Electricity_Bill)
			{
				Current_Balance = Current_Balance-Electricity_Bill;
				System.out.println("Transaction successful.");
			}
			else
			{
				System.out.println("Insufficient balance.");
			}
			
		case 2:
			System.out.println("Enter the Hydro bill amount:");
			Hydro_Bill = sc.nextInt();
			if(Current_Balance>=Hydro_Bill)
			{
				Current_Balance = Current_Balance - Hydro_Bill;
				System.out.println("Transaction successful.");
			}
			else
			{
				System.out.println("Insufficient balance.");
			}
		case 3:
			System.out.println("Enter the gas bill amount:");
			Gas_Bill = sc.nextInt();
			if(Current_Balance>=Gas_Bill)
			{
				Current_Balance = Current_Balance - Gas_Bill;
				System.out.println("Transaction successful.");
			}
			else
			{
				System.out.println("Insufficient balance.");
			}
		case 4:
			System.out.println("Enter the maintenance bill amount:");
			Maintenence_Bill = sc.nextInt();
			if(Current_Balance>=Maintenence_Bill)
			{
				Current_Balance = Current_Balance-Maintenence_Bill;
				System.out.println("Transaction successful.");
			}
			else
			{
				System.out.println("Insufficient balance.");
			}
			default:
				System.out.println("Enter valid option.");
		}
	}
	
	//Update Details Method to view details from the file and update details
	public void Update_Details() throws IOException
	{
		//Enter the file name
		Scanner Read = new Scanner(System.in);
		System.out.printf("Enter File Name: "+"\t"+"Note: Enter 'Save.txt' or 'Checking.txt'"+"\n");
        String fileName = Read.next();
        int answer;
        String Customer,Mail,Phone,country,postcode,line= " ";
        int choice;
      
        try 
        {
        	File inFile = new File(fileName);
            Scanner in = new Scanner(new File(fileName));
            System.out.println("Correct the File name is "+inFile.getName());
            
            if(inFile!=null)
            {
            	BufferedReader br = new BufferedReader(new FileReader(inFile));
            	String st;
            	  while ((st = br.readLine()) != null)
            	    System.out.println(st+"\n");
            }
         
        } 
        //if filename is incorrect the user cannot view the details from the file
        catch (FileNotFoundException ex) 
        {
          System.out.println(ex.getMessage());  
          
        }    
        //Asks if the user want to update the details
        System.out.println("Do you want to update the details(Click 1 to continue)");
        answer=Read.nextInt();
        
        if(answer!=0)
        {
        
        	Customer=JOptionPane.showInputDialog("Customer Name");	
        	
        	Mail=JOptionPane.showInputDialog("Update Mail Address");
        	
        	Phone=JOptionPane.showInputDialog("Update Phone Number");
        	
        	DOB=JOptionPane.showInputDialog("Update Date of Birth");
        	
        	country=JOptionPane.showInputDialog("Update Country");
        	
        	postcode=JOptionPane.showInputDialog("Update Postal Code");
        	
        	try
        	{
        		/*It will take filename dynamically either savings or checking 
        		 when typed during validation filename.*/
        		File f = new File("Updated"+fileName);
        		FileWriter file = new FileWriter(f); 
       			file.write("Updated Information"+"\n"+"Customer name: "+ Customer +"\n" + "Mail Address: " + Mail+"\n"+ "Contact Info: "+ Phone+"\n"+"Date of Birth: "+ DOB +"\n"+"Country: "+country+"\n"+"Postal Code: "+postcode);
       			file.close();
       		} 
       		catch(IOException e)
       		{
       			 e.printStackTrace();
            }
       		 System.out.println("Saving account created successfully");
        }
           
           else
           	{
    			System.out.println("Successfully updated details in Savings Account");
    		}	
        }
        
	


	/*Bank_Details Method contains switch case which will call all the defined methods*/
	public int Bank_Details() throws IOException 
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);

		do 
		{	
			System.out.println("A To Create new account");
			System.out.println("B.To view Current Balance");
			System.out.println("C.To view Deposit Money");
			System.out.println("D.To view Withdraw Money[5$ Withdrawal Chargess]");
			System.out.println("E.To view Previous Transaction");
			System.out.println("F.To Transfer Money");
			System.out.println("G.To pay utility bill.");
			System.out.println("I.To View and Update Details");
			System.out.println("H.To Exit");
			System.out.println("Enter your option:");
			option = scanner.next().charAt(0);
		
			switch(option)
			{
				case 'A':
					Create_Acc(); //It will call the account to either create savings or checking account
				
				case 'B':
					System.out.println("Current_Balance= " +Current_Balance); //to view current balance of the accounts
					break;
			
				case 'C':
					System.out.println("Deposit Money"); //It will call the deposit money method
					deposit_money = scanner.nextInt();
					Deposit_Money(deposit_money);
					break;
			
				case 'D':
					System.out.println("Withdraw Money"); //It will call the withdraw method to withdraw money
					withdraw_money = scanner.nextInt();
					Withdraw_Money(withdraw_money);
					System.out.println("\n");
					break;
			
				case 'E':
					Transaction(); //To view the previous transaction
					break;
		
				case 'F':
					transfer(withdraw_money); //Transfer method will transfer money within accounts
					break;
	
				case 'G':
					Utility_Bills(); //To pay different bills
					break;
			
				case 'I':
					Update_Details(); // To view and update the account details from the files
					break;
			
				default:
					System.out.println("Thanking you for Banking with us");
					break;
			}
		}
		while(option!= 'H');
		{
			System.out.println("Have a good day!");
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		// Object obj is created.
		JavaProject obj = new JavaProject();
		obj.Bank_Details(); // Bank_Details method is called which contains the switch case.
	}

}
