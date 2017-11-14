package thinkInJava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

public class FileLock_18 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileOutputStream fo = new FileOutputStream("C:/Users/lijianfu/Desktop/hello.cpp");
		FileLock fl = fo.getChannel().tryLock();
		if (fl != null) {
			System.out.println("File is Locked");
			//休眠
			TimeUnit.MILLISECONDS.sleep(1000);
			//解锁
			fl.release();
			System.out.println("Release lock");
		}
		fo.close();
	}

}
