# FourSquareCipher
Java [four-square cipher](https://en.wikipedia.org/wiki/Four-square_cipher) encryption program.

A java program that encrypts and decrypts text. The user selects a file or URL resource to be encrypted/decrypted. 
The user has the option of setting the encryption keys. The text is then encrypted and written to file. The encrypted 
text can then be decrypted and written to file.
  

## The Program

The program uses four classes. **Runner**, **Menu**, **Parser** and **FourSquareCipher**.

**Runner** contains the main method and is used to launch the program.

**Menu** provides the user interface:

	---------4-Square-Cipher---------
	Please enter an option (1 to 5).
	(1) Select resource to encrypt.
	(2) Set keys.
	(3) Encrypt.
	(4) Decrypt.
	(5) Quit.

1. Select resource to encrypt: ...User is prompted to choose between a file/URL, then prompted to enter the file/URL name.
2. Set keys: ...(Optional) If the keys aren't set the text is encrypted using the default four-square cipher. When selected the user is prompted to Set Key 1 then Set Key 2. This requires the user to type any variation of the 25 letters (i.e. no j) of the alphabet for key 1 and key 2. e.g. QWERTYUIOPASDFGHKLZXCVBNM and MNBVCXZLKHGFDSAPOIUYTREWQ
3. Encrypt: ...This will encrypt the text to a file called "encrypted.txt".
4. Decrypt: ...This decrypts "encrypted.txt" to a file called "decrypted.txt".
5. Quit: ...Quits the application.
   After each selection bar Quit the user is returned to the main menu.

**Parser** prepares the text for encryption/decryption and writes to the encrypted/decrypted files.

**FourSquareCipher** encrypts/decrypts using the 4-square cipher. FourSquareCipher also sets the keys.




### Running the program from the command line:
Navigate to the directory containing the program files...
	
	>javac *.java
	
	>java Runner 

### Other files:
Matrix.java is a demo class with static methods for testing 2D array operations.

test.txt when encrypted/decrypted is indicative of how text is encrypted/decrypted.

elegy.txt is a larger sample text.
