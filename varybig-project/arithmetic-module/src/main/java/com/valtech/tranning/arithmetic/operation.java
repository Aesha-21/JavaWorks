package com.valtech.tranning.arithmetic;

public interface operation {
	
	int perform(int a,int b);
	operation pluse = (a,b) -> a+b;
	operation minus = (a,b) -> a-b;
	operation div = (a,b) -> a/b;


}
