package blockchain;

import java.util.LinkedList;
import java.util.Date;

public class blockchain {


	private LinkedList<block> chain = new LinkedList<>();


	public block createGenesisBlock() throws Exception
	{
		 Date date = new Date();

		return new block(0,"genesisBlock","firstCoin",date.getTime(),block.apply256("genesis").toString());
	}

	public void addBlock(block Block) throws Exception
	{
		chain.add(createGenesisBlock());
		Block.hash = Block.calculateHash();
		Block.previousHash = getLatestBlock().hash;
		chain.push(Block);

	}
	public block getLatestBlock()
	{
		return chain.getLast();
	}

	public boolean IsValid() throws Exception
	{
		boolean isValid = false;
		for (int i = 1;i<chain.size();i++) {
			block currentBlock = chain.get(i);
			block previousBlock = chain.get(i-1);

			if(!currentBlock.previousHash.equals(currentBlock.calculateHash()))
					{
				return isValid;
					}
			else if(!currentBlock.previousHash.equals(previousBlock.previousHash))
			{
				return isValid;
			}else
			{
				return isValid=true;
			}
		}
		return isValid;


	}



}
