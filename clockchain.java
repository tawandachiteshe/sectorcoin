package blockchain;

import java.util.Date;

public class clockchain {



	public static void main(String[] args) throws Exception {
		blockchain chain =new blockchain();
		chain.createGenesisBlock();
		Date date = new Date();
		block Block1 = new block(1,chain.getLatestBlock().hash,chain.getLatestBlock().hash,date.getTime(),chain.createGenesisBlock().calculateHash());
		chain.addBlock(Block1);


	}

}
