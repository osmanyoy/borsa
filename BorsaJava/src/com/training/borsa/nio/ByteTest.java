package com.training.borsa.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.channels.FileChannel.MapMode;

public class ByteTest {
	public static void main(String[] args) {
		ByteBuffer allocate = ByteBuffer.allocate(1024);
		ByteBuffer allocate2 = ByteBuffer.allocateDirect(1024);
		int position = allocate.position();
		int limit = allocate.limit();
		int capacity = allocate.capacity();

		allocate.clear();

		allocate.flip();

		byte[] test = new byte[1000];

		ByteBuffer allocate3 = ByteBuffer.wrap(test);
		for (int i = 33; i < 100; i++) {
			allocate2.putChar((char) i);
		}
		allocate2.flip();
		try (FileChannel open = FileChannel.open(Paths.get("test.1000.txt"), StandardOpenOption.CREATE,
		        StandardOpenOption.WRITE);) {
			open.write(allocate2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
