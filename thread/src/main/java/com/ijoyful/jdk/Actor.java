package com.ijoyful.jdk;

public class Actor extends Thread {

	@Override
	public void run() {
		boolean keepRunning = true;
		System.out.println(this.getName() + "开始工作.........");
		
		int count = 0;
		while(keepRunning){
			System.out.println(this.getName()+"工作次数" + (++count));
			
			if(count % 10 == 0){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(count == 100){
				keepRunning = false;
			}
		}
		
		System.out.println(this.getName() + "工作结束.........");
	}

	public static void main(String[] args){
		Thread actor = new Actor();
		actor.setName("Mr.程序员");
		actor.start();
		
		Thread actressThread = new Thread(new Actress(),"Ms.测试人员");
		actressThread.start();
	}
}

class Actress implements Runnable{

	@Override
	public void run() {
		boolean keepRunning = true;
		System.out.println(Thread.currentThread().getName() + "开始工作.........");
		
		int count = 0;
		while(keepRunning){
			System.out.println(Thread.currentThread().getName()+"工作次数" + (++count));
			
			if(count % 10 == 0){
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(count == 100){
				keepRunning = false;
			}
		}
		
		System.out.println(Thread.currentThread().getName() + "工作结束.........");
	}
	
}