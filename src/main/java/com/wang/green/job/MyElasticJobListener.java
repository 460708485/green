package com.wang.green.job;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;

public class MyElasticJobListener implements ElasticJobListener{

	public void beforeJobExecuted(ShardingContexts shardingContexts) {
		
		System.out.println("之前运行");
		
		
	}

	public void afterJobExecuted(ShardingContexts shardingContexts) {
		
		System.out.println("之后运行");
		
	}
	
	

}
