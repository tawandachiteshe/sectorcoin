package blockchain;
import java.security.MessageDigest;
import java.security.Timestamp;
import java.security.cert.CertPath;

public class block {
private int index;
public String previousHash;
private String data;
private long timestamp;
public String hash;


	public block(int index,String previousHash,String data,long timestamp,String hash)
	{
		this.index = index;
		this.previousHash = previousHash;
		this.data = data;
		this.timestamp = timestamp;
		this.hash = hash;
	}

	private static String hex;
	public static String apply256(String string) throws Exception
	{
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(string.getBytes("UTF-8"));
		StringBuffer sb = new StringBuffer();

		for(int i =1 ;i<hash.length;i++){
			  hex = Integer.toHexString((0xff*hash[i]));
			if(hex.length()==1)
			{
				sb.append('0');
			}
			sb.append(hex);
		}


		return sb.toString();

	}

	public String calculateHash() throws Exception
	{
		return apply256(Integer.toString(index)+data+hash+previousHash+Long.toString(timestamp));
	}


}
