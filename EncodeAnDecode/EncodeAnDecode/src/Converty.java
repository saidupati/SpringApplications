import java.util.Base64;

public class Converty {
public String base64Encoder(String data)
{
	//TransForm data into another format 
	//used for transmitting data for usability
	//eg : Base64
	//Encryption  :  keeping data safe
	//uses a key(symmetric/asymmetric)
	//eg: AES/RSA
	//basically doing encripting network trafic using specific algoridhms
	//Encrption is specific uniqueness
	//Hashing : way of validating integrating and validation
	//when you just want to verify but dont want to store data
	
	String s=Base64.getEncoder().encodeToString(data.getBytes());
	return s;
}
public String base64Decoder(String data)
{
	byte[] b=Base64.getDecoder().decode(data);
	String str=new String(b);
	return str;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Converty c=new Converty();
		String str1=c.base64Encoder("rani123");
		System.out.println("Encoded data : "+ str1);
		String str2=c.base64Decoder(str1);
		System.out.println("Decoded data : "+ str2);
	}

}
