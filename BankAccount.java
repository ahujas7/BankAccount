import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class BankAccount 
{

    private final int LOGIN_LENGTH = 5;
    final int NUM_DIGITS = 9;

    private int acctNum;
	private double balance;
	private String fName;
	private String lName;
	private String pswd;
	public String log;
	private int rows = 1;

    BankAccount() 
    {
		acctNum = genAcctNum(LOGIN_LENGTH);

		balance = 0;
 
		fName = "";
		lName = "";

		pswd = genPswd(LOGIN_LENGTH);

		log = "";
	}

    BankAccount (String fName, String lName) 
    {
		acctNum = genAcctNum(LOGIN_LENGTH);

		balance = 0;

		this.fName = fName;
		this.lName = lName;

		pswd = genPswd(LOGIN_LENGTH);

		log = "";
	} 

    boolean deposit (double amount) 
    {
        if (amount > 0) 
        {
			balance += amount; 

            log += ("\n" + genTimestamp() + " Deposit Successful: " + "$" + amount + "."); 
            rows++;

			return true;
		}
        else 	
            return false;
	}

    boolean withdraw (double amount) 
    {
        if (balance >= amount && amount > 0) 
        {
			balance -= amount;

            log += ("\n" + genTimestamp() + " Withdrawal Successful: " + "$" + amount + "."); 
            rows++;

			return true;
		}
        else 
            return false;
	} 

    boolean transferTo (double amount, BankAccount acc) 
    {
        if (balance >= amount && amount > 0) 
        {
			acc.balance += amount;
			balance -= amount;

            log += ("\n" + genTimestamp() + " Transfer: " + "$" + amount + " to account " + acc.acctNum + "."); 
            rows++;
            
            acc.log += ("\n" + genTimestamp() + " Transfer: " + "$" + amount + " recieved from account " + acctNum + "."); 
            acc.rows++;

			return true;
		}
        else 
        {
            log += ("\n" + genTimestamp() + " Transfer Failed: " + "$" + amount + " to account " + acc.acctNum + "."); 
            rows++;

			return false;
		}
	}

    boolean checkPswd (String pswd) 
    {
		return this.pswd.equals(pswd);
	}

    boolean resetPswd (String currentPswd, String newPswd) 
    {
        if (currentPswd.equals(pswd)) 
        {
			pswd = newPswd;

            log += ("\n" + genTimestamp() + " Password Successfully Changed!"); 
            rows++;

			return true;
		}
        else 
        {
            log += ("\n" + genTimestamp() + " Reset Password Failed!"); 
            rows++;

			return false;
		}
	}

    void setFName (String firstName) 
    {
		fName = firstName;
    }
    
    void setLName (String lastName) 
    {
		lName = lastName;
	}

    double getBalance() 
    { 
        return balance; 
    }

    int getAcctNum() 
    {	
        return acctNum;	
    }

    String getFName() 
    {	
        return fName;	
    }

    String getLName() 
    { 
        return lName;	
    }

    String getPswd() 
    { 
        return pswd; 	
    }

    String getLog() 
    { 	
        return log;
    }

    int getRows() 
    { 
        return rows; 
	}

    int genAcctNum (int length) 
    { 
		String acNum = "";

		Random gen = new Random();

		for (int x = 0; x < length; x++) {

			int num = gen.nextInt(NUM_DIGITS);

			acNum += num;

			int n = Integer.parseInt(acNum);

            if (n == 0)  
            {
                length++;
                continue;
            } 

		}

		acctNum = Integer.parseInt(acNum);

		return acctNum;
	}

    private String genPswd (int length) 
    {
		pswd = "";

        String[] strArray = { "a", "b", "c", "d", "e", "f", 
                              "g", "h", "i", "j", "k", "l", 
                              "m", "n", "o", "p", "q", "r",
                              "s", "t", "u", "v", "w", "x", 
                              "y", "z", "A", "B", "C", "D", 
                              "E", "F", "G", "H", "I", "J",
                              "K", "L", "M", "N", "O", "P", 
                              "Q", "R", "S", "T", "U", "V", 
                              "W", "X", "Y", "Z", "1", "2",
                              "3", "4", "5", "6", "7", "8", 
                              "9", "0" };	

		Random gen = new Random();

        for (int x = 0; x < length; x++) 
        {
			int num = gen.nextInt(strArray.length);

			pswd += strArray[num];
		}

		return pswd;
	}

    public static String genTimestamp()
    {
		LocalDateTime time =  LocalDateTime.now();

		DateTimeFormatter setFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH.mm.ss");

		String timeStamp = time.format(setFormat);

		return timeStamp;
	}

    void display() 
    {
        System.out.println("Account Number: " + acctNum +
                           "\nBalance: " + balance +
                           "\nFirst Name: " + fName +
                           "\nLast Name: " + lName +
                           "\nPassword: " + pswd + log);
	}
}