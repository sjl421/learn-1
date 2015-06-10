package com.undergrowth;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

import org.junit.Test;

/**
 * The Java NIO Files class (java.nio.file.Files) provides several methods for
 * manipulating files in the file system.
 * �ļ�������
 *    �½������ļ��� �ٽ��ļ����Ƶ����ļ����� Ȼ����б����ļ��� ������ɺ� ɾ���ļ��м��ļ�
 * @author u1
 * 
 */
public class BasicFiles {

	@Test
	public void test() throws IOException {
		//��ȡ·��
		Path path=Paths.get(".\\test");
		//�ֱ𴴽������ļ��� ��test���� �ֱ�Ϊtest1 ��  test2
		createDir(path);
		//�����ļ�
		copyFiles(path);
		//�����ļ�
		path=Paths.get(".\\test");
		walkFile(path);
	}

	/**
	 * �����ļ�Ŀ¼
	 * @param path
	 * @throws IOException 
	 */
	private void walkFile(Path path) throws IOException {
		// TODO Auto-generated method stub
		Files.walkFileTree(path, new SimpleFileVisitor<Path>(){

			@Override
			public FileVisitResult visitFile(Path file,
					BasicFileAttributes attrs) throws IOException {
				// TODO Auto-generated method stub
				//ɾ���ļ�
				System.out.println("ɾ��"+file.toFile().getAbsolutePath());
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc)
					throws IOException {
				// TODO Auto-generated method stub
				//������Ŀ¼��ɾ��
				System.out.println("������Ŀ¼��ɾ��"+dir.toAbsolutePath());
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
			
		});
	}

	/**
	 * �����ļ�
	 * @param path
	 * @throws IOException 
	 */
	private void copyFiles(Path path) throws IOException {
		// TODO Auto-generated method stub
		Path pathSource =Paths.get("..\\git.txt");
		path=Paths.get(".\\test\\test1\\git.txt");
		//�滻�Ѿ����ڵ��ļ�
		Files.copy(pathSource, path,StandardCopyOption.REPLACE_EXISTING);
		path=Paths.get(".\\test\\test2\\git.txt");
		Files.copy(pathSource, path,StandardCopyOption.REPLACE_EXISTING);
	}

	/**
	 * �����ļ���
	 * @param path
	 * @throws IOException
	 */
	private void createDir(Path path) throws IOException {
		// TODO Auto-generated method stub
		if(!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
			Files.createDirectories(path);
		path=Paths.get(path.toString(), "test1");
		if(!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
			Files.createDirectories(path);
		path=Paths.get(path.toString(), "..\\test2");
		if(!Files.exists(path, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}))
			Files.createDirectories(path);
	}

	
}
