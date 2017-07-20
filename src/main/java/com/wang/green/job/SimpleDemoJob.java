package com.wang.green.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

public class SimpleDemoJob implements SimpleJob{

	public void execute(ShardingContext context) {
		
		switch (context.getShardingItem()) {
        case 0: 
        	System.out.println("A");
            // do something by sharding item 0
            break;
        case 1: 
        	System.out.println("B");
            // do something by sharding item 1
            break;
        case 2: 
        	System.out.println("C");
            // do something by sharding item 2
            break;
        // case n: ...
    }
		
	}

}
